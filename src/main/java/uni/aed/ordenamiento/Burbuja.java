package uni.aed.ordenamiento;
/**
 * Esta clase implementa el método de la burbuja. 
 * @author: uni.aed
 */
public class Burbuja {
    public static Integer[] burbuja(Integer[] X){
        int aux=0;
        for(int i=0;i<X.length - 1; i++){
            for(int j=0;j<X.length - 1; j++){
                if(X[j]>X[j+1]){
                    aux=X[j];
                    X[j]=X[j+1];
                    X[j+1]=aux;                    
                }                   
            }
        }
        return X;
    }
    
}
