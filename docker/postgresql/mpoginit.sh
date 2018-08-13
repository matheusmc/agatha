#!/bin/sh

set -e

# Perform all actions as $POSTGRES_USER
export PGUSER="postgres"

# Create the 'template_postgis' template db
psql <<- 'EOSQL'
CREATE DATABASE mpog;
EOSQL

psql --dbname="mpog" <<- 'EOSQL'
CREATE USER gestaoriscos WITH PASSWORD 'gestaoriscos';
CREATE SCHEMA IF NOT EXISTS gestaoriscos AUTHORIZATION gestaoriscos;

CREATE SCHEMA IF NOT EXISTS aud_gestaoriscos AUTHORIZATION gestaoriscos;
ALTER USER gestaoriscos SET search_path=gestaoriscos,aud_gestaoriscos,public;
EOSQL
