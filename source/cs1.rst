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


GCD
~~~~~

This is based on a classic algorithm by Euclid and one that is covered in many introductory computer science
courses. (See [GCD]_ for a more detailed discussion of this method and the ways it has been coded over the
years, especially in imperative programming languages.)

.. code-block:: scala

   def gcd(a : Int, b : Int) = if (b == 0) a else gcd(b, a % b)

The Scala version looks a lot like Euclid's definition!


Factorial
~~~~~~~~~~~~

This is the basic example that comes from [MiscExplorationsScala]_,
which also show show to use Scala and functional programming to rework explicitly recursive computations into
non-recursive versions using higher-order functional thinking.


This shows how to explicitly define the ``fac(n : Int) : Int`` function.

.. code-block:: scala

   def fac(n : Int) : Int = if (n <= 0) 1 else n * fac(n - 1)

This shows how to define a function *object*. It makes use of the literal syntax we introduced earlier,
You read this as "fac is a function that maps Int into Int and binds the name ``n`` to the ``Int`` parameter.

.. code-block:: scala

   val fac: Int => Int = n => if (n <= 0) 1 else n * fac(n - 1)


In many cases, you can write these functions without explcit recursion, simply by taking advantage of Scala's
innate collections:

.. code-block:: scala

   def fac(n : Int) : Int = (1 to n).foldLeft(1)((l,r) => l * r)

Or even more concisely (and cryptically?)

.. code-block:: scala

   def fac(n : Int) : Int = (1 to n).foldLeft(1)(_ * _)

We'll look more at higher-order thinking shortly. Many who think of functional programming (especially the 1960's
and 1970's style) tend to think Lisp, which very much required you to think *recursively* most of the time in
practice. Today, the recursive element is still there, but you'll find that the need to use it explicitly is
not required and can be replaced with higher-order abstractions. In the end, students still need to know about
this technique, if only to understand that certain methods (e.g. folds) often have a recursive nature to them.

In addition to rather outdated notions many tend to have about functional programming when it comes to recursion,
the optimization of recursive calls is achieved through a version of tail-recursion elimination (a.k.a. tail call
optimization). See [TailCalls]_ for more information.


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


A CS1 Friendly Example
---------------------------------------------

An example that often resonates well with students is the Monte Carlo method,
which uses randomness to perform the :math:`\pi` computation. In the interests
of showing how Scala's approach to functional programming follows the textual
description, we will write the steps and show the code (in Scala) to perform
each step in an integrated fashion.

In the Monte Carlo method for calculating :math:`\pi`, we will randomly
generate a given number of darts using a Scala stream. We *fire* the darts
into a unit circle, which is bounded by a square, whose dimensions are
:math:`2 \times 2` units.  The darts that fall within the unit circle satisfy the
constraint :math:`x^2 + y^2 \leq 1`.

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


.. note::

   The examples we are showing here, much like typical introductory examples, trade good 
   pedagogy (not bogging down students with too many details) for performance and scalability.
   If you need to operate on a larger number of darts, you'll want to take advantage of ``StreamIterator``, not ``Stream``. A StreamIterator can be obtained from a Stream by reworking the code above as 
   follows:

   .. code-block:: scala

      scala> val randomPairs = Stream continually (math.random, math.random) iterator
      randomPairs: scala.collection.immutable.Stream[(Double, Double)] = Stream((0.45422625790687077,0.1916739269602844), ?)

   Notice that the ``iterator()`` method is being invoked. This can be taught after students have learned
   more about Scala collections.


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

   scala> val darts = randomPairs.take(n)
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

   scala> val darts = randomPairs take n
   darts: scala.collection.immutable.Stream[(Double, Double)] = Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> val dartsInCircle = darts count inCircle
   dartsInCircle: Int = 784894

   scala> val totalDarts = darts length
   totalDarts: Int = 1000000

   scala> val area = 4.0 * dartsInCircle / totalDarts
   area: Double = 3.139576

At some point, you realize that you want to enter the code into a text editor that can be loaded into
the Scala interpreter (as opposed to being entered interactively).

