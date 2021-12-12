//Approach 1: Sort with Custom Comparator
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        return Arrays.copyOf(points, k);
    }
}
/* 
	Time complexity: O(N*logN) for sorting

	Space complexity: O(logN) to O(N) for the extra space required by the sorting process, depending on what kind of sorting method the programing language uses.
*/ 




//Approach 2: Max Heap or Max Priority Queue
class Solution {
    public int[][] kClosest(int[][] points, int k){
        Queue<int[]> maxKPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < points.length; i++) {
            int[] entry = {squaredDistance(points[i]), i};
            if(maxKPQ.size() < k){
                maxKPQ.add(entry);
            }else if(entry[0] < maxKPQ.peek()[0]){
                maxKPQ.poll();
                maxKPQ.add(entry);
            }
        }
        
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int index = maxKPQ.poll()[1];
            result[i] = points[index];
        }
        return result;
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
/*
    Time complexity: O(N⋅logk)
    Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size of the heap is       capped at k elements.

    Space complexity: O(k)
    The heap (or priority queue) will contain at most k elements.
*/