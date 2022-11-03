import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;

public class ExchangeSort implements Sort{
	//declaring the variable
	public int i;
	public int j;
	public int programcounter;
	public String result;
	public String step;
	public int type;
	//initializing the SelectionSort
	public ExchangeSort(){
		i=0;
		j=1;
		programcounter=1;
		result="";
		step="";
	}

    public <T extends Comparable<T>> void allStep(ArrayList<T> array) {         //Show all the steps at once
		T buffer;
		for (; i < array.size()-1 ; i++) {
			for(j=i+1; j < array.size() ; j++){
				if(array.get(i).compareTo(array.get(j)) > 0){
					buffer = array.get(i);
					array.set(i, array.get(j));
					array.set(j, buffer);
				}
				step+= (i+1) + " " + (j+1) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
        }
    }

    public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array) {         //Show all the steps at once
		T buffer;
		for (; i < array.size()-1 ; i++) {
			for(j=i+1; j < array.size() ; j++){
				if(array.get(i).compareTo(array.get(j)) < 0){
					buffer = array.get(i);
					array.set(i, array.get(j));
					array.set(j, buffer);
				}
				step+= (i+1) + " " + (j+1) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
        }
    }

	public void O_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
		Food buffer;
		for (; i < array.size()-1 ; i++) {
			for(j=i+1; j < array.size() ; j++){
				switch(judge){
					case 1:array.get(i).setComparator(new NameComparator<Food>());break;
					case 2:array.get(i).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(i).setComparator(new CaloriesComparator<Food>());break;
				}
				if(array.get(i).compare(array.get(j)) < 0){
					buffer = array.get(i);
					array.set(i, array.get(j));
					array.set(j, buffer);
				}
				step+= (i+1) + " " + (j+1) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
		}
	}

	public void O_Down_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
		Food buffer;
		for (; i < array.size()-1 ; i++) {
			for(j=i+1; j < array.size() ; j++){
				switch(judge){
					case 1:array.get(i).setComparator(new NameComparator<Food>());break;
					case 2:array.get(i).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(i).setComparator(new CaloriesComparator<Food>());break;
				}
				if(array.get(i).compare(array.get(j)) > 0){
					buffer = array.get(i);
					array.set(i, array.get(j));
					array.set(j, buffer);
				}
				step+= (i+1) + " " + (j+1) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
		}
	}

	public <T> void toString(ArrayList<T> array){         //Output the stored array
		int c=0;
		DecimalFormat df = new DecimalFormat("0.######");
		for(T k:array){
			switch(type){
				case 0: {
					result+=""+df.format((double)k);
					break;
				}
				case 1:case 2:{
					result+=""+k;
					break;
				}
			}
			if(c++<array.size()-1)
				result+="  ";       //output a space between numbers, but don't output after the last number
		}
		System.out.println("success");
	}
}