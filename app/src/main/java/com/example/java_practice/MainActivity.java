package com.example.java_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.java_practice.HuaweiOD.DFS_Stack;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);

//        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        txt1.setText(reverseLinkedList.origin());
//        txt2.setText(reverseLinkedList.res());

//        CountPrimes countPrimes = new CountPrimes();
//        txt1.setText(String.valueOf(countPrimes.eratosthenes(100)));

//        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//        txt1.setText(String.valueOf(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0, 1, 1, 2, 3, 4, 4, 5})));

//        FindTheMiddleIndexInArray findTheMiddleIndexInArray = new FindTheMiddleIndexInArray();
//        txt1.setText(String.valueOf(findTheMiddleIndexInArray.findMiddleIndex(new int[]{1, 7, 3, 6, 5, 6})));

//        ImplementRand10UsingRand7 implementRand10UsingRand7 = new ImplementRand10UsingRand7();
//        txt1.setText(String.valueOf(implementRand10UsingRand7.rand10()));
//        txt2.setText(String.valueOf(implementRand10UsingRand7.rand10()));

//        TestInterviewzen testInterviewzen = new TestInterviewzen();
//        int[] nums = new int[]{0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5};
//        testInterviewzen.rearrange(nums);
//        String res = "";
//        for (int i = 0; i < nums.length; i++) {
//            res += nums[i];
//        }
//        txt1.setText(res);

//        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
//        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
////        int[] nums = new int[]{2, 1};
//        txt1.setText(String.valueOf(findDisappearedNumbers.findDisappearedNumbers(nums)));

//        Combination combination = new Combination();
//        txt1.setText(String.valueOf(combination.count1(7, 3)));

//        TwentyFourPoints twentyFourPoints = new TwentyFourPoints();
//        txt1.setText(String.valueOf(twentyFourPoints.is24(new int[]{7, 2, 1, 10})));

        DFS_Stack DFS_Stack = new DFS_Stack();
        txt1.setText(String.valueOf(DFS_Stack.setTrains(new int[]{1, 2, 3})));

    }
}