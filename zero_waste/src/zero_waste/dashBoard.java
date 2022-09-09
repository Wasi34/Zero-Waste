/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

/**
 *
 * @author Anila Ditita
 */

    


public class dashBoard extends JFrame {

    private Container c;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JLabel ilab1, ilab2, wtextl1, wtextl2, wtext4, wtextl3, ntextl1, ntextl2, ntextl3, ctextl1,text;
    private ImageIcon img1, img2, img3, img4, img5, img6,img7,img8,img9,img10;
    private JButton sb1, sb2, sb3, sb4, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8;
    private BorderLayout blayout;
    private JTextField t1,t2;
    private JPanel contentPane;
    String name,piclocation,username;
    login logobj = new login();

    /*dashBoard() {
        try {
            Go();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public static void main(String[] args) throws FileNotFoundException  {
        dashBoard frame = new dashBoard("");
        frame.setVisible(true);

    }

    dashBoard(String username) throws FileNotFoundException {
        Go(username);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Go(final String username) throws FileNotFoundException {
        this.username = username;
        this.setBounds(450, 80, 1010, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DashBoard");
        c = this.getContentPane();
        c.setBackground(Color.white);

        blayout = new BorderLayout();
        c.setLayout(blayout);

        panel1 = new JPanel();
       //panel1.setBackground(Color.yellow);
        panel1.setPreferredSize(new Dimension(0, 200));
        panel1.setBorder(new LineBorder(Color.BLACK, 3));
        panel1.setLayout(new FlowLayout(4));
        
        t1 =new JTextField();
       t1.setBounds(15, 280, 180, 25);
       add(t1);
       
       //text = new JLabel();
       //text.setBounds(15, 280, 180, 25);
       //text.setBounds(15, 280, 180, 25);
	//panel1.add(text);
        //panel1.add(ntextl1);
       ntextl2 = new JLabel("");
        panel1.add(ntextl2);
        
        t2 =new JTextField();
        t2.setBounds(780, 125, 50, 25);
        add(t2);
       /* file saves in a text : File reader = new File("location.txt");
       Scanner scan = new Scanner(reader);
       while(scan.hasNext()){
           piclocation=scan.next();
           System.out.println(piclocation);
       }*/
       
        img1 = new ImageIcon(getClass().getResource("design\\editprofile.png"));
        ilab1 = new JLabel(img1);
        ilab1.setBounds(0, 0, 830, 30);
         panel1.add(ilab1);
        c.add(panel1, BorderLayout.NORTH);
        /////////////////////////////////////////////    

