package strategyPattern;
public class CompareModifiedDate implements Comparable{
	public int compareTo (Object o1, Object o2) {
		FileInfo f1=(FileInfo)o1;
		FileInfo f2=(FileInfo)o2;
		return f1.getModifiedDate().compareTo(f2.getModifiedDate());
	      }
}

