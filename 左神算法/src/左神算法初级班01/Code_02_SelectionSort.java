package ×óÉñËã·¨³õ¼¶°à01;

public class Code_02_SelectionSort {
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 3, 6, 2, 7, 4};
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
