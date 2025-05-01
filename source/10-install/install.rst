Installing Scala
=====================

Prerequisite: JDK
-----------------

As a prerequisite to Scala development, we recommend that you install
the Oracle Java Development Kit (Java 7 SE 7u51 or later). While you
can work with OpenJDK and other VM implementations to run Scala, our
initial testing is that the best experience and performance comes from
the latest stable release of the Java 7 Platform.

- `Oracle Java Platform Downloads <http://www.oracle.com/technetwork/java/javase/downloads/>`_
 
Command-Line Tools
------------------

We do most of our CS1 instruction using command line tools. If you
want to go this route, you can perform a standard Scala 2.10.x
standalone install using your system's package manager or manually
from

- http://www.scala-lang.org/download/

This is generally a good choice for projects without external
dependencies.

For projects with external dependencies (such as unit testing), we
also recommend using sbt (Simple Build Tool for Scala). You can
install version 0.13.x or newer of sbt using your system's package
manager or manually from

- http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html

You may also need to configure the paths on your machine to make these
tools easy to work with.

Text Editors
-----------------

To go along with the command-line tools, you will need a text editor
that you like to work with.

- On Linux, we recommend `Vim <http://www.vim.org/>`_ or `Emacs <https://www.gnu.org/software/emacs/>`_. 
  OS X Terminal also supports both via the command line or via the 
  `MacVim <https://code.google.com/p/macvim/>`_ and `AquaMacs <http://aquamacs.org/>`_ 
  projects.

- The `Sublime Text Editor <http://www.vim.org>`_ is also wildly popular among agile developers and
  works on all major platforms. While not free/open source, it can be used for an indefinite period 
  for free (with only occasional nagging suggesting you upgrade to the paid version). George uses this
  editor not only for writing Scala but also for editing reStructuredText (the source code for
  these notes).

IDE Option: JetBrains IntelliJ IDEA
-----------------------------------

Many faculty teaching introductory CS courses prefer an Integrated
Development Environment (IDE). We recommend IntelliJ IDEA, which is
growing in popularity over Eclipse and preferred by many of us. You
can get the Community edition for free from the following URL and then
install the Scala plugin through the plugin manager.

- http://www.jetbrains.com/idea/download/  

The IntelliJ IDEA Scala plugin undergoing active development, and
there is a tradeoff between stability and features/bug fixes. For
advanced Scala development, you may find yourself wanting to be more
bleeding edge. To this end, we recommend the current early access
version:

-  http://confluence.jetbrains.com/display/IDEADEV/IDEA+13.1+EAP

When you install the Scala plugin through the plugin manager, you will
automatically get the version that matches that of IDEA. There are
still a few glitches, but it has gotten a lot better since
January 2014. In particular, compilation (and execution of Scala
worksheets) has become much faster.

To work around false compilation errors in Scala worksheets, we also
recommend a standalone installation of Scala (sufficient for projects
without external dependencies) or sbt.


IDE Option: Eclipse Scala IDE
------------------------------

The official Scala IDE is provided as an Eclipse bundle that has Scala
already installed. It will work on all platforms with very minor
differences. The following link will take you there.

- http://scala-ide.org/download/sdk.html
