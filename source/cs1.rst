Scala in CS1
=====================

.. warning::

   This section is still in draft form but is nearly complete in terms of examples, subject to editing.
   There might still be a few rough spots. Comments welcome to gkt@cs.luc.edu.

.. highlight:: scala

This is an elaboration of our Google presentation slides: http://goo.gl/Q68fA.


Motivating Scala in CS1
---------------------------

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

   $ scala-2.10
   Welcome to Scala version 2.10.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_45).
   Type in expressions to have them evaluated.
   Type :help for more information.

   scala> println("Hello, World")
   Hello, World	


Types - "Lack" of Primitives
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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
   toString       unary_+        unary_-        unary_^        |


Literals are mostly what you expect
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Integers

.. code-block:: scala

   scala> val a = 95
   a: Int = 95

   scala> val b = -95
   b: Int = -95

Octal and Hexadecimal

.. code-block:: scala

   scala> val c = 039
   <console>:1: error: malformed integer number
          val c = 039
                  ^

   scala> val c = 037
   warning: there were 1 deprecation warning(s); re-run with -deprecation for details
   c: Int = 31

   scala> val d = 0xff
   d: Int = 255

   scala> val d = 0xffac
   d: Int = 65452

Double and Float

.. code-block:: scala

   scala> val e = 1.34e-7
   e: Double = 1.34E-7

   scala> val f = 1.34e-7f
   f: Float = 1.34E-7


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
   %              &              *              +              -
   /              >              >=             >>             >>>
   ^              asInstanceOf   isInstanceOf   toByte         toChar
   toDouble       toFloat        toInt          toLong         toShort
   toString       unary_+        unary_-        unary_^        |

Where you see ``<tab>``, you can use a feature known as *tab completion* in the REPL to see the options
available to value ``a``. You'll notice one thing immediately, especially if you are familiar with Java: 
operator overloading! That's right, every operator is a method.

Let's use the ``+`` method:

.. code-block:: scala

   scala> a.+(3)
   res5: Int = 98

   scala> a + 3
   res6: Int = 98


Let's convert an Int to a Float:

.. code-block:: scala

   scala> val b = a.toFloat
   b: Float = 95.0

You can also invoke methods like ``toFloat`` (which take no parameters) without using dots. We will
take advantage of this syntax as part of good Scala style (in many of our examples).

.. code-block:: scala

   scala> val b = a.toFloat
   b: Float = 95.0

We're going to look at more *advanced* objects later (Scala collections) but this should give you
a taste of what is possible.

Tuples
^^^^^^^^

A language feature that was popularized (but not invented) by the Python language are tuples. Tuples
eliminate the need for unwanted uses of a class for grouping multiple values. Let's take a quick 
look.

.. code-block:: scala

   scala> val t = (3, 4)
   t: (Int, Int) = (3,4)

   scala> val u = (3.0, 4.0)
   u: (Double, Double) = (3.0,4.0)

   scala> val v = (3.0, 4)
   v: (Double, Int) = (3.0,4)

Notice that Scala infers the type of each one of these value definitions. 

When working with a tuple, you're really working with an object. You can inspect the methods that 
are available using the tab completion method shown previously.

.. code-block:: scala

   scala> t.
   _1                _2                asInstanceOf      canEqual
   copy              isInstanceOf      productArity      productElement
   productIterator   productPrefix     swap              toString

   scala> u.
   _1                _2                asInstanceOf      canEqual
   copy              isInstanceOf      productArity      productElement
   productIterator   productPrefix     swap              toString

   scala> v.
   _1                _2                asInstanceOf      canEqual
   copy              isInstanceOf      productArity      productElement
   productIterator   productPrefix     swap              toString

You can inspect the components of a tuple by using the ``_1``, ``_2``, ... methods.

.. code-block:: scala

   scala> t._1
   res9: Int = 3

   scala> t._2
   res10: Int = 4

You'll obviously not want to use these names to refer to the components of a tuple. Using
pattern matching, you can extract the components of a tuple and *bind* them to proper names.
For example, if your tuple represents an (x, y) pair, you are likely to use a match expression
like this:

.. code-block:: scala

   scala> t match { case (x, y) => println(s"($x, $y)") }
   (3, 4)


