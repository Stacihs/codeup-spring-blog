package com.codeup.codeupspringblog.services;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BcryptTest {

    public static void main(String[] args) {
        String password = "";
        String salt1 = BCrypt.gensalt();
        String salt2 = BCrypt.gensalt();
        System.out.println(salt1);
        System.out.println(salt2);
        String hashedPassword1 = BCrypt.hashpw(password, salt1);
        String hashedPassword2 = BCrypt.hashpw(password, salt2);
        System.out.println(hashedPassword1);
        System.out.println(hashedPassword2);
    }
}