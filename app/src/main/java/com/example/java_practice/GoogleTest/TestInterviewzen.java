package com.example.java_practice.GoogleTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Node {
    int value;
    Node left, right;
}


public class TestInterviewzen {
    /**
     * 1. Java, C#
     * 2. yzb1355958493/Luke/luke-i4
     * 3. LeetCode 90
     * 4. resume delivered 8 times, 1 phone interview, 1 onsite interview
     * 5. mainly look for java back-end job
     */

    /**
     * # Coding Question 1
     * <p>
     * Given nums as an array of integers, find two numbers in the array that add up to a given target.
     * Analyze time and space complexity of your solution.
     * <p>
     * Example 1:
     * Given nums = [2, 7, 11, 15], target = 9,
     * return [2, 7] since 2+7=9.
     * <p>
     * <p>
     * If you use Java, your function can be defined as:
     * public int[] twoNum(int[] nums, int target) {}
     * <p>
     * <p>
     * Bonus: can you do it in O(n) time?
     */
    //time complexity O(n) for single loop
    //space complexity O(n) for n elements in nums array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //time complexity O(n^2)
    //space complexity O(1)
    public int[] twoNum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return new int[0];
    }

    /**
     * # Coding Question 2
     * <p>
     * Given a sorted array nums, rearrange the array so that all unique numbers in the array are placed in the left side of the array, and the duplicate numbers are placed in the right side of the array.
     * Analyze time and space complexity of your solution.
     * <p>
     * <p>
     * Example 1:
     * Given nums = [1,1,2,3,3,4], after your function runs, nums=[1,2,3,4,1,3]. Explanation: unique numbers are 1, 2, 3, and 4, so the first for numbers after arrangement are 1,2,3,4. 1,3 are duplicated numbers so they are placed on the right side.
     * <p>
     * If you use Java, your function can be defined as:
     * public void rearrange(int[] nums) {}
     * <p>
     * Bonus: Can you solve it in place (without creating a new array)?
     */
    //time complexity O(n) for single loop
    //space complexity O(n) for n elements in nums array
    public void rearrange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int lastUniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[lastUniqueIndex]) {
                lastUniqueIndex++;
                int temp = nums[i];
                nums[i] = nums[lastUniqueIndex];
                nums[lastUniqueIndex] = temp;
            }
        }
    }

    //time complexity O(n) for single loop
    //space complexity O(n) for n elements in nums1+nums2
    public void rearrange1(int[] nums) {
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(nums[0]);
        List<Integer> nums2 = new ArrayList<>();

        //store unique nums in nums1, move duplicate nums to nums2
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums2.add(nums[i]);
            } else {
                nums1.add(nums[i]);
            }
        }

        //cover nums with the combination of nums1 and nums2
        nums1.addAll(nums2);
        for (int i = 0; i < nums1.size(); i++) {
            nums[i] = nums1.get(i);
        }
    }

    /**
     * # Coding Question 3
     * <p>
     * Given a BST, find a node whose value is closest to n.
     * Analyze time and space complexity of your solution.
     * <p>
     * <p>
     * A tree node is defined as:
     * class Node
     * {
     * int value;
     * Node left, right;
     * }
     * <p>
     * If you use Java, your function can be defined as:
     * public int findCloses(Node root, int n) {}
     */
    //time complexity is O(logn) for it is n height Binary Sort Tree
    //space complexity is O(n) for n nodes
    public int findClosest(Node root, int n) {
        int closest = root.value;
        Node current = root;

        while (current != null) {
            if (Math.abs(current.value - n) < Math.abs(closest - n)) {
                closest = current.value;
            }
            if (n < current.value) {
                current = current.left;
            } else if (n > current.value) {
                current = current.right;
            } else {
                // found exact match, no need to continue searching
                break;
            }
        }

        return closest;
    }

}

//    # Coding Question 4
//
//    Implement a data structure called  CounterStack.
//    Analyze time and space complexity of your solution.
//
//    class CounterStack {
//        /* Normal Stack Operations */
//        void push(int x) // Push element x onto stack.
//        int pop() //Remove the element on top of the stack and return it.
//        int top() //Get the element on the top.
//        /* Counter Operations */
//        int count(int x) // Return number of elements in the stack whose value equals to x
//        void remove(int x) // Remove all elements from the stack whose value equals to x
//    }
//
//    Example use:
//    cs = new CounterStack();
//    cs.push(1);
//    cs.push(2);
//    cs.push(1);
//    cs.count(1);//return 2
//    cs.top(); // return 1
//    cs.remove(1);
//    cs.count(1);//return 0
//    cs.top(); return 2

//time complexity is O(1) for each function except remove() for they only use basic stack and hashmap operation, O(n) for remove() for n elements in stack
//space complexity is O(n) for stack and hashmap need to store n values
class CounterStack {
    private Stack<Integer> stack;
    private Map<Integer, Integer> counter;

    public CounterStack() {
        stack = new Stack<>();
        counter = new HashMap<>();
    }

    /* Normal Stack Operations */
    // Push element x onto stack.
    public void push(int x) {
        stack.push(x);
        counter.put(x, counter.getOrDefault(x, 0) + 1);
    }

    //Remove the element on top of the stack and return it.
    public int pop() {
        int x = stack.pop();
        int count = counter.get(x);
        if (count == 1) {
            counter.remove(x);
        } else {
            counter.put(x, count - 1);
        }
        return x;
    }

    //Get the element on the top.
    public int top() {
        return stack.peek();
    }

    /* Counter Operations */
    // Return number of elements in the stack whose value equals to x
    public int count(int x) {
        return counter.getOrDefault(x, 0);
    }

    // Remove all elements from the stack whose value equals to x
    public void remove(int x) {
        // Remove all occurrences of x from the stack
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int y = stack.pop();
            if (y != x) {
                temp.push(y);
            }
        }
        // Update the counter hashmap
        while (!temp.isEmpty()) {
            int y = temp.pop();
            stack.push(y);
        }

        counter.remove(x);
    }
}
