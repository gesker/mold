package mold.security;

import org.junit.Ignore;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class HashPasswordPBKDF2WithHmacSHA512Test {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    @Test
    public void testHashPBKDF2WithHmacSHA512() throws Exception {
        HashPBKDF2WithHmacSHA512 hasher = new HashPBKDF2WithHmacSHA512();
        assertEquals(
                "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==", hasher.getHashedText("password"));
    }

    @Test
    public void testHashPBKDF2WithHmacSHA512Verify() throws Exception {
        HashPBKDF2WithHmacSHA512 hasher = new HashPBKDF2WithHmacSHA512();
        assertEquals(true, hasher.isHashedTextMatch("password", "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg=="));
    }


}
