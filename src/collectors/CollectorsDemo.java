package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import model.Person;

public class CollectorsDemo {
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(new Person("jack",22,""),new Person("hanna",29,""),new Person("jack",22,""));
		
		Optional<Person> oldest = people.stream()
				.collect(Collectors.maxBy(Comparator.comparing(person -> person.getAge())));
		
		double average = people.stream()
				.collect(Collectors.averagingDouble(person -> person.getAge()));
		
		String names = people.stream()
				.map(p->p.getName())
				.collect(Collectors.joining(", "));
		
		TreeSet<String> namesSet = people.stream()
				.map(p->p.getName())
				.collect(Collectors.toCollection(() -> new TreeSet()));
		
		System.out.println(oldest);
		System.out.println("the average is: " + average );
		System.out.println("the nemes are: " + names);
		System.out.println(namesSet);
		
		Map<Boolean, List<Person>> pepleByAge = people.stream()
				.collect(Collectors.partitioningBy(person -> person.getAge() > 22));
		
		System.out.println(pepleByAge);
		
		Map<Integer, List<Person>> peopleByAge = people.stream()
				.collect(Collectors.groupingBy(person -> person.getAge()));

		System.out.println(peopleByAge);
		
		Map<Integer, Long> peopleByAge2 = people.stream()
				.collect(Collectors.groupingBy(person -> person.getAge(),
						Collectors.counting()
						));

		System.out.println(peopleByAge2);
		
//		Map<Integer, List<String>> namesByAge2 = people.stream()
//				.collect(
//						Collectors.groupingBy(person -> person.getAge()),
//						Collectors.mapping(
//								 person -> person.getName())
//						);

		System.out.println(peopleByAge2);

		
		
	}

}
