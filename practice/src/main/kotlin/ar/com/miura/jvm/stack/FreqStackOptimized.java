package ar.com.miura.jvm.stack;

public class FreqStackOptimized {

    private java.util.Map<Integer, Integer> freqMap = new java.util.HashMap<Integer, Integer>();
    private java.util.Map<Integer, java.util.Stack<Integer>> stackMap = new java.util.HashMap();
    private int maxFrequency = Integer.MIN_VALUE;

    public FreqStackOptimized() {}

    public void push(int val) {

        int frequency = freqMap.getOrDefault(val, 0);
        frequency++;
        freqMap.put(val, frequency);

        if (frequency>maxFrequency) {
            maxFrequency = frequency;
        }

        java.util.Stack<Integer> stack = stackMap.getOrDefault(frequency, new java.util.Stack());
        stack.push(val);
        stackMap.put(frequency, stack);

    }

    public int pop() {

        int maxFrequency = getMaxFrequency();

        java.util.Stack<Integer> stack = stackMap.get(maxFrequency);
        int key = stack.pop();
        if (stack.isEmpty()) {
            this.maxFrequency--;
        }

        int freq = freqMap.get(key);
        freq--;
        freqMap.put(key, freq);

        return key;

    }

    private int getMaxFrequency() {
        return this.maxFrequency;
    }
}
