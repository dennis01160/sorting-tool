import java.util.*;
import java.io.*;
import java.lang.Object;

public class Input {
    //declaring the variable
    public String keyin;
    public ArrayList<Double> keyinarray = new ArrayList<Double>();
    public ArrayList<String> keyinarray1 = new ArrayList<String>();
    public ArrayList<Food> keyinarray2 = new ArrayList<Food>();
    //public String[] s_keyinarray;
    public String filename;
    public int type;
    //initializing Input()
    public Input(){
        filename = "text2.txt";
        type=0;
        
    }

    public void manualInput(){          //key in the number string manually
        inputArray();
    }

    public void fileInput(){           //key in the number string by importing files
        Scanner inputfile = null;
        try{
            inputfile = new Scanner(new FileInputStream(filename));
        }
        catch (FileNotFoundException e){
            System.out.println("File was not found or could not be opened.");
            System.exit(0);
        }
        keyin = inputfile.nextLine();

        inputArray();
    }

    public void inputArray(){      //to change the String into Integer, and then store it into the array after judged
        StringTokenizer st = new StringTokenizer(keyin, " ");
        while(st.hasMoreTokens()){
            String next = st.nextToken();
            //if(judgeChar(next)) keyinarray.add(next);
            switch(type){
                case 0: {
                    if (judgeNum(next)) keyinarray.add(Double.parseDouble(next));
                    break;
                }
                case 1:{
                    if(judgeChar(next)) keyinarray1.add(next);
                    break;
                }
            }
        }
    }

/*    public void s_inputArray(){      //to change the String into Integer, and then store it into the array after judged
        StringTokenizer st1 = new StringTokenizer(keyin, " ");
        while(st1.hasMoreTokens()){
            if(judgeChar(st1.nextToken()))
                counter++;
        }
        s_keyinarray = new String[counter];
        StringTokenizer st2 = new StringTokenizer(keyin, " ");
        for(int i=0; i<counter; ){
            String nextStr = st2.nextToken();
            if(judgeChar(nextStr)){
                s_keyinarray[i] = nextStr;
                i++;
            }
        }
        counter = 0;
    }*/

    public boolean judgeNum(String nn){     //to judge if the token is a number, if not, omit it
        for(int i=0; i<nn.length(); i++){
            if(nn.charAt(i)!='0'&&nn.charAt(i)!='1'&&nn.charAt(i)!='2'&&nn.charAt(i)!='3'&&
               nn.charAt(i)!='4'&&nn.charAt(i)!='5'&&nn.charAt(i)!='6'&&nn.charAt(i)!='7'&&
               nn.charAt(i)!='8'&&nn.charAt(i)!='9'&&nn.charAt(i)!='-'&&nn.charAt(i)!='.') return false;
        }
        return true;
    }

    public boolean judgeChar(String nn){     //to judge if the token is a char, if not, omit it
        for(int i=0; i<nn.length(); i++){
            if(nn.charAt(i)<33||nn.charAt(i)>126) return false;
        }
        return true;
    }
}
