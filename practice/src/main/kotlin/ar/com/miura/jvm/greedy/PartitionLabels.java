package ar.com.miura.jvm.greedy;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++) {
            Character tempChar = s.charAt(i);
            map.put(tempChar, i);
        }

        List<Integer> intervals = new ArrayList<Integer>();
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
