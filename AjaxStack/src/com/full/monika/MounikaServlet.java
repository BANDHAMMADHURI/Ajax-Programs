package com.full.monika;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.google.appengine.repackaged.org.codehaus.jackson.node.NodeCursor.Array;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


public class MounikaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id = "0";
	int id1=0;
   String questionID="question";
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("plain/application/json/html");
		
		PrintWriter out = response.getWriter();

		QuestionsAnswersMain.map = new HashMap<String, QuestionsClass>();
		//Iterator<?> iterator;
		try {

			//JSONArray jsonArray = new JSONArray(request.getParameter("string"));
			//JSONArray jsonArray = new JSONArray(request.getParameter("jsonData"));
			JSONArray jsonArray = new JSONArray(request.getParameter("string"));
			for (int i = 0; i < jsonArray.length(); i++) {
				
				JSONObject jsonObject = new JSONObject();
				jsonObject = (JSONObject) jsonArray.get(i);
				//System.out.println(" Question and Answer[array Element] ::   " + jsonObject);
				
				//iterator = jsonObject.keys();
				//while (iterator.hasNext()) {
				String questionID="question";
					id1 = id1 + 1;
					questionID=questionID+id1;
					String question =jsonObject.getString("Given Question"); 
					//System.out.println(question);
					out.println(question);
					//String answer = jsonObject.get(question).toString();
					String answer=jsonObject.getString("Given Answers");
					//System.out.println(answer);
					out.println(answer);
					AnswersClass answers = new AnswersClass(answer, id1);

					QuestionsClass questionObject = new QuestionsClass();

					questionObject.answerList = new ArrayList<AnswersClass>();
					questionObject.answerList.add(answers);

					QuestionsClass questions = new QuestionsClass(question, questionObject.answerList);

					QuestionsAnswersMain.map = new HashMap<String, QuestionsClass>();
					QuestionsAnswersMain.map.put(questionID, questions);

					QuestionsAnswersMain.questionList.add(QuestionsAnswersMain.map);

					if (question != "" && answer != "") {

						out.println("Questions List : " + QuestionsAnswersMain.questionList);

					}

					//System.out.println("Questions List : " + QuestionsAnswersMain.questionList);

				}
			//}
		} catch (JSONException e) {

			e.printStackTrace();
		}
	}
}
