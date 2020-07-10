/**
 * 
 */
package com.demo.anograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Find anograms in a string using recursion and hash table
 * @author marklapointe
 *
 */
public class Main {

	String[] test_data = new String[] { "a","ab", "abc","abcd" };


	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public void run_test() {
		for (String data: this.test_data) {
			this.solution(data);
		}
	}


	public void solution (String data) {
		
		// Prep the data
		Set<String> anagrams = new HashSet<String>();
		List<String> chars = new ArrayList<String>();
		for( char a: data.toCharArray()) {
			chars.add(String.valueOf(a));
		}
		
		for (int c = 0; c < chars.size(); c++) {
			List<String> remainingChars = new ArrayList<String>();
			remainingChars.addAll(chars);
			remainingChars.remove(chars.get(c));
			this.build_anagrams(anagrams, chars.get(c), remainingChars);
		}

		System.out.println(anagrams);
	}

	public void build_anagrams (Set<String> anagrams, String firstLetters, List<String> remainingLeters ) {
		if (remainingLeters.size() > 0 ) {
			for (int i = 0; i < remainingLeters.size(); i++ ) {
				String r = remainingLeters.get(i);
				String newFirstLetters = firstLetters + r;
				List<String> newReaminingLetters = new ArrayList<String>();
				newReaminingLetters.addAll(remainingLeters);
				newReaminingLetters.remove(r);
				this.build_anagrams(anagrams, newFirstLetters, newReaminingLetters);
			}
		} else {
			anagrams.add(firstLetters);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start");
		Main m = new Main();
		m.run_test();
		System.out.println("End");
	}

}
