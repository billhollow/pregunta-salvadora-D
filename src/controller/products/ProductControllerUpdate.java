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

import controller.PMF;
import model.entity.Product;

@SuppressWarnings("serial")
public class ProductControllerUpdate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameter("action").equals("updating")){
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(Product.class.getSimpleName(), new Long(request.getParameter("productId")).longValue());
			Product a = pm.getObjectById(Product.class, k);
			request.setAttribute("product", a);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/products/productUpdate.jsp");
			pm.close();
			dispatcher.forward(request, response);

		}
		else{
			Product aux;
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Key k = KeyFactory.createKey(Product.class.getSimpleName(), new Long(request.getParameter("productId")).longValue());
			Product a = pm.getObjectById(Product.class, k);

			aux = a;
			aux.setName((request.getParameter("organizacion")));
			aux.setPrecio(Double.parseDouble(request.getParameter("precio")));

			pm.close();
			response.sendRedirect("/products");
		}
	}
}
