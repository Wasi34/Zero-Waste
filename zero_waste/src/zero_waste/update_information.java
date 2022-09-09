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
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author MIT
 */
public class update_information extends JFrame implements ActionListener{
        private Container c;
       // Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
        JButton b1,b2;
        String username;
    update_information(final String username){
        this.username = username;
                  this.setBounds(580, 220, 850, 550);
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
       ImageIcon i1  = new ImageIcon(getClass().getResource("design\\addcus2.png"));
                
                JLabel l1 = new JLabel(i1);
                l1.setBorder(new LineBorder(Color.BLACK,3));
                l1.setBounds(450,40,400,420);
                
                add(l1);
		
		JLabel lblName = new JLabel("   UPDATE INFORMATION:");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
                 lblName.setBackground(new Color(125,149,185));
                lblName.setBorder(new LineBorder(Color.black,3));
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t7 = new JTextField();
		t7.setBounds(271, 70, 150, 20);
		contentPane.add(t7);
		t7.setColumns(10);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Passport", "Nid", "Driving license"});
		comboBox.setBounds(271, 110, 150, 20);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 230, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 230, 100, 12);
		add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(271, 270, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                t5 = new JTextField();
		t5.setBounds(271, 310, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(271, 350, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		t8 = new JTextField();
		t8.setBounds(271, 390, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);
                
                b1 = new JButton("Add");
                b1.setBackground(new Color(125,149,185));
                b1.setForeground(Color.black);
                b1.setBounds(80,430,100,25);
                add(b1);
                
                b1.addActionListener(new ActionListener(){

                      @Override
                      public void actionPerformed(ActionEvent ae)
                      {

                        String username = t7.getText();
                        String id = (String)comboBox.getSelectedItem();
                        String number = t1.getText();
                        String name = t2.getText();
                        String lblGender = null;
                        if(r1.isSelected())
                        {
                            lblGender = "Male";
                        }
                        else if(r2.isSelected())
                        {
                            lblGender = "Female";
                        }
                        String country = t3.getText();
                        String address = t5.getText();
                        String phone = t6.getText();
                        String email = t8.getText();
                        
                        String q = "UPDATE user_info set ID = '"+id +"' ,number = '"+number +"',name = '"+name +"' , gender = '"+lblGender +"',country = '"+country +"', parmanent_address = '"+address +"', phone = '"+phone +"',email = '"+email +"'  WHERE username= '" +username+"' " ;
                          
                        try {
                        Conn con = new Conn();
                        con.s.executeUpdate(q);
                         JOptionPane.showMessageDialog(null, "Account Updated");

                         }
                        catch (Exception e) {
                           System.out.println(e);
                        }} 

                      
                      
                });
    
                
                b2 = new JButton("Back");
                b2.setBackground(new Color(125,149,185));
                b2.setForeground(Color.black);
                b2.setBounds(300,430,100,25);
                add(b2);
                b2.addActionListener(new ActionListener(){

                      @Override
                      public void actionPerformed(ActionEvent ae)
                      {
                         dispose();
                          try {
                              new dashBoard(username).setVisible(true);
                          } catch (FileNotFoundException ex) {
                              Logger.getLogger(update_information.class.getName()).log(Level.SEVERE, null, ex);
                          }
                        
                    
                      }
                       //dispose();
                       //new dashBoard().setVisible(true);
                      
                      
                 });
                
                
                        }
  
    
    public static void main(String[] args) {
        update_information frame = new update_information("");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
