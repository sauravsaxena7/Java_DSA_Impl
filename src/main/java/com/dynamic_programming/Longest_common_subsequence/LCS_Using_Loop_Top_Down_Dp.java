package com.dynamic_programming.Longest_common_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 ABCDGH
 ACDGHR
 */
public class LCS_Using_Loop_Top_Down_Dp {


    public static int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if(i==2 && j==3){
                    System.out.println(text1.charAt(i-1) +" "+ text2.charAt(j-1));
                }
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    System.out.println(i+" "+j);
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[m][n];



    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text1 = reader.readLine().trim();
        String text2 = reader.readLine().trim();

        int longestSubsequenceLength = longestCommonSubsequence(text1, text2);
        System.out.println("longestSubsequenceLength:: " + longestSubsequenceLength);
    }
}
