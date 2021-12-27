package com.ahsanshamim.nfcreader.Activities.candidate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ahsanshamim.nfcreader.Adapters.candidate.CandidateAdapter;
import com.ahsanshamim.nfcreader.Models.auth.LoginData;
import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.candidate.CandidateResponse;
import com.ahsanshamim.nfcreader.R;
import com.ahsanshamim.nfcreader.Repository.candidate.CandidateRepository;
import com.ahsanshamim.nfcreader.listener.candidate.CandidateListener;
import com.ahsanshamim.nfcreader.utils.CustomLoader;
import com.ahsanshamim.nfcreader.utils.SharePref;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.shashank.sony.fancytoastlib.FancyToast;

public class CandidateListActivity extends AppCompatActivity implements CandidateListener {

    private RecyclerView list_cand;
    private CandidateAdapter candidateAdapter;
    private CandidateRepository candidateRepository;
    private CustomLoader customLoader;
    private SharePref sharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_list);
        setXML();

    }
    private void setXML(){
        sharePref = new SharePref(getApplicationContext());
        candidateRepository = new CandidateRepository();
        candidateRepository.candidateListener = this;

        customLoader = new CustomLoader(CandidateListActivity.this);
        list_cand  =  findViewById(R.id.list_cand);
        LinearLayoutManager layoutManager =  new
            LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        list_cand.setLayoutManager(layoutManager);
        customLoader.showProgressDialog();
        UserData userData = sharePref.getUserLoginData();
        Logger.v(new Gson().toJson(userData));
        LoginData result = userData.getResult();
        candidateRepository.getAllCandidates(result.getToken(),3);
    }

    @Override
    public void onSuccessCandidate(CandidateResponse candidateResponse) {
        customLoader.dismiss();
        candidateAdapter = new CandidateAdapter(candidateResponse.getResult().getItems(),getApplicationContext());
        list_cand.setAdapter(candidateAdapter);
    }

    @Override
    public void onFailureCandidate(String message) {
        customLoader.dismiss();
        FancyToast.makeText(this,message,FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();;
    }
}
