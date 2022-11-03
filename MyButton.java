import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.util.*;
import java.util.Timer;
public class MyButton{
//declaring and initializing the object 
    private JRadioButton jRadioButton=null;
    private JRadioButton jRadioButton1=null;
    private JRadioButton jRadioButton2=null;
    private JRadioButton jRadioButton3=null;
    private JRadioButton jRadioButton4=null;
    private JRadioButton jRadioButton5=null;
    private JRadioButton jRadioButton6=null;
    private ButtonGroup buttonGroup=null;
    private ButtonGroup buttonGroup1=null;
    private ButtonGroup buttonGroup2=null;
    private JTextField jTextField=null;
    private JTextArea jTextArea=null;
    private JButton jButton=null;
    private JButton jButton1=null;
    private JButton jButton2=null;
    private JButton jButton3=null;
    private JButton jButton4=null;
    private JButton jButton5=null;
    private JButton jButton6=null;
    private JButton jButton7=null;
    private JButton jButton8=null;
    private JButton jButton9=null;
    private Timer timer = new Timer();
    private JComboBox jComboBox=null;
    public JLabel box=null;
    public JLabel step=null;
    public JPanel jSub=null;
    public boolean repeat=true;
    public boolean m_f=true;
//declaring the object of Algorithm
    public Algorithm alg=new Algorithm();
    public FoodFrame fm=null;
    public AnimateFrame af = null;
//declaring the object of RandomNumber
    public RandomNumber rn = new RandomNumber();
// initializing MyButton and stop the most button at first
    public MyButton(){
        getJButton().setEnabled(false);
        getJButton1().setEnabled(false);
        getJButton2().setEnabled(false);
        getJButton3().setEnabled(false);
        getJButton4().setEnabled(false);
        getJButton5().setEnabled(false);
        getJButton6().setEnabled(false);
        getJButton7().setEnabled(false);
        getJButton8().setEnabled(false);
        getJButton9().setEnabled(false);
        getJRadioButton().setEnabled(false);
        getJRadioButton1().setEnabled(false);
        getJRadioButton2().setEnabled(false);
        getJRadioButton3().setEnabled(false);
        getJRadioButton4().setEnabled(false);
        getJRadioButton5().setEnabled(false);
        getJRadioButton6().setEnabled(false);
    
     }
//the method to creating a RadioButton to select the way of sequence
    public JRadioButton getJRadioButton(){
        if(jRadioButton==null){
            jRadioButton=new JRadioButton("Increasing",true);
            jRadioButton.setBackground(new Color(255,255,255));
            jRadioButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Increasing");
                alg.increase=true;
                jTextField.requestFocus();
                }
            });
        }
        return jRadioButton;
    }
    public JRadioButton getJRadioButton1(){
       if(jRadioButton1==null){
          jRadioButton1=new JRadioButton("Decreasing");
          jRadioButton1.setBackground(new Color(255,255,255));
          jRadioButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            System.out.println("Decreasing");
            alg.increase=false;
            jTextField.requestFocus();
            }
        });
       }
       return jRadioButton1;
    }

    public ButtonGroup getButtonGroup(){
        if(buttonGroup==null){
            buttonGroup=new ButtonGroup();
            buttonGroup.add(getJRadioButton());
            buttonGroup.add(getJRadioButton1());
        }
        return buttonGroup;
    }

//the method to creating a RadioButton to click the way to input
    public JRadioButton getJRadioButton2(){
        if(jRadioButton2==null){
            jRadioButton2=new JRadioButton("Manually",true);
            jRadioButton2.setBackground(new Color(255,255,255));
            jRadioButton2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Manually");
                m_f=true;
		getJButton6().setEnabled(true);
		jTextField.requestFocus();
                }
            });
        }
        return jRadioButton2;
    }
    public JRadioButton getJRadioButton3(){
        if(jRadioButton3==null){
            jRadioButton3=new JRadioButton("File");
            jRadioButton3.setBackground(new Color(255,255,255));
            jRadioButton3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                getJButton6().setEnabled(false);
                System.out.println("File");
                m_f=false;
                jTextField.requestFocus();
                }
            });
        }
        return jRadioButton3;
    }
    public ButtonGroup getButtonGroup1(){
        if(buttonGroup1==null){
            buttonGroup1=new ButtonGroup();
            buttonGroup1.add(getJRadioButton2());
            buttonGroup1.add(getJRadioButton3());
        }
        return buttonGroup1;
    }

