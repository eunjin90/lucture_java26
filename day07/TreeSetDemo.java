package day07;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set<String> f = Set.of("포도", "수박", "사과", "키위", "망고");
		
		TreeSet<String> fruits = new TreeSet<String>(f);
		
		System.out.println(fruits.first());
		System.out.println(fruits.last());
		
		System.out.println(fruits.lower("사과"));
		System.out.println(fruits.higher("사과"));
	}

}
