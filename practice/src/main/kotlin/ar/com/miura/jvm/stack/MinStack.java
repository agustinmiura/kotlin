package ar.com.miura.jvm.stack;

public class MinStack {
    private java.util.Deque<int[]> deque = new java.util.LinkedList<int[]>();

    public MinStack() {}

    public void push(int val) {

        if (deque.isEmpty()) {
            deque.offerFirst(new int[]{val, val});

        } else {
            int min = Math.min(val, deque.peekFirst()[1]);
            deque.offerFirst(new int[]{val, min});

        }
    }

    public void pop() {
        if (!deque.isEmpty()) {
            deque.pollFirst();
        }
    }

    public int top() {
        if (!deque.isEmpty()) {
            return deque.peekFirst()[0];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getMin() {

        if (!deque.isEmpty()) {
            int[] top = deque.getFirst();
            return top[1];

        } else {
            return Integer.MIN_VALUE;
        }

    }
}
