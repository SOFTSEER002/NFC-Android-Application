package com.ahsanshamim.nfcreader.listener.encrypt;

import com.ahsanshamim.nfcreader.Models.encrypt.EncryptResponse;

public interface EncryptListener
{
      void onSuccessEncrypt(EncryptResponse encryptResponse);
      void onFailureEncrypt(String message);

}
