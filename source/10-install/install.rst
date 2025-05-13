Installing Scala
================

Installing Scala is a straightforward process, but it can vary depending on your operating system and preferences.
We will provide instructions for installing Scala on macOS, Linux, and Windows using the SDKMAN! tool.
We will also discuss recommended IDEs and text editors for Scala development.

..
  - Our notes assume access to a Linux/Mac command line environment. Everything should work with Windows and PowerShell but we recommend WSL.
  - We follow Java and Scala latest releases. 
  - We highly recommend sdkman.io instead of downloadable installers.
  - Leave IDE discussion as is but consider refreshing to use Visual Studio Code with its integrated terminal support and Scala plugin. 
  - In this vein, confirm that we can edit scala scripts within Visual Studio Code 
  - for example, does VS code pick up dependencies in a Scala script when you do editing/code completion?
  - Eclipse can probably be nuked.
  - Ok with retaining IntelliJ


System Requirements
-------------------

The most basic requirement for learning Scala is a computer with access to a command-line environment.
We recommend using a macOS or Linux system; this will enable you to install the necessary tools directly, even during the session. 
If you are using Windows, must use Windows 11 and are strongly encouraged to set up the Windows Subsystem for Linux (WSL) to get a Linux-like environment. 
(You can also use a virtual machine with Linux installed, though this is not recommended for beginners.)


Installing SDKMAN!
------------------

SDKMAN! is a tool for managing parallel versions of multiple Software Development Kits (SDKs) on most Unix-based systems. 
It is the recommended way to install Scala and other tools.


macOS and Linux
^^^^^^^^^^^^^^^

1. Open a terminal.
2. Run the following command to install SDKMAN!:

  .. code-block:: bash

    curl -s "https://get.sdkman.io" | bash

3. Follow the on-screen instructions to complete the installation.
4. Restart your terminal or run:

  .. code-block:: bash

    source "$HOME/.sdkman/bin/sdkman-init.sh"

5. Verify the installation by running:

  .. code-block:: bash

    sdk version


Windows
^^^^^^^

1. Install the Windows Subsystem for Linux (WSL) if not already installed. Follow the instructions here: `Install WSL <https://learn.microsoft.com/en-us/windows/wsl/install>`_.
2. Open a WSL terminal (e.g., Ubuntu).
3. Follow the same steps as for Linux above to install SDKMAN! within the WSL environment.


Installing Java and Scala
-------------------------

Once SDKMAN! is installed, you can use it to install Java and Scala.
We recommend using the latest stable long-term support (LTS) versions of Java (version 21) and the latest version of Scala (version 3.7.0).

1. Open a terminal.
2. Run the following commands to install Java and Scala:

  .. code-block:: bash

    sdk install java
    sdk install scala

3. Verify the installation by running:

  .. code-block:: bash

    java -version
    scala -version


Recommended IDE: Visual Studio Code
-----------------------------------

(If you are using a text editor, you can skip this section.)

Visual Studio Code is a lightweight, open-source code editor that supports many programming languages, including Scala.
It is available for Windows, macOS, and Linux.
You can install it using your system's package manager (such as ``apt`` or ``brew``) or download it from the following URL:

- https://code.visualstudio.com/

When you open a Scala project folder for the first time, VS Code usually offers to install the Scala extension pack.
It provides features like code completion, error checking, and debugging support.


IDE Alternative: JetBrains IntelliJ IDEA
----------------------------------------

Many faculty teaching introductory CS courses prefer an Integrated
Development Environment (IDE). We recommend the free IntelliJ IDEA, which is
growing in popularity over Eclipse and preferred by many of us. You
can get the IDEA Community Edition for free from the following URL; 
it already includes the required Scala plugin.

- https://www.jetbrains.com/idea/download/  


Text Editors
------------

Alternatively, in the spirit of the other command-line tools, you can use any text editor that you like to work with.

- On Linux, we recommend `Vim <https://www.vim.org/>`_ or `Emacs <https://www.gnu.org/software/emacs/>`_. 
  OS X Terminal also supports both via the command line or via the 
  `MacVim <https://code.google.com/p/macvim/>`_ and `Aquamacs <https://aquamacs.org/>`_ 
  projects.
  You can use any of these editors to write Scala code, but you may need to run the Scala compiler from the command line.

- There are various other graphical text editors available, including
  `Notepad++ <https://notepad-plus-plus.org/>`_ for Windows and `Sublime <https://www.sublimetext.com/>`_ for all major platforms.
