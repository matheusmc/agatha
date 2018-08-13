#!/bin/sh

set -e

# Perform all actions as $POSTGRES_USER
export PGUSER="postgres"

psql <<- 'EOSQL'
CREATE USER gestaoriscos WITH PASSWORD "Mo680A94dS2RvHmUDA8x";
create schema gestaoriscos;
alter user gestaoriscos set search_path=gestaoriscos,public;
alter default privileges in schema gestaoriscos grant select, update, insert, delete on tables to gestaoriscos;
alter default privileges in schema gestaoriscos grant select, usage on sequences to gestaoriscos;

EOSQL

