import java.util.Stack;

public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        // push --> pop
        // pop 未弹出所有元素则不新加，保证弹出顺序
        private void pushToPop() {
            if (stackPop.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        // 往队列添加数据
        public void add(int value) {
            stackPush.push(value);
            pushToPop();
        }

        // 从队列弹出数据
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            }

            pushToPop();
            return stackPop.pop();
        }

        // 查看队列最先压进的数据
        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            }

            pushToPop();
            return stackPop.peek();
        }
    }
}
