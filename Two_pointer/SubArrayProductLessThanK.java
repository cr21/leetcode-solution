/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <=1) return 0;
        int res =0;
        
        int product=1;
        
        int left=0;
        int right;
        int n = nums.length;
        
        for(right= 0; right< n ;right++) {
            
           product*=nums[right];
            
            while(product >=k ){
                product /= nums[left++];
            }
            res+=right-left+1;
            
            
        }
        
        return res;
        
        
    }
 
 
 
}



/*

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <=1) return 0;
        int res =0;
        
        int product=1;
        
        int left=0;
        int right;
        int n = nums.length;
        
        for(right= 0; right< n ;right++) {
            
            product *= nums[right];
            // maintain the invariant of product of less than k
            while(product>=k && left < n) {
                product /= nums[left++];
            }
            
            res+= right-left+1;
            
            
        }
        
        return res;
        
        
    }
}
*/



/*

Approach #1: Binary Search on Logarithms [Accepted]
Intuition

Because \log(\prod_i x_i) = \sum_i \log x_ilog(∏ 
i
​
 x 
i
​
 )=∑ 
i
​
 logx 
i
​
 , we can reduce the problem to subarray sums instead of subarray products. The motivation for this is that the product of some arbitrary subarray may be way too large (potentially 1000^50000), and also dealing with sums gives us some more familiarity as it becomes similar to other problems we may have solved before.

Algorithm

After this transformation where every value x becomes log(x), let us take prefix sums prefix[i+1] = nums[0] + nums[1] + ... + nums[i]. Now we are left with the problem of finding, for each i, the largest j so that nums[i] + ... + nums[j] = prefix[j] - prefix[i] < k.

Because prefix is a monotone increasing array, this can be solved with binary search. We add the width of the interval [i, j] to our answer, which counts all subarrays [i, k] with k <= j.

Python

class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        if k == 0: return 0
        k = math.log(k)

        prefix = [0]
        for x in nums:
            prefix.append(prefix[-1] + math.log(x))

        ans = 0
        for i, x in enumerate(prefix):
            j = bisect.bisect(prefix, x + k - 1e-9, i+1)
            ans += j - i - 1
        return ans
Java

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }
}


class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {

        if (k == 0) return 0;
        double logk = log(k);
        vector<double> prefix(nums.size() + 1);
        for (int i = 0; i < nums.size(); i++) {
            prefix[i+1] = prefix[i] + log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < prefix.size(); i++) {
            int lo = i + 1, hi = prefix.size();
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
                else hi = mi;
            }
            ans += lo - i - 1;
        }
        return ans;
    }
};
*/
