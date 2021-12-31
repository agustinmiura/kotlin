package ar.com.miura.jvm.array;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        java.util.Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }


        for(int i=0;i<nums.length;i++) {

            Integer remainder = target-nums[i];
            if (map.containsKey(remainder) && map.getOrDefault(remainder, -1)!=i) {
                Integer position = map.getOrDefault(remainder, -1);
                return new int[]{i, position};
            }

        }
        return new int[2];

    }
}
