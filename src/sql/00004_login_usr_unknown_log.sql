-- Table to keep a record of login attempts where there is no record of the user in our system 
BEGIN;
CREATE TABLE IF NOT EXISTS login_usr_unknown_log (
  id            SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  login_code_id INTEGER REFERENCES login_code (id) ON UPDATE CASCADE,
  usr           VARCHAR(254),
  pswd          VARCHAR(254),
  ip_address    VARCHAR(45),


  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created         TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_created     INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL,
  modified        TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_modified    INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL
);
COMMIT;

-- Never delete from this table 
BEGIN;
CREATE RULE login_usr_unknown_log AS ON DELETE TO login_usr_unknown_log DO INSTEAD NOTHING;
COMMIT;

