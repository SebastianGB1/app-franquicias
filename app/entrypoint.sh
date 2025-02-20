#!/bin/sh
set -e

mvn package


exec java -jar \
    -DDB_NAME="${DB_NAME:-franquicias}" \
    -DDB_HOST="${DB_HOST:-localhost}" \
    -DDB_PORT="${DB_PORT:-3306}" \
    -DDB_USER="${DB_USER:-root}" \
    -DDB_PASSWORD="${DB_PASSWORD}" \
    target/app-franquicias-0.0.1-SNAPSHOT.jar
