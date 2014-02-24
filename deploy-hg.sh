#!/bin/bash

if [ -f ~/.env/sphinx/bin/activate ]; then
        . ~/.env/sphinx/bin/activate
fi

hg pull
hg update --clean
make html
make latexpdf
make epub
rsync -av ./build/ scalaworkshop.cs.luc.edu:/var/www/vhosts/scalaworkshop.cs.luc.edu/htdocs/
