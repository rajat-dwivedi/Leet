https://leetcode.com/problems/last-stone-weight/
push - O(logn)
    pop- O(logn)
    in the while loop in each operation we do 2 pop() and 1 push()
    we do n such iterations so total n*3logn = 3nlogn approx nlogn tc
class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> pq;
        for(int x: stones){
            pq.push(x);
        }
        
        while(pq.size()>=2){
            int x = pq.top();
            pq.pop();
            int y = pq.top();
            pq.pop();
            if(x!=y){
                pq.push(x-y);
            }
        }
        
        if(pq.size()!=0)
            return pq.top();
        else
            return 0;
    }
};