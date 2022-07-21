package class08;

/**
 * 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
 * 二叉树两个节点的距离：两个节点经过的节点数，包括自身
 */
public class Code08_MaxDistance {

    /**
     * 介绍二叉树的递归套路
     *   1）假设以X节点为头，假设可以向X左树和X右树要任何信息
     *   2）在上一步的假设下，讨论以X为头节点的树，得到答案的可能性（最重要）===> 分为经过 X 节点和不经过 X 节点
     *   3）列出所有可能性后，确定到底需要向左树和右树要什么样的信息 ===> 可能性：1.子树的最大距离是最大的； 2.经过 X 节点的距离是最大的；所以需要树高和子树的最大距离
     *   4）把左树信息和右树信息求全集，就是任何一棵子树都需要返回的信息S
     *   5）递归函数都返回S，每一棵子树都这么要求
     *   6）写代码，在代码中考虑如何把左树的信息和右树信息整合出整棵树的信息
     */

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 需要向左右子树获取的信息
    public static class Info {
        // 子树的最大距离
        public int maxDistance;
        // 子树的高度，用以计算经过父节点的距离
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    private Info process(Node head) {
        // base case
        if (head == null) {
            return new Info(0, 0);
        }

        // 向左右子树获取需要的信息
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        // 对信息进行加工，组装成 Info 返回
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = 0;
        maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), (leftInfo.height) + rightInfo.height + 1);

        return new Info(maxDistance, height);
    }
}
