package class08;




/**
 * 介绍二叉树的递归套路
 *   1）假设以X节点为头，假设可以向X左树和X右树要任何信息
 *   2）在上一步的假设下，讨论以X为头节点的树，得到答案的可能性（最重要）。（ps：一般可以用跟 x 有关和跟 x 无关划分）
 *   3）列出所有可能性后，确定到底需要向左树和右树要什么样的信息
 *   4）把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
 *   5）递归函数都返回S，每一棵子树都这么要求
 *   6）写代码，在代码中考虑如何把左树的信息和右树信息整合出整棵树的信息
 */




// 给定一个头节点，判断这棵树是不是平衡二叉树
// 平衡二叉树：
//     1. 左子树是平衡二叉树；
//     2. 右子树是平衡二叉树
//     3. 左右子树的高度差不超过一
public class Code01_IsBalanced_Test {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    // 节点提供的信息
    public static class Info {
        // 树的高度
        public int height;
        // 以当前节点为根节点的树是否平衡
        public boolean isBalanced;
        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalanced2(Node head) {
        return process(head).isBalanced;
    }

    private static Info process(Node head) {
        // base case
        if (head == null) {
            return new Info(0, true);
        }

        // 向左右子树获取信息
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        // 获得当前节点树高
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 根据左右子树获得的信息判断是否平衡
        boolean isBalanced = true;
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }

        return new Info(height, isBalanced);
    }


}
