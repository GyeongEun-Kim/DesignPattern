package strategyPattern;
public class CompareSize implements Comparable{
	public int compareTo (Object o1,Object o2) {
		FileInfo f1=(FileInfo)o1;
		FileInfo f2=(FileInfo)o2;
		return (f1.getSize()-f2.getSize());
	      }
	}


