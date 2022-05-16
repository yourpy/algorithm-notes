package class02;

// 用环形数组实现栈和队列
public class Code04_RingArray {
    public static class MyQueue {
        private int[] arr;
        // 用两个变量标记 push 和 pull 的位置
        private int pushI;
        private int pullI;
        // 用 size 标记 arr 是否满了，不使用 pushI 和 pullI 计算
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.pushI = 0;
            this.pullI = 0;
            this.size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了");
            }

            size++;
            arr[pushI] = value;
            pushI = nextIndex(pullI);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("栈空了");
            }

            size--;
            int ans = arr[pullI];
            pullI = nextIndex(pullI);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
