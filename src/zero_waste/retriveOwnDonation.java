
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class retriveOwnDonation extends JFrame {

    private Container c;
    public JLabel lbel1, lbel2, lbel3, info1, info2, info3, info4, ninfo1, ninfo2, ninfo3, ninfo4, ninfo5;
    private JPanel p1, p2, p3;
    private Font fn1, fn2;
    private JLabel f1, f2, f3, f4, f5, f6, f7, f8, f9,  ngot;
    private JLabel did;
    JMenu m1, m2, m3, m4, m5, m6;
    JMenuBar menuBar;
    private ImageIcon img1;
    String username;

    retriveOwnDonation(final String username) {

        this.username = username;
        this.setBounds(670, 200, 640, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);

        c.setBackground(new Color(177, 193, 216));
        fn1 = new Font("Arial", Font.BOLD, 30);
        fn2 = new Font("Arial", Font.BOLD, 20);

        p1 = new JPanel();
        p1.setBounds(0, 0, 620, 60);
        p1.setBackground(new Color(125, 149, 185));
        p1.setLayout(null);
        p1.setBorder(new LineBorder(Color.black, 4));
        c.add(p1);

        lbel1 = new JLabel("Your Event Donation Information");
        lbel1.setBounds(83, 10, 490, 40);
        lbel1.setFont(fn1);
        lbel1.setForeground(Color.BLACK);
        p1.add(lbel1);

        p2 = new JPanel();
        p2.setBounds(0, 125, 620, 450);
        
        p2.setBackground(new Color(177,193,216));
        p2.setBorder(new LineBorder(Color.black, 3));
        p2.setLayout(null);
        c.add(p2);

        lbel2 = new JLabel("User ID:");
        lbel2.setBounds(30, 10, 300, 40);
        lbel2.setFont(fn1);
        lbel2.setForeground(Color.BLACK);
        p2.add(lbel2);

        did = new JLabel();
        did.setBounds(170, 15, 50, 30);
        did.setFont(fn1);
        did.setForeground(Color.BLACK);
        did.setBorder(new LineBorder(Color.BLACK));
        p2.add(did);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from users where username = '" + username + "'");
            while (rs.next()) {

                did.setText(rs.getString("user_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        info1 = new JLabel("Name");
        info1.setBounds(30, 70, 100, 40);
        info1.setForeground(Color.black);
        info1.setFont(fn2);
        p2.add(info1);

        f1 = new JLabel();
        f1.setBounds(250, 70, 180, 30);
        f1.setBorder(new LineBorder(Color.black, 3));
        f1.setFont(fn2);
        f1.setForeground(Color.BLACK);
        f1.setBackground(Color.white);
        p2.add(f1);

        info2 = new JLabel("Email");
        info2.setBounds(30, 110, 100, 40);
        info2.setForeground(Color.black);
        info2.setFont(fn2);
        p2.add(info2);

        f2 = new JLabel();
        f2.setBounds(250, 110, 180, 30);
        f2.setBorder(new LineBorder(Color.black, 3));
        f2.setForeground(Color.BLACK);
        f2.setFont(fn2);
        f2.setBackground(Color.white);
        p2.add(f2);
        info3 = new JLabel("Phone");
        info3.setBounds(30, 150, 100, 40);
        info3.setForeground(Color.black);
        info3.setFont(fn2);
        p2.add(info3);

        f3 = new JLabel();
        f3.setBounds(250, 153, 180, 30);
        f3.setBorder(new LineBorder(Color.black, 3));
        f3.setFont(fn2);
        f3.setForeground(Color.BLACK);
        f3.setBackground(Color.white);
        p2.add(f3);

        info4 = new JLabel("Location");
        info4.setBounds(30, 190, 150, 40);
        info4.setForeground(Color.black);
        info4.setFont(fn2);
        p2.add(info4);

        f4 = new JLabel();
        f4.setBounds(250, 193, 180, 30);
        f4.setBorder(new LineBorder(Color.black, 3));
        f4.setForeground(Color.BLACK);
        f4.setFont(fn2);
        f4.setBackground(Color.white);
        p2.add(f4);

        ninfo2 = new JLabel("Event Name");
        ninfo2.setBounds(30, 240, 250, 40);
        ninfo2.setForeground(Color.black);

        ninfo2.setFont(fn2);
        p2.add(ninfo2);

        f6 = new JLabel();
        f6.setBounds(250, 243, 180, 30);
        f6.setBorder(new LineBorder(Color.black, 3));
        f6.setForeground(Color.BLACK);
        f6.setFont(fn2);
        f6.setBackground(Color.white);
        p2.add(f6);

        ninfo3 = new JLabel("Food Type");
        ninfo3.setBounds(30, 285, 200, 40);
        ninfo3.setForeground(Color.black);
        ninfo3.setFont(fn2);
        p2.add(ninfo3);
        f7 = new JLabel();
        f7.setBounds(250, 289, 180, 30);
        f7.setFont(fn2);
        f7.setForeground(Color.BLACK);
        f7.setBorder(new LineBorder(Color.black, 3));
        f7.setBackground(Color.white);
        p2.add(f7);

        ninfo4 = new JLabel("Quantity");
        ninfo4.setBounds(30, 335, 100, 40);
        ninfo4.setForeground(Color.black);
        ninfo4.setFont(fn2);
        p2.add(ninfo4);
        f8 = new JLabel();
        f8.setBounds(250, 339, 180, 30);
        f8.setFont(fn2);
        f8.setForeground(Color.BLACK);
        f8.setBorder(new LineBorder(Color.black, 3));
        f8.setBackground(Color.white);
        p2.add(f8);
        ninfo5 = new JLabel("Location");
        ninfo5.setBounds(30, 380, 100, 40);
        ninfo5.setForeground(Color.black);
        ninfo5.setFont(fn2);
        p2.add(ninfo5);
        f9 = new JLabel();
        f9.setBounds(250, 384, 180, 30);
        f9.setBorder(new LineBorder(Color.black, 3));
        f9.setFont(fn2);
        f9.setForeground(Color.BLACK);
        f9.setBackground(Color.white);
        p2.add(f9);

        JButton btn1 = new JButton("GET");
        btn1.setBounds(140, 600, 100, 40);
        btn1.setFont(fn2);
        btn1.setBorder(new LineBorder(Color.black));
        btn1.setBackground(new Color(125, 149, 185));;
        btn1.setForeground(Color.black);
        c.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from event_donation_form where username = '" + username + "'");
                    while (rs.next()) {
                        f1.setText(rs.getString("userName"));
                        f2.setText(rs.getString("email"));
                        f3.setText(rs.getString("phone"));
                        f4.setText(rs.getString("location"));
                        f6.setText(rs.getString("ngo"));
                        f7.setText(rs.getString("food_type"));
                        f8.setText(rs.getString("date_of_cooking"));
                        f9.setText(rs.getString("quantity"));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });

        JButton btn2 = new JButton("BACK");
        btn2.setBounds(340, 600, 100, 40);
        btn2.setFont(fn2);
        btn2.setBorder(new LineBorder(Color.black));
        btn2.setBackground(new Color(125, 149, 185));
        btn2.setForeground(Color.black);
        c.add(btn2);
        btn2.addActionListener(new ActionListener() {
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
    }

    public static void main(String[] args) {

        retriveOwnDonation frame = new retriveOwnDonation(" ");
        frame.setVisible(true);

    }

}
