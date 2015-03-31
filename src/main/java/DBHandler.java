import java.util.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.*;

public class DBHandler {
    private static DBHandler handler = new DBHandler ();
    private DatastoreService datastore;
    private DBHandler () {
	datastore = DatastoreServiceFactory.getDatastoreService();
    }
    public static DBHandler getInstance () {
	return handler;
    }
    public void add (IHyperlink x) {
	Entity hyp = new Entity ("Hyperlink");
	if (x.getId () == -1) 
	    x.setId (hyp.getKey().getId());
	hyp.setProperty ("id", x.getId ());
	hyp.setProperty ("name", x.getName ());
	hyp.setProperty ("url", x.getURL ());
	hyp.setProperty ("tags", x.getTags ());
	datastore.put (hyp);
    }
    public List<IHyperlink> search (String s) {
	Query query = new Query ("Hyperlink");
	query = query.filter ("name", s);
	List<IHyperlink> ans = Arrays.asList(datastore.prepare (query));
	return ans;
    }
    public List<IHyperlink> tagged (String s) {
	Query query = new Query ("Hyperlink");
	query = query.filter ("tags", s);
	List<IHyperlink> ans = Arrays.asList(datastore.prepare (query));
	return ans;
    }
    public void remove (long id) {
	Key key = Key (id);
	datastore.delete (key);
    }
}
