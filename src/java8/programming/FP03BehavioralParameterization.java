package java8.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

/**
 * 
 * @author sikandarshaikh
 * 
 *
 */
public class FP03BehavioralParameterization {
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 2, 15);
		
		Predicate<? super Integer> evenPredicate = x -> x%2==0;
		
		numbers.stream()
		.filter(evenPredicate)
		.forEach(System.out::println);
		
		Predicate<? super Integer> oddPredicate = x -> x%2!=0;
		
		numbers.stream()
				.filter(oddPredicate)
				.forEach(System.out::println);
	}
	
}
