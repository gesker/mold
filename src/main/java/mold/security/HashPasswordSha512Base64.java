package mold.security;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class HashPasswordSha512Base64 {
    byte[] plainTextPasswordBytes;
    byte[] sha512PasswordHash;
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private String plainTextPassword;
    private String hashedSha512Password;

    public HashPasswordSha512Base64(String plainTextPassword) {
        this.plainTextPassword = plainTextPassword;
    }


    public String getSha512Base64PaddedPasswordHash() {
        MessageDigest md;


        logger.warning("Remove this logging in PRRODUCTION");
        logger.warning("Password in PlainText:" + plainTextPassword);

        try {
            md = MessageDigest.getInstance("SHA-512");
            plainTextPasswordBytes = plainTextPassword.getBytes();
            sha512PasswordHash = md.digest(plainTextPasswordBytes);
            hashedSha512Password = DatatypeConverter.printBase64Binary(sha512PasswordHash);
            logger.info("SHA512 Hash Base64 Encoded:" + sha512PasswordHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedSha512Password;
    }
}
