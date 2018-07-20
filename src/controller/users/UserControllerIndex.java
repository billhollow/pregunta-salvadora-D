package controller.users;
import java.io.IOException;
import javax.servlet.http.*;
import java.util.List;
import javax.servlet.*;
import javax.jdo.PersistenceManager;
import model.entity.*;
import controller.PMF;

@SuppressWarnings("serial")
public class UserControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// create the persistence manager instance
		PersistenceManager pm = PMF.get().getPersistenceManager();

		// query for the entities by name
		String query = "select from " + User.class.getName();
		List<User> users = (List<User>)pm.newQuery(query).execute();
		// pass the list to the jsp
		request.setAttribute("users", users);

		// forward the request to the jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/users/userDisplay.jsp");
		pm.close();
		dispatcher.forward(request, response); 

	}

}

