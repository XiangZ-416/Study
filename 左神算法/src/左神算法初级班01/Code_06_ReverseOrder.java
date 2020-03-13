package 左神算法初级班01;
/**
 * 利用归并思想解决逆序对问题
 * @author Lenovo
 *
 */
public class Code_06_ReverseOrder {
	public static int ReverseOrder (int[] arr) {
		// 如果数组元素只有1个或为空数组，不用排序
		if (arr.length < 2 || arr == null) {
			return 0;
		}
		// 将原数组切分成两半
		return Sort(arr, 0, arr.length - 1);
	}
	
	public static int Sort (int[] arr, int L, int R) {
		// 左边界等于右边界时停止切半
		if (L == R) {
			return 0;
		}
		// 计算数组中点
		int mid = L + ((R - L) >> 1);
		
		//左边的逆序对数 + 右边的逆序对数 + 左右合并时的逆序对数
		return Sort(arr, L, mid) +
				 Sort(arr, mid + 1, R) +
				 merge(arr, L, mid, R);
	}
	
	public static int merge (int[] arr, int l, int m, int r) {
		// 两个指针
		int p1 = l;
		int p2 = m + 1;
		// 辅助数组
		int i = 0;
		int[] help = new int[r - l + 1];
		// 逆序对数
		int num = 0;
		// 排序各段并存放到辅助数组中
		while (p1 <= m && p2 <= r) {
			// 如果左边数 > 右边数
			// 逆序对数 = m到l之间的个数
			num += (arr[p1] > arr[p2]) ? (m - l + 1) : 0;
			help[i++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
		}
		//左半部分没存完
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		//右半部分没存完
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		//将辅助数组元素拷贝到原数组
		for(i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 0, 8};
		System.out.println("逆序对数量：" + ReverseOrder(arr));
	}
}