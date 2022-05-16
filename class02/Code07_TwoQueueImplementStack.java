package class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code07_TwoQueueImplementStack {
    public static class TwoQueueStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        // 往 stack push
        public void push(T value) {
            queue.offer(value);
        }

        // pop 数据
        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T ans = queue.poll();
            Queue<T> temp = help;
            help = queue;
            queue = temp;

            // 队列最后一个就是要返回的值
            return ans;
        }

        // 查看栈顶数据
        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T ans = queue.poll();
            // 获取后压回去
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
