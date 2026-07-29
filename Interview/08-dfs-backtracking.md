# 08 — DFS & Backtracking

**Nhận diện:** duyệt sâu, cần **liệt kê tất cả nghiệm**, xây nghiệm từng bước và có thể **quay lui** khi bế tắc, hoặc tính toán đệ quy trên cây (post-order).

**Ba câu hỏi luôn phải trả lời:** trạng thái là gì? khi nào cắt tỉa? khôi phục trạng thái ở đâu?

---

## Chuỗi A — DFS trên cây

**Nấc 1.** Cây nhị phân, có tồn tại đường từ **root tới lá** có tổng bằng `S` không?

**Nấc 2.** Trả về **tất cả** đường từ root tới lá có tổng bằng `S`.

**Nấc 3.** Đếm số đường có tổng bằng `S`, **không cần bắt đầu từ root và không cần kết thúc ở lá** (chỉ cần đi xuống). Cho lời giải O(n²), rồi O(n).

**Nấc 4.** Tính **đường kính** của cây (đường dài nhất giữa hai node bất kỳ).

**Nấc 5.** Tìm **max path sum** — đường có tổng lớn nhất giữa hai node bất kỳ, giá trị có thể âm.

**Nấc 6.** Tìm **tổ tiên chung gần nhất (LCA)** của hai node. Rồi: nếu phải trả lời `q` truy vấn LCA thì tiền xử lý thế nào?

**Nấc 7.** **Serialize và deserialize** cây nhị phân. Rồi: cây n-ary. Rồi: BST (tận dụng tính chất để nén ngắn hơn).

**Nấc 8.** Kiểm tra một cây có phải BST hợp lệ không. Cạm bẫy phổ biến nhất ở bài này là gì?

---

## Chuỗi B — Backtracking cổ điển

**Nấc 1.** Sinh tất cả **hoán vị** của một mảng số phân biệt.

**Nấc 2.** Mảng **có phần tử trùng** — sinh hoán vị **không trùng nhau**.

**Nấc 3.** **N-Queens**: đếm số cách đặt `n` quân hậu. Rồi: in ra tất cả cấu hình.

**Nấc 4.** Tối ưu N-Queens bằng **bitmask**. Với `n = 15` thời gian chạy khác biệt ra sao?

**Nấc 5.** **Word Search**: tìm một từ trong lưới chữ cái (đi 4 hướng, không dùng lại ô).

**Nấc 6.** **Word Search II**: cho **danh sách nhiều từ**, tìm tất cả từ xuất hiện trong lưới. Chạy nấc 5 cho từng từ là quá chậm — dùng cấu trúc gì?

**Nấc 7.** **Sudoku Solver**. Rồi: tối ưu bằng bitmask cho hàng/cột/ô 3x3, và bằng heuristic chọn ô ít khả năng nhất trước (MRV).

**Nấc 8.** **Phân hoạch palindrome**: cắt chuỗi thành các đoạn đều là palindrome, liệt kê tất cả cách. Rồi: chỉ cần **số nhát cắt tối thiểu** (chuyển sang DP).

---

## Chuỗi C — Không gian trạng thái lớn

**Nấc 1.** Chia mảng thành `k` tập con có **tổng bằng nhau**. Cắt tỉa thế nào để không TLE?

**Nấc 2.** Cho mảng số, chèn `+`, `-`, `*` giữa các số để được biểu thức bằng `target`. Liệt kê tất cả biểu thức (chú ý số có nhiều chữ số và số 0 đứng đầu).

**Nấc 3.** **Robot dọn nhà**: robot chỉ có API `move()`, `turnLeft()`, `turnRight()`, `clean()`, không biết bản đồ và không biết vị trí. Dọn sạch toàn bộ phòng.

**Nấc 4.** Cho một trò chơi hai người trên mảng, xác định người đi trước có thắng không (game DFS + memo).

**Nấc 5.** Đệ quy của bạn sâu 10⁶ tầng. Chuyển sang **bản lặp dùng stack tường minh**.

---

## Câu chốt hạ hay gặp

- "Độ phức tạp của backtracking này là bao nhiêu? Đừng nói 'mũ' — cho con số cụ thể theo `n`."
- "Bạn **copy** list kết quả ở đâu? Nếu quên copy thì lỗi gì xảy ra?"
- "Chỗ nào bạn **khôi phục trạng thái**? Nếu bỏ quên thì bug biểu hiện thế nào?"
- "Có thể **cắt tỉa** sớm hơn không? Chỉ ra bất biến cho phép loại nhánh."
- "Số nghiệm có thể lên tới hàng triệu — bạn trả về list hay **generator**?"
- "Cùng bài này nhưng chỉ hỏi **số lượng nghiệm**, không cần liệt kê — có nhanh hơn không? (DP / memo)"
