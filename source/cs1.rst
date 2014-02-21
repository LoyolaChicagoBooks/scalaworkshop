Scala in CS1 and CS2
=====================

This is an elaboration of our Google presentation slides: http://goo.gl/Q68fA.

Scala Adoption/Usage Charts
-----------------------------

Coming soon.


Scala in CS1
---------------

- Programming in the small

  - REPL
  - Scripting Environment

- Libraries allow for interesting code (JVM)
- Static type checking
- Uniform syntax
- Everything is a method call
- Powerful collections

Language Complexity
----------------------

See presentation for now.

Getting Started
-------------------

Like many *agile* languages, Scala embraces the notion of being able to get started using
a REPL (Read-Evaluate-Print-Loop), which allows for interactive execution and spontaneous 
feedback.

We're assuming the reader can set up Scala and Java (needed to run Scala, a language that 
targets the JVM primarily). Once you have Scala and Java installed, you can open up an 
interactive session using the *command line*. (For those who don't prefer the command line,
especially on Windows, we recommend installing IntelliJ Community Edition and the Scala
plugin. This will allow you to get an interactive session as well.)

.. code-block:: scala

   $ scala-2.10
   Welcome to Scala version 2.10.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_45).
   Type in expressions to have them evaluated.
   Type :help for more information.

   scala>

Hello, World
----------------

.. code-block:: scala

   scala> println("Hello, World")
   Hello, World	


Types - "Lack" of Primitives
--------------------------------


.. code-block:: scala

   scala> 1
   res1: Int = 1

In the following, the user types ``1.`` and then hits the ``<tab>`` key--known as
tab completion--to show the available operations and methods available for an ``Int``.

.. code-block:: scala

   scala> 1.<tab>
   %              &              *              +              -
   /              >              >=             >>             >>>
   ^              asInstanceOf   isInstanceOf   toByte         toChar
   toDouble       toFloat        toInt          toLong         toShort
   toString       unary_+        unary_-        unary_~        |

Statements
---------------



Expressions
----------------


Semicolon Inferencing
-------------------------

Python programmers already know and love not having to deal with semicolons. Scala follows
this excellent practice as well.

You can do

.. code-block:: scala

   scala> val x = 30;
   x: Int = 30


But this works just as well and is preferred:

.. code-block:: scala

   scala> val y = 30
   y: Int = 30

Simple Input
-------------------

Much like Python and Java, import can be used to experiment with library objects and functions, even
before you know how to create classes:

.. code-block:: scala

   scala> import scala.tools.jline.console.ConsoleReader

   scala> val input = new ConsoleReader
   input: scala.tools.jline.console.ConsoleReader = scala.tools.jline.console.ConsoleReader@3ec642e5

Then you can inspect the capabilities of the ConsoleReader by using tab completion (as shown before)

.. code-block:: scala

   scala> input.r<tab>
   readCharacter     readLine          readVirtualKey    redrawLine
   removeCompleter   replace           resetPromptLine   restoreLine

Now we look up more details on the ``readLine()`` methods, which is what we
want to do basic, line-oriented input (a common need in introductory
teaching).

.. code-block:: scala

   scala> input.readLine<tab>

   def readLine(): String
   def readLine(Character): String
   def readLine(String): String
   def readLine(String, Character): String

   scala> val data = input.readLine("Please enter some text: ")
   Please enter some text: Hello, World
   data: String = Hello, World

You'll probably find it necessary to read through the Scala documentation, but
in a number of cases, the behavior is similar to what you've seen in other
language APIs. ``readLine()`` is pretty well known in Java circles. As you can
see above, ``readLine(String)`` gives us what we want: the ability to read
input with a prompt of sorts.

val vs. var
----------------

- Values (keyboard ``val``) are used for immutable storage.
- Variables (keyword ``var``) are used for mutable storage.

- You can think of this as the reemergence of ``const`` but it takes on a more powerful and predictable form in Scala than other languages that preceded it.

- Scala thinking prefers val to var.

Scripts and Worksheets
---------------------------

