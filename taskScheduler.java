//method 0 - using an array O(N)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int len = tasks.length;
        for(int i =0;i<len;i++){
            freq[tasks[i]-'A']++;
        }
        int max = 0, maxf = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>maxf){
                max = i;
                maxf = freq[i];
            }
        }
        
        int ideal = (maxf-1)*n;
        for(int i=0;i<26;i++){
            if(i!=max){
                ideal -= Math.min(freq[i],maxf-1);
            }
        }
        return len+Math.max(0,ideal);
    }
}

//m1 O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> task_counter = new HashMap<>();
    for(Character task: tasks) {
        task_counter.put(task, task_counter.getOrDefault(task,0) + 1);    
    }
    
    
    // add the frequency of all tasks  to pq (Priority-Queue)
    // use reverseOrder to account for max-heap implementation
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.addAll(task_counter.values());
    
    
    int time = 0;
    while(pq.size() > 0) {
        List<Integer> add_back = new ArrayList<>();
        
        // loop for grabbing n tasks from  pq or for idle itme only
        for(int i= 0; i <= n; i++) {
            
            // for grabbing n tasks from  pq 
            if(pq.size() > 0) {
                int count = pq.poll(); // retreives max and removes an element from pq.
                count--;
                if(count > 0) { // needs add_back
                    add_back.add(count);
                }  
            }
            
            time += 1; // accounts for idle time and real task too.
            if(pq.size() == 0 && add_back.size() == 0) {  // this accounts when the last run of tasks is done and no more tasks to ensure no idle runs happen when no tasks to schecule.
                break;
            }  

        }   
        pq.addAll(add_back);  // re-arrange the max-heap proeprty by adding the add_back counts to pq.

    }
    return time;
    }
}