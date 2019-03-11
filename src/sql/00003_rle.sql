-- Table of Application Roles 
BEGIN;
CREATE TABLE IF NOT EXISTS rle (
  id          SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  nme        VARCHAR(10) UNIQUE NOT NULL,
  description VARCHAR(30) UNIQUE NOT NULL,


  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created         TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_created     INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL,
  modified        TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_modified    INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL
);
COMMIT;


-- Never delete from this table
BEGIN;
CREATE RULE rle_protect AS ON DELETE TO rle DO INSTEAD NOTHING;
COMMIT;

-- Add Records
BEGIN;
INSERT INTO rle (uid, nme, description) VALUES ('0f911afb-c925-4580-b334-38e8c9d012b6', 'root', 'root aka system administrator');
INSERT INTO rle (uid, nme, description) VALUES ('59389632-5250-4ee9-8ec3-faf2eaa9572a', 'financial', 'financial department');
INSERT INTO rle (uid, nme, description) VALUES ('a17cc320-a137-46e9-8573-5ca859de6d20', 'customer', 'customer');
COMMIT;

