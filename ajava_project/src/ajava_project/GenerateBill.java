package ajava_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Electricity.Conn;

import java.sql.*;


public class GenerateBill extends JFrame implements ActionListener {
	JLabel l1, l2;
    JTextArea t1;
    JButton b1;
    Choice c2;
    JPanel p1;
	String meter;
	GenerateBill(String meter){
		this.meter=meter;
		setSize(500,900);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        
        l1 = new JLabel("Generate Bill");
        
        l2 = new JLabel(meter);
        c2 = new Choice();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bills where Meter_no='"+meter+"'");
            while(rs.next()){
                c2.add(rs.getString("month_s"));
            }
        }catch(Exception e){}
		

        t1 = new JTextArea(50,15);
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        JScrollPane jsp = new JScrollPane(t1);

        b1 = new JButton("Generate Bill");
        add(jsp,"Center");

        p1.add(l1);
        p1.add(l2);
        p1.add(c2);
        add(p1,"North");
        add(b1,"South");
        
        b1.addActionListener(this);
        
        setLocation(750,100);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			Conn c= new Conn();
			String month=c2.getSelectedItem();
			
            t1.setText("\tVNC POWER LIMITED\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2022\n\n\n");
            
            ResultSet rs = c.s.executeQuery("Select * from customers where Meter_no='"+meter+"'");
            
            if(rs.next()){
                t1.append("\n    Customer Name:"+rs.getString("Customer_name"));
                t1.append("\n    Meter Number:  "+rs.getString("Meter_no"));
                t1.append("\n    Address:            "+rs.getString("Address"));

                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");

		}
        
            rs=c.s.executeQuery("select * from bills where Meter_no='"+meter+"'and month_s='"+month+"'");
            
            if(rs.next()){
                t1.append("\n    Current Month :\t"+rs.getString("month_s"));
                t1.append("\n    Units Consumed:\t"+rs.getString("Units"));
                t1.append("\n    Total Charges :\t"+rs.getString("Totalbillamount"));
                t1.append("\n---------------------------------------------------------------");
                t1.append("\n    TOTAL PAYABLE :\t"+rs.getString("Totalbillamount"));
            }
            
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	public static void main(String[] args) {
		new GenerateBill("").setVisible(true);
	}
}
