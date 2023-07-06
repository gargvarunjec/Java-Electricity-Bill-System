package ajava_project;


import javax.swing.*;

import Electricity.Login;

import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {
	String meter;
	project(String meter){
		this.meter=meter;
		
        setSize(1920,1030);
        // bg image
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("icon/elec.png"));
        Image i3 = ic.getImage().getScaledInstance(1550, 800,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

		/* menubar */
		JMenuBar mb=new JMenuBar();
		
		
		JMenu info = new JMenu("Information");
		JMenuItem info1= new JMenuItem("View Information");
		ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image42));

		info1.setFont(new Font("monospaced",Font.PLAIN,12));
		info1.setMnemonic('P');
		info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info1.setBackground(Color.WHITE);
        info.setForeground(Color.RED);
        
        info1.addActionListener(this);
        
        JMenu Bill = new JMenu("Bill");
        JMenuItem b1=new JMenuItem("Generate Bill");
        JMenuItem b2=new JMenuItem("Calculate Bill");
        
        // generate bill
        b1.setFont(new Font("monospaced",Font.PLAIN,12));
        b1.setMnemonic('P');
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        b1.setIcon(new ImageIcon(image7));
        b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        b1.setBackground(Color.WHITE);
        
        //calculate bill
        b2.setFont(new Font("monospaced",Font.PLAIN,12));
        b2.setMnemonic('P');
        b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        b2.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        b2.setIcon(new ImageIcon(image4));
        
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.RED); 
        
        ut1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic('C');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);
        
        /* ---- Calculator ---- */
        ut2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic('X');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        ut2.setBackground(Color.WHITE);
        
        /* ---- Web Browser ---- */
        ut3.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic('W');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);
        
        /*Fifth Column */
        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);
        
        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        info.add(info1);
        Bill.add(b1);
        Bill.add(b2);
        
        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);
        
        exit.add(ex);

        
        mb.add(info);
        mb.add(Bill);
        mb.add(utility);
        mb.add(exit);
        
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
        
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String msg=ae.getActionCommand();
		if(msg.equals("View Information")) {
			new ViewInformation().setVisible(true);
		}
		else if(msg.equals("Generate Bill")) {
			new GenerateBill(meter).setVisible(true);
		}
		else if(msg.equals("Calculate Bill")) {
			new CalculateBill(meter).setVisible(true);
		}else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }
	}
	
	
	public static void main(String args[]) {
		new project("").setVisible(true);
	}
}
