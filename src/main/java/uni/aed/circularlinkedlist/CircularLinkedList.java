package uni.aed.circularlinkedlist;

public class CircularLinkedList {
    Nodo head;
    public void add(int data) {
        Nodo newNodo = new Nodo(data);
        if (head == null) {
            head = newNodo;
            head.next = head;
            return;
        }
        Nodo current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNodo;
        newNodo.next = head;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            Nodo current = head;

            while (current.next != head) {
                current = current.next;
            }

            head = head.next;
            current.next = head;
            return;
        }

        Nodo current = head;

        while (current.next != head && current.next.data != data) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    public void printList() {
        if (head == null) {
            return;
        }

        Nodo current = head;

        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != head);
    }
}