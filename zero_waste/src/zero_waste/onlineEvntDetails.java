/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.Choice;
import java.awt.Color;  
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class onlineEvntDetails extends JFrame implements ActionListener {
    private Container c;
    private JPanel panel1;
    private JLabel txtl1,txtl2,txtl3,txtl4,txtlmail,txtlphn,txtl5,imgl1,uploadl,txtl6,titlelb;
    private JTextField txtfd1,txtfd2,txtfd3,txtfd4,uploadtxtfd,txtfdmail,txtfdphn,emailtxfld;
    private JButton btn1,btn2,picbtn;
    private ImageIcon img;
    JFileChooser chooser;
    String filename ,username;
    
  
     onlineEvntDetails(final String username){
         this.username =username;
        this.setBounds(600,300,500,460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("On Going Event");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,0,500,400);
        panel1.setBackground(new Color(177,193,216));
        c.add(panel1);
        
        titlelb = new JLabel("INFORMATION");
        titlelb.setBorder(new LineBorder(Color.black));
        titlelb.setBounds(170,10,125,25);
        titlelb.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(titlelb);      
        
        txtl1 = new JLabel("Event Name");
        txtl1.setBounds(50,40,125,25);
        txtl1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl1);
        
        txtfd1 = new JTextField();
        txtfd1.setBounds(190,40,180,25);
        txtfd1.setBorder(null);
        panel1.add(txtfd1);
        
         
        txtl2 = new JLabel("Event For");
        txtl2.setBounds(50,100,125,25);
        txtl2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl2);
        
        txtfd2 = new JTextField();
        txtfd2.setBounds(190,100,180,25);
        txtfd2.setBorder(null);
        panel1.add(txtfd2);
        
        
        txtlmail = new JLabel("Location");
        txtlmail.setBounds(50,140,125,25);
        txtlmail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtlmail);
        
        txtfdmail = new JTextField();
        txtfdmail.setBounds(190,140,180,25);
        txtfdmail.setBorder(null);
        panel1.add(txtfdmail);
        
        
        
        txtlphn = new JLabel("Date and time");
        txtlphn.setBounds(50,180,125,25);
        txtlphn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtlphn);
        
        txtfdphn = new JTextField();
        txtfdphn.setBounds(190,180,180,25);
        txtfdphn.setBorder(null);
        panel1.add(txtfdphn);
        
        
        txtl3 = new JLabel("Event organizer");
        txtl3.setBounds(50,220,125,25);
        txtl3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl3);
        
        txtfd3 = new JTextField();
        txtfd3.setBounds(190,220,180,25);
        txtfd3.setBorder(null);
        panel1.add(txtfd3);
        
        
        txtl5 = new JLabel("Email");
        txtl5.setBounds(50,260,125,25);
        txtl5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl5);
        
        
        txtfd4 = new JTextField();
        txtfd4.setBounds(190,260,180,25);
        txtfd4.setBorder(null);
        panel1.add(txtfd4);
        
         
        txtl6 = new JLabel("Phone");
        txtl6.setBounds(50,300,125,25);
        txtl6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl6);
        
        
        emailtxfld = new JTextField();
        emailtxfld.setBounds(190,300,180,25);
        emailtxfld.setBorder(null);
        panel1.add(emailtxfld);
              
            try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from event where userName = '"+username+"'");
                    while(rs.next()){
                        txtfd1.setText(rs.getString("name")); 
                        txtfd2.setText(rs.getString("event_for")); 
                        txtfdmail.setText(rs.getString("location")); 
                        txtfdphn.setText(rs.getString("date_time"));
                        txtfd3.setText(rs.getString("userName")); 
                        txtfd4.setText(rs.getString("email")); 
                        emailtxfld.setText(rs.getString("phone")); 
                    
                    }
                }catch(Exception e){System.out.println(e); }
        
       
        btn1 = new JButton("Want to Donate");
        btn1.setFont(new Font("Tahoma",Font.BOLD,14));
        btn1.setBackground(new Color(125,149,185));
        btn1.setForeground(Color.black);
        btn1.setBounds(20,340,200,30);
        panel1.add(btn1);
        btn1.addActionListener(this);
        
        btn2 = new JButton("Back");
        btn2.setFont(new Font("Tahoma",Font.BOLD,14));
        btn2.setBackground(new Color(125,149,185));
        btn2.setForeground(Color.black);
        btn2.setBounds(270,340,100,30);
        panel1.add(btn2);
        btn2.addActionListener(this);
        
        img = new ImageIcon(getClass().getResource("design\\regicon1.png"));
        
        imgl1 = new JLabel(img);
        imgl1.setBounds(500,0,400,360);
        this.add(imgl1);
        
        
        
     
        
        
        
        
        
        
    }
    
    
    public static void main(String[] args) {
        onlineEvntDetails Frame = new onlineEvntDetails(" ");
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource()== btn1){
            dispose();
            new onEvntDonation(username).setVisible(true);
           
        }
        if(ae.getSource()== btn2){
            this.setVisible(false);
            //new login().setVisible(true);
             new event_information(username).setVisible(true);
        }
        
       
       
            
            
            
        
    }
}