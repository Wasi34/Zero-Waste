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
import java.sql.PreparedStatement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Anila Ditita
 */
public class signup extends JFrame implements ActionListener{
    
     private Container c;
    private JPanel panel1;
    private JLabel txtl1,txtl2,txtl3,txtl4,txtlmail,txtlphn,txtl5,imgl1,uploadl;
    private JTextField txtfd1,txtfd2,txtfd3,txtfd4,uploadtxtfd,txtfdmail,txtfdphn;
    private JButton btn1,btn2,picbtn;
    private ImageIcon img;
    JFileChooser chooser;
    String filename ;
    JComboBox comboBox,c2;
    private JPanel contentPane;
    
    public static void main(String[] args) {
        new signup().setVisible(true);
    }
    
    
    public signup(){
        this.setBounds(600,300,900,460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SIGN UP");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        
               /* contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);*/
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,0,500,400);
        panel1.setBackground(new Color(177,193,216));
        c.add(panel1);
        
        txtl1 = new JLabel("Username");
        txtl1.setBounds(50,20,125,25);
        txtl1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl1);
        
        txtfd1 = new JTextField();
        txtfd1.setBounds(190,20,180,25);
        txtfd1.setBorder(null);
        panel1.add(txtfd1);
        
         
        txtl2 = new JLabel("Name");
        txtl2.setBounds(50,60,125,25);
        txtl2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl2);
        
        txtfd2 = new JTextField();
        txtfd2.setBounds(190,60,180,25);
        txtfd2.setBorder(null);
        panel1.add(txtfd2);
        
        
        txtlmail = new JLabel("Email");
        txtlmail.setBounds(50,100,125,25);
        txtlmail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtlmail);
        
        txtfdmail = new JTextField();
        txtfdmail.setBounds(190,100,180,25);
        txtfdmail.setBorder(null);
        panel1.add(txtfdmail);
        
        
        
        txtlphn = new JLabel("Phone");
        txtlphn.setBounds(50,140,125,25);
        txtlphn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtlphn);
        
        txtfdphn = new JTextField();
        txtfdphn.setBounds(190,140,180,25);
        txtfdphn.setBorder(null);
        panel1.add(txtfdphn);
        
        
        txtl3 = new JLabel("Passsword");
        txtl3.setBounds(50,180,125,25);
        txtl3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl3);
        
        txtfd3 = new JTextField();
        txtfd3.setBounds(190,180,180,25);
        txtfd3.setBorder(null);
        panel1.add(txtfd3);
        
        txtl3 = new JLabel("Security Question");
        txtl3.setBounds(50,220,125,25);
        txtl3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl3);
        
        /*Choice ch = new Choice();
        ch.add("Are yoy willing to donate food");
        ch.add("Can you trust our charity?");
        ch.add("Do our charity's programs make sense to you?");
        ch.setBounds(190,220,180,25);
        panel1.add(ch);*/
        

        
        comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Are you willing to donate food?", "Can you trust our charity?",
			"Do our charity's programs make sense to you?" }));
	comboBox.setBounds(190,220,180,25);
	panel1.add(comboBox);
        
        txtl5 = new JLabel("Answer");
        txtl5.setBounds(50,260,125,25);
        txtl5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(txtl5);
        
        
        txtfd4 = new JTextField();
        txtfd4.setBounds(190,260,180,25);
        txtfd4.setBorder(null);
        panel1.add(txtfd4);
        
        uploadl = new JLabel("User Type");
        uploadl.setBounds(50,300,125,25);
        uploadl.setFont(new Font("Tahoma",Font.BOLD,14));
        panel1.add(uploadl);
        
        c2 = new JComboBox();
	c2.setModel(new DefaultComboBoxModel(new String[] { "Donor", "Volunteer"}));		
	c2.setBounds(190,300,180,25);
	panel1.add(c2);
        /* picbtn= new JButton("upload picture");
         picbtn.setBounds(50,300,125,25);
         picbtn.setBorder(null);
         picbtn.setFont(new Font("Tahoma",Font.BOLD,14));
        picbtn.setBackground(Color.black);
        picbtn.setForeground(Color.white);
         panel1.add(picbtn);
         picbtn.addActionListener(this);*/
         
        
        
       /* uploadtxtfd = new JTextField();
        uploadtxtfd.setBounds(190,300,180,25);
        uploadtxtfd.setBorder(null);
        panel1.add(uploadtxtfd);
        */
       
       
        

        
        btn1 = new JButton("Done");
        btn1.setFont(new Font("Tahoma",Font.BOLD,14));
        btn1.setBackground(new Color(125,149,185));
        btn1.setForeground(Color.black);
        btn1.setBounds(80,340,100,30);
        panel1.add(btn1);
        btn1.addActionListener(this);
        
        btn2 = new JButton("Back");
        btn2.setFont(new Font("Tahoma",Font.BOLD,14));
        btn2.setBackground(new Color(125,149,185));
        btn2.setForeground(Color.black);
        btn2.setBounds(250,340,100,30);
        panel1.add(btn2);
        btn2.addActionListener(this);
        
        img = new ImageIcon(getClass().getResource("design\\regicon1.png"));
        
        imgl1 = new JLabel(img);
        imgl1.setBounds(500,0,400,360);
        this.add(imgl1);
        
        
        
                

        
        
        
        
        
        
    }
    
    
    /*public static void main(String[] args) {
       
        
        signup frame = new signup();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }*/

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        try{
        Conn con = new Conn();
        if(ae.getSource()== btn1){
            
           
           
                String sql = "insert into user_info(username, name, email, phone,password,question,answer,user_type) values(?, ?, ?, ?,?,?,?,?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, txtfd1.getText());
                st.setString(2, txtfd2.getText());
		st.setString(3, txtfdmail.getText());
		st.setString(4, txtfdphn.getText());
                st.setString(5, txtfd3 .getText());
                st.setString(6, (String) comboBox.getSelectedItem());
                st.setString(7,txtfd4.getText());
                st.setString(8, (String) c2.getSelectedItem());
                
                
        
                
               
                
                int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                }

                txtfd1.setText("");
                txtfd2.setText("");
                txtfdmail.setText("");
                txtfdphn.setText("");
		txtfd3.setText("");
		txtfd4.setText("");
                
             
        }
        if(ae.getSource()== btn2){
            this.setVisible(false);
            new login().setVisible(true);
        }
            
        }catch(Exception e1)
        {
            System.out.println(e1);
        }
        
        if(ae.getSource() ==picbtn){
            chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
             filename = f.getAbsolutePath();
            uploadtxtfd.setText(filename);
        }
       
            
            
            
        
    }
    
}
