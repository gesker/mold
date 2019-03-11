
-- 00010 Association & Map Tables 
BEGIN;
DROP VIEW IF EXISTS usr_rle_map_view;
DROP TABLE IF EXISTS usr_rle_map;
COMMIT;

-- 00009 Many to Many
-- BEGIN;
-- COMMIT;

-- 00008 TBD
-- BEGIN;
-- COMMIT;

-- 00007 TBD
-- BEGIN;
-- COMMIT;

-- 00006 Business Level Organization Tables 
-- BEGIN;
-- COMMIT;

-- 00005 GIS Data
-- BEGIN;
-- DROP TABLE IF EXISTS facility;
-- DROP TABLE IF EXISTS area;
-- COMMIT;

-- 00004 User Access Logging/Tracking -- Depend Upon Top Level Tables and/or Reference Tables 
BEGIN;
DROP TABLE IF EXISTS login_usr_unknown_log;
DROP TABLE IF EXISTS login_usr_known_log;
 COMMIT;

-- 00003 Top Level Tables i.e. Do Not Reference Any other Table 
BEGIN;
DROP TABLE IF EXISTS rle;
DROP TABLE IF EXISTS aaaaaa;
COMMIT;

-- 00002 Views Dependant on Reference Tables 
BEGIN;
DROP TABLE IF EXISTS usr;
COMMIT;

-- 00001 Reference Tables That Rarely (If Ever) Change 
BEGIN;
DROP TABLE IF EXISTS login_code;
COMMIT;



-- 00000 Database Setup
BEGIN;
-- DROP EXTENSION IF EXISTS mysql_fdw;
-- DROP EXTENSION IF EXISTS "uuid-ossp";
-- DROP EXTENSION IF EXISTS postgis_tiger_geocoder;
-- DROP EXTENSION IF EXISTS address_standardizer_data_us;
-- DROP EXTENSION IF EXISTS address_standardizer;
-- DROP EXTENSION IF EXISTS fuzzystrmatch;
-- DROP EXTENSION IF EXISTS postgis_topology;
-- DROP EXTENSION IF EXISTS postgis;
-- DROP EXTENSION IF EXISTS pgcrypto;
-- DROP EXTENSION IF EXISTS btree_gist;
COMMIT;

