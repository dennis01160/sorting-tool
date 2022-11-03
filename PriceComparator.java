public class PriceComparator<T extends Food> implements Comparator<T>{
	public int compare(T o1, T o2){
		Integer thisPrice = o1.getPrice();
		Integer otherPrice = o2.getPrice();
		if(thisPrice > otherPrice) return 1;
		else if(thisPrice < otherPrice) return -1;
		else return 0;
	}
}