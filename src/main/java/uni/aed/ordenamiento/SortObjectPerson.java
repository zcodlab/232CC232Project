package uni.aed.ordenamiento;

import uni.aed.model.Persona;

public class SortObjectPerson {
    public Persona[ ] Burbuja ( Persona[] X,int attribute ) {
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }   
        Persona p1,p2,aux;   
        int comparisonResult;
        X[0].setCompareAttribute( attribute );
        for(int i=0;i<X.length - 1; i++){            
            for(int j=0;j<X.length - 1; j++){    
                p1=X[j];
                p2=X[j+1];
                comparisonResult = p1.compareTo( p2 );
                if(comparisonResult>0){//p1 es mayor
                    aux=X[j];
                    X[j]=X[j+1];
                    X[j+1]=aux;                    
                }
            }//end for
        }//end for
        return X;
    }
    
    public Persona[] Insercion( Persona[] X,int attribute){    
        if (!(attribute == Persona.NAME || attribute == Persona.AGE) ) {
            throw new IllegalArgumentException( );
        }  
        Persona aux,p;
        int comparisonResult;
        X[0].setCompareAttribute( attribute );
        int k;
        boolean sw=false;           
        for(int i=1; i<X.length;i++)
        {   aux=X[i];
            k=i-1;
            sw=false;
            while(sw==false && k>=0){ 
                p=X[k];
                comparisonResult = p.compareTo( aux );
                if(comparisonResult>0)
                { X[k+1]=X[k];
                  k--;}
                else
                    sw=true;
            }//end while            
            X[k+1]=aux;
        }//end for
        return X;
    }
}