        panel2 = new JPanel();
        //panel2.setBackground(Color.RED);
        panel2.setLayout(new FlowLayout(1));
        img2 = new ImageIcon(getClass().getResource("design\\btn_donatedinfo.jpg"));
        ilab2 = new JLabel(img2);
        ilab2.setBounds(0, 0, 300, 300);
        cb1 = new JButton();
        cb1.add(ilab2);
        cb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
              //  new userEvntDonationInfo().setVisible(true);
              // here Places.java opens.we will add user donation information
              new donation_information(username).setVisible(true);
            }
        });

        cb1.setBackground(Color.BLACK);

        panel2.add(cb1);
        img3 = new ImageIcon(getClass().getResource("design\\btn_ongoinge.jpg"));
        cb2 = new JButton(img3);
        cb2.setBackground(Color.BLACK);
        panel2.add(cb2);
         cb2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
              new event_information(username).setVisible(true);
                
            }
        });
        
        img4 = new ImageIcon(getClass().getResource("design\\btn_createevent.jpg"));
        cb3 = new JButton(img4);
        cb3.setBackground(Color.black);
        panel2.add(cb3);
        cb3.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent e){
                dispose();
                //dashBoard frame = new dashBoard("");
      //  new dashBoard("").setVisible(false);
                new createEvent(username).setVisible(true);
            }
        });

        img5 = new ImageIcon(getClass().getResource("design\\btn_selfinfo.png"));
        cb4 = new JButton(img5);
        cb4.setBackground(Color.BLACK);
        panel2.add(cb4);
        cb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
                new user_information(username).setVisible(true);
            }
        });
        img6 = new ImageIcon(getClass().getResource("design\\btn_donatetoorg.jpg"));
        cb5 = new JButton(img6);
        cb5.setBackground(Color.BLACK);
        panel2.add(cb5);
        
        cb5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
              //  new Gps().setVisible(true);
                dispose();
                new orgDonationForm(username).setVisible(true);
            }
        });
        img7 = new ImageIcon(getClass().getResource("design\\update.jpg"));
        cb6 = new JButton(img7);
        cb6.setBackground(Color.BLACK);
        panel2.add(cb6);
        cb6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                  dispose();
              new update_information(username).setVisible(true);
              
            }
        });
       /* cb7 = new JButton(img2);
        cb7.setBackground(Color.BLACK);
        panel2.add(cb7);
        cb8 = new JButton(img2);
        cb8.setBackground(Color.BLACK);
        panel2.add(cb8);  
         
        this are the extra two button . if we need then we will use it otherwise not.*/

        /* ilab3 = new JLabel(img2);
         panel2.add(ilab3);
         ilab4 = new JLabel(img2);
         panel2.add(ilab4);
         ilab5 = new JLabel(img2);
         panel2.add(ilab5);
         ilab6 = new JLabel(img2);
         panel2.add(ilab6);
         ilab7 = new JLabel(img2);
         panel2.add(ilab7);
         ilab8 = new JLabel(img2);
         panel2.add(ilab8);*/
        c.add(panel2, BorderLayout.CENTER);
        ////////////////////////////////////////////////////   
        panel3 = new JPanel();
       // panel3.setBackground(Color.CYAN);
        c.add(panel3, BorderLayout.SOUTH);
        ////////////////////////////////////////////////////    
        panel4 = new JPanel();
        //panel4.setBackground(Color.BLUE);
        panel4.setPreferredSize(new Dimension(205, 0));
        panel4.setBorder(new LineBorder(Color.black, 3));
        panel4.setLayout(new GridLayout(8, 1, 5, 10));
        wtextl2 = new JLabel("   Profile");
        wtextl2.setFont(new Font("Arial", Font.BOLD, 40));
        wtextl2.setBorder(new LineBorder(Color.BLACK));

        /*File read = new File("file.txt");
        try (Scanner scanner = new Scanner(read)) {
            while (scanner.hasNext()) {
                name = scanner.next();
               
            }
        }
        wtextl3 = new JLabel("     "+name);*/
        //wtextl3.setFont(new Font("Arial", Font.BOLD, 20));
       // wtextl3.setBorder(new LineBorder(Color.BLACK));
        panel4.add(wtextl2);
        //panel4.add(wtextl3);
        c.add(panel4, BorderLayout.WEST);
        //////////////////////////////////////////////////////////   
        panel5 = new JPanel();
       // panel5.setBackground(Color.GREEN);
        panel5.setPreferredSize(new Dimension(95, 0));
        panel5.setLayout(new GridLayout(6, 1, 5, 1)); //4,1,5,5
        panel5.setBorder(new LineBorder(Color.black, 3));
        img3 = new ImageIcon(getClass().getResource("design\\logout.png"));
        img9 =new ImageIcon(getClass().getResource("design\\blank.png"));
        sb1 = new JButton("");
        sb1.setBackground(Color.white);
        panel5.setBackground(Color.white);
        panel5.add(sb1);
        img10 = new ImageIcon(getClass().getResource("design\\aboutapp.jpg"));
        sb2 = new JButton(img10);
        sb2.setBackground(Color.BLACK);
        panel5.add(sb2);
        img8 = new ImageIcon(getClass().getResource("design\\backlog.png"));
        sb3 = new JButton(img8);
        sb3.setBackground(Color.BLACK);
        panel5.add(sb3);
        sb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                dispose();
                new login().setVisible(true);
            }
        });
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
        
        try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from user_info where username = '"+username+"'");
                    while(rs.next()){
                        t1.setText(rs.getString("name"));  
                        t2.setText(rs.getString("user_id"));
                    }
                }catch(Exception e){System.out.println(e); }

    }

    
}
    

