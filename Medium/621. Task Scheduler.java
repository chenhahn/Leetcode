class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task: tasks) {
            count[task - 'A']++;
            if (max == count[task - 'A']) {
                maxCount++;
            }
            if (max < count[task - 'A']) {
                max = count[task - 'A'];
                maxCount = 1;
            }
        }
        
        if (maxCount > n)
            return tasks.length;
        
        int slots = (max - 1) * (n - maxCount + 1);
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, slots - availableTasks);
        
        return tasks.length + idles;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)   O(26) -> O(1)