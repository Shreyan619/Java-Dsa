
import java.util.Stack;

//Implement Queue using Stacks
public class lc232 {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public lc232() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);

    }

    public int pop() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    public boolean empty() {
        return first.empty() && second.empty();
    }

    public static void main(String[] args) {
        lc232 Queue = new lc232();
        Queue.push(2);
        Queue.push(3);
        Queue.push(5);
        Queue.push(7);
        System.out.println("The element poped is " + Queue.pop());
        Queue.push(1);
        System.out.println("The top element is " + Queue.peek());
    }
}
