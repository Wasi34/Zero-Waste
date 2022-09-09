/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author The CY83RN4UT
 */
public class remainingFoodInfo extends JFrame {
    
     private JPanel panel1, panel2;
    private JLabel txtlb1, txtlb2, txtlb3,imgl,imgl2,imgl3;
    private JTextField textfld,textfld2,textfld3;
    private JPasswordField pass;
    private JButton button1, button2,button3,button4;
    private Font fn;
    private ImageIcon img,img2,img3;
    private Container c;
    String name,username;
    
    remainingFoodInfo(final String username){
        
         this.username =username;
        this.setBounds(500, 300, 435, 413);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
         fn = new Font("Arial", Font.BOLD, 20);
        
         panel2 = new JPanel();
        panel2.setLayout(null);
        //panel2.setBackground(new Color(129, 52, 175));
        panel2.setBackground(new Color(177,193,216));
        panel2.setBounds(0, 10, 420, 365);
        panel2.setBorder(new LineBorder(Color.black,5));
        c.add(panel2);
        
        
        txtlb1= new JLabel("Remaining Food Information");
        txtlb1.setBounds(75,10,280,30);
        txtlb1.setBorder(new LineBorder(Color.BLACK));
        txtlb1.setFont(fn);
        txtlb1.setBackground(Color.black);
        txtlb1.setForeground(Color.black);
        panel2.add(txtlb1);
        
        txtlb2 = new JLabel("User Event ID :");
        txtlb2.setBounds(50,45,200,50);
        txtlb2.setFont(fn);
        txtlb2.setForeground(Color.black);
        txtlb2.setBackground(Color.black);
        panel2.add(txtlb2);
        
        
          textfld = new JTextField();
        textfld.setBounds(50,85,300,50);
        textfld.setBorder(BorderFactory.createEmptyBorder());
        textfld.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        panel2.add(textfld);
        
        
        txtlb3 = new JLabel("Remaining Food on Hand");
        txtlb3.setBounds(50,140,270,50);
        txtlb3.setFont(fn);
        txtlb3.setForeground(Color.black);
        panel2.add(txtlb3);
        
        
        textfld2 = new JTextField();
        textfld2.setBounds(50,180,300,50);
        textfld2.setBorder(BorderFactory.createEmptyBorder());
        textfld2.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        panel2.add(textfld2);
        
        
        
        txtlb3 = new JLabel("Amount of waste Food");
        txtlb3.setBounds(50,220,270,50);
        txtlb3.setFont(fn);
        txtlb3.setForeground(Color.black);
        panel2.add(txtlb3);
        
        
        textfld3 = new JTextField();
        textfld3.setBounds(50,260,300,50);
        textfld3.setBorder(BorderFactory.createEmptyBorder());
        textfld3.setFont(new Font("SAN_SARIF",Font.PLAIN,25));
        panel2.add(textfld3);
        
        button1=new JButton("Add");
        button1.setBackground(new Color(125,149,185));
        button1.setForeground(Color.black);
        button1.setBorder(new LineBorder(Color.black));
        button1.setBounds(70,320,80,30);
        button1.setFont(fn);
        panel2.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
         Conn con = new Conn();
            String sql = "insert into remained_Food_info(user_event_id,remained_food,wasted_food)values(?,?,?)";
          //String sql = "insert into user_info(username, name, email, phone,password,answer) values(?, ?, ?, ?,?,?)";
		PreparedStatement st;
                try {
                    st = con.c.prepareStatement(sql);
                    st.setString(1, textfld.getText());
                st.setString(2, textfld2.getText());
		st.setString(3, textfld3.getText());
		//st.setString(4, (String) comboBox.getSelectedItem());
                
                String id = textfld.getText();
                    String remaining = textfld3.getText();
                    String waste = textfld3.getText();
                    
                    if (id.equals("")) {

                        JOptionPane.showMessageDialog(null, "Please fill out Event ID feild ");

                    } else if (remaining.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Remaining Food feild");

                    } else if (waste.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Amount of waste Food feild");
                    } else{
                    
		
                  
                   int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Information Added Successfully ");
                }

                textfld.setText("");
                textfld2.setText("");
		textfld3.setText("");
		
                }} catch (Exception ex) {
                   System.out.println(ex);
                }
            }
	});
        
        
        button2=new JButton("Back");
        button2.setBackground(new Color(125,149,185));
        button2.setForeground(Color.black);
        button2.setBorder(new LineBorder(Color.black));
        button2.setBounds(250,320,80,30);
        button2.setFont(fn);
        panel2.add(button2);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
          new donation_information(username).setVisible(true);
            }
	});


        
        
        
        
        
    }
    
    
    
    public static void main(String[]args){
        
        remainingFoodInfo frame= new remainingFoodInfo(" ");
        frame.setVisible(true);
        frame.setBounds(500, 300, 435, 413);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}

