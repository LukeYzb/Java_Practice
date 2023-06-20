package com.example.java_practice.HuaweiOD;

//        题目描述:
//        Excel工作表中对选定区域的数值进行统计的功能非常实用仿照Excel的这个功能，请对给定表格中选中区域中的单元格进行求和统计，并输出统计结果。
//        为简化计算，假设当前输入中每个单元格内容仅为数字或公式两种
//        如果为数字，则是一个非负整数，形如3、77
//        如果为公式，则固定以=开头，且仅包含下面三种情况等于某单元格的值，例如=B12
//        两个单元格的双目运算 (仅为+或-) ，形如=C1-C2、C3+B2
//        单元格和数字的双目运算 (仅为+或-) ，形如=B1+1、100-B2
//        注意:
//        公式内容都是合法的，例如不存在,=C+1、=C1-C2+B3，=5、=3+5不存在循环引用，例如A1=B1+C1、C1=A1+B2内容中不存在空格、括号。
//
//        输入描述:
//        第一行两个整数rows cols,表示给定表格区域的行数和列数，1<=rows<=20，1<=cols<=26.接下来rows行，每行cols个以空格分隔的字符串，表示给定表格values的单元格内容。最后一行输入的字符串，表示给定的选中区域，形如A1:C2
//        输出描述:
//        一个整数，表示给定选中区域各单元格中数字的累加总和，范围-2,147,483,648 ~ 2,147,483,647
//        补充说明:
//        表格的行号1~20，列号A~Z,例如单元格B3对应values[2][1]。输入的单元格内容 (含公式) 中的数字均为十进制，值范围[0,100]。选中区域:冒号左侧单元格表示选中区域的左上角，右侧表示右下角，如可以为B2:C10、B2:B5、B2:Y2、B2:B2,无类似C2:B2C2:A1的输入。
//
//        有的单元格所需要的数值本身就需要计算得出，这就需要用到回溯了

import java.util.Scanner;

public class Recursion_ExcelCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows;
        int cols;
        String[][] items;

        int startX, startY, endX, endY;
        int sum = 0;

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();
        items = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            String[] content = line.split("[\\t ]+");
            for (int j = 0; j < cols; j++) {
                if (j < content.length) {
                    items[i][j] = content[j];
                }

            }
        }
        String line = scanner.nextLine();
        String[] sel = line.split(":");
        startY = sel[0].charAt(0) - 'A';
        startX = Integer.parseInt(sel[0].substring(1)) - 1;
        endY = sel[1].charAt(0) - 'A';
        endX = Integer.parseInt(sel[1].substring(1)) - 1;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                sum += evaluate(items, i, j);
            }
        }
        System.out.println(sum);
    }

    private static int evaluate(String[][] items, int i, int j) {
        String s = items[i][j];
        if (s.startsWith("=")) {
            int res;
            s = s.substring(1);
            int indexPlus = s.indexOf("+");
            if (indexPlus > 0) {
                String s1 = s.substring(0, indexPlus);
                String s2 = s.substring(indexPlus + 1);
                int n1 = getNoValue(items, s1);
                int n2 = getNoValue(items, s2);
                res = n1 + n2;
            } else {
                int indexMinus = s.indexOf("-");
                if (indexMinus > 0) {
                    String s1 = s.substring(0, indexMinus);
                    String s2 = s.substring(indexMinus + 1);
                    int n1 = getNoValue(items, s1);
                    int n2 = getNoValue(items, s2);
                    res = n1 - n2;
                } else {
                    res = getNoValue(items, s);
                }
            }
            items[i][j] = String.valueOf(res);
            return res;

        } else {
            return Integer.parseInt(s);
        }
    }

    private static int getNoValue(String[][] items, String no) {
        int n;
        if (Character.isDigit(no.charAt(0))) {
            n = Integer.parseInt(no);
        } else {
            int[] p1 = excelPos(no);
            n = evaluate(items, p1[0], p1[1]);
        }
        return n;
    }

    /**
     * @param s excel单元格编号
     * @return 对应数组下标[x, y]
     */
    private static int[] excelPos(String s) {
        int[] pos = new int[2];
        pos[0] = Integer.parseInt(s.substring(1)) - 1;
        pos[1] = s.charAt(0) - 'A';
        return pos;
    }
}
