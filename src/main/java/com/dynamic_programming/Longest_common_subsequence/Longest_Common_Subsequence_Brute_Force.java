package com.dynamic_programming.Longest_common_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**

 edge case failed
 mhunuzqrkzsnidwbun
 szulspmhwpazoxijwbq
 if we consider first occurrence of 'q' for lcs
 'm' , 'h' unu 'z' , 'q' rkzsnidwbun
 szulsp 'm','h' wpa 'z' oxijwb 'q'
 lcs = mhzq = max lenght = 4

 if we not consider first occurrence of 'q' for lcs
 'm' , 'h' unu 'z' qrkzsn 'i' d 'w', 'b' un
 szulsp 'm' , 'h' wpa 'z' ox  'i'  j'w' , 'b' q
 lcs = mhziwb = max length = 6

 let's if i  pick a char and find lcs and then
 i will not pick that char and again find lcs
 we will consider max length lcs for both of the lcs length

 so, that's why we will used recursion so,
 we make choice for selecting and not selecting a particular character
 And finally apply lcs for every selecting and de-selecting the character.


 */

public class Longest_Common_Subsequence_Brute_Force {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text1 = reader.readLine().trim();
        String text2 = reader.readLine().trim();

        int longestSubsequenceLength = longestCommonSubsequence(text1, text2);
        System.out.println("longestSubsequenceLength:: "+longestSubsequenceLength);

    }

    private static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
          int p=i;
          int k=0;
          while (p<text1.length()){
              char ch = text1.charAt(p);
              int j=k;
              while(j<text2.length()){
                  if(ch==text2.charAt(j)){
                      dp[i][j]=1;
                      k=j+1;
                      break;
                  }
                  j++;
              }
              p++;
          }
        }
        int res=0;
        for(int i=0;i<text1.length();i++){
            int sum = 0;
            for(int j=0;j<text2.length();j++){
                System.out.print(dp[i][j]+" ");
                sum+=dp[i][j];
            }
            System.out.println();
            res=Math.max(res,sum);
        }
        return res;
    }
}
