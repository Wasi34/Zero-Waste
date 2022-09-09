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

public class volunteer_dashBoard extends JFrame {

    private Container c;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel ilab1, ilab2, wtextl1, wtextl2, wtext4, wtextl3, ntextl1, ntextl2, ntextl3, ctextl1, text;
    private ImageIcon img1, img2, img3, img4, img5, img6, img7, img8, img9, img10;
    private JButton sb1, sb2, sb3, sb4, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    private BorderLayout blayout;
    private JLabel t1, t2,l,l1;
    private JPanel contentPane;
    String name, piclocation, username;
    login logobj = new login();


    public static void main(String[] args) throws FileNotFoundException {
        volunteer_dashBoard frame = new volunteer_dashBoard("");
        frame.setVisible(true);

    }

    volunteer_dashBoard(String username) throws FileNotFoundException {
        Go(username);

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
  

    volunteer_dashBoard() {
        
    }

    public void Go(final String username) throws FileNotFoundException {
        this.username = username;
        this.setBounds(450, 150, 1010, 730);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setTitle("VOLUNTEER DASHBOARD");
        c = this.getContentPane();
        c.setBackground(new Color(177, 193, 216));

        blayout = new BorderLayout();
        c.setLayout(blayout);

        panel1 = new JPanelGradient();
        panel1.setPreferredSize(new Dimension(0, 200));
        panel1.setBorder(new LineBorder(Color.BLACK, 0));//BORDER LINE
        panel1.setLayout(new FlowLayout(4));

        JLabel h = new JLabel("Hello, ");
        h.setBounds(10,217,90,20);
        h.setForeground(Color.BLACK);
        h.setFont(new Font("Arial", Font.BOLD, 20));
        add(h);
        

        t1 = new JLabel();
        t1.setBounds(70, 217, 100, 20);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        add(t1);
        
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

        ntextl2 = new JLabel("");
        panel1.add(ntextl2);
        panel1.setBackground(new Color(164,196,224));
        
        JLabel heading = new JLabel("Welcome to Volunteer Home Page");
        heading.setBounds(200,70,560,40);
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
 

        panel2 = new JPanelGradient();
        panel2.setLayout(new FlowLayout(1, 50, 55));
        panel2.setBackground(new Color(194,220,242));
        img2 = new ImageIcon(getClass().getResource("design\\work.png"));
        ilab2 = new JLabel(img2);
        ilab2.setBounds(0, 0, 250, 250);
        cb1 = new JButton();
        cb1.add(ilab2);
        cb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new volunteering_info(username).setVisible(true);
            }
        });

        cb1.setBackground(Color.BLACK);

        panel2.add(cb1);
        img3 = new ImageIcon(getClass().getResource("design\\eventt_info.png"));
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
        
        JLabel Donation_info = new JLabel("Volunteering Information");
        Donation_info.setBounds(210,400,250,20);
        Donation_info.setForeground(Color.BLACK);
        Donation_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donation_info);
        
        JLabel event_info = new JLabel("Event Information");
        event_info.setBounds(451,400,250,20);
        event_info.setForeground(Color.BLACK);
        event_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(event_info);
        
        JLabel my_info = new JLabel("My Information");
        my_info.setBounds(675,400,250,20);
        my_info.setForeground(Color.BLACK);
        my_info.setFont(new Font("Arial", Font.BOLD, 16));
        add(my_info);
        
        JLabel Donate_org = new JLabel("Offer Help");
        Donate_org.setBounds(375,597,220,20);
        Donate_org.setForeground(Color.BLACK);
        Donate_org.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donate_org);
        
        JLabel Donate_evt = new JLabel("Update Profile");
        Donate_evt.setBounds(570,597,250,20);
        Donate_evt.setForeground(Color.BLACK);
        Donate_evt.setFont(new Font("Arial", Font.BOLD, 16));
        add(Donate_evt);
        
        


        img5 = new ImageIcon(getClass().getResource("design\\all_info.png"));
        cb4 = new JButton(img5);
        cb4.setBackground(Color.BLACK);
        panel2.add(cb4);
        cb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new user_information(username).setVisible(true);
            }
        });
        img6 = new ImageIcon(getClass().getResource("design\\help.png"));
        cb5 = new JButton(img6);
        cb5.setBackground(Color.BLACK);
        panel2.add(cb5);

        cb5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new offer_service(username).setVisible(true);
            }
        });
        img7 = new ImageIcon(getClass().getResource("design\\update.png"));
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
       // wtextl2 = new JLabel("Hello ");
//        wtextl2.setForeground(Color.BLACK);
//        wtextl2.setFont(new Font("Arial", Font.BOLD, 20));
        //wtextl2.setBorder(new LineBorder(Color.BLACK));

//        panel4.add(wtextl2);

        c.add(panel4, BorderLayout.WEST);

        panel5 = new JPanelGradient();
        panel5.setPreferredSize(new Dimension(105, 0));
        panel5.setBackground(new Color(177, 193, 216));
        panel5.setLayout(new GridLayout(6, 1, 5, 1)); 
        panel5.setBorder(new LineBorder(Color.black, 0));//BORDER LINE
        img3 = new ImageIcon(getClass().getResource("design\\logout.png"));
        img9 = new ImageIcon(getClass().getResource("design\\blank.png"));
        sb1 = new JButton("");
        sb1.setBackground(new Color(177, 193, 216));
        panel5.setBackground(new Color(177, 193, 216));
      //  panel5.add(sb1);

        img8 = new ImageIcon(getClass().getResource("design\\backlog.png"));

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
