package java8.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author sikandarshaikh
 * 
 *
 */
public class FP03BehavioralParameterization {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 2, 15);
		
		//filterAndPrint(numbers, x -> x%2==0);
		
		//filterAndPrint(numbers, x -> x%2!=0);
		
		filterAndPrint(numbers, x -> x%3==0);
		
		List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x->x*x);
		
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x->x*x*x);
		
		List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x->x+x);
		
		System.out.println(doubledNumbers);
		
		
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
					  .map(mappingFunction)
					  .collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}
	
}
