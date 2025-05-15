Data Science with Scala and Smile 
##################################

Monte Carlo Simulation
------------------------------------------------

This example shows how to use the Monte Carlo method to estimate the area of a circle. 

First, we'll look at the code for generating a data file for the Monte Carlo simulation, given the desired number of darts. 
The resulting file consisting the x- and y-coordinates of each dart along with a boolean flag indicating whether or not the dart landed inside the circle.

.. literalinclude:: ../../examples/introds-scala-examples/montecarlo-scala/GenerateDarts.scala
   :language: scala
   :linenos:

Next, we'll look at the code for estimating the area of a circle using the Smile library for statistical computing and machine learning in Scala.
In particular, our code loads dataframes representing the points where the darts landed and figures the area of the circle from the ratio of darts that landed inside the circle to the total number of darts.

.. literalinclude:: ../../examples/introds-scala-examples/montecarlo-scala/EstimateArea.scala
   :language: scala
   :linenos:


Going Between Java and Scala APIs
---------------------------------

When using Java-centric APIs, such as Smile, we often need to convert between Java and Scala collections.
This example shows how to convert between the two using the ``asScala`` and ``asJava`` methods.
These conversions are not strictly needed unless we want to interact with these collections in a Scala way, which we usually do when using Scala.

.. code-block:: scala

   scala> import scala.jdk.CollectionConverters.*

   scala> java.util.List.of("hello", "world")
   val res0: java.util.List[String] = [hello, world]

   scala> res0.asScala
   val res1: scala.collection.mutable.Buffer[String] = Buffer(hello, world)

   scala> res1.asJava
   val res3: java.util.List[String] = [hello, world]

   scala> List("hola", "mundo")
   val res4: List[String] = List(hola, mundo)

   scala> res4.asJava
   val res5: java.util.List[String] = [hola, mundo]


Graffiti/311 Chicago Data Portal
-----------------------------------

This example aims to introduce Scala + Smile with a compelling example from our hometown of Chicago. *Well, it could be any city!*

The Chicago Data Portal Graffiti/311 example  provides a lightweight, scriptable toolkit for analyzing graffiti-related 311 service requests in the City of Chicago. Using Scala and command-line tools, the system allows users to inspect, filter, aggregate, and visualize graffiti complaint data efficiently—even on large files.

While graffiti is often--and wrongly--perceived as a cosmetic or quality-of-life issue, tracking and understanding patterns in graffiti reports can reveal deeper insights into urban infrastructure, neighborhood disinvestment, and resident engagement.

311 calls are not limited to being complaints; they are a form of civic participation. By examining this data over time and across geographic regions, we gain valuable information about public responsiveness, spatial inequality, and where municipal services are (or aren’t) being delivered equitably to communities (a longstanding issue in many Chicago neighborhoods).

This demonstration application helps make that analysis transparent, reproducible, and accessible.


Requirements (Functional and Non-Functional)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Data Acquisition
````````````````

The system must be able to:

- Download the Chicago 311 graffiti removal dataset in CSV format
  from the City of Chicago’s open data portal.

Data Inspection
```````````````

The system must be able to:

- Load and parse the downloaded CSV file, treating the first line as a header.
- Display the dataset schema (column names).
- Preview a limited number of rows from the dataset.

Data Filtering
``````````````

The system must be able to:

- Filter requests based on:

  - Service **status** (e.g., "Completed", "Open").
  - A **start date** and/or **end date** range using the "Creation Date" column.

- Limit the number of matching rows displayed.
- Save the filtered dataset to a new CSV file.

Data Aggregation
````````````````

The system must be able to:

- Count the number of requests grouped by a specific column
  (e.g., "Zip Code" or "Surface Type").
- Display the top N group values by count.

Data Visualization
``````````````````

The system must be able to:

- Aggregate requests by month using the "Creation Date" column.
- Generate a **bar chart** of graffiti removal trends over time.
- Save the chart to a file (e.g., PNG), with no GUI dependencies.

Reproducibility & Automation
````````````````````````````

The system must be able to:

- Be scriptable and composable using CLI arguments (no hardcoded values).
- Use lazy evaluation where possible to minimize memory usage on large files.
- Avoid dependence on any GUI (especially for visualization or preview).


Implementation
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Downloader
````````````````
.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/FetchGraffitiData.scala
   :language: scala
   :linenos:

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/get-graffiti-311-data.sh
   :language: shell
   :linenos:

Loader
````````````````

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/LoadGraffitiData.scala
   :language: scala
   :linenos:

 
Filtering
````````````````

This shows how to filter based on some criteria.
In this case, we are filtering dates/status of a particular report.

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/FilterGraffitiData.scala
   :language: scala
   :linenos:


Aggregation
````````````````

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/AggregateGraffitiData.scala
   :language: scala
   :linenos:


Visualization
````````````````

.. note:: This is not ready yet (may have errors for Scala 3)


.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/VisualizeGraffitiData.scala
   :language: scala
   :linenos:

.. image:: figures/xchart-graffiti-trend.png

Reproducibility
````````````````

.. note:: This is not ready yet (may have errors for Scala 3)

.. literalinclude:: ../../examples/introds-scala-examples/311-case-study-scala/SaveFilteredGraffitiData.scala
   :language: scala
   :linenos:
