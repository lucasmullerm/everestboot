
import java.util.*;

public interface IDBHandler {
    public void add (IHyperlink x) ;
    public static IDBHandler getInstance ();
    public List<IHyperlink> search (String s) ;
    public List<IHyperlink> tagged (String s) ;
    public void remove (int id) ;
}
