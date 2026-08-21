package day02;

public class Sum {
	
	int getSum(int[] numList) {
		int sum = 0;
		
		for (int i=0; i<numList.length; i++) {
			sum += numList[i];
		}
		return sum;
	}
	

	public static void main(String[] args) {
		
		int numList[] = {20, 37, 17, 24, 53};
		
		Sum s = new Sum();
		
		int sum = s.getSum(numList);
		
		System.out.println(sum);
	}

}