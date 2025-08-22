import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class Books extends JFrame implements ItemListener,ActionListener
{
	JFrame f;
	JComboBox cb;
	static JPanel hp1,hp2,hp3,hp4,hp5,p6,p7;
	JLabel hl1,hl2,hl3,hl4;
	JButton hb1,hb2,hb3,hb4;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3;
	
	Connection con;
	PreparedStatement pstmt,pstmt1;
	Statement stmt,stmt1;
	ResultSet rs,rs1;
	String bnm,bcg,ba,pb,bnp,bnb,be;
	int tot, totbk,ab,totab;
	public Books()
	{

		
		setLayout(null);
		//Home Code
		hp1=new JPanel();
		hp1.setLayout(null);
		hp1.setBounds(0,100,200,750);
		hp1.setBackground(new Color(6,120,228));

		
		
		
		hl4=new JLabel("Books");
		hl4.setForeground(Color.WHITE);
		hl4.setFont(new Font("Broadway", Font.BOLD, 25));
		hb2=new JButton("Update");
		hb2.setBorder(null);
		hb2.setBackground(Color.BLACK);
		hb2.setForeground(Color.WHITE);
		hb2.setFont(new Font("Cooper", Font.BOLD, 18));
		hb3=new JButton("Issue Details");
		hb3.setBorder(null);
		hb3.setForeground(Color.WHITE);
		hb3.setBackground(Color.BLACK);
		hb3.setFont(new Font("Cooper", Font.BOLD, 18));
		hb4=new JButton("Back");
		hb4.setBorder(null);
		hb4.setForeground(Color.WHITE);
		hb4.setBackground(Color.BLACK);
		hb4.setFont(new Font("Cooper", Font.BOLD, 18));
			
		
		
		hl4.setBounds(50,40,150,50);
		hb2.setBounds(20,120,150,50);
		hb3.setBounds(20,200,150,50);
		hb4.setBounds(20,280,150,50);
		
		hp1.add(hl4);		
		hp1.add(hb2);
		hp1.add(hb3);
		hp1.add(hb4);
		add(hp1);

		
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(230,10,500,70);
		
		
		
		
		

			
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,0,1400,100);
		hp5.setBackground(new Color(49,199,4));
		hp5.add(hl2);
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,200,100);
		hp5.add(hbackground2);
		
		
		add(hp5);
		
		
			
		
		
		hb2.addActionListener(this);
		hb3.addActionListener(this);
		hb4.addActionListener(this);
		//home code end
		
		l1 = new JLabel("Fill the Book Details");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l2 = new JLabel("Book Name:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Category:");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4 = new JLabel("Author:");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5 = new JLabel("Publisher:");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("No.of Pages:");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7 = new JLabel("No of Books:");
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l8=new JLabel("Edition:");
		l8.setForeground(Color.WHITE);
		l8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		String c1[]={"Select","Educational","Entrance book","Science","BCA","BCS","BBA","Fantasy","Drama","Horror","Sports"};
		cb=new JComboBox(c1);
		cb.setForeground(Color.BLACK);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		t1=new JTextField();
		t1.setForeground(Color.BLACK);
		
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t2=new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t3=new JTextField();
		t3.setForeground(Color.BLACK);
		t3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t4=new JTextField();
		t4.setForeground(Color.BLACK);
		t4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t5=new JTextField();
		t5.setForeground(Color.BLACK);
		t5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t6=new JTextField();
		t6.setForeground(Color.BLACK);
		t6.setFont(new Font("Times New Roman", Font.BOLD, 18));

		b1=new JButton("Add");
		b1.setForeground(Color.BLACK);
		b1.setBackground(new Color(159,255,146));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));

		b2=new JButton("Back");
		b2.setBackground(new Color(159,255,146));

		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));

		b3=new JButton("Update");
		b3.setBackground(new Color(159,255,146));
	
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(197,100,1200,600);
		hp3.setBackground(new Color(255,255,255));

		
		JLabel hbackground1;
		ImageIcon himg1=new ImageIcon("images/books1.jpg");
		hbackground1=new JLabel("",himg1,JLabel.CENTER);
		hbackground1.setBounds(0,0,1200,600);
		hp3.add(hbackground1);
		
		p6=new JPanel();
		p6.setLayout(null);
		p6.setBounds(150,50,800,300);
		p6.setBackground(new Color(0,0,0,65));
		p7=new JPanel();
		p7.setLayout(null);
		p7.setBounds(150,420,800,100);
		p7.setBackground(new Color(0,0,0,125));
		hbackground1.add(l1);
		hbackground1.add(p6);
		hbackground1.add(p7);
		l1.setBounds(450,380,500,30);
		l2.setBounds(50,50,150,30);
		l3.setBounds(50,100,100,30);
		l4.setBounds(370,100,100,30);
		l5.setBounds(50,150,100,30);
		l6.setBounds(50,200,150,30);
		l7.setBounds(320,200,150,30);
		l8.setBounds(50,250,100,30);
		

		t1.setBounds(190,50,350,30);
		t2.setBounds(450,100,250,30);
		t3.setBounds(190,150,300,30);
		t4.setBounds(190,200,100,30);
		t5.setBounds(450,200,100,30);
		t6.setBounds(190,250,100,30);
		
		cb.setBounds(190,100,150,30);
			
		b1.setBounds(200,30,100,40);
		b2.setBounds(350,30,100,40);
		b3.setBounds(500,30,100,40);	
		
		
		p6.add(l2);
		p6.add(l3);
		p6.add(l4);
		p6.add(l5);
		p6.add(l6);
		p6.add(l7);
		p6.add(l8);
		
		
		p6.add(cb);
		p6.add(t1);
		p6.add(t2);
		p6.add(t3);
		p6.add(t4);
		p6.add(t5);
		p6.add(t6);
		p7.add(b1);
		p7.add(b2);
		p7.add(b3);

		
		
		add(hp3);
		
		setSize(1400,750);
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		cb.addItemListener(this);

		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lbms","root","");
		}catch(Exception e4){System.out.println(e4);}
		
		
	}
	public void itemStateChanged(ItemEvent e)
	{
		
		if(e.getSource()==cb)
		{
			
		}
		
		
	}
	public void actionPerformed(ActionEvent e1)
	{
		try{
		f=new JFrame();
		bnm=t1.getText();
		bcg=""+cb.getItemAt(cb.getSelectedIndex());
		ba=t2.getText();
		pb=t3.getText();
		bnp=t4.getText();
		bnb=t5.getText();
		int nb=Integer.parseInt(bnb);
		be=t6.getText();
		pstmt=con.prepareStatement("insert into book_details values(?,?,?,?,?,?,?)");

		if(e1.getSource()==b1)
		{
			
			if(t1.getText().length()==0)
			{
				t1.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			if(t2.getText().length()==0)
			{
				t2.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			
			if(t3.getText().length()==0)
			{
				t3.setBorder(BorderFactory.createLineBorder(Color.red));
			}
			if(t4.getText().length()==0)
			{
				t4.setBorder(BorderFactory.createLineBorder(Color.red));
			}
			
			if(t5.getText().length()==0)
			{
				t5.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			if(t6.getText().length()==0)
			{
				t6.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from book_details where  book_name='"+bnm+"' and b_author='"+ba+"'");
			if(rs.next())
			{
				JOptionPane.showMessageDialog(f,"This book record is already registered");
			}
			else{
			pstmt.setString(1,bnm);
			pstmt.setString(2,bcg);
			pstmt.setString(3,ba);
			pstmt.setString(4,pb);
			int n=Integer.parseInt(bnp);
			pstmt.setInt(5,n);
			
			pstmt.setInt(6,nb);
			int ed=Integer.parseInt(be);
			pstmt.setInt(7,ed);
			int p=pstmt.executeUpdate();
			JOptionPane.showMessageDialog(f,"Book Record add successfully");
			}
			stmt1=con.createStatement();
				rs1=stmt1.executeQuery("select * from report");
				if(rs1.next())
				{
					tot=rs1.getInt(2);
					ab=rs1.getInt(5);
				}
				
				totbk=tot+nb;
				pstmt1=con.prepareStatement("update report set total_books=?,t_availablebooks=?");
				
				pstmt1.setInt(1,totbk);
				totab=ab+nb;
				pstmt1.setInt(2,totab);
				int n3=pstmt1.executeUpdate();
		}
		}catch(Exception e5){System.out.println(e5);}
		if(e1.getSource()==b2)
		{
			new Home();
		
		}
		if(e1.getSource()==b3)
		{
			new UpdateBook();
		}
		
		
		
		if(e1.getSource()==hb2)
		{
			new UpdateBook();
		}
		if(e1.getSource()==hb3)
		{
			new IssueDetails();
		}
		if(e1.getSource()==hb4)
		{
			new Home();
		}

	}
		
	
	public static void main(String args[])
	{
		new Books();
	
		
	}
}