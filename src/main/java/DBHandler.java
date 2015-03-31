import java.util.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.*;
import com.google.appengine.api.datastore.Query.*;

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
	List<Entity> ret = Arrays.asList(datastore.prepare (query));
	List<IHyperlink> ans = new ArrayList<IHyperlink> ();
	for (int i = 0; i < ret.size (); i++) {
	    ans.add (new Hyperlink (ret[i].getProperty ("id"),
				    ret[i].getProperty ("name"),
				    ret[i].getProperty ("url"),
				    ret[i].getProperty ("tags")));
	}
	return ans;
    }
    public List<IHyperlink> tagged (String s) {
	Query query = new Query ("Hyperlink");
	query = query.setFilter ("tags", s);
	List<Entity> ret = Arrays.asList(datastore.prepare (query));
	List<Entity> ret = Arrays.asList(datastore.prepare (query));
	List<IHyperlink> ans = new ArrayList<IHyperlink> ();
	for (int i = 0; i < ret.size (); i++) {
	    ans.add (new Hyperlink (ret[i].getProperty ("id"),
				    ret[i].getProperty ("name"),
				    ret[i].getProperty ("url"),
				    ret[i].getProperty ("tags")));
	}
	return ans;
    }
    public void remove (long id) {
	Key key = new Key (id);
	datastore.delete (key);
    }
}
