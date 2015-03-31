
import java.io.IOException;
import java.util.*;
import java.lang.Exception;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class AddServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		req.getRequestDispatcher(req.getContextPath()+"add.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String tags = req.getParameter("tags");
		String[] tagsArray;
		List<String> tagsList;
		try {
			tagsArray = tags.split(",");
			tagsList = Arrays.asList(tagsArray);
		}
		catch (Exception e){
			resp.setContentType("text/plain");
			resp.getWriter().println("ERRO AO SEPARAR TAGS");
			return;
		}
		String comment = req.getParameter("comment");

		IHyperlink hyperlink = new Hyperlink(-1, name, url, tagsList); //add comments
		
		DBHandler dbhandler = DBHandler.getInstance();
		
		dbhandler.add(hyperlink);

		req.getRequestDispatcher(req.getContextPath()+"added.jsp").forward(req, resp);

	}
}
