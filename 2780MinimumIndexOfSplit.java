class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len = nums.size();
        int n = 0,count=0;
        //find the majority element
        for(int i=0;i<len;i++){
            int num = nums.get(i);
            if(count==0){
                n = num;
                count++;
            }else if(num==n){
                count++;
            }else{
                count--;
            }
        }

        //get the frequency of the majority element
        int total = 0;
        for(int i=0;i<len;i++){
            if(nums.get(i)==n) total++;
        }

        //find the index of split
        int freq = 0;
        for(int i=0;i<len;i++){
            if(nums.get(i)==n) freq++;
            if(freq*2>i+1 && (total-freq)*2>len-i-1) return i;
        }

        return -1;
    }
}