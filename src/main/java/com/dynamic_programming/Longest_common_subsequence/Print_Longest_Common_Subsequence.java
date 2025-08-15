package com.dynamic_programming.Longest_common_subsequence;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 abcdgh
 abhdef
 */

public class Print_Longest_Common_Subsequence {

    private static int lcs(String x, String y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) return dp[m][n];

        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            dp[m][n] = 1 + lcs(x, y, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(lcs(x, y, m - 1, n, dp), lcs(x, y, m, n - 1, dp));
        }

        return dp[m][n];
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Print Longest Common Subsequence");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String x = reader.readLine().trim();
        String y = reader.readLine().trim();

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                dp[i][j] = -1;
            }
        }

        int max = lcs(x, y, x.length(), y.length(), dp);

        System.out.println("longest_common_subsequence_length::: " + max);
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int m = x.length();
        int n = y.length();

        StringBuilder builder = new StringBuilder();

        while (m >= 1 && n >= 1) {
            if (x.charAt(m - 1) == y.charAt(n - 1)) {
                builder.append(x.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                m = m - 1;
            } else {
                n = n - 1;
            }
        }

        String longestSubsequence = builder.reverse().toString();

        System.out.println("longestSubsequence string:::  "+ longestSubsequence);
    }
}
