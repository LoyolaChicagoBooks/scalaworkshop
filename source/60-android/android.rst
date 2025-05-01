Mobile Application Development with Android
===========================================

Mobile applications backed by cloud-based RESTful services have emerged as the
primary face of computing in terms of massive consumer
participation. Jason Christensen described this system architecture in
his `OOPSLA 2009 presentation <http://www.slideshare.net/jasonc411/oopsla-2009-combining-rest-and-cloud-a-practitioners-report>`_.
Therefore, not only do we find it important to cover this system
architecture in the curriculum, but we also see this architecture as a
very effective context for teaching various important computer science topics:

- (real-world) software architecture
    + dependency inversion principle (DIP)
    + model-view-adapter architectural pattern (MVA)
    + testability
    + etc.
- concurrent, parallel, and distributed computing topics (PDC/TCPP/EduPar)
    + events
    + timers (one-shot and recurring)
    + background threads
    + offloading tasks to the cloud
- embedded/resource-conscious computing
    + limitations of the device
    + capabilities of the device (numerous sensors)

Konstantin drew the inspiration to use Android instead of Swing as a
context for teaching these topics from the mobile computing session at
`SIGCSE 2012 in Raleigh <http://www.sigcse.org/sigcse2012>`_.

Furthermore, we have found the cost of switching from, say, Java Swing
to Android minimal. Besides, Android matters in the real world: it is
a widely used technology, and mobile app development skills are in
increasing demand.

While our overall goals are similar to those of the 
`Sofia framework project <http://sofia.cs.vt.edu/sofia-2114/book>`_, we 
discuss here a language-based approach but are planning to enhance the 
practice of Android development in Scala through additional support classes.
 
As mentioned above, current and future focus has been on these courses:

- `COMP 313/413: Intermediate Object-Oriented Development <http://laufer.cs.luc.edu/teaching/313>`_ 
  (focusing on software design and architecture), using Java with Android since fall 2012,
  considering the addition of Scala down the road
- `COMP 373/473: Advanced Object-Oriented Development <http://laufer.cs.luc.edu/teaching/473>`_,   using Scala since spring 2010, planning to add Android in spring 2014

Tools
-----

There are two sbt plugins for developing Android:

- https://github.com/pfn/android-sdk-plugin
- http://fxthomas.github.io/android-plugin

The rapidly evolving topic of developing Android apps in Scala is the
subject of this discussion forum:

- https://groups.google.com/forum/#!topic/scala-on-android

After some experimentation, we have found `pfn's plugin
<https://github.com/pfn/android-sdk-plugin>`_ to be easier to use and
have adopted it for our Scala-based Android development.

Examples
--------

The learning objectives of each example are stated in the example's
readme.

- `Clickcounter app <https://bitbucket.org/loyolachicagocs_plsystems/clickcounter-android-scala>`_
- `Prime checker app <https://bitbucket.org/loyolachicagocs_plsystems/primenumbers-android-scala>`_
- `Prime checker web service <https://bitbucket.org/loyolachicagocs_distributed/primenumbers-spray-scala>`_

Lab Assignment
--------------

Format
  Pair project

Time
  10 minutes

Deliverable
  An enhancement of `this clickcounter app <https://bitbucket.org/loyolachicagocs_plsystems/clickcounter-android-scala>`_
  that addresses at least one following additional functional requirements:

    - New user story: a max (^) button as the analogous dual to the
      reset (0) button. 
    - Retaining application state during rotation (`see here to find out how to rotate the emulator <http://stackoverflow.com/questions/3916096/android-avd-rotate-portrait-landscape-how>`_).

Nonfunctional requirements
     - You should update the tests and the rest of the existing code accordingly.
     - You should implement the
       ``onSaveInstanceState`` and ``onRestoreInstanceState``
       application lifecycle methods 
       (`see <http://developer.android.com/guide/components/activities.html#SavingActivityState>`_
       for details. The system passes this method a Bundle in which
       you can save state information about the activity as name-value
       pairs, using methods such as ``putString()`` and ``putInt()``.
