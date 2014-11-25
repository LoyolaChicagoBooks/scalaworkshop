# Software Prerequisites

This document details the software prerequisites for
[SIGCSE 2013 Workshop 21: _Using Scala Strategically Across the Undergraduate Curriculum_](http://db.grinnell.edu/sigcse/sigcse2013/Program/viewAcceptedDayTime.asp?timeID=3180). We
recommend that you bring your own laptop to the workshop. If possible,
please install these packages on your laptop prior to the workshop.

Please use the [issue tracker](preparation/issues) for any questions
or concerns. We look forward to seeing you at SIGCSE!

## Required for the CS1/CS2 modules

- your favorite text editor
- the [latest Scala release](http://www.scala-lang.org/downloads),
  which includes the REPL

 After these steps, you should be able to start the Scala REPL and
 evaluate simple expressions

	$ scala
	Welcome to Scala version 2.10.0 (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_43).
	Type in expressions to have them evaluated.
	Type :help for more information.

	scala> "Hello SIGCSE 2013!".length
	res0: Int = 18

as well as more complex ones.

## Required for the concurrency module

- Java Development Kit (JDK) 6 through your package management system
  or from
  [Oracle](http://www.oracle.com/technetwork/java/javase/downloads).
  ([ProGuard](http://proguard.sourceforge.net/), highly useful for
  deploying Scala Android apps, does not yet support Java 7! So, to
  participate in the subsequent Android module, please ensure you have
  a version 6 JDK.)
- [Simple Build Tool (sbt)](http://www.scala-sbt.org/)

After these steps, you should be able to test and run a simple console
application such as
[this one](https://bitbucket.org/loyolachicagocs_plsystems/integration-scala)
following the detailed instructions contained therein. (Please check
out the project using Mercurial (hg) or download
[this zip file](https://bitbucket.org/loyolachicagocs_plsystems/integration-scala/get/default.zip).)

## Required for the Android module, recommended for the web service development module

- [Android SDK](http://developer.android.com/sdk)
- [Eclipse 4.2.x IDE for Java Developers](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/junosr1)
- [Android ADT plugin](http://developer.android.com/tools/sdk/eclipse-adt.html)
- [Scala IDE Eclipse plugin](http://scala-ide.org/download/milestone.html#scala_ide_21_milestone_3)
   corresponding to your Eclipse version
- [AndroidProguardScala](https://github.com/banshee/AndroidProguardScala) Eclipse plugin for faster Android development

After these steps, you should be able to enter the Scala perspective,
create a new project, and run a simple Scala application such as this
one:

    object Hello extends App {
	  println("Hello SIGCSE 2013!")
	}

# Other Steps

## Android Virtual Device configuration

- Configure virtual machine hardware acceleration per
  [these instructions](http://developer.android.com/tools/devices/emulator.html#accel-vm).
- Create an Android Virtual Device (AVD) per
  [these instructions](http://developer.android.com/tools/devices). This
  device should support API level 17 (Android 4.2) and have an x86
  CPU, a skin with hardware controls, and the option _hardware
  keyboard present_ checked.

## Setting up your own Android device for development (optional)

If you have an Android device and wish to use it for development, you
can follow
[these instructions](http://developer.android.com/tools/device.html)
to enable it.
