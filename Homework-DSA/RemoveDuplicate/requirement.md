Remove Duplicates from Sorted Array — Task Description

A non-empty array A consisting of N integers sorted in non-decreasing order is given. Remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Return the number of unique elements K.

For example, consider array A such that:

```
A[0] = 1
A[1] = 1
A[2] = 2
```

The function should modify A in-place and return K = 2, because there are 2 unique elements. The first K elements of A should contain the unique values [1, 2].

Write a function:

class Solution { public int solution(int[] A); }

that, given a sorted array A of N integers, removes the duplicates in-place and returns the count K of unique elements such that the first K elements of A contain all unique values in sorted order.

For example, given array A such that:

```
A[0] = 0
A[1] = 0
A[2] = 1
A[3] = 1
A[4] = 1
A[5] = 2
A[6] = 2
A[7] = 3
A[8] = 3
A[9] = 4
```

the function should return K = 5, and the first 5 elements of A should be [0, 1, 2, 3, 4].
