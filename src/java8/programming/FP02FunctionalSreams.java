package java8.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02FunctionalSreams {

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
		printAllCoursesAsSortedInReverseOrder(courses);
		printAllCoursesAsSortedInLengthrder(courses);
		printNumbersInReverseSortedOrder(numbers);
		//Double(Square) All the Numbers and print them
		printSquaresOfNumbersInList(numbers);
		printListOfEvenNumbersFromAList(numbers);
		// Create a list with length of all Course titles
		printListOfCoursesWithAllCourseTitles(courses);
		
	}
	
	private static void printListOfCoursesWithAllCourseTitles(List<String> courses) {
		List<Integer> coursesWithTitles = courses.stream().map(x -> x.length())
				.collect(Collectors.toList());
		System.out.println("Length of All the Courses are ::");
		System.out.println(coursesWithTitles);
	}

	private static void printListOfEvenNumbersFromAList(List<Integer> numbers) {
		List<Integer> EvenNumbersList = numbers.stream().filter(x -> x%2==0)
				.collect(Collectors.toList());
		System.out.println("Even Numbers are ::");
		System.out.println(EvenNumbersList);
	}

	//Double the numbers in a List and print them
	private static void printSquaresOfNumbersInList(List<Integer> numbers) {
		List<Integer> doubleList = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.println("Doubled Numbers are ::");
		System.out.println(doubleList);
	}

	private static void printNumbersInReverseSortedOrder(List<Integer> numbers) {
		System.out.println("NUmbers in Reveer Sorted Order are ::");
		numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	private static void printAllCoursesAsSortedInLengthrder(List<String> courses) {
		System.out.println("Courses Sorted As Per their Length are ::");
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

	private static void printAllCoursesAsSortedInReverseOrder(List<String> courses) {
		System.out.println("Courses Sorted in Reverse Order are ::");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	private static void printAllCoursesAsSorted(List<String> courses) {
		System.out.println("Sorted Courses are ::");
		courses.stream().sorted().forEach(System.out::println);
		// A Comparator can also be used, but natural Order prints the same Sorted Order
		//courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
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