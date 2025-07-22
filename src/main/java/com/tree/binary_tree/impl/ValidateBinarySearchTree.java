package com.tree.binary_tree.impl;


import com.common.TreeNode;
import com.common.utils.CommonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ValidateBinarySearchTree {

    public static void dfs(TreeNode root, ArrayList<Integer> sortedArray){
        if(root==null){
            return;
        }
        dfs(root.left,sortedArray);
        sortedArray.add(Integer.valueOf(root.val));
        dfs(root.right,sortedArray);
    }

    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> sortedArray = new ArrayList<>();

        dfs(root,sortedArray);
        System.out.print(sortedArray);

        for(int i=0; i<sortedArray.size()-1; i++){
            if(sortedArray.get(i) >= sortedArray.get(i+1)) return false;
        }
        return true;

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Saurav Suman");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line= br.readLine();
        String[] arr = line.trim().split(",");

        TreeNode root = CommonUtil.buildBinaryTree(arr);

        System.out.println("IsValidBST::: "+isValidBST(root));

    }
}
