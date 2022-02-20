package java8.programming;

import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		int sum = addListStructured(numbers);
		System.out.println(sum);
		
	}

	private static int addListStructured(List<Integer> numbers) {
		//how to loop
		//how to Sum
		int sum = 0;
		for(int number: numbers) {
			sum+=number;
		}
		return sum;
	}
	

}