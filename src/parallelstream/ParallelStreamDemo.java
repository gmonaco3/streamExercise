package parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamDemo {
	
	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<>();
		
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		
//		Stream.iterate("+", s -> s + "+")
//		.parallel() problem occurs: exception or size != 1000 in strings
//		.limit(1000)
//		.peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
//		.forEach(string -> strings.add(string));
		
		strings = Stream.iterate("+", s -> s + "+")
		.parallel() 
		.limit(1000)
		.collect(Collectors.toList());
		
		System.out.println(strings);
		
		
		 

	}
}
