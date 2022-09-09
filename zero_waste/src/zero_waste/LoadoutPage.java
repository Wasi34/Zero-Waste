/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author MIT
 */
public class LoadoutPage extends JFrame implements Runnable{
    private Container c ;
    Thread left,right,t;
    ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,ri1=null,ri2=null,ri3=null,ri4=null,ri5=null,ri6=null,ri7=null,ri8=null;
    ImageIcon[] img= new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8};
    ImageIcon[] rimg = new ImageIcon[]{ri1,ri2,ri3,ri4,ri5,ri6,ri7,ri8};
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,rj1,rj2,rj3,rj4,rj5,rj6,rj7,rj8;
    JLabel[] label= new JLabel[]{j1,j2,j3,j4,j5,j6,j7,j8};
    JLabel[] rlabel = new JLabel[]{rj1,rj2,rj3,rj4,rj5,rj6,rj7,rj8};
    JProgressBar bar;
    JLabel textl;
    Timer m;
    Connection conn;
    dashBoard dboard;
     String username;
    
    
    
    
  public LoadoutPage(String username){
      this .username = username;
        this.setBounds(410,290,1200,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Loading");
        c= this.getContentPane();
        c.setBackground(new Color(0,0,0));
        for(int i=0; i<8;i++){
            img[i]=new ImageIcon(getClass().getResource("design\\pictures\\"+(i+1)+".jpg"));
            this.label[i]=new JLabel(img[i]);
            this.label[i].setBounds(0,0,390,500);
            c.add(this.label[i]);
           bar = new JProgressBar();
           bar.setBounds(420,380,360,30);
           bar.setStringPainted(true);
           
           bar.setString("Loading......");
           
           c.add(bar);
           
           textl = new JLabel();
           textl.setFont(new Font("Raleway",Font.BOLD,30));
           textl.setBounds(520,60,150,150);
           c.add(textl);
          
       
        }
        
      left = new Thread(this);
      left.start();
      
      for(int i=0; i<8;i++){
            rimg[i]=new ImageIcon(getClass().getResource("design\\pictures\\"+(i+1)+".jpg"));
            this.rlabel[i]=new JLabel(img[i]);
            this.rlabel[i].setBounds(795,0,400,500);
            c.add(this.rlabel[i]);
             
        }
     
     right = new Thread(this);
     right.start();
    
    
    }
    
    
    public static void main(String[] args) {
      // LoadoutPage frame = new LoadoutPage();
       //frame.setVisible(true);
       new LoadoutPage("").setVisible(true);
        
    }

    @Override
    public void run() {
       
        
       for(int i=0;i<6;i++){
           
           this.label[i].setVisible(true);
           
           this.rlabel[i].setVisible(false);
           try {
             right.sleep(500);
           } catch (InterruptedException ex) {
            System.out.println(ex);
           }
           this.label[i].setVisible(false);
           this.rlabel[i].setVisible(false);
            
       }
       
        try {
            dispose();
            //new dashBoard(username);
             //setVisible(false);
             
          dboard = new dashBoard(username);
           dboard.setVisible(true);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
       //dboard.setVisible(true);
       
    }
   
    
}

