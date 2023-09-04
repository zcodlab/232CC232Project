package uni.aed.ordenamiento;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Ordenamiento {
    int nIntercambios=0;
    int nComparaciones=0;
    long tEjecucion=0;    

    public void setnIntercambios(int nIntercambios) {
        this.nIntercambios = nIntercambios;
    }
    public void setnComparaciones(int nComparaciones) {
        this.nComparaciones = nComparaciones;
    }
    public int getnIntercambios() {
        return nIntercambios;
    }
    public int getnComparaciones() {
        return nComparaciones;
    }    
    public void settEjecucion(long tEjecucion) {
        this.tEjecucion = tEjecucion;
    }
    public long gettEjecucion() {
        return tEjecucion;
    }
    public Integer[] burbuja(Integer[] X){                
        int aux=0;                
        int tintercambios=0,tcomparaciones=0;
        long tiempoIni=System.nanoTime();
        for(int i=0;i<X.length - 1; i++){            
            for(int j=0;j<X.length - 1; j++){
                tcomparaciones++;
                if(X[j]>X[j+1]){
                    aux=X[j];
                    X[j]=X[j+1];
                    X[j+1]=aux;
                    tintercambios++;
                }}}
        long tiempoFin=System.nanoTime();
        long tiempoEjecucion=tiempoFin-tiempoIni;
        this.setnIntercambios(tintercambios);
        this.setnComparaciones(tcomparaciones);
        this.settEjecucion(tiempoEjecucion);
        System.out.println("Tiempo de Ejecucion(ns):"+ tiempoEjecucion);        
        return X;
    }
    
    public Integer[] insercion(Integer[] X){        
        int aux,k;
        boolean sw=false;
        int tintercambios=0,tcomparaciones=0;
        long tiempoIni=System.nanoTime();
        for(int i=1; i<X.length;i++)
        {   aux=X[i];
            k=i-1;
            sw=false;
            while(sw==false && k>=0){
                tcomparaciones++;
                if(aux<X[k])
                { X[k+1]=X[k];
                  k--;}
                else
                    sw=true;
            }//end while
            tintercambios++;
            X[k+1]=aux;
        }//end for
        
        long tiempoFin=System.nanoTime();
        long tiempoEjecucion=tiempoFin-tiempoIni;
        this.setnIntercambios(tintercambios);
        this.setnComparaciones(tcomparaciones);
        this.settEjecucion(tiempoEjecucion);
        System.out.println("Tiempo de Ejecucion(ns):"+ tiempoEjecucion);        
        return X;
    }
    public Integer[] insercionBinaria(Integer[] X){
        int aux,p,u,c;
        int tintercambios=0,tcomparaciones=0;
        long tiempoIni=System.nanoTime();
        for(int i=1;i<X.length;i++)
        {   aux=X[i];
            p=0;
            u=i-1;
            while(p<=u){
                c=(p+u)/2;
                tcomparaciones++;
                if(aux<X[c])
                    u=c-1;
                else p=c+1;}//end while
            for(int k=i-1;k>=p;k--)                
                X[k+1]=X[k];
            tintercambios++;
            X[p]=aux;
        }//end for
        long tiempoFin=System.nanoTime();
        long tiempoEjecucion=tiempoFin-tiempoIni;
        this.setnIntercambios(tintercambios);
        this.setnComparaciones(tcomparaciones);
        this.settEjecucion(tiempoEjecucion);
        System.out.println("Tiempo de Ejecucion(ns):"+ tiempoEjecucion);        
        return X;
    }
    public Integer[] seleccion4c(Integer[] X){
        int aux,k;
        int tintercambios=0,tcomparaciones=0;
        long tiempoIni=System.nanoTime();
        for(int i=0; i<X.length-1;i++){
            aux=X[i];
            k=i;
            for(int j=i+1;j<X.length;j++){
                tcomparaciones++;
                if(X[j]<aux){
                    aux=X[j];
                    k=j;}                    
            }
            tintercambios++;
            X[k]=X[i];
            X[i]=aux;
        }        
        long tiempoFin=System.nanoTime();
        long tiempoEjecucion=tiempoFin-tiempoIni;
        this.setnIntercambios(tintercambios);
        this.setnComparaciones(tcomparaciones);
        this.settEjecucion(tiempoEjecucion);
        System.out.println("Tiempo de Ejecucion(ns):"+ tiempoEjecucion);        
        return X;
    }
}