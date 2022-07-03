package class07;

public class Code01_RecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    // 递归遍历，利用的是递归的时候每个节点会经过 3 次
    // 对于节点 node，父节点到达 node 是第一次；遍历 node 左子节点回来后是第二次；遍历 node 右子节点后回来是第三次
    // 第一次的时候打印是先序；第二次打印是中序；第三次打印是后序
    public static void f(Node head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    // 先序打印所有节点
    public static void pre(Node head) {
        // 递归终止条件
        if (head == null) {
            return;
        }

        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    // 先序
    public static void in(Node head) {
        if (head == null) {
            return;
        }

        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    // 后序
    public static void pos(Node head) {
        if (head == null) {
            return;
        }

        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

}
