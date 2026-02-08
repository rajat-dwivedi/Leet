//https://leetcode.com/problems/design-a-stack-with-increment-operation/
class CustomStack {
    private int[] stack;
    private int maxS;
    private int index;
    public CustomStack(int maxSize) {
        this.maxS = maxSize;
        this.stack = new int[maxS];
        this.index = 0;    
    }
    
    public void push(int x) {
        if(index<maxS){
            stack[index++]=x;
        }else{
            return;
        }
    }
    
    public int pop() {
        if(index==0)return -1;
        return stack[--index];
    }
    
    public void increment(int k, int val) {
        for(int i =0;i<k && i<index;i++){
            stack[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */