/**
 * 折纸问题
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开
 * 此时折痕是凹下去的，即折痕突起的方向指向纸条的背面
 * 如果从纸条的下边向上方连续对折2次，压出折痕后展开
 * 此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次
 * 请从上到下打印所有折痕的方向。
 *  N=1时，打印: down
 *  N=2时，打印: down down up   （ps：左中右）
 */
public class Code08_PaperFolding_Test {
    /**
     * 一折痕上方的折痕必然是 down，下方的折痕必然是 up
     * 把第一次的写在第一行，第二次的写在第一行节点的左右，第三行同理，就构成了一个二叉树，左子节点是down，右子节点是up
     * 使用中序遍历的方式就可以得到从上到下的顺序
     * @param N：折纸的次数
     */
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    // 递归过程，来到了某一个节点，
    // i是节点的层数，N一共的层数，down == true  凹    down == false 凸
    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }
}
