package com.ahsanshamim.nfcreader.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahsanshamim.nfcreader.Activities.WriteActivity;
import com.ahsanshamim.nfcreader.Models.ItemInfo;
import com.ahsanshamim.nfcreader.Models.Items;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Settings.CipherConstraints;
import com.ahsanshamim.nfcreader.Settings.EncryptDecrypt;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class productsrecyclerviewadptr extends RecyclerView.Adapter<productsrecyclerviewadptr.MyViewHolder> {
    private Context context;
    private ItemInfo[] itemInfos;

    public productsrecyclerviewadptr(Context context, ItemInfo[] itemInfos) {
        this.itemInfos = itemInfos;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rc_itemview, parent, false);
        this.context = view.getContext();
        return new productsrecyclerviewadptr.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(productsrecyclerviewadptr.MyViewHolder holder, int position) {
        ItemInfo info = itemInfos[position];
        Items item = info.items;
        holder.itemid.setText(String.valueOf(position +1));
        holder.itemname.setText(item.name);
        holder.itemprice.setText(String.valueOf(item.price));
        holder.itemquantity.setText(String.valueOf(item.quantity));
        holder.itemdesc.setText(item.description);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WriteActivity.class);
                String encryttag = encrypt(info._id.$oid, info.decryption_key);
                intent.putExtra("nfc_tag", encryttag);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemInfos.length;
    }

    public static String encrypt(String plaintext, String password) {
        byte[] salt  = EncryptDecrypt.generateSalt();
        SecretKey key = EncryptDecrypt.deriveKey(password, salt);

        try {
            Cipher cipher = Cipher.getInstance(CipherConstraints.CIPHER_ALGORITHM);
            byte[] iv = EncryptDecrypt.generateIv(cipher.getBlockSize());
            IvParameterSpec ivParams = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParams);
            byte[] cipherText = cipher.doFinal(plaintext.getBytes("UTF-8"));

            if(salt != null) {
                return String.format("%s%s%s%s%s",
                        EncryptDecrypt.toBase64(salt),
                        CipherConstraints.DELIMITER,
                        EncryptDecrypt.toBase64(iv),
                        CipherConstraints.DELIMITER,
                        EncryptDecrypt.toBase64(cipherText));
            }

            return String.format("%s%s%s",
                    EncryptDecrypt.toBase64(iv),
                    CipherConstraints.DELIMITER,
                    EncryptDecrypt.toBase64(cipherText));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemid, itemname, itemprice, itemquantity, itemdesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemid = (TextView) itemView.findViewById(R.id.itemid);
            itemname = (TextView) itemView.findViewById(R.id.itemname);
            itemprice = (TextView) itemView.findViewById(R.id.itemprice);
            itemquantity = (TextView) itemView.findViewById(R.id.itemquantity);
            itemdesc = (TextView) itemView.findViewById(R.id.itemdesc);

        }
    }
}
