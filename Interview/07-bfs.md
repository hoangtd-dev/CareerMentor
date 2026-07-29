# 07 — BFS (Tree & Graph)

**Nhận diện:** duyệt **theo tầng**, tìm **đường đi ngắn nhất trên đồ thị không trọng số** (hoặc trọng số bằng nhau), "ít bước nhất để...", lan toả từ nhiều nguồn.

---

## Chuỗi A — BFS trên cây

**Nấc 1.** Duyệt cây nhị phân **theo tầng** (level order), trả về list các list.

**Nấc 2.** Trả về theo tầng nhưng **từ dưới lên**.

**Nấc 3.** Duyệt **zigzag**: tầng 1 trái→phải, tầng 2 phải→trái, xen kẽ.

**Nấc 4.** Trả về **giá trị trung bình** của mỗi tầng. Rồi: node **lớn nhất** mỗi tầng.

**Nấc 5.** Trả về **right side view** — danh sách node nhìn thấy khi đứng bên phải cây.

**Nấc 6.** Tìm **độ sâu nhỏ nhất** của cây (tới lá gần nhất). Vì sao BFS tốt hơn DFS ở bài này?

**Nấc 7.** Nối các node cùng tầng bằng con trỏ `next`. Rồi: làm **không dùng queue**, O(1) space phụ. (Cây có phải perfect binary tree không? Hỏi lại interviewer.)

**Nấc 8.** Cho một node bất kỳ trong cây, tìm tất cả node có **khoảng cách đúng bằng `k`** tới nó (đi được cả lên cha).

---

## Chuỗi B — BFS trên lưới

**Nấc 1.** Lưới 0/1, tìm đường đi ngắn nhất từ góc trên trái tới góc dưới phải (chỉ đi qua ô 0, 4 hướng).

**Nấc 2.** Cho phép đi **8 hướng**. Thay đổi gì?

**Nấc 3.** Bạn được **phá tối đa `k` bức tường**. Tìm đường ngắn nhất. (Gợi ý về hướng: trạng thái không còn là `(r, c)`.)

**Nấc 4.** **Rotting Oranges**: mỗi phút, cam thối lây sang 4 ô kề. Sau bao nhiêu phút thì hết cam tươi? Trả `-1` nếu không thể.

**Nấc 5.** **Walls and Gates**: điền vào mỗi ô trống khoảng cách tới cổng gần nhất. Vì sao **multi-source BFS** tốt hơn chạy BFS từ mỗi ô trống?

**Nấc 6.** Đếm số **đảo** trong lưới. Rồi: đảo **lớn nhất**. Rồi: nếu được lật **đúng một ô 0 thành 1**, đảo lớn nhất có thể là bao nhiêu?

**Nấc 7.** Lưới có chi phí di chuyển là 0 hoặc 1. Tìm đường rẻ nhất. (BFS thường sai — dùng gì?)

**Nấc 8.** Lưới `10⁹ x 10⁹` nhưng chỉ có 1000 ô chướng ngại. Tìm đường đi ngắn nhất. BFS thông thường không khả thi — làm sao?

---

## Chuỗi C — BFS trên đồ thị trạng thái

**Nấc 1.** **Word Ladder**: biến `beginWord` thành `endWord`, mỗi bước đổi một chữ cái và từ trung gian phải có trong từ điển. Số bước ít nhất?

**Nấc 2.** Trả về **tất cả** đường biến đổi ngắn nhất.

**Nấc 3.** Tối ưu nấc 1 bằng **bidirectional BFS**. Nó giảm độ phức tạp từ đâu xuống đâu?

**Nấc 4.** **Open the Lock**: khoá 4 vòng số, có danh sách trạng thái chết. Số lần xoay ít nhất từ `0000` tới `target`.

**Nấc 5.** **Sliding Puzzle** 2x3: số bước ít nhất để về trạng thái đích. Biểu diễn trạng thái thế nào cho gọn?

**Nấc 6.** Đồ thị có `10⁸` node, không vừa RAM. BFS thế nào? (external BFS / frontier trên đĩa)

---

## Câu chốt hạ hay gặp

- "Bạn đánh dấu `visited` **lúc đưa vào queue** hay **lúc lấy ra**? Khác nhau thế nào? Cho ví dụ hỏng."
- "BFS tìm được đường ngắn nhất — nhưng nếu cạnh có **trọng số khác nhau** thì sao?"
- "Queue của bạn có thể phình tới bao nhiêu phần tử? Ước lượng bộ nhớ worst case."
- "Cây rất **lệch** (skewed) — BFS hay DFS tốn bộ nhớ hơn?"
- "Làm sao **truy vết lại đường đi**, không chỉ độ dài?"
- "Nếu đích **không tồn tại**, thuật toán của bạn dừng khi nào?"
