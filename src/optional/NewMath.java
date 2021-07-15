package optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class NewMath {
	
	static Function<Double,Stream<Double>> inverseSqrt = 
			d -> NewMath.inverse(d)  	//Optional<Double>
			.flatMap(NewMath::sqrt)  	//Optional<Double>
			.map(Stream::of)         	//Optional<Stream<Double>>
			.orElseGet(Stream::empty);	//Stream<Double>
	
	public static Optional<Double> sqrt(Double d){
		return d > 0d ? Optional.of(Math.sqrt(d)) : Optional.empty();
	}
	public static Optional<Double> inverse(Double d){
		return d != 0d ? Optional.of(Math.sqrt(1/d)) : Optional.empty();
	}

}
