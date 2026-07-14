# 2 Pointer & Sliding Window

## 2 Pointer

- **Idea**: 2 workers standing at 2 positions in an array, simultaneously comparing or swapping values, then moving according to a rule.

**Opposite**
`L -> <- R`

- Usually need sorting

**Same direction**
`L -> R ->`

- No Need sort

**Time complexity**
`O(n)`

- R never moves backward → total steps at most 2n → O(n)
  NOTES: Sign that you're doing it wrong (O(n²)):
- R resets back to L after each iteration → equivalent to 2 nested loops even though the code looks like 2 pointer

**Leetcode**

- [#1 - Two Sum](link)
- [#167 - Two Sum II](link)

## Sliding Window

- Sliding Window is a window that can slide to the right or resize (R expands right, L shrinks right) until the desired result is found.
- L and R only move to the right, never backward. That's why it remains O(n).

**Leetcode**

- [#3 - Longest Substring Without Repeating Characters](link)
- [#121 - Best Time to Buy and Sell Stock](link)

## Fast & Slow Pointer

**Cycle detection**

- Imagine 2 runners on a circular track, one runs twice as fast. The faster runner will eventually lap and catch up to the slower one.

**Middle of Linked List**

- Fast moves twice as fast → when Fast runs out of road, Slow has only covered half the distance.

**Intersection**
Use 2 symmetric pointers:

- Pointer A reaches the end of list A → jumps to the start of list B
- Pointer B reaches the end of list B → jumps to the start of list A
- Both will meet at the intersection point because their total distance traveled is equal

**Leetcode**

- [#141 - Linked List Cycle](link)
- [#876 - Middle of the Linked List](link)
- [#160 - Intersection of Two Linked Lists](link)

---

# Greedy

- At each step, always pick the **locally optimal choice** without worrying about the future.
- Does not backtrack on previous decisions.
  NOTE: Greedy is not always globally optimal — only works when local optimal leads to global optimal.

## Activity Selection

- **Greedy rule:** Always pick the activity that **ends earliest**.
- Ends early → more free time → fit more activities.

**Leetcode**

- [#435 - Non-overlapping Intervals](link)
- [#452 - Minimum Number of Arrows to Burst Balloons](link)

## Fractional Knapsack

- **Greedy rule:** Always pick the item with the **highest value/weight ratio** first.
- Can split items → Greedy works. Can't split → use DP instead.

**Leetcode**

- [#1710 - Maximum Units on a Truck](link)

## Huffman Encoding

- **Greedy rule:** Always merge the **2 nodes with lowest frequency** first.
- More frequent character → shorter code → smaller file.

**Leetcode**

- [#1167 - Minimum Cost to Connect Sticks](link)

## Interval Scheduling

- **Greedy rule:** Sort by **start time**, use min-heap to track earliest ending room.
- Goal: minimum number of rooms needed so no activities overlap.

**Leetcode**

- [#56 - Merge Intervals](link)
- [#253 - Meeting Rooms II](link)
- [#57 - Insert Interval](link)

---

# Recursion

**Analogy:** You want to know which row you're sitting in at a movie theater. You ask the person in front, they ask the person in front of them... until the first person says "I'm row 1" — then the answer passes back to you.

**Recursion** = A function that calls itself with a smaller problem, until the problem is small enough to answer directly.

**3 components:**

**1. Base case** — the stopping point

```
F(0) = 0
F(1) = 1
```

**2. Recurrence relation** — big problem = combination of smaller problems

```
F(n) = F(n-1) + F(n-2)
```

**3. Trust the recursion** — don't trace it in your head, just trust that `F(n-1)` will return the correct answer.

**How to think through a problem:**

1. **Base case** — what is the smallest problem I can answer immediately?
2. **Recurrence** — what smaller problems does problem n depend on?
3. **Memo** — is any subproblem being recalculated? → cache it → O(n)

**Leetcode**

- [#70 - Climbing Stairs](link)
- [#509 - Fibonacci Number](link)
