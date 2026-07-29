# 06 — In-place Reversal of Linked List

**Nhận diện:** yêu cầu **đảo ngược** toàn bộ hoặc một phần linked list, **không được dùng thêm bộ nhớ** (O(1) space), và thường **không được đổi giá trị node** — chỉ được đổi con trỏ.

---

## Chuỗi A — Đảo cơ bản tới đảo theo nhóm

**Nấc 1.** Đảo ngược toàn bộ một singly linked list. Cho cả bản **lặp** và bản **đệ quy**. So sánh space thật sự của hai bản.

**Nấc 2.** Đảo ngược **một đoạn con** từ vị trí `m` đến `n` (1-indexed), trong **một lượt duyệt**.

**Nấc 3.** Đảo ngược list theo **từng nhóm `k` node**. Nhóm cuối nếu **thiếu node thì giữ nguyên**.

**Nấc 4.** Cùng nấc 3 nhưng nhóm cuối **cũng phải đảo** dù thiếu node.

**Nấc 5.** Đảo **xen kẽ**: đảo `k` node đầu, giữ nguyên `k` node tiếp theo, đảo `k` node tiếp, ... cho tới hết list.

**Nấc 6.** Đảo mỗi nhóm `k` node **nhưng `k` tăng dần**: nhóm 1 có 1 node, nhóm 2 có 2 node, nhóm 3 có 3 node...

---

## Chuỗi B — Biến đổi cấu trúc khác

**Nấc 1.** **Hoán đổi từng cặp** node liền kề (`1→2→3→4` thành `2→1→4→3`). Không được đổi giá trị.

**Nấc 2.** **Xoay** list sang phải `k` vị trí (`k` có thể lớn hơn độ dài list).

**Nấc 3.** Cho list và giá trị `x`. Phân hoạch sao cho tất cả node `< x` đứng trước tất cả node `>= x`, **giữ nguyên thứ tự tương đối** trong mỗi nhóm.

**Nấc 4.** Sắp xếp một linked list với **O(n log n) time và O(1) space thật sự** (kể cả stack đệ quy).

**Nấc 5.** Cho một **doubly linked list** trong đó mỗi node có thêm con trỏ `child` trỏ tới một list con. **Làm phẳng** thành một doubly linked list duy nhất.

**Nấc 6.** Sao chép một linked list mà mỗi node có thêm `random` pointer trỏ tới node bất kỳ. O(1) space phụ (không dùng hash map).

---

## Chuỗi C — Kết hợp

**Nấc 1.** Kiểm tra list có phải palindrome không, O(1) space, và **trả lại list nguyên trạng**.

**Nấc 2.** Sắp xếp lại list `L0 → Ln → L1 → Ln-1 → ...`

**Nấc 3.** Cộng hai số biểu diễn bằng linked list, chữ số **hàng đơn vị ở đầu**. Rồi: chữ số **hàng cao nhất ở đầu**, không được đảo list.

**Nấc 4.** Cho `k` linked list đã sắp xếp, gộp lại thành một list. (Giao với pattern K-way Merge.)

---

## Câu chốt hạ hay gặp

- "Bản đệ quy của bạn dùng O(n) stack — với list 10⁶ node thì sao? **Stack overflow**."
- "Bạn có xử lý trường hợp `head == null`, list 1 node, `k > độ dài` chưa?"
- "Vẽ ra giấy trạng thái các con trỏ `prev / curr / next` sau mỗi bước — chỗ nào dễ mất node nhất?"
- "Nếu là **doubly linked list**, bạn phải cập nhật thêm gì?"
- "Có được đổi **giá trị** node thay vì con trỏ không? Vì sao interviewer thường cấm?"
- "Làm sao **test** hàm này? Bạn viết những test case nào?"
