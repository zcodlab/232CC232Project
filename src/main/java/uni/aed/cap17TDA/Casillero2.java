package uni.aed.cap17TDA;

public class Casillero2<T1,T2> {
    private T1 contenido1;
    private T2 contenido2;
    public Casillero2() {
        this(null,null);
    }
    
    public Casillero2(T1 elemento1,T2 elemento2) {
        contenido1=elemento1;
        contenido2=elemento2;
    }

    public void setContenido1(T1 contenido1) {
        this.contenido1 = contenido1;
    }

    public void setContenido2(T2 contenido2) {
        this.contenido2 = contenido2;
    }

    public T1 getContenido1() {
        return contenido1;
    }

    public T2 getContenido2() {
        return contenido2;
    }
}
