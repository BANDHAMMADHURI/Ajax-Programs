package com.full.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class AjaxDemoServlet extends HttpServlet {
	PrintWriter out;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/application/json/html");
		//resp.sendRedirect("register.html");
		out = resp.getWriter();
		out.println("Registered Successfully<br>");
		out.println("Your details are<br>");
		try {
			JSONObject jsonObject = new JSONObject(req.getParameter("stringParameter"));
			Iterator<?> iterator = jsonObject.keys(); // gets all the keys

			while (iterator.hasNext()) {
				String key = (String) iterator.next(); // get key
				Object value = jsonObject.get(key); // get value
				out.println(key + " : " + value + "<br>");

			}
		} catch (JSONException e) {
			out.println("Internal Server error");
			//e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.sendRedirect("register.html");
	}
}
