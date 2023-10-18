package uni.aed.model;

public class Libro {
    private String autor;
    public Libro(){
            this("Desconocido");
    }
    public Libro(String autor){
            estableceAutor(autor);
    }
    public String obtenAutor(){
            return autor;
    }
    public void estableceAutor(String autor){
            this.autor=autor;
    }
}