//the method to creating a RadioButton to choose the type of data to sort
    public JRadioButton getJRadioButton4(){
        if(jRadioButton4==null){
            jRadioButton4=new JRadioButton("Number",true);
            jRadioButton4.setBackground(new Color(255,255,255));
            jRadioButton4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Number");
                alg.setInputData(true);
                alg.object=false;
                getJRadioButton2().setEnabled(true);
                getJRadioButton3().setEnabled(true);
                jTextField.requestFocus();
                }
            });
        }
        return jRadioButton4;
    }
    public JRadioButton getJRadioButton5(){
        if(jRadioButton5==null){
            jRadioButton5=new JRadioButton("Text");
            jRadioButton5.setBackground(new Color(255,255,255));
            jRadioButton5.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("TEXT");
                alg.setInputData(false);
                alg.object=false;
                getJRadioButton2().setEnabled(true);
                getJRadioButton3().setEnabled(true);
                jTextField.requestFocus();
                }
            });
        }
        return jRadioButton5;
    }
    public JRadioButton getJRadioButton6(){
        if(jRadioButton6==null){
            jRadioButton6=new JRadioButton("Object");
            jRadioButton6.setBackground(new Color(255,255,255));
            jRadioButton6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Object");
                alg.type=2;
                alg.object=true;
                getJRadioButton2().setEnabled(false);
                getJRadioButton3().setEnabled(false);
                jTextField.requestFocus();
                }
            });
        }
        return jRadioButton6;
    }
    public ButtonGroup getButtonGroup2(){
        if(buttonGroup2==null){
            buttonGroup2=new ButtonGroup();
            buttonGroup2.add(getJRadioButton4());
            buttonGroup2.add(getJRadioButton5());
            buttonGroup2.add(getJRadioButton6());
        }
        return buttonGroup2;
    }
   
    public JButton getJButton7() {
    	if(jButton7==null) {
    		jButton7=new JButton();
    		jButton7.setBounds(new Rectangle(650, 370, 60, 40));
            jButton7.setText("OK");
            jButton7.setBackground(new Color(211, 211, 211));
            jButton7.setBorder(BorderFactory.createLineBorder(Color.black,2));
    		jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if(alg.object) {
                		getOFrame();
                		
                		getJButton8().setEnabled(true);
                        getJButton3().setEnabled(true);
                        getJButton4().setEnabled(true);
                        getJButton2().setEnabled(true);
                        getJButton().setEnabled(true);
                		alg.keyinarray2=getOFrame().ff.F;
                		System.out.println(getOFrame().judge);
                		System.out.println("open");
                	}
                	else {
                		if(m_f) {getJButton().setEnabled(true);getJButton6().setEnabled(true);}
                    	else getJButton1().setEnabled(true);
                	}
                	
                	getJButton7().setEnabled(false);
                	getJButton5().setEnabled(true);
                	getJRadioButton().setEnabled(false);
                    getJRadioButton1().setEnabled(false);
                    getJRadioButton2().setEnabled(false);
                    getJRadioButton3().setEnabled(false);
                    getJRadioButton4().setEnabled(false);
                    getJRadioButton5().setEnabled(false);
                    getJRadioButton6().setEnabled(false);
                }
            });
    	}
    	  	
    	return jButton7;
    }
    public FoodFrame getOFrame() {
    	if(fm==null) {
    		fm=new FoodFrame();
    		
    	}
    	return fm;
    }

    public JButton getJButton9(){
        if(jButton9==null){
            jButton9=new JButton();
            jButton9.setBounds(new Rectangle(450, 370, 80, 40));
            jButton9.setText("Anime");
            jButton9.setBackground(new Color(255, 40, 148));
            jButton9.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AnimateFrame af = new AnimateFrame();
                    af.dd = alg.data;
                    af.object = alg.object;
                    af.sorttype = alg.index;
                    af.initialize();
                    jTextField.requestFocus();
                }
            });
        }

        return jButton9;
    }

