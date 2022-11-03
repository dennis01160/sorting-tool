import java.text.DecimalFormat;
import java.util.*;

public class Algorithm extends Input{

    // declaring the object of the different Sort 
    public InsertionSort is = new InsertionSort();
    public SelectionSort ss = new SelectionSort();
    public ExchangeSort  es = new ExchangeSort();
    public BubbleSort  bs = new BubbleSort();
    public MergeSort  ms = new MergeSort();
    public QuickSort  qs = new QuickSort();
    public Data data = new Data();
    //declaring the variable
    public int judge;
    public int i;
    public int j;
    public int[] index1;
    public int[] index2;
    public int step;
    public int size;
    public int index;
    public String Aresult;
    public String in;
    public String text;
    public boolean increase;//judging whether is increasing
    public boolean num_text;//judging which input data we use 
    public boolean object;
    // initializing Algorithm
    public Algorithm(){
    	increase=true;
    	num_text=true;
    	i=0;
    	j=0;
    }
    // the method for setting up the value of index 
    public void setSort(int i){ index=i; }
    // judging which data type
    public void setInputData(boolean t){
    	
    		num_text=t;
        	if(num_text){ type=0;}
        	else{ type=1; }
    	
    }

    // the method for setting up the manually input & using index to decide which sort being used
    public void setManuallyInput(){
    	keyin=in;manualInput();i=0;j=0;
        switch(index){
        case 1:is.j=1;is.programcounter=1;is.type=type;is.step="";break;
        case 2:ss.j=1;ss.programcounter=1;ss.type=type;ss.step="";break;
        case 3:es.j=1;es.programcounter=1;es.i=0;es.type=type;es.step="";break;
        case 4:bs.j=0;bs.programcounter=1;bs.i=0;bs.type=type;bs.step="";break;
        case 5:ms.j=1;ms.programcounter=1;ms.head = 0;ms.type=type;ms.step="";break;
        case 6:qs.left=0;qs.programcounter=1;qs.type=type;qs.step="";break;
        }
        
    }
    // the method for setting up the file input & using index to decide which sort being used
    public void setFileInput(){
    	filename=text;fileInput();i=0;j=0;
    	in=keyin;
        switch(index){
        case 1:is.j=1;is.programcounter=1;is.type=type;is.step="";break;
        case 2:ss.j=1;ss.programcounter=1;ss.type=type;ss.step="";break;
        case 3:es.j=1;es.programcounter=1;es.i=0;es.type=type;es.step="";break;
        case 4:bs.j=0;bs.programcounter=1;bs.i=0;bs.type=type;bs.step="";break;
        case 5:ms.j=1;ms.programcounter=1;ms.head = 0;ms.type=type;ms.step="";break;
        case 6:qs.left=0;qs.programcounter=1;qs.type=type;qs.step="";break;
        }
        
    }
    
