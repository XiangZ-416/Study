package �����㷨������01;
/**
 * @Author ZX
 * @Description //TODO �鲢����
 * @Date 14:49 2020/3/24
 * @Param
 * @return
 **/
public class Code_04_mergeSort {
	/**
	 * �鲢����
	 * @param arr
	 */
	public static void MergeSort (int[] arr) {
		// ���arrֻ��һ��Ԫ�ػ���arrΪ�գ������з�
		if (arr == null || arr.length < 2) {
			return;
		}
		// �����������з�Ϊ����
		Divide(arr, 0, arr.length - 1);
	}
	/**
	 * �з�
	 * @param arr
	 * @param L
	 * @param R
	 */
	public static void Divide(int[] arr, int L, int R) {
		// ���鲻���ٷ֣�ֹͣ����
		if (L == R) {
			return;
		}
		
		// ������м�����;��ͬ��(L + R) / 2
		int mid = L + ((R - L) >> 1);
		// �����з���벿��;T(N/2)
		Divide(arr, L, mid);
		// �����з��Ұ벿��;T(N/2)
		Divide(arr, mid + 1, R);
		// �鲢��������;O(N)
		merge(arr, L, mid, R);
		// T(N) = 2 T(N/2) + O(N)
	}
	/**
	 * �ϲ�
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 */
	public static void merge (int[] arr, int l, int m, int r) {
		// ��������ָ��
		int p1 = l;
		int p2 = m + 1;
		// ���帨������
		int[] help = new int[r - l + 1];
		// ���򲢴��븨��������
		int i = 0;
		while (p1 <= m && p2 <= r) {
			help[i++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) { // p1ûԽ��
			help[i++] = arr[p1++];
		}
		while (p2 <= r) { //p2ûԽ��
			help[i++] = arr[p2++];
		}
		// ����������Ԫ�ظ�ֵ��ԭ����
		for (i = 0; i < help.length; i++) {
			// һ���Ǹ�ֵ��arr[l + i]������arr[i]����Ϊ����������һ������һ�Σ�i��ʼʼ��Ϊ0������ֵ��ԭ����Ӧ��������
			arr[l + i] = help[i]; 
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		MergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
