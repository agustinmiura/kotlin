package ar.com.miura.jvm.queue;

public class FirstUniqueElement {
    
    private Queue<Integer> queue = new LinkedList<Integer>();

    private Map<Integer, Boolean> uniqueMap = new HashMap<>();

    public FirstUnique(int[] nums) {
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
