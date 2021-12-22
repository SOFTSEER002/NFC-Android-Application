package com.ahsanshamim.nfcreader.listener.session;

import com.ahsanshamim.nfcreader.Models.auth.UserData;
import com.ahsanshamim.nfcreader.Models.session.CurrentSessionModel;

public interface SessionListener {

    void onSuccessSession(CurrentSessionModel currentSessionModel);
    void onFailureSession(String message);
}
