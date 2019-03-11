-- Add btgree_gist Extention
-- May want to use it in certain scenarios or for certain operators but it doesn't outperform standard B-Tree
-- that is standard in PostgreSQL. The <-> "nearest neighbor operator is one place we might use this but we made a
-- design descision not to include PostGis objects in our data structure.
-- More info at http://www.postgresql.org/docs/9.6/static/btree-gist.html 
BEGIN;
CREATE EXTENSION IF NOT EXISTS btree_gist;
COMMIT;

