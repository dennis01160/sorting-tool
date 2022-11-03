import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class FoodFrame extends JFrame {
	public int judge;
	JPanel p = null;
	JButton b = null;
	JButton jButton=null;
	JRadioButton jRadioButton=null;
    JRadioButton jRadioButton1=null;
    JRadioButton jRadioButton2=null;
    ButtonGroup buttonGroup=null;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel jSubPanel=null;
	boolean m = false;
	boolean f = false;
	JTextField food_name = null;
	JTextField food_price = null;
	JTextField food_calories = null;
	FoodFactory ff = new FoodFactory();
	
	public FoodFrame(){
		initialize();
		judge=1;
	}
	
	public void initialize(){
		this.setBounds(300,100,335,300);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public JPanel getPanel1(){
		panel1.removeAll();
		panel1.setBounds(500,300,350,200);
		JRadioButton b1 = new JRadioButton("manualInput");
		JRadioButton b2 = new JRadioButton("fileInput");
		
		ItemListener type = new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==e.SELECTED){
					if(e.getSource()== b1){
						m = true;
						f = false;
					}
					if(e.getSource()== b2){
						f = true;
						m = false;
					}
				}
			}
		};
		
        b1.addItemListener(type);
        b2.addItemListener(type);
		
		b1.setBounds(100,50,100,50);
		b2.setBounds(210,50,100,50);
		ButtonGroup group = new ButtonGroup();
		group.add(b1);
		group.add(b2);
		panel1.add(b1);
		panel1.add(b2);
		
		panel1.revalidate();
		panel1.repaint();
		return panel1;
	}
	
	public JPanel getPanel2(){
		panel2.removeAll();
		panel2.setBounds(500,300,400,300);
		JLabel a1 = new JLabel("Name: ");
		JLabel a2 = new JLabel("Price: ");
		JLabel a3 = new JLabel("Calories: ");
		food_name = new JTextField(20);
		food_price = new JTextField(20);
		food_calories = new JTextField(20);
		panel2.setLayout(new GridLayout(3,2));
		panel2.add(a1);
		panel2.add(food_name);
		panel2.add(a2);
		panel2.add(food_price);
		panel2.add(a3);
		panel2.add(food_calories);
		
		panel2.revalidate();
		panel2.repaint();
		return panel2;
	}
	
	public JButton getButton(){
		if(b == null){
			b = new JButton();
			b.setBounds(new Rectangle(100,30,125,50));
			b.setText("create object");
			
            b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int choose = JOptionPane.showConfirmDialog(null,getPanel1(),"please choose a data input type",JOptionPane.OK_CANCEL_OPTION);
					if (choose == JOptionPane.OK_OPTION) {
						if(m==true){
							int input = JOptionPane.showConfirmDialog(null,getPanel2(),"input attributes",JOptionPane.OK_CANCEL_OPTION);
							if (input == JOptionPane.OK_OPTION){
								String r1 = food_name.getText();
								String r2 = food_price.getText();
								String r3 = food_calories.getText();
								ff.create(r1.trim(),Integer.parseInt(r2.trim()),Double.parseDouble(r3.trim()));
								
								//print object------test only
							/*	for(int i=0;i<ff.F.size();i++){
									String name = ff.F.get(i).name;
									Integer price = ff.F.get(i).price;
									Double calories = ff.F.get(i).calories;
									System.out.print(name +" "+price+" "+calories+"\n");
									System.out.println(ff.F.get(i).toString());
									name = "";
									price = 0;
									calories = 0.0;
								}*/
								System.out.println();
								//-------------------
								food_name.setText("");
								food_price.setText("");
								food_calories.setText("");
							}
						}
						else if(f==true){
							JFileChooser chooser = new JFileChooser(".\\");
							chooser.showOpenDialog(null);
							File selectFile = chooser.getSelectedFile();
							String text;
							text= selectFile.getPath();
							try{
								Scanner inputfile = new Scanner(new FileInputStream(text));
								while(inputfile.hasNextLine()){
									String s1 = inputfile.next();
									String s2 = inputfile.next();
									String s3 = inputfile.next();
									ff.create(s1.trim(),Integer.parseInt(s2.trim()),Double.parseDouble(s3.trim()));
								}
								//print object----test only----
								for(int i=0;i<ff.F.size();i++){
									String name2 = ff.F.get(i).name;
									Integer price2 = ff.F.get(i).price;
									Double calories2 = ff.F.get(i).calories;
									System.out.print(name2 +" "+price2+" "+calories2+"\n");
									System.out.println(ff.F.get(i).toString());
									name2 = "";
									price2 = 0;
									calories2 = 0.0;
								}
								System.out.println();
								//--------------------
							}							
							catch (FileNotFoundException z){
								System.out.println("File was not found or could not be opened.");
							}
						}						
					}					
				}
			});
		}
		return b;
	}
	
	
	//the method to creating a RadioButton to select the way of sequence
    public JRadioButton getJRadioButton(){
        if(jRadioButton==null){
            jRadioButton=new JRadioButton("Name",true);
            jRadioButton.setBackground(new Color(255,255,255));
            jRadioButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Name");
                judge=1;
                }
            });
        }
        return jRadioButton;
    }
    public JRadioButton getJRadioButton1(){
       if(jRadioButton1==null){
          jRadioButton1=new JRadioButton("Price");
          jRadioButton1.setBackground(new Color(255,255,255));
          jRadioButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            System.out.println("Price");
            judge=2;
            }
        });
       }
       return jRadioButton1;
    }
    
    public JRadioButton getJRadioButton2(){
        if(jRadioButton2==null){
            jRadioButton2=new JRadioButton("Calories");
            jRadioButton2.setBackground(new Color(255,255,255));
            jRadioButton2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                System.out.println("Calories");
                judge=3;
                }
            });
        }
        return jRadioButton2;
    }
    
    
    public ButtonGroup getButtonGroup(){
        if(buttonGroup==null){
            buttonGroup=new ButtonGroup();
            buttonGroup.add(getJRadioButton());
            buttonGroup.add(getJRadioButton1());
            buttonGroup.add(getJRadioButton2());
        }
        return buttonGroup;
    }
	
    private JPanel getSubJPanel(){
        if(jSubPanel==null){
            jSubPanel=new JPanel();
            jSubPanel.setBackground(new Color(255, 255, 255));
            jSubPanel.setBounds(60,100, 200, 55);
            jSubPanel.add(getJRadioButton(),null);
            jSubPanel.add(getJRadioButton1(),null);
            jSubPanel.add(getJRadioButton2(),null);
            getButtonGroup();
        }
        return jSubPanel;
    }
	
    public JButton getJButton(){
        if(jButton==null){
            jButton=new JButton();
            jButton.setBounds(new Rectangle(120,180,80,40));
            jButton.setText("Finish");      
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	closeThis();
                	
                }
            });
        }
        return jButton;
    }
    public void closeThis() {this.dispose();}
	
	public JPanel getJContentPane(){
		if(p==null){
			p = new JPanel();
			p.setLayout(null);
			p.add(getSubJPanel(),null);
			p.add(getButton(),null);
			p.add(getJButton(),null);
		}
		return p;
	}
	
	
	
	
}