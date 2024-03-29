/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/


class MedianFinder {

    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        
        maxheap = new PriorityQueue<>((a,b) -> b-a);
        minheap = new PriorityQueue<>((a,b) -> a-b);
        
    }
    
    
//     we will maintain two heaps one will store all the element that are less than median and other heap will store all the // elemetns greater than median, we will make sure that either both the heap will have same element or maxheap has higher element
    
    
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || maxheap.peek() >= num) {
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        
//         if maxheap has higher element ( more than 1 higher then pull out elementfrom maxheap and add to minheap this
        // will make sure that maxheap always contains 1 higher element than min heap or both heap has same elements)
        if(maxheap.size() > minheap.size()+1) {
            
            minheap.add(maxheap.poll());
        }else if(maxheap.size()  < minheap.size() ) {
//             by any chance if min heap has higher element then add to maxheap
            maxheap.add(minheap.poll());
        }
        
    }
    
    public double findMedian() {
//          if both heap size are same then return sum of top of peek divide by 2
        if(maxheap.size()  == minheap.size()) {
            //System.out.println("maxheap "+ maxheap.peek() + " minheap : " +minheap.peek());
            return (maxheap.peek()+ minheap.peek()) /2.0;
        }
        
//         else return maxheap top which is median
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
