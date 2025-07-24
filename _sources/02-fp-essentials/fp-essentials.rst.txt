.. image:: ../figures/scalalogo.png

Functional Programming Essentials
======================================

Early History of Programming Languages
------------------------------------------------------

.. note::
   Interested in computing history? 
   See George's salon talk at https://ecommons.luc.edu/cs_facpubs/417/
   and Mini-History of Computing at https://ecommons.luc.edu/cs_facpubs/103/.

- 1940s: machine languages → binary code
- 1950s: assembly languages → mnemonics and symbols
- Late 1950s: 3GLs → abstraction and portability (FORTRAN, ALGOL, COBOL, LISP)

Some Paradigm‑Defining Programming Languages
------------------------------------------------------

- 1957: FORTRAN → imperative/scientific (Backus)
- 1958: ALGOL → imperative with recursion (Backus et al)
- 1964: APL → array programming (Iverson)
- 1967: Simula → Algol-style OO (Dahl & Nygaard)
- 1972: C → imperative/system (Kernighan & Ritchie)
- 1972: Prolog → logic programming (Colmerauer)
- 1972: Smalltalk → dynamic OO (Kay et al)
- 1973: Actors → concurrency/task parallelism (Hewitt, Agha, Hoare et al)
- 1978: ML → statically typed functional programming (Milner et al)
- 1983: C++ → C-style OO (Stroustrup)

Modern Incarnations, Often Multi-Paradigm
-------------------------------------------

- 1987: Perl → scripting/text processing (Wall)
- 1987: Erlang → functional/concurrent/reliable systems (Armstrong)
- 1991: Python → dynamic/multiparadigm/education/scientific (van Rossum)
- 1995: Java → statically typed OO, portable (Gosling et al)
- 1995: JavaScript → web scripting (Brendan Eich)
- 2001: C# → modern OO on .NET (Hejlsberg)
- 2003: Scala → functional + OO on JVM (Odersky)
- 2005: F# → functional-first on .NET (Syme)
- 2007: Clojure → functional Lisp on JVM (Hickey)
- 2009: Go → compiled, concurrent, systems programming (Pike et al)
- 2010: Rust → memory-safe systems programming (Mozilla/Graydon Hoare)
- 2014: Swift → modern safe systems/app language (Apple/Lattner)

Connection to Artificial Intelligence
------------------------------------------------------

+-----------------+-----------------------------+----------------------------------------+
| Period          | Dominant AI Language(s)     | Notes                                  |
+=================+=============================+========================================+
| 1960s–1980s     | Lisp, Prolog                | Symbolic AI, logic programming         |
+-----------------+-----------------------------+----------------------------------------+
| 1980s–1990s     | Lisp, Prolog, C/C++, MATLAB | Expert systems, early ML, robotics     |
+-----------------+-----------------------------+----------------------------------------+
| 1990s–2000s     | Java, C++, MATLAB, R        | Statistical AI, teaching, industrial   |
+-----------------+-----------------------------+----------------------------------------+
| 2010–Present    | Python                      | Deep learning, NLP, open-source boom   |
+-----------------+-----------------------------+----------------------------------------+

Dominant Programming Paradigms
------------------------------------------------------

- Imperative: explicit mutable state
- Functional: pure/recursive functions, immutable values
- Object-oriented: public behavior + private state
- Actors: concurrent behavior with local/transient state
- Logic: queries over facts and rules

So Why Are Things So Imperative?
------------------------------------------------------

- Computer architecture emphasizes stored-program model with shared memory
- Theoretical foundations (Turing, von Neumann) reinforce this view

Each of these deserves a closer look.

Turing Machine, 1936
------------------------------------------------------

Alan Turing’s “abstract machine” that predates modern programmable computers.

- A tape which is divided into cells, one next to the other.
- A head that can read and write symbols on the tape and move the tape left and right one (and only one) cell at a time.
- A table of instructions: (si, symbol at current position, sj, replacement symbol, L or R)
- A state register that stores the state of the Turing table.
- All programming languages today are said to be Turing-equivalent, because they can all be reduced to the Turing machine as defined here.
- Compare these concepts to the ideas of von Neumann.

von Neumann, EDVAC Report, 1945
------------------------------------------------------

Von Neumann was influential in many endeavors (mathematics, physics, game theory, and computing) and was involved in the Manhattan project and the EDVAC computer (successor to the ENIAC of Eckhert and Mauchly).

Three ideas that have shaped modern computer engineering:

