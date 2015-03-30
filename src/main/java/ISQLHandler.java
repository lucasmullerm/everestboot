
import java.util.*;

public interface ISQLHandler {
    public void add (IHyperlink x) ;
    public List<IHyperlink> search (String s) ;
    public List<IHyperlink> tagged (String s) ;
    public void remove (int id) ;
}
