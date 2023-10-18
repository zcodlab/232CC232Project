package uni.aed.cap1624heapsortlista;

public class TestHeapSortDoubleLinkedList {
     public static void main(String[] args) {
        heapsort();
    }
     
    public static void heapsort(){
        HeapSort heapSort = new HeapSort();
        
        heapSort.add(7);
        heapSort.add(10);
        heapSort.add(5);
        heapSort.add(3);
        heapSort.add(8);
        System.out.println("Original List:");
        heapSort.printSorted();
        
        heapSort.sort();
        
        System.out.println("Orden List:");
        heapSort.printSorted();        

    }
}
