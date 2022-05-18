package class03;

public class Code01_MergeSort {
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 把 arr[l, r] 范围变成有序
    private static void process(int[] arr, int l, int r) {
        // base case，跳出递归
        if (l == r) {
            return;
        }

        int mid = l + (r - l) / 2;
        // 左半部分有序
        process(arr, l, mid);
        // 右半部分有序
        process(arr, mid + 1, r);
        // 两部分合起来有序
        merge(arr, l, mid, r);
    }

    // 把两个有序数组合并成一个有序数组
    private static void merge(int[] arr, int l, int mid, int r) {
        // 准备一个辅助数组
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        // p1 或者 p2 越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 把 help 数组写回 arr
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    // 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 当前有序的左组长度
        int mergeSize = 1;
        int n = arr.length;
        while (mergeSize < n) {
            // arr 分成 n / 2mergeSize 组，
            int l = 0;
            // 开始 mergeSort
            while (l < n) {
                // [l, mid] [mid+1, r]
                int mid = l + mergeSize - 1;
                // 最后一组只剩下左组，已经是有序了，break
                if (mid >= n) {
                    break;
                }

                // 右组的 index，如果在最右边，有可能 mid + mergeSize > n - 1，所以取小
                int r = Math.min(mid + mergeSize, n - 1);
                merge(arr, l, mid, r);
                l = mid + 1;
            }

            if (mergeSize > n / 2) {
                break;
            }
            mergeSize = 2 * mergeSize;
        }
    }
}
