# 09 — Two Heaps

**Nhận diện:** cần truy cập **phần tử ở giữa** hoặc chia dữ liệu thành **nửa nhỏ / nửa lớn**, với dữ liệu **thay đổi liên tục**. Max-heap giữ nửa nhỏ, min-heap giữ nửa lớn, luôn cân bằng kích thước.

---

## Chuỗi A — Median

**Nấc 1.** Cho mảng tĩnh, tìm **median**. Cách nào tốt hơn sort? (quickselect — O(n) trung bình)

**Nấc 2.** Thiết kế cấu trúc `MedianFinder` với `addNum(x)` và `findMedian()` trên **stream vô hạn**. Cho độ phức tạp mỗi thao tác.

**Nấc 3.** Thêm thao tác **`removeNum(x)`** — xoá một phần tử bất kỳ đã thêm. Heap chuẩn không hỗ trợ xoá tuỳ ý. Bạn xử lý thế nào?

**Nấc 4.** **Sliding Window Median**: trả về median của mỗi cửa sổ kích thước `k`. (Đây chính là nấc 3 áp dụng thực tế.)

**Nấc 5.** Stream có **10¹⁰ phần tử**, không lưu hết được. Cho median **xấp xỉ** với sai số nhỏ. Bộ nhớ bao nhiêu?

**Nấc 6.** Tổng quát hoá: trả về **phân vị thứ p** (p-th percentile) thay vì median, trên stream. Hai heap còn đủ không?

---

## Chuỗi B — Chia nửa nhỏ / nửa lớn

**Nấc 1.** **IPO / Maximize Capital**: cho `n` dự án, mỗi dự án có vốn tối thiểu và lợi nhuận. Bạn có vốn ban đầu `W` và làm được tối đa `k` dự án. Tối đa hoá vốn cuối. Vì sao cần **hai** heap?

**Nấc 2.** **Next Interval**: với mỗi khoảng, tìm khoảng bắt đầu sớm nhất sau khi nó kết thúc.

**Nấc 3.** Cho mảng, tìm phần tử **vừa lớn hơn median** sau mỗi lần thêm.

**Nấc 4.** Thiết kế hệ thống theo dõi **top 50% giá trị lớn nhất** của một stream, hỗ trợ truy vấn tổng của nhóm đó bất cứ lúc nào.

**Nấc 5.** Bài toán **lập lịch máy chủ**: các task đến với thời gian bắt đầu và thời lượng, có `m` máy. Dùng heap nào cho máy rảnh, heap nào cho task đang chạy?

---

## Chuỗi C — Heap và cấu trúc thay thế

**Nấc 1.** So sánh **two heaps** với **balanced BST (order-statistic tree)** cho bài median stream. Mỗi cái mạnh ở đâu?

**Nấc 2.** Nếu giá trị nằm trong khoảng nhỏ `[0, 10⁵]`, có cấu trúc nào đơn giản hơn heap không? (BIT / counting)

**Nấc 3.** Cài đặt heap hỗ trợ `decreaseKey(x, newVal)` trong O(log n). Cần gì thêm ngoài mảng?

**Nấc 4.** Median trên **dữ liệu phân tán** ở 10 máy, mỗi máy có 1 tỉ số. Không máy nào chứa hết dữ liệu. Thuật toán?

---

## Câu chốt hạ hay gặp

- "Bạn cân bằng hai heap **sau mỗi lần thêm** hay lười biếng? Bất biến chính xác là gì?"
- "Số phần tử **chẵn** thì median tính sao? Hỏi lại interviewer trước khi code."
- "Heap trong ngôn ngữ của bạn có hỗ trợ **max-heap** không? Nếu không thì hack thế nào — và nó hỏng ở đâu với `Integer.MIN_VALUE`?"
- "**Lazy deletion** làm heap phình to. Khi nào bạn dọn dẹp? Chi phí amortized?"
- "Vì sao không dùng mảng sort + binary search insert? So sánh O(log n) vs O(n) thực tế với `n` nhỏ."
