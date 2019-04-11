package com.DemoGuru.prac;

import org.apache.commons.lang.RandomStringUtils;

public class RandomString {

	public static void main(String[] args) {
		
		for (int i = 1 ; i<9 ;i++)
		{
			String random = RandomStringUtils.randomAlphabetic(5); // gives a string containing 5 letters picked randomly
			System.out.println(random);
		}
		
		
	}
}