// the method of setting up the box to select which Sort you want to use

    public JComboBox getJComboBox(){
        if(jComboBox==null){
            String[] list={"---------------SELECT---------------","Insertion Sort","Selection Sort","Exchange Sort","Bubble Sort","Merge Sort","Quick Sort"};
            jComboBox=new JComboBox(list);
            jComboBox.setBackground(new Color(229, 231, 233));
            jComboBox.setBorder(BorderFactory.createLineBorder(Color.black,1));
            jComboBox.setBounds(650,100,200,25);
            // the action when you click
            jComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	fm=null;
                    System.out.println(jComboBox.getSelectedIndex());
                    alg.setSort(jComboBox.getSelectedIndex());
                    switch (jComboBox.getSelectedIndex()){
                        case 1:jTextArea.append("Insertion Sort\n\n");break;
                        case 2:jTextArea.append("Selection Sort\n\n");break;
                        case 3:jTextArea.append("Exchange Sort\n\n");break;
                        case 4:jTextArea.append("Bubble Sort\n\n");break;
                        case 5:jTextArea.append("Merge Sort\n\n");break;
                        case 6:jTextArea.append("Quick Sort\n\n");break;
                    }
            if(jComboBox.getSelectedIndex()!=0){          
                
            	getJButton().setEnabled(false);
                getJButton1().setEnabled(false);
                getJRadioButton().setEnabled(true);
                getJRadioButton1().setEnabled(true);
                getJRadioButton2().setEnabled(true);
                getJRadioButton3().setEnabled(true);
                getJRadioButton4().setEnabled(true);
                getJRadioButton5().setEnabled(true);
                getJRadioButton6().setEnabled(true);
                getJButton7().setEnabled(true);
                getJButton2().setEnabled(false);
                getJButton3().setEnabled(false);
                getJButton4().setEnabled(false);
                getJButton8().setEnabled(false);
            }
            else{
                getJButton().setEnabled(false);
                getJButton1().setEnabled(false);
                getJButton2().setEnabled(false);
                getJButton3().setEnabled(false);
                getJButton4().setEnabled(false);
                getJButton6().setEnabled(false);
                getJRadioButton().setEnabled(false);
                getJRadioButton1().setEnabled(false);
                getJRadioButton2().setEnabled(false);
                getJRadioButton3().setEnabled(false);
                getJRadioButton4().setEnabled(false);
                getJRadioButton5().setEnabled(false);
                getJRadioButton6().setEnabled(false);
                getJButton7().setEnabled(false);
            }
                    jTextField.requestFocus();
                }
            });
        }
        return jComboBox;
    }

// the method for creating an area to output the process
    public JTextArea getJTextArea(){
        if(jTextArea==null){
            jTextArea=new JTextArea();
            jTextArea.setLineWrap(true);// making line wrap
            jTextArea.setText("Please choose the sort method before inputting your data\n");
            jTextArea.setEditable(false);
            jTextArea.setVisible(false);
            Font f = new Font("Ariel", Font.PLAIN, 16);
            jTextArea.setFont(f);
        }
        return jTextArea;
    }
// the method for creating a textfield to input the data
    public JTextField getJTextField(){
        if(jTextField==null){
            jTextField=new JTextField();
            jTextField.setBorder(new EmptyBorder(2,2,2,2));
            Font f = new Font("Ariel", Font.PLAIN, 16);
            jTextField.setFont(f);
            jTextField.requestFocus();
            jTextField.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    String temp = jTextField.getText();
                    if (temp.equals("Welcome! Please input your data here!")) {
                        jTextField.setText("");
                        jTextField.setForeground(Color.BLACK);
                    }
                }
                public void focusLost(FocusEvent e) {
                    String temp = jTextField.getText();
                    if (temp.equals("")) {
                        jTextField.setForeground(Color.GRAY);
                        jTextField.setText("Welcome! Please input your data here!");
                    }
                }
            });
        }
        return jTextField;
    }
    
//Enter: inputting the data manually
    public JButton getJButton(){
        if(jButton==null){
            jButton=new JButton();
            jButton.setBounds(new Rectangle(525,20,80,48));
            jButton.setText("Enter");
            jButton.setForeground(Color.black);
            jButton.setBackground(new Color(255, 128, 0));
            jButton.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	alg.in=jTextField.getText();
                    alg.setManuallyInput();
                	if(alg.object) {alg.judge=fm.judge;jTextField.setText(""+alg.keyinarray2);}
                	else jTextField.setText(alg.in);
                    alg.allStep();
                    fm=null;
                    
                    jTextField.setForeground(Color.GRAY);
                    jTextArea.append("Manual Input\nInitial sequence\n"+alg.in+"\n\n");
                    getJButton8().setEnabled(true);
                    getJButton3().setEnabled(true);
                    getJButton4().setEnabled(true);
                    getJButton2().setEnabled(true);
                    getJButton9().setEnabled(true);
                    getJButton().setEnabled(false);
                    jTextField.requestFocus();
                }
            });
        }
        return jButton;
    }
