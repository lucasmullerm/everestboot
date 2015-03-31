import java.util.*;
public interface IHyperlink {
    public void setComment (String comment);
    public String getComment ();
    public List<String> getCommentWords();
    public void setId (long id) ;
    public long getId ();
    public void setName (String name);
    public String getName ();
    public void setURL (String url) ;
    public String getURL ();
    public void addTag (String tag);
    public List<String> getTags ();
}
