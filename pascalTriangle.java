class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for(int i=0;i<numRows;i++){
            row = new ArrayList<Integer>();
            //columns
            for(int j=0;j<=i;j++){
                //the first and last columns are always 1
                if(j==0||j==i){
                    row.add(1);
                }else{
                    //the current element in the row is equal to sum of above and one before above
                    row.add(pre.get(j-1)+pre.get(j));
                }
            }
            res.add(row);
            pre = row;
        }
        return res;
    }
}