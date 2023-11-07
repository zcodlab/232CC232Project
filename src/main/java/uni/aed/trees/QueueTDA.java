package uni.aed.trees;

import java.util.LinkedList;

public class QueueTDA<T> {
    private final LinkedList<T> list;

    public QueueTDA() {
        list = new LinkedList<>();
    }
    
    public void enqueue(T element){
        list.addLast(element);
    }
    public T dequeue(){
        return list.removeFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
