# 02 — Sliding Window

**Nhận diện:** bài toán về **subarray / substring liên tiếp**, hỏi "dài nhất / ngắn nhất / lớn nhất / đếm số lượng" thoả một tính chất. Cửa sổ có thể **cố định** kích thước hoặc **co giãn**.

**Điều kiện then chốt:** tính chất phải **đơn điệu** theo việc mở rộng cửa sổ. Interviewer thường phá đúng chỗ này (ví dụ: thêm số âm vào mảng).

---

## Chuỗi A — Cửa sổ trên mảng số

**Nấc 1.** Cho mảng số nguyên dương và số `k`. Tìm **tổng lớn nhất** của một subarray có đúng độ dài `k`.

**Nấc 2.** Cho mảng **số nguyên dương** và số `S`. Tìm **độ dài nhỏ nhất** của subarray có tổng `>= S`. Trả về 0 nếu không tồn tại.

**Nấc 3.** Bây giờ mảng **có thể chứa số âm và số 0**. Lời giải nấc 2 còn đúng không? Vì sao? Nếu sai, hãy giải lại.

**Nấc 4.** Mảng có số âm. Tìm subarray có tổng **đúng bằng** `K`. Có bao nhiêu cách? (trả về số lượng, không liệt kê)

**Nấc 5.** Mảng có số âm. Tìm subarray **dài nhất** có tổng bằng `K`.

**Nấc 6.** Đếm số subarray có tổng **chia hết cho** `K` (`K > 0`, mảng có số âm).

**Nấc 7.** Tìm subarray **dài nhất** mà tổng của nó `<= S`, với mảng có số âm. Cửa sổ trượt còn dùng được không?

---

## Chuỗi B — Cửa sổ trên chuỗi

**Nấc 1.** Tìm **substring dài nhất không có ký tự lặp**.

**Nấc 2.** Tìm substring dài nhất có **tối đa K ký tự phân biệt**.

**Nấc 3.** Tìm substring dài nhất có **đúng K ký tự phân biệt**. (Gợi ý về hướng suy nghĩ: quan hệ giữa "tối đa K" và "đúng K".)

**Nấc 4.** Cho chuỗi chỉ gồm chữ in hoa và số `k`. Bạn được **thay đổi tối đa `k` ký tự** bất kỳ. Tìm độ dài đoạn dài nhất chỉ gồm **một ký tự lặp lại** sau khi thay.

**Nấc 5.** Cho mảng nhị phân và số `k`. Bạn được **lật tối đa `k` số 0 thành 1**. Tìm dãy 1 liên tiếp dài nhất.

**Nấc 6.** Cho `s` và `t`. Tìm **cửa sổ nhỏ nhất** trong `s` chứa **tất cả ký tự của `t`, kể cả số lần lặp**. Nếu không có, trả về chuỗi rỗng.

**Nấc 7.** Cho `s` và `p`. Tìm tất cả vị trí bắt đầu của các **anagram của `p`** trong `s`.

**Nấc 8.** Cho `s` và một danh sách `words[]` gồm các từ **cùng độ dài**. Tìm tất cả vị trí bắt đầu của substring là **ghép nối của tất cả các từ**, mỗi từ đúng một lần, thứ tự tuỳ ý.

---

## Chuỗi C — Cửa sổ nâng cao

**Nấc 1.** Cho mảng và `k`. Trả về **giá trị lớn nhất của mỗi cửa sổ** kích thước `k`. Yêu cầu O(n) tổng cộng.

**Nấc 2.** Cùng lúc theo dõi cả **max và min** trong cửa sổ. Tìm subarray dài nhất sao cho `max - min <= limit`.

**Nấc 3.** Trả về **median của mỗi cửa sổ** kích thước `k`. Có làm tốt hơn O(n·k) không?

**Nấc 4.** Dữ liệu đến dạng **stream vô hạn**, bạn chỉ có bộ nhớ đủ chứa `k` phần tử. Trả lời truy vấn "max của `k` phần tử gần nhất" tại mọi thời điểm.

**Nấc 5.** Cửa sổ **theo thời gian** thay vì theo số lượng: đếm số sự kiện trong 5 phút gần nhất, sự kiện đến với timestamp không đều. Cấu trúc dữ liệu nào?

**Nấc 6.** Tìm subarray dài nhất mà **tích** các phần tử `< K` (mảng số nguyên dương). Rồi: đếm số subarray như vậy.

---

## Câu chốt hạ hay gặp

- "Vì sao cửa sổ trượt **sai** khi mảng có số âm? Cho phản ví dụ cụ thể."
- "Cửa sổ của bạn chạy O(2n) hay O(n²)? Chứng minh con trỏ trái không quay lui."
- "Nếu bảng chữ cái là **Unicode** thay vì 26 chữ, hash map của bạn tốn bao nhiêu?"
- "Đổi từ 'tìm cái dài nhất' sang '**đếm số lượng**' — thuật toán thay đổi thế nào?"
- "Nếu phải trả lời **q truy vấn** với `k` khác nhau mỗi lần thì sao?"
