package class05;

public class TrieTreeTest {

    public static class Node{
        // 经过次数
        public int pass;

        // 终点次数
        public int end;

        // 下面的节点
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            // 0    a
            // 1    b
            // 2    c
            // ..   ..
            // 25   z
            // nexts[i] == null   i方向的路不存在
            // nexts[i] != null   i方向的路存在
            nexts = new Node[26];
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            // 转换成字符
            char[] str = word.toCharArray();
            Node node = root;
            node.pass++;
            for (int i = 0; i < str.length; i++) {
                // 由字符，对应成走向哪条路
                int index = str[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                // 移动到下一个节点
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            // 转换成字符
            char[] str = word.toCharArray();
            Node node = root;
            node.pass--;
            for (int i = 0; i < str.length; i++) {
                // 由字符，对应成走向哪条路
                int index = str[i] - 'a';
                node.nexts[index].pass--;
                if (node.nexts[index].pass == 0) {
                    // 断开链接
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }

        // 查找加入过几次
        public int search(String word) {
            if (word == null || word.length() == 0) {
                return 0;
            }

            Node node = root;
            char[] str = word.toCharArray();
            for (int i = 0; i < str.length; i++) {
                int path = str[i] - 'a';
                // 其中一个字符没添加
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }

        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null || pre.length() == 0) {
                return 0;
            }

            Node node = root;
            char[] str = pre.toCharArray();
            for (int i = 0; i < str.length; i++) {
                int path = str[i] - 'a';
                // 其中一个字符没添加
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }
    }
    
    // 第二种实现是数组换 HashMap
}
