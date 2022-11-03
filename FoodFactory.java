import java.util.*;

public class FoodFactory{

    public ArrayList<Food> F = null;

    public FoodFactory(){
        F = new ArrayList<Food>();
    }

    public ArrayList<Food> create(String name , Integer price , Double calories){           
        Food ftemp = new Food(name,price,calories);
        F.add(ftemp);
		return F;
    } 
}
