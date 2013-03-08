Mobile Application Development with Android
===========================================


why Android?
- effective context for teaching a number of topics
  - (real-world) software architecture (DIP, MVA, testability, etc.)
  - concurrency/distributed (EduPar): events, timers, background threads, offloading tasks
    to the cloud
  - embedded/resource-conscious computing
- minimal cost of switching from, say, Swing to Android but enormous benefits
- Android matters in the real world: widely used technology, increasing number of jobs

Tie each section to our curriculum!!!

this one:

IOOP: Java + Android
AOOP: Scala + Android since spring 2010
PL
web apps - since fall 2010
web services - since spring 2011

 


do they know Uncle Bob?

inspiration from previous sigcse


Topics

- see clickcounter readme

 
- starting from scratch
g8 fxthomas/android-app
but issues with in-container functional testing of more complex apps

- conceptual/architectural topics


- lab -> PAIR

    - new user story: max button
        - add ^ button
        - update tests and rest of code accordingly
    - onSaveInstanceState/onRestoreInstanceState
        http://developer.android.com/guide/components/activities.html    
        to simulate rotation: http://stackoverflow.com/questions/3916096/android-avd-rotate-portrait-landscape-how
        The system calls onSaveInstanceState() before making the activity vulnerable to destruction. The system passes this method a Bundle in which you can save state information about the activity as name-value pairs, using methods such as putString() and putInt().


