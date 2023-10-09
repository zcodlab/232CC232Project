package uni.aed.osimplelinkedlist;

import uni.aed.model.Bicicleta;
import java.util.Scanner;
import uni.aed.model.Persona;

public class TestBicicleta {
     public static void main(String[] args) {
        TestBicicleta();           
    }
    public static void TestBicicleta(){
        Scanner escaner=new Scanner(System.in);        
        Bicicleta b;
        ObjectSimpleLinkedList simpleLinkedList=new ObjectSimpleLinkedList();
        String nombre;        
        System.out.println("Consigne nombres de propietarios de las bicicletas:");        
        //creando la lista enlazada de objetos
        while(true){
            nombre=escaner.next();
            if(!nombre.equalsIgnoreCase("salir")){
                b=new Bicicleta(nombre);
                simpleLinkedList.addLast(b);            
            }else break;
        }
        
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());        
        //Busqueda de objeto en lista enlazada                
        //Eliminar objeto en lista enlazada        
        System.out.println("Eliminar Objeto en lista enlazada");
        System.out.println("Consigne el nombre que desea eliminar de la lista en enlazada: ");
        nombre=escaner.next();
        b=new Bicicleta(nombre);
        simpleLinkedList.remove(b);
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());  
    }
    public static void TestPersona(){
        Scanner escaner=new Scanner(System.in);        
        Persona b;
        ObjectSimpleLinkedList simpleLinkedList=new ObjectSimpleLinkedList();
        String nombre;        
        System.out.println("Consigne nombres de propietarios de las bicicletas:");        
        //creando la lista enlazada de objetos
        while(true){
            nombre=escaner.next();
            if(!nombre.equalsIgnoreCase("salir")){
                b=new Persona(nombre,20,'M');
                simpleLinkedList.addLast(b);            
            }else break;
        }
        
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());        
        //Busqueda de objeto en lista enlazada                
        //Eliminar objeto en lista enlazada        
        System.out.println("Eliminar Objeto en lista enlazada");
        System.out.println("Consigne el nombre que desea eliminar de la lista en enlazada: ");
        nombre=escaner.next();
        b=new Persona(nombre,20,'M');
        simpleLinkedList.remove(b);
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());  
    }
    public static void TestInteger(){
        Scanner escaner=new Scanner(System.in);        
        Integer b;
        ObjectSimpleLinkedList simpleLinkedList=new ObjectSimpleLinkedList();
        String nombre;        
        System.out.println("Consigne numeros:");        
        //creando la lista enlazada de objetos
        while(true){
            nombre=escaner.next();
            if(!nombre.equalsIgnoreCase("salir")){
                b=Integer.valueOf(nombre);
                simpleLinkedList.addLast(b);            
            }else break;
        }
        
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());        
        //Busqueda de objeto en lista enlazada                
        //Eliminar objeto en lista enlazada        
        System.out.println("Eliminar Objeto en lista enlazada");
        System.out.println("Consigne el numero que desea eliminar de la lista en enlazada: ");
        nombre=escaner.next();
        b=Integer.valueOf(nombre);
        simpleLinkedList.remove(b);
        //Visualizando el contenido de la lista enlazada
        System.out.print("Visualizando el contenido de la lista enlazada: ");
        System.out.println(simpleLinkedList.toString());   
    }
}
