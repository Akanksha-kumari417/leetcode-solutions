class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums2Set = new HashSet<>();
        for(int i =0; i<nums2.length; i++){
        nums2Set.add(nums2[i]);
        }
        HashSet<Integer> result = new HashSet<>();
        for(int i =0; i<nums1.length; i++){
            if(nums2Set.contains(nums1[i])) result.add(nums1[i]);
        }
        int[] ans = new int[(result.size())];
        int index = 0;
        for(int num: result){
            ans[index++] = num;
        }
        return ans;
    }
}