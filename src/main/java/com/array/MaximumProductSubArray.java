package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 *
 * solution
 * 1. all +ve integer -> max product will be all prefix product or suffix product
 * 2. even no of -ve integer -> max product will be all prefix product or suffix product
 * 3. odd no of -ve integer -> after selecting one of the -ve integer in between of array either prefix or suffix will be maximum
 * example 1 2 3 4 -9 5 1 -4 9 2 7
 *
 * 4. if array contains 0
 * example 1 2 3 0 8 4 0 0 1 3
 *
 *
 */

public class MaximumProductSubArray {


    public int maxProduct(int[] nums) {

        int maximum = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix=1;

        for (int i=0;i<nums.length;i++){

            prefix=prefix*nums[i];
            suffix=suffix*nums[nums.length-i-1];
            maximum = Integer.max(maximum, Integer.max(prefix,suffix));

            if(prefix==0) prefix=1;
            if (suffix==0) suffix=1;



        }
        return maximum;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine();  // e.g., "10 20 30 40"

        // Split and parse into int array
        int[] arr = Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new MaximumProductSubArray().maxProduct(arr));
    }
}
