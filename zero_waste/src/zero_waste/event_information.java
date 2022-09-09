/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


   

public class event_information extends JFrame  {
    private Container c;
    private JLabel lab1,lab2,lab3,titlelbl;
    private JTextField p1,p2,p3,p4,p5;
    
    private ImageIcon img1,img2,bpi1,bpi2,bpi3,bpi4,bpi5;
    private JButton btn1,btn2,btn3,btn4,btn5,backbtn,checkbtn;
    String username;
    
    event_information(final String username){
         
          this.username =username;
         this.setBounds(750,350,690,480);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         c = this.getContentPane();
         c.setLayout(null);
         c.setBackground(Color.black);
        
     titlelbl=new JLabel("                        Online Events-");
     titlelbl.setBounds(250,5,250,45);
     titlelbl.setBorder(new LineBorder(Color.white));
     titlelbl.setForeground(Color.white);
     c.add(titlelbl);
         
       
         p1= new JTextField();
         p2=new JTextField();
         p3=new JTextField();
         p4=new JTextField();
         p5=new JTextField();
         
        
         p1.setBounds(20,80,120,40);
         p1.setBorder(new LineBorder(Color.white,4));
         c.add(p1);
         p2.setBounds(20,170,120,40);
         p2.setBorder(new LineBorder(Color.white,4));
         c.add(p2);
         p3.setBounds(20,260,120,40);
         p3.setBorder(new LineBorder(Color.white,4));
       c.add(p3);
         
         p4.setBounds(320,80,120,40);
         p4.setBorder(new LineBorder(Color.white,4));
        c.add(p4);
         p5.setBounds(320,170,120,40);
         p5.setBorder(new LineBorder(Color.white,4));
        c.add(p5);
         
         try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from event where userName = '"+username+"'");
                    while(rs.next()){
                        p1.setText(rs.getString("event_id"));  
                    
                    }
                }catch(Exception e){System.out.println(e); }
        
         btn1 = new JButton("Details");
         btn1.setBounds(180,80,80,35);
         btn1.setBackground(Color.white);
         btn1.setForeground(Color.black);
          btn1.setBorder(null);
         c.add(btn1);
         btn1.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae){
              dispose();
              new  onlineEvntDetails(username).setVisible(true);
          }
         });
         
         btn2 = new JButton("Details");
         btn2.setBounds(180,170,80,35);
         btn2.setBackground(Color.white);
         btn2.setForeground(Color.black);
         btn2.setBorder(null);
         c.add(btn2);
         btn2.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae){
              dispose();
              new  onlineEvntDetails(username).setVisible(true);
          }
         });
         
         
         btn3 = new JButton("Details");
         btn3.setBounds(180,260,80,35);
        btn3.setBackground(Color.white);
         btn3.setForeground(Color.black);
         btn3.setBorder(null);
         c.add(btn3);
         btn3.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae){
              dispose();
              new  onlineEvntDetails(username).setVisible(true);
          }
         });
         
         btn4 = new JButton("Details");
         btn4.setBounds(470,80,80,35);
         btn4.setBackground(Color.white);
         btn4.setForeground(Color.black);
          btn4.setBorder(null);
         c.add(btn4);
         btn4.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ae){
                 dispose();
                 new onlineEvntDetails(username).setVisible(true);
             }
         });
         
          
         btn5 = new JButton("Details");
         btn5.setBounds(470,170,80,35);
         btn5.setBackground(Color.white);
         btn5.setForeground(Color.black);
         btn5.setBorder(null);
         c.add(btn5);
         btn5.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ae){
                 dispose();
                 new onlineEvntDetails(username).setVisible(true);
             }
         });
         
         checkbtn = new JButton("Check");
                checkbtn.setBounds(200,380,100,30);
                checkbtn.setBackground(Color.white);
                checkbtn.setForeground(Color.black);
                checkbtn.setBorder(null);
                c.add(checkbtn);
               
                checkbtn.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ae) {
         //database code will be here 
            }
                });
         
         backbtn = new JButton("Back");
                backbtn.setBounds(350,380,100,30);
                backbtn.setBackground(Color.white);
                backbtn.setForeground(Color.black);
                backbtn.setBorder(null);
                c.add(backbtn);
               
                backbtn.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ae) {
               dispose();
            try {
                new dashBoard(username).setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(event_information.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                });
                
                

    
}

    public static void main(String[] args) {
        event_information frame = new event_information(" ");
        frame.setVisible(true);
        
    }
    
    
}

