package class05;

// 计数排序
public class CountSort {

    // only for 0~200 value
    // 一是需要排序的元素必须是整数，二是排序元素的取值要在一定范围内，并且比较集中。
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 找到最大值 max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 创建一个大小为 max +1 的数组 bucket
        int[] bucket = new int[max + 1];

        // 遍历数组 arr，统计每个数字出现的次数，写到 bucket
        // bucket 的下标 index 表示统计的数字；bucket[index] 表示数字的个数
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        // 遍历 bucket，将 bucket 的数字写回 arr
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }
}


