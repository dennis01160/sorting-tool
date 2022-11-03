import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;

public class SelectionSort implements Sort{
	//declaring the variable
	public int j;
	public int programcounter;
	public String result;
	public String step;
	public int type;
	//initializing the SelectionSort
	public SelectionSort(){
		j = 1;
		result="";
		step="";
		programcounter=1;
	}

//--------------------Increase_AllStep-----------------------------
	public <T extends Comparable<T>> void allStep(ArrayList<T> array){
		j--;
       	for (; j < (array.size() - 1) ; j++){
			int minIndex = j;
           	for (int q = j + 1; q < array.size(); q++){
           		if (array.get(q).compareTo(array.get(minIndex)) < 0){
					minIndex = q;
           	   	}
           	}
           	if (minIndex != j) Swap(array, minIndex, j);
			step+=(minIndex+1) + " " + (j+1) +"\n";
           	toString(array);
			result+="\n";
			programcounter++;
       	}
       	j=array.size();
	}

//---------------------Down_AllStep-----------------------------
	public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array){
		j--;
        for (; j < (array.size() - 1) ; j++){
        	int maxIndex = j;
           	for (int q = j + 1; q < array.size(); q++){
           		if (array.get(q).compareTo(array.get(maxIndex)) > 0){
					maxIndex = q;
           	   	}
           	}
           	if (maxIndex != j) Swap(array, maxIndex, j);
			step+=(maxIndex+1) + " " + (j+1) +"\n";
           	toString(array);
			result+="\n";
			programcounter++;
        }
        j=array.size();
	}
//--------------------Object_Increase_AllStep-----------------------------
	public void O_allStep(ArrayList<Food> array, int judge){
		j--;
		for (; j < (array.size() - 1) ; j++){
			int minIndex = j;
			for (int q = j + 1; q < array.size(); q++){
				switch(judge){
					case 1:array.get(q).setComparator(new NameComparator<Food>());break;
					case 2:array.get(q).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(q).setComparator(new CaloriesComparator<Food>());break;
				}
				if (array.get(q).compare(array.get(minIndex)) < 0){
					minIndex = q;
				}
			}
			if (minIndex != j) Swap(array, minIndex, j);
			step+=(minIndex+1) + " " + (j+1) +"\n";
			toString(array);
			result+="\n";
			programcounter++;
		}
		j=array.size();
	}
//---------------------Object_Down_AllStep-----------------------------
	public void O_Down_allStep(ArrayList<Food> array, int judge){
		j--;
		for (; j < (array.size() - 1) ; j++){
			int maxIndex = j;
			for (int q = j + 1; q < array.size(); q++){
				switch(judge){
					case 1:array.get(q).setComparator(new NameComparator<Food>());break;
					case 2:array.get(q).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(q).setComparator(new CaloriesComparator<Food>());break;
				}
				if (array.get(q).compare(array.get(maxIndex)) > 0){
					maxIndex = q;
				}
			}
			if (maxIndex != j) Swap(array, maxIndex, j);
			step+=(maxIndex+1) + " " + (j+1) +"\n";
			toString(array);
			result+="\n";
			programcounter++;
		}
		j=array.size();
	}
//--------------------------Change A and B---------------------------
	private <T> void Swap(ArrayList<T> array, int indexA, int indexB){
		T tmp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, tmp);
	}
//-------------------------------------------------------------------
	public <T> void toString(ArrayList<T> array){
		int c=0;
		DecimalFormat df = new DecimalFormat("0.######");
		for(T i:array){
			switch(type){
				case 0: {
					result+=""+df.format((double)i);
					break;
				}
				case 1:case 2:{
					result+=""+i;
					break;
				}
			}
			if(c++<array.size()-1)
				result+="  ";       //output a space between numbers, but don't output after the last number
		}
		System.out.println("success");
	}
}