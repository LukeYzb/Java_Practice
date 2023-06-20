package com.example.java_practice.HuaweiOD;

//        题目描述:
//        有M (1<=M<=10)个端口组，每个端口组是长度为N(1<=N<=100)的整数数组，如果端口组间存在2个及以上不同端口相同，则认为这两个端口组互相关联，可以合并。
//        第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组，输出合并后的端口组用二维数组表示
//
//        输入描述:
//        端口组内数字可以重复
//        输出描述:
//        1.组内相同端口仅保留一个，从小到大排序
//        2.组外顺序保持输入顺序
//        补充说明:
//        M，N不再限定范围内，统一输出一组空数组[[]]
//
//        示例1
//        输入:
//        4
//        4
//        2,3,2
//        1,2
//        5
//        输出:
//        [[4],[2,3],[1,2],[5]]
//        说明:
//        仅有一个端口2相同，不可以合并
//
//        示例2
//        输入:
//        3
//        2,3,1
//        4,3,2
//        5
//        输出:
//        [[1,2,3,4],[5]]
//        说明:
//        存在两个2,3有交集，可以合并
//
//        解题思路:
//        1.将输入的组合转化为set集合 (有去重和排序的功能)，加入list集合中
//        2.每输入一个组合，则对list进行遍历，找出其中有两个并集的集合进行合并，合并完加入原来list集合中。再次执行步骤2注意: 两个需要合并的集合都需要从list中删除，且并集需要加在靠前的位置(题目要求组外保持输入顺序)

import java.util.*;

public class PortMerging {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        if (M > 10) {
            System.out.println("[[]]");
        } else {
            List<Set<Integer>> list = new ArrayList<>();
            sc.nextLine();

            for (int i = 0; i < M; i++) {
                String[] strings = sc.nextLine().split(",");
                int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
                Set<Integer> set = new TreeSet<>();
                if (nums.length == 1) {    //只有一个元素直接添加
                    set.add(nums[0]);
                    list.add(set);
                } else {
                    for (int num : nums) {
                        set.add(num);   //数组转化为set集合
                    }
                    list.add(set);
                    merge(set, list, list.size() - 1);
                }
            }

            System.out.println(list);
        }
    }

    /**
     * 合并关联端口组合
     *
     * @param set   进行合并的端口组合
     * @param list  端口组合集合
     * @param index 需要进行合并的组合索引
     */
    public static void merge(Set<Integer> set, List<Set<Integer>> list, int index) {

        for (int i = 0; i < list.size(); i++) {

            if (i == index) {
                continue;
            }

            Set<Integer> setIndex = list.get(i);     //当前索引的set集合

            Set<Integer> setTemp = new TreeSet<>();
            setTemp.addAll(set);
            setTemp.retainAll(setIndex);    //求出set和setIndex的交集

            if (setTemp.size() >= 2) {  //交集大于等于2则合并

                set.addAll(setIndex);   //set与setIndex合并

                int beforeIndex = index > i ? i : index;    //求出排在前面的index
                int afterIndex = beforeIndex == index ? i : index;  //靠后的位置

                list.remove(afterIndex);     //合并的两个set进行删除，先删除后面的一个
                list.remove(beforeIndex);
                list.add(beforeIndex, set);    //将新的set放在前面位置

                merge(set, list, beforeIndex);     //将新建的组合再进行判断合并

            }
        }
    }
}
