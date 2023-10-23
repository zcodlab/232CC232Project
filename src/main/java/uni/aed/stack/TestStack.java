package uni.aed.stack;

public class TestStack {
     public static void main(String[] args) {
         StackTDA<String> pila= new LinkedStackTDA<>();
         pila.push("Jose");
         pila.push("Pedro");
         pila.push("Sandro");
         System.out.println("Despues de ingresar elementos en la pila");         
         System.out.println(pila.toString());
         System.out.println("El numero de elementos en la pila es:" + pila.size());
         System.out.println("El elemento top en la pila es:" + pila.peek());
         System.out.println("Realizando una llamada a pop()");         
         pila.pop();
         System.out.println("Despues de llamar a pop()");         
         System.out.println("El numero de elementos en la pila es:" + pila.size());
         System.out.println("El elemento top en la pila es:" + pila.peek());
         System.out.println(pila.toString());
         
         System.out.println("Limpiando la pila");         
         pila.clear();
         System.out.println("visualizando elemento en la pila");         
         System.out.println(pila.toString());
         
         
        
    }
     public static void testArrayStackTDA(){
         StackTDA<String> pila= new ArrayStackTDA<>();
         pila.push("Jose");
         pila.push("Pedro");
         pila.push("Sandro");
         System.out.println("Despues de ingresar elementos en la pila");         
         System.out.println(pila.toString());
         System.out.println("El numero de elementos en la pila es:" + pila.size());
         System.out.println("El elemento top en la pila es:" + pila.peek());
         System.out.println("Realizando una llamada a pop()");         
         pila.pop();
         System.out.println("Despues de llamar a pop()");         
         System.out.println("El numero de elementos en la pila es:" + pila.size());
         System.out.println("El elemento top en la pila es:" + pila.peek());
         System.out.println(pila.toString());
         
         System.out.println("Limpiando la pila");         
         pila.clear();
         System.out.println("visualizando elemento en la pila");         
         System.out.println(pila.toString());
     }
}
