class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = (nums.length) -1;
        int k = (result.length) -1;
        while(left<=right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[k] = nums[left] * nums[left];
                left++; k--;
            }
            else{
                 result[k] = nums[right] * nums[right];
                right--; k--;
            }
        }
        return result;
    }
}