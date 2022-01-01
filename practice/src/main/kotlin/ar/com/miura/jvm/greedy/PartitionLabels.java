package ar.com.miura.jvm.greedy;

public class PartitionLabels {
    public java.util.List<Integer> partitionLabels(String s) {

        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            Character tempChar = s.charAt(i);
            map.put(tempChar, i);
        }

        java.util.List<Integer> intervals = new java.util.ArrayList<Integer>();
        int start = 0;
        int j = 0;
        for(int i=0;i<s.length();i++) {

            j = Math.max(j, map.getOrDefault(s.charAt(i), -1));
            if (i==j) {
                intervals.add( (j-start+1) );
                start =  i + 1;
            }


        }
        return intervals;
    }
}
