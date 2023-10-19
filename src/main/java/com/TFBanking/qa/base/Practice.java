package com.TFBanking.qa.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Practice {

	public static void main(String[] args) {

		Scanner ui = new Scanner(System.in);

		System.out.println("Give me a string: ");

		String palindrome = ui.next();

		String reverseWord = "";

		for (int i = palindrome.length() - 1; i >= 0; i--) {

			reverseWord = reverseWord + palindrome.charAt(i);

		}

		if (reverseWord.equalsIgnoreCase(palindrome)) {
			System.out.println(palindrome + " is  a Palindrome!");
		} else {
			System.out.println(palindrome + " is not a Palindrome!");
		}
	}

	// @Test
	public void myStream() {

		List<String> myList = new ArrayList<>();

		myList.add("Kasra");
		myList.add("Atena");
		myList.add("Reera");
		myList.add("Vania");
		myList.add("Kimia");
		myList.add("Kabir");

		boolean flag = myList.stream().anyMatch(s -> s.contains("K"));
		Assert.assertTrue(flag);
	}

	// @Test
	public void streamCollect() {

		List<String> ls = Stream.of("Kasra", "Atenam", "Reera", "Vania").filter(s -> s.endsWith("m"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());

		System.out.println(ls.get(0));

		List<Integer> myNumbers = Arrays.asList(3, 4, 8, 8, 4, 10, 5, 0, 3, 4, 12);

		myNumbers.stream().distinct().forEach(s -> System.out.println(s));

	}

	List<Integer> myNumbers = Arrays.asList(3, 4, 8, 8, 4, 10, 5, 0, 3, 4, 12);

	public void getData() {
		
		Object [][] data = {{
		
		
	}


		} 
