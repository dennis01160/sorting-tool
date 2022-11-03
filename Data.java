import java.util.*;

public class Data {
    public String result;
    public String sindex;
    public int step;
    public int size;
    public String[][] data;
    public int[] index1;
    public int[] index2;
    public int[] rawindex1;
    public int[] rawindex2;
    public String rawstr;
    public String[] rawarray;
    public int[][] nrarray;
    public int[] nrawindex1;
    public int[] nrawindex2;
    
    public Data(){}

    public void rearrange(){
        data = new String[step][size];
        StringTokenizer st = new StringTokenizer(result, "\n");
        for(int i=0; i<step; i++){
            String datastr = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(datastr, "  ");
            for(int j=0; j<size; j++){
                data[i][j] = st2.nextToken();
            }
        }
    }
    
    public void pickindex() {
    	index1 = new int[step];
    	index2 = new int[step];
        StringTokenizer st = new StringTokenizer(sindex, "\n");
        for(int i=0; i<step; i++){
            String datastr = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(datastr, " ");
            index1[i] =Integer.parseInt(st2.nextToken());
            index2[i] =Integer.parseInt(st2.nextToken());
        }
    }

    public void torawarray(){
        rawarray = new String[size];
        StringTokenizer st = new StringTokenizer(rawstr, " ");
        for(int i=0; i<size; i++){
            rawarray[i] = st.nextToken();
        }
    }

    public void searchrawindex(){
        rawindex1 = new int[step];
        rawindex2 = new int[step];
        rawindex1[0] = index1[0]-1;
        rawindex2[0] = index2[0]-1;
        for(int i=1; i<step; i++){
            String search1 = data[i-1][index1[i]-1];
            String search2 = data[i-1][index2[i]-1];
            for(int j=0; j<size; j++){
                if(search1.compareTo(rawarray[j])==0){
                    rawindex1[i] = j;
                }
                if(search2.compareTo(rawarray[j])==0){
                    rawindex2[i] = j;
                }
            }
        }
    }

    public void buildnrindex(int index){
        nrarray = new int[step][size];
        int[] raw = new int[size];
        for(int i=0; i<size; i++){
            raw[i] = i;
        }
        for(int i=0; i<step; i++){
            if(judgelastline(i)){
                if(index ==1) raw = insert(raw, index1[i]-1, index2[i]-1);
                else raw = swap(raw, index1[i]-1, index2[i]-1);
            }
            for(int j=0; j<size; j++){
                nrarray[i][j] = raw[j];
            }
        }
    }

    public void searchnrindex(){
        nrawindex1 = new int[step];
        nrawindex2 = new int[step];
        for(int i=0; i<step; i++){
            nrawindex2[i] = nrarray[i][index1[i]-1];
            nrawindex1[i] = nrarray[i][index2[i]-1];
        }
    }

    public int[] swap(int[] array, int a, int b){
        int buf = array[a];
        array[a] = array[b];
        array[b] = buf;
        return array;
    }

    public int[] insert(int[] array, int a, int b){
        int insert = array[a];
        for(int i=a-1; i>=b; i--){
            array[i+1] = array[i];
        }
        array[b] = insert;
        return array;
    }

    public boolean judgelastline(int ai){
        boolean change=false;
        if(ai==0){
            for(int i=0; i<size; i++){
                if(!(data[ai][i].equals(rawarray[i]))) change=true;
            }
        }
        else{
            for(int i=0; i<size; i++){
                if(!(data[ai][i].equals(data[ai-1][i]))) change=true;
            }
        }
        return change;
    }
}