Semicolon Inferencing
^^^^^^^^^^^^^^^^^^^^^^^^

Python programmers already know and love not having to deal with semicolons. Scala follows
this excellent practice as well.

You can do this:

.. code-block:: scala

   scala> val x = 30;
   x: Int = 30


But this works just as well and is the preferred way to write Scala code:

.. code-block:: scala

   scala> val y = 30
   y: Int = 30

Simple Input (and Output)
^^^^^^^^^^^^^^^^^^^^^^^^^^^

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

We'll be taking advantage of this a bit more in our discussion about ``sbt``, the Scala Build Tool.

Conditional and Functions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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
^^^^^^^^^^^^^^^^^^^^^^

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
   res16: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how to map a *function literal* to the range of values. 

.. code-block:: scala

   scala> first_n map (n => n * n)
   res17: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

This shows how you can combine a function literal with a previously defined function:

.. code-block:: scala

   scala> first_n map (n => square(n))
   res18: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


You can avoid having to name arguments in function literals using the ``_`` parameter. This syntax is a 
bit awkward to new programmers (and therefore should be introduced gently in CS1 courses) but allows
for concise (and sometimes clearer) expression, especially when used in a disciplined way.

Consider this code that creates the first n even numbers:

.. code-block:: scala

   scala> 1 to 10 map (_ * 2)
   res26: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

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

Early Collection, Arrays and Lists
--------------------------------------

Scala has some very advanced and comprehensive collections libraries. For CS1
you can focus only on the simplest of these, beginning with Arrays and Lists.
In actually makes sense to introduce these before loops (and iteration in
general) in Scala for two reasons. First, the collections have many methods
that allow you to do standard tasks that would often go in loops. As such,
Scala code often doesn’t include all that many loops. Second, the for loop in
Scala is really a foreach type loop that works with collections so it makes
more sense to introduce it after the basic collections.

Making Arrays and Lists
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The simplest way to make an Array or a List is with the following syntax.

.. code-block:: scala

   scala> Array(1,2,3,4)
   res0: Array[Int] = Array(1, 2, 3, 4)

   scala> List(1.3,4.2,3.14)
   res1: List[Double] = List(1.3, 4.2, 3.14)


Note that the Array and List types take type parameters. These appear in
square brackets. It is standard across the Scala language that value arguments
appear in parentheses, type arguments appear in square brackets, and curly
braces are used to denote code blocks for complex expressions or statements.
Also note that as before, Scala’s type inference figures out the types for
these expressions.

.. note::

   Technically these are making calls to the apply methods of the Array and
   List companion objects. The details of how that works don’t really matter
   in CS1, but you can find them in the section on object-orientation under
   CS2. We cover this topic later in our discussion of classes and 
   objects.

You can also made longer arrays using the new syntax that one uses in Java.

.. code-block:: scala

   scala> new Array[Int](100)
   res2: Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
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
   res4: List[Int] = List(1, 2, 3, 4)


The ``Nil`` object is a short name for an empty List. You can also use
``List()`` (the empty list) in place of ``Nil``. Note that the List type is a
singly-linked, *immutable* list. So prepending as shown above is an efficient
operation. Also note that you can’t change values without making a new List
because it is immutable.

This form of building a List with ``::`` is probably most beneficial with
recursive functions and works very well in situations where you don’t know how
many values you will be working with.

.. code-block:: scala

   scala> def readNumbers(n:Int):List[Int] = if(n<1) Nil else 
        | readInt :: readNumbers(n-1)
   readNumbers: (n: Int)List[Int]

   scala> readNumbers(5)
   1
   2
   3
   4
   5
   res6: List[Int] = List(1, 2, 3, 4, 5)

   scala> def readUntilQuit():List[Int] = {
        | val data = readLine
        | if(data!="quit") data.toInt :: readUntilQuit() else Nil
        | }
   readUntilQuit: ()List[Int]

   scala> readUntilQuit()
   1
   2
   3
   4
   5
   quit
   res7: List[Int] = List(1, 2, 3, 4, 5)


Indexing/Traversing Arrays and Lists
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

You can get to values in an Array or a List by indexing with parentheses.

