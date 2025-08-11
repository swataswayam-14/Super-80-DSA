#  Why Java Allows Multiple Inheritance of Interfaces but Not Classes

### with classes : 

Multiple inheritance can cause the diamond problem with state (instance variable). 
ex: if 2 parent have the same field, which one should the child inherit?

### with interfaces: 
pre (java-8) , interfaces had no state - only abstract methods - so no state conflict

post java-8 -> default method still avoid this issue by forcing the implementing class to explicitly resolve any ambiguity

