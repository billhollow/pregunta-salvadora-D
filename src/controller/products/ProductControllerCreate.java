package controller.products;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Product 	;

public class ProductControllerCreate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			dp.forward(request, response);
		}
		else{
			String userId = uGoogle.getUserId();
			if(request.getParameter("action").equals("creating")){
				// create the persistence manager instance
				PersistenceManager pm = PMF.get().getPersistenceManager();
				// query for the entities by name
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/products/productCreate.jsp");
				dispatcher.forward(request, response);
			}
			else{
				// create the persistence manager instance
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Product a = new Product(request.getParameter("name"), Double.parseDouble(request.getParameter("precio")), userId);
				try { 
					pm.makePersistent(a);
				} finally {
					pm.close();
				}
				response.sendRedirect("/products");
			}
		}
	}
}