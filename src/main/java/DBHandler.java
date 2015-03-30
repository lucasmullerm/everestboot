import java.util.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.*

public SQLHandler implements ISQLHandler {
    private static SQLHandler handler = new SQLHandler ();
    private DatastoreService datastore;
    private SQLHandler () {
	datastore = DatastoreServiceFactory.getDatastoreService();
    }
    public static SQLHandler getInstance () {
	return handler;
    }
    public void add (IHyperlink x) {
	x.setId (KeyFactory.createKey("Hyperlink", "Hyperlink"));
	Entity hyp = new Entity ("Hyperlink", "Hyperlink");
	hyp.setProperty ("id", x.getId ());
	hyp.setProperty ("name", x.getName ());
	hyp.setProperty ("url", x.getURL ());
	hyp.setProperty ("tags", x.getTags ());
    }
    public List<IHyperlink> search (String s) {

    }
    public List<IHyperlink> tagged (String s) {

    }
    public void remove (int id) {

    }
}