.. code-block:: scala

   scala> val arr = Array(6,8,2,4,1)
   arr: Array[Int] = Array(6, 8, 2, 4, 1)

   scala> val lst = List('g','e','o','r','g','e')
   lst: List[Char] = List(g, e, o, r, g, e)

   scala> arr(2)
   res1: Int = 2

   scala> lst(2)
   res2: Char = o

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
   res4: Array[Int] = Array(6, 8, 99, 4, 1)

The common way to run through a List is using the head and tail methods. The
head method returns the first element of the List while tail returns the last
remaining after the first element. (Note that these can be called on an Array
as well, but tail will be very inefficient as it builds a new, shorter Array.)
The use of head and tail is particularly well suited for recursion.

.. code-block:: scala

   scala> def sumList(lst:List[Int]):Int = if(lst.isEmpty) 0 else
        | lst.head+sumList(lst.tail)
   sumList: (lst: List[Int])Int

   scala> sumList(List(1,2,3,4,5))
   res5: Int = 15

This same function can be defined using a match and patterns in the following
way.

.. code-block:: scala

   scala> def sumList(lst:List[Int]):Int = lst match {
        | case Nil => 0
        | case h::t => h + sumList(t)
        | }
   sumList: (lst: List[Int])Int

Standard Methods
^^^^^^^^^^^^^^^^^^^^^^^^^^

The collection types in Scala have a large number of methods defined on them.
We won’t list them here. Instead, you can look in the [ScalaAPI]_ for the
names and details. This is what you get when you use tab completion in the
REPL on a List.

.. code-block:: scala

   scala> lst.<tab>
   ++                   ++:                  +:                   
   /:                   /:\                  :+                   
   ::                   :::                  :\                   
   addString            aggregate            andThen              
   apply                applyOrElse          asInstanceOf         
   canEqual             collect              collectFirst         
   combinations         companion            compose              
   contains             containsSlice        copyToArray          
   copyToBuffer         corresponds          count                
   diff                 distinct             drop                 
   dropRight            dropWhile            endsWith             
   exists               filter               filterNot            
   find                 flatMap              flatten              
   fold                 foldLeft             foldRight            
   forall               foreach              genericBuilder       
   groupBy              grouped              hasDefiniteSize      
   head                 headOption           indexOf              
   indexOfSlice         indexWhere           indices              
   init                 inits                intersect            
   isDefinedAt          isEmpty              isInstanceOf         
   isTraversableAgain   iterator             last                 
   lastIndexOf          lastIndexOfSlice     lastIndexWhere       
   lastOption           length               lengthCompare        
   lift                 map                  mapConserve          
   max                  maxBy                min                  
   minBy                mkString             nonEmpty             
   orElse               padTo                par                  
   partition            patch                permutations         
   prefixLength         product              productArity         
   productElement       productIterator      productPrefix        
   reduce               reduceLeft           reduceLeftOption     
   reduceOption         reduceRight          reduceRightOption    
   removeDuplicates     repr                 reverse              
   reverseIterator      reverseMap           reverse_:::          
   runWith              sameElements         scan                 
   scanLeft             scanRight            segmentLength        
   seq                  size                 slice                
   sliding              sortBy               sortWith             
   sorted               span                 splitAt              
   startsWith           stringPrefix         sum                  
   tail                 tails                take                 
   takeRight            takeWhile            to                   
   toArray              toBuffer             toIndexedSeq         
   toIterable           toIterator           toList               
   toMap                toSeq                toSet                
   toStream             toString             toTraversable        
   toVector             transpose            union                
   unzip                unzip3               updated              
   view                 withFilter           zip                  
   zipAll               zipWithIndex 


You might notice that there is a sum method, so the listSum written above is
something you never need to write. There are also methods for converting
between types such at toList and toArray.


Higher Order Methods
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
   lst: List[Int] = List(6, 4, 9, 1, 2, 8, 3, 7)

   scala> lst.filter(_ < 6)
   res8: List[Int] = List(4, 1, 2, 3)

   scala> lst.filter(_ % 2 == 0)
   res9: List[Int] = List(6, 4, 2, 8)

Both examples use the shorthand underscore syntax for writing the lambda
expressions/function literals. They could have been written using the longer
syntax as ``n => n<6`` and ``n => n%2 == 0`` respectively.

