package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class OptionalDemo {

	public static void main(String[] args) {

		List<Double> doubles = ThreadLocalRandom.current()
		.doubles(1_000)
		.parallel()
		.map(d->d*100)
		.boxed()
		.collect(Collectors.toList());

		List<Double> invSqrtOfDoubles = doubles.stream().parallel()
				.flatMap(NewMath.inverseSqrt).toList();

		doubles.stream().forEach(System.out::println);

		System.out.println("####################### after operation ##################");

		invSqrtOfDoubles.stream().forEach(System.out::println);

		// No Parallelism this!
//		List<Double> result = new ArrayList<>();
//		ThreadLocalRandom.current().doubles(10_000).boxed()
//				.forEach(
//						d -> NewMath.inverse(d)
//						.ifPresent(inv -> NewMath.sqrt(inv)
//								.ifPresent(sqrt -> result.add(sqrt))));
//		
//		System.out.println("# result = " + result.size());

	}

}
//build an Optional
//Optional.empty();
//Optional.of(new Person("",1,"")); null pointer exception if you pass null
//Optional.ofNullable(new Person("",1,""));