package com.ahsanshamim.nfcreader.Settings;

import android.util.Base64;

import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {
    public static byte[] generateSalt() {
        byte[] b = new byte[CipherConstraints.PKCS5_SALT_LENGTH];
        CipherConstraints.random.nextBytes(b);
        return b;
    }

    public static byte[] generateIv(int length) {
        byte[] b = new byte[length];
        CipherConstraints.random.nextBytes(b);
        return b;
    }

    public static SecretKey deriveKey(String password, byte[] salt) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, CipherConstraints.ITERATION_COUNT, CipherConstraints.KEY_LENGTH);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(CipherConstraints.PBKDF2_DERIVATION_ALGORITHM);
            byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();
            return new SecretKeySpec(keyBytes, "AES");
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toBase64(byte[] bytes) {
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }

    public static byte[] fromBase64(String base64) {
        return Base64.decode(base64, Base64.NO_WRAP);
    }
}
