package mold.security;

import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;

public class HashPasswordPBKDF2WithHmacSHA512 {


    Pbkdf2PasswordHash pbkdfHash;


    public HashPasswordPBKDF2WithHmacSHA512() {
        this.init();
    }

    private void init(){

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parametersMap.put("Pbkdf2PasswordHash.Iterations", "4096");
        parametersMap.put("Pbkdf2PasswordHash.KeySizeBytes", "64");
        parametersMap.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");

        pbkdfHash.initialize(parametersMap);

    }


    public String getHashedText(String text) {
        String hashed = pbkdfHash.generate(text.toCharArray());
        return hashed;
    }


    public boolean isHashedTextMatch(String text, String hashedText) {
        return this.pbkdfHash.verify(text.toCharArray(), hashedText);
    }
}
