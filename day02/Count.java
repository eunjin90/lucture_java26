package day02;

public class Count {
	
	int getCount(int[] numList, int target) {
		int count = 0;
		
		for(int i=0; i<numList.length;i++) {
			if(numList[i] > target) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		int numList[] = {20, 37, 17, 24, 53};
		
		int target = 22;
		
		Count c = new Count();
		
		int count = c.getCount(numList, target);
		
		System.out.println(count);
	}
}