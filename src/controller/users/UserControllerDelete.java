package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.User;

@SuppressWarnings("serial")
public class UserControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameter("action").equals("deleting")){
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(User.class.getSimpleName(), new Long(request.getParameter("userId")).longValue());
			User a = pm.getObjectById(User.class, k);
			pm.deletePersistent(a);
			pm.close();
			response.sendRedirect("/users");
		}
		else{
			System.out.println("Error");
		}
	}
}
