package com.ahsanshamim.nfcreader.Repository.user;

import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;
import com.ahsanshamim.nfcreader.Models.session.SessionRequest;
import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;
import com.ahsanshamim.nfcreader.Repository.SessionRepository;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.session.SessionListener;
import com.ahsanshamim.nfcreader.listener.user.UserDetailsListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsRepository {
    String TAG = UserDetailsRepository.class.getSimpleName();
    public UserDetailsListener userDetailsListener;

    public void verifyUserSession(String headerToken, int id){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<UserDetailsResponse> call = apiInterface.getUserDetails("Bearer "+headerToken,id);
        call.enqueue(new Callback<UserDetailsResponse>() {
            @Override
            public void onResponse(Call<UserDetailsResponse> call, Response<UserDetailsResponse> response) {
                UserDetailsResponse data = response.body();
                Logger.e(TAG + " " + data);

                if(data.getResult()!=null){
                    userDetailsListener.onSuccessUserDetails(data);
                }else{
                    userDetailsListener.onFailureUserDetails("User not found.Please login again");
                }
            }
            @Override
            public void onFailure(Call<UserDetailsResponse> call, Throwable t) {
                userDetailsListener.onFailureUserDetails(t.getMessage());
            }
        });
    }

}
