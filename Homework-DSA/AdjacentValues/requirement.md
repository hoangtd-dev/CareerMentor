Adjacent Values — Task Description

Integer V lies strictly between integers U and W if U < V < W or if U > V > W.

A non-empty array A consisting of N integers is given. A pair of indices (P, Q), where 0 ≤ P < Q < N, is said to have adjacent values if no value in the array lies strictly between values A[P] and A[Q].

For example, in array A such that:

```
A[0] =  0
A[1] =  3
A[2] =  3
A[3] =  7
A[4] =  5
A[5] =  3
A[6] = 11
A[7] =  1
```

the following pairs of indices have adjacent values:

```
(0, 7),    (1, 2),    (1, 4),
(1, 5),    (1, 7),    (2, 4),
(2, 5),    (2, 7),    (3, 4),
(3, 6),    (4, 5),    (5, 7).
```

For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly between A[4] = 5 and A[5] = 3; the only such value could be the number 4, and it is not present in the array.

Write a function:

```
class Solution { public int solution(int[] A); }
```

that, given a non-empty array A consisting of N integers, returns the number of pairs of indices of this array that have adjacent values. The function should return −1 if this number exceeds 100,000,000.

For example, given array A such that:

```
A[0] =  0
A[1] =  3
A[2] =  3
A[3] =  7
A[4] =  5
A[5] =  3
A[6] = 11
A[7] =  1
```

the function should return 12, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
