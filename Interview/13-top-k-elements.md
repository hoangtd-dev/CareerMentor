# 13 — Top K Elements

**Nhận diện:** "K lớn nhất / nhỏ nhất / hay gặp nhất / gần nhất". Heap kích thước `K` cho O(n log k) — nhưng interviewer thường ép bạn xuống O(n) hoặc mở rộng sang stream/phân tán.

---

## Chuỗi A — Từ K lớn nhất tới O(n)

**Nấc 1.** Cho mảng chưa sort và số `k`. Trả về **k phần tử lớn nhất** (thứ tự tuỳ ý).

**Nấc 2.** Trả về **phần tử lớn thứ k**. So sánh 3 cách: sort O(n log n), heap O(n log k), **quickselect** O(n) trung bình.

**Nấc 3.** Quickselect có worst case O(n²). Làm sao đảm bảo O(n) **worst case**? (median of medians — và vì sao thực tế ít ai dùng?)

**Nấc 4.** Với `k = n/2` thì heap size `k` không còn tiết kiệm. Khi nào heap thắng quickselect và ngược lại?

**Nấc 5.** Tìm **k phần tử nhỏ nhất** — bạn dùng max-heap hay min-heap? Giải thích vì sao ngược trực giác.

---

## Chuỗi B — Biến thể theo tiêu chí

**Nấc 1.** Cho mảng **đã sort** và số `x`. Tìm `k` phần tử **gần `x` nhất**. O(log n + k).

**Nấc 2.** Cho mảng điểm 2D. Tìm `k` điểm **gần gốc toạ độ nhất**.

**Nấc 3.** Tìm `k` phần tử **xuất hiện nhiều nhất** trong mảng. Cho lời giải heap O(n log k), rồi **bucket sort O(n)**. Khi nào bucket sort không dùng được?

**Nấc 4.** Sắp xếp mảng theo **tần suất giảm dần**; nếu bằng tần suất thì giá trị nhỏ đứng trước.

**Nấc 5.** Tìm `k` **chuỗi** hay gặp nhất, tie-break theo thứ tự từ điển. So sánh hàm ưu tiên viết thế nào cho đúng?

**Nấc 6.** Cho `n` sợi dây với độ dài khác nhau. Nối tất cả thành một sợi, chi phí mỗi lần nối bằng tổng độ dài hai sợi. Tìm **chi phí tối thiểu**.

**Nấc 7.** **Task Scheduler**: cho danh sách task và khoảng nghỉ `n` giữa hai task cùng loại. Tính thời gian tối thiểu để chạy hết. Rồi: **in ra lịch cụ thể**.

**Nấc 8.** **Rearrange String k Distance Apart**: sắp xếp lại chuỗi sao cho hai ký tự giống nhau cách nhau ít nhất `k`. Trả rỗng nếu không thể.

---

## Chuỗi C — Stream & quy mô lớn

**Nấc 1.** Thiết kế `KthLargest`: khởi tạo với mảng và `k`, mỗi lần `add(x)` trả về phần tử lớn thứ `k` hiện tại.

**Nấc 2.** Stream vô hạn, bộ nhớ giới hạn. Duy trì top-k **liên tục**. Chi phí mỗi phần tử?

**Nấc 3.** Stream các từ khoá tìm kiếm (10⁹/ngày). Tìm **top 100 từ khoá hot nhất**, cho phép sai số nhỏ. Bộ nhớ chỉ vài MB. (count-min sketch / space-saving)

**Nấc 4.** Dữ liệu nằm trên **1000 máy**. Mỗi máy có top-k cục bộ. Ghép lại thành top-k toàn cục — có luôn đúng không? Cần trao đổi thêm gì?

**Nấc 5.** Top-k trong **cửa sổ thời gian trượt** (top 10 sản phẩm bán chạy trong 1 giờ qua), cập nhật liên tục.

**Nấc 6.** Thiết kế `LFUCache` (least frequently used) với `get` và `put` đều **O(1)**. Vì sao heap không đủ?

---

## Câu chốt hạ hay gặp

- "`k = 1` thì thuật toán của bạn có suy biến thành gì? `k = n` thì sao?"
- "Bạn dùng min-heap size `k` cho 'k lớn nhất' — giải thích lại bằng bất biến."
- "Nếu có **tie** (bằng nhau) thì trả về cái nào? Interviewer thường không nói — bạn phải hỏi."
- "O(n log k) và O(n) — với `n = 10⁶`, `k = 10` thì chênh nhau thực tế bao nhiêu? Có đáng đổi lấy code phức tạp không?"
- "Bucket sort cho top-k tần suất là O(n) — nhược điểm bộ nhớ là gì?"
- "Kết quả có cần **sắp xếp** không, hay chỉ cần đúng tập hợp?"
