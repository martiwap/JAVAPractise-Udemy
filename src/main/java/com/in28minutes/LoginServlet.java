package com.in28minutes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	 /**
	 * This has been added due to the extension
	 */
	private static final long serialVersionUID = 1L;
	
	private UserValidationService validationService = new UserValidationService();

	// get action => login.do(GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		//	These where for the example used before the form 
		//		request.setAttribute("name", request.getParameter("name"));
		//		request.setAttribute("password", request.getParameter("password"));
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,  response);
	 }
	
	// post action => login.do(POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean isUserValid = validationService.isUserValid(name, password);
		
		if (isUserValid)
		{
			request.setAttribute("givenName", name);			
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,  response);
		}
		else
		{
			request.setAttribute("errorMessage", "Username or Password not valid.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,  response);
		}		
	 }	  
	  
}
 