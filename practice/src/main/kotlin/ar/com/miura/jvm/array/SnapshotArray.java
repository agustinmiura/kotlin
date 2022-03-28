package ar.com.miura.jvm.array;

public class SnapshotArray {

    private java.util.List<java.util.Map<Integer, Integer>> historical = new java.util.ArrayList();

    public SnapshotArray(int length) {
        historical.add(new java.util.HashMap());
    }

    public void set(int index, int val) {
        int snapId = historical.size() - 1;
        historical.get(snapId).put(index, val);
    }

    public int snap() {
        historical.add(new java.util.HashMap());
        return historical.size() - 2;
    }

    public int get(int index, int snap_id) {
        int snapId = snap_id;
        while(snapId>=0) {
            if (historical.get(snapId).containsKey(index)) {
                return historical.get(snapId).get(index);
            }
            snapId--;
        }
        return 0;
    }
}
