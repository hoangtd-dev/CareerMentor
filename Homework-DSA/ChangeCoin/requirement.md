Change Coins — Task Description

You are given a sum of money and an unlimited supply of coins with denominations [1, 2, 5]. The goal is to find the minimum number of coins needed to make exact change for the given amount.

Write a function:

```
class Solution { public int changeCoins(int money); }
```

that, given a positive integer money, returns the minimum number of coins required to make exact change for that amount using coins of denominations 1, 2, and 5.

Examples:

Given money = 11, the function should return 3, because 11 = 5 + 5 + 1 (three coins).
Given money = 6, the function should return 2, because 6 = 5 + 1 (two coins).
Given money = 8, the function should return 3, because 8 = 5 + 2 + 1 (three coins).
Given money = 0, the function should return 0, because no coins are needed.

Note: You have an unlimited supply of coins of each denomination.

Write an efficient algorithm for the following assumptions:

money is an integer within the range [0..1,000,000,000];
available coin denominations are: 1, 2, 5;
you may use each denomination any number of times;
it is always possible to make exact change (since denomination 1 is always available).
