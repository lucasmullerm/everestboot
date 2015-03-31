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
	query = query.setFilter (new FilterPredicate("name",
						     FilterOperator.EQUAL,
						     s));
	List<Entity> ret = datastore.prepare (query).asList(FetchOptions.Builder.withLimit(1000));
	List<IHyperlink> ans = new ArrayList<IHyperlink> ();
	for (int i = 0; i < ret.size (); i++) {
	    long id = (long)ret.get (i).getProperty ("id");
	    String name = (String)ret.get (i).getProperty ("name");
	    String url = (String)ret.get (i).getProperty ("url");
	    List<String> tags = (List<String>)ret.get (i).getProperty ("tags");
	    ans.add (new Hyperlink (id, name, url, tags));
	}
	return ans;
    }
    public List<IHyperlink> tagged (String s) {
	Query query = new Query ("Hyperlink");
	query = query.setFilter (new FilterPredicate("tags", 
						     FilterOperator.EQUAL,
						     s));
	List<Entity> ret = datastore.prepare (query).asList(FetchOptions.Builder.withLimit(1000));
	List<IHyperlink> ans = new ArrayList<IHyperlink> ();
	for (int i = 0; i < ret.size (); i++) {
	    long id = (long)ret.get(i).getProperty ("id");
	    String name = (String)ret.get(i).getProperty("name");
	    String url = (String)ret.get(i).getProperty("url");
	    List<String> tags = (List<String>)ret.get(i).getProperty("tags");
	    ans.add (new Hyperlink (id, name, url, tags));
	}
	return ans;
    }
    public void remove (long id) {
	Key key = KeyFactory.createKey("Hyperlink", id);
	datastore.delete (key);
    }
}
