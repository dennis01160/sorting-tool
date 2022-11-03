public class NameComparator<T extends Food> implements Comparator<T>{
	public int compare(T o1, T o2){
		String thisName = o1.getName();
		String otherName = o2.getName();
		if(thisName.compareTo(otherName) > 0) return 1;
		else if(thisName.compareTo(otherName) < 0) return -1;
		else return 0;
	}
}