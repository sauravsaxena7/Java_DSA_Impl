package com.dynamic_programming.Longest_common_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_Using_Recursion_Bottom_Up_Dp {


    private static int lcs(String str1, String str2, int m, int n, int[][] dp) {
        if(m==0||n==0){
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];

        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return dp[m][n]= 1+lcs(str1,str2,m-1,n-1,dp);
        }else{
            int decMLcs = lcs(str1,str2,m-1,n,dp);
            int decNLsc = lcs(str1,str2,m,n-1,dp);
            return dp[m][n]=Math.max(decMLcs,decNLsc);
        }
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < (text1.length() + 1); i++) {
            for (int j = 0; j < (text2.length() + 1); j++) {
                dp[i][j]=-1;
            }
        }

        int res =lcs(text1, text2, text1.length(), text2.length(), dp);
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return res;
    }


    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text1 = reader.readLine().trim();
        String text2 = reader.readLine().trim();

        int longestSubsequenceLength = longestCommonSubsequence(text1, text2);
        System.out.println("longestSubsequenceLength:: " + longestSubsequenceLength);
    }
}
