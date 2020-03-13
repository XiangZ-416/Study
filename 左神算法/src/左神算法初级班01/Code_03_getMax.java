package 左神算法初级班01;
/* 理解递归
 * 利用递归寻找数组中的最大值
 */
public class Code_03_getMax {
	public  static int getMaxNum (int[] arr, int L, int R) {
		//递归终止条件
		if (L == R) {
			return arr[L];
		}
		
		int mid = (L + R) / 2;
		int maxL = getMaxNum(arr, L, mid);
		int maxR = getMaxNum(arr, mid + 1, R);
		int Max = Math.max(maxL, maxR);
		
		return Max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,9,3,4};
		System.out.println(getMaxNum(arr, 0, arr.length - 1));
	}
}
