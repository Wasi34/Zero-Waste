package zero_waste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class dashBoard extends JFrame {

    private Container c;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel ilab1, ilab2, wtextl1, wtextl2, wtext4, wtextl3, ntextl1, ntextl2, ntextl3, ctextl1, text;
    private ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, img9, img10,img11;
    private JButton sb1, sb2, sb3, sb4, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8,cb9;
    private BorderLayout blayout;
    private JLabel t1, t2,l,l1;
    private JPanel contentPane;
    private JLabel Donate;
    String name, piclocation, username;
    login logobj = new login();

    public static void main(String[] args) throws FileNotFoundException {
        dashBoard frame = new dashBoard(" ");
        frame.setVisible(true);

    }

    dashBoard(String username) throws FileNotFoundException {
        Go(username);
    }

    dashBoard() {

    }
    
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

    public void Go(final String username) throws FileNotFoundException {
        
         
        this.username = username;
        this.setBounds(450, 150, 1010, 730);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DashBoard");
        setResizable(false);
        c = this.getContentPane();
        c.setBackground(new Color(177, 193, 216));

        blayout = new BorderLayout();
        c.setLayout(blayout);

        panel1 = new JPanelGradient();
        //panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(0, 200));
        panel1.setBorder(new LineBorder(Color.BLACK, 0));  //BORDER LINE
        panel1.setLayout(new FlowLayout(4));

        t1 = new JLabel();
        t1.setBounds(70, 217, 100, 20);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        add(t1);
        
        JLabel h = new JLabel("Hello, ");
        h.setBounds(10,217,90,20);
        h.setForeground(Color.BLACK);
        h.setFont(new Font("Arial", Font.BOLD, 20));
        add(h);
        
        l = new JLabel();
        l.setBounds(4, 208, 140, 50);
        l.setForeground(Color.BLACK);
        l.setBorder(new LineBorder(Color.BLACK, 2));
        l.setFont(new Font("Arial", Font.BOLD, 20));
        add(l);
        
        l1 = new JLabel();
        l1.setBounds(4, 258, 140, 50);
        l1.setForeground(Color.BLACK);
        l1.setBorder(new LineBorder(Color.BLACK, 2));
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        add(l1);

//        l = new JLabel();
//        l.setBounds(4, 214, 100, 20);
//        l.setForeground(Color.BLACK);
//        l.setFont(new Font("Arial", Font.BOLD, 20));
//        add(l);
        
        ntextl2 = new JLabel("");
        panel1.add(ntextl2);
        panel1.setBackground(new Color(164,196,224));
        
        JLabel heading = new JLabel("Welcome to Donar Home Page");
        heading.setBounds(220,70,600,40);
       // heading.setForeground(Color.BLACK);
        heading.setForeground(Color.BLACK);
       
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        add(heading);

        JLabel id = new JLabel("User ID: ");
        id.setBounds(10,280,90,20);
        id.setForeground(Color.BLACK);
        id.setFont(new Font("Arial", Font.BOLD, 20));
        add(id);
        
        t2 = new JLabel();
        t2.setBounds(95,280,50,20);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Arial", Font.BOLD, 20));
        add(t2);
        
        JLabel t4 = new JLabel("           ");
        t2.setBounds(95,280,50,20);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Arial", Font.BOLD, 20));
        add(t2);

        img1 = new ImageIcon(getClass().getResource("design\\logo.png"));
        ilab1 = new JLabel(img1);
        ilab1.setBounds(850, 28, 130, 130);
        add(ilab1);
       // panel1.add(ilab1);
        c.add(panel1, BorderLayout.NORTH);

       // panel2 = new JPanel();
        panel2 = new JPanelGradient();
        panel2.setLayout(new FlowLayout(1, 50, 55));
        panel2.setBackground(new Color(194,220,242));
        img2 = new ImageIcon(getClass().getResource("design\\dinformation.png"));
        ilab2 = new JLabel(img2);
        ilab2.setBounds(0, 50, 300, 300);
        cb1 = new JButton();
        cb1.add(ilab2);
        cb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new donation_information(username).setVisible(true);
            }
        });

