package com.example.user_service.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Service
public class MD5HashingService {
    public String stringToMD5(String text) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("MD5");
        final byte[] encodedHash = digest.digest(text.getBytes());
        final String hash = HexFormat.of().formatHex(encodedHash);
        return hash;

    }
}
