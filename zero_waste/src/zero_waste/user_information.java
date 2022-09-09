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
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class user_information extends JFrame {
    
    private Container contentPane;
    //private JButton btn1;
    private JButton btn1,btn2;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String username;
    user_information(final String username){
        this.username =username;
        setBounds(580, 220, 850, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                this.setTitle("Details");
               
                
                ImageIcon i1  = new ImageIcon(getClass().getResource("design\\usrinfo.jpg"));               
                JLabel la1 = new JLabel(i1);
                la1.setBounds(450,50,350,350);
                add(la1);
		
		JLabel lblName = new JLabel("USER INFORMATION:");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(88, 11, 350, 53);
		contentPane.add(lblName);
                
                JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
                JLabel l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
                t1 = new JTextField();
	        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
                t1.setForeground(new Color(105, 70, 105));
                t1.setBounds(160, 70, 200, 20);
                contentPane.add(t1);
                t1.setColumns(10);
                
                JLabel lblId = new JLabel("Name :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
                t2 = new JTextField();
	        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
                t2.setForeground(new Color(105, 70, 105));
                t2.setBounds(160, 110, 200, 20);
                contentPane.add(t2);
                t2.setColumns(10);
                
                JLabel lb2 = new JLabel("User Id :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
                
                t3 = new JTextField();
	        t3.setFont(new Font("Tahoma", Font.BOLD, 13));
                t3.setForeground(new Color(105, 70, 105));
                t3.setBounds(160, 150, 200, 20);
                contentPane.add(t3);
                t3.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Phone :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);
                
                 t4 = new JTextField();
	        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
                t4.setForeground(new Color(105, 70, 105));
                t4.setBounds(160, 190, 200, 20);
                contentPane.add(t4);
                t4.setColumns(10);

                
		JLabel lblGender = new JLabel("Email :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);
                
                t5 = new JTextField();
	        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
                t5.setForeground(new Color(105, 70, 105));
                t5.setBounds(160, 230, 200, 20);
                contentPane.add(t5);
                t5.setColumns(10);
                
		JLabel lblCountry = new JLabel("Gender :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);
                
                t6 = new JTextField();
	        t6.setFont(new Font("Tahoma", Font.BOLD, 13));
                t6.setForeground(new Color(105, 70, 105));
                t6.setBounds(160, 270, 200, 20);
                contentPane.add(t6);
                t6.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);
                
                t7 = new JTextField();
	        t7.setFont(new Font("Tahoma", Font.BOLD, 13));
                t7.setForeground(new Color(105, 70, 105));
                t7.setBounds(160, 310, 200, 20);
                contentPane.add(t7);
                t7.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Present Address :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);
                
                 t8 = new JTextField();
	        t8.setFont(new Font("Tahoma", Font.BOLD, 13));
                t8.setForeground(new Color(105, 70, 105));
                t8.setBounds(160, 350, 200, 20);
                contentPane.add(t8);
                t8.setColumns(10);

		
		JLabel lblDeposite = new JLabel("Country :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);
                
                t9 = new JTextField();
	        t9.setFont(new Font("Tahoma", Font.BOLD, 13));
                t9.setForeground(new Color(105, 70, 105));
                t9.setBounds(160, 390, 200, 20);
                contentPane.add(t9);
                t9.setColumns(10);
                
                JLabel la2 = new JLabel("Cost :");
		la2.setBounds(35, 430, 200, 14);
		//contentPane.add(la2);
		
		JLabel l10 = new JLabel();
		l10.setBounds(271, 430, 200, 14);
		contentPane.add(l10);
                
                btn1 = new JButton("Back");
                btn1.setBounds(355,480,100,30);
                btn1.setBackground(new Color(125,149,185));
                btn1.setForeground(Color.black);
                btn1.setBorder(null);
                contentPane.add(btn1);
                btn1.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ae) {
               dispose();
            try {
                new dashBoard(username).setVisible(true);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
            }
                });
                
                JButton btn_show = new JButton("Show");
		btn_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                Conn con = new Conn();
                                
                                String sql = "select * from user_info where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                 st.setString(1, t1.getText());
                 ResultSet rs = st.executeQuery();

                 while (rs.next()) {
                 t2.setText(rs.getString("name"));
                 t3.setText(rs.getString("ID"));
                 t4.setText(rs.getString("phone"));
                 t5.setText(rs.getString("email"));
                 t6.setText(rs.getString("gender"));
                 t7.setText(rs.getString("parmanent_address"));
                 t8.setText(rs.getString("parmanent_address"));
                 t9.setText(rs.getString("country"));
                 }
                                
                                
                                
                            }catch(Exception e1)
                            {
                               System.out.println(e);
                            }
			}
		}); 
		btn_show.setBounds(80, 470, 120, 30);
                btn_show.setBackground(new Color(125,149,185));
                btn_show.setForeground(Color.black);
		contentPane.add(btn_show);
                
                getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        user_information frame = new user_information(" ");
        frame.setVisible(true);
        
    }
    
    
}            
        
     
