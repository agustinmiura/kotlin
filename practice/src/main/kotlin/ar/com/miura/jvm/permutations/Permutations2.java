package ar.com.miura.jvm.permutations;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {

    public java.util.List<java.util.List<Integer>> permuteUnique(int[] nums) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        java.util.List<java.util.List<Integer>> results = new java.util.ArrayList<>();
        java.util.List<Integer> combination = new java.util.ArrayList<Integer>();
        backtrack(combination, results, nums, map);
        return results;
    }

    private void backtrack(java.util.List<Integer> combination, java.util.List<java.util.List<Integer>> results, int[] nums, java.util.Map<Integer, Integer> map) {
        /**
         * Combination with 4 elements has the results
         */
        if (combination.size()==nums.length) {
            results.add(combination.stream().collect(java.util.stream.Collectors.toList()));
        } else {

            for(java.util.Map.Entry<Integer, Integer> eachEntry:map.entrySet()) {
                Integer key = eachEntry.getKey();
                Integer number = eachEntry.getValue();
                /**
                 * Process only elements with more than once ocurrence
                 */
                if (number.compareTo(1)>=0) {
                    combination.add(key);
                    map.put(key, number-1);

                    backtrack(combination, results, nums, map);

                    combination.remove(combination.size()-1);
                    map.put(key, number);
                }
            }
        }
    }


}

