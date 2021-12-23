package com.ahsanshamim.nfcreader.listener.user;

import com.ahsanshamim.nfcreader.Models.user.UserDetailsResponse;

public interface UserDetailsListener {
    public void onSuccessUserDetails(UserDetailsResponse userDetailsResponse);
    public void onFailureUserDetails(String message);
}
