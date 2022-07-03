package class07;

import java.util.Stack;

public class Code02_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }


    // 先序：根左右
    public static void pre(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    // 中序：左根右
    // 根据中序遍历的顺序，对于任意节点，优先访问其左孩子，而左孩子节点又可以看做一根节点，然后继续访问左孩子节点为空的节点才进行
    // 访问，然后按相同的规则访问其右子树。因此其处理过程如下：
    //   对于任意节点
    //   （1）其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前节点P再进行相同的处理
    //   （2）若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶节点，然后将当前的P置为栈顶节点的右孩子
    //   （3）直到P为NULL并且栈为空则遍历结束

    // 非递归算法思想：
    //  （1）设置一个栈S存放所经过的根结点（指针）信息；初始化S；
    //  （2）第一次访问到根结点并不访问，而是入栈；
    //  （3）中序遍历它的左子树，左子树遍历结束后，第二次遇到根结点，就将根结点（指针）退栈，并且访问根结点；然后中序遍历它的右子树。
    //  （4） 当需要退栈时，如果栈为空则结束。
    public static void in(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            // 第一次遇到
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                // 第二次遇到
                // 弹出根节点并打印
                head = stack.pop();
                System.out.print(head + " ");
                // 移动到右节点
                head = head.right;
            }
        }
    }

    // 后序
    // 先序遍历是“根左右”，后序是“左右根”
    // 使用“根右左”的顺序遍历，然后存到一个栈，打印出来就是左右根
    public static void pos(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            // 打印 --> 存储到 stack2
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value);
        }
    }
}
