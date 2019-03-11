-- Codes to Support Login/Logout Activity Records 
BEGIN;
CREATE TABLE IF NOT EXISTS login_code (
  id          SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  nme        VARCHAR(20) UNIQUE NOT NULL,
  description VARCHAR(30) UNIQUE NOT NULL,
  
  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created     TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  modified    TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);
COMMIT;


BEGIN;
INSERT INTO login_code (nme, description) VALUES ('success', 'valid username and password');
INSERT INTO login_code (nme, description) VALUES ('fail disabled', 'account disabled');
INSERT INTO login_code (nme, description) VALUES ('fail password', 'bad password');
INSERT INTO login_code (nme, description) VALUES ('fail username', 'bad username');
INSERT INTO login_code (nme, description) VALUES ('logout', 'logout');
INSERT INTO login_code (nme, description) VALUES ('timeout', 'timeout');
COMMIT;

-- Never delete from this table 
BEGIN;
CREATE RULE login_code_protect AS ON DELETE TO login_code DO INSTEAD NOTHING;
COMMIT;

