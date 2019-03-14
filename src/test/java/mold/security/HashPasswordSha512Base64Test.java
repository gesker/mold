package mold.security;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashPasswordSha512Base64Test {


    @Test
    public void testGetPaswdHash512Base64Dennis() throws Exception {
        HashPasswordSha512Base64 hp = new HashPasswordSha512Base64("password");
        assertEquals(
                "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==", hp.getSha512Base64PaddedPasswordHash());
    }


}
