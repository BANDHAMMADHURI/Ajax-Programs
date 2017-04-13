package com.full.monika;

import java.util.ArrayList;

public class QuestionsClass {
	String id;
	String question;
	 ArrayList<AnswersClass> answerList;/* = new ArrayList<AnswersClass>();*/
	QuestionsClass(String question,ArrayList<AnswersClass> list) {
		this.question = question;
		this.answerList = list;
	}

	public QuestionsClass() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<AnswersClass> getList() {
		return answerList;
	}

	/*public void setList(ArrayList<AnswersClass> list) {
		this.list = list;
	}*/
	public String toString()
	{
		return (" Question Given: "+question+"- Given Answers "+answerList);
	}

	

}
