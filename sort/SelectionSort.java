import java.util.Arrays;

public class SelectionSort {
    
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length(); j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[j] = arr[i];
        arr[j] = tmp;
    }
}
