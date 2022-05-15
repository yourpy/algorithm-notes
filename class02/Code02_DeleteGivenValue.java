public class Code02_DeleteGivenValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
    
    public static Node removeValue(Node head, int num) {
        // 判断 head 是否等于 num，如果head == num，找到第一个不为 num 的头节点
        while (head != null) {
            if (head != num) {
                break;
            }
            head = head.next;
        }
        
        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        
        return head;
    }
}
