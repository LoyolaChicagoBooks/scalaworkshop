=====================
Build Tools for Scala
=====================

In this section, we provide a brief overview of build tools for
Scala. In general, build tools support the build process in several
ways:

- structured representation of the project dependency graph
- management of the build lifecycle (compile, test, run)
- management of external dependencies

Why Use a Build Tool?
---------------------

When using the Java or Scala command-line tools, the developer is
responsible for setting the dreaded classpath. This can quickly become
unwieldy when dependencies even as simple as JUnit are involved, so
this is not something you would usually want to do manually.

Brief History of Build Tools
----------------------------

.. TODO optional add links to tools

Unix make, Apache ant
  These tools manage the build lifecycle but not external dependencies.

Apache maven
  This tool also manages external dependencies but requires a lot of
  XML-based configuraration.

.. code-block:: xml
  :linenos:

	<dependency>
		<groupId>org.restlet</groupId>
		<artifactId>org.restlet.ext.spring</artifactId>
		<version>${restlet.version}</version>
	</dependency>

Apache ivy, Gradle, Scala's `Simple Build Tool (sbt) <http://www.scala-sbt.org>`_, etc.
  These tools emphasize convention over configuration in support of
  agile development processes. sbt is compatible with ivy and designed
  primarily for Scala development. For example, ivy uses a structured
  but lighter-weight format:

.. code-block:: xml
  :linenos:

	<dependency org="junit" name="junit" rev="4.11"/>

sbt
---

In the simplest case, sbt does not require any configuration and will
use reasonable defaults. The project layout is similar to that used by
Maven:

- Production code goes in ``src/main/scala``.
- Test code goes in ``src/test/scala``.

sbt supports two configuration styles, one based on a simple
Scala-based domain-specific language, and one based on the full Scala
language for configuring all aspects of a project.

build.sbt format
++++++++++++++++

A minimal sbt ``build.sbt`` file would look like this. The empty lines
are required, and the file must be placed in the project root folder.

.. code-block:: scala
  :linenos:

    name := "integration-scala"
    
    version := "0.0.2"

Additional dependencies can be specified either one at a time

.. code-block:: scala
  :linenos:

    libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"
 
or as a group

.. code-block:: scala
  :linenos:

    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-actors" % "2.10.1",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )

Build.scala format
++++++++++++++++++

Examples of more complex Scala-based project configurations can be
found in these examples:

- `Android click counter app <https://bitbucket.org/loyolachicagocs_plsystems/clickcounter-android-scala/src/tip/project/>`_
- `Prime checker web service <https://bitbucket.org/loyolachicagocs_distributed/primenumbers-spray-scala/src/master/project/>`_

Plugin Ecosystem
----------------

sbt includes a growing plugin ecosystem. Key examples include

`sbteclipse <https://github.com/typesafehub/sbteclipse>`_
  automatically generates an Eclipse project configuration from an sbt one.

`sbt-start-script <https://github.com/sbt/sbt-start-script>`_
  generates a start script for running a Scala application outside of
  sbt.

The IntelliJ IDEA Scala plugin also integrates directly with sbt.

.. Starting from Scratch
   ---------------------

   A remaining question is how to start new projects from scratch. One
   can start with a skeleton and modify it, or one can use maven
   archetypes, which are somewhat configuration-heavy and a bit hard to
   use.

   Alternatively, `Giter8 <https://github.com/n8han/giter8>`_ is a
   command-line tool that instantiates templates stored in Git
   repositories. Giter8 itself is based on Scala but handles templates in
   any language(s). For example:

   .. code-block:: none
     :linenos:

       $ g8 fxthomas/android-app

       Template for Android apps in Scala 

       package [my.android.project]: 
       name [My Android Project]: my-android-project
       main_activity [MainActivity]: 
       min_api_level [8]: 
       scala_version [2.10.0]: 2.10.3
       api_level [16]: 17
       useProguard [true]: 
       scalatest_version [1.9.1]: 

       Applied fxthomas/android-app.g8 in my-android-project

   Now we have a hello world app that is ready to run.

   .. code-block:: none
     :linenos:

       $ sbt android:package-debug
       $ sbt android:start-emulator
