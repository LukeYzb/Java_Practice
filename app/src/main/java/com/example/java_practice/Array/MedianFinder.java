package com.example.java_practice.Array;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> min, max;

    //time complexity O(logn)
    //space complexity O(n)
    public MedianFinder() {
        min = new PriorityQueue<>();//small root pile, store larger one
        max = new PriorityQueue<>((x, y) -> (y - x));//big root pile
    }

    public void addNum(int num) {
        //even num
        if (min.size() == max.size()) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
    }

    public double findMedian() {
        //even num
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek() * 1.0;
        }
    }
}
