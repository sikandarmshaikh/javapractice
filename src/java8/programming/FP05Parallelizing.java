package java8.programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {

	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		//0, 1000000000
		//System.out.println(LongStream.range(0, 1000000000).sum());
		//499999999500000000 //1424
		
		//Parallel method gives efficiency in utilizing the CPU Cores for faster processing
		System.out.println(LongStream.range(0, 1000000000)
				.parallel()
				.sum());
		//499999999500000000 //141
		
		System.out.println(System.currentTimeMillis()-time);
		//1424
	}

}
