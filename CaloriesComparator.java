public class CaloriesComparator<T extends Food> implements Comparator<T>{
	public int compare(T o1, T o2){
		Double thisCalories = o1.getCalories();
		Double otherCalories = o2.getCalories();
		if(thisCalories > otherCalories) return 1;
		else if(thisCalories < otherCalories) return -1;
		else return 0;
	}
}