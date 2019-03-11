-- Add pgcrypto Extention
-- Needed for SHA512 
BEGIN;
CREATE EXTENSION IF NOT EXISTS pgcrypto;
COMMIT;

