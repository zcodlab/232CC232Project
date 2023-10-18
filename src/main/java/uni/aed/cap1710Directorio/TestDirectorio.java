package uni.aed.cap1710Directorio;

import uni.aed.model.Empleado;
import uni.aed.model.Persona;

public class TestDirectorio {
    public static void main(String[] args) {        
        Directorio<Empleado> lista= new Directorio<>(2);
        lista.add(new Empleado("Jose",30,'M',"Gerente"));                                
        lista.add(new Empleado("Pedro",35,'M',"Jefe de RRHH"));        
        lista.add(new Empleado("Josefina",45,'F',"Analista de Presupuesto"));        
        lista.add(new Empleado("Isabel",25,'F',"Analista Programador"));
        System.out.println("Visualizando el contenido del Array");
        lista.imprimir();        
        System.out.println("Buscando Jose para su eliminacion");
        String name="Jose";        
        System.out.println("Eliminando...");
        lista.deleteAll(name);        
        lista.imprimir();
    }
    
    public static void testPersona(){
        Directorio<Persona> lista= new Directorio<>(2);
        lista.add(new Persona("Jose",30,'M'));                                
        lista.add(new Persona("Pedro",35,'M'));        
        lista.add(new Persona("Jose",45,'F'));        
        lista.add(new Persona("Isabel",25,'F'));        
        System.out.println("Visualizando el contenido del Array");
        lista.imprimir();        
        System.out.println("Buscando Jose para su eliminacion");
        String name="Jose";        
        System.out.println("Eliminando...");
        lista.deleteAll(name);        
        lista.imprimir();
    }
}
