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

public class retriveOrgDonation extends JFrame {

    private Container c;
    public JLabel lbel1, lbel2, lbel3, info1, info2, info3, info4, ninfo1, ninfo2, ninfo3, ninfo4;
    private JPanel p1, p2, p3;
    private Font fn1, fn2;
    private JLabel f1, f2, f3, f4, f5, f6, f7, f8;
    private JLabel did, ngot;
    JMenu m1, m2, m3, m4, m5, m6;
    JMenuBar menuBar;
    private ImageIcon img1;
    String username;

    retriveOrgDonation(final String username) {
        this.username = username;
        this.setBounds(580, 230, 620, 680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);
       c.setBackground(new Color(177,193,216));
        fn1 = new Font("Arial", Font.BOLD, 30);
        fn2 = new Font("Arial", Font.BOLD, 20);

        p1 = new JPanel();
        p1.setBounds(0, 0, 600, 60);
        p1.setBackground(new Color(125, 149, 185));
        p1.setLayout(null);
        p1.setBorder(new LineBorder(Color.black, 4));
        c.add(p1);

        lbel1 = new JLabel("Your Donation Information");
        lbel1.setBounds(135, 10, 400, 40);
        lbel1.setFont(fn1);
        lbel1.setForeground(Color.BLACK);
        p1.add(lbel1);

        p2 = new JPanel();
        p2.setBounds(0, 125, 600, 400);
        p2.setBackground(new Color(177,193,216));
        p2.setBorder(new LineBorder(Color.black, 3));
        p2.setLayout(null);
        c.add(p2);

        lbel2 = new JLabel("Donate ID:");
        lbel2.setBounds(30, 10, 450, 40);
        lbel2.setFont(fn1);
        lbel2.setForeground(Color.BLACK);
        p2.add(lbel2);

        did = new JLabel();
        did.setBounds(180, 10, 70, 40);
        did.setFont(fn1);
        did.setForeground(Color.BLACK);
        did.setBorder(new LineBorder(Color.BLACK));
        p2.add(did);

        ninfo1 = new JLabel("NGO:");
        ninfo1.setBounds(270, 10, 130, 40);
        ninfo1.setFont(fn1);
        ninfo1.setForeground(Color.BLACK);
       // p2.add(ninfo1);

        ngot = new JLabel();
        ngot.setBounds(350, 10, 240, 40);
        ngot.setFont(fn1);
        ngot.setForeground(Color.BLACK);
        ngot.setBorder(new LineBorder(Color.BLACK));
        //p2.add(ngot);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from donation_form where username = '" + username + "'");
            while (rs.next()) {
                did.setText(rs.getString("donation_id"));
               // ngot.setText(rs.getString("ngo"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        info1 = new JLabel("Username");
        info1.setBounds(30, 70, 100, 40);
        info1.setForeground(Color.black);
        info1.setFont(fn2);
        p2.add(info1);

        f1 = new JLabel();
        f1.setBounds(250, 72, 180, 30);
        f1.setBorder(new LineBorder(Color.black, 3));
        f1.setFont(fn2);
        f1.setForeground(Color.black);
        f1.setBackground(Color.white);
        p2.add(f1);

        info2 = new JLabel("Email");
        info2.setBounds(30, 110, 100, 40);
        info2.setForeground(Color.black);
        info2.setFont(fn2);
        p2.add(info2);

        f2 = new JLabel();
        f2.setBounds(250, 117, 180, 30);
        f2.setFont(fn2);
        f2.setForeground(Color.black);
        f2.setBorder(new LineBorder(Color.black, 3));
        f2.setBackground(Color.white);
        p2.add(f2);
        info3 = new JLabel("Phone");
        info3.setBounds(30, 150, 100, 40);
        info3.setForeground(Color.black);
        info3.setFont(fn2);
        p2.add(info3);

        f3 = new JLabel();
        f3.setBounds(250, 153, 180, 30);
        f3.setFont(fn2);
        f3.setForeground(Color.black);
        f3.setBorder(new LineBorder(Color.black, 3));
        f3.setBackground(Color.white);
        p2.add(f3);

        info4 = new JLabel("Location");
        info4.setBounds(30, 190, 100, 40);
        info4.setForeground(Color.black);
        info4.setFont(fn2);
        p2.add(info4);

        f4 = new JLabel();
        f4.setBounds(250, 195, 180, 30);
        f4.setBorder(new LineBorder(Color.black, 3));
        f4.setFont(fn2);
        f4.setForeground(Color.black);
        f4.setBackground(Color.white);
        p2.add(f4);

        ninfo2 = new JLabel("Type of food");
        ninfo2.setBounds(30, 240, 200, 40);
        ninfo2.setForeground(Color.black);

        ninfo2.setFont(fn2);
        p2.add(ninfo2);

        f6 = new JLabel();
        f6.setBounds(250, 243, 180, 30);
        f6.setFont(fn2);
        f6.setForeground(Color.black);
        f6.setBorder(new LineBorder(Color.black, 3));
        f6.setBackground(Color.white);
        p2.add(f6);

        ninfo3 = new JLabel("Date of Cooking");
        ninfo3.setBounds(30, 285, 200, 40);
        ninfo3.setForeground(Color.black);
        ninfo3.setFont(fn2);
        p2.add(ninfo3);
        f7 = new JLabel();
        f7.setBounds(250, 288, 180, 30);
        f7.setFont(fn2);
        f7.setForeground(Color.black);
        f7.setBorder(new LineBorder(Color.black, 3));
        f7.setBackground(Color.white);
        p2.add(f7);

        ninfo4 = new JLabel("Qunatity");
        ninfo4.setBounds(30, 335, 100, 40);
        ninfo4.setForeground(Color.black);
        ninfo4.setFont(fn2);
        p2.add(ninfo4);
        f8 = new JLabel();
        f8.setBounds(250, 338, 180, 30);
        f8.setFont(fn2);
        f8.setForeground(Color.black);
        f8.setBorder(new LineBorder(Color.black, 3));
        f8.setBackground(Color.white);
        p2.add(f8);

        JButton btn1 = new JButton("GET");
        btn1.setBounds(135, 550, 100, 40);
        btn1.setFont(fn2);
        btn1.setBorder(new LineBorder(Color.black,2));
        btn1.setBackground(new Color(125, 149, 185));
        btn1.setForeground(Color.black);
        c.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from donation_form where username = '" + username + "'");
                    while (rs.next()) {
                        f1.setText(rs.getString("userName"));
                        f2.setText(rs.getString("email"));
                        f3.setText(rs.getString("phone"));
                        f4.setText(rs.getString("location"));
                        f6.setText(rs.getString("food_type"));
                        f7.setText(rs.getString("date_of_cooking"));
                        f8.setText(rs.getString("quatity"));

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        JButton btn2 = new JButton("BACK");
        btn2.setBounds(330, 550, 100, 40);
        btn2.setFont(fn2);
        btn2.setBorder(new LineBorder(Color.black,2));
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

        retriveOrgDonation frame = new retriveOrgDonation(" ");
        frame.setVisible(true);

    }

}
