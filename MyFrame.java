import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.color.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MyFrame extends JFrame{ 

//declaring and initializing the object 
    private JScrollPane jScrollPane=null;
    private JScrollPane jScrollPane1=null;
    private JScrollPane jScrollPane2=null;
	private JPanel jContentPane=null;
    private JPanel jSubPanel=null;
    private JPanel jSubPanel1=null;
    private JPanel jSubPanel2=null;
    private JMenu jMenu=null;
    private JMenu jMenu1=null;
    private JMenu jMenu2=null;
    private JMenuItem jMenuItem = null;
    private JMenuItem jMenuItem1 = null;
    public JMenuBar jMenuBar=null;
  //declaring the object of MyButton   
	public MyButton mb=new MyButton();
// initializing MyFrame
    public MyFrame(){
        super();
        initialize();
    }
//the method for initializing MyFrame & modifying the whole frame 
    private void initialize(){
        this.setBounds(300,30,900,510);
        this.setTitle("ATM(Algorithm-Tutorial Machine)");
        this.setContentPane(getJContentPane());
       // this.setJMenuBar(getJMenuBar());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
 //

// the panel that this is the place to put "Increasing" "Decreasing" button in
    private JPanel getSubJPanel(){
        if(jSubPanel==null){
            jSubPanel=new JPanel();
            jSubPanel.setBackground(new Color(255, 255, 255));
            jSubPanel.setBorder(BorderFactory.createTitledBorder("Which sequence do you want"));
            jSubPanel.setBounds(650, 295, 200, 55);
            jSubPanel.add(mb.getJRadioButton(),null);
            jSubPanel.add(mb.getJRadioButton1(),null);
            mb.getButtonGroup();
        }
        return jSubPanel;
    }
 // the panel that this is the place to put "Manually" "File" button in
    private JPanel getSubJPanel1(){
        if(jSubPanel1==null){
            jSubPanel1=new JPanel();
            jSubPanel1.setBackground(new Color(255, 255, 255));
            jSubPanel1.setBorder(BorderFactory.createTitledBorder("Which Input do you want"));
            jSubPanel1.setBounds(650, 233, 200, 55);
            jSubPanel1.add(mb.getJRadioButton2(),null);
            jSubPanel1.add(mb.getJRadioButton3(),null);
            mb.getButtonGroup1();
        }
        return jSubPanel1;
    }
 // the panel that this is the place to put "Number" "Text" button in
    private JPanel getSubJPanel2(){
        if(jSubPanel2==null){
            jSubPanel2=new JPanel();
            jSubPanel2.setBackground(new Color(255, 255, 255));
            jSubPanel2.setBorder(BorderFactory.createTitledBorder("Which type of data do you want"));
            jSubPanel2.setBounds(650, 135, 200, 90);
            jSubPanel2.add(mb.getJRadioButton4(),null);
            jSubPanel2.add(mb.getJRadioButton5(),null);
            jSubPanel2.add(mb.getJRadioButton6(),null);
            mb.getButtonGroup2();
        }
        return jSubPanel2;
    }

//the method for creating a Menubar & importing the menu in bar
    public JMenuBar getJMenuBar(){
        if(jMenuBar==null){
            jMenuBar=new JMenuBar();
            jMenuBar.add(getJMenu());
         //   jMenuBar.add(getJMenu1());
        //    jMenuBar.add(getJMenu2());
//if you want to set up a submenu ,you can use this way--->  jMenuBar.add(menu).add(submenu);       
        }
        return jMenuBar;
    }
// the method of setting up the menu and you can set up the actionlistenr in this  
    
	private JMenu getJMenu(){
        if(jMenu==null){
            jMenu=new JMenu("File");
            jMenu.setFont(new Font("", Font.BOLD, 14));
	        jMenu.add(getJMenuItem());
	        jMenu.add(getJMenuItem1());
        }
        return jMenu;
	}
// the method of setting how to saving the textarea
	private JMenuItem getJMenuItem(){
		if(jMenuItem == null){
			jMenuItem = new JMenuItem("Save");
			jMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JFileChooser Fc = new JFileChooser(new File("c:\\"));
					Fc.setDialogTitle("Save as");
					Fc.setFileFilter(new FileTypeFilter(".txt","Text Documents"));
					int result = Fc.showSaveDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						String content = mb.getJTextArea().getText();
						File F = Fc.getSelectedFile();
						try {
							FileWriter Fw=new FileWriter(F.getPath());
							Fw.write(content);
							Fw.flush();
							Fw.close();
						}catch(Exception e2){
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}
					}
				}
			});
		}
		return jMenuItem;
    }
	// the method of setting how to open a text file and put data in textarea	
	private JMenuItem getJMenuItem1(){
		if(jMenuItem1 == null){
			jMenuItem1 = new JMenuItem("Open");
			jMenuItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					JFileChooser Fc = new JFileChooser(new File("c:\\"));
					Fc.setDialogTitle("Open...");
					Fc.setFileFilter(new FileTypeFilter(".txt","Text Documents"));
					int result = Fc.showOpenDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						try {
							File F = Fc.getSelectedFile();
							BufferedReader Br = new BufferedReader(new FileReader(
									F.getPath()));
							String line = "";
							String s = "";
							while((line = Br.readLine()) != null) {
								s+=line+"\n";
							}
							mb.getJTextArea().setText(s);
							if(Br != null)
								Br.close();
						}catch(Exception e2){
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}
					}
				}
			});
		}
		return jMenuItem1;
    }
