//Find Median from Data Stream
// Problem: Continuously add integers and return the median of all elements so far.

//Concepts : 
// Key Concepts:
// Max Heap (left side): holds the smaller half of the numbers

// Min Heap (right side): holds the larger half of the numbers

// Balancing: Sizes differ by at most 1

// Median logic:

// If heaps are equal → median = average of roots

// Else → median = root of the larger heap


// Time & Space:
// Insert: O(log n) (due to heap insertion)

// Find Median: O(1)

// Space: O(n)

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStreams {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFromDataStreams() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        // ensure maxheap has equal or 1 more element than minheap
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            //even no. of elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            //odd no. of elements
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        MedianFromDataStreams mds = new MedianFromDataStreams();
        mds.addNum(1);
        mds.addNum(2);
        System.out.println(mds.findMedian());
        mds.addNum(3);
        System.out.println(mds.findMedian());
    }
}
