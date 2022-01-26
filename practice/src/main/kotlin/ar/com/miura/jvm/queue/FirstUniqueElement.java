package ar.com.miura.jvm.queue;

public class FirstUniqueElement {

    private java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();

    private java.util.Map<Integer, Boolean> uniqueMap = new java.util.HashMap<>();

    public FirstUniqueElement(int[] nums) {
        for(int num:nums) {
            addNumber(num);
        }
    }

    public int showFirstUnique() {
        while( !queue.isEmpty() && !uniqueMap.getOrDefault(queue.peek(), false) ) {
            queue.remove();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            return -1;
        }
    }

    public void add(int value) {
        addNumber(value);
    }

    private void addNumber(int number) {
        if (!uniqueMap.containsKey(number)) {
            uniqueMap.put(number ,true);
            queue.add(number);
        } else {
            uniqueMap.put(number, false);
        }
    }
}
