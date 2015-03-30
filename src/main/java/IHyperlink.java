public interface IHyperlink {
    public void setId (long id) ;
    public int getId ();
    public void setName (String name);
    public String getName ();
    public void setURL (String url) ;
    public String getURL ();
    public void addTag (String tag);
    public List<String> getTags ();
}
