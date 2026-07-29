# 05 — Cyclic Sort

**Nhận diện:** mảng chứa các số trong một **khoảng biết trước** (thường `1..n` hoặc `0..n`), độ dài mảng liên quan trực tiếp tới `n`. Câu hỏi về **missing / duplicate**. Ràng buộc chốt hạ gần như luôn là **O(n) time, O(1) space**.

**Ý tưởng gốc:** giá trị có thể dùng làm **chỉ số** → đặt mỗi số về đúng vị trí của nó bằng cách hoán vị tại chỗ.

> Đây chính là chuỗi bạn đã mô tả trong câu hỏi. File này mở rộng nó ra đầy đủ.

---

## Chuỗi A — Chuỗi kinh điển (đúng thứ tự interviewer hay dẫn)

**Nấc 1.** Cho mảng chứa `n` số phân biệt trong khoảng `1..n`, thứ tự bị xáo trộn. **Sắp xếp tại chỗ trong O(n)**. (Không được dùng thuật toán sort tổng quát.)

**Nấc 2.** Mảng chứa `n` số phân biệt lấy từ khoảng `0..n` — tức **thiếu đúng một số**. Tìm số bị thiếu.
- Hãy đưa ra **ít nhất 4 lời giải khác nhau** và so sánh time/space: sort, hash/boolean array, công thức tổng, XOR, cyclic sort.

**Nấc 3.** Mảng độ dài `n` chứa số trong `1..n`, một số số xuất hiện nhiều lần nên **có nhiều số bị thiếu**. Trả về **tất cả** số thiếu. O(n) time, O(1) space (không tính mảng kết quả).

**Nấc 4.** Mảng độ dài `n+1` chứa số trong `1..n`, **đúng một số bị lặp** (có thể lặp nhiều lần). Tìm số đó. O(n) time, O(1) space.

**Nấc 5.** Mảng độ dài `n` chứa số trong `1..n`, mỗi số xuất hiện **một hoặc hai lần**. Trả về **tất cả** số xuất hiện hai lần.

**Nấc 6.** Mảng độ dài `n` chứa số trong `1..n`, trong đó **đúng một số bị lặp và đúng một số bị thiếu**. Trả về cặp `[duplicate, missing]`. O(n) time, O(1) space.

**Nấc 7.** Cùng nấc 4, nhưng **không được sửa mảng** (read-only) và vẫn O(1) space. Pattern nào cứu bạn ở đây?

**Nấc 8.** Cùng nấc 7 nhưng có thể có **nhiều số lặp**. O(1) space còn khả thi không? Nếu không, cho lời giải tốt nhất có thể và **giải thích giới hạn lý thuyết**.

---

## Chuỗi B — Khi khoảng giá trị không còn đẹp

**Nấc 1.** Cho mảng số nguyên **bất kỳ** (có số âm, số 0, số rất lớn, có trùng). Tìm **số nguyên dương nhỏ nhất bị thiếu**. O(n) time, O(1) space.

**Nấc 2.** Cùng bài trên nhưng tìm **`k` số nguyên dương nhỏ nhất bị thiếu**.

**Nấc 3.** Cho mảng **đã sắp xếp** chứa số phân biệt. Tìm số nguyên dương thứ `k` bị thiếu. O(log n).

**Nấc 4.** Cho mảng độ dài `n` chứa số trong `1..m` với `m > n`. Bạn còn dùng cyclic sort được không? Điều kiện nào để pattern này áp dụng được?

**Nấc 5.** Cho mảng chứa số trong `1..n` nhưng bạn **chỉ được đọc mảng một lần theo thứ tự** (stream). Tìm số thiếu. Cần bao nhiêu bộ nhớ?

---

## Chuỗi C — Biến thể mở rộng

**Nấc 1.** Mảng `nums` độ dài `n` chứa số trong `0..n-1`. Với mỗi `i`, xây `ans[i] = nums[nums[i]]` **tại chỗ**, O(1) space. (Mẹo mã hoá hai giá trị vào một ô.)

**Nấc 2.** Cho mảng hoán vị của `1..n`. Tìm số **chu trình** (cycle) trong hoán vị đó, và độ dài mỗi chu trình.

**Nấc 3.** Cho hoán vị, tìm **số phép hoán đổi tối thiểu** để sắp xếp nó.

**Nấc 4.** Cho mảng bất kỳ, tìm số phép hoán đổi tối thiểu để sắp xếp (không phải hoán vị `1..n`).

---

## Câu chốt hạ hay gặp

- "Cách dùng **tổng Gauss** của bạn — với `n = 10⁹` thì sao? **Overflow**. Sửa thế nào?" *(đây là câu bẫy phổ biến nhất của pattern này)*
- "XOR giải được nấc 2 — vì sao nó **không** giải được nấc 6 một cách trực tiếp?"
- "Vòng `while` lồng trong vòng `for` — vì sao vẫn là O(n) chứ không phải O(n²)? Chứng minh amortized."
- "Nếu mảng chứa `long` chứ không phải `int`, mẹo 'đánh dấu bằng dấu âm' còn dùng được không?"
- "Nếu mảng **read-only** và bạn được dùng O(√n) bộ nhớ thì có nhanh hơn không?"
