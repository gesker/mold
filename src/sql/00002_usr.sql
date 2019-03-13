-- Table of Application Users
-- email address is userName -- RFC3696 and RFC5321 indicate 254 characters plus 2 angle
-- SHA-512, Hex 64 Bit encoded in the application = 88 characters


BEGIN;
CREATE TABLE IF NOT EXISTS usr (
  id              SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  nme            VARCHAR(254)                                            NOT NULL,
  pswd           VARCHAR(254)                                            NOT NULL,


  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created         TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_created     INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL,
  modified        TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_modified    INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL

);
COMMIT;


-- Never delete from this table
BEGIN;
CREATE RULE usr_protect AS ON DELETE TO usr DO INSTEAD NOTHING;
COMMIT;

-- Add Sample Users SHA-512 Hex
INSERT INTO usr (nme, pswd, enabled) VALUES ('systemaction@mold', 'PBKDF2WithHmacSHA512:4096:8QX3ISYb8tGfRHxJfCSMY3aqJG8lXTAHOeDTa7I31Gr9BNPRqRpdd03ouAaTQCdGFBw8VYclZFHvhRJkEIHlPw==:1LXyLSEnoHRdU6i4MrJZ9h55jQPBz83zrD6pc6czH7g=', FALSE);
INSERT INTO usr (nme, pswd) VALUES ('dennis@mold', 'PBKDF2WithHmacSHA512:4096:8QX3ISYb8tGfRHxJfCSMY3aqJG8lXTAHOeDTa7I31Gr9BNPRqRpdd03ouAaTQCdGFBw8VYclZFHvhRJkEIHlPw==:1LXyLSEnoHRdU6i4MrJZ9h55jQPBz83zrD6pc6czH7g=');

