package java8.programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		//printAllNumbersInListFuntional(numbers);
		//printEvenNumbersInListFuntional(numbers);
		//printOddNuberInListFunctional(numbers);
		//printAllCoursesIndivudually(courses);
		//printCoursesContainingWordSpring(courses);
		printCoursesContainingAtleast4Letters(courses);
	}
	
	private static void printCoursesContainingAtleast4Letters(List<String> courses) {
		courses.stream().filter(course->course.length()>=4).forEach(System.out::println);
	}

	private static void printCoursesContainingWordSpring(List<String> courses) {
		courses.stream().filter(course->course.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllCoursesIndivudually(List<String> courses) {
		courses.forEach(System.out::println);
	}

	private static void printOddNuberInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number->number%2!=0)
		.forEach(System.out::println);
	}

	private static boolean isEven(int number) {
		return number%2==0;
	}

	private static void printAllNumbersInListFuntional(List<Integer> numbers) {
		
		//print even numbers in the list
//		for(int number: numbers) {
//			if(number%2==0) {
//				System.out.println(number);
//			}
//		}
		numbers.stream()
				.forEach(System.out::println);
	}
	
	private static void printEvenNumbersInListFuntional(List<Integer> numbers) {
			
			//print even numbers in the list
//			for(int number: numbers) {
//				if(number%2==0) {
//					System.out.println(number);
//				}
//			}
			numbers.stream()
					//.filter(FP01Functional::isEven)
					.filter(number->number%2==0) // .filter(number->number%2==1)
					.forEach(System.out::println);
			
		}

}