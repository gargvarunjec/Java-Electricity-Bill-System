package ajava_project;


import javax.swing.*;
import javax.swing.border.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener{
    /**
   * 
   */
  private static final long serialVersionUID = -3764742068065563128L;
  
  JPanel p1;
    JTextField t1, t2, t3, t4,t5;
    JButton b1, b2;
    Signup(){
    	super("Signup");
        setBounds(600, 250, 700, 400);
        
        p1 = new JPanel();
        p1.setBounds(30, 30, 650, 300);
        p1.setLayout( null);
        p1.setBackground(Color.WHITE);
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);
        
        //ADDING IMAGE
        
        JFrame jFrame = new JFrame();
    jFrame.add(new JLabel(new ImageIcon("\"C:\\Users\\lakshay\\Desktop\\Adv. Java PRoject\\icon.png\"")));
        
        JLabel l1 = new JLabel("Username");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 50, 100, 20);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(260, 50, 150, 20);
        p1.add(t1);
        
        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 90, 100, 20);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(260, 90, 150, 20);
        p1.add(t2);
        
        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 130, 100, 20);
        p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(260, 130, 150, 20);
        p1.add(t3);
        
        JLabel l4 = new JLabel("Meter Number");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 170, 140, 20);
        l4.setVisible(true);
        p1.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(260, 170, 150, 20);
        t4.setVisible(true);
        p1.add(t4);
        
        JLabel l5 = new JLabel("Address");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 210, 140, 20);
        l5.setVisible(true);
        p1.add(l5);
        
        t5 = new JTextField();
        t5.setBounds(260, 210, 150, 20);
        t5.setVisible(true);
        p1.add(t5);
        
        
        
        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140, 290, 120, 30);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300, 290, 120, 30);
        b2.addActionListener(this);
        p1.add(b2);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String meter = t4.getText();
            String Address=t5.getText();
 
            try{
                Conn c = new Conn();
                String str = null;
                str = "insert into Customers values('"+meter+"', '"+username+"', '"+name+"', '"+password+"','"+Address+"')";
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                
            }
        } else if(ae.getSource()== b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Signup().setVisible(true);
    }

 
}