//        Donate = new JLabel("");
//        Donate.setBounds(200, 250, 200, 200);
//        panel2.add(Donate);

        cb1.setBackground(Color.BLACK);

        panel2.add(cb1);
        img3 = new ImageIcon(getClass().getResource("design\\e.png"));
        cb2 = new JButton(img3);
        cb2.setBackground(Color.BLACK);
        panel2.add(cb2);
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();

                DBTable_Event_History st = new DBTable_Event_History(username);
                st.setVisible(true);

            }
        });

        img5 = new ImageIcon(getClass().getResource("design\\inf.png"));
        cb4 = new JButton(img5);
        cb4.setBackground(Color.BLACK);
        panel2.add(cb4);
        cb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new user_information(username).setVisible(true);
            }
        });
        img6 = new ImageIcon(getClass().getResource("design\\d.png"));
        cb5 = new JButton(img6);
        cb5.setBackground(Color.BLACK);
        panel2.add(cb5);

        cb5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //  new Gps().setVisible(true);
                dispose();
                new orgDonationForm(username).setVisible(true);
            }
        });
         img11 = new ImageIcon(getClass().getResource("design\\on_event_donation.png"));
        cb9 = new JButton(img11);
        cb9.setBackground(Color.BLACK);
        panel2.add(cb9);

        cb9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new onEvntDonation(username).setVisible(true);
            }
        });
        
        JLabel Donation_info = new JLabel("All Donation Information");
        Donation_info.setBounds(212,400,250,16);
        Donation_info.setForeground(Color.BLACK);
        Donation_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donation_info);
        
        JLabel event_info = new JLabel("Event Information");
        event_info.setBounds(452,400,250,16);
        event_info.setForeground(Color.BLACK);
        event_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(event_info);
        
        JLabel my_info = new JLabel("My Information");
        my_info.setBounds(675,400,250,16);
        my_info.setForeground(Color.BLACK);
        my_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(my_info);
        
        JLabel Donate_org = new JLabel("Donate to Organization");
        Donate_org.setBounds(212,597,250,20);
        Donate_org.setForeground(Color.BLACK);
        Donate_org.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donate_org);
        
        JLabel Donate_evt = new JLabel("Donate to Event");
        Donate_evt.setBounds(455,597,250,20);
        Donate_evt.setForeground(Color.BLACK);
        Donate_evt.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donate_evt);
        
        JLabel update = new JLabel("Update Profile");
        update.setBounds(677,597,250,20);
        update.setForeground(Color.BLACK);
        update.setFont(new Font("Arial", Font.BOLD, 16));
        add(update);
        
        //img7 = new ImageIcon(getClass().getResource("design\\u.png"));
        img7 = new ImageIcon(getClass().getResource("design\\dupdate.png"));
        cb6 = new JButton(img7);
        cb6.setBackground(Color.BLACK);
        panel2.add(cb6);
        cb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new update_information(username).setVisible(true);

            }
        });

        c.add(panel2, BorderLayout.CENTER);
//        panel3 = new JPanel();
//        c.add(panel3, BorderLayout.SOUTH);
        panel4 = new JPanelGradient();
        panel4.setPreferredSize(new Dimension(150, 0));
       panel4.setBackground(new Color(177, 193, 216));
        panel4.setBorder(new LineBorder(Color.black, 0));//BORDER LINE
        panel4.setLayout(new GridLayout(8, 1, 5, 10));
//        wtextl2 = new JLabel("Hello");
//        wtextl2.setFont(new Font("Arial", Font.BOLD, 20));
//        wtextl2.setForeground(Color.BLACK);
//        wtextl2.setBounds(10,300,20,20);
//        panel4.add(wtextl2);
        c.add(panel4, BorderLayout.WEST);
        panel5 = new JPanelGradient();
        panel5.setPreferredSize(new Dimension(105, 0));
       // panel5.setBackground(new Color(125,149,185));
        panel5.setLayout(new GridLayout(6, 1, 5, 1));
        panel5.setBorder(new LineBorder(Color.black, 0));//BORDER LINE
        img3 = new ImageIcon(getClass().getResource("design\\logout.png"));
        sb1 = new JButton("");
        sb1.setBackground(new Color(177, 193, 216));
        panel5.setBackground(new Color(177, 193, 216));
       // panel5.add(sb1);
     
        sb4 = new JButton(img3);
        sb4.setBackground(Color.BLACK);
        panel5.add(sb4);
        sb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                dispose();
            }
        });

        c.add(panel5, BorderLayout.EAST);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from users where username = '" + username + "'");
            while (rs.next()) {
                t1.setText(rs.getString("name"));
                t2.setText(rs.getString("user_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