“First: since the device is a computor (sic), it will have to perform the elementary operations of arithmetics….”
“Second: the logical control of the device is the proper sequencing of its operations (by…a control organ).”
“Third: Any device which is to carry out long and complicated sequences of operations…must have a considerable memory.”

These views of computing are identical and were independently conceived by Babbage in the design of the Analytical Engine, which Ada Lovelace knew how to program!.

How to Choose?!?
------------------------------------------------------

- Match paradigm to the problem
- Some solutions use multiple paradigms/languages
- Avoid the "hammer/nail" syndrome of the late 1990s

Zoom Out: Fundamental Computational Models
------------------------------------------------------

- Turing machine/von-Neumann architecture: model of the hardware; low-level, unnatural
- lambda calculus: model of the computational behavior; simple, mathematical, natural
- recursion: direct model of underlying mathematical theory

These three models are equivalent in computational power (Turing complete).

Church-Turing thesis: these three models express anything that is algorithmically computable.



Lambda Calculus
------------------------------------------------------

::

   <Exp> ::= <ident>
           | lambda <ident> . <Exp>
           | <Exp> <Exp>
           | <constant>

   (\f (x, y) -> (f x, f y)) (*2) (2, 3) -> (4, 6)

- Powerful enough to express everything using recursion


Make It Safe: Type Systems in Programming Languages
------------------------------------------------------

- A type system is a mechanism to classify program fragments according to the type of value they compute. Can be used to ensure values are used as intended.
- A type error is a type-related erroneous program behavior.
- Type safety is the use of a type system to prevent type errors.

- 2 + 3 -> 5
- 2 + "3" -> error (possible in C)
- 3[4] -> error (possible in C with cast)

Type System Dimensions
------------------------------------------------------

- Static vs. dynamic
- Strong vs. weak
- Implicit/inferred vs. explicit

Static Type Safety
------------------------------------------------------

The use of a static and strong type system to prevent type errors at run time.

Benefits

- early detection of logical errors "when things don't fit together"

- do not need to keep type information around at run time -> performance!!

Challenge

- keep it from feeling like a straightjacket to the programmer

Timeline of the Language/Type System Pendulum
------------------------------------------------------

- Since mid 1980s: statically typed OO languages: C++, Java, C#

  - want type safety and performance
  - language monoculture trap: started to focus on libraries and frameworks instead of languages

- Since late 1990s: dynamic languages: Perl, Python, Ruby

  - wanted productivity (expressiveness, flexibility, extensibility, etc.)
  - build confidence in correctness through extensive testing (TDD)
  - performance? avoid bottleneck by using as glue for C/C++ libraries

- Back since late 2000s: statically typed functional languages: ML and its descendants F#, Haskell, and OCaml; Scala

  - want type safety, performance, and agility
  - want better support for multi-core hardware

ThoughtWorks Technology Radar: Languages Section
------------------------------------------------------

Main Statically Typed Contenders

- Haskell: ML descendant, but lazy and without mutable state, no OO
- Scala: Java-based, mutable and immutable state, eager, functional on top of OO
- F#: OCaml descendant, mutable and immutable state, eager, OO on top of functional
- Swift: Apple language, mutable and immutable state, eager, functional on top of OO
- Rust: C/C++ "systems" successor, AoT compilation, mutable and immutable state, eager, functional on top of OO

Note: Others omitted not because we don't like them but they are not statically typed or lack full FP support (e.g. Python, Go, etc.)


Interesting Dynamically Typed Contenders
------------------------------------------------------

- Clojure: concurrency + performance
- Erlang: scalability, soft real-time
- JavaScript: front-end ubiquity, CoffeeScript, etc.
- Python: itertools, functools

So How to Choose?
------------------------------------------------------

- Foundational soundness
- Adherence to design principles (Maclennan 1986)
- Readability
- Writability/Productivity
- Reliability
- Cost
- Portability
- Generality
- REPL for exploratory programming
- Support for internal and/or external domain-specific languages

Extrinsic Criteria (from Consulting world):
------------------------------------------------------

- Developer expertise and workforce availability
- Hiring in local area
- Developer productivity cost
- Training & migration cost
- Tooling cost
- Performance/scalability
- Offshoring
- Community (blogs, meetups, conventions)
- Visibility, support, ecosystem

Other Interesting Criteria
------------------------------------------------------

- Performance
- Concurrency/parallelism support
- Ecosystem (tools, standard libraries, interoperability)
- Major projects, community activity

