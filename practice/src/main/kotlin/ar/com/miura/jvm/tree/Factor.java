package ar.com.miura.jvm.tree;

class Factor {

    public int numFactoredBinaryTrees(int[] arr) {
        if(arr == null ||arr.length ==0){
            return 0;
        }
        java.util.Arrays.sort(arr); // O(nlogn)

        java.util.Map<Integer, Long> map = new java.util.HashMap<>();

        for(int i=0;i< arr.length;i++){ // O(n2)
            long count = 1l;
            for(int j=0;j<i;j++){
                if(arr[i] % arr[j] == 0 && map.containsKey(arr[i]/arr[j])){
                    count += map.get(arr[j]) * map.get(arr[i]/arr[j]);
                }

            }
            map.put(arr[i], count);
        }

        long totalCount = 0l;

        for(java.util.Map.Entry<Integer, Long> entry: map.entrySet()){
            totalCount += entry.getValue();
        }

        return (int)(totalCount % (1000000000 + 7));
    }

}
