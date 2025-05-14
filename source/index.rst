.. This is a new Sphinx project for George's and Konstantin's Scala for Computer Science and Data Science

.. image:: figures/scalalogo.png

Scala for Computer Science and Data Science Education
=====================================================


Authors
--------

| **Konstantin Läufer**
| Professor of Computer Science, Loyola University Chicago
| https://laufer.cs.luc.edu
|
| **George K. Thiruvathukal**
| Professor of Computer Science and Chairperson, Loyola University Chicago
| Visiting Computer Scientist, Argonne National Laboratory, Leadership Computing Facility
| https://gkt.sh


Abstract
--------

This book is a tutorial on the Scala programming language, with a focus on its applications in computer science and data science.
Scala is the language behind Apache Spark and one of the most powerful tools for scalable data analysis. 
This one-hour hands-on workshop, led by Dr. George K. Thiruvathukal and Dr. Konstantin Läufer, introduces beginners to Scala. 
Participants will explore basic Scala syntax and data structures while performing simple data transformations and summaries using the command line. 
The session will also introduce participants to working with data science libraries such as Smile, which offers functionality similar to Python’s Pandas for data manipulation in Scala. 
We will also provide an update on the overall state of data science in Scala, including current libraries, tooling, and community trends.
Participants should bring laptops capable of running Scala at the command line. Windows users must use Windows 11 and are strongly encouraged to set up the Windows Subsystem for Linux (WSL). macOS and Linux users will be able to install the necessary tools directly, even during the session.


This tutorial--delivered as a Python Sphinx book that rebuilds on all changes to the text and underlying source code--is intended to accompany the workshop.


Acknowledgments
----------------

| **Mark Lewis**
| Senior Software Engineer, Amazon
| Professor, Trinity University, Texas


.. toctree::
   :maxdepth: 4
   :caption: Table of Contents
   :hidden:

   05-intro/intro.rst
   10-install/install.rst
   20-essentials/essentials.rst
   30-datastructures/datastructures.rst
   35-datascience/datascience.rst
   40-buildtools/buildtools.rst
   50-webservices/webservices.rst
   60-android/android.rst
   70-parallel/parallel.rst
   80-actors/actors.rst
   90-pl/pl.rst


Distribution
------------

Build Status
   .. only:: html

      .. image:: https://github.com/LoyolaChicagoBooks/scalaworkshop/actions/workflows/main.yml/badge.svg
         :target: https://github.com/LoyolaChicagoBooks/scalaworkshop/actions/workflows/main.yml
         :alt: GitHub Pages and Release PDF

Latest Version
   |version|

Repository
   `github.com/LoyolaChicagoBooks/scalaworkshop <https://github.com/LoyolaChicagoBooks/scalaworkshop>`_

Releases
   The current book (|version|) in PDF is available at
   `GitHub Releases <https://github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest>`__

   You can also perform the following steps to pull the book with all examples contained in the ``examples`` subdirectory.

   .. code-block:: bash

      git clone --recurse-submodules https://github.com/LoyolaChicagoBooks/scalaworkshop


Example Source Code
   .. csv-table:: Example Repositories
      :header: "Description", "URL"

      "introcs-scala-examples","https://github.com/LoyolaChicagoBooks/introcs-scala-examples"
      "introds-scala-examples","https://github.com/LoyolaChicagoBooks/introds-scala-examples"
      "integration-scala","https://github.com/LoyolaChicagoCode/integration-scala"
      "lcs-systolicarray","https://github.com/LoyolaChicagoCode/lcs-systolicarray-scala"
      "hpjpc","https://github.com/LoyolaChicagoCode/hpjpc-source-java"
      "numerical-explorations-scala","https://github.com/LoyolaChicagoCode/numerical-explorations-scala"



Indices and tables
----------------------

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`


.. note:: AI Disclosure: This text contains a mix of original writing and programming with strategic use of Chat-GPT4 via intelligent/clever prompting. All examples will be available in our repository with an appropriate **cmake** build file and tests. We will also make our prompts and analysis available, similar to what we have done for our recent ongoing study of Chat-GPT4 and Systems Programming. See https://doi.org/10.6084/m9.figshare.22257274.
