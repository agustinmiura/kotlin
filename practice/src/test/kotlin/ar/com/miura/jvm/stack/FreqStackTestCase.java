package ar.com.miura.jvm.stack;

public class FreqStackTestCase {

    /**
     ["FreqStack","push","push","push","push","push","push",

     "pop",
     "push",

     "pop",
     "push",

     "pop",
     "push",

     "pop",
     "push",

     "pop","pop","pop","pop","pop","pop"]

     [[],[7],[6],[2],[6],[3],[3],[],[2],[],[2],[],[5],[],[6],[],[],[],[],[],[]]
     */
    @org.junit.jupiter.api.Test
    public void shouldAddAndVerify() {

        FreqStack freqStack = new ar.com.miura.jvm.stack.FreqStack();

        freqStack.push(7);
        freqStack.push(6);
        freqStack.push(2);
        freqStack.push(6);
        freqStack.push(3);
        freqStack.push(3);

        freqStack.pop();
        freqStack.push(2);

        freqStack.pop();
        freqStack.push(2);

        freqStack.pop();
        freqStack.push(5);

        freqStack.pop();
        freqStack.push(6);

        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();

        int stop = 100;
        String stopPoint = "stopPoint";

    }

}
