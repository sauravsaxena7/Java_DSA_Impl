package com.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int start= 0;
        int end = nums.length-1;

        while (start<=end){
            int mid = (end+start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine();  // e.g., "10 20 30 40"

        // Split and parse into int array
        int[] arr = Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        line = br.readLine();
        int k=Integer.parseInt(line.trim());

        System.out.println(binarySearch(arr,k));
    }
}
