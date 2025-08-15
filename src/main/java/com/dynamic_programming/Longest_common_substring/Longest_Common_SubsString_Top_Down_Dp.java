package com.dynamic_programming.Longest_common_substring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**


 ABCDGH
 ACDGHR

 ABCD
 ABC

 ABCD
 LLLA
 */

public class Longest_Common_SubsString_Top_Down_Dp {

    public static int longestCommonSubstr(String s1, String s2,int max) {
        // code here
        int m=s1.length();
        int n=s2.length();
        int[][] dp = new int[m+1][n+1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {


                if(i==6 && j==5){
                    System.out.println("dp[i][j-1] "+dp[i][j-1]);
                    System.out.println("dp[i][j] "+dp[i][j]);
                    System.out.println("dp[i-1][s2.length()] "+dp[i-1][s2.length()]);
                    System.out.println("s1.charAt(i-1) s2.charAt(j-1)   "+s1.charAt(i-1)+" "+s2.charAt(j-1));
                    System.out.println("1+dp[i-1][j-1]:: "+1+dp[i-1][j-1]);
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
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

        int max = Integer.MIN_VALUE;

        int longestSubstringLength = longestCommonSubstr(text1, text2,max);
        System.out.println("longestSubstringLength:: " + longestSubstringLength);
    }
}
