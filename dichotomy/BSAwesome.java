// 一个任意两数不相等的有序数组，查找数组中的局部最小值
// 定义何为局部最小值：
// arr[0] < arr[1]，0位置是局部最小；
// arr[N-1] < arr[N-2]，N-1位置是局部最小；
// arr[i-1] > arr[i] < arr[i+1]，i位置是局部最小；
public class BSAwesome {

	public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
        
        if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
        
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
        
        int left = 1;
		int right = arr.length - 2;
		int mid = 0;
        
        // 当 left == right 的时候返回，一定存在这个最小值
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return left;
    }
    
}
