Scala Essentials for Introductory CS and DS
===========================================

.. highlight:: scala

This is an elaboration of our Google presentation slides: http://goo.gl/Q68fA.


Motivating Scala for Introductory CS and DS
-------------------------------------------

- Programming in the small
- REPL - Read-Evaluate-Print-Loop 
- Scripting Environment
- Libraries allow for interesting code (JVM)
- Static type checking
- Uniform syntax
- Everything is a method call
- Powerful collections

Our motivation is to have the best of both worlds:

- Concise script-ability of languages like Python and Ruby
- Static type checking in the small makes it (generally) easy to fix compilation errors

The emerging *worksheet* model makes it possible to give students many
examples that just work and can be adapted to solve new problems.

Getting Started
-------------------

Like many *agile* languages, Scala embraces the notion of being able to get started using
a REPL (Read-Evaluate-Print-Loop), which allows for interactive execution and spontaneous 
feedback.

We're assuming the reader can set up Scala and Java (needed to run Scala, a language that 
targets the JVM primarily). Once you have Scala and Java installed, you can open up an 
interactive session using the *command line*. (For those who don't prefer the command line,
especially on Windows, we recommend installing IntelliJ Community Edition and the Scala
plug-in. This will allow you to get an interactive session as well.)

Hello, World
^^^^^^^^^^^^^^^^^^^^^^

.. code-block:: scala

   $ scala
   Welcome to Scala 3.7.0 (21.0.7, Java OpenJDK 64-Bit Server VM).
   Type in expressions for evaluation. Or try :help.

   scala> println("Hello, World")
   Hello, World	


Types - "Lack" of Primitives
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. code-block:: scala

   scala> 1
   val res1: Int = 1

In the following, the user types ``1.`` and then hits the ``<tab>`` key--known as
tab completion--to show the available operations and methods available for an ``Int``.

.. code-block:: scala

   scala> 1.<tab>
   !=                    ceil                  isValidByte           to
   ##                    compare               isValidChar           toBinaryString
   %                     compareTo             isValidInt            toByte
   &                     describeConstable     isValidLong           toChar
   *                     doubleValue           isValidShort          toDegrees
   +                     ensuring              isWhole               toDouble
   -                     eq                    longValue             toFloat
   ->                    equals                max                   toHexString
   /                     floatValue            min                   toInt
   <                     floor                 ne                    toLong
   <<                    formatted             nn                    toOctalString
   <=                    getClass              notify                toRadians
   ==                    hashCode              notifyAll             toShort
   >                     intValue              resolveConstantDesc   toString
   >=                    isFinite              round                 unary_+
   >>                    isInfinite            runtimeChecked        unary_-
   >>>                   isInfinity            self                  unary_~
   ^                     isInstanceOf          shortValue            until
   abs                   isNaN                 sign                  wait
   asInstanceOf          isNegInfinity         signum                |
   byteValue             isPosInfinity         synchronized          →

Literals are mostly what you expect
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Integers

.. code-block:: scala

   scala> val a = 95
   val a: Int = 95

   scala> val b = -95
   val b: Int = -95

Hexadecimals

.. code-block:: scala

   scala> val d = 0xff
   val d: Int = 255

   scala> val d = 0xffac
   val d: Int = 65452

Double and Float

.. code-block:: scala

   scala> val e = 1.34e-7
   val e: Double = 1.34E-7

   scala> val f = 1.34e-7f
   val f: Float = 1.34E-7


Statements vs. Expressions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Scala eschews statements as a general rule in favor of expressions (which produce values), owing to its functional heritage, which emphasizes the composition of functions to effect computation.

In practice, however, many expressions, however, behave like statements as they produce ``Unit`` as
a result.

A notable consequence of this language decision is that some constructs are not provided in
Scala, including the familiar break and continue (found in loops).

Everything is an Object
^^^^^^^^^^^^^^^^^^^^^^^^^^

Scala is not designed in a vacuum. Its heritage is one shared with Java, even if its ideas have value
above and beyond Java. Everything is achieved in Scala with *objects*, although you can do a tremendous amount of programming before ever writing a *class* per se.

There are two consequences to this decision:

- There are no primitive types per se. Every one of the literals discussed previously is an object.
  This eliminates the need to distinguish ``int`` from ``Integer`` (a major pain point for Java prior
  to boxing/unboxing support).

- There are very few keywords in Scala. Even when you encounter something that you think is a keyword,
  it is often just a method call. A really good example is the concept of mapping (map) from functional
  programming, which is a method common to just about every Scala collection.

Let's look at a couple of examples of methods. Here is an example of how to see the methods available
to an ``Int`` instance:

.. code-block:: scala

   scala> a.<tab>
   !=                    ceil                  isValidByte           to
   ##                    compare               isValidChar           toBinaryString
   %                     compareTo             isValidInt            toByte
   &                     describeConstable     isValidLong           toChar
   *                     doubleValue           isValidShort          toDegrees
   +                     ensuring              isWhole               toDouble
   -                     eq                    longValue             toFloat
   ->                    equals                max                   toHexString
   /                     floatValue            min                   toInt
   <                     floor                 ne                    toLong
   <<                    formatted             nn                    toOctalString
   <=                    getClass              notify                toRadians
   ==                    hashCode              notifyAll             toShort
   >                     intValue              resolveConstantDesc   toString
   >=                    isFinite              round                 unary_+
   >>                    isInfinite            runtimeChecked        unary_-
   >>>                   isInfinity            self                  unary_~
   ^                     isInstanceOf          shortValue            until
   abs                   isNaN                 sign                  wait
   asInstanceOf          isNegInfinity         signum                |
   byteValue             isPosInfinity         synchronized          →


Where you see ``<tab>``, you can use a feature known as *tab completion* in the REPL to see the options
available to value ``a``. You'll notice one thing immediately, especially if you are familiar with Java: 
operator overloading! That's right, every operator is a method.

Let's use the ``+`` method:

.. code-block:: scala

   scala> a.+(3)
   val res5: Int = 98

   scala> a + 3
   val res6: Int = 98


Let's convert an Int to a Float:

.. code-block:: scala

   scala> val b = a.toFloat
   val b: Float = 95.0


We're going to look at more *advanced* objects later (Scala collections) but this should give you
a taste of what is possible.

Tuples
^^^^^^^^

A language feature that was popularized (but not invented) by the Python language are tuples. Tuples
eliminate the need for unwanted uses of a class for grouping multiple values. Let's take a quick 
look.

.. code-block:: scala

   scala> val t = (3, 4)
   val t: (Int, Int) = (3,4)

   scala> val u = (3.0, 4.0)
   val u: (Double, Double) = (3.0,4.0)

   scala> val v = (3.0, 4)
   val v: (Double, Int) = (3.0,4)

Notice that Scala infers the type of each one of these value definitions. 

When working with a tuple, you're really working with an object. You can inspect the methods that 
are available using the tab completion method shown previously.

