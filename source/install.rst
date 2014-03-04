Installing Scala
=====================

We do most of my CS1 instruction using command line tools. We know that many faculty teaching introductory CS courses prefer an Integrated Development Environment (IDE). For an IDE, we officially recommend Eclipse because it is provided as a bundle that has Scala already installed and it will work on all platforms with very minor differences. The following link will take you to that.

http://scala-ide.org/download/sdk.html

If you want to go the command-line route, you can also download the standard Scala install. 

- http://www.scala-lang.org/download/

Of course, to make this easy to work with you will need to configure the paths on your machine and you probably want a text editor that you like to work with. 

- On Linux, we recommend `Vim <http://www.vim.org/>`_ or `Emacs <https://www.gnu.org/software/emacs/>`_. 

- The `Sublime Text Editor <http://www.vim.org>`_ is also wildly popular among agile developers and
  works on all major platforms. While not free/open source, it can be used for an indefinite period 
  for free (with only occasional nagging suggesting you upgrade to the paid version).

Lastly, IntelliJ is growing in popularity over Eclipse and is preferred by some of us. You can get
the Community edition for free and then install the plugin.

- http://www.jetbrains.com/idea/download/
- http://confluence.jetbrains.com/display/SCA/Scala+Plugin+for+IntelliJ+IDEA

If you have any questions of problems, please just respond to me and hopefully we can get you set up. We look forward to seeing you in two days at SIGCSE.


IntelliJ Community Edition Notes
-------------------------------------

The IntelliJ IDEA Scala plugin undergoing active development, and there is a
tradeoff between stability and features/bug fixes. For advanced Scala development, you may find
yourself wanting to be more bleeding edge.

To thi send, we recommend the current early access version:

  http://confluence.jetbrains.com/display/IDEADEV/IDEA+13.1+EAP

When you install the Scala plugin through the plugin manager, you will
automatically get the version that matches that of IDEA. There are still a few
glitches, but it has gotten a lot better since January 2014. In
particular, compilation (and execution of Scala worksheets) has become much
faster.

(Konstantin has downloaded this version for all three platforms and will carry
(a USB stick for on-site distribution as needed.)

To work around false compilation errors in worksheets, we also recommend a
standalone installation of SBT (using your system's package manager or
manually):

- http://www.scala-sbt.org

The slowness of the first compilation Michael has reported might also have
been due to the initial code indexing, and responsiveness should improve
thereafter.
