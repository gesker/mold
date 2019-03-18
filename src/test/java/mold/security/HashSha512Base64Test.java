package mold.security;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashPasswordSha512Base64Test {


    @Test
    public void testHashSha512Base64() throws Exception {
        HashSha512Base64 hasher = new HashSha512Base64();
        assertEquals(
                "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==", hasher.getHashedText("password"));
    }

    @Test
    public void testHashSha512Base64Verify() throws Exception {
        HashSha512Base64 hasher = new HashSha512Base64();
        assertEquals(true, hasher.isHashedTextMatch("password", "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg=="));
    }



}
