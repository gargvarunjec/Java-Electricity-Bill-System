package ajava_project;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t2;
    JLabel l11,l13,l14,l15,l12;
    ViewInformation(){
        setBounds(600,250, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);
        
     
        
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(70, 140, 100, 20);
        add(l2);
        
       
        t2 = new JTextField();
        t2.setBounds(250, 140, 100, 20);
        add(t2);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(70, 80, 100, 20);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(250, 80, 100, 20);
        add(l11);
        
        JLabel l3 = new JLabel("User name ");
        l3.setBounds(70, 200, 100, 20);
        add(l3);
        
        l13 = new JLabel();
        l13.setBounds(250, 200, 100, 20);
        add(l13);
        
        JLabel l4 = new JLabel("password");
        l4.setBounds(70, 260, 100, 20);
        add(l4);
        
        l14 = new JLabel();
        l14.setBounds(250, 260, 100, 20);
        add(l14);
        
        JLabel l5 = new JLabel("Address");
        l5.setBounds(500, 80, 100, 20);
        add(l5);
        
        l15 = new JLabel();
        l15.setBounds(650, 80, 100, 20);
        add(l15);
        
        b2 = new JButton("View");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350, 340, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(550, 340, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8  = new JLabel(i3);
        l8.setBounds(20, 350, 600, 300);
        add(l8);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b2) {
    		try{
                Conn c = new Conn();
                String a=t2.getText();
                
                ResultSet rs = c.s.executeQuery("Select * from customers where Meter_no= '"+a+"'");
                while(rs.next()){
                	
                    l11.setText(rs.getString(2));
                    l13.setText(rs.getString(3));
                    l14.setText(rs.getString(4));
                    l15.setText(rs.getString(5));
                
                    
                }
            }catch(Exception e){
            	 e.printStackTrace();
                 System.out.println("error: "+e);
            }
    	}
    	else if(ae.getSource()==b1) {
    		 this.setVisible(false);
    	}
    	   
    }
    
    public static void main(String[] args){
        new ViewInformation().setVisible(true);
    }
}