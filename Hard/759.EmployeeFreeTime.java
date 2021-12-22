/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param schedule: a list schedule of employees
     * @return: Return a list of finite intervals 
     */
    public List<Interval> employeeFreeTime(int[][] schedule) {
        List<Interval> intervals = new ArrayList<>();
		for (int[] s : schedule) {
            for (int i = 0; i < s.length; i = i + 2) {
                intervals.add(new Interval(s[i], s[i + 1]));
            }
        }
	Collections.sort(intervals, (a, b) -> {
		if (a.start == b.start) {
			return a.end - b.end;
		}
		return a.start - b.start;
	});

	List<Interval> result = new ArrayList<>();
	Interval pre = intervals.get(0);
	for (int i = 1; i < intervals.size(); i++) {
		Interval cur = intervals.get(i);
		if (cur.start > pre.end) {
			result.add(new Interval(pre.end, cur.start));
			pre = cur;
		} else {
			pre.end = Math.max(pre.end, cur.end);
		}
	}
	return result;
    }
}
