package controller.boletas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.ElementoBoleta;
import model.entity.Product 	;


public class BoletaControllerCreate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


		com.google.appengine.api.users.User uGoogle= UserServiceFactory.getUserService().getCurrentUser();
		if(uGoogle == null){
			RequestDispatcher dp = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/Error1.jsp");
			dp.forward(request, response);
		}
		else{
			
			if(request.getParameter("action").equals("creating")){
				
				
				// create the persistence manager instance
				PersistenceManager pm = PMF.get().getPersistenceManager();
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
				request.setAttribute("productos", products);
				// query for the entities by name
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/boletas/boletaCreate.jsp");
				dispatcher.forward(request, response);
				
			}
			else{
				String userId = uGoogle.getUserId();
				// create the persistence manager instance
				PersistenceManager pm = PMF.get().getPersistenceManager();
				ElementoBoleta aux;
				String query = "select from " + Product.class.getName();
				List<Product> productos = (List<Product>)pm.newQuery(query).execute();
				int i;
				for(i = 0;i<productos.size();i++){
					if(productos.get(i).getName().equals(request.getParameter("producto")))
						break;
				}
				Product b = productos.get(i);
				aux = new ElementoBoleta (b.getName(),b.getPrecio(),Integer.parseInt(request.getParameter("cantidad")), userId);
				
				try { 
					pm.makePersistent(aux);
				} finally {
					pm.close();
				}
				response.sendRedirect("/boleta");
			}
		}
	}
}