Another higher-order method that is used extensively is the ``map`` method
(one of our favorites). The argument passed into ``map`` is a function that takes
the type of the collection and returns something. The return type could be the
same as the input type, but it could be different. The map method returns a
new collection of the return type of the function. A first example will use
the list of integers from above and make a collection that contains values
that are twice the original values.

.. code-block:: scala

   scala> lst.map(_*2)
   res10: List[Int] = List(12, 8, 18, 2, 4, 16, 6, 14)


To show that the types can be different, this second example shows mapping
Strings to their length.

.. code-block:: scala

   scala> val words = "This is a sentence with words".split(" ")
   words: Array[String] = Array(This, is, a, sentence, with, words)

   scala> words.map(_.length)
   res0: Array[Int] = Array(4, 2, 1, 8, 4, 5)

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

There are other higher-order methods that are very accessible for CS1 students
such as ``count``, ``exists``, and ``forall``, all of which take predicate functions on a
single argument. There are more complex methods like the ``reduce`` methods and
``fold`` methods that can be very helpful, but which are more challenging for CS1
students to understand. We use these occasionally in this workshop but recommmend
that they be used sparingly and with an emphasis on clarity (as opposed to conciseness).

Currying and By-Name Arguments
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

The best ways to create large Arrays and Lists in Scala are with the ``fill`` and
``tabulate`` methods. These use some syntax that needs to be introduced. The first
element of new syntax is that these methods are *curried*. This means that the
arguments are broken across multiple argument lists. So instead of having
``f(x,y)`` you would have ``f(x)(y)``. This is a common feature of functional
programming languages and it is done to allow functions to be partially
applied. (A partial application means that you apply the function to a subset
of the arguments, which results in a new function of the remaining arguments.)
The syntax for defining a curried function in Scala is fairly
straightforward.

.. code-block:: scala

   scala> def currySum(x:Int)(y:Int) = x+y
   currySum: (x: Int)(y: Int)Int

   scala> currySum(3)(5)
   res2: Int = 8

   scala> val plus3 = currySum(3)_
   plus3: Int => Int = <function1>

   scala> plus3(5)
   res3: Int = 8


The need for the underscore in the partially applied call removes ambiguity in
the Scala syntax. Often functions are curried in Scala to help with type
inference or to simplify the syntax for calling them.

The second new element of the syntax is pass-by-name arguments. By default,
variables in Scala are passed in a manner similar to Java. The variables are
references and the references are passed by-value. With pass-by-name
semantics, the code is passed more like a function instead of by-value.
Instead of being evaluated at the call point, the code is wrapped in a “thunk”
(a term that originated with Algol 60). Every time the variable is used,  the
code is executed. We specify that a parameter is pass-by-name using a rocket
with no arguments.

.. code-block:: scala

   scala> def multiplyThrice(x: => Double) = x*x*x
   multiplyThrice: (x: => Double)Double

   scala> var i = 5
   i: Int = 5

   scala> multiplyThrice(i)
   res5: Double = 125.0

   scala> multiplyThrice({i += 1; i})
   res6: Double = 336.0


The first invocation of ``multiplyThrice`` does what one would expect, even though
the argument is passed by-name.

We use call-by-name for timing blocks of code in the Monte Carlo Pi example later
in this section. See :ref:`montecarlopi`.

Fill and Tabulate
^^^^^^^^^^^^^^^^^^^^^

The fill method, which is defined on the Array object, is...

Recursion for Iteration
--------------------------

.. code-block:: scala

   scala> def sum(n : Int) : Int = if (n <= 0) 0 else n + sum(n-1)
   sum: (n: Int)Int

   scala> sum(0)
   res0: Int = 0

   scala> sum(1)
   res1: Int = 1

   scala> sum(2)
   res2: Int = 3

   scala> sum(3)
   res3: Int = 6

   scala> sum(100)
   res4: Int = 5050

Recursion does take awhile to master, but much of the trouble students have with it in practice
is a consequence of side-effect-full thinking. Nevertheless, you can replace this with a more
imperative (von Neumann) style. See our loops section.


Some CS1 Friendly Examples
------------------------------

GCD
^^^^^

This is based on a classic algorithm by Euclid and one that is covered in many introductory computer science
courses. (See [GCD]_ for a more detailed discussion of this method and the ways it has been coded over the
years, especially in imperative programming languages.)

