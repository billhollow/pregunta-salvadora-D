package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.User;

@SuppressWarnings("serial")
public class UserControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameter("action").equals("updating")){
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("userId")).longValue());
			User a = pm.getObjectById(User.class, k);
			request.setAttribute("user", a);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/users/userUpdate.jsp");
			pm.close();
			dispatcher.forward(request, response);

		}
		else{
			User aux;
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("userId")).longValue());
			User a = pm.getObjectById(User.class, k);

			aux = a;
			aux.setName((request.getParameter("organizacion")));

			pm.close();
			response.sendRedirect("/users");
		}
	}
}
