class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class CircularLinkedList {
    Node head = null;
    Node tail = null;
    public void insert(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }
    public void insertBeg(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            n.next = head;
            head = n;
            tail.next = head;
        }
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }
    public void deleteBeg() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }
    public void deleteEnd() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }
}
public class Circular {
    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insertBeg(5);
        System.out.println("Circular Linked List:");
        ll.display();
        ll.deleteBeg();
        System.out.println("After deletion at beginning:");
        ll.display();
        ll.deleteEnd();
        System.out.println("After deletion at end:");
        ll.display();
    }
}