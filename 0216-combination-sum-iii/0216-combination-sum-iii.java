class Solution {
    private void findCombination(int start, int k, int n, int sum, List<Integer> ds, List<List<Integer>> ans){
        if(sum > n) return;
        if(ds.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(ds));
                return;
            }
        }
        for(int i = start; i<= 9; i++){
            ds.add(i);
            findCombination(i+1, k, n, sum+i, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombination(1, k, n, 0, ds,ans);
        return ans;
    }
}