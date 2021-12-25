package com.ahsanshamim.nfcreader.utils;
import android.os.Build;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import java.security.AlgorithmParameters;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * Usage:
 *
 * String crypto = SimpleCrypto.encrypt(masterpassword, cleartext)
 * ...
 * String cleartext = SimpleCrypto.decrypt(masterpassword, crypto)
 *
 * @author ferenc.hechler
 */
public class SimpleCrypto {
    public static String decrypt(byte[] key, String encryptedBase64) throws Exception {

        byte[] encrypted = android.util.Base64.decode(encryptedBase64, Base64.DEFAULT);
        byte[] result = decrypt(key, encrypted);
        return new String(result);
    }

    private static byte[] encrypt(byte[] key, byte[] clear) throws Exception {

        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        return  cipher.doFinal(clear);
        // base64 encode and return
        // return Base64.encodeToString(enc, Base64.DEFAULT);
        // String[] myStringArray = {"a","b","c"};
    }

    private static byte[] decrypt(byte[] key, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES"); // /ECB/PKCS7Padding", "SC");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

}
