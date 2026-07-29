# 16 Pattern DSA — Chuỗi đề leo thang

Bộ tài liệu này gồm 16 file, mỗi file là một pattern. Trong mỗi file:

- **Nhận diện**: tín hiệu để biết bài toán thuộc pattern này
- **Chuỗi leo thang**: các nấc đề, đi từ dễ → khó theo đúng cách interviewer dẫn dụ
- **Câu chốt hạ**: những câu hỏi vặn mà interviewer hay dùng để kết thúc vòng

> **Chỉ có đề, không có lời giải.** Hãy tự giải từng nấc trước khi đọc nấc sau — vì nấc sau thường phá vỡ giả định của nấc trước.

## Danh sách

| File | Pattern |
|---|---|
| 01 | Two Pointers |
| 02 | Sliding Window |
| 03 | Fast & Slow Pointers |
| 04 | Merge Intervals |
| 05 | Cyclic Sort |
| 06 | In-place Reversal of Linked List |
| 07 | BFS (Tree / Graph) |
| 08 | DFS & Backtracking |
| 09 | Two Heaps |
| 10 | Subsets / Combinatorial |
| 11 | Modified Binary Search |
| 12 | Bitwise XOR |
| 13 | Top K Elements |
| 14 | K-way Merge |
| 15 | Dynamic Programming |
| 16 | Topological Sort |

## 6 trục leo thang chung

Interviewer hiếm khi đổi bài — họ đổi **ràng buộc**. Nhận ra trục đang bị siết là nhận ra hướng giải:

1. **Time / Space**: brute force → sort → hash → in-place trick
2. **Tổng quát hoá**: 1 phần tử → k phần tử → tất cả phần tử
3. **Ràng buộc đầu vào**: được sửa mảng → read-only; số dương → có số âm; không trùng → có trùng
4. **Quy mô**: vừa RAM → không vừa RAM (external / streaming / sampling / phân tán)
5. **Truy vấn**: 1 query → n query (chuyển chi phí sang tiền xử lý)
6. **Tính động**: dữ liệu tĩnh → có insert/delete liên tục

## Cách luyện

- Mỗi nấc: nói **ý tưởng + độ phức tạp** trước, code sau.
- Sau mỗi nấc tự hỏi: "giả định nào của tôi vừa bị phá?"
- Ghi lại nấc nào mình bị khựng — đó là chỗ cần ôn, không phải cả pattern.
