package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final Function<String, String> first3CharsMapper = word -> word.length() >= 3 ? word.substring(0, 3)
			: word.substring(0, word.length());
	private static final Collector<String, ?, Map<String, List<String>>> clusteredIndexCollector = Collectors
			.groupingBy(first3CharsMapper);
	private static final BiConsumer<String, List<String>> clusteredIndexPrinter = (index,list) -> {
		System.out.println(index + ": " + list);
	};

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Group the dictionary words by their first three letters
		Map<String, List<String>> clusteredIndex = words.stream().collect(clusteredIndexCollector);
		clusteredIndex.forEach( clusteredIndexPrinter);
	}
}
