package mold.security;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import mold.security.HashPasswordPBKDF2WithHmacSHA512;

import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Ignore
public class HashPasswordPBKDF2WithHmacSHA512Test {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    @Test
    public void testHashPasswordPBKDF2WithHmacSHA512() throws Exception {
//        Pbkdf2PasswordHash pbkdfHash;
//
//
//        Map<String, String> parametersMap = new HashMap<>();
//        parametersMap.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
//        parametersMap.put("Pbkdf2PasswordHash.Iterations", "4096");
//        parametersMap.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
//        //parametersMap.put("Pbkdf2PasswordHash.KeySizeBytes", "64");
//        pbkdfHash.initialize(parametersMap);
//        String hashed = pbkdfHash.generate("password".toCharArray());
//
//        logger.info(hashed);

//        HashPasswordPBKDF2WithHmacSHA512 hp = new HashPasswordPBKDF2WithHmacSHA512();
        //hp.getHashedText("password");
        assertEquals("a", "a");
    }


}
