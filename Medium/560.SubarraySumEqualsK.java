// Using Cumulative Sum
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int start = 0; start < nums.length; start++){
            int sum = 0;
            for(int end = start; end < nums.length; end++){
                sum += nums[end];
                if(sum == k) count++;
            }
        }
        return count;
    }
}

// Hashmap
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] ;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}