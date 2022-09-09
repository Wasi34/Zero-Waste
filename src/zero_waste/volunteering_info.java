package zero_waste;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;

public class volunteering_info extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice cplace;
    String username;

    volunteering_info(final String username) {
        this.username = username;
        setLayout(null);
        setResizable(false);

        JLabel lblName = new JLabel("Previous Volunteering Information");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 24));
        lblName.setBounds(380, 11, 400, 53);
        lblName.setForeground(Color.BLACK);
        add(lblName);

        JLabel location = new JLabel("Location: ");
        location.setBounds(35, 30, 80, 40);
        location.setForeground(Color.BLACK);
        location.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(location);

        cplace = new Choice();
        try {

            Conn c = new Conn();
            String query = "select *from offer_help";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cplace.add(rs.getString("event_location"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        cplace.setBounds(120, 40, 150, 25);
        cplace.setBackground(new Color(125, 149, 185));
        cplace.setForeground(Color.BLACK);
        add(cplace);

        JLabel name = new JLabel("User Name");
        name.setForeground(Color.BLACK);
        name.setBounds(10, 16, 100, 200);
        add(name);

        JLabel email = new JLabel("Email");
        email.setBounds(150, 16, 100, 200);
        email.setForeground(Color.BLACK);
        add(email);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(290, 16, 100, 200);
        phone.setForeground(Color.BLACK);
        add(phone);

        JLabel id = new JLabel("Event ID");
        id.setBounds(435, 16, 100, 200);
        id.setForeground(Color.BLACK);
        add(id);

        JLabel ename = new JLabel("Event Name");
        ename.setBounds(580, 16, 100, 200);
        ename.setForeground(Color.BLACK);
        add(ename);

        JLabel etime = new JLabel("Event Time");
        etime.setBounds(720, 16, 100, 200);
        etime.setForeground(Color.BLACK);
        add(etime);

        JLabel elocation = new JLabel("Location");
        elocation.setBounds(865, 16, 100, 200);
        elocation.setForeground(Color.BLACK);
        add(elocation);

        JLabel efor = new JLabel("Event Name");
        efor.setBounds(1010, 16, 100, 200);
        efor.setForeground(Color.BLACK);
        add(efor);

        back = new JButton("BACK");
        back.setFont(new Font("Tohoma", Font.PLAIN, 18));
        back.setBackground(new Color(125, 149, 185));
        back.setForeground(Color.BLACK);
        back.setBounds(580, 350, 120, 40);
        back.addActionListener(this);
        add(back);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tohoma", Font.PLAIN, 18));
        submit.setBackground(new Color(125, 149, 185));
        submit.setForeground(Color.BLACK);
        submit.setBounds(380, 350, 120, 40);
        submit.addActionListener(this);
        add(submit);

        table = new JTable();
        table.setBounds(0, 130, 1150, 330);
        table.setBackground(new Color(177, 193, 216));
        add(table);

        try {

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from offer_help");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(new Color(125, 149, 185));
        setBounds(450, 200, 1150, 450);
        setVisible(true);

    }

    public static void main(String[] args) {

        new volunteering_info("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            try {

                Conn c = new Conn();

                String q1 = "select * from offer_help where event_location = '" + cplace.getSelectedItem() + "'";

                ResultSet rs;
                rs = c.s.executeQuery(q1);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == back) {
            dispose();
            try {
                new volunteer_dashBoard(username).setVisible(true);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        }

    }

}
