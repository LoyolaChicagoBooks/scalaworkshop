.. todo:: Revise this merged content for coherence.
   

Downloading these Materials
===========================

scalaworkshop.cs.luc.edu
------------------------

.. csv-table:: Available Tutorial Formats
    :header: "Format", "URL"
    :widths: 15, 30

    "Web Pages", "http://scalaworkshop.cs.luc.edu/"
    "Web Pages (offline ZIP)", "https://github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest"
    "PDF", "https://github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest"
    "ePub (Experimental)", "https://github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest"

Source Code Repositories
----------------------------

The following table contains links to GitHub source code repositories for all of the long examples in our tutorial. 
You will need to have basic knowledge of version control using ``git`` to check out the code from these repositories.
We note that shorter, interactive sessions shown in the tutorial (especially the ones meant to be done simultaneously by the reader)
are not in any repository. You must copy/paste to try them out on your own!

.. csv-table:: Repositories
    :header: "Description", "URL"

    "integration-scala","https://github.com/LoyolaChicagoCode/integration-scala"
    "lcs-systolicarray","https://github.com/LoyolaChicagoCode/lcs-systolicarray-scala"
    "hpjpc","https://github.com/LoyolaChicagoCode/hpjpc-source-java"
    "introcs-scala-examples","https://github.com/LoyolaChicagoBooks/introcs-scala-examples"
    "numerical-explorations-scala","https://github.com/LoyolaChicagoCode/numerical-explorations-scala"


Alternately, you can perform the following steps to pull all examples into the ``examples`` subdirectory.

.. code-block:: bash

    git clone https://github.com/LoyolaChicagoBooks/scalaworkshop
    cd scalaworkshop
    git pull --recurse-submodules

.. _contact:

Comments?
--------------------

Please don't hesitate to contact the authors.

.. csv-table:: Repositories
    :header: "Name","E-mail"

    "Mark Lewis","mlewis@trinity.edu"
    "Konstantin Läufer","klaufer@luc.edu"
    "George K. Thiruvathukal", "gthiruvathukal@luc.edu"



About the Book
================

.. todo:: brief background on Scala for CS and DS

This tutorial--delivered as a Python Sphinx book that rebuilds on all changes to the text and underlying source code--provides hands-on experience in developing TODO blah blah blah.

Build Status
--------------

.. only:: html

      .. image:: https://github.com/LoyolaChicagoBooks/scalaworkshop/actions/workflows/main.yml/badge.svg
         :target: https://github.com/LoyolaChicagoBooks/scalaworkshop/actions/workflows/main.yml
         :alt: GitHub Pages and Release PDF


      See `github.com/LoyolaChicagoBooks/scalaworkshop/actions <https://github.com/LoyolaChicagoBooks/scalaworkshop/actions>`_


Distribution
-------------

Web Version
   See `scala-cs-ds.org <https://scala-cs-ds.org>`_

Book Version
   See `github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest/download/ScalaCSDS.pdf <https://github.com/LoyolaChicagoBooks/scalaworkshop/releases/latest/download/ScalaCSDS.pdf>`_.

Example Source Code

- `Scala for CS and DS Examples <https://github.com/LoyolaChicagoCode/scala-cs-ds-examples>`__

.. todo:: other references

If you find our work useful, please consider citing the above paper.
We will have an updated way of citing this work soon.

Please do not hesitate to contact us with any questions, regardless of whether you find us useful or not.

Motivation for Our Work
-------------------------

.. todo:: update away from HPC toward CS/DS

This is not all-inclusive.

Tenets:

- Who are the next generation of research software engineers **and** want to consider HPC careers?
- Most graduates drawn to modern web development, data science, and machine learning jobs. All require HPC knowledge, too.
- Most graduates learning about *cool* languages that offer higher-order thinking, e.g. Scala, Go, Rust, and numerous scripting languages. This is a first step toward bringing them back to C++.

In addition:

- HPC itself is still cool with *heterogeneous computing* and "novel architectures* having a renaissance.
- The most modern languages still *punt to C* to provide acceleration; C++ raises the level of abstraction without compromising performance.
- Research software engineers want to balance performance, portability, and productivity.


Editors/Contributors
----------------------

- `Mark C. Lewis <https://www.cs.trinity.edu/~mlewis/>`__, Professor, Trinity University, Computer Science
- `Konstantin Läufer (AEIC) <https://laufer.cs.luc.edu>`__, Professsor, Loyola University Chicago, Computer Science
- `George K. Thiruvathukal (EIC) <https://gkt.sh>`__, Professor and Chairperson, Loyola University Chicago, Computer Science

Contributors
-----------------

.. note:: There are others; however, I am waiting for their initial pull requests (for chapters) and ORCIDs

.. todo:: add contributors once there are any


AI Disclosure
---------------

.. note:: This text contains a mix of original writing and programming with strategic use of Chat-GPT4 via intelligent/clever prompting. All examples will be available in our repository with an appropriate **cmake** build file and tests. We will also make our prompts and analysis available, similar to what we have done for our recent ongoing study of Chat-GPT4 and Systems Programming. See https://doi.org/10.6084/m9.figshare.22257274.


Acknowledgements
-----------------

.. todo:: acknowledgments


Topics
-----------

These are the planned chapters:

.. todo:: list planned chapters
