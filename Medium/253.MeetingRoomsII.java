/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int num = 0, maxNum = 0;
        List<Integer> list = new ArrayList<>();
        for(Interval itl: intervals){
            list.add(itl.start);
            list.add(-itl.end);
        }
        list.sort((a, b) -> (Math.abs(a) - Math.abs(b)));
        for(Integer time: list){
            if(time >= 0) num++;
            if(time < 0) num--;
            if(num > maxNum) maxNum = num;
        }
        return maxNum;
    }
}