package org.educative.tree.examples;

import lombok.extern.slf4j.Slf4j;
import org.educative.tree.common.BinarySearchTree;
import org.educative.tree.common.TreeNode;

@Slf4j
public class FindHeight {
    static int findHeight(TreeNode<Integer> root) {
        // Check if root exists, no root means 0 height of the tree
        if (root == null) {
            return 0;
        }

        // Otherwise, recursively find the height of the tree
        else {
            log.info("Calculate height for node {}", root);

            // Finding the max height of both sub-trees
            TreeNode<Integer> leftNode = root.getLeft();
            int leftSubTreeHeight = findHeight(leftNode);
            log.info("Left subtree root node {} height {}", leftNode, leftSubTreeHeight);

            TreeNode<Integer> rightNode = root.getRight();
            int rightSubTreeHeight = findHeight(rightNode);
            log.info("Right subtree root node {} height {}", rightNode, rightSubTreeHeight);

            int maxSubTreeHeight = Math.max(leftSubTreeHeight, rightSubTreeHeight);

            // Add 1 to max height and return

            int ret = 1 + maxSubTreeHeight;
            log.info("Max height {} of node is {}", ret, root);

            return ret;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Integer[][] inputs = {
                {17, 10, 4, 12, 15, 11, 22, 19, 26},
//                {1, 2, 3, 4, 5, 6},
//                {100, 200, 50, 40, 30, 80, 90},
//                {10},
//                {1, 2},
//                {-10, -20, -30, -40, -50, -60, -70}
        };

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            System.out.println((i + 1) + ".\tGiven Tree: ");
            System.out.println("\n\tHeight of the Tree: " + findHeight(inputTree.getRoot()));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
