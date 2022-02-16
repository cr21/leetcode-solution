
/*
Bottom up DP
*/
class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, nums.length );
        memo[nums.length - 1] = 0;
        
        for (int pos = nums.length - 2; pos >= 0; pos--){
            int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
            for (int r = furthestJump; r >= pos + 1; r--){
                memo[pos] = Math.min(memo[pos], memo[r] + 1);
            }
        }
        
        return memo[0];
    }
}