.. code-block:: scala

   def gcd(a : Int, b : Int) = if (b == 0) a else gcd(b, a % b)

The Scala version looks a lot like Euclid's definition!


Factorial
^^^^^^^^^^^^

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

.. _montecarlopi:

Monte Carlo :math:`\pi` Calculation
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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
   randomPairs: scala.collection.immutable.Stream[(Double, Double)] = 
      Stream((0.45422625790687077,0.1916739269602844), ?)


.. note::

   The examples we are showing here, much like typical introductory examples, trade good 
   pedagogy (not bogging down students with too many details) for performance and scalability.
   If you need to operate on a larger number of darts, you'll want to take advantage of ``StreamIterator``, not ``Stream``. A StreamIterator can be obtained from a Stream by reworking the code above as 
   follows:

   .. code-block:: scala

      scala> val randomPairs = Stream continually (math.random, math.random) iterator
      randomPairs: scala.collection.immutable.Stream[(Double, Double)] = 
         Stream((0.45422625790687077,0.1916739269602844), ?)

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
   res7: scala.collection.immutable.Stream[(Double, Double)] = 
      Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> randomPairs.take(5).foreach(println)
   (0.45422625790687077,0.1916739269602844)
   (0.9252028282996272,0.5638265909110913)
   (0.5588908846857542,0.21516929857230815)
   (0.5842149396390998,0.7226255374753748)
   (0.8454163994561401,0.6805038035803781)

So what is going on here? We're taking the first 5 coordinate pairs in the
stream and applying the ``println()`` function to each item in the stream
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

This generates a random pair, and it even *looks* like a random pair from mathematics. Of course, it's also type-safe!

So we're now near the point where we can put all of the pieces together. We have a function to determine whether a randomly generated coordinate pair falls within the unit circle. Let's compute :math:`\pi`.

.. code-block:: scala

   scala> val n = 1000000
   n: Int = 1000000

   scala> val darts = randomPairs.take(n)
   darts: scala.collection.immutable.Stream[(Double, Double)] = 
      Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> val dartsInCircle = darts.count(inCircle)
   dartsInCircle: Int = 784894

   scala> val totalDarts = darts.length
   totalDarts: Int = 1000000

   scala> val area = 4.0 * dartsInCircle / totalDarts
   area: Double = 3.139576

This is a good time to introduce the *dot-less* syntax, which is often associated with object-oriented programming but actually precedes these languages (C *struct* et al).

You can also write the above code (where you see dots) as follows:

.. code-block:: scala

   scala> val darts = randomPairs take n
   darts: scala.collection.immutable.Stream[(Double, Double)] = 
      Stream((0.45422625790687077,0.1916739269602844), ?)

   scala> val dartsInCircle = darts count inCircle
   dartsInCircle: Int = 784894

   scala> val totalDarts = darts length
   totalDarts: Int = 1000000

   scala> val area = 4.0 * dartsInCircle / totalDarts
   area: Double = 3.139576

At some point, you realize that you want to enter the code into a text editor that can be loaded into
the Scala interpreter (as opposed to being entered interactively).

The actual code for this can be found at 
https://bitbucket.org/loyolachicagocs_plsystems/numerical-explorations-scala. You can 
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
   perform the Monte Carlo :math:`\pi` calculation in chunks. You can visit our
   repository for these versions, which are a bit complex compared to the Int
   version. We hope future versions of Scala will evolve beyond 32-bit
   thinking but don't see this as a show stopper for  introductory teaching.
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
   randomPairs: Iterator[(Double, Double)] = non-empty iterator
   n: Int = 1000000
   darts: Iterator[(Double, Double)] = non-empty iterator
   dartsInCircle: Int = 785719
   totalDarts: Int = 0
   area: Double = Infinity
   longDartsInCircle: (numDarts: Int)Long
   monteCarloCircleArea: (numDarts: Int)Double
   time: [R](block: => R)R
   powers: scala.collection.immutable.Range.Inclusive = 
      Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
   sizes: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000)
   problemSizes: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1000000, 10000000, 100000000, 1000000000)
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

More Scala
-----------------


While Loop
^^^^^^^^^^^^^^

- While loop
- Not an expression

In Scala, you can do imperative style loops and interactive loops:

Consider this interactive session to compute well-known example for sum

