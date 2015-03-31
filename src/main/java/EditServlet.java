
import java.io.IOException;
import java.util.*;
import java.lang.Exception;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class EditServlet extends HttpServlet {
	
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
		req.setAttribute("id", id);
		req.setAttribute("name", h.getName());
		req.setAttribute("url", h.getURL());
		String tagString = null;
		for (String tag : h.getTags()) {
			if (tagString == null) {
				tagString = tag;
			}
			else {
				tagString += "," + tag;
			}
		}
		req.setAttribute("tag", tagString);
		req.setAttribute("comment", h.getComment());
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		long id = Long.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String url = req.getParameter("url");
		String tags = req.getParameter("tags");
		String comment = req.getParameter("comment");
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

		IHyperlink hyperlink = new Hyperlink(id, name, url, tagsList, comment);
		
		DBHandler dbhandler = DBHandler.getInstance();
		
		dbhandler.edit(hyperlink);
		req.getRequestDispatcher("/edited.jsp").forward(req, resp);

	}
}
