package uni.aed.queue;
import uni.aed.listTDA.ListTDA;
import uni.aed.linkedlistTDA.LinkedListTDA;

public class ListQueueTDA<E> implements QueueTDA<E> {    
    private static final int FRENTE=0;
    private ListTDA<E> lista;    
    
    public ListQueueTDA() {
        this.lista = new LinkedListTDA<E>();
    }
    public void add(E elementos){//enqueue
        lista.add(lista.size(),elementos);        
    }
    
    public E delete()throws QueueEmptyExceptionTDA{//dequeue
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        else
            return lista.delete(FRENTE);
    }
    
    public E get() throws QueueEmptyExceptionTDA{//peek
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        else
            return lista.get(FRENTE);
    }
    
    public void clear(){
        lista.clear();
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }    
    
    public int size(){
        return lista.size();
    }
    
    @Override
    public String toString(){
        return lista.toString();
    }

    @Override
    public void offer(E elemento, int prioridad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
