package uni.aed.queue;

public class TestQueueTDA {
    public static void main(String[] args){
        QueueTDA<String> q=new LinkedQueueTDA<>();
        q.add("Jose");
        q.add("Pedro");
        q.add("Sandro");
        
        System.out.println("Despues de insertar elementos en la cola");
        System.out.println(q.toString());
        System.out.println("Despues de eliminar elementos en la cola"+ q.delete());
        System.out.println(q.toString());
    }
    public static void TestArrayQueueTDA(){
        QueueTDA<Integer> q=new ArrayQueueTDA<>(5);
        q.add(30);
        q.add(10);
        q.add(20);        
        System.out.println("Despues de insertar elementos en la cola");
        System.out.println(q.toString());        
        q.delete();
        System.out.println("Despues eliminar");
        System.out.println(q.toString());
        q.delete();
        System.out.println("Despues eliminar");        
        System.out.println(q.toString());
        q.add(80);
        q.add(70);
        q.add(60);
        q.add(50);
        q.add(40);
        System.out.println("Despues 2 adicion");        
        System.out.println(q.toString());
    }
}
