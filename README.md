# Puzzles-CountTriangles

## Overview

Count the number of triangles that can be built from a given set of edges.

### Details

An array A consisting of N integers is given.

A triplet (P, Q, R) is *triangular* if it is possible to build a triangle with sides of lengths A[P], A[Q], and A[R].

In other words, triplet (P, Q, R) is *triangular* if 0 <= P < Q < R < N, and:

- A[P] + A[Q] > A[R]
- A[Q] + A[R] > A[P]
- A[R] + A[P] > A[Q]

For example, consider array A such that:

```
A[0] = 10
A[1] = 2
A[2] = 5
A[3] = 1
A[4] = 8
A[5] = 12
```

There are C(6,3) unordered combinations = 6!/(3!(6-3)!) = 6!/(3!\*3!) = 720/(6\*6) = 720/36 = 20

```
Elements
(0, 1, 2)
(0, 1, 3)
(0, 1, 4)
(0, 1, 5)
(0, 2, 3)
(0, 2, 4)
(0, 2, 5)
(0, 3, 4)
(0, 3, 5)
(0, 4, 5)
(1, 2, 3)
(1, 2, 4)
(1, 2, 5)
(1, 3, 4)
(1, 3, 5)
(1, 4, 5)
(2, 3, 4)
(2, 3, 5)
(2, 4, 5)
(3, 4, 5)
```

```
Values
(10, 2, 5)  checks are true, false, true 
(10, 2, 1)  checks are true, false, true
(10, 2, 8)  checks are true, false, true
(10, 2, 12) checks are false, true, true
(10, 5, 1)  checks are true, false, true
(10, 5, 8)  checks are true, true, true ****
(10, 5, 12) checks are true, true, true ****
(10, 1, 8)  checks are true, false, true
(10, 1, 12) checks are false, true, true
(10, 8, 12) checks are true, true, true ****
(2, 5, 1)   checks are true, true, false
(2, 5, 8)   checks are false, true, true
(2, 5, 12)  checks are false, true, true
(2, 1, 8)   checks are false, true, true
(2, 1, 12)  checks are false, true, true
(2, 8, 12)  checks are false, true, true
(5, 1, 8)   checks are false, true, true
(5, 1, 12)  checks are false, true, true
(5, 8, 12)  checks are true, true, true ****
(1, 8, 12)  checks are false, true, true
```

There are 4 triangular triplets that can be constructed from elements of this array,
namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

Write a function:

```
class CountTriangles { public int solution(int [] A); }
```

that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

Write an efficient algorithm for the following assumptions:

- N is an integer within the range [1..1000];
- each element of array A is an integer within the range [1..1,000,000,000]

### Naive solution

Use three nested loops.

Loop on P from 0 to N - 2.

Loop on Q from P + 1 to N - 1.

Loop on R from Q + 1 to N.

The performance of the naive solution is:

- 34 iterations
- 60 comparisons 

### Internet solution

The internet solution uses a sort and claims the sort reduces the number comparisons needed.

See [here](https://codility-solutions.com/lessons/lesson-15-caterpillar-method/counttriangles/)

Given the same input array:

```
A[0] = 10
A[1] = 2
A[2] = 5
A[3] = 1
A[4] = 8
A[5] = 12
```

First sort it.

```
A[0] = 1
A[1] = 2
A[2] = 5
A[3] = 8
A[4] = 10
A[5] = 12
```

For every P and Q we figure out the maximal R that can be a
triangular, and when we increase Q the former R would still
be a triangular because of the sorted array, so we just need
to count the number of triangular between Q and R.

The element triplets would be the same.

The value triplets are now:

```
(1, 2, 5)
(1, 2, 8)
(1, 2, 10)
(1, 2, 12)
(1, 5, 8)
(1, 5, 10)
(1, 5, 12)
(1, 8, 10)
(1, 8, 12)
(1, 10, 12)
(2, 5, 8)
(2, 5, 10)
(2, 5, 12)
(2, 8, 10)
(2, 8, 12)
(2, 10, 12)
(5, 8, 10)    ****
(5, 8, 12)    ****
(5, 10, 12)   ****
(8, 10, 12)   ****
```

The triangular test results are now:


The triplet test results are now:

```
(1, 2, 5)     false, true, true
(1, 2, 8)     false, true, true
(1, 2, 10)    false, true, true
(1, 2, 12)    false, true, true
(1, 5, 8)     false, true, true
(1, 5, 10)    false, true, true
(1, 5, 12)    false, true, true
(1, 8, 10)    false, true, true
(1, 8, 12)    false, true, true
(1, 10, 12)   false, true, true
(2, 5, 8)     false, true, true
(2, 5, 10)    false, true, true
(2, 5, 12)    false, true, true
(2, 8, 10)    false, true, true
(2, 8, 12)    false, true, true
(2, 10, 12)   false, true, true
(5, 8, 10)    true, true, true
(5, 8, 12)    true, true, true
(5, 10, 12)   true, true, true
(8, 10, 12)   true, true, true
```

The internet solution is very non-obvious.

The stop condition of when to add to the result, when k == N, is not intuitive.

For the sample array,

The performance of the internet solution is:

- 25 iterations
- 8 comparisons

### Optimized solution

To leverage the sorted array even more,

- we note that all the triangular triplets are at the end of the list.
- we note that all the non-triangular triplets fail the A[P] + A[R] > A[Q] test

Therefore, we can step through the sorted array in reverse order.
When A[P] + A[R] > A[Q] is false, then stop counting triangular results.

For th sample array,

The performance of the optimized solution is:

- 13 iterations
- 8 comparisons
