package com.leetcode.daily.year2024.month12;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Michael
 * @date: 2024/12/30
 * @desc:
 */
public class Day30 {

    public static void main(String[] args) {
        Integer[] inputList = {1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3};
        TreeNode treeNode2 = TreeBuilder.listToTree(inputList);
        ListNode listNode2 = ListBuilder.createLinkedList(List.of(1, 4, 2, 6));
        ListBuilder.printLinkedList(listNode2);
        System.out.println(isSubPath(listNode2, treeNode2));
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static boolean dfs(TreeNode rt, ListNode head) {
        // 链表已经全部匹配完，匹配成功
        if (head == null) {
            return true;
        }
        // 二叉树访问到了空节点，匹配失败
        if (rt == null) {
            return false;
        }
        // 当前匹配的二叉树上节点的值与链表节点的值不相等，匹配失败
        if (rt.val != head.val) {
            return false;
        }
        return dfs(rt.left, head.next) || dfs(rt.right, head.next);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListBuilder {

    // 根据提供的整数列表创建ListNode链表
    public static ListNode createLinkedList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        // 创建头节点
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        // 创建后续节点
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        return head;
    }

    // 打印ListNode链表用于验证
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

class TreeBuilder {

    public static TreeNode listToTree(Integer[] inputList) {
        if (inputList == null || inputList.length == 0 || inputList[0] == null) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(inputList[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < inputList.length) {
            TreeNode currentNode = queue.poll();

            // 左子节点
            if (i < inputList.length && inputList[i] != null) {
                currentNode.left = new TreeNode(inputList[i]);
                queue.offer(currentNode.left);
            }
            i++;

            // 右子节点
            if (i < inputList.length && inputList[i] != null) {
                currentNode.right = new TreeNode(inputList[i]);
                queue.offer(currentNode.right);
            }
            i++;
        }

        return root;
    }

    // 测试函数（仅用于验证）
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("None");
            return;
        }
        System.out.println("Root: " + root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                System.out.println(node.val + ".left = " + node.left.val);
                queue.offer(node.left);
            }
            if (node.right != null) {
                System.out.println(node.val + ".right = " + node.right.val);
                queue.offer(node.right);
            }
        }
    }
}