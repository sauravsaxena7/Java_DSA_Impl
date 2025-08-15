package com.dynamic_programming.longest_increasing_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *

 300. Longest Increasing Subsequence
 Medium

 Given an integer array nums, return the length of the longest strictly increasing subsequence.



 Example 1:

 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Example 2:

 Input: nums = [0,1,0,3,2,3]
 Output: 4
 Example 3:

 Input: nums = [7,7,7,7,7,7,7]
 Output: 1


 Constraints:

 1 <= nums.length <= 2500
 -104 <= nums[i] <= 104


 input
 10 9 2 5 3 7 101 18

 Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?


 */

public class Longest_Increasing_Subsequence_Memoization {



    private static int lis(int index, int prev_index,int[] nums,int n, int[][] dp) {

        if(index==n){
            return 0;
        }

        if(dp[index][prev_index+1]!=-1) return dp[index][prev_index+1];

        int length = lis(index+1,prev_index,nums,n,dp);

        if(prev_index==-1 || nums[index]>nums[prev_index]){
            length = Math.max(length,1+lis(index+1,index,nums,n,dp));

        }
        return dp[index][prev_index+1]=length;
    }



    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        int max = lis(0,-1,nums,n,dp);

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Longest_Increasing_Subsequence_Of_Array::: "+lengthOfLIS(nums));

    }
}
