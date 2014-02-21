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

.. todo::

   George will continue working on this.

How Scala Allows us to focus on CS1 Ideas
---------------------------------------------

An example that often resonates well with students is the Monte Carlo method,
which uses randomness to perform the :math:`\pi` computation. In the interests
of showing how Scala's approach to functional programming follows the textual
description, we will write the steps and show the code (in Scala) to perform
each step in an integrated fashion.

In the Monte Carlo method for calculating :math:`\pi`, we will randomly
generate a given number of darts using a Scala stream. We *fire* the darts
into a unit circle, which is bounded by a square, whose dimensions are
:math:`2 x 2` units.  The darts that fall within the unit circle satisfy the
constraint :math:`x^2 + y^2 <= 1`.

Let's start by establishing the needed functions. First, here is the now-
familiar ``square(x:Double)`` function, again for reference.

.. code-block:: scala

   def sqr(x: Double) = x * x

We use this function to create another function, which tests whether a given
dart, specified as an (x, y) coordinate pair (a Scala tuple), falls within the
unit circle:

.. code-block:: scala

   val inCircle: ((Double, Double)) => Boolean = { case (x, y) => sqr(x) + sqr(y) <= 1.0 }

Let's to a quick sanity check here:

.. code-block:: scala

   scala> inCircle((0, 0))
   res1: Boolean = true

   scala> inCircle((1, 1))
   res2: Boolean = false

   scala> inCircle((0.7, 0.7))
   res3: Boolean = true

   scala> inCircle((0.7, -0.7))
   res4: Boolean = true

   scala> inCircle((1, -1))
   res5: Boolean = false

So how do we generate a set of darts and test whether they fall within the
circle? We start by using a Scala Stream (more on this in collections).

.. code-block:: scala

   scala> val randomPairs = Stream continually (math.random, math.random)
   randomPairs: scala.collection.immutable.Stream[(Double, Double)] = Stream((0.45422625790687077,0.1916739269602844), ?)

What you see here is the first item of the stream being displayed. The "?"
indicates that there are more values (an infinite number, in theory) which
will be obtained on demand. This principle is an advanced one but one that is
teachable and can be understood in greater detail later.

So how do we get a finite number of darts? This is where a number of famous
methods from functional programming come to play. One is known as ``take(n)``,
which can take however many we want. Let's use this to show how to print the
first 5 random coordinate pairs.

.. code-block:: scala

   scala> randomPairs.take(5)
   res7: scala.collection.immutable.Stream[(Double, Double)] = Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> randomPairs.take(5).foreach(println)
   (0.45422625790687077,0.1916739269602844)
   (0.9252028282996272,0.5638265909110913)
   (0.5588908846857542,0.21516929857230815)
   (0.5842149396390998,0.7226255374753748)
   (0.8454163994561401,0.6805038035803781)

So what is going on here? We're taking the first 5 coordinate pairs in the
stream and applyingg the ``println()`` function to each item in the stream
(that is, each coordinate pair). While there are some aspects of this that are
advanced, there are some aspects that are *vastly simpler* than their
equivalent in tradition imperative object-oriented languages (e.g. C++, Java,
C#). For example, we rely on the notion of a tuple (a pair of Double values),
which usually requires the premature exploration of a Pair class in other
languages. Before long, you need to learn a lot of arcane type theory to
understand Pair, whereas in Scala, the type information is *inferred*.

Looking more closely:

.. code-block:: scala

   scala> (math.random, math.random)
   res10: (Double, Double) = (0.20679803333001656,0.91233235776938)

This generates a random pair, and it even *looks* like a random pair from mathematics. Of course, it's also typesafe!

So we're now near the point where we can put all of the pieces together. We have a function to determine whethe a randomly generated coordinate pair falls within the unit circle. Let's compute :math:`\pi`.

.. code-block:: scala

   scala> val n = 1000000
   n: Int = 1000000

   scala> val darts = randomPairs take n
   darts: scala.collection.immutable.Stream[(Double, Double)] = Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> val dartsInCircle = darts.count(inCircle)
   dartsInCircle: Int = 784894

   scala> val totalDarts = darts.length
   totalDarts: Int = 1000000

   scala> val area = 4.0 * dartsInCircle / totalDarts
   area: Double = 3.139576

This is a good time to introduce the *dotless* syntax, which is often associated with object-oriented programming but actually precedes these languages (C *struct* et al).

You can also write the above code (where you see dots) as follows:

.. code-block:: scala

   scala> val dartsInCircle = darts count inCircle
   dartsInCircle: Int = 784894

   scala> val totalDarts = darts length
   totalDarts: Int = 1000000

   scala> val area = 4.0 * dartsInCircle / totalDarts
   area: Double = 3.139576

.. todo::

   More to come!

Recursion
---------------

Recursion for Iteration
--------------------------

- This is my style, even in C.
- Works well with functional
- Cements previous topics
- Further with Scala
- Passing function argument → early abstraction
- Matching idiom
- Introduce patterns
- Scala optimizes tail recursion (JVM constraints)


Collections
---------------------
- Just for Scala
- Doesn't make sense before loops in most languages.
- One mutable, one immutable
- Many standard methods
- Many higher-order methods
- Syntax
- Use () for indexing
- List also have ML style operations
- Creation, pass-by-name

Loops
-------
- While loop
- Not an expression
- For loop/comprehension
- Really for-each
- yield
- Ranges
- Many options
- Multiple generators
- If guards
- Variables
- Patterns


Files
----------
- Can use Scanner
- scala.io.Source
- Scala Iterator[Char]
- getLines : Iterator[String]
- Use with higher-order methods
- Write with PrintWriter
- Introduce APIs?

Case Classes
---------------

- Immutable struct in simplest usage
- Simple syntax for grouping data
- Works as a pattern
- Copy method

GUIs
------

- scala.swing wraps javax.swing
- Cleaner beginner syntax
- No explicit inheritance
- Reactions use partial functions
- Drawbacks: Currently no JTree, Tables complex, Button syntax uses companion object
- Full Java2D
- Really using Java
- Override paint method
- Events for animations
- Keyboard, Mouse, Timer

Objects
-----------

- OO syntax is very natural
- Class declaration with body
- Can have arguments
- Constructor not required
- Functions declarations in class are methods
- val or var declarations are member data
- Visibility controls
- More control than present in Java

CS2
-------

- Pure OO
- Fewer quirks than Java
- Powerful type system
- Traits
- Rich collections
- Libraries again
- Can make things interesting/relevant
- Multithreading and networking
- Eclipse
- Scalable language
- Libraries as language
- Special methods
