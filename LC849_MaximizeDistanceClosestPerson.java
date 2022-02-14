class Solution {
    public int maxDistToClosest(int[] seats) {
        int [] left = new int[seats.length] ;
        
        int [] right = new int[seats.length];
        Arrays.fill(left, seats.length);
        Arrays.fill(right, seats.length);
        
        // first pass left pass to get the minimum distance to filled seat from 
        // left of current location
        for(int i=0;i<seats.length;i++) {
            if(seats[i] == 1) {
                left[i] = 0;
            }
            
            else if(i >0 ) {
                left[i] = left[i-1]+1;
            }
        }
        
        
        // first pass right pass to get the minimum distance to filled seat from 
        // right of current location
        for(int i=seats.length-1;i>=0;i--) {
            if(seats[i] == 1) {
                right[i] = 0;
            }
            
            else if(i < seats.length-1 ) {
                right[i] = right[i+1]+1;
            }
        }
        
        
        int ans = 0;
        
        // find the minimum of left and right at current location where seat is empty 
        // which shows the maximum distance to filled location, find the maximum of this distance 
        for(int i=0;i< seats.length;i++) {
            if(seats[i]==0) {
              ans = Math.max(ans, Math.min(left[i], right[i]));  
            }  
        }
        return ans;
    }
}
