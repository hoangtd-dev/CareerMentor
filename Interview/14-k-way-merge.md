# 14 — K-way Merge

**Nhận diện:** đầu vào là **nhiều danh sách/mảng đã sắp xếp**, cần gộp hoặc tìm phần tử thứ `k` trên tập hợp chung. Min-heap kích thước `K` giữ "đầu" mỗi danh sách.

---

## Chuỗi A — Merge

**Nấc 1.** Gộp **hai** linked list đã sắp xếp thành một. O(1) space phụ.

**Nấc 2.** Gộp **K** linked list đã sắp xếp. Cho hai lời giải: **min-heap** và **chia để trị**. So sánh time và space.

**Nấc 3.** Gộp hai mảng đã sort, trong đó mảng thứ nhất có sẵn chỗ trống ở cuối. Làm **tại chỗ**, O(1) space. (Gợi ý về hướng đi: điền từ đâu?)

**Nấc 4.** Có `K` mảng, tổng `N` phần tử. Với `K` rất lớn (gần `N`) thì heap còn tốt không? Với `K = 2` thì heap có thừa không?

**Nấc 5.** Gộp `K` mảng nhưng cần **loại bỏ trùng lặp** trong kết quả.

---

## Chuỗi B — Phần tử thứ K

**Nấc 1.** Cho `K` mảng đã sort. Tìm phần tử **nhỏ thứ `k`** trong hợp của chúng.

**Nấc 2.** Cho ma trận `n x n` mà **mỗi hàng và mỗi cột đều sort**. Tìm phần tử nhỏ thứ `k`. Cho lời giải heap, rồi **binary search on value**. Cái nào tốt hơn khi `k` lớn?

**Nấc 3.** Cho hai mảng đã sort. Tìm `k` cặp `(a[i], b[j])` có **tổng nhỏ nhất**. Không sinh hết `m·n` cặp.

**Nấc 4.** Cho hai mảng đã sort. Tìm **tổng cặp nhỏ thứ k**.

**Nấc 5.** Cho mảng phân số `arr[i]/arr[j]`. Tìm phân số **nhỏ thứ k**.

**Nấc 6.** Cho `K` danh sách đã sort. Tìm **khoảng `[a, b]` nhỏ nhất** sao cho khoảng đó chứa ít nhất một phần tử từ **mỗi** danh sách.

---

## Chuỗi C — Quy mô lớn & stream

**Nấc 1.** Bạn có **100 file**, mỗi file 10GB đã sort, RAM chỉ 8GB. Gộp thành một file sort. Mô tả thuật toán, kích thước buffer, số lượt đọc/ghi đĩa.

**Nấc 2.** Nếu có **10.000 file** thì mở đồng thời hết là không khả thi. Làm nhiều **pass** thế nào? Số pass tối ưu?

**Nấc 3.** Gộp `K` **stream vô hạn** đã sort. Kết quả cũng là stream. Thiết kế iterator có `next()` và `hasNext()`.

**Nấc 4.** `K` stream đến với tốc độ khác nhau, một stream có thể **treo lâu**. Bạn xử lý thế nào để không chặn toàn bộ?

**Nấc 5.** Trong hệ phân tán: mỗi máy trả về danh sách kết quả đã sort theo điểm số. Gộp lại lấy top-N toàn cục, **tối thiểu hoá lượng dữ liệu truyền qua mạng**.

**Nấc 6.** External sort tổng quát: sort 1TB dữ liệu với 4GB RAM. Chia thành mấy bước? Chi phí I/O là bao nhiêu?

---

## Câu chốt hạ hay gặp

- "Heap của bạn lưu **giá trị** hay lưu **(giá trị, chỉ số mảng, chỉ số phần tử)**? Vì sao cần cái thứ hai?"
- "Độ phức tạp `O(N log K)` — `N` ở đây là gì, tổng số phần tử hay số phần tử mỗi mảng?"
- "Có mảng **rỗng** trong input thì code của bạn crash ở đâu?"
- "Chia để trị và heap cùng O(N log K) — vì sao chia để trị thường nhanh hơn trong thực tế?"
- "Nếu các mảng có **kích thước rất lệch** (một mảng 10⁶, còn lại 1 phần tử) thì sao?"
- "Với dữ liệu trên đĩa, chi phí thật nằm ở **I/O tuần tự vs ngẫu nhiên** — thiết kế của bạn tối ưu cái nào?"