//File: inputting the data in file
    public JButton getJButton1(){
        if(jButton1==null){
            jButton1=new JButton();
            jButton1.setBounds(new Rectangle(650,20,80,48));
            jButton1.setText("File");
            jButton1.setBackground(new Color(255, 224, 0));
            jButton1.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFileChooser chooser = new JFileChooser("./");
                    chooser.showOpenDialog(null);
                    File selectFile = chooser.getSelectedFile();
                    String text1;
                    text1= selectFile.getPath();
                    alg.text=text1;
                    alg.setFileInput();
                    alg.allStep();
                    jTextField.setText(alg.in);
                    jTextArea.append("Import file from-> "+alg.text+"\nInitial sequence\n"+alg.in+"\n\n");
                    jTextField.requestFocus();
                    getJButton2().setEnabled(true);
                    getJButton3().setEnabled(true);
                    getJButton4().setEnabled(true);
                    getJButton8().setEnabled(true);
                    getJButton9().setEnabled(true);
                }
            });
        }
        return jButton1;
    }
    
//Next: outputting the next step
    public JButton getJButton2(){
        if(jButton2==null){
            jButton2=new JButton();
            jButton2.setBounds(new Rectangle(515,100,90,45));
            jButton2.setText("Next");
            jButton2.setBackground(new Color(163, 228, 215));
            jButton2.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	show_Liner_Next();
                    jTextField.requestFocus();
                }
            });
        }
        return jButton2;
    }

    
    public JPanel getJSub(){
        if(jSub==null){
            jSub=new JPanel();
            jSub.setBackground(new Color(255, 255, 255));
            
        }
        return jSub;
    }
  //Result: outputting the final result
    public JButton getJButton4(){
        if(jButton4==null){
            jButton4=new JButton();
            jButton4.setBackground(new Color(215, 189, 226));
            jButton4.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton4.setBounds(new Rectangle(212,100,90,45));
            jButton4.setText("Previous");
            jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	show_Liner_Previous();
                    jTextField.requestFocus();
                }
            });
        }
        return jButton4;
    }
    
//START: outputting the all step
    public JButton getJButton3(){
        if(jButton3==null){
            jButton3=new JButton();
            jButton3.setBackground(new Color(174, 214, 241));
            jButton3.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton3.setBounds(new Rectangle(314,100,90,45));
            jButton3.setText("Start");
            jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    t_Work(true);
                    
                    jTextArea.append(alg.Aresult);
                    jTextField.requestFocus();
                }
            });
        }
        return jButton3;
    }

  //All: outputting the all step
    public JButton getJButton8(){
        if(jButton8==null){
            jButton8=new JButton();
            jButton8.setBackground(new Color(144, 233, 251));
            jButton8.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton8.setBounds(new Rectangle(415,100,90,45));
            jButton8.setText("Stop");
            jButton8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	t_Work(false);
                	jTextField.requestFocus();
                }
            });
        }
        return jButton8;
    }

//Clear: refrashing the content in Textarea
    public JButton getJButton5(){
        if(jButton5==null){
            jButton5=new JButton();
            jButton5.setBackground(new Color(229, 152, 102));
            jButton5.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton5.setBounds(new Rectangle(20,370,80,40));
            jButton5.setText("Clear");
            jButton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jTextArea.setText("Please choose the sort method before inputting your data\n");
                    switch (jComboBox.getSelectedIndex()){
                        case 1:jTextArea.append("Insertion Sort\n\n");break;
                        case 2:jTextArea.append("Selection Sort\n\n");break;
                        case 3:jTextArea.append("Exchange Sort\n\n");break;
                    }
                    t_Work(false);
                    getJSub().removeAll();
                    getJSub().setVisible(false);
                    getJSub().setVisible(true);
                    getJButton8().setEnabled(false);
                    getJButton3().setEnabled(false);
                    getJButton4().setEnabled(false);
                    getJButton2().setEnabled(false);
                    getJButton6().setEnabled(false);
                    getJButton9().setEnabled(false);
                    getJButton1().setEnabled(false);
                    getJButton().setEnabled(false);
                    getJTextField().setText("");
                    jTextField.requestFocus();
                }
            });
        }
        return jButton5;
    }
