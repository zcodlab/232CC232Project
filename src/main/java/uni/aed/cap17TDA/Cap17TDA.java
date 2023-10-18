package uni.aed.cap17TDA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uni.aed.model.Escoba;
import uni.aed.model.Libro;

public class Cap17TDA {

    public static void main(String[] args) {
        testColeccionAnidadaLibro();
        //testCasillero6();        
    }
    public static void testCasillero1(){
        Casillero1<String> casilleroUno;
        Casillero1<Integer> casilleroDos;
        casilleroUno=new Casillero1<>();
        casilleroDos=new Casillero1<>();
        
        casilleroUno.setContenido("Hola");
        casilleroDos.setContenido(100);
        
        String cadena=casilleroUno.getContenido();
        Integer entero=casilleroDos.getContenido();
                        
        System.out.println("Valores ingresados a la clase generica; cadena: "+cadena+" entero:"+entero);
        System.out.println("La clase de casillero uno es: "+ casilleroUno.getClass().getName());
        System.out.println("La clase de casillero dos es: "+ casilleroDos.getClass().getName());
    }
    public static void testCasillero2(){
        Casillero2<String,Integer> casillero;        
        casillero=new Casillero2<>("Hola",100);
        
        Casillero2<String,String> saludo;        
        saludo=new Casillero2<>("Hola","Java");
        
        String cadena=casillero.getContenido1();
        Integer entero=casillero.getContenido2();
                        
        System.out.println("Valores ingresados a la clase generica; cadena: "+cadena+" entero:"+entero);        
        System.out.println("Valores ingresados a la clase generica; cadena: "+saludo.getContenido1()+" entero:"+saludo.getContenido2());
    }
    public static void testCasillero3(){
        Casillero3<String> casillero3= new Casillero3<>("Hola","Java");                        
        System.out.println("Valores ingresados a la clase generica; cadena: "+casillero3.getContenido1()+" entero:"+casillero3.getContenido2());
    }
    public static void testCasillero4(){
//        Casillero4<Number> casillero1= new Casillero4<Double>();                        
//        Casillero4<Double> casillero2= new Casillero4<Integer>();                        
        Casillero4<Number> casillero3= new Casillero4<Number>();  
        Casillero4<Double> casillero4= new Casillero4<Double>();                        
        Casillero4<Integer> casillero5= new Casillero4<Integer>(); 
        System.out.println("Valores ingresados a la clase generica; cadena: "+casillero3.getContenido()+" entero:"+casillero3.getContenido());
    }
    public static void testCasillero5(){
        Casillero5<Double> casillero1= 
                new Casillero5<>(3.0);  
        Casillero5<Integer> casillero2= 
                new Casillero5<>(3);  
        System.out.println("Los valores en casillero1 y casillero2 son los mismos: "+casillero1.isSameValue(casillero2));
    }
    public static void testCasillero6(){
        Casillero6<Double> casillero1= 
                new Casillero6<>(3.0);  
        Casillero6<Double> casillero2= 
                new Casillero6<>(3.0);  
        System.out.println("Los valores en casillero1 y casillero2 son los mismos: "+casillero1.isSameValue(casillero2));
    }
    //17.2 Genericos y colecciones
    public static void testColeccionLibroSinParametro(){
        List listaLibros=new ArrayList();        
        listaLibros.add(new Libro("Jane Austin"));
        listaLibros.add(new Libro("Charles Dickens"));
        listaLibros.add(new Libro("Henry James"));
        
        Iterator it=listaLibros.iterator();
        while(it.hasNext()){
            Libro libro=(Libro)it.next();
            System.out.println(libro.obtenAutor());
        }
    }
    
    public static void testColeccionLibroConParametro(){
        List<Libro> listaLibros=new ArrayList<>();        
        listaLibros.add(new Libro("Jane Austin"));
        listaLibros.add(new Libro("Charles Dickens"));
        listaLibros.add(new Libro("Henry James"));
        
        Iterator<Libro> it=listaLibros.iterator();
        while(it.hasNext()){
            Libro libro=it.next();
            System.out.println(libro.obtenAutor());
        }
        
        for(Libro libro:listaLibros)
            System.out.println(libro.obtenAutor());
            
    }
    //Declaracion de clase generica anidada
    public static void testColeccionAnidadaLibro(){
        List<Casillero1<Libro>> listaCasilleroLibros=new ArrayList<>();        
        Casillero1<Libro> casilleroLibros1=new Casillero1<>();
        casilleroLibros1.setContenido(new Libro("La Ciudad y los Perros"));
        listaCasilleroLibros.add(casilleroLibros1);
        
        Casillero1<Libro> casilleroLibros2=new Casillero1<>();
        casilleroLibros2.setContenido(new Libro("Cien años de soledad"));
        listaCasilleroLibros.add(casilleroLibros2);
        
        for(Casillero1<Libro> casillero:listaCasilleroLibros)
            System.out.println(casillero.getContenido().obtenAutor());
    }
    
    
    public static void testEscobaLibro(){
        Casillero1<Libro> casillero1,casillero2;
        Casillero1<Escoba> casillero3;
        casillero1=new Casillero1<>();
        casillero2=new Casillero1<>();
        casillero3=new Casillero1<>();
        casillero1.setContenido(new Libro("Edgar Allan Poe"));
        casillero3.setContenido(new Escoba());

        System.out.println(casillero1.getContenido());
        //System.out.println(casillero2.recupera().obtenAutor());
        System.out.println(casillero3.getContenido().obtenValor());

        /*Casillero<Integer>[] casilleros1;
        Casillero<Integer>[] casilleros2;
        Casillero[] casilleros3;
        casilleros1=new Casillero<Integer>[34];
        casilleros2=new Casillero[23];
        casilleros3=new Casillero<String>[20];*/
    }
}
