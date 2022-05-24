// 在一个数组中，每一个数左边比当前数小的累加起来，叫做这个数的小和，求一个数组的小和
// 一个数左边有几个比当前的数小 ==> 一个数右边有几个数比当前数大

public class Code02_SmallSum {
    
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和返回
    // 所有merge时，产生的小和，累加
    // 左 排序   merge
    // 右 排序  merge
    // merge
    private static int process(int[] arr, int l, int r) {
        // 结束递归
        if (l == r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        // 辅助数组下标
        int index = 0;

        int res = 0;

        // 左半边数组和右半边数组下标
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                // // 因为两边都是有序的，所以 p2 及其后面有(r - p2 + 1)个元素大于 arr[p1]
                res = res + arr[p1] * (r - p2 + 1);
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }

        // p1 没越界
        while (p1 <= m) {
            help[index++] = arr[p1++];
        }
        // p2 没越界
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }

        // 拷贝回原数组
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return res;
    }
}
