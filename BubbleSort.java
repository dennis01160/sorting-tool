import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;


public class BubbleSort implements Sort{
	//declaring the variable
	public int i;
	public int j;
	public int programcounter;
	public String result;
	public String step;
	public int type;
	//initializing the SelectionSort
	public BubbleSort(){
		i=0;
		j=0;
		programcounter=1;
		result="";
		step="";
	}

    public <T extends Comparable<T>> void allStep(ArrayList<T> array) {         //Show all the steps at once
		T buffer;
		for (i=0; i < array.size()-1 ; i++) {
			for(j=0; j < array.size()-1-i ; j++){
				if(array.get(j).compareTo(array.get(j+1)) > 0){
					buffer = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, buffer);
				}
				step+=(j+1) + " " + (j+2) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
        }
    }

    public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array) {         //Show all the steps at once
		T buffer;
		for (i=0; i < array.size()-1 ; i++) {
			for(j=0	; j < array.size()-1-i ; j++){
				if(array.get(j).compareTo(array.get(j+1)) < 0){
					buffer = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, buffer);
				}
				step+=(j+1) + " " + (j+2) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
        }
    }

	public void O_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
		Food buffer;
		for (i=0; i < array.size()-1 ; i++) {
			for(j=0; j < array.size()-1-i ; j++){
				switch(judge){
					case 1:array.get(j).setComparator(new NameComparator<Food>());break;
					case 2:array.get(j).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(j).setComparator(new CaloriesComparator<Food>());break;
				}
				if(array.get(j).compare(array.get(j+1)) > 0){
					buffer = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, buffer);
				}
				step+=(j+1) + " " + (j+2) +"\n";
				toString(array);
				result+="\n";
				programcounter++;
			}
		}
	}

	public void O_Down_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
		Food buffer;
		for (i=0; i < array.size()-1 ; i++) {
			for(j=0	; j < array.size()-1-i ; j++){
				switch(judge){
					case 1:array.get(j).setComparator(new NameComparator<Food>());break;
					case 2:array.get(j).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(j).setComparator(new CaloriesComparator<Food>());break;
				}
				if(array.get(j).compare(array.get(j+1)) < 0){
					buffer = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, buffer);
				}
				step+=(j+1) + " " + (j+2) +"\n";
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
