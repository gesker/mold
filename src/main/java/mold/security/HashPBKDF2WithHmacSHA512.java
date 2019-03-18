package mold.security;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;

public class HashPBKDF2WithHmacSHA512 {


    @Inject
    private Pbkdf2PasswordHash pbkdfHash;


    public HashPBKDF2WithHmacSHA512() {
        this.init();
    }

    private void init() {

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parametersMap.put("Pbkdf2PasswordHash.Iterations", "4096");
        parametersMap.put("Pbkdf2PasswordHash.KeySizeBytes", "64");
        parametersMap.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        pbkdfHash.initialize(parametersMap);

    }


    public String getHashedText(String plainText) {
        String hashed = pbkdfHash.generate(plainText.toCharArray());
        return hashed;
    }


    public boolean isHashedTextMatch(String plainText, String hashedText) {
        return this.pbkdfHash.verify(plainText.toCharArray(), hashedText);
    }
}
