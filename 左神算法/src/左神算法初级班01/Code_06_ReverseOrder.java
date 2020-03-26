package �����㷨������01;
/**
 * ���ù鲢˼�������������
 * @author Lenovo
 *
 */
public class Code_06_ReverseOrder {
	public static int ReverseOrder (int[] arr) {
		// �������Ԫ��ֻ��1����Ϊ�����飬��������
		if (arr == null || arr.length < 2) {
			return 0;
		}
		// ��ԭ�����зֳ�����
		return Divide(arr, 0, arr.length - 1);
	}
	
	public static int Divide(int[] arr, int L, int R) {
		// ��߽�����ұ߽�ʱֹͣ�а�
		if (L == R) {
			return 0;
		}
		// ���������е�
		int mid = L + ((R - L) >> 1);
		
		//��ߵ�������� + �ұߵ�������� + ���Һϲ�ʱ���������
		return Divide(arr, L, mid) +
				 Divide(arr, mid + 1, R) +
				 merge(arr, L, mid, R);
	}
	
	public static int merge (int[] arr, int l, int m, int r) {
		// ����ָ��
		int p1 = l;
		int p2 = m + 1;
		// ��������
		int i = 0;
		int[] help = new int[r - l + 1];
		// �������
		int num = 0;
		// ������β���ŵ�����������
		while (p1 <= m && p2 <= r) {
			// �������� > �ұ���
			// ������� = m��l֮��ĸ���
			num += (arr[p1] > arr[p2]) ? (m - p1 + 1) : 0;
			help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
		}
		//��벿��û����
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		//�Ұ벿��û����
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		//����������Ԫ�ؿ�����ԭ����
		for(i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		System.out.println("�����������" + ReverseOrder(arr));
	}
}