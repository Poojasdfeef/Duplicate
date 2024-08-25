-- MySQL example to check schema
SHOW CREATE TABLE table_name;

-- PostgreSQL example to check schema
SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'table_name';
