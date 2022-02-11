class Solution {
    public int trap(int[] height) {
        
        int res=0;
        
        // The idea here is that for every element find the maximum height bar from left
        // and right side, then we can store minimum of left and height bar - current height of the index water in that perticular location
        
        for(int i = 1;i< height.length -1;i++) {
            
            int left = height[i];
            // find the maxmium height bar from left side of the element
            for(int j=0; j<i; j++) {
                left = Math.max(left, height[j]);
            }
            
            int right = height[i];
            
            // find the maxmium height bar from right side of the element
            for(int k=i;k< height.length; k++) {
                right = Math.max(right, height[k]);
            }
            
            // rain trapped at location i will be minimum maximum height of left and right bar - current height of the location
            res += Math.min(left, right) - height[i];
        }
        
        return res;
        
    }
}
