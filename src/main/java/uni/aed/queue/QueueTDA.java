package uni.aed.queue;

public interface QueueTDA<E> {
    public void add(E elemento);//enqueue
    public E delete();//dequeue
    public E get();//peek
    public void clear();
    public boolean isEmpty();
    public int size();    
    public void offer(E elemento,int prioridad);//enqueue
    
}
