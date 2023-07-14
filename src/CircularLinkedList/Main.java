package CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.print();

        cll.addNode(1);
        cll.addNode(2);
        cll.addNode(3);
        cll.print();

        cll.insertNode(1,4);
        cll.insertNode(1,5);
        cll.print();

        cll.deleteNode(1);
        cll.print();

        cll.deleteNode(1);
        cll.print();

        cll.deleteNode(100);
        cll.print();

        System.out.println(cll.findNode(1));
        System.out.println(cll.findNode(2));
        System.out.println(cll.findNode(3));
        System.out.println(cll.findNode(4));

        cll.printReverse();
    }
}

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data, Node prev, Node next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class CircularLinkedList {
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
            while (cur.next != this.head) {
                cur = cur.next;
                size++;
            }
        }
        return size;
    }

    void addNode(int data) {
        if (isEmpty()) {
            this.head = new Node(data, null, null);
            this.head.prev = this.head;
            this.head.next = this.head;
        } else {
            Node last = this.head.prev;
            Node newNode = new Node(data, last, this.head);
            last.next = newNode;
            this.head.prev = newNode;
        }
    }

    void insertNode(int offset, int data) {
        if (isEmpty()) {
            addNode(data);
        } else {
            if (offset == 0) {
                addNode(data);
                this.head = this.head.prev;
            } else if (offset == getSize()) {
                addNode(data);
            } else {
                int prevIdx = 0;
                Node prev = this.head;
                while (prevIdx != offset-1) {
                    prev = prev.next;
                    prevIdx++;
                }

                Node newNode = new Node(data, prev, prev.next);
                prev.next.prev = newNode;
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

                prev.next = prev.next.next;
                prev.next.prev = prev;
            }
        }
    }

    int findNode(int data){
        if(isEmpty()){
            return -1;
        }

        int curIdx = 0;
        Node cur = this.head;
        while(cur.next != this.head){
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
            while (cur.next != this.head) {
                System.out.print(cur.data + ", ");
                cur = cur.next;
            }
            System.out.print(cur.data + "\n");
        }
    }

    void printReverse() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node cur = this.head.prev;
            while(cur!=this.head){
                System.out.print(cur.data + ", ");
                cur = cur.prev;
            }

            System.out.print(cur.data + "\n");
        }
    }
}