.. code-block:: scala

   scala> t.<tab>
   !=                    _2$mcI$sp             invert                size
   ##                    _2$mcJ$sp             isInstanceOf          splitAt
   *:                    _2$mcZ$sp             last                  swap
   ++                    apply                 map                   synchronized
   ->                    asInstanceOf          ne                    tail
   :*                    canEqual              nn                    take
   ==                    copy                  notify                toArray
   _1                    drop                  notifyAll             toIArray
   _1$mcC$sp             ensuring              productArity          toList
   _1$mcD$sp             eq                    productElement        toString
   _1$mcI$sp             equals                productElementName    wait
   _1$mcJ$sp             formatted             productElementNames   zip
   _1$mcZ$sp             getClass              productIterator       zipped
   _2                    hashCode              productPrefix         →
   _2$mcC$sp             head                  reverse
   _2$mcD$sp             init                  runtimeChecked

   scala> u.<tab>
   // identical output

   scala> v.<tab>
   // identical output

You can inspect the components of a tuple by using the ``_1``, ``_2``, ... methods.

.. code-block:: scala

   scala> t._1
   val res9: Int = 3

   scala> t._2
   val res10: Int = 4

You don't usually not want to use these names to refer to the components of a tuple. Using
pattern matching, you can extract the components of a tuple and *bind* them to proper names.
For example, if your tuple represents an (x, y) pair, you are likely to use a match expression
like this:

.. code-block:: scala

   scala> t match { case (x, y) => println(s"($x, $y)") }
   (3, 4)

We can get rid of the curly braces by introducing a new line after the ``match`` keyword:

.. code-block:: scala

   scala> t match 
        |   case (x, y) => println(s"($x, $y)")
   (3, 4)


Semicolon Inferencing
^^^^^^^^^^^^^^^^^^^^^^^^

Python programmers already know and love not having to deal with semicolons. Scala follows
this excellent practice as well.

You can do this:

.. code-block:: scala

   scala> val x = 30;
   val x: Int = 30


But this works just as well and is the preferred way to write Scala code:

.. code-block:: scala

   scala> val y = 30
   val y: Int = 30


Simple Input (and Output)
^^^^^^^^^^^^^^^^^^^^^^^^^^^

Much like Python and Java, import can be used to experiment with library objects and functions, even
before you know how to create classes:

.. code-block:: scala

   scala> import scala.io.StdIn

Then you can inspect the capabilities of the StdIn by using tab completion (as shown before)

.. code-block:: scala

   scala> StdIn.r<tab>
   readBoolean      readDouble       readLine         readf            readf3
   readByte         readFloat        readLong         readf1           runtimeChecked
   readChar         readInt          readShort        readf2


Now we look up more details on the ``readLine()`` methods, which is what we
want to for basic, line-oriented input (a common need in introductory
teaching).

.. code-block:: scala

   scala> input.readLine<tab>

   def readLine(text: String, args: Any*): String
   def readLine(): String

   scala> val data = StdIn.readLine("Please enter some text: ")
   Please enter some text: Hello, World
   val data: String = Hello, World

You'll probably find it necessary to read through the Scala documentation, but
in a number of cases, the behavior is similar to what you've seen in other
language APIs. ``readLine()`` without arguments is pretty well known in Java circles. As you can
see above, ``readLine(String)`` gives us what we want: the ability to read
input with a prompt of sorts.

val vs. var
^^^^^^^^^^^^^

- Values (keyboard ``val``) are used for immutable storage.
- Variables (keyword ``var``) are used for mutable storage.

- You can think of this as the reemergence of ``const`` but it takes on a more powerful and predictable form in Scala than other languages that preceded it.

- Scala thinking prefers val to var. So do we. 

- Interesting 

Scripts and Worksheets
^^^^^^^^^^^^^^^^^^^^^^^^^

Similar to modern scripting languages (e.g. Python and Ruby) and the original shell, you can create a 
Scala script in a file, e.g. ``myscript.scala`` and run the script using the ``scala`` command.

.. code-block:: scala

   $ scala myscript.scala

You can also *load* the script within the Scala REPL:

.. code-block:: scala

   $ scala
   scala> :load myscript.scala

Nevertheless, this works only for very simple scripts without external library dependencies. 
For more complex scripts, you should normally invoke them the ``scala myscript.scala`` syntax.

We'll be discussing the Scala REPL and library dependencies in more detail later.


Conditional and Functions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Functional → expressions


if expression

.. code-block:: scala

   scala> val a = 25
   val a: Int = 25

   scala> val b = 30
   val b: Int = 30

   scala> val max = if a > b then a else b
   val max: Int = 30

Contrast with:

.. code-block:: scala

   scala> var max = 0
   var max: Int = 0

   scala> if a > b then
        |   max = a

   scala> if a > b then
        |    max = a
        | else
        |    max = b

   scala> max
   val res4: Int = 30


.. note:: 

   Similar to other agile languages, you can enter compound statements and blocks of code in the REPL.
   
   The ``|`` is a continuation character to indicate that more input is expected. It's often best to use a 
   text editor once you start entering more complex fragments of code (especially more complicated than what
   you see here).

Functions are front and center when it comes to Scala programming. Although object-functional, a pure function
can be written without the boilerplate associated with OOP. We're proponents of OOP but prefer to introduce
functional thinking and *use* of objects prior to creating classes.

.. code-block:: scala

   scala> def square(x: Int) = x * x
   def square(x: Int): Int


   scala> square(25)
   val res6: Int = 625

   scala> square(25.0)
   -- [E007] Type Mismatch Error: -------------------------------------------------
   1 |square (25.0)
   |        ^^^^
   |        Found:    (25.0d : Double)
   |        Required: Int
   |
   | longer explanation available when compiling with `-explain`
   1 error found
                        ^

As expected, the second invocation of ``square()`` results in an error. Scala performs static type checking 
in real time. That is, this is *not* a run-time check.


Function literals
^^^^^^^^^^^^^^^^^^^^^^

Let's build on the ``square()`` example to see how easy it is to generate the first ``n`` squares. We'll use
this to show how you can use functions as parameters and to sensitize the use of Scala *function literals*,
which are used rather idiomatically in Scala programming.

We'll start by generating the first 25 values using a Scala range.

.. code-block:: scala

   scala> val n = 10
   val n: Int = 10

   scala> val first_n = 1 to n
   val first_n: scala.collection.immutable.Range.Inclusive = Range 1 to 10


This shows how to map the ``square()`` function to each value in the range of values.

.. code-block:: scala

   scala> first_n.map(square)
   val res15: IndexedSeq[Int] = 
     Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how to map a *function literal* (anonymous function, a.k.a., lambda) to the range of values. 
As you can see, the dot notation is not needed for methods such as ``map()``, which are applied to one object and one argument.
Even the parentheses are optional in this case, but they are needed when the method takes more than one argument.

.. code-block:: scala

   scala> first_n.map square
   val res16: IndexedSeq[Int] = 
     Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


.. code-block:: scala

   scala> first_n map (n => n * n)
   val res17: scala.collection.immutable.IndexedSeq[Int] = 
     Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how you can combine a function literal with a previously defined function:

.. code-block:: scala

   scala> first_n map (n => square(n))
   res18: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


You can avoid having to name arguments in function literals using the ``_`` parameter. This syntax is a 
bit awkward to new programmers (and therefore should be introduced gently in CS and DS courses) but allows
for concise (and sometimes clearer) expression, especially when used in a disciplined way.

Consider this code that creates the first n even numbers:

.. code-block:: scala

   scala> 1 to 10 map (_ * 2)
   val res26: IndexedSeq[Int] = 
      Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

You might be tempted to try this by doing the following:

