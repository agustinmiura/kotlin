package ar.com.miura.jvm.stack;

class FreqStack {

    private java.util.Map<Integer, Integer> freqMap = new java.util.HashMap<Integer, Integer>();

    private java.util.Stack<TopElement> stack = new java.util.Stack<TopElement>();

    public FreqStack() {}

    public void push(int val) {
        Integer freq = freqMap.getOrDefault(val, 0);
        freq++;
        freqMap.put(val, freq);
        stack.push(new TopElement(val, freq));
    }

    public int pop() {
        Integer maxQty = Integer.MIN_VALUE;
        Integer qty = Integer.MIN_VALUE;
        for(java.util.Map.Entry<Integer,Integer> entry:freqMap.entrySet()) {
            maxQty = Math.max(maxQty, entry.getValue());
        }
        java.util.List<TopElement> list = new java.util.ArrayList<TopElement>();
        TopElement topElement = null;
        while(!stack.isEmpty()) {
            TopElement element = stack.pop();
            if (element.frequency.equals(maxQty) && topElement == null) {
                topElement = element;
                int size = list.size();
                for(int i=size-1;i>=0;i--) {
                    stack.push(list.get(i));
                }
                break;
            } else {
                list.add(element);
            }
        }
        return topElement.element;
    }
}
