/*
LEEETCODE 904

https://leetcode.com/problems/fruit-into-baskets/

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
Example 4:

Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can pick from trees [1,2,1,1,2].
 

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
*/

/*
TIME LIMIT EXCEED
*/
class Solution {
    public int totalFruit(int[] fruits) {
        
        int currMax = 0;
        int curr =0;
        Set<Integer> s;
        
        if(fruits == null ) return 0;
        if(fruits.length <= 2 ){
            return fruits.length;
        }
        for(int i = 0; i< fruits.length-1; i++) {
            //System.out.println("currMax"+currMax);
            curr = 0;
            s = new HashSet();
            s.add(fruits[i]);
            curr+=1;
            for(int j =i+1;j < fruits.length; j++  ) {
                
                if(s.contains(fruits[j])) {
                    curr++;
                }else{
                    if(s.size() <2){
                        s.add(fruits[j]);
                        curr++;
                    }else{
                        currMax = Math.max(currMax, curr);
                        break;
                    }
                    
                }
            }
            currMax = Math.max(currMax, curr);
            
        }
        
        return currMax;
        
        
    }
}
