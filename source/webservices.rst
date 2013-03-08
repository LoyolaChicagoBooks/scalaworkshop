Web Application and Services
============================

Professional Context
--------------------

*Disclaimer: I am not affiliated in any form with Typesafe.*

In this section, we discuss how Scala can enhance the pedagogy in
certain foundational and applied advanced courses. Given that the
majority of students coming out of our undergraduate and graduate
programs find jobs in local and global industry, we place considerable
emphasis on professional practice. 

To this end, we draw on several (local and global) resources:

- `Uncle Bob
  <http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod>`_
- `ThoughtWorks Technology Radar <http://www.thoughtworks.com/radar>`_
- `IEEE Software's Software Engineering Radio <http://www.se-radio.net>`_

We attempt to strike a balance among solid foundational knowledge,
state-of-the-art technology, and job market demands. In particular, we
have adopted the following rule for our advanced courses and research
projects: *new code in Java (the language, as opposed to the
platform)*.

We also strive to choose technologies that scale properly. Here, the
typical startup story goes like this: Implement in RoR, oops, it
doesn't scale, then redo in guess what language? There are an
increasing number of good language and platform choices here, and in
our experience, Scala is one of them.
 
The job market is also increasingly interested in Scala. `Here
<http://jobs.cs.luc.edu/post/41214148685/telecommuting-internships-and-full-time-positions-at>`_
is an interesting local internship ad.

Curricular Context
------------------

Starting in 2010, we have been incorporating Scala into several of
these courses, taught mostly by Konstantin and experienced
professionals serving as adjuncts.

- `COMP 373/473: Advanced Object-Oriented Development <http://laufer.cs.luc.edu/teaching/473>`_, 
  using Scala since spring 2010, planning to add Android in spring 2014
- `COMP 372/471: Theory (and Practice) of Programming Languages <http://laufer.cs.luc.edu/teaching/372>`_, 
  using Haskell and F# since fall 2010
- `COMP 338/442: Server-Side Software Development <http://laufer.cs.luc.edu/teaching/442>`_ 
  (focusing on web applications), using Scala with the 
  `Play! framework <http://www.playframework.com/>`_ since fall 2010
- `COMP 388/433: Web Services Development <http://laufer.cs.luc.edu/teaching/433>`_, 
  using Scala with the `spray toolkit <http://spray.io>`_ 
  since spring 2011
- `COMP 313/413: Intermediate Object-Oriented Development <http://laufer.cs.luc.edu/teaching/313>`_ 
  (focusing on software design and architecture), using Java with Android since fall 2012,
  considering the addition of Scala down the road


Why Scala?
----------

In our experience, Scala can help with the pedagogy of advanced
applied courses in multiple ways:

- less boilerplate
- focus on deep concepts
- focus on good practices

In the remainder of this section, we will give an overview of web
application and web service development in Scala and contrast the
experience with the corresponding Java-based techniques.

Web Applications
----------------

The predominant web application frameworks targeting Scala are `Lift
<http://liftweb.net>`_ and `Play! <http://playframework.com>`_.
Typesafe has adopted the latter as part of its `official stack
<http://typesafe.com/stack>`_, and we had actually started to use
Play! in our course before Typesafe's decision was known.

The primary concerns in the development of web application for human
users---as opposed to a web service for programmatic consumption---are

- views
    + presentation
    + visual styles
    + layout
    + navigation
    + i18n
- controllers
    + validation
    + authentication
    + dynamic behavior/interaction/state
- models
    + services
    + domain model
- persistence
    + database technologies
    + mapping domain object to persistent storage
- testing
    + unit testing
    + integration testing
    + functional testing
    + acceptance testing
    + performance/load testing

When using a Java-based stack, we typically address these concerns
with a stack tied together by a dependency-injection framework such as
Spring and an object-relational mapper (ORM) such as Hibernate, along
with a MVC framework for the upper layers. 

When using a Scala-based stack, we an express an equivalent
architecture much more concisely and using language mechanisms instead
of requiring a DI framework.

Examples
++++++++

- `Linear regression in Java with Spring, Stripes, and maven
  <https://github.com/webapps-cs-luc-edu/linreg-stripes-spring-maven>`_
- `To-do list in Scala with Play!
  <https://github.com/webapps-cs-luc-edu/todolist-play-scala>`_
- `Live version of the to-do list deployed to the cloud
  <http://laufer-todolist-play-scala.herokuapp.com>`_


Web Services
------------

As opposed to the Simple Object Access Protocol (SOAP), we will focus
on representational state transfer (REST), which has emerged as the
preferred approach of the broader agile community.

The implementing-rest community has put together a helpful 
`language matrix <https://code.google.com/p/implementing-rest/wiki/ByLanguage>`_
of REST libraries, toolkits, and frameworks. Typesafe's stack does not
yet include strong support for RESTful web services in the sense of
a high-level DSL for request routing, which is where some of the
choices in the language matrix come into the picture. 

We have picked `spray <http://spray.io>`_ not only because the author is from
Konstantin's home town but also because it is:

- concise
- flexible
- type-safe
- focus on HTTP and request routing
- more and more widely used and supported

Scala and Spray are supported by `Heroku <https://devcenter.heroku.com/articles/scala>`_ 
and several other newer APaaS cloud providers. Deploying a service to the cloud requires
a simple Git commit; this makes it possible to achieve continuous delivery.

Examples
++++++++

- `Social bookmarking example based on Java with the Restlet framework <https://github.com/webservices-cs-luc-edu/restlet-book-examples/tree/master/src/main/java/org/restlet/example/book/rest/ch7>`_
- `Prime number checker based on Scala with spray <https://github.com/webservices-cs-luc-edu/primenumbers-spray-scala>`_


