# 11 — Modified Binary Search

**Nhận diện:** dữ liệu **có thứ tự** (sort, xoay vòng, bitonic), **hoặc** đáp án nằm trong một khoảng số và hàm kiểm tra `check(x)` là **đơn điệu** (đúng từ một điểm trở đi). Cái thứ hai gọi là *binary search on answer* và là dạng khó hay được dùng để chốt hạ.

---

## Chuỗi A — Binary search trên mảng

**Nấc 1.** Binary search cơ bản trên mảng tăng dần. Viết đúng **không lỗi off-by-one**. Vì sao `mid = (lo + hi) / 2` có thể sai?

**Nấc 2.** Mảng có thể tăng **hoặc** giảm (không biết trước). Tìm phần tử.

**Nấc 3.** Nếu không tìm thấy, trả về **ceiling** (số nhỏ nhất `>=` target). Rồi: **floor**.

**Nấc 4.** Mảng ký tự sắp xếp **vòng tròn**. Tìm ký tự nhỏ nhất lớn hơn target (quay vòng về đầu nếu cần).

**Nấc 5.** Mảng **có phần tử trùng**. Tìm **vị trí đầu tiên và cuối cùng** của target. O(log n).

**Nấc 6.** Mảng có độ dài **không biết trước** (chỉ có API `get(i)`, trả `Integer.MAX_VALUE` nếu vượt biên). Tìm target trong O(log n).

**Nấc 7.** Mảng **bitonic** (tăng rồi giảm). Tìm phần tử lớn nhất. Rồi: tìm một target bất kỳ.

**Nấc 8.** Mảng đã sort rồi bị **xoay** tại một vị trí không biết. Tìm target. Rồi: **có phần tử trùng** — độ phức tạp worst case bây giờ là bao nhiêu và vì sao?

**Nấc 9.** Tìm **phần tử đơn độc** trong mảng sort mà mọi phần tử khác xuất hiện đúng 2 lần. O(log n).

---

## Chuỗi B — Binary search on answer

**Nấc 1.** **Koko Eating Bananas**: `n` đống chuối, `h` giờ. Tìm tốc độ ăn nhỏ nhất để ăn hết đúng hạn.

**Nấc 2.** **Capacity to Ship Packages**: chuyển hết hàng trong `D` ngày, giữ nguyên thứ tự. Tìm sức chứa tàu nhỏ nhất.

**Nấc 3.** **Split Array Largest Sum**: chia mảng thành `k` đoạn liên tiếp, tối thiểu hoá tổng lớn nhất của một đoạn.

**Nấc 4.** Chỉ ra rằng nấc 1, 2, 3 là **cùng một bài**. Viết ra template chung: `check(x)` là gì, biên `lo`/`hi` đặt thế nào?

**Nấc 5.** **Aggressive Cows / Magnetic Force**: đặt `k` vật vào các vị trí cho trước sao cho khoảng cách nhỏ nhất giữa hai vật là **lớn nhất**.

**Nấc 6.** Bài toán với **đáp án là số thực** (ví dụ: tối thiểu hoá tốc độ trung bình). Điều kiện dừng của vòng lặp là gì?

**Nấc 7.** Tìm **căn bậc hai nguyên** của một số. Rồi: căn bậc `k`. Rồi: xử lý overflow khi bình phương.

---

## Chuỗi C — Binary search trên cấu trúc 2D và nhiều mảng

**Nấc 1.** Ma trận `m x n` mà mỗi hàng sort tăng và **phần tử đầu hàng sau > phần tử cuối hàng trước**. Tìm target trong O(log(mn)).

**Nấc 2.** Ma trận mà chỉ có **mỗi hàng sort và mỗi cột sort** (không có ràng buộc giữa các hàng). Tìm target. Độ phức tạp tốt nhất là bao nhiêu?

**Nấc 3.** Tìm phần tử **nhỏ thứ k** trong ma trận ở nấc 2. Cho lời giải bằng heap, rồi bằng binary search on answer. So sánh.

**Nấc 4.** Tìm **median của hai mảng đã sort** trong O(log(min(m, n))).

**Nấc 5.** Tổng quát: tìm phần tử nhỏ thứ `k` trong **hai** mảng sort. Rồi: trong **K** mảng sort.

**Nấc 6.** Tìm **peak element** trong mảng chưa sort (chỉ cần lớn hơn hai hàng xóm) trong O(log n). Rồi: peak trong ma trận 2D.

---

## Câu chốt hạ hay gặp

- "Vòng lặp của bạn dùng `while (lo < hi)` hay `lo <= hi`? Chứng minh nó **luôn dừng**."
- "Với mảng xoay **có trùng lặp**, vì sao worst case tụt xuống O(n)? Cho ví dụ."
- "Hàm `check(x)` của bạn tốn O(n) — tổng độ phức tạp là bao nhiêu?"
- "Biên `hi` bạn đặt bằng gì? Nếu đặt sai thì sai ở đâu?"
- "Bài này **có thật sự đơn điệu** không? Chứng minh, đừng chỉ tin trực giác."
- "Mảng nằm trên đĩa, mỗi lần đọc tốn 10ms. Binary search có còn là lựa chọn tốt không? (B-tree, interpolation search)"
