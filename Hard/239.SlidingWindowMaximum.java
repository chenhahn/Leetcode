class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); // queue for index
        
        for (int i = 0; i < n; i++) {
            // if leftmost element (index) of the queue is out of window, remove it from queue
            while (queue.size() > 0 && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            // if corresponding value of the rightmost index in the queue is smaller than current value, remove it from queue
            while (queue.size() > 0 && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            // add index of current value to queue
            queue.offerLast(i);
            // add max value of current window to result
            if(i >= k - 1) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}