# Gale-Shapley
This will be an object oriented implementation of Gale-Shapley's algorithm for stable marriage problem.

The stable marriage/matching problem is a problem to find a stable matching between two equally sized sets of elements given an ordering of preferences for each element. A matching is a mapping from the elements of one set to the elements of the other set. A matching is not stable if There is an element A of the first matched set which prefers an element B of the second matched set over the element to which A is already matched, and B also prefers A over the element to which B is already matched. [Source: Wikipedia](https://en.wikipedia.org/wiki/Stable_marriage_problem).

I made an object oriented Java implementation for this algorithm. I also wrote a [blog post](https://comscibloghun.wordpress.com/2017/09/04/stabil-parositas-gale-shapley-algoritmussal/) to my site (in Hungarian).

## Classes

- Person - Generic parent class of both Man and Woman class. It contains a preference list of Persons
- Man    - Man'ss preference list only contains Woman objects. Every Man implement a method to propose the first single woman in his preference list.
- Woman  - Woman's preference list only contains Man objects. Every Woman has a proporsal set of Men objects and a method to apply the best of the proporsal's list.

Every Man and Woman might throw a GenderMismatchException if we call their method with wrong gender. (For example if we want to add a Woman to a Woman's preference list)


