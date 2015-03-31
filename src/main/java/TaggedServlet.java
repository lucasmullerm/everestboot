
import java.io.IOException;
import java.util.*;
import java.lang.Exception;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class TaggedServlet extends HttpServlet {
	
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
//			throws IOException, ServletException {
//
//		req.getRequestDispatcher(req.getContextPath()+"search.jsp").forward(req, resp);
//	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		String name = req.getParameter("name");
		DBHandler dbhandler = DBHandler.getInstance();
		List<IHyperlink> result = dbhandler.tagged(name);
		req.setAttribute("result", result);
		req.setAttribute("type", "tagged");
		req.getRequestDispatcher("searchresult.jsp").forward(req, resp);

	}
}