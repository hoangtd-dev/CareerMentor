## Linked List

**Ý tưởng:** Các node nối nhau bằng pointer, không lưu liền kề trong bộ nhớ như array.

```
[data|next] → [data|next] → [data|next] → null
```

---

## 3 dạng

### 1. Singly Linked List

Mỗi node có 1 pointer trỏ về phía trước.

```
A → B → C → null
```

| Thao tác             | Time     | Space |
| -------------------- | -------- | ----- |
| Access (tìm index i) | O(n)     | O(1)  |
| Search               | O(n)     | O(1)  |
| Insert đầu           | O(1)     | O(1)  |
| Insert cuối          | O(n)     | O(1)  |
| Insert giữa          | O(n + 1) | O(1)  |
| Delete đầu           | O(1)     | O(1)  |
| Delete cuối          | O(n)     | O(1)  |
| Delete giữa          | O(n + 1) | O(1)  |

---

### 2. Doubly Linked List

Mỗi node có 2 pointer: 1 trỏ tới, 1 trỏ lui.

```
null ← A ⇄ B ⇄ C → null
```

| Thao tác    | Time     | Space |
| ----------- | -------- | ----- |
| Access      | O(n)     | O(1)  |
| Search      | O(n)     | O(1)  |
| Insert đầu  | O(1)     | O(1)  |
| Insert cuối | O(1)\*   | O(1)  |
| Insert giữa | O(n + 1) | O(1)  |
| Delete đầu  | O(1)     | O(1)  |
| Delete cuối | O(1)\*   | O(1)  |
| Delete giữa | O(n + 1) | O(1)  |

> \*O(1) nếu có pointer giữ sẵn tail node.

**Khác Singly:** Delete/Insert cuối nhanh hơn vì có thể đi ngược từ tail.

---

### 3. Circular Linked List

Node cuối trỏ ngược về node đầu, không có null.

```
A → B → C → A (vòng lại)
```

| Thao tác    | Time   | Space |
| ----------- | ------ | ----- |
| Access      | O(n)   | O(1)  |
| Search      | O(n)   | O(1)  |
| Insert đầu  | O(1)   | O(1)  |
| Insert cuối | O(1)\* | O(1)  |
| Delete đầu  | O(1)   | O(1)  |
| Delete cuối | O(n)   | O(1)  |

> \*O(1) nếu giữ pointer tại tail.

---

## So sánh 3 dạng

|              | Singly       | Doubly    | Circular                  |
| ------------ | ------------ | --------- | ------------------------- |
| Pointer/node | 1            | 2         | 1 hoặc 2                  |
| Space/node   | O(n + 1)     | O(n + 2)  | O(n + 1)                  |
| Đi ngược     | ❌           | ✅        | ❌                        |
| Dùng cho     | Stack, Queue | LRU Cache | Round-robin, Media player |

---

## So sánh với Array

|             | Array | Linked List       |
| ----------- | ----- | ----------------- |
| Access      | O(1)  | O(n)              |
| Insert đầu  | O(n)  | O(1)              |
| Insert cuối | O(1)  | O(1) hoặc O(n)    |
| Space       | O(n)  | O(n + số pointer) |
