package mold.security;

import org.junit.Test;

import mold.security.PbkdfGenerator;

import static org.junit.Assert.assertEquals;

public class PbkdfGeneratorTest {



    @Test
    public void pbkdfGeneratorTest() throws Exception {
    	PbkdfGenerator h = new PbkdfGenerator();
    	System.out.println(h.getHashedText("password"));
        assertEquals(
                "sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==", h.getHashedText("password"));
    }




}
