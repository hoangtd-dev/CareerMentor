public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);
        minHeap.add(1);

        while (minHeap.size > 0) {
            System.out.print(minHeap.removeMin() + " ");
        }
    }
}