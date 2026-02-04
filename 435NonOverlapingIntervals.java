//435 non overlaping intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort on the basis of end points
        Arrays.sort(intervals, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        int count =0;
        int len = intervals.length;
        int end = intervals[0][1];
        for(int i=1;i<len;i++){
            if(intervals[i][0]<end){
                count++;
            }else{
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}