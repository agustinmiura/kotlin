package ar.com.miura.jvm.graph;

public interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);

    public java.util.List<ar.com.miura.jvm.graph.NestedInteger> getList();

}
