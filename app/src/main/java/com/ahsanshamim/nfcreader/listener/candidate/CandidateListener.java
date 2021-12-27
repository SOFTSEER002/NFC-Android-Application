package com.ahsanshamim.nfcreader.listener.candidate;

import com.ahsanshamim.nfcreader.Models.candidate.CandidateResponse;

public interface CandidateListener {
    void onSuccessCandidate(CandidateResponse candidateResponse);
    void onFailureCandidate(String message);
}