.. code-block:: scala

   scala> 1 to 10 map (_ + _)
   -- [E086] Syntax Error: --------------------------------------------------------
   1 |1 to 10 map (_ + _)
   |             ^^^^^
   |             Wrong number of parameters, expected: 1


Alas, it doesn't work. Why? Because each occurrence of ``_`` corresponds to an expected parameter. In
this case, there would have to be pairs of values. Unfortunately, in the range 1 to 10, each value is an Int.

Default parameters and named parameters
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Similar to other agile languages, Scala allows you to specify default parameter values. This is particularly
useful, especially when diving into object-oriented programming, but has uses even before then.

Consider this version of ``square()`` :


.. code-block:: scala

   scala> def square(x: Int = 0) = x * x
   def square(x: Int): Int

   scala> square()
   val res28: Int = 0

   scala> square(5)
   val res29: Int = 25

Here we are creating a version that has a default value of zero, if the caller doesn't specify ``x``. (This 
is not necessarily intended to be pedagogically interesting but is effective, considering we spent most of 
our time in this section looking at the ``square()`` function!)


Early Introduction to Collections, Arrays, and Lists
----------------------------------------------------


Scala has some very advanced and comprehensive collections libraries. For introductory CS and DS, you can focus only on the simplest of these, beginning with Arrays and Lists.  In actually makes sense to introduce these before loops (and iteration in general) in Scala for two reasons. First, the collections have many methods
that allow you to do standard tasks that would often go in loops. As such,
Scala code often doesn’t include all that many loops. Second, the for loop in
Scala is really a foreach type loop that works with collections so it makes
more sense to introduce it after the basic collections.


Making Arrays and Lists
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The simplest way to make an Array or a List is with the following syntax.

.. code-block:: scala

   scala> Array(1,2,3,4)
   val res0: Array[Int] = Array(1, 2, 3, 4)

   scala> List(1.3,4.2,3.14)
   val res1: List[Double] = List(1.3, 4.2, 3.14)


Note that the Array and List types take type parameters. These appear in
square brackets. It is standard across the Scala language that value arguments
appear in parentheses, type arguments appear in square brackets, and curly
braces are used to denote code blocks for complex expressions or statements.
Also note that as before, Scala’s type inference figures out the types for
these expressions.

.. note::

   Technically these are making calls to the apply methods of the Array and
   List companion objects. The details of how that works don’t really matter
   in introductory CS and DS, but you can find them in the section on object-orientation under
   CS2. We cover this topic later in our discussion of classes and 
   objects.

You can also made longer arrays using the new syntax that one uses in Java.

.. code-block:: scala

   scala> new Array[Int](100)
   val res2: Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)


Here we need to specify the type and say how big the Array is. Array objects in
Scala are implemented as Java arrays and they have the same general
properties. Like Java Arrays, they are mutable and they can’t dynamically
change their size. Note that this approach to making Arrays is not the one
typically used in Scala because if the type is something like String you get
the same behavior you have in Java and all the values are initialized to null.
Later in this section we will see the fill and tabulate methods, which are
much less likely to produce a NullPointerException and are generally favored
over this style of creating a large Array.

