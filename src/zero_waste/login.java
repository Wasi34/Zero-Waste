
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

public class login extends JFrame implements ActionListener {

    private JPanel panel1, panel2;
    private JLabel txtlb1, txtlb2, txtlb3, imgl, imgl2, imgl3;
    private JTextField textfld;
    private JPasswordField pass;
    private JComboBox c2;
    private JButton button1, button2, button3;
    private Font fn;
    private ImageIcon img, img2, img3;
    private Container c;
    String name;

    login() {
        start();
    }

    void start() {
        c = this.getContentPane();
         setResizable(false);
        c.setLayout(null);
        c.setBackground(Color.white);

        fn = new Font("Arial", Font.BOLD, 20);
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(125, 149, 185));
        panel1.setBounds(0, 0, 450, 440);
        c.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(177, 193, 216));
        panel2.setBounds(450, 0, 450, 440);
        c.add(panel2);

        txtlb1 = new JLabel("Welcome to the Zero Waste");
        txtlb1.setBounds(30, 0, 450, 160);
        txtlb1.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(txtlb1);

        img = new ImageIcon(getClass().getResource("design\\login.png"));
        imgl = new JLabel(img);
        imgl.setBounds(105, 130, 200, 225);
        panel1.add(imgl);

        txtlb2 = new JLabel("Username");
        txtlb2.setBounds(50, 15, 200, 30);
        txtlb2.setFont(fn);
        txtlb2.setForeground(Color.BLACK);
        panel2.add(txtlb2);

        textfld = new JTextField();
        textfld.setBounds(50, 55, 320, 30);
        textfld.setBorder(BorderFactory.createEmptyBorder());
        textfld.setFont(new Font("SAN_SARIF", Font.PLAIN, 25));
        panel2.add(textfld);


        txtlb3 = new JLabel("Password");
        txtlb3.setBounds(50, 115, 200, 30);
        txtlb3.setFont(fn);
        txtlb3.setForeground(Color.BLACK);
        panel2.add(txtlb3);

        pass = new JPasswordField();
        pass.setBounds(50, 158, 320, 30);
        pass.setFont(new Font("SAN_SARIF", Font.PLAIN, 25));
        pass.setBorder(null);
        panel2.add(pass);

        JLabel type = new JLabel("User Type");
        type.setBounds(50, 220, 125, 30);
        type.setFont(fn);
        type.setForeground(Color.BLACK);
        panel2.add(type);

        c2 = new JComboBox();
        c2.setModel(new DefaultComboBoxModel(new String[]{"Donor", "Volunteer", "Admin"}));
        c2.setBackground(Color.white);
        c2.setBounds(190, 220, 180, 30);
        panel2.add(c2);


        
        button1 = new JButton("Login");
        button1.setBounds(40, 315, 95, 35);
        button1.setBackground(new Color(125, 149, 185));
        button1.setForeground(Color.BLACK);
        button1.setBorder(null);
        panel2.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String username = textfld.getText();
                String password = new String(pass.getPassword());;
                String type = String.valueOf(c2.getSelectedItem());

                Conn con = new Conn();

                String str = "select * from users where username = '" + username + "' and password = '" + password + "'and user_type = '" + type + "' ";

                try {

                    ResultSet rs = con.s.executeQuery(str);

                    if (rs.next()) {

                        JOptionPane.showMessageDialog(null, "Successfull");
                        dispose();
                        
                        
                       
                        if (type == "Admin") {

                            new admin_dashBoard(username).setVisible(true);
                        }
                        else if (type == "Volunteer") {

                            new volunteer_dashBoard(username).setVisible(true);
                        }
                        else {
                            new LoadoutPage(textfld.getText()).setVisible(true);
                        }

                    } else {

                        String s = "select * from users where username = '" + username + "' ";
                        try {

                            ResultSet rs1 = con.s.executeQuery(s);

                            if (!rs1.next()) {
                                new dialog("Invalid Username. Please Try Again.").setVisible(true);
                                textfld.setText("");
                                pass.setText("");
                                return;

                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        String s1 = "select * from users where password = '" + password + "' ";
                        try {

                            ResultSet rs2 = con.s.executeQuery(s1);

                            if (!rs2.next()) {
                                new dialog("Invalid Password for " + username + ". Please Try Again.").setVisible(true);
                                textfld.setText("");
                                pass.setText("");
                                return;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                        String s2 = "select * from users where username = '" + username + "' and password = '" + password + "'and user_type = '" + type + "' ";;
                        try {

                            ResultSet rs3 = con.s.executeQuery(s2);

                            if (!rs3.next()) {
                                new dialog("Invalid User Type for " + username + ". Please Try Again.").setVisible(true);
                                textfld.setText("");
                                pass.setText("");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }

                    }

                } catch (Exception e) {

                }
            }
        });

        
        
        button2 = new JButton("SignUp");
        button2.setBounds(150, 315, 90, 35);
        button2.setForeground(Color.BLACK);
        button2.setBorder(null);
        button2.setBackground(new Color(125, 149, 185));
        panel2.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new signup().setVisible(true);
                dispose();
            }
        });

        
        button3 = new JButton("Forgot Password");
        button3.setBounds(255, 315, 120, 35);
        button3.setBackground(new Color(125, 149, 185));
        button3.setBorder(null);

        button3.setForeground(Color.BLACK);
        panel2.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
