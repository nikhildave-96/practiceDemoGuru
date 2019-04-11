package com.DemoGuru.prac;

import org.apache.commons.lang.RandomStringUtils;

public class RandomNum {

	public static void main(String[] args) {
		
		for (int i = 1;i<5;i++)
		{
			String ran = RandomStringUtils.randomNumeric(6);		// gives a string containing 6 numbers picked randomly
			System.out.println(ran);
		}
		
		System.out.println();
		
		for (int j = 1;j<8;j++)
		{
			String ran1 = RandomStringUtils.randomAlphanumeric(3);	// gives a string containing 6 letters/numbers picked randomly	
			System.out.println(ran1);
		}
	}

}
