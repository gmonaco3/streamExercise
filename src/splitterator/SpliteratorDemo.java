package splitterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import model.Person;

public class SpliteratorDemo {

	public static void main(String[] args) {

		Path path = Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/persons.txt");

		try (Stream<String> lines = Files.lines(path)) {

			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);
			
			Stream<Person> people = StreamSupport.stream(personSpliterator, false);
			people.forEach(System.out::println);
			
		} catch (IOException e) {

		}
		;
	}

}
