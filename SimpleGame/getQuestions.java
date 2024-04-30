package com.jdbc.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class getQuestions {
		
		public static int getRandomQuestion(String[][] questionList) throws Exception { 
	        Random random = new Random();
	        int randNum = random.nextInt(questionList.length);
	        return randNum;
	    }
		
		public static String[][] questionList() throws Exception {
			File file = new File("Questions.txt");
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String[][] questions = new String[28][6]; //change the first number to amount of questions
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				for (int i = 0; i < questions.length; i++) { //change the amount of questions that will be put into the possible questions and creates random order
					
					String string = reader.readLine(); 
					
					String[] arrString = string.split(",", 0);
					
					int num = getRandomQuestion(questions);
					
					while(getFlag(list, num)) {
						num = getRandomQuestion(questions);
					}
					
					int j = 0;
					
						for (String a : arrString) {
							questions[num][j] = a;
							j++;
						}
						
					list.add(num);
				}
				return questions;
			}
		}
		
		public static boolean getFlag(ArrayList<Integer> list, int num) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) == num) {
					return true;
				}
			}
			return false;
		}
	}
