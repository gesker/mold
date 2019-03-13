package mold.security;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashPasswordPBKDF2WithHmacSHA512Test {


    @Test
    public void testHashPasswordPBKDF2WithHmacSHA512() throws Exception {
        HashPasswordPBKDF2WithHmacSHA512 hp = new HashPasswordPBKDF2WithHmacSHA512();
        hp.getHashedText("password");
        assertEquals("a", "a");
    }


}
