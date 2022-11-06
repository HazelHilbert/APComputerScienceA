import java.util.Arrays;

//Bubble Sort, Selection Sort, Insertion Sort

public class SortingAlgorithms {
	public static void main(String[] args) {

		int[] nums = {3, 4, 5, 2, 1};
		System.out.println(Arrays.toString(nums));

		//  bubbleSort(nums);
		//  selectionSort(nums);
		//	insertionSort(nums);
	
		System.out.println(Arrays.toString(nums));
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					int arrJ = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = arrJ;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int small = i;
			for (int j = i; j < arr.length; j++) {
				if(arr[small] > arr[j]) {
					small = j;
				}
			}
			int s = arr[small];
			arr[small] = arr[i];
			arr[i] = s;
		}
	}

	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int possibleIndex = i-1;
			while(possibleIndex >= 0 && temp < arr[possibleIndex]) {
				arr[possibleIndex+1] = arr[possibleIndex];
				possibleIndex--;
			}
			arr[possibleIndex+1] = temp;
		}
	}
}