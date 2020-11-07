
package com.gmail.tyi;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Questionnaire implements Serializable {
	private Map<Integer, String> questions;
	private Map<Integer, AtomicInteger[]> answers;
	private int questionIdNum = 0;
	
	
	
	public Questionnaire() {
		questions = new HashMap<>();
		answers = new HashMap<>();
	}

	public String getQuestionByID(int questionId) {
		return questions.get(questionId);
	}

	public void addQuestion(String question) {
		questions.put(++questionIdNum, question);
		answers.put(questionIdNum, new AtomicInteger[] {new AtomicInteger(0), new AtomicInteger(0)});
	}
	
	private void updateAnswerCount(int questionId, int position) {
		AtomicInteger[] tmp = answers.get(questionId);
		tmp[position] = new AtomicInteger(answers.get(questionId)[position].get() + 1);
		answers.replace(questionId, tmp); 
	}
	
	public int getYesUnswers(int questionId) {
		return answers.get(questionId)[1].get();
	}
	
	public int getNoUnswers(int questionId) {
		return answers.get(questionId)[0].get();
	}
	
	public void voteYes(int questionId) {
		updateAnswerCount(questionId, 1);
	}
	
	public void voteNo(int questionId) {
		updateAnswerCount(questionId, 0);
	}



	public Map<Integer, String> getQuestions() {
		return questions;
	}



	public Map<Integer, AtomicInteger[]> getAnswers() {
		return answers;
	}

	public int getQuestionIdNum() {
		return questionIdNum;
	}



	@Override
	public String toString() {
		return "Questionnaire [questions=" + questions + ", answers=" + answers + ", questionIdNum=" + questionIdNum
				+ "]";
	}



	
	
	
	

}
