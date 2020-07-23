#!/usr/bin/env bash
#file: mysql-backups.sh
DIR=`dirname $0`
echo "Backup DB with export script."
$DIR/mysql-backup.sh

echo "Moving exported files into backup dir."
DB_BAK_DIR=$HOME/mysql-backups/`date +%a`
echo "Removing old file (if exists) and saving new backup into $DB_BAK_DIR"
if [[ -e $DB_BAK_DIR ]]; then
  rm -fv $DB_BAK_DIR/*
else
  mkdir -p $DB_BAK_DIR
fi
cp -v $DIR/*.sql $DB_BAK_DIR