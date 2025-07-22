package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 1573. Number of Ways to Split a String
 *
 *
 *
 * Given a binary string s, you can split s into 3 non-empty strings s1, s2, and s3 where s1 + s2 + s3 = s.
 *
 * Return the number of ways s can be split such that the number of ones is the same in s1, s2, and s3. Since the answer may be too large, return it modulo 109 + 7.

 * Example 1:
 *
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * Example 2:
 *
 * Input: s = "1001"
 * Output: 0
 * Example 3:
 *
 * Input: s = "0000"
 * Output: 3
 * Explanation: There are three ways to split s in 3 parts.
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 105
 * s[i] is either '0' or '1'.
 *
 * solution
 * input
 * 100100010100110
 *
 * testcase 1
 * first we find no of ones, if no. of one's is not divisible by 3 simply return 0
 *
 * testcase 2
 * 1001  | 000101 | 0010
 *1001  |  101  | 10
 *      000      00
 *
 * for 2nd place we have 3 zero
 * if we want to arrange 3 zero on first and 2nd place
 * -    000
 * 0    00
 * 00   0
 * 000  -
 *
 * no of ways to place 3 zero on two places is 4
 * so formula is (n+1) where n is number of zero
 *
 * similarly for 3rd place we have 2 zero
 * if we want to arrange 2 zero on 2nd and third place
 * -   00
 * 0   0
 * 00  -
 * no of ways to place 2 zero on two places is 3
 * again (n+1) where n is number of zero
 *
 *testcase 3
 * if only zero is present in string.
 * 0000
 * if we want to break one piece of wood into three times, we need to make cut two times
 * 3c2 will be the answer so wholesome formula is ((n-1)*(n-2))/2
 */

public class NumberOfWaysToSplitString {


    public int numWays(String s) {

        final int MOD = 1_000_000_007;
        int count=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count = count+1;
        }

        if(count%3!=0) return 0;

        int no_of_ones = count/3;
        int n=s.length();

        if(no_of_ones==0) {


            System.out.println(n);

            //long res = (long)((n-1)*(n-2));
            long res = ((long)(n - 1) * (n - 2)) / 2;
            System.out.println(res);
            return (int)(res%MOD);


        }

        StringBuilder s1= new StringBuilder();
        StringBuilder s2= new StringBuilder();
        StringBuilder s3= new StringBuilder();

        int j=0;
        int s1_count=0;
        while(s1_count<no_of_ones){
            s1.append(s.charAt(j));
            if(s.charAt(j)=='1') s1_count++;
            j++;
        }

        int s2_count=0;
        int s2_count_0=0;
        boolean flag=false;
        while(s2_count<no_of_ones){
            s2.append(s.charAt(j));
            if(s.charAt(j)=='1') {
                s2_count++;
                flag=true;
            }
            if(!flag){
                s2_count_0=s2_count_0+1;
            }

            j++;
        }

        int s3_count=0;
        int s3_count_0=0;
        flag=false;
        while(s3_count<no_of_ones){
            s3.append(s.charAt(j));
            if(s.charAt(j)=='1') {
                s3_count++;
                flag=true;
            }
            if(!flag){
                s3_count_0=s3_count_0+1;
            }
            j++;
        }

        //System.out.println(s1+" "+s2+" "+s3);

        // System.out.println(s2_count_0);
        // System.out.println(s3_count_0);
        int a =s2_count_0;
        int b =s3_count_0;


        return (int)(((long) (a+1) * (b+1)) % MOD);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Saurav suman");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine();  // e.g., "10 20 30 40"

        String str=line.trim();

        NumberOfWaysToSplitString obj = new NumberOfWaysToSplitString();
        System.out.println( obj.numWays(str));
    }
}
