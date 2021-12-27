package com.ahsanshamim.nfcreader.Repository.candidate;

import com.ahsanshamim.nfcreader.Models.candidate.CandidateResponse;
import com.ahsanshamim.nfcreader.Models.items.ItemResponse;
import com.ahsanshamim.nfcreader.Repository.item.ItemRepository;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIClient;
import com.ahsanshamim.nfcreader.RetrofitAPI.APIInterface;
import com.ahsanshamim.nfcreader.listener.candidate.CandidateListener;
import com.ahsanshamim.nfcreader.listener.item.ItemListener;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidateRepository {

    String TAG = CandidateRepository.class.getSimpleName();
    public CandidateListener candidateListener;

    public void getAllCandidates(String headerToken,int taID){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<CandidateResponse> call = apiInterface.getAllCandidates("Bearer "+headerToken,taID);
        call.enqueue(new Callback<CandidateResponse>() {
            @Override
            public void onResponse(Call<CandidateResponse> call, Response<CandidateResponse> response) {
                CandidateResponse data = response.body();
                Logger.e(TAG + " " + response.body());

                if(data.getResult().getTotalCount()>0){
                    candidateListener.onSuccessCandidate(data);
                }else{
                   candidateListener.onFailureCandidate("No candidates found");
                }
            }
            @Override
            public void onFailure(Call<CandidateResponse> call, Throwable t) {
                candidateListener.onFailureCandidate(t.getMessage());
            }
        });
    }
}
