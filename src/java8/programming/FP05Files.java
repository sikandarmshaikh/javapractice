package java8.programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get("C://Users//h104239//git//javapractice//src//java8//programming//file.txt"))
			 .forEach(System.out::println);
		
		//Exercise - Print the Unique words in a File
		System.out.println("Print Unique words from the stream");
		Files.lines(Paths.get("C://Users//h104239//git//javapractice//src//java8//programming//file.txt"))
		 .map(str -> str.split(" "))
		 .flatMap(Arrays::stream)
		 .distinct()
		 .sorted()
		 .forEach(System.out::println);
		
		//Files.lines(Paths.get("."))
			//			 .filter(Files::isDirectory)
				//		 .forEach(System.out::println);
		
	}

}
