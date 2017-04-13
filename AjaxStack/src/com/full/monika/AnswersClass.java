package com.full.monika;

public class AnswersClass {
	int id;
	String answer;
	int rankCount;

	AnswersClass(String answer,int id) {
		this.id = id;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getRankCount() {
		return rankCount;
	}

	public void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}
	public String toString()
	{
		return (String)answer;
	}

	public Object split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
