public class BSExist {
	// 二分查找
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		
		int l = 0;
		int r = sortedArr.length - 1;
		int mid = 0;
		
		while (r > l) {
			// 防止 r + l 超出 int 范围
			mid = l + (r - l) / 2;
			if (sortedArr[mid] == num) {
				return true;
			} else if (sortedArr[mid] > num) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return sortedArr[L] == num;
    }
	
}
