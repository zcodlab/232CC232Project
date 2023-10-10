package uni.aed.linkedlistTDA;

public class TestLinkedListTDA {
    public static void main(String[] args) {
        LinkedListTDA<String> linkedListTDA = new LinkedListTDA();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        linkedListTDA.add("Jose");
        linkedListTDA.add("Beatriz");
        linkedListTDA.add("Sandro");
        linkedListTDA.add("Franklin");
        linkedListTDA.add(2,"Adelaida");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+linkedListTDA.size());
        linkedListTDA.imprimir();
        String elemento="Adelaida";
        if (linkedListTDA.contain(elemento)==true){            
            System.out.println("El elemento buscado: "+ elemento +" se encuentra en la posicion: "+ linkedListTDA.indexOf(elemento)+" se procedera a su eliminacion.");            
            linkedListTDA.delete(linkedListTDA.indexOf(elemento));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList
        linkedListTDA.imprimir();   
        System.out.println("Añadiedo 1 registro en la posicion 2");
        linkedListTDA.add(2, "Steve Jobs");
        //imprimiendo elementos de la LinkedList
        linkedListTDA.imprimir(); 
    }
}
