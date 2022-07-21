package class08;

// 给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的大小

/**
 *
 * 介绍二叉树的递归套路
 *   1）假设以X节点为头，假设可以向X左树和X右树要任何信息
 *   2）在上一步的假设下，讨论以X为头节点的树，得到答案的可能性（最重要）。（ps：跟 X 节点无关，即 X 不是搜索二叉树，最大 size 在子树；跟 X 有关）
 *   3）列出所有可能性后，确定到底需要向左树和右树要什么样的信息 ===> 需要知道子树是否是搜索二叉树，子树的最大最小值（用以判断 X 是否是搜索二叉树），子树的最大搜索二叉树的大小
 *   4）把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
 *   5）递归函数都返回S，每一棵子树都这么要求
 *   6）写代码，在代码中考虑如何把左树的信息和右树信息整合出整棵树的信息
 */

public class Code04_MaxSubBSTSize_Test {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        // 整棵树是不是搜索二叉树
        public boolean isAllBST;
        // 当前树的最小值和最大值
        public int min;
        public int max;
        // 当前树的最大子搜索二叉树大小
        public int maxSubBSTSize;

        public Info(boolean isAllBST, int max, int min, int maxSubBSTSize) {
            this.isAllBST = isAllBST;
            this.min = min;
            this.max = max;
            this.maxSubBSTSize = maxSubBSTSize;
        }
    }

    public static int maxSubBSTSize2(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head).maxSubBSTSize;
    }

    // 主处理函数
    private static Info process(Node head) {
        // base case
        if (head == null) {
            return null;
        }

        // 从左右子树获取的信息
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        // 根据信息进行组装判断，分为跟 head 有关和无关
        int max = head.value;
        int min = head.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, leftInfo.maxSubBSTSize);
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }

        boolean isAllBST = false;
        // 判断以 head 根节点的树是否是二叉搜索树
        // 左子树需要是二叉搜索树，右子树需要是二叉搜索树
        // 且 head.value 大于左子树的最大值，小于右子树的最小值
        if (
                (leftInfo == null ? true : leftInfo.isAllBST)
                &&
                (rightInfo == null ? true : rightInfo.isAllBST)
                &&
                (leftInfo == null ? true : head.value > leftInfo.max)
                &&
                (rightInfo == null ? true : head.value < rightInfo.min)
        ) {
            // 以 X 为节点的树是搜索二叉树，判断大小
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
            isAllBST = true;
        }

        return new Info(isAllBST, max, min, maxSubBSTSize);
    }

}
