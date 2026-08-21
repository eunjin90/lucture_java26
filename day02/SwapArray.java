package day02;

import java.util.Arrays;

public class SwapArray {
	
	int[] swapArray(int numList[]) {
		
		for (int i=0; i<numList.length/2; i++) {
			int temp = numList[i];
	        numList[i] = numList[numList.length - 1 - i];
	        numList[numList.length - 1 - i] = temp;
		}
		return numList;
	}
	
	public static void main(String[] args) {
		
		int numList[] = {20, 37, 17, 24, 53};
		
		SwapArray sa = new SwapArray();
		
		int[] arr = sa.swapArray(numList);
		
		System.out.println(Arrays.toString(arr));
	}

}