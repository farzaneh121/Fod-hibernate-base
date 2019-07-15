package main.java.service.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.model.Person;
import main.java.model.exceptions.ProcessException;
import main.java.service.dao.PersonDAO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDAO personDAO = new PersonDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionMode = request.getParameter("action-mode");
		if (actionMode == null || actionMode.trim().equals("")) {
			throw new ProcessException("your action is not recognize");
		} else {
			if (actionMode.equals("save")) {
				registerUser(request, response);
			}
			if (actionMode.equals("login")) {
				loginUser(request, response);
			}
			if (actionMode.equals("signOut")) {
				signOutUser(request, response);
			}
		}
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String emailAddress = request.getParameter("email-address");
		String userName = request.getParameter("user-name");
		Person person = new Person(firstName, lastName, emailAddress, userName, "CUST");
		try {
			personDAO.insertNewUser(person);
		} catch (Exception e) {
			throw new ProcessException("an error occurred in save user", e);
		}
		request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);

	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user-name");
		String emailAddress = request.getParameter("email-address");
		Person person = personDAO.findUser(userName, emailAddress);
		request.setAttribute("member", person);
		HttpSession userSession = request.getSession(true);
		userSession.setAttribute("user", person);
		request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);

	}

	private void signOutUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			request.getSession().removeAttribute("user");
		}
		request.getRequestDispatcher("/jsps/home.jsp").forward(request, response);

	}

}
