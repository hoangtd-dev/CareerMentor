# 15 — Dynamic Programming

**Nhận diện:** bài toán tối ưu hoặc đếm, có **bài toán con chồng lấp** và **cấu trúc con tối ưu**. Dấu hiệu: backtracking bị TLE, hoặc câu hỏi "có bao nhiêu cách", "ít nhất/nhiều nhất bao nhiêu".

**Quy trình 5 bước:** định nghĩa trạng thái → công thức chuyển → điều kiện biên → thứ tự duyệt → tối ưu bộ nhớ.

---

## Chuỗi A — Knapsack 0/1

**Nấc 1.** Cho tập số dương và `S`. Có tồn tại tập con nào có tổng bằng `S` không?

**Nấc 2.** Chia mảng thành **hai tập con có tổng bằng nhau** — có làm được không?

**Nấc 3.** Chia mảng thành hai tập con sao cho **hiệu tổng là nhỏ nhất**.

**Nấc 4.** **Đếm** số tập con có tổng bằng `S`.

**Nấc 5.** **Target Sum**: gán dấu `+` hoặc `-` cho mỗi số để tổng bằng `target`. Đếm số cách. (Liên hệ với nấc 4 thế nào?)

**Nấc 6.** Knapsack cổ điển: mỗi vật có **trọng lượng và giá trị**, sức chứa `C`. Tối đa hoá giá trị. Rồi: **truy vết** ra danh sách vật được chọn.

**Nấc 7.** **Unbounded knapsack**: mỗi vật dùng vô hạn lần. Rồi: **bounded** — mỗi vật dùng tối đa `c[i]` lần (tối ưu bằng nhị phân hoá).

**Nấc 8.** **Coin Change**: số đồng xu ít nhất để đạt `amount`. Rồi: **đếm số cách** đổi tiền. Vì sao thứ tự hai vòng lặp khác nhau giữa hai bài?

**Nấc 9.** Sức chứa `C = 10⁹` nhưng chỉ có 100 vật. Bảng DP theo `C` không khả thi — đổi trạng thái thế nào?

---

## Chuỗi B — DP trên chuỗi

**Nấc 1.** **Longest Common Subsequence** của hai chuỗi. Rồi: truy vết ra chuỗi đó.

**Nấc 2.** **Edit Distance** (chèn/xoá/thay). Rồi: nếu mỗi phép có **chi phí khác nhau**?

**Nấc 3.** **Longest Increasing Subsequence**: O(n²) trước, rồi **O(n log n)**. Rồi: đếm số LIS.

**Nấc 4.** **Longest Palindromic Subsequence**. Rồi: **số ký tự ít nhất cần chèn** để chuỗi thành palindrome.

**Nấc 5.** **Longest Palindromic Substring** (liên tiếp) — khác gì bài trên về trạng thái?

**Nấc 6.** **Word Break**: chuỗi có tách được thành các từ trong từ điển không? Rồi: liệt kê **mọi cách tách**.

**Nấc 7.** **Regular Expression Matching** với `.` và `*`. Rồi: **Wildcard Matching** với `?` và `*`.

**Nấc 8.** **Distinct Subsequences**: đếm số cách chuỗi `t` xuất hiện như subsequence trong `s`.

**Nấc 9.** **Interleaving String**: `s3` có phải là trộn xen kẽ của `s1` và `s2` không?

---

## Chuỗi C — Các họ DP khác

**Nấc 1.** **House Robber**: không cướp hai nhà liền kề. Rồi: nhà xếp **vòng tròn**. Rồi: nhà xếp thành **cây nhị phân**.

**Nấc 2.** **Best Time to Buy and Sell Stock**: 1 giao dịch → 2 giao dịch → `k` giao dịch → không giới hạn → có **cooldown** → có **phí giao dịch**. Trạng thái tổng quát là gì?

**Nấc 3.** **Unique Paths** trong lưới → có **chướng ngại vật** → **min path sum** → đường có **tích lớn nhất** (có số âm!).

**Nấc 4.** **Maximal Square** / **Maximal Rectangle** trong ma trận nhị phân.

**Nấc 5.** **DP trên đoạn**: Matrix Chain Multiplication → **Burst Balloons** → Remove Boxes.

**Nấc 6.** **Bitmask DP**: gán `n` công việc cho `n` người sao cho chi phí nhỏ nhất, `n <= 20`.

**Nấc 7.** **Digit DP**: đếm số trong `[L, R]` thoả một tính chất về chữ số.

**Nấc 8.** **DP trên cây**: chọn tập độc lập lớn nhất trên cây; đường đi dài nhất; rerooting.

**Nấc 9.** Khi nào **greedy đủ** và không cần DP? Cho ví dụ bài mà greedy sai nhưng trông có vẻ đúng.

---

## Câu chốt hạ hay gặp

- "Bảng DP của bạn là `O(n·m)` bộ nhớ — giảm xuống **`O(min(n, m))`** đi. Cần đổi thứ tự duyệt thế nào?"
- "Bạn viết **top-down (memo)** hay **bottom-up**? Cái nào có nguy cơ stack overflow? Cái nào tính thừa ít hơn?"
- "**Truy vết** nghiệm chứ không chỉ giá trị tối ưu — lưu thêm gì?"
- "`n = 10⁵` nhưng DP của bạn là O(n²). Bài này chắc có cách khác — nghĩ về cấu trúc dữ liệu hỗ trợ (BIT / segment tree / monotonic)."
- "Định nghĩa trạng thái của bạn có **đủ thông tin** không? Chứng minh tính chất Markov."
- "Nếu input **thay đổi động** (thêm phần tử liên tục), bạn tính lại từ đầu hay cập nhật được?"