    // the method for declaring the method in sort for work allStep() 
    public void allStep(){
    	if(!object) {
        	if(num_text){//number is true
        	    data.rawstr = toString(keyinarray);
        		if(increase)
                switch(index){
                    case 1:is.allStep(keyinarray);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.allStep(keyinarray);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.allStep(keyinarray);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.allStep(keyinarray);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.allStep(keyinarray);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.allStep(keyinarray);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
                	}
        		else 
                switch(index){
                    case 1:is.Down_allStep(keyinarray);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.Down_allStep(keyinarray);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.Down_allStep(keyinarray);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.Down_allStep(keyinarray);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.Down_allStep(keyinarray);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.Down_allStep(keyinarray);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
                	}
        		data.size = keyinarray.size();
        	}
        	else{//number is false
                data.rawstr = toString(keyinarray1);
        		if(increase)
                switch(index){
                    case 1:is.allStep(keyinarray1);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.allStep(keyinarray1);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.allStep(keyinarray1);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.allStep(keyinarray1);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.allStep(keyinarray1);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.allStep(keyinarray1);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
        		}
        		else 
                switch(index){
                    case 1:is.Down_allStep(keyinarray1);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.Down_allStep(keyinarray1);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.Down_allStep(keyinarray1);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.Down_allStep(keyinarray1);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.Down_allStep(keyinarray1);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.Down_allStep(keyinarray1);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
        		}
        	
                data.size = keyinarray1.size();
        	}
    	}
    	else {
    		i=0;j=0;
            switch(index){
            case 1:is.j=1;is.programcounter=1;is.type=type; break;
            case 2:ss.j=1;ss.programcounter=1;ss.type=type;break;
            case 3:es.j=1;es.programcounter=1;es.i=0;es.type=type;break;
            case 4:bs.j=0;bs.programcounter=1;bs.i=0;bs.type=type;break;
            case 5:ms.j=1;ms.programcounter=1;ms.head = 0;ms.type=type;break;
            case 6:qs.left=0;qs.programcounter=1;qs.type=type;break;
            }
    		is.type=type;ss.type=type;es.type=type;bs.type=type;ms.type=type;

            data.rawstr = toString(keyinarray2);

    		if(increase)
                switch(index){
                    case 1:is.O_allStep(keyinarray2,judge);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.O_allStep(keyinarray2,judge);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.O_allStep(keyinarray2,judge);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.O_allStep(keyinarray2,judge);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.O_allStep(keyinarray2,judge);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.O_allStep(keyinarray2,judge);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
    		    }
        		else 
                switch(index){
                    case 1:is.O_Down_allStep(keyinarray2,judge);Aresult=is.result;is.result="";data.step=is.programcounter-1;data.sindex = is.step;break;
                    case 2:ss.O_Down_allStep(keyinarray2,judge);Aresult=ss.result;ss.result="";data.step=ss.programcounter-1;data.sindex = ss.step;break;
                    case 3:es.O_Down_allStep(keyinarray2,judge);Aresult=es.result;es.result="";data.step=es.programcounter-1;data.sindex = es.step;break;
                    case 4:bs.O_Down_allStep(keyinarray2,judge);Aresult=bs.result;bs.result="";data.step=bs.programcounter-1;data.sindex = bs.step;break;
                    case 5:ms.O_Down_allStep(keyinarray2,judge);Aresult=ms.result;ms.result="";data.step=ms.programcounter-1;data.sindex = ms.step;break;
                    case 6:qs.O_Down_allStep(keyinarray2,judge);Aresult=qs.result;qs.result="";data.step=qs.programcounter-1;data.sindex = qs.step;break;
        		}
        	data.size = keyinarray2.size();
    	}
        data.result = Aresult;
        System.out.println(Aresult);
        /*System.out.println(data.result);
        System.out.printf("%d %d\n",data.step,data.size);
        System.out.println();*/
        data.rearrange();
        data.torawarray();
       
        data.pickindex();
        index1=data.index1;
        index2=data.index2;
        
        System.out.println(Arrays.toString(data.index1));
        System.out.println(Arrays.toString(data.index2));

        data.searchrawindex();
        data.buildnrindex(index);
        data.searchnrindex();

        System.out.println();
        System.out.println(Arrays.toString(data.rawindex1));
        System.out.println(Arrays.toString(data.rawindex2));

        System.out.println();
        System.out.println(Arrays.toString(data.nrawindex1));
        System.out.println(Arrays.toString(data.nrawindex2));
        System.out.println();

        for(int i=0; i<data.step; i++){
            System.out.println(Arrays.toString(data.nrarray[i]));
        }

        size= data.size;
        step=data.step;
        keyinarray.clear();
        keyinarray1.clear();

    }

    public int previous() {
    	System.out.println("previous");	
    	System.out.println("step"+(i));
    	
    	return 	i-1;
    }

    public int next() {
        System.out.println("next");	
        System.out.println("step"+(i+1));	
        return 	i+1;
    }

    public String step() {
        System.out.println("Y");
        return 	data.data[i][j++];
    }

    public <T> String toString(ArrayList<T> array){
        int c=0;
        String rawstr="";
        DecimalFormat df = new DecimalFormat("0.######");
        for(T i:array){
            if(num_text && !object) rawstr+=""+df.format((double)i);
            else if(!num_text || object) rawstr+=""+i;

            if(c++<array.size()-1)
                rawstr+=" ";       //output a space between numbers, but don't output after the last number
        }
        return rawstr;
    }
   
}
