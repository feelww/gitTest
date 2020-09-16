public class MinHeap {
    private HeapNode[] heapArray;
    private int maxSize;
    private int currentSize;

    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        heapArray = new HeapNode[maxSize];
        currentSize = 0;

    }

    // 自上而下扫描堆，pop()出堆时用于调整建堆
    public void filterDown(int start, int endOfHeap) {
        int i = start;
        int j = 2 * i + 1;
        HeapNode t = heapArray[i];
        while (j <= endOfHeap){
            if(j < endOfHeap && heapArray[j].compareTo(heapArray[j+1]) == 1)
                j ++;
            if(t.compareTo(heapArray[j]) <= 0)
                break;
            else{
                heapArray[i] = heapArray[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        heapArray[i] = t;
    }

    // 自下而上扫描堆，用于put()时调整建堆
    public void filterUp(int start){
        int j = start;
        int i = (j - 1) / 2;
        HeapNode t = heapArray[j];
        while (j > 0){
            if(heapArray[i].compareTo(t) <= 0)
                break;
            else{
                heapArray[j] = heapArray[i];
                j = i;
                i = (i - 1) / 2;
            }
        }
        heapArray[j] = t;
    }

    public boolean put(HeapNode t){
        boolean bool = true;
        if(isFull())
            bool = false;
        else{
            heapArray[currentSize] = t;
            filterUp(currentSize);
            currentSize ++;
        }
        return bool;
    }

    public HeapNode removeMin(){
        if (isEmpty()) {
            System.out.println("堆已为空");
            return null;
        }
        HeapNode root = heapArray[0];
        heapArray[0] = heapArray[currentSize - 1];
        currentSize --;
        filterDown(0, currentSize - 1);
        return root;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public void printList(){
        for (int i = 0; i < currentSize; i ++){
            System.out.print(heapArray[i].lcost + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(20);
        int[] xa = new int[2];
        HeapNode node1 = new HeapNode(10,0,0,0,xa);
        HeapNode node2 = new HeapNode(11,0,0,0,xa);
        HeapNode node3 = new HeapNode(7,0,0,0,xa);
        HeapNode node4 = new HeapNode(8,0,0,0,xa);
        HeapNode node5 = new HeapNode(12,0,0,0,xa);
        HeapNode node6 = new HeapNode(17,0,0,0,xa);
        minHeap.put(node1);
        minHeap.put(node2);
        minHeap.put(node3);
        minHeap.put(node4);
        minHeap.put(node5);
        minHeap.put(node6);

        minHeap.printList();


        System.out.println(minHeap.removeMin().lcost);

        minHeap.printList();
    }
}
