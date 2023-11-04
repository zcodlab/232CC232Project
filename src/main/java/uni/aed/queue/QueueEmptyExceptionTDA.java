package uni.aed.queue;

public class QueueEmptyExceptionTDA extends RuntimeException{

    public QueueEmptyExceptionTDA() {
        this("Cola Vacia");
    }
    public QueueEmptyExceptionTDA(String msg) {
        super(msg);
    }
    
    
}