The actual code for this can be found at 
https://gkthiruvathukal@bitbucket.org/loyolachicagocs_plsystems/numerical-explorations-scala. You can 
pull up the Scala worksheet from ``MonteCarloPiStreamIteratorChunkFree.sc`` (by drilling into Source).

Here's the final version of our function to calculate :math:`\pi`.

.. literalinclude:: ../examples/numerical-explorations-scala/MonteCarloPiStreamIteratorChunkFree.sc
   :language: scala
   :linenos:
   :start-after: begin-monteCarloCircleArea
   :end-before: end-monteCarloCircleArea

We also provide a simple *timing* function, that allows us to time a *block*
of Scala statements. We'll not present it in detail now, but this function
could be given to your students with the hope of  sensitizing them to the
notion of *performance*. It also shows the tremendous power available in Scala
to work with a block of Scala code as an object (which can produce a value).

.. literalinclude:: ../examples/numerical-explorations-scala/MonteCarloPiStreamIteratorChunkFree.sc
   :language: scala
   :linenos:
   :start-after: begin-time
   :end-before: end-time

We're going to use this to show how to measure the execution time of our
:math:`\pi` calculation by  varying the problem size. Here is the fragment of
code that tries different problem sizes up to  :math:`n = 10^k`, where
:math:`k = \lfloor log_{10}(Int.MaxValue) \rfloor` (:math:`k = \lfloor
log_{10}(2147483647) \rfloor = 9`)

