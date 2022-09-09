/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class interface_1 extends JFrame implements Runnable{
    private JLabel imglabel;
    private ImageIcon img;
    private Container c;
    interface_1(){
       Go();
    }
   void Go(){
       
       
       this.setTitle("ZeroWaste");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       c = this.getContentPane();
       c.setLayout(null);
       
       c.setBackground(Color.black);
       img = new ImageIcon(getClass().getResource("design\\zero waste.png"));
       imglabel = new JLabel(img);
       imglabel.setBounds(0,5,1098,700);
       
       c.add(imglabel);
       this.setVisible(true);
       int x = 1;
       for(int i =0; i<800; i+=16,x+=5){
           
           this.setBounds((905-(x+i)/2),500-(i/2),x+i,i);
           try {
               Thread.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(interface_1.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(interface_1.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.setVisible(false);
        login frame = new login();
        frame.setVisible(true);
     
       
      
       
       
       
   }
    public static void main(String[]args){
        Thread t;
        interface_1 frame = new interface_1();
       
     
        
        
   
    }

    @Override
    public void run() {
        
    }
}