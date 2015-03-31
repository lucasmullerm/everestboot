
import java.io.IOException;
import java.util.*;
import java.lang.Exception;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class RemoveServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		String id = req.getParameter("id");
		long idLong = Long.valueOf(id);
		DBHandler dbhandler = DBHandler.getInstance();
		IHyperlink h = dbhandler.searchId(idLong);
		if (h == null) {
			resp.setContentType("text/plain");
			resp.getWriter().println("ID INVÁLIDO!");
			return;
		}
		dbhandler.remove(idLong);
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
