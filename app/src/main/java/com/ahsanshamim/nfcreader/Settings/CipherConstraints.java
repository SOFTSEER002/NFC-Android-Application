package com.ahsanshamim.nfcreader.Settings;

import java.security.SecureRandom;

public class CipherConstraints {
    public static final int ITERATION_COUNT = 1000;
    public static final int KEY_LENGTH = 256;
    public static final String PBKDF2_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA1";
    public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final int PKCS5_SALT_LENGTH = 32;
    public static final String DELIMITER = "]";
    public static final SecureRandom random = new SecureRandom();
}
