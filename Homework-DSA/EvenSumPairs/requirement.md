Even Sum Pairs — Task Description

Write a function:

```
class Solution { public int solution(int[] A); }
```

that, given an array A consisting of N integers, returns the number of pairs (P, Q) such that 0 ≤ P < Q < N and the sum A[P] + A[Q] is an even number. The function should return −1 if the number of such pairs exceeds 1,000,000,000.

For example, given array A such that:

```
A[0] = 2
A[1] = 1
A[2] = 5
A[3] = -6
A[4] = 9
```

the function should return 4, because there are exactly four pairs that fulfill the above condition, namely:

(0, 3), because the sum A[0] + A[3] = 2 + (−6) = −4, an even number;
(1, 2), because the sum A[1] + A[2] = 1 + 5 = 6;
(1, 4), because the sum A[1] + A[4] = 1 + 9 = 10;
(2, 4), because the sum A[2] + A[4] = 5 + 9 = 14.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..50,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
