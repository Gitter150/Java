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
    void display() {
        if(this.head == null) {
            throw new NoSuchElementException("The list is empty! Cannot display it.");
        }
        Node curr;
        curr = this.head;
        while(curr != null) {
            System.out.print((curr==this.head? "head -> ":" -> ") + "("+curr.data+")" + (curr.next==null? " -> null":""));
            curr = curr.next;
        }
        System.out.println();
    }
}

class linkedList {
    public static void main(String[] args) {
        List lst = new List();
        lst.push_back(0);
        lst.push_back(1);
        lst.push_back(2);
        lst.display();
        lst.pop_back();
        lst.display();
    }
}




