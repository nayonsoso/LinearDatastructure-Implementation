package Stack;

class Stack{
    int[] stack;
    int top = -1;

    Stack(int size){
        this.stack = new int[size];
    }
    public boolean isEmpty(){
        if(top == -1){
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(){
        if(top == stack.length-1){
            return true;
        } else {
            return false;
        }
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack is full.");
        } else {
            this.top++;
            this.stack[this.top] = data;
        }
    }

    // null을 리턴할 수 있으므로 리턴 타입을 int가 아니라 Integer로 설정
    public Integer pop(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        } else {
            int v = this.stack[this.top];
            this.stack[this.top] = 0; // 사실 stap의 영역은 top까지이므로 안해줘도 상관 없음
            this.top--;
            return v;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        } else {
            int v = this.stack[this.top];
            return v;
        }
    }

    public void print(){
        for (int i=0; i<=this.top; i++) {
            System.out.print(this.stack[i]+" ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        for (int i = 0; i <= 5; i++) {
            stack.push(i);
        }

        stack.print();

        for (int i = 0; i <= 5; i++) {
            Integer result = stack.pop();
            System.out.print(result==null ? " " : result+" ");
        }
    }
}