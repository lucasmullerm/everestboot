package server;

public interface ISQLHandler {
	public void add (IHyperlink x) ;
	public IHyperlink[] search (String s) ;
	public IHyperlink[] tagged (String s) ;
	public void remove (int id) ;
}