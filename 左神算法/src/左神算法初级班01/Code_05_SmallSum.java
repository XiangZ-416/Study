package �����㷨������01;

public class Code_05_SmallSum {
	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		int mid = L + ((R - L) >> 1); // ��ͬ�� mid = l + (r - l) / 2
		//���С�� + �ұ�С�� + ���Һϲ�ʱ��С��
		return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, mid, R);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			// ���arr[p1]<arr[p2]
			// С��+ = p2(����p2)��r(����r)Ԫ�صĸ��� * arr[p1]
			// ���� С��+ = 0
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			// ��Ԫ��ȫ�����븨������
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5};
		System.out.println(smallSum(arr));
	}
}
