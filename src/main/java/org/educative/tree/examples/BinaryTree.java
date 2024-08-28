package org.educative.tree.examples;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.educative.tree.common.TreeNode;

@Slf4j
@Getter
public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insertRecursive(T data) {
        if (this.root == null) {
            this.root = new TreeNode<>(data);
            return;
        }

        if (root.getData().compareTo(data) >= 0) {
            //Insert to left subtree
            root.setLeft(insertDataInSubtree(data, root.getLeft()));
        } else {
            //Insert to right subtree
            root.setRight(insertDataInSubtree(data, root.getRight()));
        }
    }

    private TreeNode<T> insertDataInSubtree(T data, TreeNode<T> treeNode) {
        if (treeNode == null) {
            return new TreeNode<>(data);
        }

        if (treeNode.getData().compareTo(data) >= 0) {
            treeNode.setLeft(insertDataInSubtree(data, treeNode.getLeft()));
        } else {
            treeNode.setRight(insertDataInSubtree(data, treeNode.getRight()));
        }

        return treeNode;
    }


    public void insertIterative(T data) {
        if (this.root == null) {
            this.root = new TreeNode<>(data);
            return;
        }

        TreeNode<T> node = root;

        while (true) {
            if (node.getData().compareTo(data) >= 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode<>(data));
                    break;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode<>(data));
                    break;
                }
                node = node.getRight();
            }
        }
    }

    public TreeNode<T> searchRecursive(T value) {
       if (this.root == null) {
           return  null;
       }

       T data = root.getData();
       TreeNode<T> matchedNode;
       if (data == value ) {
           matchedNode = this.root;
       } else if (data.compareTo(value) > 0) {
           matchedNode = searchInSubtree(value, root.getLeft());
       } else {
           matchedNode = searchInSubtree(value, root.getRight());
       }

        return matchedNode;

    }

    private TreeNode<T> searchInSubtree(T value, TreeNode<T> treeNode) {
        TreeNode<T> matchedNode = null;

        if (treeNode == null) {
            return matchedNode;
        }

        T data = treeNode.getData();

        if (data.compareTo(value) == 0) {
            matchedNode = treeNode;
        } else if (data.compareTo(value) > 0) {
            matchedNode = searchInSubtree(value, treeNode.getLeft());
        } else {
            matchedNode = searchInSubtree(value, treeNode.getRight());
        }

        return matchedNode;
    }

    public TreeNode<T> searchIterative(T value) {
        if (this.root == null) {
            return  null;
        }

        T data = root.getData();
        TreeNode<T> matchedNode = null;
        TreeNode<T> traverseNode = root;
        while (traverseNode != null) {
            if (data.compareTo(value) == 0) {
                matchedNode = traverseNode;
                break;
            } else if (data.compareTo(value) > 0) {
                traverseNode = traverseNode.getLeft();
            } else {
                traverseNode = traverseNode.getRight();
            }
            data = traverseNode == null? data : traverseNode.getData();
        }


        return matchedNode;

    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insertRecursive(6);
        binaryTree.insertRecursive(4);
        binaryTree.insertRecursive(9);
        binaryTree.insertRecursive(2);
        binaryTree.insertRecursive(5);
        binaryTree.insertRecursive(12);
        binaryTree.insertRecursive(8);
        binaryTree.insertRecursive(14);
        binaryTree.insertRecursive(10);

//        binaryTree.insertIterative(6);
//        binaryTree.insertIterative(4);
//        binaryTree.insertIterative(9);
//        binaryTree.insertIterative(2);
//        binaryTree.insertIterative(5);
//        binaryTree.insertIterative(12);
//        binaryTree.insertIterative(8);
//        binaryTree.insertIterative(14);
//        binaryTree.insertIterative(10);

        TreeNode<Integer> treeNode = binaryTree.searchRecursive(9);
        log.info(" Recursive search : Node {} , left {} right {}", treeNode.getData(), treeNode.getLeft(), treeNode.getRight());
        treeNode = binaryTree.searchIterative(4);
        log.info(" Iterative search : Node {} , left {} right {}", treeNode.getData(), treeNode.getLeft(), treeNode.getRight());

    }
}
