-- Table of Application Users
-- email address is userName -- RFC3696 and RFC5321 indicate 254 characters plus 2 angle
-- SHA-512, Hex encoded in the application = 128 characters
-- If this is an Employee it must have an accounting code description VARCHAR(254),

BEGIN;
CREATE TABLE IF NOT EXISTS usr (
  id              SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  nme            VARCHAR(254)                                            NOT NULL,
  pswd           VARCHAR(88)                                            NOT NULL,


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
INSERT INTO usr (nme, pswd, enabled) VALUES ('systemaction@mold', 'sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==', FALSE);
INSERT INTO usr (nme, pswd) VALUES ('dennis@mold', 'sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==');

