import java.util.*

public Hyperlink implements IHyperlink{
    private int id;
    private String name, url;
    private List<String> tags = new List<String>();
    public Hyperlink (int id, String name, String url, List<String> tags) {
	this.id = id;
	this.name = name;
	this.url = url;
	this.tags = new ArrayList<String>(tags);
    }
    public void setId(int id){
	this.id = id;
    }
    public int getId() {
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
}
