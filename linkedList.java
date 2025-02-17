import java.util.NoSuchElementException;

class List {
    private Node head, tail;
    private static class Node {
        int data;
        Node next;
        public Node(int x) {
            data = x;
            next = null;
        }
    }
    public List() {
        head = null;
        tail = null;
    }
    void push_front(int x) {
        Node first = new Node(x);
        first.next = this.head;
        this.head = first;
        if(tail == null) tail = first;
    }
    void push_back(int x) {
        if(this.head == null) {
            this.head = new Node(x);
            this.tail = this.head;
            return;
        }
        this.tail.next = new Node(x);
        this.tail = this.tail.next;   
    }
    void pop_front() {
        if(this.head == null) {
            throw new NoSuchElementException("The list is empty! Cannot display it.");
        }
        if(this.head.next == null) {
            this.tail = null;
            this.head = null;
            return;
        }
        this.head = this.head.next;
    }
    void pop_back() {
        if(this.head == null) {
            throw new NoSuchElementException("The list is empty! Cannot pop from back.");
        }
        if(this.head.next == null) {
            this.tail = null;
            this.head = null;
            return;
        }
        Node curr = this.head;
        while(curr.next != this.tail) curr = curr.next;
        curr.next = null;
        this.tail = curr;
    }
    int len() {
        if(this.head == null) return 0;
        int count = 0;
        Node curr = this.head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    void display(boolean Debug) {
        if(this.head == null) {
            throw new NoSuchElementException("The list is empty! Cannot display it.");
        }
        Node curr;
        curr = this.head;
        if(Debug) while(curr != null) {
            System.out.print((curr==this.head? "head -> ":" -> ") + curr.data + (curr.next==null? " -> null":""));
            curr = curr.next;
        }
        else while(curr != null) {
            System.out.print(curr == this.tail? (curr.data) + " ]":(curr == this.head? ("[ "+curr.data +", "):(curr.data + ", ")));
            curr = curr.next;
        }
        System.out.println();
    }
    void display() {
        this.display(false);
    }
    int peek_front() {
        if(this.head == null) throw new NoSuchElementException("List is empty! Can't retrieve front element");
        return this.head.data;
    } 
    int peek_back() {
        if(this.tail == null) throw new NoSuchElementException("List is empty! Can't retrieve front element");
        return this.tail.data;
    }
}

public class linkedList {
    public static void main(String[] args) {
        List lst = new List();
        for(int i=1;i<=5;i++) lst.push_back(i);
        lst.display();
        System.out.println("The length of the list is now "+lst.len());
    }
}
