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

/*
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
*/


// SLIDING WINDOW HASHMAP

class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> counter = new HashMap();
        
        if(fruits == null ) return 0;
        if(fruits.length <=2 ) return fruits.length;
        
        int left = 0;
        int curr = 0;
        int global = 0;
        int right = 0;
        while(right < fruits.length) {
            
//             if map already contains key increment the counter
            if(counter.containsKey(fruits[right])) {
                counter.put(fruits[right], counter.get(fruits[right]) + 1);
                curr++;
            }else{
                
//                  if map size is less than two we can add the fruit in new basket and increment the counter
                if(counter.size() <2) {
                    counter.put(fruits[right],1);
                    curr++;
                }else{
//                     if we already picked two different fruits we need  to update the maximum number of fruits till now
//                      add third basket Temporarily   and increment current counter
                    global = Math.max(global, curr);
                    counter.put(fruits[right],1);
                    curr++;
//                  keeps on increment left pointer (remove the element) till the map has two types of fruits basket left
                    while(counter.size()!= 2) {
                        //decrement the size of fruits in basket
                        counter.put(fruits[left], counter.get(fruits[left])-1);
                        // remove the basket when it becomes empty
                        counter.remove(fruits[left],0);
                        left+=1;
                        curr--;
                    }
                } 
            }
            global = Math.max(global, curr);
            right++;
        }
        return global;      
    }
}
