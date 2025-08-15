package com.dynamic_programming.Longest_common_substring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 ABCDGH
 ACDGHR



 not working
 KXCGMTMVVGFQQWSPD
 JXZADDUKVLQPKUZJZHWSUTPCAFSYAIBJHAMMEGWBTPQELRNKBLDXGUZGCSEC

 working code

 class Solution {

 public int longestCommonSubstrRecursive(String s1, String s2, int n, int m, int count) {
 // Base case: If either string length is 0, return count
 if (n == 0 || m == 0) {
 return count;
 }

 // If characters match, increment count and recursively call function
 if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
 count = longestCommonSubstrRecursive(s1, s2, n - 1, m - 1, count + 1);
 }

 // Explore options by recursively calling function with different indices and reset count
 int res = Math.max(count, Math.max(
 longestCommonSubstrRecursive(s1, s2, n - 1, m, 0),
 longestCommonSubstrRecursive(s1, s2, n, m - 1, 0)
 ));

 return res;
 }

 public int longestCommonSubstr(String str1, String str2) {
 // code here
 return longestCommonSubstrRecursive(str1, str2, str1.length(), str2.length(), 0);
 }
 }
 */

public class LongestCommonSubstring {
    static int max;

    private static int longestCommonSubString(String s1, String s2, int m, int n, int[][] dp) {

        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];

        if(s1.charAt(m-1)==s2.charAt(n-1)){
             dp[m][n]=1+longestCommonSubString(s1,s2,m-1,n-1,dp);
             max = Math.max(dp[m][n],max);
             System.out.println(dp[m-1][n-1]+" "+dp[m][n]);
        }else {
            dp[m][n]=0;
            longestCommonSubString(s1,s2,m-1,n,dp);
            longestCommonSubString(s1,s2,m,n-1,dp);


        }
        return max;
    }

    public static int longestCommonSubstr(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length()+1][s2.length()+1];


        for (int i = 0; i < (s1.length() + 1); i++) {
            for (int j = 0; j < (s2.length() + 1); j++) {
                dp[i][j]=-1;
            }
        }

        max = Integer.MIN_VALUE;

        max= longestCommonSubString(s1,s2,s1.length(),s2.length(),dp);

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return max;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text1 = reader.readLine().trim();
        String text2 = reader.readLine().trim();

        int longestSubstringLength = longestCommonSubstr(text1, text2);
        System.out.println("longestSubsequenceLength:: " + longestSubstringLength);
    }
}

