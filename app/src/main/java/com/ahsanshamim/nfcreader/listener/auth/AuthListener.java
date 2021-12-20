package com.ahsanshamim.nfcreader.listener.auth;

import com.ahsanshamim.nfcreader.Models.auth.UserData;

public interface AuthListener {
    void onSuccessfully(UserData userData);
    void onFailure(String message);
}
