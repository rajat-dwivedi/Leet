//method 0 - pq O(nlogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int key: map.keySet()){
            int[] temp = new int[]{key, map.get(key)};
            pq.offer(temp);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        int idx = 0;
        while(pq.size()>0){
            int[] temp = pq.poll();
            res[idx++] = temp[0];
        }
        return res;
    }
}

//m2 - buckets - O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        int idx = 0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int val: bucket[i]){
                    if(idx==k) break;
                    res[idx++]=val;
                    
                }
            }
        }
        return res;
    }
}