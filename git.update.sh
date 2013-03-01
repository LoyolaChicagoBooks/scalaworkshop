#!/bin/bash

SHORT_NAME=$1
REPO_URI=$2

mkdir -p examples
pushd examples
if [ -e "$SHORT_NAME" ]; then
   cd $SHORT_NAME
   git pull
else
   rm -rf $SHORT_NAME
   git clone $REPO_URI $SHORT_NAME
fi
popd
