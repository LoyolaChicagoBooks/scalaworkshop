Scala and Data Structures
#########################

.. warning::

   This section is not ready yet. Working on it!
   
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

Simple GUI Example
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This example shows a simple GUI where there is no inheritance.
Clicking the button increments the number in the text field. If the user
has changed it so that it is not an integer, it is set back to 0.

Those familiar with Java will notice a lot of similarities. This is because
the scala.swing library is a wrapper around Java's Swing library. The
ideas are similar, but the way in which you interact with them has been
changed to match the Scala style.

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGUI.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGUI
   :end-before: end-SimpleGUI


Simple GUI Example using scala.util.Try
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Scala supports simplified exception handling through its
``scala.util.Try`` wrapper type. This is an important Scala idiom for
representing a computation that either succeeds with a result value or
fails with an exception.

For example, say you want to validate and convert a text field in your
UI from string to integer. You could write this simple conversion
function to do so:

.. code-block:: scala

   scala> def toInteger(s: String) = scala.util.Try(s.toInt)
   toInteger: (s: String)scala.util.Try[Int]

   res0: scala.util.Try[Int] = Failure(java.lang.NumberFormatException: For input string: "blah")

   scala> toInteger("35")
   res1: scala.util.Try[Int] = Success(35)

Then you can use ``getOrElse`` to process the enclosed value and, if
the ``Try`` value represents failure, return the given default value
(as you see above when we tried to validate the string "blah").

.. code-block:: scala

   scala> toInteger("35").getOrElse(-1)
   res2: Int = 35

   scala> toInteger("blah").getOrElse(-1)
   res3: Int = -1

It's clear that being able to validate input efficiently is something
that excites us. It certainly makes UI development more reliable and
resilient to failures. (We've had more than our share of fun chasing
down validation bugs in web and mobile app development. Most of the
time it is caused by unnecessarily complex validation logic.)

You can see how this plays out in a slightly reworked version of the code:

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGUI2.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGUI2
   :end-before: end-SimpleGUI2

Simple Paint Example
~~~~~~~~~~~~~~~~~~~~~~~~~

This example shows how you can override the paint method to make a
custom drawing. It also shows interactions with the mouse.


.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimplePaint.sc
   :language: scala
   :linenos:
   :start-after: begin-SimplePaint
   :end-before: end-SimplePaint

Here's what the output looks like when you drag the mouse quasi-randomly on
the blank canvas that first comes appears. (Your output may vary!)

.. image:: figures/SimplePaint.png

A More Complex GUI Example
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


This is a large GUI example. There are two lists with a text fields and
some buttons. The first list is populated by the text field and the buttons
move things between lists or remove them from the second list.

The populating from the text field demonstrates how you listen to GUI
elements and react to them. The behavior of the lists shows how collection
methods can play a role in GUIs.

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/BiggerGUI.sc
   :language: scala
   :linenos:
   :start-after: begin-BiggerGUI
   :end-before: end-BiggerGUI


Asteroids
~~~~~~~~~~~~~~~~

This program is a little implementation of asteroids. It shows keyboard
events and the use of case classes to group data together.

We start by importing varius dependencies. This shows how you can take advantage of
existing Java libraries.

Case classes are used to maintain information about key elements of the game, notably
the asteroids and bullets. Although you see the word class here, we're primarily using
class to aggregate the data (think about C *struct* but even nicer). These are used to 
maintain two typesafe lists of asteroids and bullets, respectively, with type ``List[Asteroid]``
and ``List[Bullet]``.

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGame.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGame-setup
   :end-before: end-SimpleGame-setup

The ``wrap()`` method does what you might be thinking it does. It takes an x
or y coordinate (even though you only see ``x`` in the parameter name) of a
given asteroid and ensures it falls within the bounds of the window. Note that
this references an external "global" *value* ``windowSize``. Because this
value is immutable, there is no risk of a side effect. (This could be called
the revival of the ``const`` from C/C++ and Pascal but in a more modern
formulation.)

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGame.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGame-wrap
   :end-before: end-SimpleGame-wrap


The definition of the panel is where the actual drawing (and redrawing) of the game
takes place. It also shows how to clearly separate the drawing from the reactions to 
events of interest (keyboard and mouse). Notably, we can handle these events
without having to use *classes*. This allows us to stay focused on design principles
instead of the vagaries of event objects and interfaces (even though these details
are still present, being able to match the event's *type* allows us to avoid
premature complexity from a student perspective.)


.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGame.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGame-panel
   :end-before: end-SimpleGame-panel

A *timer* is particularly useful in game design, where you want to have self-updating without
user interaction. In the case of this game, whether or not the user is doing anything, asteroids
continue moving, subject to their velocities. Same for bullets. There is also logic to determine 
collisions and whether the ship is destroyed (which ends the game).

.. literalinclude:: ../../examples/introcs-scala-examples//worksheets/SimpleGame.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGame-timer
   :end-before: end-SimpleGame-timer

Setup of the game is fairly concise. Create the main (Swing) frame and set the desired properties.
In particular, we embed the created panel (a method that is familiar to anyone who has taught Java
based UIs using AWT or Swing) and disallow frame resizing. We also center the frame on the screen 
(if supported). Then we display the frame and start the timer.

While there are a few details about Swing to know here, much of this code is common to all Swing
application development, so it is eminently teachable--and you can always point students to the 
basic documentation for Java to learn the details.

.. literalinclude:: ../../examples/introcs-scala-examples/worksheets/SimpleGame.sc
   :language: scala
   :linenos:
   :start-after: begin-SimpleGame-main
   :end-before: end-SimpleGame-main

Here's a screenshot of the game:

.. image:: figures/SimpleGame.png


Basic Data Structures for CS and DS
--------------------------------------------------

- Pure OO
- Fewer quirks than Java
- Powerful type system
- Traits
- Rich collections
- Libraries again
- Can make things interesting/relevant
- Multithreading and networking
- VS Code (our favorite) and IntelliJ (optional alternative)
- Scalable language
- Libraries as language
- Special methods


