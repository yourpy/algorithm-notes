import java.util.Arrays;

public class BSNearLeft {
    
    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1; // 记录最左的对号
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return index;
    }
}
