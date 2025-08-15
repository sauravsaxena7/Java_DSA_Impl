package com.dynamic_programming.longest_increasing_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Number_Of_Longest_Increasing_Subsequence {



    public static int findNumberOfLIS(int[] nums){
        int[][] dp = new int[nums.length+1][nums.length+1];


        int count=0;
        int length=Integer.MIN_VALUE;
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<=nums.length;j++){
                if(j==0 || nums[i]>nums[j]){
                    dp[i][j] = length = Math.max(length,1+dp[i][j]);
                }
            }
        }

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Longest_Increasing_Subsequence_Of_Array::: "+findNumberOfLIS(nums));

    }
}
