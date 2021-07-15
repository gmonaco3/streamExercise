package stream.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapDemo {

	public static void main(String[] args) throws IOException {

		
		
		Stream<String> cap1 = Files.lines(Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/tomsawyer/cap1.txt"));
		Stream<String> cap2 = Files.lines(Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/tomsawyer/cap2.txt"));
		Stream<String> cap3 = Files.lines(Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/tomsawyer/cap3.txt"));
		Stream<String> cap4 = Files.lines(Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/tomsawyer/cap4.txt"));
		Stream<String> otherCaps = Files.lines(Paths.get("C:/Users/Giaco/eclipse-workspace/stream-exercise/src/text/tomsawyer/other-caps.txt"));

		Stream<Stream<String>> streamOfStreams = Stream.of(cap1,cap2,cap3,cap4,otherCaps);
		
		Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());
		
		//takes a line and return a stream of words
		Function<String,Stream<String>> lineSplitter = line -> Pattern.compile(" ").splitAsStream(line);
		
		Stream<String> streamOfWords = streamOfLines.flatMap(lineSplitter);
		
//		System.out.println("# words: " + streamOfWords.count());
		
		Long numberOfWords = streamOfWords.map(word -> word.toLowerCase()).distinct().count();
		
		System.out.println("# words: " + numberOfWords);
	
	}

}
