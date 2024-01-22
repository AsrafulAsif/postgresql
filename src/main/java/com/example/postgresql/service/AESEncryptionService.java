package com.example.postgresql.service;

import org.apache.hc.client5.http.utils.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Service
public class AESEncryptionService {
    private static final String AES_ALGORITHM = "AES";
    private static final String AES_TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static String encryptJson(String jsonData, String secretKey) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(jsonData.getBytes());
        return Base64.encodeBase64String(encryptedBytes);
    }

    public static String decryptJson(String encryptedJson, String secretKey) throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.decodeBase64(encryptedJson));
        return new String(decryptedBytes);
    }
}
