import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import java.util.*;
public class Home extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5;
	JFrame hf;
	JLabel hl1,hl2,hl3;
	JButton hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8;
	
	public Home()
	{
		
		hf=new JFrame();
		setLayout(null);
		hp1=new JPanel();
		hp1.setLayout(null);
		hp1.setBounds(0,150,250,750);
		hp1.setBackground(new Color(6,120,228));
		

		hl1 = new JLabel("HOME");
		hl1.setForeground(Color.RED);
		hl1.setFont(new Font("Broadway", Font.BOLD, 25));
		
		
		hb1=new JButton("Student");
		hb1.setForeground(Color.WHITE);
		hb1.setBackground(Color.BLACK);
		hb1.setBorder(null);
		hb1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hb2=new JButton("Book");
		hb2.setBorder(null);
		hb2.setBackground(Color.BLACK);
		hb2.setForeground(Color.WHITE);
		hb2.setFont(new Font("Times New Roman", Font.BOLD, 18));

		hb7=new JButton("Issue Book");
		hb7.setBorder(null);
		hb7.setBackground(Color.BLACK);
		hb7.setForeground(Color.WHITE);
		hb7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		hb8=new JButton("Return Book");
		hb8.setBorder(null);
		hb8.setBackground(Color.BLACK);
		hb8.setForeground(Color.WHITE);
		hb8.setFont(new Font("Times New Roman", Font.BOLD, 18));		

		hb3=new JButton("Issue Details");
		hb3.setBorder(null);
		hb3.setForeground(Color.WHITE);
		hb3.setBackground(Color.BLACK);
		hb3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hb4=new JButton("Book Details");
		hb4.setForeground(Color.WHITE);
		hb4.setBorder(null);
		hb4.setBackground(Color.BLACK);
		hb4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hb5=new JButton("Report");
		hb5.setForeground(Color.WHITE);
		hb5.setBorder(null);
		hb5.setBackground(Color.BLACK);
		hb5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		hb6=new JButton("Logout");
		hb6.setForeground(Color.BLACK);
		hb6.setBorder(null);
		hb6.setBackground(new Color(255,204,0));
		hb6.setFont(new Font("Times New Roman", Font.BOLD, 18));
				
		
		hl1.setBounds(20,5,100,40);
		hb1.setBounds(40,40,150,40);
		hb2.setBounds(40,110,150,40);
		hb7.setBounds(40,180,150,40);
		hb8.setBounds(40,250,150,40);
		hb3.setBounds(40,320,150,40);
		hb4.setBounds(40,390,150,40);
		hb5.setBounds(40,460,150,40);
		
		hp1.add(hb1);		
		hp1.add(hb2);
		hp1.add(hb3);
		hp1.add(hb4);
		hp1.add(hb5);
		hp1.add(hb7);
		hp1.add(hb8);
		
		add(hp1);

		hp2=new JPanel();
		hp2.setLayout(null);
		hp2.setBounds(0,0,1400,50);
		hp2.setBackground(Color.BLACK);
		//new Color(37,160,0)
	
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(150,10,500,70);
		
		hb6.setBounds(1150,5,100,40);
		
		hp2.add(hl1);
		hp2.add(hb6);
		add(hp2);

		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(250,150,1200,600);
		hp3.setBackground(new Color(255,255,255));

		
		JLabel hbackground1;
		ImageIcon himg1=new ImageIcon("images/Homebk3.jpg");
		hbackground1=new JLabel("",himg1,JLabel.CENTER);
		hbackground1.setBounds(0,0,1200,600);
		hp3.add(hbackground1);
		JLabel hstr1=new JLabel("The only thing that you");
		hstr1.setForeground(Color.WHITE);
		hstr1.setFont(new Font("Broadway", Font.BOLD, 24));
		hstr1.setBounds(200,180,500,80);
		JLabel hstr2=new JLabel("absolutely have to know, is the");
		hstr2.setForeground(Color.WHITE);
		hstr2.setFont(new Font("Broadway", Font.BOLD, 24));
		hstr2.setBounds(150,250,500,80);
		JLabel hstr3=new JLabel("location of the library.");
		hstr3.setForeground(Color.WHITE);
		hstr3.setFont(new Font("Broadway", Font.BOLD, 24));
		hstr3.setBounds(200,320,500,80);
		add(hp3);	
		hbackground1.add(hstr1);
		hbackground1.add(hstr2);
		hbackground1.add(hstr3);
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,50,1400,100);
		hp5.setBackground(new Color(0,0,0,125));
		JLabel border=new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		border.setBounds(0,69,1400,50);
		border.setFont(new Font("Times New Roman", Font.BOLD, 36));
		border.setForeground(Color.YELLOW);
		//new Color(49,199,4)
		hp5.add(hl2);
		hp5.add(border);
		
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/Homelogo1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(20,0,150,100);
		hp5.add(hbackground2);
		
		add(hp5);
		setSize(1400,750);
		setVisible(true);
			
			
		
		hb1.addActionListener(this);
		hb2.addActionListener(this);
		hb3.addActionListener(this);
		hb4.addActionListener(this);
		hb5.addActionListener(this);
		hb6.addActionListener(this);
		hb7.addActionListener(this);
		hb8.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent he1)
	{
		
		if(he1.getSource()==hb1)
		{
			new NewMember();
		}
		if(he1.getSource()==hb2)
		{
			new Books();
		}
		if(he1.getSource()==hb3)
		{
			new IssueDetails();
		}
		if(he1.getSource()==hb4)
		{
			new BookDetails();
		}
		if(he1.getSource()==hb5)
		{
			new Report();
		}
		if(he1.getSource()==hb6)
		{
			System.exit(0);
		}
		if(he1.getSource()==hb7)
		{
			new IssueBook();
		}
		if(he1.getSource()==hb8)
		{
			new ReturnBook();
		}
		
	}
		
	
	public static void main(String args[])
	{
		new Home();
		
	}
}
