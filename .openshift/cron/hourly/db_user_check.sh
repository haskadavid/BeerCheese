#!/bin/sh
mysql --host=${OPENSHIFT_MYSQL_DB_HOST} --port=${OPENSHIFT_MYSQL_DB_PORT} --user=${OPENSHIFT_MYSQL_DB_USERNAME} --password=${OPENSHIFT_MYSQL_DB_PASSWORD} beer < ${OPENSHIFT_DATA_DIR}db_user_check
