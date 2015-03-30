import java.util.*

public Hyperlink implements IHyperlink{
    private long id;
    private String name, url;
    private List<String> tags;
    public Hyperlink (int id, String name, String url, List<String> tags) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.tags = new ArrayList<String>(tags);
    }
    public void setId(long id){
	this.id = id;
    }
    public long getId() {
	return id;
    }
    public void setName(String name){
	this.name = name;
    }
    public String getName() {
	return name;
    }
    public void setURL(String url) {
	this.url = url;
    }
    public String getURL() {
	return url;
    }
    public void addTag(String tag) {
	tags.add (tag);
    }
    public List<String> getTags () {
	return tags;
    }
}
