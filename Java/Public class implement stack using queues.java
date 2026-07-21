Public class implement stack using queues
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Pushes element x to the top of the stack.
    // Time Complexity: O(n)
    public void push(int x) {
        queue.add(x);
        // Rotate the queue to bring the newly added element to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    // Removes the element on the top of the stack and returns it.
    // Time Complexity: O(1)
    public int pop() {
        return queue.remove();
    }
    
    // Returns the element on the top of the stack.
    // Time Complexity: O(1)
    public int top() {
        return queue.peek();
    }
    
    // Returns true if the stack is empty, false otherwise.
    // Time Complexity: O(1)
    public boolean empty() {
        return queue.isEmpty();
    }
}