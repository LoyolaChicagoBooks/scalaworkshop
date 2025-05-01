sigcse.scala
============

TODO update - see https://unoapi.org readme

These instructions assume you are on Linux or OS X.

To ensure a good experience with Sphinx, do the following.

- Make sure you have Python 2.7 or later. I use Python 2.7.x whenever I work with it.

- Make sure you install virtualenv (Macports: py27-virtualenv, Ubuntu: python-virtualenv)

- Create a virtual environment for running Sphinx: virtualenv sphinx (or whatever you want to name it)

- source sphinx/bin/activate

- easy_install sphinx (do not do as root; virtual env doesn't require root, which is why we're using it)

Once the dependencies are installed, you're ready to build.

- cd sigcse.scala
- run build.sh 

- On subsequent runs, you can do *make html*

- Note: The build.sh script will pull down any needed example repositories
  to *git.examples*. This folder is being *ignored* via .gitignore, because we don't 
  want to keep a copy of the examples (already available from existing
  repositories). If you add examples, please make an entry in git.examples.in
  to ensure that the build works cleanly.


- To add new code examples from existing Git repositories, edit 
  *git.examples.in* and see the Hello world example.

- Make sure to run git.examples.py (which does the updating through git.examples.sh) after making any updates to *git.examples.in*.
