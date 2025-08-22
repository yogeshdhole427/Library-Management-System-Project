import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class NewMember extends JFrame implements ActionListener, ItemListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5,p1;
	JFrame hf;
	JLabel hl2,hl3,hl4;
		
	JButton hb1,hb2,hb3,hb4;

	JFrame f;
	JComboBox cb;
	JRadioButton r1,r2;
	JLabel l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5;
	JButton b2,b3;
	
	Connection con;
	PreparedStatement pstmt,pstmt1;	
	Statement stmt,stmt1;
	String nm,cl,rn,gn,mb,eml;
	ResultSet rs,rs1;
	int flag=0,totstd=0,tot;
	public NewMember()
	{
		
		setLayout(null);
		setTitle("New Student");
		
		//Home Page
		hf=new JFrame();
		setLayout(null);
		hp1=new JPanel();
		hp1.setLayout(null);
		hp1.setBounds(0,100,210,750);
		hp1.setBackground(new Color(6,120,228));

		
		
		
		hl4=new JLabel("STUDENT");
		hl4.setForeground(Color.WHITE);
		hl4.setFont(new Font("Broadway", Font.BOLD, 25));
		hb2=new JButton("Update");
		hb2.setBorder(null);
		hb2.setBackground(Color.BLACK);
		hb2.setForeground(Color.WHITE);
		hb2.setFont(new Font("Cooper", Font.BOLD, 18));
		hb3=new JButton("Delete");
		hb3.setBorder(null);
		hb3.setForeground(Color.WHITE);
		hb3.setBackground(Color.BLACK);
		hb3.setFont(new Font("Cooper", Font.BOLD, 18));
		hb4=new JButton("Back");
		hb4.setForeground(Color.WHITE);
		hb4.setBorder(null);
		hb4.setBackground(Color.BLACK);
		hb4.setFont(new Font("Cooper", Font.BOLD, 18));
				
		
		
		hl4.setBounds(30,40,150,50);
		hb2.setBounds(20,130,150,50);
		hb3.setBounds(20,210,150,50);
		hb4.setBounds(20,290,150,50);
		
		
		hp1.add(hl4);		
		hp1.add(hb2);
		hp1.add(hb3);
		hp1.add(hb4);
		
		
		add(hp1);

		hp2=new JPanel();
		hp2.setLayout(null);
		hp2.setBounds(0,0,1400,100);
		hp2.setBackground(new Color(0,0,0,125));
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,210,100);
		hp2.add(hbackground2);
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(240,30,500,50);
		
		
		hp2.add(hl2);
		
		add(hp2);

		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(197,100,1200,600);
		hp3.setBackground(new Color(255,255,255));

		JLabel hbackground1;
		ImageIcon himg1=new ImageIcon("images/student2.jpg");
		hbackground1=new JLabel("",himg1,JLabel.CENTER);
		hbackground1.setBounds(0,0,1200,600);
		hp3.add(hbackground1);
		
		
		
		
		hb2.addActionListener(this);
		hb3.addActionListener(this);
		hb4.addActionListener(this);
		
		//Home Page
		
		l2 = new JLabel("Name:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Class:");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4 = new JLabel("Roll No:");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5 = new JLabel("Gender:");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("Mobile No:");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7 = new JLabel("Email:");
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		r1=new JRadioButton(" Male");
		r1.setForeground(Color.BLACK);
		
		r1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r2=new JRadioButton(" Female");
		r2.setForeground(Color.BLACK);
		
		r2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		

		String c1[]={"Select","FYBBA","SYBBA","TYBBA","FYBCA","SYBCA","TYBCA","FYBCS","SYBCS","TYBCS","FYBCOM","SYBCOM","TYBCOM"};
		cb=new JComboBox(c1);
		cb.setForeground(Color.BLACK);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
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
		
		
		
		b2=new JButton("Submit");
		
		b2.setBackground(new Color(37,160,0));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3=new JButton("Back");
		
		b3.setBackground(new Color(37,160,0));
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));	
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(150,100,800,350);
		p1.setBackground(new Color(0,0,0,125));

		
		
		
		l2.setBounds(100,50,150,30);
		l3.setBounds(100,100,100,30);
		l4.setBounds(370,100,100,30);
		l5.setBounds(100,150,100,30);
		l6.setBounds(100,200,150,30);
		l7.setBounds(410,200,150,30);
		
		t1.setBounds(230,50,300,30);
		t2.setBounds(460,100,100,30);
		t3.setBounds(230,200,150,30);
		t4.setBounds(490,200,200,30);
		
		
		cb.setBounds(230,100,100,30);
		
		
		r1.setBounds(230,150,100,30);
		r2.setBounds(360,150,150,30);
	
		
		b2.setBounds(230,280,100,40);
		b3.setBounds(370,280,100,40);	
	
		
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		
		
		
		p1.add(cb);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		p1.add(r1);
		p1.add(r2);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		
		
		
		
		p1.add(b2);
		p1.add(b3);
		
		hbackground1.add(p1);
		
		add(hp3);
		setSize(1400,750);
		setVisible(true);
	
		
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
		
		nm=t1.getText();
		cl=""+cb.getItemAt(cb.getSelectedIndex());
		rn=t2.getText();
		int n1=Integer.parseInt(rn);
		if(r1.isSelected())
			gn="Male";	
		if(r2.isSelected())
			gn="female";
		mb=t3.getText();
		eml=t4.getText();
		pstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		
		if(e1.getSource()==b2)
		{
			if(t1.getText().length()==0)
			{
				t1.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			if(t2.getText().length()==0)
			{
				t2.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			
				if(t3.getText().length()>10)
				{
					JOptionPane.showMessageDialog(f,"Invalid mobile number");
				}
				if(t3.getText().length()!=10)
				{
					JOptionPane.showMessageDialog(f,"Invalid mobile number");
				}
			
			if(t4.getText().length()==0)
			{
				t4.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			stmt1=con.createStatement();
				rs1=stmt1.executeQuery("select * from report");
				if(rs1.next())
				{
					 tot=rs1.getInt(1);
					
				}
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from student where  s_class='"+cl+"' and s_rollno='"+n1+"'");
			if(rs.next())
			{
				JOptionPane.showMessageDialog(f,"You are already registered");
			}
			else{
			
				pstmt.setString(1,nm);
				pstmt.setString(2,cl);
				
				pstmt.setInt(3,n1);
				pstmt.setString(4,gn);
				int p=Integer.parseInt(mb);
				pstmt.setInt(5,p);
				pstmt.setString(6,eml);
				int n=pstmt.executeUpdate();
			
				JOptionPane.showMessageDialog(f,"Student add successfully");
				flag=1;
			}
			if(flag==1)
			{
				totstd=tot+1;
				pstmt1=con.prepareStatement("update report set total_students=?");
				
				pstmt1.setInt(1,totstd);
				int n3=pstmt1.executeUpdate();
			}
				
			
		}
		if(e1.getSource()==b3)
		{
			new Home();
		}
		}catch(Exception e3){System.out.println(e3);}
		
		if(e1.getSource()==hb2)
		{
			new CheckMember();
		}
		if(e1.getSource()==hb3)
		{
			new DeleteMember();
		}
		if(e1.getSource()==hb4)
		{
			new Home();
		}
		
		
		
	}
		
	
	public static void main(String args[])
	{
		new NewMember();
	
		
	}
}