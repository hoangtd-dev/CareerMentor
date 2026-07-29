# 16 — Topological Sort

**Nhận diện:** có **quan hệ phụ thuộc / thứ tự trước-sau**, đồ thị **có hướng**, câu hỏi kiểu "thứ tự nào hợp lệ", "có làm được không", "cần bao nhiêu bước". Hai cách cài: **Kahn (BFS + indegree)** và **DFS + post-order**.

---

## Chuỗi A — Cơ bản tới tính duy nhất

**Nấc 1.** Cho `n` môn học và danh sách điều kiện tiên quyết. Có thể học hết tất cả không? (tức: đồ thị có **chu trình** không)

**Nấc 2.** In ra **một thứ tự học hợp lệ** bất kỳ.

**Nấc 3.** Thứ tự đó có **duy nhất** không? Làm sao kiểm tra?

**Nấc 4.** **Đếm** số thứ tự hợp lệ. Với `n` nhỏ thì làm sao? Với `n` lớn thì bài toán này thuộc lớp nào?

**Nấc 5.** Trả về thứ tự hợp lệ **nhỏ nhất theo từ điển**. Kahn thay đổi thế nào?

**Nấc 6.** **Alien Dictionary**: cho danh sách từ đã sort theo bảng chữ cái lạ, suy ra thứ tự các chữ cái. Xử lý trường hợp input **mâu thuẫn** và trường hợp `["abc", "ab"]`.

**Nấc 7.** **Sequence Reconstruction**: cho một dãy gốc và các dãy con, kiểm tra dãy gốc có phải là **thứ tự tô-pô duy nhất** dựng được từ các dãy con không.

---

## Chuỗi B — Mở rộng bài toán

**Nấc 1.** **Minimum Height Trees**: cho cây vô hướng, tìm các node làm gốc để chiều cao nhỏ nhất. (Kỹ thuật "bóc lá" — giống Kahn nhưng cho đồ thị vô hướng.)

**Nấc 2.** **Parallel Courses**: mỗi học kỳ học được không giới hạn môn, miễn là đủ điều kiện tiên quyết. Cần **tối thiểu bao nhiêu học kỳ**?

**Nấc 3.** Mỗi môn có **thời lượng khác nhau**, học song song không giới hạn. Tổng thời gian tối thiểu? (đường đi dài nhất trên DAG)

**Nấc 4.** Mỗi học kỳ chỉ học được tối đa `k` môn. Bài toán trở nên khó hơn nhiều — vì sao? Greedy nào hợp lý?

**Nấc 5.** Nếu đồ thị **có chu trình**, tìm **một chu trình cụ thể** để báo lỗi cho người dùng (như báo lỗi circular import).

**Nấc 6.** Đồ thị có chu trình — **nén các thành phần liên thông mạnh (SCC)** thành node rồi topo sort DAG kết quả. Khi nào cần làm vậy?

**Nấc 7.** **Course Schedule IV**: trả lời `q` truy vấn "môn `a` có phải điều kiện gián tiếp của môn `b` không?" Tiền xử lý thế nào?

---

## Chuỗi C — Ứng dụng hệ thống

**Nấc 1.** Thiết kế **build system**: cho graph phụ thuộc giữa các module, xác định thứ tự build và những module **build song song được**.

**Nấc 2.** Phát hiện **deadlock**: cho graph "process chờ resource", xác định có deadlock không và các process liên quan.

**Nấc 3.** **Spreadsheet**: ô này phụ thuộc công thức của ô kia. Khi một ô đổi giá trị, tính lại **những ô nào** và theo **thứ tự nào**?

**Nấc 4.** Đồ thị phụ thuộc thay đổi **liên tục** (thêm/xoá cạnh). Duy trì thứ tự tô-pô mà không tính lại từ đầu.

**Nấc 5.** Đồ thị có **10⁹ cạnh**, không vừa RAM. Topo sort thế nào? (external / MapReduce)

**Nấc 6.** Task có phụ thuộc **và** deadline **và** thời lượng, `m` worker. Lập lịch tối thiểu makespan. Bài này còn là topo sort không?

---

## Câu chốt hạ hay gặp

- "Bản DFS và bản Kahn — cái nào phát hiện chu trình dễ hơn? Cái nào cho bạn **thông tin về chu trình**?"
- "Đồ thị **không liên thông** thì code của bạn có bỏ sót thành phần nào không?"
- "Có node **cô lập** (không cạnh nào) — nó có xuất hiện trong output không?"
- "Bạn dùng đệ quy DFS — đồ thị sâu 10⁶ thì sao?"
- "Có **cạnh trùng lặp** hoặc **self-loop** trong input thì `indegree` tính sai ở đâu?"
- "Làm sao biết topo sort **thất bại** vì chu trình chứ không phải vì bug? Test case nào chứng minh?"
