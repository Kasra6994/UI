package com.TFBanking.qa.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

import com.TFBanking.qa.util.ExcelReader;

public class Practice  {

	public static void main(String[] args) {

			newDepositTestData();
		
	
	}
	public static Object [][] newDepositTestData(){
		ExcelReader xl = new ExcelReader("src/main/java/com/TFBanking/qa/testdata/testData.xlsx"); 
		Object data[][] = xl.getExcelData("NewDepositData");
		System.out.println(data);
		return data;
		
	}
	
	
	
		public String calendar5daysAfter(int days) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, days);

        // Extract the day number as an integer
        int dayNumber = calendar.get(Calendar.DAY_OF_MONTH);

        // Convert the day number to a string
        String dayNumberStr = String.valueOf(dayNumber);

        // Print or use the day number string as needed
        System.out.println(dayNumberStr);
        
        return dayNumberStr;
	
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

}