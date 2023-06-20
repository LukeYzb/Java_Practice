package com.example.java_practice.HuaweiOD;

//        题目描述:
//        给定一个由纯数字组成以字符串表示的数值，现要求字符串中的每个数字最多只能出现2次，超过的需要进行删除，删除某个重复的数字后，其它数字相对位置保持不变。
//        如”34533”，数字3重复超过2次，需要删除其中一个3，删除第一个3后获得最大数值”4533'请返回经过删除操作后的最大的数值，以字符串表示。
//        输入描述:
//        第一行为一个纯数字组成的字符串，长度范围: [1,100000]
//        输出描述:
//        输出经过删除操作后的最大的数值


import java.util.ArrayList;
import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = str.charAt(i) - '0';
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int count = 0;
            for (int j = i; j < n; j++) {
                ArrayList<Integer> indexList = new ArrayList<>();//indexes of this num
                if (nums[j] == num) {
                    indexList.add(j);
                    count++;
                }
                if (count > 2) {
                    for (int k : indexList) {
                        if (k == indexList.get(indexList.size() - 1)) {//if it's the last "num", delete it
                            nums[k] = -1;
                            indexList.remove(k);
                            count--;
                            //it's already the last "num", no need to break
                        } else if (nums[k] == num) {
                            int next = 1;
                            while (nums[k + next] == -1) {//-1 represents the removed one
                                next++;
                            }
                            if (nums[k] < nums[k + next]) {//compare k with the next exist one
                                nums[k] = -1;
                                indexList.remove(k);
                                count--;
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int num : nums) {
            if (num != -1) {
                System.out.print(num);
            }
        }
    }
}
