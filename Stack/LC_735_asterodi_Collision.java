/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
Accepted
180,568


*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        if(asteroids == null || asteroids.length  == 0) return null;
        Deque<Integer> st = new ArrayDeque();
        // st.push(asteroids[0]);
        
        
        // collision condition
        // if ith asteroid moving in ===>> direction, and i+1th asteroid moving in 
         // <<=== direction then  collision can occure
        // when collision occurs and both size is same both will explode
        
        for(int i=0;i<asteroids.length;i++) {
            int current = asteroids[i];
            // flag to maintain if you need to push current or not
            boolean push = true;
            
            // condition for collision
            // for collision top should be >  0 and current should be less than 0 < 0
            // peek > 0 and current < 0 
            while(!st.isEmpty() && st.peek() >0 && current < 0) {
                // top of the stack
                int peekAbs = Math.abs(st.peek());
                // current element
                int currentAbs = Math.abs(current);
                    // if collision occurs no need to push (top of the stack 
                // asteroid is in larger than current so top survives and current is exploded)
                    if(peekAbs >= currentAbs) {
                        // no need to push current asteroid
                        push = false;
                        // if both are same both will collapse
                        if(peekAbs == currentAbs){
                            // remove top of the stack asteroid as it will be destroyed
                            st.pop();
                        }
                            
                        break;
                    }else{
                        // current survives so remove top asteroid from the stack
                        st.pop();
                    }
                
                
            }
            
            // if push is still there ( current asterod  survive the current collision
            // then push it to stack)
            if(push){
                st.push(current);
            }
        }
        
        // now stack contains all the asterodi that survives
        int[] res= new int[st.size()];
        
        for(int k=res.length-1;k>=0;k--) {
            res[k] = st.pop();
        }
        return res;
    }
}

