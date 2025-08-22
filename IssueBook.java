import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener,ItemListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5;
	JLabel hl1,hl2,hl3;
	JButton hb1,hb2,hb3,hb4,hb5,hb6;
	
	int flag;
	JFrame f;
	JPanel p1,p2;
	JLabel l1,l2,l3,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t5,t6,t7,t8;
	JButton b1,b2,b3;
	JComboBox cb,cmb1, cmb2, cmb3;
	Connection con;
	Statement stmt,stmt1,stmt2,stmt3;
	ResultSet rs1,rs2,rs3,rs4;
	PreparedStatement pstmt,pstmt1,pstmt2;
	String rn,cl,snm,bnm,ba,id,rd,d,m,y;
	int tot,totstd,ab,totab;

	public IssueBook()
	{
		f=new JFrame();
		
		setLayout(null);
		setTitle("Issue_Book");
		
		//Home Page
		
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(230,10,500,70);
		
		
		
		

		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(0,100,1400,600);
		hp3.setBackground(new Color(255,255,255));
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,0,1400,100);
		hp5.setBackground(new Color(49,199,4));
		//new Color(49,199,4)
		hp5.add(hl2);
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,200,100);
		hp5.add(hbackground2);
		add(hp5);	
		
		
		
		//home code end
		
		l1 = new JLabel("Roll No:");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2 = new JLabel("Class:");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Student Name:");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		l5 = new JLabel("Mobile No:");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("Book Name:");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		l9 = new JLabel("Issue Date:");
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l10 = new JLabel("Return Date:");
		l10.setForeground(Color.BLACK);
		l10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l11 = new JLabel("Author:");
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		t1=new JTextField();
		
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t1.setForeground(Color.BLACK);
		
		t2=new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t3=new JTextField();
		t3.setForeground(Color.BLACK);
		t3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		t5=new JTextField();
		t5.setForeground(Color.BLACK);
		t5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t6=new JTextField();
		t6.setForeground(Color.BLACK);
		t6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t7=new JTextField();
		t7.setForeground(Color.BLACK);
		t7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t8=new JTextField();
		t8.setForeground(Color.BLACK);
		t8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		cmb1=new JComboBox();
		cmb1.setForeground(Color.BLACK);
		cmb1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		

		
		for(int i=1; i<=31; i++)
		{
			cmb1.addItem(i);
		}
		
		
		String c2[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
		cmb2=new JComboBox(c2);
		cmb2.setForeground(Color.BLACK);
		cmb2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		cmb3=new JComboBox();
		cmb3.setForeground(Color.BLACK);
		cmb3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		for(int i=2015; i<=2030; i++)
		{
			cmb3.addItem(i);
		}
		

		b1=new JButton("Check");
		b1.setBackground(new Color(159,255,146));
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		b2=new JButton("Submit");
		b2.setBackground(new Color(159,255,146));
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b3=new JButton("Clear");
		b3.setBackground(new Color(159,255,146));	
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		String c1[]={"Select","FYBBA","SYBBA","TYBBA","FYBCA","SYBCA","TYBCA","FYBCS","SYBCS","TYBCS","FYBCOM","SYBCOM","TYBCOM"};
		cb=new JComboBox(c1);
		cb.setForeground(Color.BLACK);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 16));
				

		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1400,100);
		p1.setBackground(new Color(6,120,228));

		l1.setBounds(100,30,100,40);
		t1.setBounds(230,30,150,40);
		l2.setBounds(440,30,100,40);
		cb.setBounds(520,30,150,40);
		b1.setBounds(750,30,130,40);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(cb);
		p1.add(b1);
		hp3.add(p1);

		l3.setBounds(100,130,150,30);
		t3.setBounds(270,130,500,30);
		t3.setEditable(false);
		
		l5.setBounds(100,180,100,30);
		t5.setBounds(270,180,150,30);
		t5.setEditable(false);
		hp3.add(l3);
		hp3.add(t3);
		
		hp3.add(l5);
		hp3.add(t5);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,250,1400,400);
		p2.setBackground(new Color(0,0,0,65));
		//new Color(255,146,146)
		l6.setBounds(100,50,150,30);
		t6.setBounds(270,50,300,30);
		l11.setBounds(100,110,150,30);
		t8.setBounds(270,110,200,30);
		
		l9.setBounds(100,170,150,30);
		t7.setBounds(270,170,150,30);
		l10.setBounds(440,170,150,30);
		
		cmb1.setBounds(580,170,100,30);
		cmb2.setBounds(700,170,100,30);
		cmb3.setBounds(820,170,100,30);
		b2.setBounds(280,240,150,40);
		b3.setBounds(480,240,150,40);	
		p2.add(l6);
		p2.add(t6);
		
		p2.add(l9);
		p2.add(l11);
		p2.add(t8);
		p2.add(t7);
		p2.add(l10);
		p2.add(cmb1);
		p2.add(cmb2);
		p2.add(cmb3);
		p2.add(b2);
		p2.add(b3);
		
		hp3.add(p2);
		
		
		add(hp3);
		setSize(1400,750);
		setVisible(true);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		cmb1.addItemListener(this);
		cmb2.addItemListener(this);
		cmb3.addItemListener(this);
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS","root","");
		}catch(Exception e4){System.out.println(e4);}
		
		
	}
	public void itemStateChanged(ItemEvent e6)
	{

	}
	
	public void actionPerformed(ActionEvent e1)
	{
		try{
		f=new JFrame();
		rn=t1.getText();
		int n1=Integer.parseInt(rn);
		cl=""+cb.getItemAt(cb.getSelectedIndex());
		snm=t3.getText();
		bnm=t6.getText();
		ba=t8.getText();
		id=t7.getText();
		d=""+cmb1.getItemAt(cmb1.getSelectedIndex());
		m=""+cmb2.getItemAt(cmb2.getSelectedIndex());
		y=""+cmb3.getItemAt(cmb3.getSelectedIndex());
		rd=d+""+m+""+y;
		
		pstmt=con.prepareStatement("insert into issue_details values(?,?,?,?,?,?,?,?)");

		if(e1.getSource()==b1)
		{
			stmt=con.createStatement();
			rs1=stmt.executeQuery("select * from student where  s_rollno='"+n1+"' and s_class='"+cl+"'");
			if(rs1.next())
			{
				t3.setText(""+rs1.getString(1));
				t5.setText(""+rs1.getInt(5));
			}
			else{
				JOptionPane.showMessageDialog(f,"Student is not Found");
				new NewMember();
			}
		}
		if(e1.getSource()==b2)
		{
			
				
			String str1="Not Returned";
			stmt2=con.createStatement();
			rs3=stmt.executeQuery("select * from issue_details where  returned='"+str1+"' and s_rollno='"+n1+"' and s_class='"+cl+"'");
			if(rs3.next())
			{
				JOptionPane.showMessageDialog(f,"Student already issued by book");
			}
			else{
			stmt1=con.createStatement();
			rs2=stmt.executeQuery("select * from book_details where  book_name='"+bnm+"' and b_author='"+ba+"'");
			if(rs2.next())
			{
				 int bn=rs2.getInt(6);
				
				if(bn==0)
					JOptionPane.showMessageDialog(f,"Book is not Available");
				else
				{
					pstmt.setString(1,snm);
					pstmt.setInt(2,n1);
					pstmt.setString(3,cl);
					pstmt.setString(4,bnm);
					pstmt.setString(5,ba);
					pstmt.setString(6,id);
					pstmt.setString(7,rd);
					String str="Not Returned";
					pstmt.setString(8,str);
					int p=pstmt.executeUpdate();
					JOptionPane.showMessageDialog(f,"Book Issued successfully");
					flag=1;
				}
			
				if(flag==1)
				{
					
					int c=bn-1;
					pstmt1=con.prepareStatement("update book_details set b_qty=? where book_name=? and b_author=?");
					pstmt1.setInt(1,c);
					pstmt1.setString(2,bnm);
					pstmt1.setString(3,ba);
					int p1=pstmt1.executeUpdate();
					
				}
			}
			}
			
				stmt3=con.createStatement();
				rs4=stmt3.executeQuery("select * from report");
				if(rs4.next())
				{
					tot=rs4.getInt(3);
					ab=rs4.getInt(5);
				}
				
				totstd=tot+1;
				pstmt2=con.prepareStatement("update report set t_issuedbooks=?,t_availablebooks=?");
				
				pstmt2.setInt(1,totstd);
				totab=ab-1;
				pstmt2.setInt(2,totab);
				int n3=pstmt2.executeUpdate();
		}
		if(e1.getSource()==b3)
		{
			
			
			t3.setText("");
				
			t5.setText("");
			t6.setText("");
			t7.setText("");
		
		}
		
		}catch(Exception e5){System.out.println(e5);}
		if(e1.getSource()==hb1)
		{
			new NewMember();
		}
		if(e1.getSource()==hb2)
		{
			new Books();
		}
		if(e1.getSource()==hb3)
		{
			new CheckMember();
		}
		if(e1.getSource()==hb4)
		{
			JOptionPane.showMessageDialog(f,"You Already Opened this window");
		}
		if(e1.getSource()==hb5)
		{
			new ReturnBook();
		}
		if(e1.getSource()==hb6)
		{
			System.exit(0);
		}
	}
		
	
	public static void main(String args[])
	{
		new IssueBook();
		
		
	}
}