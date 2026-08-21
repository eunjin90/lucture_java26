package day02;

public class Max {

	int getMax(int[] numList) {
		
        int max = numList[0];
        
        for (int i = 1; i < numList.length; i++) {
        	
            if (numList[i] > max) {
                max = numList[i];
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		
		int numList[] = {20, 37, 17, 24, 53};
		
		Max m = new Max();
		
		int max = m.getMax(numList);
		
		System.out.println(max);

	}
	
	
}
