Data Science with Scala and Smile 
##################################

.. warning::
 
   This section is not ready yet. Working on it!

Monte Carlo Simulation
------------------------------------------------

This example shows how to use the Monte Carlo method to estimate the area of a circle. 
It uses the Smile library for statistical computing and machine learning in Scala.
In particular, it loads dataframes representing the points where the darts landed and figures the area of the circle from the ratio of darts that landed inside the circle to the total number of darts.

.. literalinclude:: ../../examples/introds-scala-examples/montecarlo-scala/EstimateArea.scala
   :language: scala
   :linenos:

For convenience, here is the code for generating the data file:

.. literalinclude:: ../../examples/introds-scala-examples/montecarlo-scala/GenerateDarts.scala
   :language: scala
   :linenos:


Graffiti/311 Chicago Data Portal
-----------------------------------

.. note:: This is just the start. Adding placeholders for the code examples/snippets.

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/LoadGraffitiData.scala
   :language: scala
   :linenos:

 


















