package fruit;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		Map<Fruit, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put(new Fruit("사과", 1000), 10);
		fruitMap.put(new Fruit("사과", 5000), 5);
		
		System.out.println(fruitMap.size());
		
		
	}
	
	
}
