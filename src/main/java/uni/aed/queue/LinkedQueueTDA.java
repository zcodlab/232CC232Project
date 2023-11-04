package uni.aed.queue;

import uni.aed.linkedlistTDA.Nodo;

public class LinkedQueueTDA<E> implements QueueTDA<E>{
    private Nodo front;
    private Nodo back;
    private int contador;

    public LinkedQueueTDA() {
        clear();
    }
    @Override
    public void add(E item) {
        Nodo newNodo=new Nodo(item);
        if(isEmpty())
            front=back=newNodo;
        else{
            back.setNext(newNodo);
            back=newNodo;
        }
        contador++;
    }
    @Override
    public E delete() {
        E item;
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        else{
            item=(E)front.getData();
            front=front.getNext();
            contador--;
        }
        return item;    
    }

    @Override
    public E get() {
        if(isEmpty())
            throw new QueueEmptyExceptionTDA();
        else
            return (E)front.getData();
    }

    @Override
    public void clear() {
        front=back=null;
        contador=0;
    }

    @Override
    public boolean isEmpty() {
        return (contador==0);
    }

    @Override
    public int size() {
        return contador;
    }
    @Override
    public String toString(){
        String result="";
        Nodo current=front;
        while(current!=null){
            result=result+"->"+current.getData();
            current=current.getNext();
        }
        return result;
    }

    @Override
    public void offer(E elemento, int prioridad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
