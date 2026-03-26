Activity for Scala Essentials
-----------------------------


Instructions
^^^^^^^^^^^^

- For each of the following questions, enter (or copy-and-paste or recall-and-edit) and evaluate the corresponding expression within a Scala REPL.

- Pay attention to both the result value *and its complete type*, e.g.,
  
   .. code-block:: scala

      res12: Seq[Int] = List(1, 2, 3, 4, 5)


  or

   .. code-block:: scala

      List(1, 2, 3, 4, 5): scala.collection.immutable.List[Int]


- To enhance your understanding of these techniques, you are also encouraged to evaluate different subexpressions of these expressions in the Scala REPL.

- Make sure to leave some time for the last five or so examples!

- *You're encouraged to work in pairs or small groups, and to discuss your results with each other.*


Specific examples for this activity
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Please evaluate each of these expressions in the Scala REPL, one at a time.
 
.. code-block:: scala

  // basic sequence and list operations

   Seq("hello", "world",  "what", "up")(2)

   Seq("hello", "world",  "what", "up").take(2)

   Seq("hello", "world",  "what", "up").drop(2)

   // maps and filters

   (1 to 5).map(n => (n, n + 1))

   Seq(4, 3, 1, 5, 2).filter(_ >= 3)

   (1 to 5).filter(_ >= 3).map(n => (n, n + 1))

   (1 to 5).map(n => (n, n + 1)).filter{ case (x, y) => y >= 3 }

   (1 to 5).map(n => Seq(n, n + 1))

   (1 to 5).flatMap(n => Seq(n, n + 1))

   (1 to 5).flatMap(n => Seq(n, n + 1)).filter(_ >= 3)

   // fold left and right (repeated application of a binary operator)

   (1 to 5).foldLeft(1) { (result, n) =>
     result * n
   }

   (1 to 5).foldLeft(Seq.empty[Int]) { (result, n) =>
     n +: result
   }

   (1 to 5).foldRight(Seq.empty[Int]) { (n, result) =>
     n +: result
   }

   // for-yield expressions

   for {
     x <- 1 to 5
     y <- Seq(x, x + 1)
     if y >= 3 // like filter!
   } yield y

   for { 
     x <- 1 to 5 
     y <- Some(4) 
     if y >= 3 // like filter! 
   } yield x + y

   // grouping and aggregation

   Seq("hello", "world", "what", "up").map(s => s.length).max

   Seq(("s", 2), ("s", 3), ("s", 5), ("s", 3)).map(_._2).toSet

   Seq("hello", "world", "what", "up").zipWithIndex

   Seq("hello", "world", "what", "up", "hello", "hello", "up", "hello").zipWithIndex.groupBy(_._1)

   Seq("hello", "world", "what", "up", "hello", "hello", "up", "hello").zipWithIndex.groupBy(_._1).view.mapValues(_.length).toMap
