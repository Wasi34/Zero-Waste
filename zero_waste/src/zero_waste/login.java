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
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Choice;
import java.sql.PreparedStatement;


public class login extends JFrame implements ActionListener{
    private JPanel panel1, panel2;
    private JLabel txtlb1, txtlb2, txtlb3,imgl,imgl2,imgl3;
    private JTextField textfld;
    private JPasswordField pass;
    private JComboBox c2;
    //private Choice c2;
    private JButton button1, button2,button3;
    private Font fn;
    private ImageIcon img,img2,img3;
    private Container c;
    String name;
   
    

    login() {
        start();
    }

    void start() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        fn = new Font("Arial", Font.BOLD, 20);
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(125,149,185));
        panel1.setBounds(0, 0, 450, 440);
        c.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        //panel2.setBackground(new Color(33, 41, 48));panel1.setBackground(new Color(164,196,224));
        panel2.setBackground(new Color(177,193,216));
        panel2.setBounds(450, 0, 450, 440);
        c.add(panel2);

        txtlb1 = new JLabel("Welcome to the Zero Waste");
        txtlb1.setBounds(30, 0, 450, 160);
        txtlb1.setFont(new Font("Arial",Font.BOLD,30));
        panel1.add(txtlb1);
        
        img = new ImageIcon(getClass().getResource("design\\login.png"));
        imgl= new JLabel(img);
        imgl.setBounds(105,130,200,225);
        panel1.add(imgl);
        
        txtlb2 = new JLabel("Username");
        txtlb2.setBounds(50,15,200,30);
        txtlb2.setFont(fn);
        //txtlb2.setForeground(new Color(90, 125, 159));
        txtlb2.setForeground(Color.black);
        panel2.add(txtlb2);
        
        textfld = new JTextField();
        textfld.setBounds(50,55,320,30);
        textfld.setBorder(BorderFactory.createEmptyBorder());
        textfld.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        panel2.add(textfld);
        
        //img2 = new ImageIcon(getClass().getResource("design\\user.png"));
        //imgl2= new JLabel(img2);
        //imgl2.setBounds(340,55,70,50);
        //panel2.add(imgl2);
        
       
        
        txtlb3 = new JLabel("Password");
        txtlb3.setBounds(50,115,200,30);
        txtlb3.setFont(fn);
        //txtlb3.setForeground(new Color(90, 125, 159));
        txtlb3.setForeground(Color.black);
        panel2.add(txtlb3);
        
        pass = new JPasswordField();
        pass.setBounds(50,158,320,30);
        pass.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        pass.setBorder(null);
        panel2.add(pass);
        
        JLabel type = new JLabel("User Type");
        type.setBounds(50,220,125,30);
        type.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        type.setForeground(Color.BLACK);
        type.setFont(new Font("Tahoma",Font.BOLD,14));
        panel2.add(type);
        
        c2 = new JComboBox();
	c2.setModel(new DefaultComboBoxModel(new String[] { "Donor", "Volunteer","Admin"}));
        c2.setBackground(Color.white);
	c2.setBounds(190,220,180,30);
	panel2.add(c2);
        
        //img3 = new ImageIcon(getClass().getResource("design\\icon.png"));
        //imgl3 = new JLabel(img3);
        //imgl3.setBounds(350,148,50,70);
        //panel2.add(imgl3);
        
        
        button1 = new JButton("Login");
        button1.setBounds(50,300,140,30);
        //button1.setBackground(Color.BLACK);
        button1.setBackground(new Color(125,149,185));
        button1.setForeground(Color.black);
        
        button1.setBorder(null);
        panel2.add(button1);
        button1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               
            String username = textfld.getText();
            String password = pass.getText();
            //String type = (String) c2.getSelectedItem();
           // String type = String.valueOf(c2.getSelectedIntem());
             String UserType = String.valueOf(c2.getSelectedItem());
           // st.setString(8, (String) c2.getSelectedItem());user_type = '" +type+"'" 

            Conn con = new Conn();

            String str = "select * from user_info where username = '" + username + "' and password = '" + password + "' ";
            /*String query = "Select * from user_info where username=? AND password=? AND user_type='Donor'";*/
              /*try {
            pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pin);
            ResultSet res = pst.executeQuery();

            //match email & pw -> UserHomePage
            if (res.next()) {
                dispose();
                UserHomePage rg = new UserHomePage();
                rg.setVisible(true);
            } else {
                System.out.println("Email :" + email);
                System.out.println("Pass :" + pin);
                JOptionPane.showMessageDialog(this, "Email/Password not found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Log_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

         try {
               ResultSet rs = con.s.executeQuery(str);

                if (rs.next()) {
                   
                   JOptionPane.showMessageDialog(null, "Successfull");
                   dispose();
                   //this.setVisible(false);
                   new LoadoutPage(textfld.getText()).setVisible(true);
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username , password or user type");
                    textfld.setText("");
                    pass.setText("");
                }

            } catch (Exception e) {

            }
                /*name = textfld.getText();
               
               char[] password = pass.getPassword();
               if("one".equals(name)){
                   dispose();
                   new LoadoutPage().setVisible(true);
               }*/
           }
        });
        
        
        
          
        button2 = new JButton("SignUp");
        button2.setBounds(240,300,130,30);
        button2.setForeground(Color.black);
        button2.setBorder(null);
        button2.setBackground(new Color(125,149,185));
        
        panel2.add(button2);
        
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new signup().setVisible(true);
                dispose();
            }
        });
        
        button3 = new JButton("Forgot Password");
        button3.setBounds(142,347,150,30);
        button3.setBackground(new Color(125,149,185));
        button3.setBorder(null);
         
        button3.setForeground(Color.black);
        panel2.add(button3);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new forgetPassword().setVisible(true);
            }
        });
        
        
        this.setBounds(500, 300, 900, 440);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 

    }

    public static void main(String[] args) {

        login frame = new login();
        frame.setBounds(500, 300, 900, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
