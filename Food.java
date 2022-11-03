public class Food{
	String name;
	Integer price;
	Double calories;
	Comparator<Food> comp = null;

	public Food () {}

	public Food(String n, Integer p, Double c){
		this.name = n;
		this.price = p;
		this.calories = c;
	}
	
	public void setComparator(Comparator<Food> comp){
		this.comp = comp;
	}
    public int compare(Food other) {	
		if(comp==null) System.out.println("ERROR!");
        return comp.compare(this, other);
    }
	
	public String getName(){return this.name;}
	
	public Integer getPrice(){return this.price;}
	
	public Double getCalories(){return this.calories;}

	public String toString() {
		return name + "," + price + "," + calories;
	}
}