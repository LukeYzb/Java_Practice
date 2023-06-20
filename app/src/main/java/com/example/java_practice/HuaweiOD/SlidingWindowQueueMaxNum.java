package com.example.java_practice.HuaweiOD;

//给你一个整数数组nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的k个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowQueueMaxNum {
    /***
     * 想象一下，我有一个队列，这个队列的长度不固定，是可以变动的，并且这个队列是一个递减队列，也就是说队列的第一个元素代表最大值。
     * 那么在这个基础上，我再次修改一下，这个队列存储的是值的下标，那么第一个元素就是最大值的下标。
     * 好了队列已经定义完毕了，那么具体的逻辑关系又是怎么样的呢？我们一一道来：
     * 1、初始队列为空，quee = [],res =[],其中quee表示队列，res用来存储题目想要的结果
     * 2：（1）、遍历第一个值时，由于quee为空，所以直接将第一个值加入到quee中
     * (2)、遍历第二个值时，若是第二个值比第一个值小，则直接加入到quee中，注意这里加入的都是对应的下标。但若是比第一个值大，则把第一个值弹出队列，第二个加入。
     * ：这里就可以看出一种思路了，新加入的值，若是队列里面有值比这个新的要小，就弹出。，因为小已经没用了，我们只需要保留大的
     * （3）、判断队列头的值，下标是否超出了窗口，若是则弹出。
     */
    //单调队列
    public int[] slidingWindowMaxNum(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    //预处理
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        //预处理
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        //预处理
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
