#!/bin/bash

SHORT_NAME=$1
REPO_URI=$2

mkdir -p examples
pushd examples
if [ -e "$SHORT_NAME" ]; then
   cd $SHORT_NAME
   hg pull
   hg update
else
   rm -rf $SHORT_NAME
   hg clone $REPO_URI $SHORT_NAME
fi
popd
