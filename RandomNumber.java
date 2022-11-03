import java.lang.*;

public class RandomNumber {
	public int total;
	public int min,max;
	public double[] randomarray;
	public String randomresult;
	
	public RandomNumber(){
		randomresult="";
	}
		
	public void produce(){
		randomarray = new double[total];
		for(int count=0;count<total;count++){
			int r = (int)(Math.random() * 3);
			switch(r){
			case 0:
			randomarray[count] = Math.round(((Math.random() * (max - min + 1)) + min)*10.0)/10.0;
			break;
			case 1:
			randomarray[count] = Math.round(((Math.random() * (max - min + 1)) + min)*100.0)/100.0;
			break;
			case 2:
			randomarray[count] = Math.round(((Math.random() * (max - min + 1)) + min)*1000.0)/1000.0;
			break;
			}
		}

		/*for(int i=0;i<total;i++){	//can output only double numbers that are three digits after decimal point
			randomarray[i] = Math.round(((double)(Math.random() * (max - min + 1)) + min)*1000.0)/1000.0;
		}*/
		
		for(int j=0;j<total;j++){
			if(j!=total-1){
				randomresult += (randomarray[j] + " ");
			}
			else{
				randomresult += Double.toString(randomarray[j]);
			}
		}
	}
	
}