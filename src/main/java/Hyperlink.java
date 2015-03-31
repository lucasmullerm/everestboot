import java.util.*;

public class Hyperlink implements IHyperlink{
    private long id;
    private String name, url;
    private List<String> tags, comments;
    public Hyperlink (long id, String name, String url, 
		      List<String> tags, String comments) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.tags = new ArrayList<String>(tags);
		this.comment = comment;
    }
    public void setComment (String comment) {
	this.comment = comment;
    }
    public String getComment () {
	return comment;
    }
    public List<String> getCommentWords () {
	return Array.asList (comment.split ("\\s+");
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
