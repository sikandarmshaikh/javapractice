package java8.programming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Course {
	
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}
}

public class FP04CustomClass {

	public static void main(String[] args) {

		List<Course> courses = List.of(
									new Course("Spring","Framework",98,20000),
									new Course("Spring Boot","Framework",95,18000),
									new Course("API","Microservices",97,22000),
									new Course("Microservices","Microservices",96,25000),
									new Course("FullStack","FullStack",91,14000),
									new Course("AWS","Cloud",92,21000),
									new Course("Azure","Cloud",99,21000),
									new Course("Docker","Cloud",92,20000),
									new Course("Kubernetes","Cloud",91,20000)
				);

		//allMatch, noneMatch, anyMatch
		Predicate<? super Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
		
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
		
		Predicate<? super Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
		
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

		Comparator comparingNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
		//Sort the courses
		System.out.println(courses.stream().sorted(comparingNoOfStudentsIncreasing).collect(Collectors.toList()));
		//[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]
		Comparator comparingNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comparingNoOfStudentsDecreasing).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

		Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = 
				Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).limit(5).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]

		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).limit(5).collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]
		
		System.out.println(courses);

		System.out.println(courses.stream()
						.takeWhile(course -> course.getReviewScore() >= 95)
						.collect(Collectors.toList()));
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

		System.out.println(courses.stream()
				.dropWhile(course -> course.getReviewScore() >= 95)
				.collect(Collectors.toList()));
		//[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

		System.out.println(courses.stream()
				.max(comparingByNoOfStudentsAndNoOfReviews));
		//Optional[FullStack:14000:91]  - Returns the last element of the List

		System.out.println(courses.stream()
				.min(comparingByNoOfStudentsAndNoOfReviews)
				.orElse(new Course("Kubernetes","Cloud",91,20000))
				);
		//Optional[Microservices:25000:96] - Returns the first element of the List
		//Microservices:25000:96
		
		System.out.println(courses.stream()
				.filter(reviewScoreLessThan90Predicate)
				.min(comparingByNoOfStudentsAndNoOfReviews) //Optional.empty
				.orElse(new Course("Kubernetes","Cloud",91,20000))); //Kubernetes:20000:91
		
		
		//Find the first element which meets a certain criteria
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findFirst() //Optional.empty
				);
		//Optional[Spring:20000:98]

		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findAny() //Optional.empty
				);
		//Optional[Spring:20000:98]

		//In Courses having review score greater than 95 we need to find 
		//how many total number of students are enroleld in it and 
		//we want to find the average of that and find the count of such courses
		//Total Nor of Students who have review score >= 95
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.sum());	
		//88000
		
		System.out.println(courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.average());	
		//OptionalDouble[22000.0]

		// Group the Courses based on certain criteria
		//Group the courses based on the Category with Framework as the Key and its courses as its values
		//Similarly for Microservices as the Key and its courses as its values
		System.out.println(courses.stream()
			   .collect(Collectors.groupingBy(Course::getCategory)));
		//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}
		//Find out how many Cloud Courses are there or how many Framework Courses are there 
		// or how many FullStack courses are there, etc
		System.out.println(courses.stream()
				   .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}
		
		//Now within these Catagory of Courses, retun that course which has highest ReviewScore
		//For example In Cloud Catagory - Azure has highest reviewscore and in Microservices - API has highest, etc
		System.out.println(courses.stream()
				   .collect(Collectors.groupingBy(Course::getCategory, Collectors
				   .maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}
		
		// Map the Name of the Course, instead of mapping the entire Course to the specific List
		System.out.println(courses.stream()
				   .collect(Collectors.groupingBy(Course::getCategory, Collectors
				   .mapping(Course::getName, Collectors.toList()))));
		//{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
		
		//Create Streams directly
		System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 2, 15).count());;
		//9
		int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 2, 15};
		Arrays.stream(numberArray);
		Arrays.stream(numberArray).sum();
		Arrays.stream(numberArray).average();
		Arrays.stream(numberArray).min();
		Arrays.stream(numberArray).max();
		
		//Create a Stream with the first 100 numbers
		System.out.println(IntStream.range(1, 10).sum()); //45
		// In the above stmt only numbers from 1 to 9 are included and 10 is excluded
		// If we want to include 10 as well then we need to do rangeClosed
		System.out.println(IntStream.rangeClosed(1, 10).sum()); //55 
		//Create a Stream of numbers by providing some logic
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum());
		
		//Exercise to print first 10 even numbers using the peek and finally do the sum
		System.out.println(IntStream.iterate(2, e -> e+2).limit(10).peek(System.out::println).sum());
		//The above stmt prints all the even numbers from 1 to 20
		//Calculate the first 10 powers of 2
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum());
		//Now collect these list of numbers in a List using boxed operation
		List list = IntStream.iterate(2, e -> e*2).limit(10).boxed().collect(Collectors.toList());
		list.stream().forEach(System.out::println);
		
		//Bigint
		System.out.println(Integer.MAX_VALUE+" "+Long.MAX_VALUE);
		//Calculate 50 factorial - 50!
		System.out.println(LongStream.rangeClosed(1, 50)
				.mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply));
		
		//Simple operations using Strings
		//Combine all the courses separated by a Comma
		//Use FlatMap
		List<String> course1 = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		System.out.println(course1.stream().collect(Collectors.joining(",")));
		//Spring,Spring Boot,API,Microservices,AWS,PCF,Azure,Docker,Kubernetes
		
		//Print the characters in each of the Strings
		System.out.println("Spring".split(""));
		System.out.println(course1.stream().map(str -> str.split("")).collect(Collectors.toList()));
		// Output: [[Ljava.lang.String;@69663380, [Ljava.lang.String;@5b37e0d2, [Ljava.lang.String;@4459eb14, [Ljava.lang.String;@5a2e4553, [Ljava.lang.String;@28c97a5, [Ljava.lang.String;@6659c656, [Ljava.lang.String;@6d5380c2, [Ljava.lang.String;@45ff54e6, [Ljava.lang.String;@2328c243]
		//In above stmt we are not able to print the individual characters of each of the Course
		//This stmt is not printing the individual characters as each char in the String has become an individual String
		//Hence in order to resolve this we need to use Flatmap
		System.out.println(course1.stream().map(str -> str.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
		//Now above stmt is working
		//If we want to get distinct characters
		System.out.println(course1.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
		/**
		 * FlatMap : each element of Stream replaced with content of mapped Stream Mapping Function
		 * -> Arrays::stream 
		 * ["S","p","r","i","n","g"] => "S","p","r","i","n","g"
		 * ["A","W","S"] => "A","W","S"
		 */
		
		//Exercise: Identify pairs of Courses with same number of charecters
		List<String> courses2 = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		System.out.println("All the Courses with same number of characters ");
		System.out.println(course1.stream().flatMap(course -> courses2.stream()
				.map(course2 -> List.of(course, course2)))
				.collect(Collectors.toList()));
		//Above stmt is printing duplicates, so we need to remove duplicates from both the courses
		System.out.println(course1.stream().flatMap(course -> courses2.stream()
				.map(course2 -> List.of(course, course2)))
				.filter(list1 -> !list1.get(0).equals(list1.get(1)))
				.collect(Collectors.toList()));
		//[[Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], [Spring Boot, Spring], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], [API, Spring Boot], [API, Microservices], [API, AWS], [API, PCF], [API, Azure], [API, Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, AWS], [Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], [AWS, Spring], [AWS, Spring Boot], [AWS, API], [AWS, Microservices], [AWS, PCF], [AWS, Azure], [AWS, Docker], [AWS, Kubernetes], [PCF, Spring], [PCF, Spring Boot], [PCF, API], [PCF, Microservices], [PCF, AWS], [PCF, Azure], [PCF, Docker], [PCF, Kubernetes], [Azure, Spring], [Azure, Spring Boot], [Azure, API], [Azure, Microservices], [Azure, AWS], [Azure, PCF], [Azure, Docker], [Azure, Kubernetes], [Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker]]
		//Next Goal is to filter tuples with same length - [[Spring,Docker]],[[API,AWS]]
		//[API,PCF],[AWS,API],[PCF,API],[PCF,AWS],[Docker,Spring]]
		System.out.println(
				course1.stream()
				.flatMap(course -> courses2.stream()
				.filter(cours2 -> cours2.length()==course.length())
				.map(course2 -> List.of(course, course2)))
				.filter(list1 -> !list1.get(0).equals(list1.get(1)))
				.collect(Collectors.toList()));
		//[[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]

		//A Higher Order Function is a Function which returns a Function
		
		Predicate<? super Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore2(95);
		
		Predicate<? super Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore2(90);
		
		//Find the courses > 11 characters, Uppercase them and then find the first among them
		System.out.println(course1.stream()
				.filter(cours -> cours.length()>11)
				.map(String::toUpperCase)
				.findFirst());
		//Optional[MICROSERVICES]
		
		//If I want to change all the elements of a List
		course1.replaceAll(str -> str.toUpperCase());
		//The above stmt will not work as the List course1 is not mofyable, hence we will create a new List
		List<String> modifyableCourses = new ArrayList<>();
		modifyableCourses.addAll(course1);
		modifyableCourses.replaceAll(String::toUpperCase);
		modifyableCourses.removeIf(cours -> cours.length()>6);
		
	}

	private static Predicate<? super Course> createPredicateWithCutoffReviewScore2(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}

}
