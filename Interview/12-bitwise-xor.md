# 12 — Bitwise XOR

**Nhận diện:** "xuất hiện chẵn/lẻ lần", "tìm số duy nhất", yêu cầu **O(1) space** khi hash map là cách tự nhiên, hoặc bài toán trực tiếp về bit.

**Tính chất nền:** `a ^ a = 0`, `a ^ 0 = a`, giao hoán và kết hợp.

---

## Chuỗi A — Single Number và họ hàng

**Nấc 1.** Mảng trong đó **mọi số xuất hiện đúng 2 lần trừ một số**. Tìm số đó. O(n) time, O(1) space.

**Nấc 2.** Mảng trong đó **hai số** xuất hiện một lần, còn lại xuất hiện hai lần. Tìm cả hai. (Gợi ý hướng: XOR toàn mảng cho bạn gì, và bit nào giúp chia mảng?)

**Nấc 3.** Mảng trong đó **mọi số xuất hiện 3 lần trừ một số**. XOR không còn dùng trực tiếp được — làm sao? O(1) space.

**Nấc 4.** Tổng quát: mọi số xuất hiện `k` lần trừ một số xuất hiện `p` lần (`p < k`). Điều kiện nào để giải được?

**Nấc 5.** Mảng chứa `n` số trong `0..n` thiếu đúng một số. Giải bằng XOR. **So sánh với công thức tổng Gauss** — ưu điểm gì? (câu trả lời liên quan tới `n` lớn)

**Nấc 6.** Mảng độ dài `2n+1` trong đó `n` cặp số và một số lẻ loi, nhưng mảng **đã sort**. Có làm tốt hơn O(n) không?

---

## Chuỗi B — Bit thao tác

**Nấc 1.** Đếm số bit 1 trong một số nguyên. Rồi: đếm cho **tất cả** số từ `0` tới `n` (O(n) tổng cộng).

**Nấc 2.** Kiểm tra một số có phải luỹ thừa của 2 không, bằng một biểu thức bit.

**Nấc 3.** Đảo ngược thứ tự các bit của một số 32-bit. Rồi: nếu hàm được gọi hàng triệu lần thì tối ưu thế nào?

**Nấc 4.** Cộng hai số **không dùng toán tử `+` hay `-`**.

**Nấc 5.** Nhân hai số không dùng `*`. Chia không dùng `/` (chú ý tràn số với `INT_MIN / -1`).

**Nấc 6.** Tìm **complement** của một số trong hệ nhị phân (chỉ tính các bit có nghĩa: `5 = 101 → 010 = 2`).

**Nấc 7.** Cho khoảng `[m, n]`, tính AND của tất cả số trong khoảng. O(log n), không lặp qua từng số.

---

## Chuỗi C — XOR nâng cao

**Nấc 1.** **Prefix XOR**: trả lời `q` truy vấn "XOR của subarray `[l, r]`" trong O(1) mỗi truy vấn.

**Nấc 2.** Đếm số subarray có XOR bằng `K`.

**Nấc 3.** Đếm số subarray có **số lượng số lẻ** đúng bằng `k`.

**Nấc 4.** Cho mảng, tìm **cặp có XOR lớn nhất**. O(n²) là hiển nhiên — làm O(n · 32) bằng cấu trúc nào?

**Nấc 5.** Cho mảng và `q` truy vấn `(x, m)`: tìm `max(x ^ a[i])` với `a[i] <= m`.

**Nấc 6.** Tính **tổng XOR của tất cả tập con** của một mảng. Có công thức đóng không?

**Nấc 7.** Trò chơi Nim: hai người lần lượt lấy đá từ các đống. Ai thắng? (XOR xuất hiện ở đâu?)

**Nấc 8.** Bitmask DP: bài toán **du lịch người bán hàng** với `n <= 20`. Trạng thái biểu diễn bằng bitmask thế nào?

---

## Câu chốt hạ hay gặp

- "Cách dùng tổng Gauss bị **overflow** với `n` lớn — XOR thì không. Vì sao?"
- "Nếu mảng có **số âm**, thao tác bit của bạn còn đúng không? Dịch phải có dấu vs không dấu."
- "Ngôn ngữ của bạn dùng int 32 hay 64 bit? `1 << 31` cho ra gì?"
- "Bạn giả định số nguyên bao nhiêu bit? Nếu là `BigInteger` thì sao?"
- "Giải pháp XOR ngắn 3 dòng nhưng khó đọc — bạn viết comment thế nào để đồng nghiệp hiểu?"
