# 01 — Two Pointers

**Nhận diện:** mảng/chuỗi (thường đã sort), cần tìm cặp/bộ ba thoả điều kiện, hoặc xử lý in-place với yêu cầu O(1) space. Hai con trỏ có thể đi ngược chiều (từ hai đầu vào giữa), cùng chiều (read/write), hoặc trên hai mảng khác nhau.

---

## Chuỗi A — Từ Two Sum tới k-Sum

**Nấc 1.** Cho mảng số nguyên **đã sắp xếp tăng dần** và một số `target`. Tìm hai chỉ số `i < j` sao cho `a[i] + a[j] == target`. Trả về cặp chỉ số, hoặc `[-1, -1]` nếu không có.

**Nấc 2.** Giải lại bài trên với **O(n) time và O(1) space**. Chứng minh vì sao thuật toán không bỏ sót nghiệm nào.

**Nấc 3.** Bây giờ mảng **chưa sắp xếp**. Trả về **tất cả các cặp giá trị phân biệt** có tổng bằng `target` (cặp `(2,3)` và `(3,2)` tính là một; nếu mảng có nhiều số 2 thì cặp `(2,2)` chỉ liệt kê một lần).

**Nấc 4.** Cho mảng số nguyên. Tìm **tất cả bộ ba phân biệt** `(a, b, c)` sao cho `a + b + c == 0`. Không được có bộ ba trùng nhau trong kết quả.

**Nấc 5.** Cho mảng và `target`. Tìm bộ ba có tổng **gần `target` nhất**. Nếu có nhiều bộ ba cùng khoảng cách, trả về bộ có tổng nhỏ hơn.

**Nấc 6.** Cho mảng và `target`. **Đếm** số bộ ba `(i, j, k)` với `i < j < k` sao cho `a[i] + a[j] + a[k] < target`. Không được liệt kê từng bộ (số bộ có thể lên tới hàng tỉ).

**Nấc 7.** Tổng quát hoá thành **k-Sum**: tìm tất cả bộ `k` phần tử có tổng bằng `target`. Cho biết độ phức tạp theo `n` và `k`. Với `k` lớn, cách tiếp cận nào tốt hơn hai con trỏ?

---

## Chuỗi B — In-place partition & dedup

**Nấc 1.** Cho mảng **đã sắp xếp**. Xoá các phần tử trùng lặp **tại chỗ**, trả về độ dài mảng mới. Phần đuôi mảng chứa gì cũng được.

**Nấc 2.** Cùng bài trên, nhưng cho phép mỗi giá trị xuất hiện **tối đa 2 lần**. Tổng quát: tối đa `k` lần.

**Nấc 3.** Cho mảng số nguyên. Dời tất cả số `0` về cuối mảng, **giữ nguyên thứ tự tương đối** của các số khác. Tại chỗ. Tối thiểu hoá **số lần ghi** vào mảng.

**Nấc 4.** Cho mảng chỉ chứa giá trị `0`, `1`, `2`. Sắp xếp tại chỗ trong **đúng một lượt duyệt**, O(1) space.

**Nấc 5.** Tổng quát hoá nấc 4: cho một hàm `predicate(x)` bất kỳ, phân hoạch mảng thành hai phần (thoả / không thoả). Có làm được **stable** (giữ thứ tự tương đối trong mỗi nhóm) với O(n) time và O(1) space không? Nếu không, chứng minh hoặc nêu giới hạn.

---

## Chuỗi C — Container & Trapping Water

**Nấc 1.** Cho mảng `height[]`, mỗi phần tử là chiều cao một cột. Chọn hai cột tạo thành thùng chứa nước có **diện tích lớn nhất**.

**Nấc 2.** Chứng minh vì sao khi dùng hai con trỏ ở hai đầu, việc luôn dịch con trỏ có cột **thấp hơn** không làm mất nghiệm tối ưu.

**Nấc 3.** Cùng mảng `height[]`, nhưng bây giờ tính **tổng lượng nước đọng lại** giữa các cột sau cơn mưa. Cho lời giải O(n) time, O(n) space.

**Nấc 4.** Giải lại nấc 3 với **O(1) space**.

**Nấc 5.** Bây giờ là ma trận 2D `m x n` chiều cao. Tính tổng lượng nước đọng lại. Two pointers còn dùng được không? Nếu không thì pattern nào thay thế?

---

## Chuỗi D — Chuỗi & Palindrome

**Nấc 1.** Kiểm tra một chuỗi có phải palindrome không, **bỏ qua** ký tự không phải chữ/số và không phân biệt hoa thường.

**Nấc 2.** Cho một chuỗi. Kiểm tra nó có thể trở thành palindrome sau khi **xoá tối đa 1 ký tự** hay không.

**Nấc 3.** Tổng quát: xoá tối đa `k` ký tự. Với `k` nhỏ thì làm sao? Với `k` lớn tới `n` thì bài toán trở thành gì?

**Nấc 4.** Tìm **palindrome con dài nhất** (substring liên tiếp) của một chuỗi. Cho lời giải O(n²), rồi cải tiến xuống **O(n)**.

**Nấc 5.** Cho hai chuỗi `s` và `t`. Kiểm tra `s` có phải **subsequence** của `t` không. Follow-up: nếu có **10⁹ chuỗi `s`** cần kiểm tra trên cùng một `t`, tiền xử lý thế nào?

---

## Câu chốt hạ hay gặp

- "Nếu mảng có **cả số âm** thì thuật toán của bạn còn đúng không?"
- "Mảng **read-only**, không được sort. Bạn làm sao?"
- "Nếu kết quả có thể có **hàng triệu cặp**, bạn trả về kiểu gì? (generator / streaming)"
- "Vì sao two pointers là O(n) mà không phải O(n²)? Chứng minh bằng lập luận amortized."
- "Nếu dữ liệu đến dạng **stream**, không random access, bạn còn dùng được two pointers không?"
