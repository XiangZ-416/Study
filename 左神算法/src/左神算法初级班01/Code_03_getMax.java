package �����㷨������01;
/* ���ݹ�
 * ���õݹ�Ѱ�������е����ֵ
 */
public class Code_03_getMax {
	public  static int getMaxNum (int[] arr, int L, int R) {
		//�ݹ���ֹ����
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
