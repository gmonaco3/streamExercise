package streamofnumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamOfNumbersDemo {

	public static void main(String[] args) throws IOException {

		Set<String> shakespeareWords = Files
				.lines(Paths
						.get("C:\\Users\\Giaco\\eclipse-workspace\\stream-exercise\\src\\text\\shakespearewords.txt"))
				.map(word -> word.toLowerCase()).collect(Collectors.toSet());

		Set<String> scrabbleWords = Files
				.lines(Paths.get("C:\\Users\\Giaco\\eclipse-workspace\\stream-exercise\\src\\text\\scrablewords.txt"))
				.map(word -> word.toLowerCase()).collect(Collectors.toSet());

		final int[] SCRABBLE_EN_SCORE = {
				// a b c d e f g h i j k l m n o p q r s t u v w x y z
				1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

		Function<String, Integer> score = word -> word.chars().map(letter -> SCRABBLE_EN_SCORE[letter - 'a']).sum();

		ToIntFunction<String> intScore = word -> word.chars().map(letter -> SCRABBLE_EN_SCORE[letter - 'a']).sum();

		System.out.println("Score of hello: " + intScore.applyAsInt("hello"));

		String bestWord = shakespeareWords.stream()
				.filter(word -> scrabbleWords.contains(word))
				.max(Comparator.comparing(score))
				.get();

		System.out.println("Best word: " + bestWord);
		
		IntSummaryStatistics summaryStatistics = shakespeareWords.stream()
		.parallel()
		.filter(scrabbleWords::contains)
		.mapToInt(intScore)
		.summaryStatistics();
		 
		System.out.println("stats: " + summaryStatistics);

	}

}

//		List<Person> people = Arrays.asList(new Person("",44,""),new Person("",18,""),new Person("",32,""));
//		
//		OptionalDouble average = people.stream()
//		.mapToInt(person -> person.getAge())
//		.average();
//		
//		System.out.println("the average is: " + average.getAsDouble());