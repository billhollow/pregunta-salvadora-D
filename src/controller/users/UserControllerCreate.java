package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.User;

public class UserControllerCreate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameter("action").equals("creating")){
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();
			// query for the entities by name
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/users/userCreate.jsp");
			dispatcher.forward(request, response);
		}
		else{
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();
			User a = new User(request.getParameter("organizacion"), request.getParameter("email"));
			try { 
				pm.makePersistent(a);
			} finally {
				pm.close();
			}
			response.sendRedirect("/users");
		}
	}
}
