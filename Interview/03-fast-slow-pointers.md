# 03 — Fast & Slow Pointers (Floyd)

**Nhận diện:** cấu trúc có thể **đi tiếp từ một trạng thái** (linked list, hàm `f(x)`, mảng dùng giá trị làm chỉ số), cần phát hiện **chu trình**, tìm **điểm giữa**, hoặc tìm phần tử trong không gian trạng thái hữu hạn với **O(1) bộ nhớ**.

---

## Chuỗi A — Chu trình trong Linked List

**Nấc 1.** Cho head của một singly linked list. Kiểm tra list có chứa **chu trình** không. O(1) space.

**Nấc 2.** Nếu có chu trình, trả về **node bắt đầu** chu trình. **Chứng minh** công thức bạn dùng (vì sao đặt lại một con trỏ về head rồi cho hai con trỏ đi cùng tốc độ lại gặp nhau đúng điểm vào chu trình).

**Nấc 3.** Trả về **độ dài** của chu trình.

**Nấc 4.** Nếu `fast` nhảy 3 bước thay vì 2 thì thuật toán còn đúng không? Tổng quát: `fast` nhảy `k` bước, điều kiện nào để hai con trỏ chắc chắn gặp nhau?

**Nấc 5.** Cho hai linked list có thể **giao nhau**. Tìm node giao đầu tiên, O(1) space. Nếu một trong hai list có chu trình thì sao?

---

## Chuỗi B — Điểm giữa và cấu trúc lại

**Nấc 1.** Tìm node **ở giữa** linked list trong một lượt duyệt. Nếu list có số node chẵn, trả node thứ hai trong hai node giữa.

**Nấc 2.** Kiểm tra linked list có phải **palindrome** không, với O(n) time và O(1) space.

**Nấc 3.** Follow-up của nấc 2: bạn đã sửa cấu trúc list. Hãy **khôi phục list về nguyên trạng** trước khi trả kết quả.

**Nấc 4.** Cho list `L0 → L1 → ... → Ln`. Sắp xếp lại thành `L0 → Ln → L1 → Ln-1 → ...` tại chỗ.

**Nấc 5.** Xoá node thứ `n` **tính từ cuối** trong một lượt duyệt.

---

## Chuỗi C — Chu trình trong hàm và trong mảng

**Nấc 1.** **Happy Number**: lặp lại phép "thay số bằng tổng bình phương các chữ số". Số gọi là happy nếu cuối cùng về 1. Kiểm tra một số có happy không, với O(1) space.

**Nấc 2.** Cho mảng `n+1` số nguyên, mỗi số nằm trong `[1, n]`. Chứng minh luôn tồn tại ít nhất một số **trùng lặp**, và tìm nó.

**Nấc 3.** Cùng bài nấc 2, nhưng **không được sửa mảng** và chỉ dùng **O(1) space**.

**Nấc 4.** Cùng ràng buộc nấc 3, nhưng bây giờ có thể có **nhiều hơn một** số trùng. Tìm tất cả. Có làm được O(1) space không? Nếu không, giới hạn thật sự là gì?

**Nấc 5.** Cho mảng số nguyên, mỗi phần tử là "bước nhảy" (dương = tiến, âm = lùi, vòng tròn). Tìm xem có tồn tại **chu trình cùng chiều** độ dài > 1 hay không. O(n) time, O(1) space.

**Nấc 6.** Cho hàm `f` bất kỳ trên tập hữu hạn và điểm xuất phát `x0`. So sánh **Floyd** với **thuật toán Brent** về số lần gọi `f`. Khi nào chọn cái nào?

---

## Câu chốt hạ hay gặp

- "Chứng minh chặt chẽ vì sao slow chưa đi hết một vòng chu trình thì fast đã bắt kịp."
- "Nếu mỗi lần gọi `f(x)` tốn 1 giây, bạn tối ưu **số lần gọi** thế nào?"
- "Dùng HashSet cũng giải được — vì sao interviewer vẫn hỏi Floyd?"
- "List cực dài, không vừa RAM, đọc tuần tự từ đĩa. Fast/slow còn hiệu quả không?"
- "Nếu list là **doubly linked** hoặc có random pointer thì đổi gì?"
