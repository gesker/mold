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
INSERT INTO rle (uid, nme, description) VALUES ('c83f13a7-ff04-4c52-a394-cc4b11f7fb31', 'manager', 'manager');
INSERT INTO rle (uid, nme, description) VALUES ('ccb047bc-fc99-4987-beae-076a87af931c', 'supervisor', 'supervisor');
INSERT INTO rle (uid, nme, description) VALUES ('eba38ffd-5033-4ad5-a671-e2b040a5b96d', 'admin', 'administrative assistant');
INSERT INTO rle (uid, nme, description) VALUES ('6a8575ce-6a8c-49e0-b4ec-7225321d769e', 'inspector', 'inspector');
INSERT INTO rle (uid, nme, description) VALUES ('a17cc320-a137-46e9-8573-5ca859de6d20', 'customer', 'customer');
COMMIT;

