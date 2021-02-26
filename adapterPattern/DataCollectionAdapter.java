package adapterPattern;
import java.util.ArrayList;
import java.util.Iterator;


public class DataCollectionAdapter implements DataCollection<String>{
	
	private ArrayList<String> arr;
	
	public DataCollectionAdapter (ArrayList<String> arr) {
		this.arr=arr;
	}//»ý¼ºÀÚ 
	
	
	@Override
	public boolean put(String t) {
		arr.add(t);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object elemAt(int index) {
		// TODO Auto-generated method stub
		return arr.get(index);
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return arr.size();
	}

	@Override
	public Iterator createIterator() {
		Iterator<String> iter = arr.iterator();
		// TODO Auto-generated method stub
		return iter;
	}

	

}
