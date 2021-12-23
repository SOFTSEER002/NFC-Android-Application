package com.ahsanshamim.nfcreader.Repository;

import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;
import com.ahsanshamim.nfcreader.Models.session.SessionRequest;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.session.SessionListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionRepository {
    String TAG = SessionRepository.class.getSimpleName();
    public SessionListener sessionListener;

    public void verifyUserSession(String headerToken, SessionRequest sessionRequest){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CurrentSessionModel> call = apiInterface.checkCurrentSession("Bearer "+headerToken);
        call.enqueue(new Callback<CurrentSessionModel>() {
            @Override
            public void onResponse(Call<CurrentSessionModel> call, Response<CurrentSessionModel> response) {
                CurrentSessionModel data = response.body();
                Logger.e(TAG + " " + response.body());

                if(data.getResult().getUser()!=null){
                    sessionListener.onSuccessSession(data);
                }else{
                    sessionListener.onFailureSession("User not found.Please login again");
                }
            }
            @Override
            public void onFailure(Call<CurrentSessionModel> call, Throwable t) {
                sessionListener.onFailureSession(t.getMessage());
            }
        });
    }

}
