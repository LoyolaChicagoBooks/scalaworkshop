Activity for Data Science with Scala and Smile
----------------------------------------------


Obtain the source code for this activity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Check out the source code

.. code-block:: bash

   $ git clone https://github.com/LoyolaChicagoBooks/introds-scala-examples

or download and unzip

.. code-block:: bash

   $ wget https://github.com/LoyolaChicagoBooks/introds-scala-examples/archive/refs/heads/main.zip
   $ unzip main.zip

Then navigate to the ``montecarlo-scala`` directory for the Monte Carlo simulation code, and the ``311-case-study-scala`` directory for the 311 case study code.


Monte Carlo challenge
^^^^^^^^^^^^^^^^^^^^^

- Verify that you can run the Monte Carlo simulation code for estimating the area of a circle, and understand how it works. (Refer to the README file in the ``montecarlo-scala`` directory for instructions on how to run the code.)
- Determine how many darts (as a power of 10) you need to throw to get a good estimate of the area of the circle, defined as accurate when rounded to the first two decimal places, e.g.,

  - 3.12017 rounded to 3.12 (FAIL)
  - 3.14159 rounded to 3.14 (PASS)
  - 3.14859 rounded to 3.15 (FAIL)

- Study the source code and understand how the data is generated and analyzed. In particular, understand what role the Smile library plays in each stage of the process.


311 case study challenge
^^^^^^^^^^^^^^^^^^^^^^^^

- Find out which options the ``FilterGraffitiData.scala`` program accepts by running it with the ``--help`` option, e.g.,

  .. code-block:: bash

     scala-cli FilterGraffitiData.scala -- --help

- Filter the data based on various criteria, such as status, e.g.,

  .. code-block:: bash

     scala-cli FilterGraffitiData.scala -- -i dataset/311_graffiti.csv -s 'Open'

  This might show only a few matches, so try again with other status values (look at the dataset to see what other status values are available) and a higher number of records to show, e.g.,

  .. code-block:: bash

     scala-cli FilterGraffitiData.scala -- -l 1000 -i dataset/311_graffiti.csv -s 'Open'
 
- Attempt to reproduce the visualization by running the ``VisualizeGraffitiData.scala`` program, e.g.,

  .. code-block:: bash

     scala-cli VisualizeGraffitiData.scala -- -i dataset/311_graffiti.csv

- Study the source code and understand how the data is generated and analyzed. In particular, understand what role the Smile library plays in each stage of the process.
