package java8.programming;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		//int sum = addListFunctional(numbers);
		//System.out.println(sum);
		
		printSumOfSquaresOfAllNumbersInList(numbers);
		printSumOfCubesOfAllNumbersInList(numbers);
		printSumOfOddNumbersInList(numbers);
		printSumOfEvenNumbersInList(numbers);
		printDistinctNumbersInList(numbers);
		printDisinctSortedNumbersInList(numbers);
		printAllCoursesAsSorted(courses);
		
	}
	
	private static void printAllCoursesAsSorted(List<String> courses) {
		System.out.println("Sorted Courses are ::");
		courses.stream().sorted().forEach(System.out::println);
	}

	private static void printDisinctSortedNumbersInList(List<Integer> numbers) {
		System.out.println("Sorted NUmbers are ::");
		numbers.stream().distinct().forEach(System.out::println);
	}

	private static void printDistinctNumbersInList(List<Integer> numbers) {
		System.out.println("Distinct NUmbers are ::");
		numbers.stream().distinct().forEach(System.out::println);		
	}

	private static void printSumOfEvenNumbersInList(List<Integer> numbers) {
		System.out.println("Sum Of Even NUmbers are ::");
		System.out.println(numbers.stream().filter(x -> x%2==0).reduce(0, Integer::sum));
	}

	private static void printSumOfOddNumbersInList(List<Integer> numbers) {
		System.out.println("Sum Of Odd NUmbers are ::");
		System.out.println(numbers.stream().filter(x -> x%2!=0).reduce(0, Integer::sum));
	}

	private static void printSumOfCubesOfAllNumbersInList(List<Integer> numbers) {
		System.out.println("Sum Of Cubes of NUmbers are ::");
		System.out.println(numbers.stream().map(x -> x*x*x).reduce(0, Integer::sum));
	}

	private static void printSumOfSquaresOfAllNumbersInList(List<Integer> numbers) {
		System.out.println("Sum Of Squares NUmbers are ::");
		System.out.println(numbers.stream().map(x -> x*x).reduce(0, Integer::sum));
	}

	//Understanding reduce method
	private static int sum1(int aggregate, int nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate + nextNumber;
	}

	private static int addListFunctional(List<Integer> numbers) {
		
		return numbers.stream()
		//Combine all of them into one result =>value
		// 0 and (a,b) -> a+b
				//.reduce(0,FP02Functional::sum);
				//.reduce(0, (x, y) -> (x + y));
				.reduce(0, Integer::sum);
	}
	

}