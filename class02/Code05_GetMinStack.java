package class02;

import java.util.Stack;

public class Code05_GetMinStack {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int value) {
            // 最小栈始终存储当前位置的最小值
            if (stackMin.empty()) {
                stackMin.push(value);
            } else if (value <= stackMin.peek()){
                stackMin.push(value);
            } else {
                stackMin.push(stackMin.peek());
            }

            stackData.push(value);
        }

        public int pop() {
            // 两个一起弹出
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty.");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }    
}
