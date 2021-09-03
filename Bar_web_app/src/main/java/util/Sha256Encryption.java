package util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;

public class Sha256Encryption {
    private static final Logger logger = Logger.getLogger(Sha256Encryption.class);

    public static String getSha256(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch (Exception ex) {
            logger.error("Failed to use encryption",ex);
            throw new RuntimeException(ex);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}

