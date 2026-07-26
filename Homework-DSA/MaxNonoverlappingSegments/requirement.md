Max Nonoverlapping Segments — Task Description

You are given an array A of N integers. You can delete some (possibly zero) of its elements. Then the remaining elements in even positions are added and elements in odd positions are subtracted:

S = A[0] − A[1] + A[2] − A[3] + ...

What is the maximum possible value of S that could be obtained by performing such deletions? As the result may be large, return its last nine digits without leading zeros (in other words, return the result modulo 1,000,000,000).

Write a function:

```
class Solution { public int solution(int[] A); }
```

that, given an array A of length N, returns the maximum value of S (modulo 1,000,000,000).

Examples:

Given A = [4, 1, 2, 3], the function should return 6, because we could delete the third value in A and obtain A = [4, 1, 3]. Then S = 4 − 1 + 3 = 6, which is the maximum possible value of S.
Given A = [1, 2, 3, 3, 2, 1, 5], the function should return 7, because for A = [3, 1, 5] we could obtain S = 3 − 1 + 5 = 7.
Given A = [1000000000, 1, 2, 2, 1000000000, 1, 1000000000], the function should return 999999998, because for A = [1000000000, 1, 1000000000, 1, 1000000000] we could obtain S = 1000000000 − 1 + 1000000000 − 1 − 1000000000 = 2999999998. That is the maximum possible value of S, but it should be returned modulo 1000000000.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..200,000];
each element of array A is an integer within the range [0..1,000,000,000].
