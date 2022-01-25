package ar.com.miura.jvm.monotonicstack;

public class ReplaceElementsWithRight {
    public int[] replaceElements(int[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        int size = arr.length;
        stack.push(arr[size-1]);

        int[] elements = new int[size];
        elements[size-1] = -1;

        for(int i=size-2;i>=0;i--) {
            elements[i] = stack.peek();
            while(!stack.isEmpty() && arr[i]>stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && arr[i]>stack.peek()) {
                stack.push(arr[i]);
            } else if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
        }
        return elements;
    }
}
