/*

Problem Statement#
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
Example 2:

Input: [2, 4, 1, 2]
Output: 3
Example 3:

Input: [2, 3, 2, 1]
Output: 4


*/


/*

1) Mark the location of every element in the array to its correct location (negative), then return all the positive (that are not visited by anyone)

2) another idea is to keep on swapping and moving untill all the element are on it's correct index
 then return all the indexes out of position

*/
using namespace std;

#include <iostream>
#include <vector>

class AllMissingNumbers {
 public:
  static vector<int> findNumbers(vector<int> &nums) {
    vector<int> missingNumbers;
    // TODO: Write your code here
    // for(int i=0;i< nums.size();i++) {
    //     int _abs = abs(nums[i]);
    //     if( nums[_abs-1] >0) {
    //       nums[_abs-1] = -1*nums[_abs-1];
    //     }


    // }

    // for(int i=0; i< nums.size(); i++) {
    //   if(nums[i] > 0) {
    //     missingNumbers.push_back(i+1);
    //   }
    // }
    int i=0;
    while (i < nums.size()) {
      if (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
    }

    vector<int> missingNumbers;
    for (i = 0; i < nums.size(); i++) {
      if (nums[i] != i + 1) {
        missingNumbers.push_back(i + 1);
      }
    }

    

    return missingNumbers;
  }
};
