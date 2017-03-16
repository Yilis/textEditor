package textEditor;

public class IOresult<T> {

	
	private T data;
	private boolean ok;
	
	public IOresult(boolean ok, T data){
		this.ok = ok;
		this.data = data;
	}
	
	public boolean isOk(){
		return ok;
	}
	
	public T getdata(){
		return data;
	}
	
	public boolean hasData(){
		return data != null;
	}
}