.. note::

   You might wonder why we are limited to ``Int`` in this version as opposed
   to a 64-bit ``Int``. It is a perfectly valid idea to ponder, especially in
   the modern era. Scala collections do not support operations like ``take()``
   and ``drop()`` with 64-bit Int values. The  explanation for this is a bit
   beyond the scope here, but we have worked out 64-bit versions where we
   perform the Monte Carlo :math:`\pi` calculation in chunks. You can vist our
   repostory for these versions, which are a bit complex compared to the Int
   version. We hope future versions of Scala will evolve beyond 32-bit
   thinking but don't see this as a showstopper for  introductory teaching.
   (We also hope the friendly competition between F# and Scala, where F#
   supports Int64, will eventually make its way to Scala.


.. literalinclude:: ../examples/numerical-explorations-scala/MonteCarloPiStreamIteratorChunkFree.sc
   :language: scala
   :linenos:
   :start-after: begin-performance-study
   :end-before: end-performance-study


Here is the output (some output has been deleted for conciseness).

.. code-block:: scala

   scala> :load MonteCarloPiStreamIteratorChunkFree.sc
   Loading MonteCarloPiStreamIteratorChunkFree.sc...
   sqr: (x: Double)Double
   inCircle: ((Double, Double)) => Boolean = <function1>
   warning: there were 1 feature warning(s); re-run with -feature for details
   randomPairs: Iterator[(Double, Double)] = non-empty iterator
   n: Int = 1000000
   darts: Iterator[(Double, Double)] = non-empty iterator
   dartsInCircle: Int = 785719
   warning: there were 1 feature warning(s); re-run with -feature for details
   totalDarts: Int = 0
   area: Double = Infinity
   longDartsInCircle: (numDarts: Int)Long
   monteCarloCircleArea: (numDarts: Int)Double
   time: [R](block: => R)R
   powers: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
   sizes: scala.collection.immutable.IndexedSeq[Int] = Vector(10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000)
   problemSizes: scala.collection.immutable.IndexedSeq[Int] = Vector(1000000, 10000000, 100000000, 1000000000)
   Trying these probem sizes
   1000000
   10000000
   100000000
   1000000000
   numDarts: 1000000
   Elapsed time: 0.149393s
   The area is 3.141644
   numDarts: 10000000
   Elapsed time: 1.110151s
   The area is 3.1406688
   numDarts: 100000000
   Elapsed time: 10.744608s
   The area is 3.141555
   numDarts: 1000000000


We will discuss performance and timing issues again when speaking to parallel computing in
:doc:`parallel`.

While Loop
-----------
- While loop
- Not an expression

In Scala, you can do imperative style loops and interactive loops:

Consider this interactive session to compute well-known example for sum

.. code-block:: scala

   scala> var i = 0
   i: Int = 0

   scala> var n = 10
   n: Int = 10

   scala> var sum = 0
   sum: Int = 0

   scala> while (i <= n) {
        |    sum = sum + i
        |    i = i + 1
        | }

   scala> i
   res2: Int = 11

   scala> sum
   res3: Int = 0

   scala> n
   res4: Int = 10

Of course, you can replace many computational loops by a side-effect free version.

.. code-block:: scala

   scala> 1 to n sum
   warning: there were 1 feature warning(s); re-run with -feature for details
   res6: Int = 55


What about interactive loops?

.. code-block:: scala

   scala> val reader = new ConsoleReader
   reader: scala.tools.jline.console.ConsoleReader = scala.tools.jline.console.ConsoleReader@26075b18

   scala> var response = 0
   response: Int = 0

   scala> while (response < 0 || response > 100) {
        |    response = reader.readLine("Enter a number >= 0  and <= 100? ").toInt
        | }

   scala> var response = -1
   response: Int = -1

   scala> while (response < 0 || response > 100) {
        |    response = reader.readLine("Enter a number >= 0  and <= 100? ").toInt
        | }
   Enter a number >= 0  and <= 100? -5
   Enter a number >= 0  and <= 100? 105
   Enter a number >= 0  and <= 100? 100

It is interesting to think about whether we can turn an interactive while loop into one without 
side effects. There are so many bad things that happent to us as CS1 educators when we work with
interactive loops:

- Improper initialization of the ``response`` variable.
- Improper setting of ``response`` upon termination.
- etc.

This is my early attempt to figure out how to have a side-effect free interactive while loop. 
Basic idea:

- Use Stream.continually() to get a continuous stream of lines read in.
- Because Stream is lazy only in the tail, assume a blank line as the first value of the Stream
  (which is safely ignored). I'd like to figure out the right way to eliminate this without introducing
  complexity.
- use the takeWhile() method to accept input until an appropriate terminating condition (the word "no" 
  is entered)
- convert each line to integer, if possible. We take advantage of the simplified exception management and 
  provide a wrapper that is applied to each element to produce an option. Option is an important Scala
  idiom to address a success/failure paradigm.
- use flatMap to get only the input that were integral. All other values (None) are discarded.

.. code-block:: scala

   scala> val s1 = "" #:: Stream.continually( reader.readLine("Enter number or no to end input: "))
   s1: scala.collection.immutable.Stream[String] = Stream(, ?)

   scala> val s = s1.takeWhile(_ != "no")
   s: scala.collection.immutable.Stream[String] = Stream(, ?)

   scala> val l = s.toList
   Prompt: 25
   Prompt: 35
   Prompt: 55
   Prompt:
   Prompt: s
   Prompt: no
   l: List[String] = List("", 25, 35, 55, "", s)

   scala> def toInteger(n : String) : Option[Int] = {
        |  catching(classOf[NumberFormatException]) opt n.toInt
        | }
   toInteger: (n: String)Option[Int]

   scala> l.map(toInteger)
   res3: List[Option[Int]] = List(None, Some(25), Some(35), Some(55), None, None)

   scala> l.flatMap(toInteger)
   res7: List[Int] = List(25, 35, 55)

   scala> l.flatMap(toInteger).sum
   res8: Int = 115

for loop
----------

Similar to the while loop, a for loop exists for *imperative* style programming, often when there is
a need to do something where a side-effect is needed.

.. code-block:: scala

   scala> var sum = 0
   sum: Int = 0

   scala> var n = 100
   n: Int = 100

   scala> for (i <- 1 to n)
        | {
        |    sum = sum + i
        | }

   scala> println(s"The sum is $sum")
   The sum is 5050


for comprehension
--------------------

A for comprehension is designed for where you want a more functional style. That is, there is no intention 
of having side effects, and it is likely that you want to use the result of the comprehension in another
computation.

Let's look at something a bit more interesting: Getting the first ``n`` squares:

.. code-block:: scala

   scala> val n = 10
   n: Int = 10

   scala> val first_n_squares = for (i <- 1 to n) yield { i * i }
   first_n_squares: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


You could wrap this up nicely in a Scala function as follows:

.. code-block:: scala

   scala> def squares(n : Int) = for (i <- 1 to n) yield { i * i }
   squares: (n: Int)scala.collection.immutable.IndexedSeq[Int]

   scala> squares(10)
   res7: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


Option
----------

Per the Scala documentation: An option represents optional values. Instances
of Option are either an instance of scala.Some or the object None.

The Scala Option type is useful for dealing with the notion of success and
failure (but is not limited to supporting this concept). In the interests of
keeping this discussion focused on being CS1-friendly, an Option is always
connected to an underlying type. For example Option[Int] means that you either
get the Int, or nothing (None).

.. code-block:: scala

   scala> val i = Some(3)
   i: Some[Int] = Some(3)

   scala> val j = None
   j: None.type = None


``Some`` and ``None`` are both *case classes* that extend ``Option[A]`` (a generic class that allows you
to use any time). While knowing all of the details requires a mastery of object-oriented programming (and 
perhaps more), the introduction of this idea is remarkably straightforward and one that can help students
to write better code from the beginning. In CS1 courses, we tend to spend a lot of time handling special
cases, and options give us a framework for dealing with missing information, etc.

As you can see from the above, ``i`` is defined as some value, in this case 3. It's a wrapped value, of course,
that must be unbundled later. For example, here is an attempt to use the value ``i`` (incorrectly):

.. code-block:: scala

   scala> i + 5
   <console>:9: error: type mismatch;
    found   : Int(5)
    required: String
                 i + 5
                     ^


So how do we make use of ``i`` and ``j``? A method associated with options, ``getOrElse()`` allows us to get the
*option*, if set to *some* value. Rather delightfully, we can set a value to be used, if the option was not set
previously.

.. code-block:: scala

   scala> i getOrElse(-1)
   res13: Int = 3

   scala> j getOrElse(-1)
   res14: Int = -1

So now if we want to use this value in a computation, we can just do this:

.. code-block:: scala

   scala> i.getOrElse(-1) + j.getOrElse(-1)
   res17: Int = 2

Options have their uses throughout Scala, notably its libraries. For example, maps (a.k.a. associative 
structures/arrays) use option to return the result of getting a key from the map:

.. code-block:: scala

   scala> val map = scala.collection.mutable.HashMap.empty[String, Int]
   map: scala.collection.mutable.HashMap[String,Int] = Map()

   scala> map += ("scala" -> 10)
   res4: map.type = Map(scala -> 10)

   scala> map += ("java" -> 20)
   res5: map.type = Map(scala -> 10, java -> 20)

   scala> map += ("C#" -> 15)
   res6: map.type = Map(scala -> 10, java -> 20, C# -> 15)

   scala> map += ("F#" -> 25)
   res7: map.type = Map(scala -> 10, F# -> 25, java -> 20, C# -> 15)

   scala> map += ("scala" -> 22)
   res8: map.type = Map(scala -> 22, F# -> 25, java -> 20, C# -> 15)

Here's an attempt to get the case-sensitive and case-insensitive versions of key, F#, from the map:

.. code-block:: scala

   scala> map.get("F#")
   res9: Option[Int] = Some(25)

   scala> map.get("f#")
   res10: Option[Int] = None

Seasoned Java programmers know that an entry not found in the map will result in the *null* value being
returned. This differs from Scala, because the value gotten from the map must be *tested* before attempting
to use it in any way.

In Scala, because ``None`` and ``Some(25)`` are both options, you can use ``getOrElse()`` to obtain the
options value (irrespective of whether the value is null, or not set) without writing an (unwanted) if-then-else
statement, which results in bloat (in most programming languages).

.. code-block:: scala

   scala> val entry = map.get("F#").getOrElse(-1)
   entry: Int = 25

   scala> println(s"The entry for F# is $entry")
   The entry for F# is 25

It's often the case that we have *default* values associated with failure to
accomplish a certain task. The Option idiom is an attempt to standardize this
for core data structures and (as we'll see) other situations (e.g. working
with complex for comprehensions). In the case of maps, an entry not found
would usually default to 0 or -1 (a convention that dates back to the earliest
days of C), which is preferable to throwing exceptions for no good reason (not to 
mention our general dislike of prematurely covering exceptions as a programming
technique in CS1 in particular.)

for comprehension and options
---------------------------------

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
- Eclipse (maybe) and IntelliJ (our favorite)
- Scalable language
- Libraries as language
- Special methods


Useful REPL functionality
-------------------------------

The Scala REPL supports a number of commmands that can be greatly helpful for working interactively. We've
relied on many of these in the preparation of this tutorial but will focus on the highlights, especially
for use in CS1 teaching.

.. code-block ::

   scala> :help
   All commands can be abbreviated, e.g. :he instead of :help.
   Those marked with a * have more detailed help, e.g. :help imports.

   :cp <path>                 add a jar or directory to the classpath
   :help [command]            print this summary or command-specific help
   :history [num]             show the history (optional num is commands to show)
   :h? <string>               search the history
   :imports [name name ...]   show import history, identifying sources of names
   :implicits [-v]            show the implicits in scope
   :javap <path|class>        disassemble a file or class name
   :load <path>               load and interpret a Scala file
   :paste                     enter paste mode: all input up to ctrl-D compiled together
   :power                     enable power user mode
   :quit                      exit the interpreter
   :replay                    reset execution and replay all previous commands
   :reset                     reset the repl to its initial state, forgetting all session entries
   :sh <command line>         run a shell command (result is implicitly => List[String])
   :silent                    disable/enable automatic printing of results
   :type [-v] <expr>          display the type of an expression without evaluating it
   :warnings                  show the suppressed warnings from the most recent line which had any


paste 
~~~~~~~~

When writing longer definitions in the REPL, it can be tricky. Having paste mode allows you to take some
code you have (perhaps from an editor where you are typing a Scala program) and copy/paste into the Scala
session. 

This shows an example of entering a slightly more verbose than needed definition of the ``square()`` 
function (presented earlier in this section):

.. code-block:: scala

   scala> :paste
   // Entering paste mode (ctrl-D to finish)

   def square(x : Int) : Int = {
      x * x
   }

   // Exiting paste mode, now interpreting.

   square: (x: Int)Int

Notice that you don't see the continuation characters when entering multiple lines of text.

load 
~~~~~~

Many programmers coming to Scala find it a bit frustrating at first that some things (like interactive
scripts, found in languages like Python) don't work quite the same way. More often than not, the real issue
is whether there is an easy way to load a script into the REPL--as opposed to having to run it on the 
command line (which is also possible but not the focus of this section). It is a matter of loading 
the filename, which may be an absolute or relative path.

.. code-block:: scala

   scala> :load myscript.scala

history
~~~~~~~~~~

History should be familiar to anyone who has used modern Unix shells. Even if you haven't, you've probably
used the history buffer, which allows you to use the up/down arrows or emacs/vi commands (^p, ^n, j, k) to 
access previous and next commands in the history buffer.

Scala also allows you to do ^r to perform a regex search for text within a previous command. We rely on
this heavily in our work, especially in this section, where it was necessary to look up previous attempts
within the REPL so they could be pasted into the notes!

In this example, I used ^r to search for the substring "val" so I could find a previous value definition in
my REPL session:

.. code-block:: scala

   (reverse-i-search)`val': val entry = map.get("F#").getOrElse(-1)

When you type ^r, you'll be given the "(reverse-i-search)" prompt to perform a search. While the full 
functionality of regex is provided, the nominal use is to type a few characters of something you
probably remember (at least partially). More often than not, I am looking for previous "val" or "def" 
(functions).


Additional Resources
------------------------

.. [TailCalls] Tail Call, http://en.wikipedia.org/wiki/Tail_call

.. [GCD] Greatest Common Divisor, http://introcs.cs.luc.edu/html/gcdexamples.html

.. [MiscExplorationsScala] Miscellaneous Scala Explorations, https://bitbucket.org/lucproglangcourse/misc-explorations-scala