//Random: to generate a random string for input
    public JButton getJButton6(){
        if(jButton6==null){
            jButton6 = new JButton();
            jButton6.setBackground(new Color(241, 148, 138));
            jButton6.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton6.setBounds(new Rectangle(20,100,90,45));
            jButton6.setText("Random");
            JPanel myPanel = new JPanel();
            JTextField first_range = new JTextField(5);
            JTextField last_range = new JTextField(5);
            myPanel.add(new JLabel("Min:"));
            myPanel.add(first_range);
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Max:"));
            myPanel.add(last_range);
            jButton6.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String st_Inputsize= JOptionPane.showInputDialog(null,"Please input size");
                    rn.total = Integer.parseInt(st_Inputsize);
                    int range = JOptionPane.showConfirmDialog(null,myPanel,"Please input range",JOptionPane.OK_CANCEL_OPTION);
                    if (range == JOptionPane.OK_OPTION) {
                        String r1 = first_range.getText();
                        String r2 = last_range.getText();
                        rn.min = Integer.parseInt(r1);
                        rn.max = Integer.parseInt(r2);
                        rn.randomresult = "";
                        rn.produce();
                        jTextField.setText(rn.randomresult);
                        jTextField.setForeground(Color.BLACK);
                    }
                    else if(range == JOptionPane.CANCEL_OPTION){
                        rn.randomresult = "";
                    }
                    jTextField.requestFocus();
                }
            });
        }
        return jButton6;
    }
    
    public void show_Liner_Next() {
    	getJSub().removeAll();
    	Font f = new Font("", Font.BOLD, 25);
    	
    	if(alg.next()==alg.step) {
    		step=new JLabel("Final Result : ");
    		timer.cancel();
    		repeat=true;
    		
    	}
    	else 
    		step=new JLabel("Step "+alg.next()+" : ");
    	
    	if(alg.next()<=alg.step) {
    	getJSub().add(step);
    	step.setFont(f);
    	for(int i=0;i<alg.size;i++) {
    	box=new JLabel(" "+alg.step()+" ");
    	box.setFont(f);
    	if(alg.index1[alg.i]-1==i||alg.index2[alg.i]-1==i)
        box.setBorder(BorderFactory.createLineBorder(Color.red,2)); 
        else
    	box.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
    	getJSub().add(box);
    	}
    	getJSub().setVisible(false);
    	getJSub().setVisible(true);
    	if(alg.next()!=alg.step)
    	alg.i++;
    	alg.j=0;
    	}
    	
    	
    }
    
    public void show_Liner_Previous() {
    	getJSub().removeAll();
    	Font f = new Font("", Font.BOLD, 25);
    	if(alg.previous()==alg.step-1)
    		step=new JLabel("Final Result : ");
    	else if(alg.previous()>=0)
    		step=new JLabel("Step "+(alg.previous()+1)+" : ");
    	else 
    		step=new JLabel("Step "+(alg.previous()+2)+" : ");
    	if(alg.previous()>=0) {   	
    	alg.i--;
    	getJSub().add(step);
    	step.setFont(f);
    	for(int i=0;i<alg.size;i++) {
    	box=new JLabel(" "+alg.step()+" ");
    	box.setFont(f);
    	if(alg.index1[alg.i]-1==i||alg.index2[alg.i]-1==i)
        box.setBorder(BorderFactory.createLineBorder(Color.red,2)); 
        else
    	box.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
    	getJSub().add(box);
    	}
    	getJSub().setVisible(false);
    	getJSub().setVisible(true);
    	
    	alg.j=0;
    	}
    	else {
    		
    		System.out.println("TWO");
        	getJSub().add(step);
        	step.setFont(f);
        	for(int i=0;i<alg.size;i++) {
        	box=new JLabel(" "+alg.step()+" ");
        	box.setFont(f);
        	if(alg.index1[alg.i]-1==i||alg.index2[alg.i]-1==i)
            box.setBorder(BorderFactory.createLineBorder(Color.red,2)); 
            else
        	box.setBorder(BorderFactory.createLineBorder(Color.black,2)); 
        	getJSub().add(box);
        	}
        	getJSub().setVisible(false);
        	getJSub().setVisible(true);
        	alg.i++;
        	alg.j=0;
    	}
        jTextField.requestFocus();
    }
    
    public void t_Work(boolean b) {
    	
    	
    	if(b&&repeat&&alg.next()<alg.step) {
    	 timer = new Timer();
    	Task task=new Task();
    	timer.scheduleAtFixedRate(task, 1000, 1000);
    	repeat=false;
    	}
    	else if(!b&&!repeat){
    	timer.cancel();
    	repeat=true;
    	}
    }
   
    public class Task extends TimerTask{
    	
		@Override
		public void run() {
			show_Liner_Next();
		}
    }
    
}