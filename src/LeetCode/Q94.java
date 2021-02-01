package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvin on 2020/04/14.
 */
//Recursion
//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Q94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(null);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);

        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;

        System.out.println(inorderTraversal(treeNode1));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        recursion(root,results);
        return results;
    }

    private static void recursion(TreeNode root, List<Integer> results) {
        if (root != null) {
            if (root.left != null) {
                recursion(root.left, results);
            }
            results.add(root.val);

            if (root.right != null) {
                recursion(root.right, results);
            }

        }
    }

}
