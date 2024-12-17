package com.learn.stringProblems;

import java.util.Stack;

//Given String : "..geeks..for.geeks."
//output string : "geeks.for.geeks"

//Use stack to push the words and the pop the words
//because words are separated by .dot . when dot is encountered add the word formed using stringBuilder to stack, otherwise form the word
//Also after reaching end of the string , pop the words, also add dot inbetween the words

public class ReverseWordsInString {

	public static void main(String[] args) {

		String str = "..geeks..for.geeks.";
		System.out.println("Reversed String is " + reverseWords(str));
	}

	private static String reverseWords(String str) {

		StringBuilder result = new StringBuilder();
		Stack<String> stack = new Stack<>();
		StringBuilder word = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '.') {
				word.append(str.charAt(i));
			} else if (word.length() > 0) {
				stack.push(word.toString());
				word.setLength(0);
			}
		}

		// last word
		if (word.length() != 0) {
			stack.push(word.toString());
		}

		// Getting from stack
		while (!stack.empty()) {
			result.append(stack.pop());
			if (!stack.empty()) {
				result.append(".");
			}
		}

		return result.toString();
	}

}
