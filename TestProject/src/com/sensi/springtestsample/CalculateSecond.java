package com.sensi.springtestsample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalculateSecond {
	public static void main(String[] args) {

		String actualSeconds, inputSeconds;
		
		try {
			Scanner requestingInput = new Scanner(System.in);
			do{
				System.out.print("Enter Input seconds: " + "\n");
				inputSeconds = requestingInput.nextLine();
				  
				if(inputSeconds.isEmpty()) {
					System.out.print("Input seconds is empty"+ "\n");
				} else if(Integer.valueOf(inputSeconds) <= -1) {
					System.out.println("Input seconds will not accept negative integer");
				} else if(!inputSeconds.matches("[0-9]+")) {
					System.out.println("Input seconds will accept only integer");
				} else if(inputSeconds.length() > 2){
					System.out.print("Input seconds should not contain more than two integer"+ "\n");
				} else if(Integer.valueOf(inputSeconds) > 59){
					System.out.print("It exceeds the seconds");
				} else {
					while(true) {
						DateFormat df = new SimpleDateFormat("ss");
						Calendar calobj = Calendar.getInstance();
						actualSeconds = df.format(calobj.getTime());
					   
						if(Integer.valueOf(actualSeconds) == Integer.valueOf(inputSeconds)) {
							System.out.println("Its time now");
							break;
					    } else {
					    	System.out.println("Please wait");
					    }
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			  } while(inputSeconds.isEmpty() || !inputSeconds.matches("[0-9]+") || inputSeconds.length() > 2);
			
			requestingInput.close();
		} catch(Exception e) {
	        System.out.println("Input seconds is Invalid");
	    }
		}
}
