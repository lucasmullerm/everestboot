
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
		List<String> idList      = new ArrayList<String>();
		List<String> nameList    = new ArrayList<String>();
		List<String> urlList     = new ArrayList<String>();
		List<String> commentList = new ArrayList<String>();
		List<String> tagList     = new ArrayList<String>();
		for (IHyperlink h : result) {
			idList.add(String.valueOf(h.getId()));
			nameList.add(h.getName());
			urlList.add(h.getURL());
			commentList.add(h.getComment());
			String tagString = null;
			for (String tag : h.getTags()) {
				if (tagString == null) {
					tagString = tag;
				}
				else {
					tagString += "," + tag;
				}
			}
			tagList.add(tagString);	
		}
		//req.setAttribute("result", result);
		req.setAttribute("idList", idList);
		req.setAttribute("nameList", nameList);
		req.setAttribute("urlList", urlList);
		req.setAttribute("tagList", tagList);
		req.setAttribute("commentList", commentList);
		req.setAttribute("type", "tagged");
		req.getRequestDispatcher("/searchresult.jsp").forward(req, resp);

	}
}