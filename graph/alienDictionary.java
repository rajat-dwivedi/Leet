class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        int changes = 0;
        if(!set.contains(endWord)) return changes;
        Queue<String> q= new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        changes++;
        q.offer(beginWord);
        while(q.size()>0){
            int len = q.size();
            for(int i=0;i<len;i++){
                String word = q.poll();
                if(word.equals(endWord)) return changes;
                
                for(int j=0;j<word.length();j++){
                    for(int k='a';k<='z';k++){
                        char[] wch = word.toCharArray();
                        wch[j] = (char)k;
                        String temp = new String(wch);
                        if(set.contains(temp) && !visited.contains(temp)){
                            q.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}