-- Place Holder Table
-- Probably keep all my SqlResultSetMappings && @NamedNativeQuery in this Entity Object 
BEGIN;
CREATE TABLE IF NOT EXISTS aaaaaa (
  id  SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  val INTEGER UNIQUE NOT NULL DEFAULT '1' CHECK (val = 1),

  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created         TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_created     INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL,
  modified        TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_modified    INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL
);
COMMIT;

-- Never delete from this table 
BEGIN;
CREATE RULE aaaaaa_protect AS ON DELETE TO aaaaaa DO INSTEAD NOTHING;
COMMIT;

-- Add single Record
BEGIN;
INSERT INTO aaaaaa (val) VALUES (1);
COMMIT;

