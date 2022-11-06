import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {4, 8, 3, 6, 7, 9};

		sort(a);

		System.out.println(Arrays.toString(a));
	}

	private static void merge(int[] first, int[] second, int[] a) {
		int i = 0;
		while(a[i] != 0) {
			i++;
		}

		if (first.length == 0) {
			for (int x=i; x<a.length; x++)
				a[x]=second[x-i];
		}
		else if (second.length == 0) {
			for (int x=i; x<a.length; x++)
				a[x]=first[x-i];
		}
		else if (first[0] < second[0]) {
			a[i] = first[0];
			merge(remove(first), second, a);
		}
		else {
			a[i] = second[0];
			merge(first, remove(second), a);
		}
	}

	private static int[] remove(int[] arr) {
		int[] a = new int[arr.length-1];
		for(int i = 1; i < arr.length; i++) {
			a[i-1] = arr[i];
		}
		return a;
	}

	public static void sort(int[] a)
	{	
		// if length is less than or equal to one, the array is sorted
		if (a.length <= 1) { 
			return; 
		}

		int k = a.length/2;

		//create an array for the first half of a
		int[] first = new int[k];

		//create an array for the second half of a
		int[] second = new int[a.length-k];

		// Now copy the first half of array a into first, the second half into second
		for (int n = 0; n < k; n++) {
			first[n]=a[n];
		}
		for (int n = k; n < a.length; n++) {
			second[n-k]=a[n];
		}

		// recursively sort the partitions of the array
		sort(second);
		sort(first);
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}

		//Call merge to join the partitions together.		
		merge (first, second, a);
	}
}
