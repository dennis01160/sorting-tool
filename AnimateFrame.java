import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import javax.swing.Timer;

public class AnimateFrame extends JFrame {
    Data dd = new Data();
    JPanel panel = null;
    JPanel anime = null;
    private JButton jButton=null;
    private JButton jButton1=null;
    private JButton jButton2=null;
    private JButton jButton3=null;
    private JButton jButton4=null;
    private JButton jButton5=null;
    private JButton jButton6=null;
    //private JButton jButton7=null; //delete in final
    private Timer timer = null;
    public int ai;
    public int aj;
    public int animetype;
    public boolean repeat=true;
    public boolean move=false;
    public boolean object;
    public int sorttype;
    public JLabel[] labelarray;

    public AnimateFrame(){
        this.ai = 0;
        this.aj = 0;
        this.animetype=1;
    }

    public void initialize(){
        this.setBounds(0,100,1535,600);
        this.setTitle("Sorting Anime");
        this.setContentPane(getJContentPane());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        panel.requestFocus();
        setRawLabels();
    }

    public JPanel getAnime(){
        if (anime==null){
            anime = new JPanel();
            anime.setLayout(null);
            anime.setBounds(5,150,1510,400);
            anime.setBackground(Color.white);
            anime.setBorder(BorderFactory.createLineBorder(Color.black,2));
        }
        return anime;
    }

    public void setRawLabels(){
        int x;
        if(dd.size%2==1) x = 705-105*(dd.size/2);
        else x = 753-105*(dd.size/2);

        labelarray = new JLabel[dd.size];

        for (int i=0; i<dd.size; i++){
            JLabel label = new JLabel();
            if(object){
                StringTokenizer st = new StringTokenizer(dd.rawarray[i], ",");
                label.setText("<html><body>" + st.nextToken() + "<br>" + st.nextToken() + "<br>" + st.nextToken() + "<br>" + "</body></html>");
            }
            else label.setText(dd.rawarray[i]);
            label.setBounds(x, 150, 100, 100);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setBorder(new circleFrame());
            labelarray[i] = label;
            anime.add(label);
            x += 105;
        }
    }

    //Result: outputting the final result
    public JButton getJButton(){
        if(jButton==null){
            jButton=new JButton();
            jButton.setBounds(new Rectangle(1000,100,90,45));
            jButton.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton.setBackground(new Color(30, 80, 255));
            jButton.setText("Anime 1");
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    animetype = 1;
                    panel.requestFocus();
                }
            });
        }
        return jButton;
    }

    //START: outputting the all step
    public JButton getJButton1(){
        if(jButton1==null){
            jButton1=new JButton();
            jButton1.setBounds(new Rectangle(350,100,90,45));
            jButton1.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton1.setBackground(new Color(255, 60, 60));
            jButton1.setText("Start");
            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    t_Work(true);
                    getJButton().setEnabled(false);
                    getJButton3().setEnabled(false);
                    panel.requestFocus();
                }
            });
        }
        return jButton1;
    }

    //All: outputting the all step
    public JButton getJButton2(){
        if(jButton2==null){
            jButton2=new JButton();
            jButton2.setBounds(new Rectangle(450,100,90,45));
            jButton2.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton2.setBackground(new Color(255, 128, 0));
            jButton2.setText("Stop");
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    t_Work(false);
                    panel.requestFocus();
                }
            });
        }
        return jButton2;
    }

    public JButton getJButton3(){
        if(jButton3==null){
            jButton3=new JButton();
            jButton3.setBounds(new Rectangle(1100,100,90,45));
            jButton3.setText("Anime 2");
            jButton3.setBackground(new Color(200, 80, 255));
            jButton3.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    animetype = 2;
                    panel.requestFocus();
                }
            });
        }
        return jButton3;
    }

    public JButton getJButton4(){
        if(jButton4==null){
            jButton4=new JButton();
            jButton4.setBounds(new Rectangle(750,100,90,45));
            jButton4.setText("Circle");
            jButton4.setBackground(new Color(0, 255, 160));
            jButton4.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<dd.size; i++){
                        labelarray[i].setBorder(new circleFrame());
                    }
                    panel.requestFocus();
                }
            });
        }
        return jButton4;
    }

    public JButton getJButton5(){
        if(jButton5==null){
            jButton5=new JButton();
            jButton5.setBounds(new Rectangle(850,100,90,45));
            jButton5.setText("Triangle");
            jButton5.setBackground(new Color(20, 240, 240));
            jButton5.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for(int i=0; i<dd.size; i++){
                        labelarray[i].setBorder(new triFrame());
                    }
                    panel.requestFocus();
                }
            });
        }
        return jButton5;
    }

    public JButton getJButton6(){
        if(jButton6==null){
            jButton6=new JButton();
            jButton6.setBounds(new Rectangle(600,100,90,45));
            jButton6.setText("Reset");
            jButton6.setBackground(new Color(255, 224, 0));
            jButton6.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    getJButton().setEnabled(true);
                    getJButton3().setEnabled(true);
                    getAnime().setVisible(false);
                    anime.removeAll();
                    ai=0;
                    aj=0;
                    setRawLabels();
                    getAnime().setVisible(true);
                    panel.requestFocus();
                }
            });
        }
        return jButton6;
    }

    /*public JButton getJButton7(){
        if(jButton7==null){
            jButton7=new JButton();
            jButton7.setBounds(new Rectangle(1265,100,90,45));
            jButton7.setText("Next");
            jButton7.setBackground(new Color(163, 228, 215));
            jButton7.setBorder(BorderFactory.createLineBorder(Color.black,2));
            jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    swapAnime2();
                    panel.requestFocus();
                }
            });
        }
        return jButton7;
    }*/

    public JPanel getJContentPane(){
        if (panel == null){
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(60,60,60));
            panel.add(getAnime(), null);
            panel.add(getJButton(), null);
            panel.add(getJButton1(), null);
            panel.add(getJButton2(), null);
            panel.add(getJButton3(), null);
            panel.add(getJButton4(), null);
            panel.add(getJButton5(), null);
            panel.add(getJButton6(), null);
            //panel.add(getJButton7(), null); //delete in final
        }
        return panel;
    }