.. code-block:: scala

   scala> def sum(n : Int) : Int = {
        |   var i = 0
        |   var sum = 0
        |   while (i <= n) {
        |     sum = sum + n
        |     i = i + 1
        |   }
        |   sum
        | }
   sum: (n: Int)Int

   scala> sum(100)
   res5: Int = 10100

   scala> sum(0)
   res6: Int = 0

Much is possible without iteration with the added advantage of being recursive and side-effect
free underneath the hood.

   scala> def sum(n : Int) = (1 to n).sum
   sum: (n: Int)Int

   scala> sum(0)
   res8: Int = 0

   scala> sum(100)
   res9: Int = 5050

What about interactive loops?

.. code-block:: scala

   scala> val reader = new ConsoleReader
   reader: scala.tools.jline.console.ConsoleReader = 
      scala.tools.jline.console.ConsoleReader@26075b18

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
   scala> ...

It is interesting to think about whether we can turn an interactive while loop into one without 
side effects. There are so many bad things that happen to us as CS1 educators when we work with
interactive loops:

- Improper initialization of the ``response`` variable.
- Improper setting of ``response`` upon termination.
- etc.

This is my early attempt to figure out how to have a side-effect free
interactive while loop. Basic idea: 

- Use ``Stream.continually`` to get a continuous stream of input lines
  read. 
- Because ``Stream`` is lazy only in the tail, assume a blank line as
  the first value of the stream (which is safely ignored). I'd like to
  figure out the right way to eliminate this without introducing complexity.
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

   scala> val s1 = "" #:: Stream.continually(reader.readLine("Prompt: "))
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

   scala> import scala.util.Try
   import scala.util.Try

   scala> def toInteger(s: String) = Try(s.toInt)
   toInteger: (s: String)scala.util.Try[Int]

   scala> l.map(toInteger)
   res3: List[scala.util.Try[Int]] = List(Failure(java.lang.NumberFormatException: For input string: ""), Success(25), Success(35), Success(55), Failure(java.lang.NumberFormatException: For input string: ""), Failure(java.lang.NumberFormatException: For input string: "s"))

   scala> l.map(t => toInteger(t).toOption)
   res6: List[Option[Int]] = List(None, Some(25), Some(35), Some(55), None, None)

   scala> l.flatMap(t => toInteger(t).toOption)
   res7: List[Int] = List(25, 35, 55) 

   scala> l.flatMap(t => toInteger(t).toOption).sum
   res8: Int = 115

for loop
^^^^^^^^^^^^^

Similar to the while loop, a for loop exists for *imperative* style
programming, often when there is a need to do something where a
side-effect is needed.

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
^^^^^^^^^^^^^^^^^^^^^^

A for comprehension is designed for where you want a more functional style. That is, there is no intention 
of having side effects, and it is likely that you want to use the result of the comprehension in another
computation.

Let's look at something a bit more interesting: Getting the first ``n`` squares:

.. code-block:: scala

   scala> val n = 10
   n: Int = 10

   scala> val first_n_squares = for (i <- 1 to n) yield { i * i }
   first_n_squares: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


You could wrap this up nicely in a Scala function as follows:

.. code-block:: scala

   scala> def squares(n : Int) = for (i <- 1 to n) yield { i * i }
   squares: (n: Int)scala.collection.immutable.IndexedSeq[Int]

   scala> squares(10)
   res7: scala.collection.immutable.IndexedSeq[Int] = 
      Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)


options and failure sans exceptions
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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


So how do we make use of ``i`` and ``j``? A method associated with options, ``getOrElse`` allows us to get the
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

In Scala, because ``None`` and ``Some(25)`` are both options, you can use ``getOrElse`` to obtain the
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

yield
^^^^^^^^^

Yield is used to take a collection and produce a new one with mapped values.

Let's produce a List[Int] of squares from a List[Int] of the first three 
integers:

.. code-block:: scala

   scala> val l = List(1, 2, 3)
   l: List[Int] = List(1, 2, 3)

   scala> l
   res10: List[Int] = List(1, 2, 3)

   scala> for (i <- l) yield { i * i }
   res11: List[Int] = List(1, 4, 9)

Let's try this with an Array[Int]:

