/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
        int lastend = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start < lastend){
                return false;
            }
            lastend = intervals.get(i).end;
        }
        return true;
    }
}