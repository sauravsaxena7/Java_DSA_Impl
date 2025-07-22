package com.common.utils;

import com.common.TreeNode;

public class CommonUtil {
    public static TreeNode buildBinaryTree(String[] arr){

        TreeNode[] nodes = new TreeNode[arr.length];
        TreeNode root = new TreeNode(arr[0],null,null);
        nodes[0]=root;

        for(int i=0;i< arr.length;i++){
            if(arr[i].equals("null")){
                nodes[i]=null;
                continue;
            }
            TreeNode node = nodes[i];

            int left = 2*i+1;
            int right = 2*i+2;

            if(left < arr.length){
                if(!arr[left].equals("null")){
                    TreeNode leftNode = new TreeNode(arr[left],null,null);
                    node.left = leftNode;
                    nodes[left]=leftNode;
                }
            }

            if(right < arr.length){
                if(!arr[right].equals("null")){
                    TreeNode rightNode = new TreeNode(arr[right],null,null);
                    node.right = rightNode;
                    nodes[right]=rightNode;
                }
            }
        }

        for (TreeNode node : nodes) {
            System.out.print((node == null ? null : node.val) + ", ");
        }
        System.out.println();

        return root;

    }
}
