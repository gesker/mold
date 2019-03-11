-- Add UUID Extention
-- Needed for pgsql to generate UUIDs
-- Probably just use function uuid_generate_v4() 
-- But UUID is also a data type so we may need to extend a class if we choose to generate UUIDs in Java
BEGIN;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
COMMIT;

