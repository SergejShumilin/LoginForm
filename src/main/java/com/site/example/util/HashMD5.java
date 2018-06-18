package com.site.example.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashMD5 {
    public static String getHash(String password) {
        StringBuilder sb;
        try {
            byte[] data = MessageDigest.getInstance("HashMD5").digest(password.getBytes("UTF-8"));
            sb = new StringBuilder();
            for (byte aData : data) {
                sb.append(Integer.toHexString((aData & 0xFF) | 0x100).substring(1, 3));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
