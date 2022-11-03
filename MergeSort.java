import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;
 
public class MergeSort implements Sort{
	
	public int j;
    public int programcounter;
    public String result;
	public String step;
    public int type;
	public int head,tail;
	
	public MergeSort(){
		j = 1;
        result="";
        programcounter=1;
        step="";
	}
	
	public <T extends Comparable<T>> void allStep(ArrayList<T> array){	
		head = 0;
		tail = array.size()-1;
		sort(array,head,tail);
	}
	
	public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array){
		head = 0;
		tail = array.size()-1;
		down_sort(array,head,tail);
	}
	
	public void O_allStep(ArrayList<Food> array, int judge) {
		head = 0;
		tail = array.size()-1;
		O_sort(array,head,tail,judge);
	}
	
	public void O_Down_allStep(ArrayList<Food> array, int judge){
		head = 0;
		tail = array.size()-1;
		O_down_sort(array,head,tail,judge);
	}
	
	public <T extends Comparable <T>> void sort(ArrayList<T> array, int s, int e){
		
        if (s == e)
            return;

        int mid = (s + e) / 2;

        sort(array, s, mid);
        sort(array, mid + 1, e);
        merge(array, s, e);
    }
	
    public <T extends Comparable <T>> void down_sort(ArrayList<T> array, int s, int e){
		
        if (s == e)
            return;

        int mid = (s + e) / 2;

        down_sort(array, s, mid);
        down_sort(array, mid + 1, e);
        down_merge(array, s, e);
    }
	
	public void O_sort(ArrayList<Food> array, int s, int e, int judge){
		
        if (s == e)
            return;

        int mid = (s + e) / 2;

        O_sort(array, s, mid,judge);
        O_sort(array, mid + 1, e,judge);
        O_merge(array, s, e,judge);
    }
	
	public void O_down_sort(ArrayList<Food> array, int s, int e, int judge){
		
        if (s == e)
            return;

        int mid = (s + e) / 2;

        O_down_sort(array, s, mid,judge);
        O_down_sort(array, mid + 1, e,judge);
        O_down_merge(array, s, e,judge);
    }
	
 
    public <T extends Comparable <T>> void merge(ArrayList<T> array, int start, int end){
		
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0;gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                int k = i + gap;
                if (array.get(i).compareTo(array.get(k)) > 0){
                    swap(array, i, k);

					step+=(i+1) + " " + (k+1) +"\n";
					toString(array);
					result+="\n";
					programcounter++;
				}
            }
        }
    }
	
	public <T extends Comparable <T>> void down_merge(ArrayList<T> array, int start, int end){
		
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0;gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                int k = i + gap;
                if (array.get(i).compareTo(array.get(k)) <= 0){
                    swap(array, i, k);

					step+=(i+1) + " " + (k+1) +"\n";
					toString(array);
					result+="\n";
					programcounter++;
				}
            }
        }
    }
	
    public void O_merge(ArrayList<Food> array, int start, int end, int judge){

        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0;gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
				switch(judge){
					case 1:array.get(i).setComparator(new NameComparator<Food>());break;
					case 2:array.get(i).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(i).setComparator(new CaloriesComparator<Food>());break;
				}
                int k = i + gap;
                if (array.get(i).compare(array.get(k)) > 0){
                    swap(array, i, k);
					
					step+=(i+1) + " " + (k+1) +"\n";
					toString(array);
					result+="\n";
					programcounter++;
				}
            }
        }
    }
	
    public void O_down_merge(ArrayList<Food> array, int start, int end, int judge){
		
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0;gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
				switch(judge){
					case 1:array.get(i).setComparator(new NameComparator<Food>());break;
					case 2:array.get(i).setComparator(new PriceComparator<Food>());break;
					case 3:array.get(i).setComparator(new CaloriesComparator<Food>());break;
				}
                int k = i + gap;
                if (array.get(i).compare(array.get(k)) < 0){
                    swap(array, i, k);

					step+=(i+1) + " " + (k+1) +"\n";
					toString(array);
					result+="\n";
					programcounter++;
				}
            }
        }
    }

	
	public int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (int)Math.ceil(gap / 2.0);
    }
 
	private <T> void swap(ArrayList<T> array, int indexA, int indexB){
		T tmp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, tmp);
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