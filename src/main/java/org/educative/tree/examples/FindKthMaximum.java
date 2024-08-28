package org.educative.tree.examples;

import lombok.extern.slf4j.Slf4j;
import org.educative.tree.common.BinarySearchTree;
import org.educative.tree.common.TreeNode;

@Slf4j
public class FindKthMaximum {

    public static int findKthMax(TreeNode<Integer> root, int k) {
        int[] kValue = {k};
        return kthMaximumRec(root, kValue);
    }

    private static int kthMaximumRec(TreeNode<Integer> node, int[] k) {

        if (node == null) {
            return -1;
        }

        log.info("Before Node {}", node);

        int right = kthMaximumRec(node.getRight(), k);

        log.info("After Node {}", node);

        if (right != -1) {
            return right;
        }

        log.info("Before K {}", k[0]);

        k[0]--;

        log.info("After K {}", k[0]);

        if (k[0] == 0) {
            return node.getData();
        }

        return kthMaximumRec(node.getLeft(), k);
    }

    private static int kthMinimumRec(TreeNode<Integer> node, int[] k) {

        if (node == null) {
            return -1;
        }

        log.info("kthMinimumRec : Before Node {}", node);

        int left = kthMaximumRec(node.getLeft(), k);

        log.info("kthMinimumRec : After Node {}", node);

        if (left != -1) {
            return left;
        }

        log.info("kthMinimumRec : Before K {}", k[0]);

        k[0]--;

        log.info("kthMinimumRec: After K {}", k[0]);

        if (k[0] == 0) {
            return node.getData();
        }


        return kthMinimumRec(node.getRight(), k);
    }

    public static void main(String[] args) {
        Integer[][] inputs = {
                {10, 3, 4, 13, 14, 11},
//                {18, 15, 13, 19, 5, 14},
//                {1, 2, 3, 4, 5, 6},
//                {100, 200, 50, 40, 30, 80, 90},
//                {10},
//                {1, 2},
//                {-10, -20, -30, -40, -50, -60, -70}
        };
//        int[] k = {2, 4, 6, 1, 1, 3};
        int[] k = {6};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tk = " + k[i]);
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            log.info("\n\tInput tree: ");
            log.info("\n\tKth maximum element is: " + findKthMax(inputTree.getRoot(), k[i]));
            log.info(new String(new char[100]).replace('\0', '-'));
        }
    }
}
