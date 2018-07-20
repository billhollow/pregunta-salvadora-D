package controller.products;
import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.Product;
import model.entity.User;
import controller.PMF;

@SuppressWarnings("serial")
public class ProductControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();

		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			dp.forward(request, response);
		}
		else{


			boolean encontrado = false;
			// create the persistence manager instance
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query2 = "select from " + User.class.getName() ;
			List<User> users = (List<User>)pm.newQuery(query2).execute();

			for(int i = 0; i<users.size();i++){
				if(users.get(i).getEmail().equals(uGoogle.getEmail())){
				encontrado = true;
				break;
				}
			}

			if(!encontrado){
				RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error2.jsp");
				dp.forward(request, response);
			}
			else{


				// query for the entities by name
				String query = "select from " + Product.class.getName() ;
				List<Product> products = (List<Product>)pm.newQuery(query).execute();
				ArrayList<Product> products2 = new ArrayList<Product>();

				//filtrar todos los elementos por el usuario actual
				for(int i = 0; i<products.size();i++){
					if(products.get(i).getIdUser().equals(uGoogle.getUserId())){
						products2.add(products.get(i));
					}
				}
				products = products2;


				// pass the list to the jsp
				request.setAttribute("products", products);

				// forward the request to the jsp
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/products/productDisplay.jsp");
				pm.close();
				dispatcher.forward(request, response); 
			}
		}
	}

}