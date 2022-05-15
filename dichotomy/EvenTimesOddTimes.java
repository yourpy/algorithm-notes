 public class EvenTimesOddTimes {
     // arr中，只有一种数，出现奇数次
	public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		System.out.println(eor);
    }
     
     // arr中，有两种数，出现奇数次
	public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
        
        // eor = a ^ b
		// eor != 0
		// eor必然有一个位置上是1
		// 0110010000
		// 0000010000
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
			// rightOne=  000000000010000
            if (arr[i] & rightOne != 0) {
                onlyOne ^= arr[i];
            }
        }
        
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
 }
