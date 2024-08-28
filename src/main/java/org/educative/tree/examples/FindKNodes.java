package org.educative.tree.examples;

import lombok.extern.slf4j.Slf4j;
import org.educative.tree.common.BinarySearchTree;
import org.educative.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FindKNodes {

    public static List<Integer> findKNodes(TreeNode<Integer> root, int k) {

        // Replace this placeholder return statement with your code
        List<Integer> result = new ArrayList<>();
        findKNodesRec(root, k , 0, result);
        return result;
    }

    private  static void findKNodesRec (TreeNode<Integer> treeNode, int k, int dist, List<Integer> result) {
        if (treeNode == null) {
            return;
        }

        log.info("Before Node {}, dist {} , k {}, result {}", treeNode, dist, k, result);

        if (dist == k) {
            result.add(treeNode.getData());
            return;
        }

        dist+=1;

        log.info("After Node {}, dist {} , k {}", treeNode, dist, k);

        findKNodesRec(treeNode.getLeft(), k, dist, result);
        findKNodesRec(treeNode.getRight(), k, dist, result);
    }

    public static void main(String args[]) {

        Integer[][] inputs = {
                {8,10, 5, 6, 5, 14},
//                {2, 1, 4, 3, 5, 6, 7},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9},
//                {45, 32, 23, 21, 18, 1},
//                {8, 5, 9, 4, 6, null, 10},
//                {10, 6, 9, 3, null, 8, null, 3},
        };
        Integer[] k = {1};

//        for (int i = 0; i < inputs.length; i++) {
//            BinaryTree<Integer> inputTree = new BinaryTree<Integer>(inputs[i]);
//            System.out.println((i + 1) + ".\tInput Tree:");
//            System.out.println("\n\tk: " + k[i]);
//            List<Integer> result = findKNodes(inputTree.getRoot(), k[i]);
//            System.out.println("\n\tResult: " + Arrays.toString(result.toArray()));
//            System.out.println(new String(new char[100]).replace('\0', '-'));
//        }

    }
}
