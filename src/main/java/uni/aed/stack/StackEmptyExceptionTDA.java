package uni.aed.stack;

public class StackEmptyExceptionTDA extends RuntimeException {

    public StackEmptyExceptionTDA(String message) {
        super(message);
    }
    
    public StackEmptyExceptionTDA() {
        this("La Pila esta vacia");   }
    
    
    
}
