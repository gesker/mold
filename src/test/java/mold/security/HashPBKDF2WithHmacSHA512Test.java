package mold.security;

import org.junit.Ignore;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@Ignore
public class HashPBKDF2WithHmacSHA512Test {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    @Test
    public void testHashPBKDF2WithHmacSHA512() {
        HashPBKDF2WithHmacSHA512 hasher = new HashPBKDF2WithHmacSHA512();
        assertEquals(
                "PBKDF2WithHmacSHA512:4096:8QX3ISYb8tGfRHxJfCSMY3aqJG8lXTAHOeDTa7I31Gr9BNPRqRpdd03ouAaTQCdGFBw8VYclZFHvhRJkEIHlPw==:1LXyLSEnoHRdU6i4MrJZ9h55jQPBz83zrD6pc6czH7g=".length(), hasher.getHashedText("password").length());
    }

    @Test
    public void testHashPBKDF2WithHmacSHA512Verify() {
        HashPBKDF2WithHmacSHA512 hasher = new HashPBKDF2WithHmacSHA512();
        assertEquals(true, hasher.isHashedTextMatch("password", "PBKDF2WithHmacSHA512:4096:8QX3ISYb8tGfRHxJfCSMY3aqJG8lXTAHOeDTa7I31Gr9BNPRqRpdd03ouAaTQCdGFBw8VYclZFHvhRJkEIHlPw==:1LXyLSEnoHRdU6i4MrJZ9h55jQPBz83zrD6pc6czH7g="));
    }


}
