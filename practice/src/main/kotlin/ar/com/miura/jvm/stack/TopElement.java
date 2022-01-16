package ar.com.miura.jvm.stack;

class TopElement {
    Integer element;
    Integer frequency;

    public TopElement(Integer element, Integer frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    public String toString() {
        return " element : " + element + " , " + frequency;
    }

}