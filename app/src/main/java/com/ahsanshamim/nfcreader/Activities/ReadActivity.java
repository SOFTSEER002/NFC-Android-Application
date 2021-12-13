package com.ahsanshamim.nfcreader.Activities;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ahsanshamim.nfcreader.Models.ItemInfo;
import com.ahsanshamim.nfcreader.Models.getproductsInfo;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.Settings.CipherConstraints;
import com.ahsanshamim.nfcreader.Settings.EncryptDecrypt;
import com.ahsanshamim.nfcreader.Settings.getNetworkstate;
import com.bhargavms.dotloader.DotLoader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadActivity extends Activity {
    public static final String TAG = "Read NFC Activity";
    private TextView tvNFCMessage, tvTextNFC;
    private NfcAdapter mNfcAdapter;
    private DotLoader dotloader;
    private ImageView ivBack;
    private Spinner spinner;
    private APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcread);
        initViews();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setSpinner();

    }

    private void initViews() {
        tvNFCMessage = findViewById(R.id.tvNFCMessage);
        tvTextNFC = findViewById(R.id.tvText);
        dotloader = findViewById(R.id.text_dot_loader);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        ivBack = findViewById(R.id.ivBack);
        spinner = (Spinner) findViewById(R.id.key_spinner);
    }

    private void setSpinner(){
        if(getNetworkstate.isNetworkConnected(this) == false){
            Toast.makeText(getApplicationContext(),"Internet Not Connect Please Connect the WIFI!", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        Call<getproductsInfo> call;
        try {
            apiInterface = APIClient.getClient().create(APIInterface.class);
            call = apiInterface.getproducts();

            call.enqueue(new Callback<getproductsInfo>() {
                @Override
                public void onResponse(Call<getproductsInfo> call, Response<getproductsInfo> response) {
                    if(response.isSuccessful()){
                        getproductsInfo info = response.body();
                        if(info.products.length > 0) {
                            ItemInfo[] itemInfo = info.products;
                            ArrayList<String> items = new ArrayList<>();
                            for(ItemInfo item : itemInfo){
                                items.add(item.decryption_key);
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                                    R.layout.spinner_item, items);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(adapter);
                            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    tvTextNFC.setText(R.string.tap_your_str_nfc_tag_on_mobile_to_read);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    tvTextNFC.setText(R.string.str_select_key);
                                }
                            });

                        }
                    }

                }

                @Override
                public void onFailure(Call<getproductsInfo> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "API Server Out of Service.", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "API Server Out of Service.", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        tvNFCMessage.setText(R.string.str_reading);
        dotloader.setVisibility(View.VISIBLE);
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        IntentFilter ndefDetected = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        IntentFilter techDetected = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
        IntentFilter[] nfcIntentFilter = new IntentFilter[]{techDetected, tagDetected, ndefDetected};

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        if (mNfcAdapter != null)
            mNfcAdapter.enableForegroundDispatch(this, pendingIntent, nfcIntentFilter, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        patchTag(tag);
        if (tag != null) {
            readFromNFC(tag, intent);
        }
    }


    public Tag patchTag(Tag oTag) {
        if (oTag == null)
            return null;

        String[] sTechList = oTag.getTechList();

        Parcel oParcel, nParcel;

        oParcel = Parcel.obtain();
        oTag.writeToParcel(oParcel, 0);
        oParcel.setDataPosition(0);

        int len = oParcel.readInt();
        byte[] id = null;
        if (len >= 0) {
            id = new byte[len];
            oParcel.readByteArray(id);
        }
        int[] oTechList = new int[oParcel.readInt()];
        oParcel.readIntArray(oTechList);
        Bundle[] oTechExtras = oParcel.createTypedArray(Bundle.CREATOR);
        int serviceHandle = oParcel.readInt();
        int isMock = oParcel.readInt();
        IBinder tagService;
        if (isMock == 0) {
            tagService = oParcel.readStrongBinder();
        } else {
            tagService = null;
        }
        oParcel.recycle();

        int nfca_idx = -1;
        int mc_idx = -1;

        for (int idx = 0; idx < sTechList.length; idx++) {
            if (sTechList[idx] == NfcA.class.getName()) {
                nfca_idx = idx;
            } else if (sTechList[idx] == MifareClassic.class.getName()) {
                mc_idx = idx;
            }
        }

        if (nfca_idx >= 0 && mc_idx >= 0 && oTechExtras[mc_idx] == null) {
            oTechExtras[mc_idx] = oTechExtras[nfca_idx];
        } else {
            return oTag;
        }

        nParcel = Parcel.obtain();
        nParcel.writeInt(id.length);
        nParcel.writeByteArray(id);
        nParcel.writeInt(oTechList.length);
        nParcel.writeIntArray(oTechList);
        nParcel.writeTypedArray(oTechExtras, 0);
        nParcel.writeInt(serviceHandle);
        nParcel.writeInt(isMock);
        if (isMock == 0) {
            nParcel.writeStrongBinder(tagService);
        }
        nParcel.setDataPosition(0);
        Tag nTag = Tag.CREATOR.createFromParcel(nParcel);
        nParcel.recycle();

        return nTag;
    }

    private void readFromNFC(Tag tag, Intent intent) {
        try {
            Ndef ndef = Ndef.get(tag);
            if (ndef != null) {
                ndef.connect();
                NdefMessage ndefMessage = ndef.getNdefMessage();

                if (ndefMessage != null) {

                    Parcelable[] messages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

                    if (messages != null) {
                        NdefMessage[] ndefMessages = new NdefMessage[messages.length];
                        for (int i = 0; i < messages.length; i++) {
                            ndefMessages[i] = (NdefMessage) messages[i];
                        }
                        NdefRecord record = ndefMessages[0].getRecords()[0];
                        Toast.makeText(getApplicationContext(), new String(record.getId()),Toast.LENGTH_LONG).show();
                        byte[] payload = record.getPayload();
                        String text = new String(payload);

                        String data = decrypt(text, spinner.getSelectedItem().toString());
                        if(!data.toString().equals("")){
                            intent = new Intent(ReadActivity.this,ProductViewActivity.class);
                            intent.putExtra("decrypt", data.toString());
                            this.startActivity(intent);
                        }
                        tvNFCMessage.setText(data);
                        dotloader.setVisibility(View.GONE);
                        Log.e("tag", "vahid  -->  " + text);
                        ndef.close();

                    }

                } else {
                    Toast.makeText(this, "Not able to read from NFC, Please try again...", Toast.LENGTH_LONG).show();

                }
            } else {
                NdefFormatable format = NdefFormatable.get(tag);
                if (format != null) {
                    try {
                        format.connect();
                        NdefMessage ndefMessage = ndef.getNdefMessage();

                        if (ndefMessage != null) {
                            String message = new String(ndefMessage.getRecords()[0].getPayload());
                            Log.d(TAG, "NFC found.. " + "readFromNFC: " + message);
                            String data = decrypt(message, spinner.getSelectedItem().toString());
                            tvNFCMessage.setText(data);
                            ndef.close();
                        } else {
                            Toast.makeText(this, "Not able to read from NFC, Please try again...", Toast.LENGTH_LONG).show();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "NFC is not readable", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String decrypt(String ciphertext, String password) {
        String[] fields = ciphertext.split(CipherConstraints.DELIMITER);
        if(fields.length != 3) {
            throw new IllegalArgumentException("Invalid encypted text format");
        }
        byte[] salt        = EncryptDecrypt.fromBase64(fields[0]);
        byte[] iv          = EncryptDecrypt.fromBase64(fields[1]);
        byte[] cipherBytes = EncryptDecrypt.fromBase64(fields[2]);
        SecretKey key = EncryptDecrypt.deriveKey(password, salt);

        try {
            Cipher cipher = Cipher.getInstance(CipherConstraints.CIPHER_ALGORITHM);
            IvParameterSpec ivParams = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParams);
            byte[] plaintext = cipher.doFinal(cipherBytes);
            return new String(plaintext, "UTF-8");
        } catch (GeneralSecurityException e) {
            Toast.makeText(this, "Unable to Read, Decryption Key Does Not Match. Please try again...", Toast.LENGTH_LONG).show();
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(this, "Unable to Read, Decryption Key Does Not Match. Please try again...", Toast.LENGTH_LONG).show();
            throw new RuntimeException(e);
        }
    }




}