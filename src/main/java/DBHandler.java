import java.util.*;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.*;
import com.google.appengine.api.datastore.Query.*;

public class DBHandler {
    private static DBHandler handler = new DBHandler ();
    private DatastoreService datastore;
    private Random rand;
    private DBHandler () {
	datastore = DatastoreServiceFactory.getDatastoreService();
	rand = new Random();
    }
    public static DBHandler getInstance () {
	return handler;
    }
    public void add (IHyperlink x) {
	Entity hyp = new Entity ("Hyperlink");
	if (x.getId () == (long)(-1)) 
	    x.setId (rand.nextLong ());
	hyp.setProperty ("id", x.getId ());
	hyp.setProperty ("name", x.getName ());
	hyp.setProperty ("url", x.getURL ());
	hyp.setProperty ("tags", x.getTags ());
	hyp.setProperty ("commentWords", x.getCommentWords ());
	hyp.setProperty ("comment", x.getComment ());
	datastore.put (hyp);
    }
    public IHyperlink searchId (long id) {
	Query query = new Query ("Hyperlink");
	query = query.setFilter (new FilterPredicate("id",
						     FilterOperator.EQUAL,
						     id));
	List<Entity> ret = datastore.prepare (query).asList(FetchOptions.Builder.withLimit(1000));
	Hyperlink ans;
	if (ret.size () == 1) {
	    String name = (String)ret.get(0).getProperty ("name");
	    String url = (String)ret.get(0).getProperty("url");
	    List<String> tags = (List<String>)ret.get(0).getProperty("tags");
	    String comment = (String)ret.get(0).getProperty("comment");
	    ans = new Hyperlink (id, name, url, tags, comment);
	}
	else
	    ans = null;
	return ans;
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
	    String comment = (String)ret.get (i).getProperty ("comment");
	    ans.add (new Hyperlink (id, name, url, tags, comment));
	}
	return ans;
    }
    public List<IHyperlink> searchComment (String s) {
	Query query = new Query ("Hyperlink");
	query = query.setFilter (new FilterPredicate ("commentWords", 
						      FilterOperator.EQUAL,
						      s));
	List<Entity> ret = datastore.prepare (query).asList(FetchOptions.Builder.withLimit(1000));
	List<IHyperlink> ans = new ArrayList<IHyperlink> ();
	for (int i = 0; i < ret.size (); i++) {
	    long id = (long)ret.get (i).getProperty ("id");
	    String name = (String)ret.get (i).getProperty ("name");
	    String url = (String)ret.get (i).getProperty ("url");
	    List<String> tags = (List<String>)ret.get (i).getProperty ("tags");
	    String comment = (String)ret.get (i).getProperty ("comment");
	    ans.add (new Hyperlink (id, name, url, tags, comment));
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
	    String comment = (String)ret.get (i).getProperty ("comment");
	    ans.add (new Hyperlink (id, name, url, tags, comment));
	}
	return ans;
    }
    public void edit (IHyperlink x) {
	remove (x.getId ());
	add (x);
    }
    public void remove (long id) {
	Query query = new Query ("Hyperlink");
	query = query.setFilter (new FilterPredicate("id",
						     FilterOperator.EQUAL,
						     id));
	List<Entity> ret = datastore.prepare (query).asList(FetchOptions.Builder.withLimit(1000));
	Key key = ret[0].getKey();
	datastore.delete (key);
    }
}
