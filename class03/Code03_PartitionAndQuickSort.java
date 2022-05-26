public class Code03_PartionAndQuickSort {
  public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 将数组分成两部分，小于等于arr[R]的在左边，右边的大于arr[R]，最后返回arr[R]最后的下标
    // 每次搞定一个数: arr[R]
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }

        if (L == R) {
            return L;
        }

        int index = L;
        // 左边数组下标
        int leftIndex = L - 1;
        while (index < R) {
            // 跟左边数组的下一个数交换，实现左边数组的扩大
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++leftIndex);
            }
            index++;
        }
        // 剩下arr[R]没交换
        swap(arr, leftIndex + 1, R);

        return leftIndex;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值，返回==arr[R]的下标
    //  <arr[R]  ==arr[R]  > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L < R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                // less 扩大边界
                swap(arr, index++, ++less);
            } else {
                // more 扩大边界，index 没有 ++，因为more交换过来后不知道是大于还是小于 arr[R]
                swap(arr, index, --more);
            }
        }
        swap(arr, R, more);

        // arr[less]是小于arr[R]的，arr[more]经过交换后是等于arr[R]的
        return new int[]{less + 1, more};
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        // base case
        if (L >= R) {
            return;
        }

        // 一次处理一个
        int m = partition(arr, L, R);
        process1(arr, L, m - 1);
        process1(arr, m + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        // base case
        if (L >= R) {
            return;
        }

        // 一次搞定多个数
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        // base case
        if (L >= R) {
            return;
        }

        // 一次处理多个，但是pivot选择随机位置的值
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

}
