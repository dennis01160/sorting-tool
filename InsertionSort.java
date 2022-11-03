import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;

public class InsertionSort implements Sort{
    //declaring the variable
    public int j;
    public int programcounter;
    public String result;
    public String step;
    public int type;
    //initializing the InsertionSort
    public InsertionSort(){
        j = 1;
        step="";
        result="";
        programcounter=1;
    }

    public <T extends Comparable <T>> void allStep(ArrayList<T> array) {         //Show all the steps at once
        for (; j < array.size(); j++) {
            T key = array.get(j);
            int i = j-1;
            while ( (i > -1) && (array.get(i).compareTo(key) > 0)) {
                array.set(i+1,array.get(i));
                i--;
            }
            array.set(i+1, key);
            step+=(j+1) + " " + (i+2)+"\n";
            toString(array);
            result+="\n";
            programcounter++;
        }
    }

    public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array) {         //Show all the steps at once
        for (; j < array.size(); j++) {
            T key = array.get(j);
            int i = j-1;
            while ( (i > -1) && (array.get(i).compareTo(key) < 0)) {
                array.set(i+1,array.get(i));
                i--;
            }
            array.set(i+1, key);
            step+=(j+1) + " " + (i+2)+"\n";
            toString(array);
            result+="\n";
            programcounter++;
        }
    }

    public void O_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
        for (; j < array.size(); j++) {
            Food key = array.get(j);
            switch(judge){
                case 1:key.setComparator(new NameComparator<Food>());break;
                case 2:key.setComparator(new PriceComparator<Food>());break;
                case 3:key.setComparator(new CaloriesComparator<Food>());break;
            }
            int i = j-1;
            while ( (i > -1) && (key.compare(array.get(i)) < 0)) {
                array.set(i+1,array.get(i));
                i--;
            }
            array.set(i+1, key);
            step+=(j+1) + " " + (i+2)+"\n";
            toString(array);
            result+="\n";
            programcounter++;
        }
    }

    public void O_Down_allStep(ArrayList<Food> array, int judge) {         //Show all the steps at once
        for (; j < array.size(); j++) {
            Food key = array.get(j);
            switch(judge){
                case 1:key.setComparator(new NameComparator<Food>());break;
                case 2:key.setComparator(new PriceComparator<Food>());break;
                case 3:key.setComparator(new CaloriesComparator<Food>());break;
            }
            int i = j-1;
            while ( (i > -1) && (key.compare(array.get(i)) > 0)) {
                array.set(i+1,array.get(i));
                i--;
            }
            array.set(i+1, key);
            step+=(j+1) + " " + (i+2)+"\n";
            toString(array);
            result+="\n";
            programcounter++;
        }
    }

    public <T> void toString(ArrayList<T> array){         //Output the stored array
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
