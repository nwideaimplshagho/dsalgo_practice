package org.educative.tree.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"left", "right"})
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