.. code-block:: scala

   scala> val a = Array(1, 2, 3)
   a: Array[Int] = Array(1, 2, 3)

   scala> for (i <- a) yield i * i
   res16: Array[Int] = Array(1, 4, 9)

For the most part, when iterating over values and using yield, you will always get
back the same type, or another type that makes sense.

In these basic examples, the above can also be written as follows (without the for):

.. code-block:: scala

   scala> l map (i => i * i)
   res17: List[Int] = List(1, 4, 9)

   scala> a map (i => i * i)
   res18: Array[Int] = Array(1, 4, 9)


Ranges
^^^^^^^^^^

Ranges should be familiar to you if you've worked with other agile scripting languages, e.g. Python.

.. code-block:: scala

   scala> Range(1, 5)
   res20: scala.collection.immutable.Range = Range(1, 2, 3, 4)

This gives a range of values from 1 to 5 but stopping at the last value before 5. The increment
is +1.

.. code-block:: scala

   scala> Range(1, 9, 2)
   res22: scala.collection.immutable.Range = Range(1, 3, 5, 7)

You can also work backwards:

.. code-block:: scala

   scala> Range(9, 0, -2)
   res24: scala.collection.immutable.Range = Range(9, 7, 5, 3, 1)


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
- getLines : Iterator[String]
- Use with higher-order methods
- Write with PrintWriter
- Introduce APIs?


Classes and Objects
---------------------------


Classes
^^^^^^^^^^^

Here is the familiar Point class. It's often shown where the (x, y) coordinate pair are Int (even in
the Scala documentation) but is even more interesting with Double. This is an elaborated version that
includes elements appropriate mostly to CS1 and some that are best covered in CS2 and beyond.

.. literalinclude:: ../examples/introcs-scala-examples/point.sc
   :language: scala
   :linenos:
   :start-after: begin-class-Point
   :end-before: end-class-Point

What does this class Point show?

- how to create a simple Scala class. Notice the complete lack of keyboards and public/private/static that
  tend to confuse students!

- Scala brings back *disciplined* operator overloading. We'd probably not use this in CS1, but it is entirely
  appropriate for CS2.

- Shows how to refer to the object (familiarly) with ``this``. Again, the methods relying on this might be
  more appropriate for CS2 or even later courses that dive into OOP's complexity.

- Constructors? The Scala class definition itself makes it clear how one constructs an instance. Just like
  a function definition in general, there can be default values. It is liberating not to have constructors
  (especially too many of them), especially when trying to introduce a topic. (This will become readily
  apparent when we look at *case classes*, which provide a mechanism for more data-centric OO abstraction.)

- Convert an instance of class Point to a String representation using ``ToString()``. ``ToString()`` can be
  a valuable pedagogical tool, done right (as observed in languages like Python). Scala 2.10 gives us the
  ability to do type-safe string interpolation by substituting the value of variables (their String
  representation) into a String template. In Scala, prefixing a string literal with ``s`` will give you
  a string where any variables (beginning with ``$``) are substituted. Here, it allows us to get a beautiful
  representation of a point as an (x, y) pair with virtually no effort or complexity!

Let's take a look at how the ``Point`` class is used:

.. literalinclude:: ../examples/introcs-scala-examples/point.sc
   :language: scala
   :linenos:
   :start-after: begin-use-Point
   :end-before: end-use-Point

This results in the following output.

.. code-block:: text

   scala> :load point.sc
   :load point.sc
   Loading point.sc...
   defined class Point
   p: Point = (2.0, 3.0)
   q: Point = (-2.0, 3.0)
   Two points (2.0, 3.0) and (-2.0, 3.0)
   distanceToOrigin: Double = 3.605551275463989
   distance from p to origin = 3.605551275463989
   dpq: Double = 4.0
   dqp: Double = 4.0
   d(p,q) = 4.0
   d(q,p) = 4.0
   pointSum: Point = (0.0, 6.0)
   pointSumOp: Point = (-2.0, 9.0)
   p.add(q) = (-2.0, 9.0); p + q = (-2.0, 9.0)


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

.. literalinclude:: ../examples/introcs-scala-examples/point.sc
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
for use in CS1 teaching.

.. code-block :: text

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
^^^^^^^^

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

.. [ScalaAPI] Scala API Documentation, http://www.scala-lang.org/api/current/#package
