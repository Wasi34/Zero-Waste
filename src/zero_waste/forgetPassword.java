package zero_waste;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class forgetPassword extends JFrame implements ActionListener {

    private JPanelGradient contentPane;
    private JTextField t1, t2, t3, t4, t5, t6;
    private JButton b1, b2, b3;
    
         class JPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(135,206,235);
            Color color2 = new Color(28,40,65);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    

    forgetPassword() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(630, 300, 600, 375);
        contentPane = new JPanelGradient();
        setResizable(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        


        JPanel panel2 = new JPanel();

        panel2.setBounds(0, 0, 580, 44);
        panel2.setBackground(new Color(125, 149, 185));
        panel2.setBorder(new LineBorder(Color.black, 5));
        contentPane.add(panel2);
        JLabel textlabel = new JLabel("Recovery !");
        textlabel.setBounds(45, 20, 250, 22);
        textlabel.setForeground(Color.black);
        textlabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel2.add(textlabel);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(109, 83, 87, 29);
        contentPane.add(l1);
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(109, 122, 75, 21);
        contentPane.add(l2);
        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 154, 156, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(new Color(105, 105, 105));
        t1.setBounds(277, 88, 139, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(true);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(277, 123, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(true);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(125, 149, 185));
        t3.setColumns(10);
        t3.setBounds(277, 161, 270, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(277, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(50, 205, 50));
        t5.setColumns(10);
        t5.setBounds(277, 225, 139, 20);
        contentPane.add(t5);
        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(428, 83, 80, 29);
        b1.setBackground(new Color(177, 193, 216));
        b1.setForeground(Color.black);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 188, 85, 29);
        b2.setBackground(new Color(177, 193, 216));
        b2.setForeground(Color.black);
        contentPane.add(b2);
        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(new Color(177, 193, 216));
        b3.setForeground(Color.black);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBounds(0, 45, 580, 281);
        panel.setBackground(new Color(125, 149, 185));
        panel.setBorder(new LineBorder(Color.black, 5));
        contentPane.add(panel);

    }

    public static void main(String[] args) {
        forgetPassword frame = new forgetPassword();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn();
            if (ae.getSource() == b1) {
                String sql = "select * from users where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("question"));
                }

            }
            if (ae.getSource() == b2) {
                String sql = "select * from user_info where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }

            }
            if (ae.getSource() == b3) {
                this.setVisible(false);
                new login().setVisible(true);

            }
        } catch (Exception e) {

        }
    }
}
