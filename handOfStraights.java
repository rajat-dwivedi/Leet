//NlogN
class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        int len = hand.length;
        if(len%gs!=0) return false;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int card:hand){
            tm.put(card, tm.getOrDefault(card,0)+1);
        }

        while(tm.size()>0){
            int first = tm.firstKey();
            for(int j=1;j<gs;j++){
                int next = first+j;
                if(tm.containsKey(next)){
                    tm.put(next,tm.get(next)-1);
                    if(tm.get(next)==0) tm.remove(next);
                }else{
                    return false;
                }
            }
            tm.put(first, tm.get(first)-1);
            if(tm.get(first)==0) tm.remove(first);
        }
        return true;
    }
}