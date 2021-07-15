package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<Long> list = new ArrayList<>(10_000_000);
		for (Long num : list) {
			list.add(ThreadLocalRandom.current().nextLong());
		}
		
		//the most slow
		List<Long> list2 = Stream.generate(() -> ThreadLocalRandom.current().nextLong())
				.limit(10_000_000)
				.toList();
		
		
		//the most efficent
		List<Long> list3 = ThreadLocalRandom.current().longs(10_000_000)
				.mapToObj(Long::new)
				.toList();

	}

}
