package mold.security;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class HashPasswordSha512Base64 {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public HashPasswordSha512Base64() {
    }


    public String getHashedText(String plainText) {
        MessageDigest md = null;
        byte[] sha512Digest;
        String hashedText = null;


        try {
            md = MessageDigest.getInstance("SHA-512");
            sha512Digest = md.digest(plainText.getBytes());
            hashedText = DatatypeConverter.printBase64Binary(sha512Digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedText;
    }





    public boolean isHashedTextMatch(String plainText, String hashedText) {
        if (this.getHashedText(plainText).equals(hashedText)){
            return true;
        }
        return false;
    }
}
