package uni.aed.list;

public interface IteratorTDA<E> {
    public boolean hasNext();
    public E next() throws NoSuchElementException;
    
}
