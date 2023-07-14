package DoublyLinkedList; // 16:57 ~ 17:14

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.print();

        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(3);
        dll.print();

        dll.insertNode(1,4);
        dll.insertNode(1,5);
        dll.print();

        dll.deleteNode(1);
        dll.print();

        dll.deleteNode(1);
        dll.print();

        dll.deleteNode(100);
        dll.print();

        System.out.println(dll.findNode(1));
        System.out.println(dll.findNode(2));
        System.out.println(dll.findNode(3));
        System.out.println(dll.findNode(4));

        dll.printReverse();
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

class DoublyLinkedList {
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
            this.head = new Node(data, null, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, cur, null);
        }
    }

    void insertNode(int offset, int data) {
        if (isEmpty()) {
            this.head = new Node(data, null, null);
        } else {
            if (offset == 0) {
                Node newNode = new Node(data,null ,this.head);
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

                if (offset == getSize() - 1) {
                    prev.next = null;
                } else {
                    prev.next = prev.next.next;
                    prev.next.prev = prev;
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

    void printReverse() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }

            while(cur.prev!=null){
                System.out.print(cur.data + ", ");
                cur = cur.prev;
            }

            System.out.print(cur.data + "\n");
        }
    }
}
