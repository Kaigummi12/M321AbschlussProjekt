package com.example.user_service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordUtil {
    private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public static String hashPassword(String password) {
        return bcrypt.encode(password);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return bcrypt.matches(password, hashedPassword);
    }
}
