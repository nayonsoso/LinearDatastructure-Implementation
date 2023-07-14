package SinglyLinkedList;// 15:51 ~ 16:34

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.print();

        sll.addNode(1);
        sll.addNode(2);
        sll.addNode(3);
        sll.print();

        sll.insertNode(1,4);
        sll.insertNode(1,5);
        sll.print();

        sll.deleteNode(1);
        sll.print();

        sll.deleteNode(1);
        sll.print();

        sll.deleteNode(100);
        sll.print();

        System.out.println(sll.findNode(1));
        System.out.println(sll.findNode(2));
        System.out.println(sll.findNode(3));
        System.out.println(sll.findNode(4));
    }
}

class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList {
    Node head;

    boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    int getSize() {
        int size = 0;
        if (!isEmpty()) {
            size = 1;
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
                size++;
            }
        }
        return size;
    }

    void addNode(int data) {
        if (isEmpty()) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    void insertNode(int offset, int data) {
        if (isEmpty()) {
            this.head = new Node(data, null);
        } else {
            if (offset == 0) {
                Node newNode = new Node(data, this.head);
                this.head = newNode;
            } else if (offset == getSize()) {
                addNode(data);
            } else {
                int prevIdx = 0;
                Node prev = this.head;
                while (prevIdx != offset-1) {
                    prev = prev.next;
                    prevIdx++;
                }
                Node newNode = new Node(data, prev.next);
                prev.next = newNode;
            }
        }
    }

    void deleteNode(int offset) {
        if(isEmpty()){
            System.out.println("Empty");
        } else {
            if (offset == 0) {
                if(getSize() == 1){
                    this.head = null;
                } else {
                    this.head = this.head.next;
                }
            } else if (offset >= getSize()){
                System.out.println("Wrong delete");
            } else {
                int prevIdx = 0;
                Node prev = this.head;
                while (prevIdx != offset-1) {
                    prev = prev.next;
                    prevIdx++;
                }

                if (offset == getSize() - 1) {
                    prev.next = null;
                } else {
                    prev.next = prev.next.next;
                }
            }
        }
    }

    int findNode(int data){
        if(isEmpty()){
            return -1;
        }

        int curIdx = 0;
        Node cur = this.head;
        while(cur.next != null){
            if(cur.data == data){
                break;
            }
            curIdx++;
            cur = cur.next;
        }

        if(curIdx == getSize()-1 && cur.data !=data){
            return -1;
        }

        return curIdx;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                System.out.print(cur.data + ", ");
                cur = cur.next;
            }
            System.out.print(cur.data + "\n");
        }
    }
}
