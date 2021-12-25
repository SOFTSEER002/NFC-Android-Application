package com.ahsanshamim.nfcreader.Repository;

import com.ahsanshamim.nfcreader.Models.encrypt.EncryptResponse;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.encrypt.EncryptListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EncryptRespository {
    String TAG = EncryptRespository.class.getSimpleName();
    public EncryptListener encryptListener;

    public void getAllEncyption(String headerToken, int tantId){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<EncryptResponse> call = apiInterface.getAllEncryptionKey("Bearer "+headerToken,tantId);
        call.enqueue(new Callback<EncryptResponse>() {
            @Override
            public void onResponse(Call<EncryptResponse> call, Response<EncryptResponse> response) {
                EncryptResponse data = response.body();
                Logger.e(TAG + " " + response.body());

                if(data.getResult().getTotalCount() > 0 ){
                    encryptListener.onSuccessEncrypt(data);
                }else{
                    encryptListener.onFailureEncrypt("Please contact to admin.No any encryption key found!");
                }
            }
            @Override
            public void onFailure(Call<EncryptResponse> call, Throwable t) {
                encryptListener.onFailureEncrypt(t.getMessage());
            }
        });
    }
}
