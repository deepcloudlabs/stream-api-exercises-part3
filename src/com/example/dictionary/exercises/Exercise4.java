package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	private static final Predicate<String> isPalindrome = word -> word.contains(new StringBuilder(word).reverse());

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the palindromes in the dictionary
		words.stream().filter(isPalindrome).forEach(System.err::println);
	}

}