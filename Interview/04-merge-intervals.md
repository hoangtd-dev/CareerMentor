# 04 — Merge Intervals

**Nhận diện:** đầu vào là danh sách khoảng `[start, end]`. Câu hỏi về **gộp, chèn, giao, chồng lấn, lịch trình, tài nguyên**. Bước đầu gần như luôn là sắp xếp theo `start` (hoặc tách thành sự kiện `+1/-1` rồi quét).

---

## Chuỗi A — Cơ bản tới lịch trình

**Nấc 1.** Cho danh sách khoảng. **Gộp** tất cả khoảng chồng lấn và trả về danh sách kết quả.

**Nấc 2.** Cho danh sách khoảng **đã sắp xếp và không chồng lấn**, và một khoảng mới. **Chèn** khoảng mới vào, gộp nếu cần. O(n).

**Nấc 3.** Cho **hai** danh sách khoảng, mỗi danh sách đã sắp xếp và không tự chồng lấn. Trả về **giao** của hai danh sách.

**Nấc 4.** Cho danh sách các cuộc họp `[start, end]`. Một người có tham dự được tất cả không? Rồi: cần **tối thiểu bao nhiêu phòng họp**?

**Nấc 5.** Follow-up nấc 4: trả về **thời điểm** có nhiều cuộc họp chồng nhau nhất, và **danh sách** các cuộc họp tại thời điểm đó.

**Nấc 6.** Cho lịch làm việc của `K` nhân viên (mỗi người là danh sách khoảng đã sắp xếp, không chồng lấn). Tìm các khoảng **rảnh chung** của tất cả nhân viên.

---

## Chuỗi B — Tối ưu trên khoảng

**Nấc 1.** Cho danh sách khoảng. Tìm **số khoảng ít nhất cần xoá** để các khoảng còn lại không chồng lấn.

**Nấc 2.** Mỗi khoảng có thêm **trọng số**. Chọn tập con không chồng lấn có **tổng trọng số lớn nhất**. Greedy còn đúng không?

**Nấc 3.** Cho danh sách khoảng `[start, end]` và mảng `points[]`. Với mỗi điểm, đếm xem nó nằm trong bao nhiêu khoảng. Có `n` khoảng và `q` điểm — tối ưu cho `q` lớn.

**Nấc 4.** Cho mỗi khoảng, tìm khoảng **bắt đầu sớm nhất sau khi nó kết thúc** ("next interval"). Trả về mảng chỉ số.

**Nấc 5.** Cho danh sách khoảng có thể chồng lấn. Trả về **tổng độ dài phần được phủ** (union length).

---

## Chuỗi C — Động và quy mô lớn

**Nấc 1.** Thiết kế cấu trúc dữ liệu hỗ trợ `addRange(start, end)`, `queryRange(start, end)` (có phủ hoàn toàn không), `removeRange(start, end)`.

**Nấc 2.** Thiết kế `MyCalendar`: `book(start, end)` trả về `true` nếu không chồng với booking nào đã có. Rồi: `MyCalendarII` cho phép chồng tối đa 2 lần. Rồi: `MyCalendarIII` trả về mức chồng lấn tối đa hiện tại.

**Nấc 3.** Khoảng đến dạng **stream**, không sắp xếp sẵn, và bạn phải trả lời "số khoảng đang chồng nhau nhiều nhất" **sau mỗi lần thêm**. Cấu trúc nào cho O(log n) mỗi thao tác?

**Nấc 4.** Có **10⁹ khoảng** lưu trên đĩa, không vừa RAM. Gộp chúng lại. Chiến lược?

**Nấc 5.** Khoảng trên **2 chiều** (hình chữ nhật). Tính diện tích union của `n` hình chữ nhật.

---

## Câu chốt hạ hay gặp

- "Hai khoảng chạm nhau tại đúng một điểm `[1,3]` và `[3,5]` — có tính là chồng lấn không? Ai quyết định?"
- "Khoảng **nửa mở** `[start, end)` thay đổi điều kiện so sánh thế nào?"
- "Bạn sort theo `start` hay theo `end`? Với bài nào thì sort theo `end` mới đúng?"
- "Có cách nào **không cần sort** không, nếu `start`/`end` là số nguyên nhỏ?"
- "Chi phí chủ yếu là O(n log n) do sort — nếu dữ liệu đã gần sort thì tận dụng ra sao?"
