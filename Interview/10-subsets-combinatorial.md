# 10 — Subsets / Combinatorial

**Nhận diện:** "sinh ra tất cả...", "liệt kê mọi cách...", "có bao nhiêu cách...". Không gian nghiệm có kích thước `2ⁿ`, `n!`, hoặc Catalan. Có thể làm bằng BFS mở rộng dần, DFS/backtracking, hoặc bitmask.

---

## Chuỗi A — Tập con & hoán vị

**Nấc 1.** Sinh **tất cả tập con** của một mảng các số **phân biệt**.

**Nấc 2.** Mảng **có phần tử trùng** — sinh tất cả tập con **không trùng nhau**.

**Nấc 3.** Sinh tất cả **hoán vị**. Rồi: có phần tử trùng.

**Nấc 4.** Sinh tất cả **tổ hợp chập k** của `1..n`.

**Nấc 5.** **Combination Sum**: cho mảng số dương phân biệt và `target`, liệt kê mọi tổ hợp có tổng bằng `target`, **mỗi số được dùng lại vô hạn lần**.

**Nấc 6.** Biến thể: mỗi số **chỉ dùng một lần**, và mảng có phần tử trùng — kết quả không được trùng.

**Nấc 7.** Biến thể: chỉ dùng số `1..9`, mỗi số tối đa một lần, đúng `k` số, tổng bằng `n`.

**Nấc 8.** Sinh **tập con thứ K theo thứ tự từ điển** mà **không sinh hết** `2ⁿ` tập con. Tương tự cho **hoán vị thứ K**.

---

## Chuỗi B — Sinh cấu trúc

**Nấc 1.** Sinh tất cả chuỗi **dấu ngoặc hợp lệ** với `n` cặp.

**Nấc 2.** Có bao nhiêu chuỗi như vậy? Liên hệ với **số Catalan**.

**Nấc 3.** Có bao nhiêu **BST có cấu trúc khác nhau** với `n` node? Rồi: **sinh ra** tất cả chúng.

**Nấc 4.** **Letter Case Permutation**: cho chuỗi chữ và số, sinh mọi biến thể hoa/thường.

**Nấc 5.** **Letter Combinations of a Phone Number**: cho chuỗi số điện thoại, sinh mọi tổ hợp chữ cái.

**Nấc 6.** **Different Ways to Add Parentheses**: cho biểu thức số học, tính mọi kết quả có thể tuỳ cách đặt ngoặc.

**Nấc 7.** Sinh mọi cách **phân hoạch một chuỗi** thành các đoạn palindrome.

**Nấc 8.** Cho một chuỗi và từ điển, sinh mọi cách **tách chuỗi thành các từ hợp lệ** (Word Break II). Vì sao cần memo?

---

## Chuỗi C — Từ liệt kê sang đếm và sang tối ưu

**Nấc 1.** Với mỗi bài ở chuỗi A/B: nếu chỉ hỏi **số lượng nghiệm**, có tránh được việc sinh hết không?

**Nấc 2.** Cho `n = 40`, `2ⁿ` là quá lớn. Kỹ thuật **meet in the middle** áp dụng vào bài "đếm tập con có tổng bằng target" thế nào?

**Nấc 3.** Dùng **bitmask** thay vì đệ quy để sinh tập con. Ưu nhược điểm? Giới hạn `n`?

**Nấc 4.** Duyệt **mọi tập con của một tập con** (submask enumeration). Độ phức tạp tổng là bao nhiêu — và vì sao là `3ⁿ` chứ không phải `4ⁿ`?

**Nấc 5.** Kết quả có `10⁷` phần tử, không vừa bộ nhớ. Thiết kế API trả về dạng **iterator / lazy**, hỗ trợ `next()` trong O(n).

---

## Câu chốt hạ hay gặp

- "Bạn khử trùng lặp bằng cách nào — **sort rồi bỏ qua**, hay dùng **Set**? Cái nào rẻ hơn và vì sao?"
- "Độ phức tạp là `O(2ⁿ)` hay `O(n · 2ⁿ)`? Chi phí **copy** mỗi nghiệm tính vào đâu?"
- "Bản BFS (mở rộng dần từng phần tử) và bản DFS — cái nào tốn bộ nhớ hơn?"
- "Nếu `n = 100` thì rõ ràng không sinh hết được. Bài toán thật sự đang hỏi gì? (thường là DP)"
- "Thứ tự nghiệm trong output có quan trọng không? Nếu interviewer yêu cầu **thứ tự từ điển** thì đổi gì?"
