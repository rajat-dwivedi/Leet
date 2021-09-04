class Solution {
    public void solve(int idx, List<List<Integer>> ans, int[] nums, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }else{
                temp.add(nums[i]);
                solve(i+1,ans, nums, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, ans, nums, new ArrayList<>());
        return ans;
    }
}