//-----------------------------------new anime------------------------------------------------
    public void swapAnime() {
        if(next()==dd.step+1) {
            timer.stop();
            repeat=true;
        }
        if(next()<=dd.step) {
            if(dd.judgelastline(ai)){
                int startX = labelarray[dd.nrawindex1[ai]].getX();
                int targetX = labelarray[dd.nrawindex2[ai]].getX();
                int y = 150;
                final long startTime = System.currentTimeMillis();
                int PLAY_TIME = 4000;

                System.out.println(startX+" "+targetX);

                Timer timer1 = new Timer(1, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int x;
                        long duration = System.currentTimeMillis() - startTime;
                        float progress = (float)duration/(float)PLAY_TIME;
                        if (progress > 1f) {
                            progress = 1f;
                            ((Timer)(e.getSource())).stop();
                        }
                        x = startX + Math.round((targetX - startX) * progress);
                        labelarray[dd.nrawindex1[ai-1]].setLocation(x, y);

                        x = targetX + Math.round((startX - targetX) * progress);
                        labelarray[dd.nrawindex2[ai-1]].setLocation(x, y);
                    }
                });
                timer1.start();
            }
            if(next()<=dd.step) ai++;
        }
    }

    public void swapAnime2(){
        if(next()==dd.step+1) {
            timer.stop();
            repeat=true;
        }
        if(next()<=dd.step) {
            if(dd.judgelastline(ai)){
                int startX = labelarray[dd.nrawindex1[ai]].getX();
                int targetX = labelarray[dd.nrawindex2[ai]].getX();
                int Y = 150;
                int midX = (targetX+startX)/2;
                int midY = 0;
                final long startTime = System.currentTimeMillis();
                int PLAY_TIME = 2000;

                System.out.println(startX+" "+targetX);

                Timer timer2 = new Timer(1, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x;
                        int y;
                        long duration = System.currentTimeMillis() - startTime;
                        float progress = (float)duration/(float)PLAY_TIME;

                        if (progress > 2f) {
                            progress = 2f;
                            ((Timer)(e.getSource())).stop();
                        }
                        else if(progress <= 1f){
                            x = startX + Math.round((midX - startX) * progress);
                            y = Y + Math.round((midY - Y) * progress);
                            labelarray[dd.nrawindex1[ai-1]].setLocation(x, y);

                            x = targetX + Math.round((midX - targetX) * progress);
                            labelarray[dd.nrawindex2[ai-1]].setLocation(x, y);
                        }
                        else {
                            x = midX + Math.round((targetX - midX) * (progress-1));
                            y = midY + Math.round((Y - midY) * progress)-150;
                            labelarray[dd.nrawindex1[ai-1]].setLocation(x, y);

                            x = midX + Math.round((startX - midX) * (progress-1));
                            labelarray[dd.nrawindex2[ai-1]].setLocation(x, y);
                        }
                    }
                });
                timer2.start();
            }
            if(next()<=dd.step) ai++;
        }
    }

    public void insertionAnime(){
        if(next()==dd.step+1) {
            timer.stop();
            repeat=true;
        }
        if(next()<=dd.step) {
            if(dd.judgelastline(ai)){
                int startX = labelarray[dd.rawindex1[ai]].getX();
                int insertX = labelarray[dd.rawindex2[ai]].getX();
                int y = 150;
                final long startTime = System.currentTimeMillis();
                int PLAY_TIME = 4000;
                int distence= 105;

                System.out.println(startX+" "+insertX);

                Timer timer3 = new Timer(1, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x;
                        long duration = System.currentTimeMillis() - startTime;
                        float progress = (float)duration/(float)PLAY_TIME;
                        if (progress > 1f) {
                            progress = 1f;
                            ((Timer)(e.getSource())).stop();
                        }

                        x = startX + Math.round((insertX - startX) * progress);
                        labelarray[dd.index1[ai-1]-1].setLocation(x, y);
                        move = false;
                        int insertX2=insertX;
                        if(dd.index1[ai-1]!=dd.index2[ai-1]){
                            for(int j=0;j<dd.index1[ai-1]-1;j++){
                                int i=ai-1;
                                if(dd.nrarray[i][j]==dd.index1[ai-1]-1){
                                    move=true;
                                }
                                if(move){
                                    x=insertX2+Math.round(distence * progress);
                                    labelarray[dd.nrarray[i][j+1]].setLocation(x, y);
                                    insertX2+=105;
                                }
                            }
                        }
                    }
                });
                timer3.start();
            }
            if(next()<=dd.step) ai++;
        }
    }

    public void insertionAnime2(){
        if(next()==dd.step+1) {
            timer.stop();
            repeat=true;
        }
        if(next()<=dd.step) {
            if(dd.judgelastline(ai)){
                int startX = labelarray[dd.rawindex1[ai]].getX();
                int insertX = labelarray[dd.rawindex2[ai]].getX();
                int Y = 150;
                int midX = (insertX+startX)/2;
                int midY = 0;
                final long startTime = System.currentTimeMillis();
                int PLAY_TIME = 2000;
                int distence= 105;

                System.out.println(startX+" "+insertX);

                Timer timer4 = new Timer(1, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x;
                        int y;
                        long duration = System.currentTimeMillis() - startTime;
                        float progress = (float)duration/(float)PLAY_TIME;
                        if (progress > 2f) {
                            progress = 2f;
                            ((Timer)(e.getSource())).stop();
                        }
                        else if(progress <= 1f){
                            x = startX + Math.round((midX - startX) * progress);
                            y = Y + Math.round((midY - Y) * progress);
                            labelarray[dd.index1[ai-1]-1].setLocation(x, y);
                        }
                        else {
                            x = midX + Math.round((insertX - midX) * (progress-1));
                            y = midY + Math.round((Y - midY) * progress)-150;
                            labelarray[dd.index1[ai-1]-1].setLocation(x, y);
                        }

                        move=false;
                        int insertX2=insertX;
                        if(dd.rawindex1[ai-1]!=dd.rawindex2[ai-1]){
                            for(int j=0;j<dd.index1[ai-1]-1;j++){
                                int i=ai-1;
                                if(dd.nrarray[i][j]==dd.index1[ai-1]-1){
                                    move=true;
                                }
                                if(move){
                                    x=insertX2+Math.round(distence * progress/2);
                                    labelarray[dd.nrarray[i][j+1]].setLocation(x, Y);
                                    insertX2+=105;
                                }
                            }
                        }
                    }
                });
                timer4.start();
            }
            if(next()<=dd.step) ai++;
        }
    }

    public void t_Work(boolean b) {
        if(b&&repeat&&next()<=dd.step) {
            timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(animetype==1){
                        if(sorttype==1) insertionAnime();
                        else swapAnime();
                    }
                    else{
                        if(sorttype==1) insertionAnime2();
                        else swapAnime2();
                    }

                }
            });
            timer.start();
            repeat=false;
        }
        else if(!b&&!repeat){
            timer.stop();
            repeat=true;
        }
    }

    public int next() {
        System.out.println("next");
        System.out.println("step"+(ai+1));
        return 	ai+1;
    }
}
