-- Create user and database (run by superuser)
CREATE USER travel_journal_user WITH PASSWORD 'travel_journal';

CREATE DATABASE travel_journal_db
OWNER travel_journal_user;

-- Create schema and grant permissions (run by travel_journal_user)
CREATE SCHEMA travel_journal_schema;
GRANT ALL PRIVILEGES ON SCHEMA travel_journal_schema TO travel_journal_user;