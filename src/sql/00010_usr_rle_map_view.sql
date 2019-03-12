-- Map Application Users to Roles AS a View --> for use in/by the WildFly Login-Module 
BEGIN;
 CREATE VIEW usr_rle_map_view AS SELECT usr_rle_map.id, usr.nme AS usrNme, usr.pswd AS usrPswd, rle.nme AS rleNme FROM usr_rle_map LEFT JOIN usr ON usr.id = usr_rle_map.usr_id LEFT JOIN rle ON rle.id = usr_rle_map.rle_id;
COMMIT;