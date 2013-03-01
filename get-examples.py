import sys
import os

def process(filename):
   
   with open(filename, "r") as infile:
      for line in infile:
         line = line.strip()
         (dvcs, name, repo) = line.split(",")
         print("Fetching %s to examples/%s using method %s" % (repo, name, dvcs))
         if dvcs == 'hg':
            os.system("./hg.update.sh %s %s" % (name, repo))
         elif dvcs == 'git':
            os.system("./git.update.sh %s %s" % (name, repo))
         else:
            print("unknown method %s -- ignoring" % dvcs)

process("examples.in")