Similar to modern scripting languages (e.g. Python and Ruby) and the original shell, you can create a 
Scala script in a file, e.g. ``myscript.scala`` and run the script using the ``scala`` command.

.. code-block:: scala

   $ scala myscript.scala

You can also *load* the script within the Scala REPL:

.. code-block:: scala

   $ scala
   scala> :load myscript.scala

We'll be taking advantage of this a bit more in our discussion about ``sbt``, the Scala Build Tool.

Conditional and Functions
-----------------------------

Functional → expressions


if expression

.. code-block:: scala

   scala> val a = 25
   a: Int = 25

   scala> val b = 30
   b: Int = 30

   scala> val max = if (a > b) a else b
   max: Int = 30

Contrast with:

.. code-block:: scala

   scala> var max = 0
   max: Int = 0

   scala> if (a > b)
        |   max = a

   scala> if (a > b) {
        |    max = a
        | } else {
        |    max = b
        | }

   scala> max
   res4: Int = 30

Note: Similar to other agile languages, you can enter compound statements and blocks of code in the REPL.
The ``|`` is a continuation character to indicate that more input is expected. It's often best to use a 
text editor once you start entering more complex fragments of code (especially more complicated than what
you see here).

Functions are front and center when it comes to Scala programming. Although object-functional, a pure function
can be written without the boilerplate associated with OOP. We're proponents of OOP but prefer to introduce
functional thinking and *use* of objects prior to creating classes.

.. code-block:: scala

   scala> def square(x : Int) = x * x
   square: (x: Int)Int


   scala> square(25)
   res6: Int = 625

   scala> square(25.0)
   <console>:12: error: type mismatch;
    found   : Double(25.0)
    required: Int
                 square(25.0)
                        ^

As expected, the second invocation of ``square()`` results in an error. Scala performs static type checking 
in real time. That is, this is *not* a run-time check.

Function literals
----------------------

Let's build on the ``square()`` example to see how easy it is to generate the first ``n`` squares. We'll use
this to show how you can use functions as parameters and to sensitize the use of Scala *function literals*,
which are used rather idiomatically in Scala programming.

We'll start by generating the first 25 values using a Scala range.

.. code-block:: scala

   scala> val n = 10
   n: Int = 10

   scala> val first_n = 1 to n
   first_n: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)



This shows how to map the ``square()`` function to the range of values.

.. code-block:: scala

   scala> first_n.map(square)
   res16: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how to map a *function literal* to the range of values. 

.. code-block:: scala

   scala> first_n map (n => n * n)
   res17: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how you can combine a function literal with a previously defined function:

.. code-block:: scala

   scala> first_n map (n => square(n))
   res18: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


You can avoid having to name arguments in function literals using the ``_`` parameter. This syntax is a 
bit awkward to new programmers (and therefore should be introduced gently in CS1 courses) but allows
for concise (and sometimes clearer) expression, especially when used in a disciplined way.

Consider this code that creates the first n even numbers:

.. code-block:: scala

   scala> 1 to 10 map (_ * 2)
   res26: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

You might be tempted to try this by doing the following:

.. code-block:: scala

   scala> 1 to 10 map (_ + _)
   <console>:11: error: wrong number of parameters; expected = 1
                 1 to 10 map (_ + _)

Alas, it doesn't work. Why? Because each occurrence of ``_`` corresponds to an expected parameter. In
this case, there would have to be pairs of values. Unfortunately, in the range 1 to 10, each value is an Int.

Default parameters and named parameters

Similar to other agile languages, Scala allows you to specify default parameter values. This is particularly
useful, especially when diving into object-oriented programming, but has uses even before then.

Consider this version of ``square()``:


.. code-block:: scala

   scala> def square( x : Int = 0) = x * x
   square: (x: Int)Int

   scala> square()
   res28: Int = 0

   scala> square(5)
   res29: Int = 25

Here we are creating a version that has a default value of zero, if the caller doesn't specify ``x``. (This 
is not necessarily intended to be pedagogically interesting but is effective, considering we spent most of 
our time in this section looking at the ``square()`` function!)

Recursion
---------------