// Edit menu is useless temporarily
    private JMenu getJMenu1(){
        if(jMenu1==null){
            jMenu1=new JMenu("Edit");
            jMenu1.setFont(new Font("", Font.BOLD, 14));
        }
        return jMenu1;
    }
 // Setting menu is useless temporarily
    private JMenu getJMenu2(){
        if(jMenu2==null){
            jMenu2=new JMenu("Setting");
            jMenu2.setFont(new Font("", Font.BOLD, 14));
        }
        return jMenu2;
    }
    
 // the method for setting up the textfield to avoid the data too long to watch the data
    public JScrollPane getJScrollPane(){
        if(jScrollPane==null){
            jScrollPane = new JScrollPane(mb.getJTextArea());
            jScrollPane.setVisible(false);
            jScrollPane.setBounds(new Rectangle(20,150,600,300));
            jScrollPane.setBorder(new EmptyBorder(2,2,2,2));
            
            jScrollPane.setBackground(Color.BLACK);
        }
        return jScrollPane;
    }

 // the method for setting up the textarea to avoid the data too long to watch the data
    public JScrollPane getJScrollPane1(){
        if(jScrollPane1==null){
            jScrollPane1 = new JScrollPane(mb.getJTextField());
            jScrollPane1.setBounds(new Rectangle(20,20,500,50));
            jScrollPane1.setBorder(new EmptyBorder(2,2,2,2));
            jScrollPane1.setBackground(Color.BLACK);
        }
        return jScrollPane1;
    }
//
    public JScrollPane getJScrollPane2(){
        if(jScrollPane2==null){
            jScrollPane2 = new JScrollPane(mb.getJSub());
            jScrollPane2.setBounds(new Rectangle(20, 200, 600, 150));
            jScrollPane2.setBorder(new EmptyBorder(2,2,2,2));
            jScrollPane2.setBackground(Color.BLACK);
        }
        return jScrollPane2;
    }
// the method of loading all object to contentpane
    private JPanel getJContentPane(){
        
        if(jContentPane==null){
            jContentPane=new JPanel();
            jContentPane.setBackground(new Color(255, 243, 199));
            jContentPane.setLayout(null);
            jContentPane.add(getJScrollPane(), null);
            jContentPane.add(getJScrollPane1(), null);
            jContentPane.add(getJScrollPane2(), null);
            jContentPane.add(mb.getJButton(), null);
            jContentPane.add(mb.getJButton1(), null);
            jContentPane.add(mb.getJButton2(), null);
            jContentPane.add(mb.getJButton3(), null);
            jContentPane.add(mb.getJButton4(), null);
            jContentPane.add(mb.getJButton5(), null);
            jContentPane.add(mb.getJButton6(), null);
            jContentPane.add(mb.getJButton7(), null);
            jContentPane.add(mb.getJButton8(), null);
            jContentPane.add(mb.getJButton9(), null);
            jContentPane.add(mb.getJComboBox(),null);
            jContentPane.add(getSubJPanel(),null);
            jContentPane.add(getSubJPanel1(),null);
            jContentPane.add(getSubJPanel2(),null);
            
        }
        return jContentPane;
    }
}
