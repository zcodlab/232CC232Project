package uni.aed.trees.TBT;
public class TestTBT {
    public static void main(String[] args){
        TBT t=new TBT();
        t.insert(15);
        t.insert(4);
        t.insert(20);
        t.insert(17);
        t.insert(19);
        System.out.println("TBTInOrder(LVR) ");
        t.TBTInOrder();
    }
    
}
