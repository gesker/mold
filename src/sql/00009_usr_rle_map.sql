-- Map Application Users to Roles 
BEGIN;
CREATE TABLE IF NOT EXISTS usr_rle_map (
  id           SERIAL PRIMARY KEY,
  uid UUID UNIQUE NOT NULL DEFAULT uuid_generate_v4(),
  usr_id       INTEGER REFERENCES usr (id) ON UPDATE CASCADE,
  rle_id       INTEGER REFERENCES rle (id) ON UPDATE CASCADE,
  UNIQUE (usr_id, rle_id),

  enabled         BOOLEAN                  DEFAULT TRUE CHECK (enabled = TRUE OR enabled = FALSE),
  created         TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_created     INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL,
  modified        TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
  usr_modified    INTEGER REFERENCES usr (id) ON UPDATE CASCADE DEFAULT 1 NOT NULL
);
COMMIT;


BEGIN;
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (1, 1);
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (1, 2);
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (1, 3);

INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (2, 1);
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (2, 2);
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (2, 3);
INSERT INTO usr_rle_map (usr_id, rle_id) VALUES (1, 4);
COMMIT;


