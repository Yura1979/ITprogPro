package com.gmail.tyi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VotingServlet
 */

@WebServlet("/VotingServlet")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Questionnaire questionare = new Questionnaire();
	
	static {
		questionare.addQuestion("Do you like programming?");
		questionare.addQuestion("Do you like Java?");
		questionare.addQuestion("Do you like C#?");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.setAttribute("data", questionare);
		RequestDispatcher rd = request.getRequestDispatcher("vote.jsp");
		rd.forward(request, response);
			
		
//		response.sendRedirect("vote.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		for (int i = 1; i <= questionare.getQuestionIdNum(); i++) {
			String answer = request.getParameter(Integer.toString(i));
			if (answer.equals("Yes")) {
				questionare.voteYes(i);
			} else {
				questionare.voteNo(i);
			}
		}
		
		request.setAttribute("data", questionare);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
//		response.sendRedirect("result.jsp");
	}

}
