package com.ahsanshamim.nfcreader.Repository;

import com.ahsanshamim.nfcreader.Models.ErrorModel;
import com.ahsanshamim.nfcreader.Models.IsTenantAvailable;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.SimpleLogin;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.auth.AuthListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private String TAG = AuthRepository.class.getSimpleName();
    public AuthListener authListener;

    /**
     * Login user
     * @param simpleLogin
     * @param tenId
     */
    public void loginUser(SimpleLogin simpleLogin, int tenId) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<UserData> call = apiInterface.loginUser(tenId, simpleLogin);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                Logger.e(TAG + " " + response);
                // if(response.isSuccessful()){
                UserData data = response.body();
                if (data!=null) {
                    if (data.getSuccess()) {
                        authListener.onSuccessfully(data);
                    } else {
                        ErrorModel errorModel = data.getError();
                        authListener.onFailure(errorModel.getMessage());
                    }
                }else{
                    authListener.onFailure("Invalid user name or password");
                }
            }
            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                authListener.onFailure(t.getMessage());
            }
        });
    }
}