Lists can be built using the ``::`` operator. We read ``::`` as ``cons``, following the
tradition of Scheme (Lisp and ML. ``::`` is a right associative operator so it takes a
value on the left and a List on the right. For example:


.. code-block:: scala

   scala> 1::2::3::4::Nil
   val res4: List[Int] = List(1, 2, 3, 4)


The ``Nil`` object is a short name for an empty List. You can also use
``List()`` (the empty list) in place of ``Nil``. Note that the List type is a
singly-linked, *immutable* list. So prepending as shown above is an efficient
operation. Also note that you can’t change values without making a new List
because it is immutable.

This form of building a List with ``::`` is probably most beneficial with
recursive functions and works very well in situations where you don’t know how
many values you will be working with.

.. code-block:: scala

   scala> import scala.io.StdIn.readInt

   scala> def readNumbers(n: Int): List[Int] = if n < 1 then Nil else 
        |   readInt :: readNumbers(n - 1)
   def readNumbers(n: Int): List[Int]

   scala> readNumbers(5)
   1
   2
   3
   4
   5
   val res6: List[Int] = List(1, 2, 3, 4, 5)

   scala> import scala.io.StdIn.readLine

   scala> def readUntilQuit(): List[Int] =
        |   val data = readLine
        |   if data != "quit" then data.toInt :: readUntilQuit() else Nil
   def readUntilQuit(): List[Int]

   scala> readUntilQuit()
   1
   2
   3
   4
   5
   quit
   val res7: List[Int] = List(1, 2, 3, 4, 5)


Indexing/Traversing Arrays and Lists
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

You can get to values in an Array or a List by indexing with parentheses.

.. code-block:: scala

   scala> val arr = Array(6, 8, 2, 4, 1)
   val arr: Array[Int] = Array(6, 8, 2, 4, 1)

   scala> val lst = List('g','e','o','r','g','e')
   lst: List[Char] = List(g, e, o, r, g, e)

   scala> arr(2)
   val res1: Int = 2

   scala> lst(2)
   val res2: Char = o

The use of parentheses instead of square brackets keeps the syntax consistent.
(Having parentheses is the next best thing to square brackets as well. It is certainly 
preferable to having an explicit method call as found in Java to access elements in
the array. We also note that the well-known math/science focused programming language,
FORTRAN, uses parentheses for subscripting!)

Neither the Array type, nor the List type have any special place in the Scala
syntax. They are both handled in the programming language just like any other
library code. The compiler does optimize Arrays to Java bytecode arrays, but
that is an implementation detail beyond the scope of our workshop.

You can also use the syntax you would expect to set the values of elements in
an Array. You can’t do this for Lists because they are immutable.

.. code-block:: scala

   scala> arr(2) = 99

   scala> arr
   val res4: Array[Int] = Array(6, 8, 99, 4, 1)

The common way to run through a List is using the head and tail methods. The
head method returns the first element of the List while tail returns the last
remaining after the first element. (Note that these can be called on an Array
as well, but tail will be very inefficient as it builds a new, shorter Array.)
The use of head and tail is particularly well suited for recursion.

.. code-block:: scala

   scala> def sumList(lst: List[Int]): Int = if lst.isEmpty then 0 else
        | lst.head + sumList(lst.tail)
   def sumList(lst: List[Int]): Int

   scala> sumList(List(1,2,3,4,5))
   val res5: Int = 15

This same function can be defined using a ``match`` expression and patterns in the following way.

.. code-block:: scala

   scala> def sumList(lst: List[Int]): Int = lst match
        | case Nil => 0
        | case h :: t => h + sumList(t)
   def sumList(lst: List[Int]): Int

Standard Methods
^^^^^^^^^^^^^^^^^^^^^^^^^^

The collection types in Scala have a large number of methods defined on them.
We won’t list them here. Instead, you can look in the [ScalaAPI]_ for the
names and details. This is what you get when you use tab completion in the
REPL on a List.

.. code-block:: scala

   scala> lst.<tab>
   !=                   eq                   lift                 size
   ##                   equals               map                  sizeCompare
   ++                   exists               mapConserve          sizeIs
   ++:                  filter               max                  slice
   +:                   filterNot            maxBy                sliding
   ->                   find                 maxByOption          sortBy
   /:                   findLast             maxOption            sortWith
   :+                   flatMap              min                  sorted
   :++                  flatten              minBy                span
   ::                   fold                 minByOption          splitAt
   :::                  foldLeft             minOption            startsWith
   :\                   foldRight            mkString             stepper
   ==                   forall               ne                   sum
   CombinationsItr      foreach              nn                   synchronized
   Maximized            formatted            nonEmpty             tail
   PermutationsItr      getClass             notify               tails
   addString            groupBy              notifyAll            take
   aggregate            groupMap             orElse               takeRight
   andThen              groupMapReduce       padTo                takeWhile
   appended             grouped              partition            tapEach
   appendedAll          hasDefiniteSize      partitionMap         to
   apply                hashCode             patch                toArray
   applyOrElse          head                 permutations         toBuffer
   asInstanceOf         headOption           prefixLength         toIndexedSeq
   canEqual             indexOf              prepended            toIterable
   collect              indexOfSlice         prependedAll         toIterator
   collectFirst         indexWhere           product              toList
   combinations         indices              reduce               toMap
   companion            init                 reduceLeft           toSeq
   compose              inits                reduceLeftOption     toSet
   concat               intersect            reduceOption         toStream
   contains             isDefinedAt          reduceRight          toString
   containsSlice        isEmpty              reduceRightOption    toTraversable
   copyToArray          isInstanceOf         repr                 toVector
   copyToBuffer         isTraversableAgain   reverse              transpose
   corresponds          iterableFactory      reverseIterator      unapply
   count                iterator             reverseMap           union
   diff                 knownSize            reverse_:::          unzip
   distinct             last                 runWith              unzip3
   distinctBy           lastIndexOf          runtimeChecked       updated
   drop                 lastIndexOfSlice     sameElements         view
   dropRight            lastIndexWhere       scan                 wait
   dropWhile            lastOption           scanLeft             withFilter
   elementWise          lazyZip              scanRight            zip
   empty                length               search               zipAll
   endsWith             lengthCompare        segmentLength        zipWithIndex
   ensuring             lengthIs             seq                  →



You might notice that there is a ``sum`` method, so the listSum written above is
something you never need to write yourself. There are also methods for converting
between types such as ``toList`` and ``toArray``.


Higher-Order Methods
^^^^^^^^^^^^^^^^^^^^^^^^^

Some of the methods in that list are worth describing instead of leaving it to
the reader to explore the API. In particular, the most commonly used higher-
order methods, like ``map`` and ``filter``, are used to a significant extent in Scala
programming. The ``foreach`` method is also helpful in a number of situations.

Higher-order methods are methods that take or return functions. In this
situation, we are considering methods that take a function as an argument. The
``filter`` method, for example, takes a function that takes one argument of the
type of the collection and returns a Boolean. That function is called on every
element of the collection. A new collection is produced that contains only the
elements for which the function returned true. To see how this is used,
consider the following code where we filter a List of Ints in two different
ways.

.. code-block:: scala

   scala> val lst = List(6,4,9,1,2,8,3,7)
   val lst: List[Int] = List(6, 4, 9, 1, 2, 8, 3, 7)

   scala> lst.filter(_ < 6)
   val res8: List[Int] = List(4, 1, 2, 3)

   scala> lst.filter(_ % 2 == 0)
   val res9: List[Int] = List(6, 4, 2, 8)

Both examples use the shorthand underscore syntax for writing the lambda
expressions/function literals. They could have been written using the longer
syntax as ``n => n < 6`` and ``n => n % 2 == 0`` respectively.

Another higher-order method that is used extensively is the ``map`` method
(one of our favorites). The argument passed into ``map`` is a function that takes
the type of the collection and returns something. The return type could be the
same as the input type, but it could be different. The map method returns a
new collection of the return type of the function. A first example will use
the list of integers from above and make a collection that contains values
that are twice the original values.

.. code-block:: scala

   scala> lst.map(_ * 2)
   val res10: List[Int] = List(12, 8, 18, 2, 4, 16, 6, 14)


To show that the types can be different, this second example shows mapping
Strings to their length.

.. code-block:: scala

   scala> val words = "This is a sentence with words".split(" ")
   val words: Array[String] = Array(This, is, a, sentence, with, words)

   scala> words.map(_.length)
   val res0: Array[Int] = Array(4, 2, 1, 8, 4, 5)

The ``foreach`` method takes a function and simply executes the function on all
the elements of the collection. While map and filter return new collections,
``foreach`` is used for its side effects and returns ``Unit``.

.. code-block:: scala

   scala> words.foreach(println)
   This
   is
   a
   sentence
   with
   words

There are other higher-order methods that are very accessible for introductory CS and DS students
such as ``count``, ``exists``, and ``forall``, all of which take predicate functions on a
single argument. There are more complex methods like the ``reduce`` methods and
``fold`` methods that can be very helpful, but which are more challenging for introductory CS and DS
students to understand. We use these occasionally in this workshop but recommmend
that they be used sparingly and with an emphasis on clarity (as opposed to conciseness).

Currying and By-Name Arguments
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The best ways to create large Arrays and Lists in Scala are with the ``fill`` and
``tabulate`` methods. These use some syntax that needs to be introduced. The first
element of new syntax is that these methods are *curried*. This means that the
arguments are broken across multiple argument lists. So instead of having
``f(x, y)`` you would have ``f(x)(y)``. This is a common feature of functional
programming languages and it is done to allow functions to be partially
applied. (A partial application means that you apply the function to a subset
of the arguments, which results in a new function of the remaining arguments.)
The syntax for defining a curried function in Scala is fairly
straightforward.

.. code-block:: scala

   scala> def currySum(x: Int)(y: Int) = x + y
   def currySum(x: Int)(y: Int): Int

   scala> currySum(3)(5)
   res2: Int = 8

   scala> val plus3 = currySum(3)
   val plus3: Int => Int = Lambda/0x000000d0016bece0@4f1d97d8

   scala> plus3(5)
   val res3: Int = 8


The second new element of the syntax is pass-by-name arguments. By default,
variables in Scala are passed in a manner similar to Java. The variables are
references and the references are passed by-value. With pass-by-name
semantics, the code is passed more like a function instead of by-value.
Instead of being evaluated at the call point, the code is wrapped in a “thunk”
(a term that originated with Algol 60). Every time the variable is used,  the
code is executed. We specify that a parameter is pass-by-name using a rocket
with no arguments.

.. code-block:: scala

   scala> def multiplyThrice(x: => Double) = x * x * x
   def multiplyThrice(x: => Double): Double

   scala> var i = 5
   var i: Int = 5

   scala> multiplyThrice(i)
   val res5: Double = 125.0

   scala> multiplyThrice({ i += 1; i })
   res6: Double = 336.0

Similarly to the ``match-case`` example above, if we want to get rid of the curly braces, we have to split the function call across two lines:

.. code-block:: scala

   scala> multiplyThrice:
        |   i += 1; i

The first invocation of ``multiplyThrice`` does what one would expect, even though
the argument is passed by-name.

We use call-by-name for timing blocks of code in the Monte Carlo :math:`\pi` example later
in this section. See :ref:`montecarlopi`.


Fill and Tabulate
^^^^^^^^^^^^^^^^^^^^^

The ``fill`` method, which is defined on the Array object, is...


Recursion for Iteration
--------------------------

.. code-block:: scala

   scala> def sum(n: Int): Int = if n <= 0 then 0 else n + sum(n - 1)
   def sum(n: Int): Int

   scala> sum(0)
   val res0: Int = 0

   scala> sum(1)
   val res1: Int = 1

   scala> sum(2)
   val res2: Int = 3

   scala> sum(3)
   val res3: Int = 6

   scala> sum(100)
   val res4: Int = 5050

Recursion does take awhile to master, but much of the trouble students have with it in practice
is a consequence of side-effect-full thinking. Nevertheless, you can replace this with a more
imperative (von Neumann) style. See our loops section.


Some introductory CS and DS Friendly Examples
---------------------------------------------

GCD
^^^^^

This is based on a classic algorithm by Euclid and one that is covered in many introductory computer science
courses. (See [GCD]_ for a more detailed discussion of this method and the ways it has been coded over the
years, especially in imperative programming languages.)

.. code-block:: scala

   scala> def gcd(a: Int, b: Int): Int = if b == 0 then a else gcd(b, a % b)
   def gcd(a: Int, b: Int): Int

The Scala version looks a lot like Euclid's definition!


Factorial
^^^^^^^^^^^^

This is the basic example that comes from [MiscExplorationsScala]_,
which also show show to use Scala and functional programming to rework explicitly recursive computations into
non-recursive versions using higher-order functional thinking.


This shows how to explicitly define the ``fac(n: Int): Int`` function.

.. code-block:: scala

   scala> def fac(n: Int): Int = if n <= 0 then 1 else n * fac(n - 1)
   def fac(n: Int): Int

The following example shows how to define a function *object*. It makes use of the literal syntax we introduced earlier,
You read this as ``fac`` is a function that maps Int into Int and binds the name ``n`` to the ``Int`` parameter.

.. code-block:: scala

   scala> val fac: Int => Int = n => if n <= 0 then 1 else n * fac(n - 1)
   val fac: Int => Int = Lambda/0x00000003015799f8@64508788


In many cases, you can write these functions without explcit recursion, simply by taking advantage of Scala's
innate collections:

.. code-block:: scala

   scala> def fac(n: Int): Int = (1 to n).foldLeft(1)((l, r) => l * r)
   def fac(n: Int): Int

Or even more concisely (and cryptically?)

.. code-block:: scala

   scala> def fac(n: Int): Int = (1 to n).foldLeft(1)(_ * _)
   def fac(n: Int): Int

We'll look more at higher-order thinking shortly. Many who think of functional programming (especially the 1960's
and 1970's style) tend to think Lisp, which very much required you to think *recursively* most of the time in
practice. Today, the recursive element is still there, but you'll find that the need to use it explicitly is
not required and can be replaced with higher-order abstractions. In the end, students still need to know about
this technique, if only to understand that certain methods (e.g. folds) often have a recursive nature to them.

In addition to rather outdated notions many tend to have about functional programming when it comes to recursion,
the optimization of recursive calls is achieved through a version of tail-recursion elimination (a.k.a. tail call
optimization). See [TailCalls]_ for more information.

.. _montecarlopi:

Monte Carlo Pi Calculation
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

An example that often resonates well with students is the Monte Carlo method,
which uses randomness to perform the :math:`\pi` computation. In the interests
of showing how Scala's approach to functional programming follows the textual
description, we will write the steps and show the code (in Scala) to perform
each step in an integrated fashion.

In the Monte Carlo method for calculating :math:`\pi`, we will randomly
generate a given number of darts using a Scala iterator. We *fire* the darts
into a unit circle, which is bounded by a square, whose dimensions are
:math:`2 \times 2` units.  The darts that fall within the unit circle satisfy the
constraint :math:`x^2 + y^2 \leq 1`.

Let's start by establishing the needed functions. First, here is the now-
familiar ``square(x:Double)`` function, again for reference.

.. code-block:: scala

   def square(x: Double) = x * x

We use this function to create another function, which tests whether a given
dart, specified as an (x, y) coordinate pair (a Scala tuple), falls within the
unit circle:

.. code-block:: scala

   val inCircle: ((Double, Double)) => Boolean = 
     case (x, y) => square(x) + square(y) <= 1.0

Let's to a quick sanity check here:

.. code-block:: scala

   scala> inCircle(0, 0)
   val res1: Boolean = true

   scala> inCircle(1, 1)
   val res2: Boolean = false

   scala> inCircle(0.7, 0.7)
   val res3: Boolean = true

   scala> inCircle(0.7, -0.7)
   val res4: Boolean = true

   scala> inCircle(1, -1)
   val res5: Boolean = false

So how do we generate a set of darts and test whether they fall within the
circle? We start by using a Scala iterator (more on this in collections).

.. code-block:: scala

   scala> val randomPairs = Iterator continually (math.random, math.random)
   val randomPairs: Iterator[(Double, Double)] = <iterator>


The "<iterator>"
indicates that there are values (an infinite number, in theory) that
can be obtained on demand. This principle is an advanced one but one that is
teachable and can be understood in greater detail later.

So how do we get a finite number of darts? This is where a number of famous
methods from functional programming come to play. One is known as ``take(n)``,
which can take however many we want. Let's use this to show how to print the
first 5 random coordinate pairs.

.. code-block:: scala

   scala> randomPairs.take(5)
   val res2: Iterator[(Double, Double)] = <iterator>

   scala> randomPairs.take(5).foreach(println)
   (0.6081069895961647,0.8798248629725995)
   (0.6481849430285651,0.9303049076616573)
   (0.04935640275866082,0.08890200833301021)
   (0.501359391302812,0.5846008917942399)
   (0.7474491411281527,0.8257238368222605)

So what is going on here? We're taking the first 5 coordinate pairs in the
iterator and applying the ``println()`` function to each item in the iterator
(that is, each coordinate pair). While there are some aspects of this that are
advanced, there are some aspects that are *vastly simpler* than their
equivalent in the legacy versions of imperative object-oriented languages (e.g. C++, Java,
C#), though modern C++ and Java have adopted similar APIs.

For example, we rely on the notion of a tuple (a pair of ``Double`` values),
which in legacy object-oriented languages requires the premature exploration of a ``Pair`` class in other
languages. Before long, you need to learn a lot of arcane type theory and syntax to
understand ``Pair``, whereas in Scala, the type information is *inferred*.

Looking more closely:

.. code-block:: scala

   scala> (math.random, math.random)
   val res10: (Double, Double) = (0.20679803333001656,0.91233235776938)

This generates a random pair, and it even *looks* like a random pair from mathematics. Of course, it's also type-safe!

So we're now near the point where we can put all of the pieces together. We have a function to determine whether a randomly generated coordinate pair falls within the unit circle. Let's compute :math:`\pi`.

.. code-block:: scala

   scala> val n = 1000000
   val n: Int = 1000000

   scala> val darts = randomPairs.take(n)
   val darts: Iterator[(Double, Double)] = <iterator>

   scala> val dartsInCircle = darts.count(inCircle)
   val dartsInCircle: Int = 785907

   scala> val area = 4.0 * dartsInCircle / n
   val area: Double = 3.143628


This is a good time to introduce the *dot-less* syntax, which is often associated with object-oriented programming but actually precedes these languages (C *struct* et al).

You can also write the above code (where you see dots) as follows:

.. code-block:: scala

   scala> val darts = randomPairs take n
   val darts: Iterator[(Double, Double)] = <iterator>

   scala> val dartsInCircle = darts count inCircle
   val dartsInCircle: Int = 784894

   scala> val area = 4.0 * dartsInCircle / n
   val area: Double = 3.139576

At some point, you realize that you want to enter the code into a text editor that can be loaded into
the Scala interpreter (as opposed to being entered interactively).

The actual code for this can be found at 
https://github.com/LoyolaChicagoCode/numerical-explorations-scala. You can 
pull up the Scala worksheet from ``MonteCarloPiIteratorChunkFree.sc`` (by drilling into Source).

Here's the final version of our function to calculate :math:`\pi`.

.. literalinclude:: ../../examples/numerical-explorations-scala/MonteCarloPiIteratorChunkFree.sc
   :language: scala
   :linenos:
   :start-after: begin-monteCarloCircleArea
   :end-before: end-monteCarloCircleArea

We also provide a simple *timing* function, that allows us to time a *block*
of Scala statements. We'll not present it in detail now, but this function
could be given to your students with the hope of  sensitizing them to the
notion of *performance*. It also shows the tremendous power available in Scala
to work with a block of Scala code as an object (which can produce a value).


.. literalinclude:: ../../examples/numerical-explorations-scala/MonteCarloPiIteratorChunkFree.sc
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
   and ``drop()`` with 64-bit Int values. 
   
   The  explanation for this is a bit
   beyond the scope here, but we have worked out 64-bit versions where we
   perform the Monte Carlo :math:`\pi` calculation in chunks. You can visit our
   repository for these versions, which are a bit complex compared to the Int
   version. We hope future versions of Scala will evolve beyond 32-bit
   thinking but don't see this as a show stopper for introductory teaching.
   
   We also hope the friendly competition between F# and Scala, where F#
   supports Int64, will eventually make its way to Scala. So far, the limiting factor has been the Java Virtual Machine (JVM) and the fact that it does not support 64-bit integers.


.. literalinclude:: ../../examples/numerical-explorations-scala/MonteCarloPiIteratorChunkFree.sc
   :language: scala
   :linenos:
   :start-after: begin-performance-study
   :end-before: end-performance-study


Here is the output (some output has been deleted for conciseness).

.. code-block:: scala

   scala> :load MonteCarloPiIteratorChunkFree.sc
   pi = 3.1408912 with 10000000 darts
   n = 1000000, t = 0.043675958, pi = 3.143128
   n = 10000000, t = 0.394970834, pi = 3.1414792
   n = 100000000, t = 3.788361375, pi = 3.14158032
   n = 1000000000, t = 38.134192792, pi = 3.141675596
   def square(x: Double): Double
   val inCircle: ((Double, Double)) => Boolean = Lambda/0x00000008015b4000@1018f702
   val randomPairs: Iterator[(Double, Double)] = <iterator>
   val totalDarts: Int = 10000000
   val darts: Iterator[(Double, Double)] = <iterator>
   val dartsInCircle: Int = 7852228
   val area: Double = 3.1408912
   def longDartsInCircle(numDarts: Int): Long
   def monteCarloCircleArea(numDarts: Int): Double
   def nanoTime[R](block: => R): (Double, R)
   def secondsTime[R](block: => R): (Double, R)
   val powers: scala.collection.immutable.Range.Inclusive = Range 1 to 9
   val sizes: IndexedSeq[Int] = Vector(10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000)


We will discuss performance and timing issues again when speaking to parallel computing in
:doc:`../70-parallel/parallel`.

More Scala
-----------------


While Loop
^^^^^^^^^^^^^^

In Scala, you can use imperative style, interactive loops; as noted above, these are *not* expressions.

Consider this interactive session to compute well-known example for sum

.. code-block:: scala

   scala> def sum(n: Int): Int =
        |   var i = 0
        |   var sum = 0
        |   while i <= n do
        |     sum = sum + n
        |     i = i + 1
        |   sum
   def sum(n: Int): Int

   scala> sum(100)
   val res5: Int = 10100

   scala> sum(0)
   val res6: Int = 0

Much is possible without iteration with the added advantage of being recursive and side-effect-free underneath the hood, using the built-in ``sum`` method.

.. code-block:: scala

   scala> def sum(n: Int) = (1 to n).sum
   def sum(n: Int): Int

   scala> sum(0)
   val res8: Int = 0

   scala> sum(100)
   val res9: Int = 5050

What about interactive loops?

.. code-block:: scala

   scala> import scala.io.StdIn.readLine

   scala> var response = 0
   var response: Int = 0

   scala> while response < 0 || response > 100 do
        |    response = readLine("Enter a number >= 0 and <= 100? ").toInt

   scala> var response = -1
   response: Int = -1

   scala> while response < 0 || response > 100 do
        |    response = readLine("Enter a number >= 0 and <= 100? ").toInt
   Enter a number >= 0 and <= 100? -5
   Enter a number >= 0 and <= 100? 105
   Enter a number >= 0 and <= 100? 100
   scala> ...

It is interesting to think about whether we can turn an interactive while loop into one without 
side effects. There are so many bad things that happen to us as introductory CS and DS educators when we work with
interactive loops:

- Improper initialization of the ``response`` variable.
- Improper setting of ``response`` upon termination.
- etc.

This is my early attempt to figure out how to have a side-effect free
interactive while loop. Basic idea: 

- Use ``Iterator.continually`` to get a continuous iterator of input lines
  read. 
- Use ``takeWhile`` to accept input until an appropriate terminating condition (the word "no" is entered)
- Convert each line to integer, if possible. We simplify exception
  management by applying a ``Try`` wrapper to each attempted
  conversion. ``Try`` is an important Scala idiom for representing a 
  computation that either succeeds with a result value or fails with
  an exception.  
- Use ``flatMap`` to get only the input values where the conversion
  succeeded. In the process of applying ``flatMap``, however, we need
  to convert each ``Try`` value to an ``Option`` value. ``Option`` is
  very similar to ``Try`` but simpler in that it represents all failures as
  ``None``, which ``flatMap`` discards from the resulting list.

.. code-block:: scala

   scala> val s1 = Iterator.continually(readLine("Prompt: "))
   val s1: Iterator[String] = <iterator>

   scala> val s = s1.takeWhile(_ != "no")
   val s: Iterator[String] = <iterator>

   scala> val l = s.toList
   Prompt: 25
   Prompt: 35
   Prompt: 55
   Prompt:
   Prompt: s
   Prompt: no
   val l: List[String] = List(25, 35, 55, "", s)

   scala> import scala.util.Try
   import scala.util.Try

   scala> def toInteger(s: String) = Try(s.toInt)
   def toInteger(s: String): scala.util.Try[Int]

   scala> l.map(toInteger)
   val res3: List[scala.util.Try[Int]] = List[scala.util.Try[Int]] = List(Success(25), Success(35), Success(55), Failure(java.lang.NumberFormatException: For input string: ""), Failure(java.lang.NumberFormatException: For input string: "s"))

   scala> l.map(t => toInteger(t).toOption)
   val res6: List[Option[Int]] = List(Some(25), Some(35), Some(55), None, None)

   scala> l.flatMap(t => toInteger(t).toOption)
   val res7: List[Int] = List(25, 35, 55) 

   scala> l.flatMap(t => toInteger(t).toOption).sum
   val res8: Int = 115


for loop
^^^^^^^^^^^^^

Similar to the while loop, a for loop exists for *imperative* style
programming, often when there is a need to do something where a
side-effect is needed.

.. code-block:: scala

   scala> var sum = 0
   var sum: Int = 0

   scala> var n = 100
   var n: Int = 100

   scala> for i <- 1 to n do
        |    sum = sum + i

   scala> println(s"The sum is $sum")
   The sum is 5050


for comprehension
^^^^^^^^^^^^^^^^^^^^^^

A for comprehension is designed for where you want a more functional style. That is, there is no intention 
of having side effects, and it is likely that you want to use the result of the comprehension in another
computation.

Let's look at something a bit more interesting: Getting the first ``n`` squares:

.. code-block:: scala

   scala> val n = 10
   val n: Int = 10

   scala> val first_n_squares = for i <- 1 to n yield i * i
   val first_n_squares: IndexedSeq[Int] = 
     Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)



You could wrap this up nicely in a Scala function as follows:

.. code-block:: scala

   scala> def squares(n: Int) = for i <- 1 to n yield i * i
   def squares(n: Int): IndexedSeq[Int]

   scala> squares(10)
   val res7: IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


options and failure sans exceptions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Per the Scala documentation: An option represents optional values. Instances
of Option are either an instance of scala.Some or the object None.

The Scala Option type is useful for dealing with the notion of success and
failure (but is not limited to supporting this concept). In the interests of
keeping this discussion focused on being introductory CS and DS-friendly, an Option is always
connected to an underlying type. For example Option[Int] means that you either
get the Int, or nothing (None).

.. code-block:: scala

   scala> val i = Some(3)
   val i: Some[Int] = Some(3)

   scala> val j = None
   val j: None.type = None


``Some`` and ``None`` are both *case classes* that extend ``Option[A]`` (a generic class that allows you
to use any time). While knowing all of the details requires a mastery of object-oriented programming (and 
perhaps more), the introduction of this idea is remarkably straightforward and one that can help students
to write better code from the beginning. In introductory CS and DS courses, we tend to spend a lot of time handling special
cases, and options give us a framework for dealing with missing information, etc.

As you can see from the above, ``i`` is defined as some value, in this case 3. It's a wrapped value, of course,
that must be unbundled later. For example, here is an attempt to use the value ``i`` (incorrectly):

.. code-block:: scala

   scala> i + 5
   -- [E008] Not Found Error: -----------------------------------------------------
   1 |i + 5
   |^^^
   |value + is not a member of Some[Int], but could be made available as an extension method.


So how do we make use of ``i`` and ``j``? A method associated with options, ``getOrElse`` allows us to get the
*option*, if set to *some* value. Rather delightfully, we can set a value to be used, if the option was not set
previously.

.. code-block:: scala

   scala> i getOrElse -1
   val res13: Int = 3

   scala> j getOrElse -1
   val res14: Int = -1

So now if we want to use this value in a computation, we can just do this:

.. code-block:: scala

   scala> i.getOrElse(-1) + j.getOrElse(-1)
   val res17: Int = 2

Options have their uses throughout Scala, notably its libraries. For example, maps (a.k.a. associative 
structures/arrays) use option to return the result of getting a key from the map:

.. code-block:: scala

   scala> val map = scala.collection.mutable.Map.empty[String, Int]
   val map: scala.collection.mutable.HashMap[String,Int] = HashMap()

   scala> map += ("scala" -> 10)
   val res4: scala.collection.mutable.Map[String, Int] = HashMap(scala -> 10)

   scala> map += ("java" -> 20)
   val res5: scala.collection.mutable.Map[String, Int] = HashMap(java -> 20, scala -> 10)

   scala> map += ("C#" -> 15)
   val res6: scala.collection.mutable.Map[String, Int] = HashMap(scala -> 10, java -> 20, C# -> 15)

   scala> map += ("F#" -> 25)
   val res7: scala.collection.mutable.Map[String, Int] = HashMap(scala -> 10, F# -> 25, java -> 20, C# -> 15)

   scala> map += ("scala" -> 22)
   val res8: scala.collection.mutable.Map[String, Int] = HashMap(scala -> 22, F# -> 25, java -> 20, C# -> 15)

Here's an attempt to get the case-sensitive and case-insensitive versions of key, F#, from the map:

.. code-block:: scala

   scala> map.get("F#")
   val res9: Option[Int] = Some(25)

   scala> map.get("f#")
   val res10: Option[Int] = None

Seasoned Java programmers know that an entry not found in the map will result in the *null* value being
returned. This differs from Scala, because the value gotten from the map must be *tested* before attempting
to use it in any way.

In Scala, because ``None`` and ``Some(25)`` are both options, you can use ``getOrElse`` to obtain the
options value (irrespective of whether the value is null, or not set) without writing an (unwanted) if-then-else
statement, which results in bloat (in most programming languages).

.. code-block:: scala

   scala> val entry = map.get("F#").getOrElse(-1)
   val entry: Int = 25

   scala> println(s"The entry for F# is $entry")
   The entry for F# is 25

It's often the case that we have *default* values associated with failure to
accomplish a certain task. The Option idiom is an attempt to standardize this
for core data structures and (as we'll see) other situations (e.g. working
with complex for comprehensions). In the case of maps, an entry not found
would usually default to 0 or -1 (a convention that dates back to the earliest
days of C), which is preferable to throwing exceptions for no good reason (not to 
mention our general dislike of prematurely covering exceptions as a programming
technique in introductory CS and DS in particular.)

yield
^^^^^^^^^

Yield is used to take a collection and produce a new one with mapped values.

Let's produce a List[Int] of squares from a List[Int] of the first three 
integers:

.. code-block:: scala

   scala> val l = List(1, 2, 3)
   val l: List[Int] = List(1, 2, 3)

   scala> l
   val res10: List[Int] = List(1, 2, 3)

   scala> for i <- l yield i * i
   val res11: List[Int] = List(1, 4, 9)

Let's try this with an Array[Int]:

.. code-block:: scala

   scala> val a = Array(1, 2, 3)
   val a: Array[Int] = Array(1, 2, 3)

   scala> for (i <- a) yield i * i
   val res16: Array[Int] = Array(1, 4, 9)

For the most part, when iterating over values and using yield, you will always get
back the same type, or another type that makes sense.

In these basic examples, the above can also be written as follows (without the for):

.. code-block:: scala

   scala> l map ( i => i * i )
   val res17: List[Int] = List(1, 4, 9)

   scala> a map ( i => i * i )
   val res18: Array[Int] = Array(1, 4, 9)


Ranges
^^^^^^^^^^

Ranges should be familiar to you if you've worked with other agile scripting languages, e.g. Python.

.. code-block:: scala

   scala> Range(1, 5)
   val res20: scala.collection.immutable.Range.Exclusive = Range 1 until 5

This gives a range of values from 1 to 5 but stopping at the last value before 5. The increment
is +1.

.. code-block:: scala

   scala> Range(1, 9, 2)
   res22: scala.collection.immutable.Range.Exclusive = Range 1 until 9 by 2

You can also work backwards:

.. code-block:: scala

   scala> Range(9, 0, -2)
   res24: scala.collection.immutable.Range.Exclusive = inexact Range 9 until 0 by -2




Multiple generators
^^^^^^^^^^^^^^^^^^^^^^^^



If guards
^^^^^^^^^^^^^^^^



Variables
^^^^^^^^^^^^^^^^



Patterns
^^^^^^^^^^^^^^^



Files
----------

- Can use Scanner
- scala.io.Source
- Scala Iterator[Char]
- getLines: Iterator[String]
- Use with higher-order methods
- Write with PrintWriter
- Introduce APIs?


Classes and Objects
---------------------------


Classes
^^^^^^^^^^^

Here is the familiar Point class. It's often shown where the (x, y) coordinate pair are Int (even in
the Scala documentation) but is even more interesting with Double. This is an elaborated version that
includes elements appropriate mostly to introductory CS and DS and some that are best covered in CS2 and beyond.

.. literalinclude:: ../../examples/introcs-scala-examples/worksheets/point.sc
   :language: scala
   :linenos:
   :start-after: begin-class-Point
   :end-before: end-class-Point

What does this class Point show?

- how to create a simple Scala class. Notice the complete lack of keyboards and public/private/static that
  tend to confuse students!

- Scala brings back *disciplined* operator overloading. We'd probably not use this in introductory CS and DS, but it is entirely
  appropriate for CS2.

- Shows how to refer to the object (familiarly) with ``this``. Again, the methods relying on this might be
  more appropriate for CS2 or even later courses that dive into OOP's complexity.

- Constructors? The Scala class definition itself makes it clear how one constructs an instance. Just like
  a function definition in general, there can be default values. It is liberating not to have constructors
  (especially too many of them), especially when trying to introduce a topic. (This will become readily
  apparent when we look at *case classes*, which provide a mechanism for more data-centric OO abstraction.)

- Convert an instance of class Point to a String representation using ``toString()``. ``toString()`` can be
  a valuable pedagogical tool, done right (as observed in languages like Python). Scala 2.10 gives us the
  ability to do type-safe string interpolation by substituting the value of variables (their String
  representation) into a String template. In Scala, prefixing a string literal with ``s`` will give you
  a string where any variables (beginning with ``$``) are substituted. Here, it allows us to get a beautiful
  representation of a point as an (x, y) pair with virtually no effort or complexity!

Let's take a look at how the ``Point`` class is used:

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/point.sc
   :language: scala
   :linenos:
   :start-after: begin-use-Point
   :end-before: end-use-Point

This results in the following output.

.. code-block:: text

   scala> :load point.sc
   Two points (2.0, 3.0) and (-2.0, 3.0)
   distance from p to origin = 3.605551275463989
   d(p,q) = 4.0
   d(q,p) = 4.0
   p.add(q) = (-2.0, 9.0); p + q = (-2.0, 9.0)
   Two points (2.0, 3.0) and (-2.0, 3.0)
   distance from p to origin = 3.605551275463989
   d(p,q) = 4.0
   d(q,p) = 4.0
   p.add(q) = (-2.0, 9.0); p + q = (-2.0, 9.0)
   // defined class Point
   val p: Point = (-2.0, 9.0)
   val q: Point = (-2.0, 3.0)
   val distanceToOrigin: Double = 3.605551275463989
   val dpq: Double = 4.0
   val dqp: Double = 4.0
   val pointSum: Point = (-2.0, 9.0)
   val pointSumOp: Point = (-2.0, 9.0)
   // defined object PointDemo


A Look at Singleton Objects
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

At some point, relying on the interpreter for trying out the Point class (as we have been doing until
now) grows a bit tedious. Furthermore, sometimes you want to have a complete, functioning program that
includes not just the class Point but also a driver program--often found in a ``main()`` method--that
allows you to run it from the command line.

Scala's answer to ``main()`` (largely a vestige of C-based languages) is to support *singleton objects*,
which we rely upon in some more advanced examples. While we consider the singleton pattern to be a bit 
overrated and overused (e.g. ``Runtime.getRuntime()`` and many others like it in Java's API), the 
singleton object as found here is completely decoupled from any class and allows you to create an 
*environment* so to speak with its own namespace but without the burden of a full class definition. 

In this example, we create a singleton object to act as our ``main()`` driver. 

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/point.sc
   :language: scala
   :linenos:
   :start-after: begin-object-PointDemo
   :end-before: end-object-PointDemo

Similar to a class definition, you *can* have methods. Notably absent, however, are any parameters to
the object name. To create an entry point that allows the object to be used like any other Scala function,
we define an ``apply()`` method, which may or may not have parameters. In our case, we just want to be able
to run the same demo code we produced previously and then invoke the PointDemo as a function, e.g.
``PointDemo()``. This could be further wrapped with some logic to handle command-line arguments, etc.
More on that towards the end.


Useful REPL functionality
-------------------------------

The Scala REPL supports a number of commands that can be greatly helpful for working interactively. We've
relied on many of these in the preparation of this tutorial but will focus on the highlights, especially
for use in introductory CS and DS teaching.

.. code-block :: text

   scala> :help
   The REPL has several commands available:

   :help                    print this summary
   :load <path>             interpret lines in a file
   :quit                    exit the interpreter
   :type <expression>       evaluate the type of the given expression
   :doc <expression>        print the documentation for the given expression
   :imports                 show import history
   :reset [options]         reset the repl to its initial state, forgetting all session entries
   :settings <options>      update compiler options, if possible
   :silent                  disable/enable automatic printing of results


load 
^^^^^^

Many programmers coming to Scala find it a bit frustrating at first that some things (like interactive
scripts, found in languages like Python) don't work quite the same way. More often than not, the real issue
is whether there is an easy way to load a script into the REPL--as opposed to having to run it on the 
command line (which is also possible but not the focus of this section). It is a matter of loading 
the filename, which may be an absolute or relative path.

.. code-block:: scala

   scala> :load myscript.scala

history
^^^^^^^^^^

History should be familiar to anyone who has used modern Unix shells. Even if you haven't, you've probably
used the history buffer, which allows you to use the up/down arrows or emacs/vi commands (^p, ^n, j, k) to 
access previous and next commands in the history buffer.

Scala also allows you to do ^r to perform a regex search for text within a previous command. We rely on
this heavily in our work, especially in this section, where it was necessary to look up previous attempts
within the REPL so they could be pasted into the notes!

In this example, I used ^r to search for the substring "val" so I could find a previous value definition in
my REPL session:

.. code-block:: scala

   scala> val entry = map.get("F#").getOrElse(-1)
   (back-i-search) `val_` 

When you type ^r, you'll be given the "(reverse-i-search)" prompt to perform a search. While the full 
functionality of regex is provided, the nominal use is to type a few characters of something you
probably remember (at least partially). More often than not, I am looking for previous "val" or "def" 
(functions).


Additional Resources
------------------------

.. [TailCalls] Tail Call, http://en.wikipedia.org/wiki/Tail_call

.. [GCD] Greatest Common Divisor, http://introcs.cs.luc.edu/html/gcdexamples.html

.. [MiscExplorationsScala] Miscellaneous Scala Explorations, https://github.com/lucproglangcourse/misc-explorations-scala

.. [ScalaAPI] Scala API Documentation, http://www.scala-lang.org/api/current/#package
