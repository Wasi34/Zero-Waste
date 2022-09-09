package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class offer_service extends JFrame {

    private Container c;
    public JLabel lbel1, lbel2, lbel3, info1, info2, info3, info4, ninfo1, ninfo2, ninfo3, ninfo4, event_for;
    private JPanel p1, p2, p3;
    private Font fn1, fn2;
    private JLabel f1, f2, f3, f4, f6, f7, f8, f9;
    private JTextField f5;
    JMenu m1, m2, m3, m4, m5, m6;
    JMenuBar menuBar;
    String username, uname;

     class JPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(156,222,185);
          
          //  Color color2 = new Color(245,245,220);
          Color color2 = new Color(177, 193, 216);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    offer_service(final String username) {

        this.username = username;
        this.setBounds(500, 200, 640, 720);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(177, 193, 216));
        fn1 = new Font("Arial", Font.BOLD, 30);
        fn2 = new Font("Arial", Font.BOLD, 20);

        p1 = new JPanelGradient();
        p1.setBounds(0, 0, 620, 60);
        p1.setBackground(new Color(125, 149, 185));
        p1.setLayout(null);

        p1.setBorder(new LineBorder(Color.black, 4));
        c.add(p1);

        lbel1 = new JLabel("Want to Offer Help at Donation Event?");
        lbel1.setBounds(30, 10, 550, 40);
        lbel1.setFont(fn1);
        lbel1.setForeground(Color.black);
        p1.add(lbel1);

        p2 = new JPanelGradient();
        p2.setBounds(0, 75, 620, 210);
        p2.setBackground(new Color(177, 193, 216));
        p2.setBorder(new LineBorder(Color.black, 3));
        p2.setLayout(null);
        c.add(p2);

        lbel2 = new JLabel("Personal Information Details");
        lbel2.setBounds(30, 10, 450, 40);
        lbel2.setFont(fn1);
        lbel2.setForeground(Color.black);
        lbel2.setBorder(new LineBorder(Color.black, 4));
        lbel2.setBackground(new Color(125, 149, 185));
        p2.add(lbel2);

        info1 = new JLabel("Username");
        info1.setBounds(30, 65, 100, 40);
        info1.setForeground(Color.black);
        info1.setFont(fn2);
        p2.add(info1);

        Conn con = new Conn();
        String sql = "select * from users where username = '" + username + "' ";
        PreparedStatement st;
        try {
            st = con.c.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                uname = rs.getString("username");
                String mail = rs.getString("email");
                String phone = rs.getString("phone");

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        f1 = new JLabel(username);
        f1.setBounds(250, 60, 230, 40);
        f1.setBorder(new LineBorder(Color.black, 3));
        f1.setBackground(Color.white);
        p2.add(f1);

        info2 = new JLabel("Email");
        info2.setBounds(30, 110, 100, 40);
        info2.setForeground(Color.black);
        info2.setFont(fn2);
        p2.add(info2);

        f2 = new JLabel();
        f2.setBounds(250, 105, 230, 40);
        f2.setBorder(new LineBorder(Color.black, 3));
        f2.setBackground(Color.white);
        p2.add(f2);
        info3 = new JLabel("Phone");
        info3.setBounds(30, 150, 100, 40);
        info3.setForeground(Color.black);
        info3.setFont(fn2);
        p2.add(info3);

        f3 = new JLabel();
        f3.setBounds(250, 155, 230, 40);
        f3.setBorder(new LineBorder(Color.black, 3));
        f3.setBackground(Color.white);
        p2.add(f3);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from users where username = '" + username + "'");
            while (rs.next()) {
                f1.setText(rs.getString("username"));
                f2.setText(rs.getString("email"));
                f3.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        p3 = new JPanelGradient();
        p3.setBounds(0, 300, 620, 300);
        p3.setBackground(new Color(177, 193, 216));
        p3.setBorder(new LineBorder(Color.black, 3));
        p3.setLayout(null);
        c.add(p3);

        lbel3 = new JLabel("Event Details");
        lbel3.setBackground(new Color(125, 149, 185));
        lbel3.setForeground(Color.black);
        lbel3.setBounds(30, 10, 300, 40);
        lbel3.setFont(fn1);
        lbel3.setBorder(new LineBorder(Color.black, 4));
        p3.add(lbel3);

        ninfo1 = new JLabel("Event ID");
        ninfo1.setBounds(30, 70, 100, 40);
        ninfo1.setForeground(Color.black);
        ninfo1.setFont(fn2);
        p3.add(ninfo1);
        f5 = new JTextField();
        f5.setBounds(250, 65, 230, 35);
        f5.setBorder(new LineBorder(Color.black, 3));
        f5.setBackground(Color.white);
        p3.add(f5);

        ninfo2 = new JLabel("Event Name");
        ninfo2.setBounds(30, 110, 200, 40);
        ninfo2.setForeground(Color.black);

        ninfo2.setFont(fn2);
        p3.add(ninfo2);

        f6 = new JLabel();
        f6.setBounds(250, 110, 230, 35);
        f6.setBorder(new LineBorder(Color.black, 3));
        f6.setBackground(Color.white);
        p3.add(f6);

        ninfo3 = new JLabel("Event Time");
        ninfo3.setBounds(30, 153, 200, 40);
        ninfo3.setForeground(Color.black);
        ninfo3.setFont(fn2);
        p3.add(ninfo3);
        f7 = new JLabel();
        f7.setBounds(250, 155, 230, 35);
        f7.setBorder(new LineBorder(Color.black, 3));
        f7.setBackground(Color.white);
        p3.add(f7);

        ninfo4 = new JLabel("Event Location");
        ninfo4.setBounds(30, 196, 160, 40);
        ninfo4.setForeground(Color.black);
        ninfo4.setFont(fn2);
        p3.add(ninfo4);
        f8 = new JLabel();
        f8.setBounds(250, 200, 230, 35);
        f8.setBorder(new LineBorder(Color.black, 3));
        f8.setBackground(Color.white);
        p3.add(f8);

        event_for = new JLabel("Event For");
        event_for.setBounds(30, 240, 160, 40);
        event_for.setForeground(Color.black);
        event_for.setFont(fn2);
        p3.add(event_for);
        f9 = new JLabel();
        f9.setBounds(250, 243, 230, 35);
        f9.setBorder(new LineBorder(Color.black, 3));
        f9.setBackground(Color.white);
        p3.add(f9);

        JButton btn1 = new JButton("SHOW");
        btn1.setBounds(80, 615, 120, 40);
        btn1.setFont(fn2);
        btn1.setBorder(new LineBorder(Color.black));
        btn1.setBackground(new Color(125, 149, 185));
        btn1.setForeground(Color.black);
        c.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Conn con = new Conn();

                //String str = "select * from event where event_id = '" + username + "' ";
                String sql = "select * from event where event_id=?";
                PreparedStatement st;
                try {
                    st = con.c.prepareStatement(sql);

                    st.setString(1, f5.getText());
                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        f6.setText(rs.getString("event_name"));
                        f7.setText(rs.getString("date_time"));
                        f8.setText(rs.getString("location"));
                        f9.setText(rs.getString("event_for"));

                    } else {
                        new dialog("Invalid Event ID. Please Try Again.").setVisible(true);
                       
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        });

        JButton btn2 = new JButton("SUBMIT");
        btn2.setBounds(240, 615, 120, 40);
        btn2.setFont(fn2);
        btn2.setBorder(new LineBorder(Color.black));
        btn2.setBackground(new Color(125, 149, 185));
        btn2.setForeground(Color.black);
        c.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Conn con = new Conn();
                String sql = "insert into offer_help (username,email ,phone, event_ID,event_name,event_time,event_location,event_for)values(?,?,?,?,?,?,?,?)";
                PreparedStatement st;
                try {
                    st = con.c.prepareStatement(sql);
                    st.setString(1, f1.getText());
                    st.setString(2, f2.getText());
                    st.setString(3, f3.getText());
                    st.setString(4, f5.getText());
                    st.setString(5, f6.getText());
                    st.setString(6, f7.getText());
                    st.setString(7, f8.getText());
                    st.setString(8, f9.getText());

                    String username = f1.getText();
                    String email = f2.getText();
                    String phone = f3.getText();
                    String event_ID = f5.getText();
                    String event_name = f6.getText();
                    String event_time = f7.getText();
                    String event_location = f8.getText();
                    String event_for = f9.getText();

                    if (username.equals("")) {

                        JOptionPane.showMessageDialog(null, "Please fill out name feild ");

                    } else if (email.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out email feild");

                    } else if (phone.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out phone feild");
                    } else if (event_ID.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event ID feild");
                    } else if (event_name.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event Name feild");
                    } else if (event_time.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event Time feild");
                    } else if (event_location.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event Location feild");
                    } else if (event_for.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out the Event For  feild");
                    } else {

                        int i = st.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Thanks for filling the form ");
                        }

                        f1.setText("");
                        f2.setText("");
                        f3.setText("");
                        f5.setText("");
                        f6.setText("");
                        f7.setText("");
                        f8.setText("");
                        f9.setText("");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                try {
                    dispose();
                    new volunteer_dashBoard(username).setVisible(true);
                } catch (FileNotFoundException ex) {

                }

            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(400, 615, 130, 40);
        back.setFont(fn2);
        back.setBorder(new LineBorder(Color.black));
        back.setBackground(new Color(125, 149, 185));
        back.setForeground(Color.black);
        c.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                dispose();
                try {
                    new volunteer_dashBoard(username).setVisible(true);
                } catch (FileNotFoundException ex) {

                }

            }
        });
    }

    public static void main(String[] args) {

        offer_service frame = new offer_service(" ");
        frame.setVisible(true);

    }

}
