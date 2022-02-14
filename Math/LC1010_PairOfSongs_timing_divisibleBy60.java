/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500


Solution Approach:

Let's dive deep into the condition (time[i] + time[j]) % 60 == 0 to examine the relation between time[i] and time[j]. Assuming that a and b are two elements in the input array time, we have:

(a+b)\space \% \space60=0 \\ \Downarrow \\ ((a \space \% \space 60)+(b \space \% \space 60))\space \% \space 60=0 \\ \Downarrow \\ \text{Therefore, either }\begin{cases} a \space \% \space60 &= 0\\ b \space \% \space60 &= 0 \end{cases} \text{, or } (a\space\%\space60)+(b\space\%\space60)=60 \\(a+b) % 60=0
⇓
((a % 60)+(b % 60)) % 60=0
⇓
Therefore, either { 
a % 60
b % 60
​
  
=0
=0
​
 , or (a % 60)+(b % 60)=60
You can learn more about the modulo operation here.

Hence, all we need would be finding the pairs of elements in time so they meet these conditions.

Algorithm

We would iterate through the input array time and for each element a, we want to know the number of elements b such that:

b \space\%\space 60=0b % 60=0, \space \text{if } a \space \% \space 60=0 if a % 60=0
b \space \% \space 60=60-a \space\% \space60b % 60=60−a % 60, \space \text{if } a\space\% \space 60\neq0 if a % 60 

We can use Approach 1 to implement this logic by repeatedly examining the rest of time again and again for each element a. However, we are able to improve the time complexity by consuming more space - we can store the frequencies of the remainder a % 60, so that we can find the number of the complements in \mathcal{O}(1)O(1) time.

Current
1 / 7
We would initiate an array remainders with size 6060 to record the frequencies of each remainder - as the range of remainders is [0,59][0,59]. Then we can loop through the array once and for each element a we would:

if a \space \% \space 60=0a % 60=0, add remainders[0] to the result; else, add remainders[60 - a % 60] to the result;
update remainders[a % 60].

*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // TLE STARTS
//         int counter = 0;
//         for(int i=0;i<time.length;i++) {
            
//             for(int j=i+1;j< time.length;j++) {
//                 if((time[i]+time[j] ) % 60 == 0){
//                     counter++;
//                 }
//             }
//         }
//         return counter;
        // TLE ENDS
        
        
        int [] modulus = new int [60];
        int count = 0;
        // (a+b)% 60 == 0 
        // if a% 60 == 0 and b%60 ==0
        // or ((a%60) + (b%60)) % 60 == 0
        for(int t: time) {
            
            // check if a % 60 == 0 && b % 60 == 0 
            // count total number of pairs having a%60 == 0 and b%60 == 0
            if( t% 60 == 0 ){
                count+= modulus[0];
            }else{
                // check if (a%60 + b%60) == 0
                count+= modulus[60-t%60];
            }
            // update modulus counter
            modulus[t % 60]++;
            
        }
        
        return count;
    }
}
