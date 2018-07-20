package controller.products;

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
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Product;

@SuppressWarnings("serial")
public class ProductControllerDelete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();

		if(request.getParameter("action").equals("deleting")){
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(Product.class.getSimpleName(), new Long(request.getParameter("productId")).longValue());
			Product a = pm.getObjectById(Product.class, k);
			pm.deletePersistent(a);
			pm.close();
			response.sendRedirect("/products");
		}
		else{
			System.out.println("Error");

		}

	}
}