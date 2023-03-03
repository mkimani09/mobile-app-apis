//package com.faidihr.mobile.app.api.util;
//
//import at.favre.lib.crypto.bcrypt.BCrypt;
//
//import java.nio.charset.StandardCharsets;
//
//public class PasswordDecryption {
//
//public static boolean verifyPassword(String requestPassword, String hashDbPassword) {
//    BCrypt.Result result = BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
//            .verifyStrict(requestPassword.getBytes(StandardCharsets.UTF_8), hashDbPassword.getBytes(StandardCharsets.UTF_8));
//    return result.verified;
//}
//}
