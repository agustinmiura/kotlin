package ar.com.miura.jvm.string;


public class SumBeauty {

    public int beautySum(String s) {
        int sum = 0;
        int size = s.length();

        for(int i=0;i<size-1;i++) {

            java.util.Map<Character, Integer> map = new java.util.HashMap<>();

            for(int j=i;j<size;j++) {

                Integer count = map.getOrDefault(s.charAt(j), 0);
                count++;
                map.put(s.charAt(j), count);

                int min = getMin(map);
                int max = getMax(map);

                sum = sum + (max-min);
            }
        }

        return sum;
    }

    public Integer getMax(java.util.Map<Character, Integer> map) {
        java.util.Optional<java.util.Map.Entry<Character, Integer>> maxEntry = map.entrySet().stream().max((
                java.util.Map.Entry<Character, Integer> e1, java.util.Map.Entry<Character,  Integer> e2) -> e1.getValue().compareTo(e2.getValue())
        );
        return (Integer) maxEntry.get().getValue();
    }

    public Integer getMin(java.util.Map<Character, Integer> map) {
        java.util.Optional<java.util.Map.Entry<Character, Integer>> minEntry = map.entrySet().stream().min((
                java.util.Map.Entry<Character, Integer> e1, java.util.Map.Entry<Character,  Integer> e2) -> e1.getValue().compareTo(e2.getValue())
        );
        return minEntry.get().getValue();
    }
}
