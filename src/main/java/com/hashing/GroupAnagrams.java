package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//eat tea tan ate nat bat

public class GroupAnagrams {
    private static String generateUniqueAnagramKey(String str){
        int[] arr = new int[26];

        for(int i=0;i<str.length();i++){
            arr[(str.charAt(i)-'a')]++;
        }

        return Arrays.toString(arr);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            String key = generateUniqueAnagramKey(str);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = reader.readLine().trim().split(" ");

        System.out.println("Group anagram:: "+groupAnagrams(strs));
    }
}
