package org.educative.tree.examples;

import org.educative.tree.common.BinarySearchTree;
import org.educative.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAncestors {
    public static List<Integer> findAncestors(TreeNode<Integer> root, int k) {
        List<Integer> ancestors = new ArrayList<>();

        if (root == null) {
            return ancestors;
        }

        boolean found = false;
        TreeNode<Integer> traverseNode = root;

        while (traverseNode != null) {
            Integer data = traverseNode.getData();
            // if match found then break
            if (data.compareTo(k) == 0) {
                break;
            } else if (data.compareTo(k) > 0) {
                // if current > number then
                    // search left subtree
                traverseNode = traverseNode.getLeft();
            } else {
                // if current < number then
                    // search right subtree
                traverseNode = traverseNode.getRight();
            }

            if (traverseNode != null) {
                // push the number in array list
                ancestors.add(data);
            } else {
                // if node is null then clear ancestors list
                ancestors = new ArrayList<>();
            }
        }

        return ancestors;
    }

    public static void main(String[] args) {
        Integer inputs[][] = {
                {100, 50, 200, 25, 75, 150 , 350},
                {25, 15, 75, 8, 18, 50, 350},
                {350, -100, 450, -175, 125, 375, 500},
                {100},
                {23, 21, 27, 18, 22, 25, 29, 17, 19, 23,45,67,78, 85},
        };
        int k[] = {75, 8, 125, 100, 85};

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<>(inputs[i]);
            System.out.println((i+1)+ "\tInput Tree: ");
            System.out.println("\n\tk: " + k[i]);
            System.out.println("\n\tThe ancestors are : " + findAncestors(inputTree.getRoot(), k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
