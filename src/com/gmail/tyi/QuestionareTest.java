package com.gmail.tyi;

import java.util.Arrays;

public class QuestionareTest {

	public static void main(String[] args) {
		Questionnaire questionare = new Questionnaire();
		questionare.addQuestion("Do you like programming?");
		questionare.addQuestion("Do you like Java?");
		questionare.addQuestion("Do you like C#?");
		System.out.println(questionare);
		questionare.voteYes(1);
		questionare.voteYes(2);
		questionare.voteYes(1);
		questionare.voteNo(3);
		
//		System.out.println(questionare.getYesUnswers(1));
//		System.out.println(questionare.getYesUnswers(2));
//		System.out.println(questionare.getYesUnswers(3));
		for (int i = 1; i <= questionare.getQuestionIdNum(); i++) {
			System.out.println(i + " " + questionare.getQuestionByID(i));
		}

	}

}
