import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import java.util.*;
public class Report extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5,p1;
	JFrame hf;
	JLabel hl1,hl2,hl3;
	JButton home;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;

	Connection con;
	Statement stmt;
	ResultSet rs;
	public Report()
	{
		
		hf=new JFrame();
		setLayout(null);
		
		 home=new JButton("Home");
		home.setBorder(null);
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hp2=new JPanel();
		hp2.setLayout(null);
		hp2.setBounds(0,0,1400,100);
		hp2.setBackground(new Color(0,0,0,125));
		home.setBounds(1200,30,100,40);
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,200,100);
		hp2.add(hbackground2);
		
		
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(230,10,500,70);
		
		
		hp2.add(hl2);
		hp2.add(home);
		add(hp2);

		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(0,100,1400,600);
		hp3.setBackground(new Color(255,255,255));
		
		JLabel hbackground1;
		ImageIcon himg1=new ImageIcon("images/reportnew3.jpg");
		hbackground1=new JLabel("",himg1,JLabel.CENTER);
		hbackground1.setBounds(0,0,1400,600);
		hp3.add(hbackground1);
		
		l1 = new JLabel("TOTAL  STUDENTS:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Broadway", Font.BOLD, 18));
		l2 = new JLabel("TOTAL BOOKS:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Broadway", Font.BOLD, 18));
		l3 = new JLabel("ISSUED BOOKS:");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Broadway", Font.BOLD, 18));
		l4 = new JLabel("RETURNED BOOKS:");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Broadway", Font.BOLD, 18));
		l5 = new JLabel("AVAILABLE BOOKS:");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Broadway", Font.BOLD, 18));

		t1 = new JTextField();
		t1.setForeground(Color.BLACK);
		t1.setFont(new Font("Broadway", Font.BOLD, 18));
		t1.setEditable(false);
		t2 = new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Broadway", Font.BOLD, 18));
		t2.setEditable(false);
		t3 = new JTextField();
		t3.setForeground(Color.BLACK);
		t3.setFont(new Font("Broadway", Font.BOLD, 18));
		t3.setEditable(false);
		t4 = new JTextField();
		t4.setForeground(Color.BLACK);
		t4.setFont(new Font("Broadway", Font.BOLD, 18));
		t4.setEditable(false);
		t5 = new JTextField();
		t5.setForeground(Color.BLACK);
		t5.setFont(new Font("Broadway", Font.BOLD, 18));
		t5.setEditable(false);
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(250,100,800,400);
		p1.setBackground(new Color(0,0,0,65));
		l1.setBounds(100,50,200,50);
		t1.setBounds(370,50,100,40);
		l2.setBounds(100,120,200,50);
		t2.setBounds(370,120,100,40);
		l3.setBounds(100,190,200,50);
		t3.setBounds(370,190,100,40);
		l4.setBounds(100,250,200,50);
		t4.setBounds(370,250,100,40);
		l5.setBounds(100,320,250,50);
		t5.setBounds(370,320,100,40);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		hbackground1.add(p1);
		add(hp3);	
		
		
		setSize(1400,750);
		setVisible(true);
			
		home.addActionListener(this);	
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS","root","");
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from report");
		if(rs.next())
		{
			t1.setText(""+rs.getInt(1));
			t2.setText(""+rs.getInt(2));
			t3.setText(""+rs.getInt(3));
			t4.setText(""+rs.getInt(4));
			t5.setText(""+rs.getInt(5));
			
		}
		}catch(Exception e4){System.out.println(e4);}
		
	}
	public void actionPerformed(ActionEvent e1)
	{
		if(e1.getSource()==home)
		{
			new Home();
		}
	}
	
		
	
	public static void main(String args[])
	{
		new Report();
		
	}
}
