import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class CheckMember extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5;
	JLabel hl1,hl2,hl3;
	
	JPanel p2;
	JFrame f;
	JLabel l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	JComboBox cb;
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt, pstmt1;	
	Statement stmt;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	int flag=0;
	public CheckMember()
	{
		
		setLayout(null);
		
		//Home Page
		
		
		hl1 = new JLabel("HOME");
		hl1.setForeground(Color.RED);
		hl1.setFont(new Font("Broadway", Font.BOLD, 25));
		
		
		

		hp2=new JPanel();
		hp2.setLayout(null);
		hp2.setBounds(0,0,1400,50);
		hp2.setBackground(new Color(37,160,0));
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,150,50);
		hp2.add(hbackground2);
	
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(20,10,500,70);
		
		
		hp2.add(hl1);
		
		add(hp2);

		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(0,150,1400,600);
		hp3.setBackground(new Color(255,255,255));
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,50,1400,100);
		hp5.setBackground(new Color(49,199,4));
		hp5.add(hl2);
		
		add(hp5);	
		
		
		//home code end

		
		l2 = new JLabel("Roll No:");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Class:");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4 = new JLabel("Name:");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5 = new JLabel("Class:");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("Roll No:");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7 = new JLabel("Mobile No:");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l8 = new JLabel("Email:");
		l8.setForeground(Color.BLUE);
		l8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
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
		t7=new JTextField();
		t7.setForeground(Color.BLACK);
		t7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		b1=new JButton("Check");
		b1.setForeground(Color.BLACK);
		b1.setBackground(new Color(159,255,146));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2=new JButton("Update");
		b2.setForeground(Color.BLACK);
		b2.setBackground(new Color(159,255,146));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3=new JButton("Back");
		b3.setForeground(Color.BLACK);
		b3.setBackground(new Color(159,255,146));
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));	
		String c1[]={"Select","FYBBA","SYBBA","TYBBA","FYBCA","SYBCA","TYBCA","FYBCS","SYBCS","TYBCS","FYBCOM","SYBCOM","TYBCOM"};
		cb=new JComboBox(c1);
		cb.setForeground(Color.BLACK);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 16));

		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,0,1400,100);
		p2.setBackground(new Color(255,146,146));

		l2.setBounds(100,30,100,40);
		t1.setBounds(230,30,150,40);
		l3.setBounds(440,30,100,40);
		cb.setBounds(520,30,150,40);
		b1.setBounds(750,30,130,40);
		p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(cb);
		p2.add(b1);
		hp3.add(p2);
		
		l4.setBounds(140,130,150,30);
		t3.setBounds(310,130,500,30);
		l5.setBounds(140,180,150,30);
		t4.setBounds(310,180,400,30);
		l6.setBounds(140,230,100,30);
		t5.setBounds(310,230,300,30);
		l7.setBounds(140,280,150,30);
		t6.setBounds(310,280,150,30);
		l8.setBounds(490,280,150,30);
		t7.setBounds(580,280,200,30);
		
		
		b2.setBounds(340,380,130,40);
		b3.setBounds(500,380,130,40);		
	
		
		
		
		hp3.add(l4);
		hp3.add(l5);
		hp3.add(l6);
		hp3.add(l7);
		hp3.add(l8);
		
		
		hp3.add(t2);
		hp3.add(t3);
		hp3.add(t4);
		hp3.add(t5);
		hp3.add(t6);
		hp3.add(t7);
		
		
		hp3.add(b2);
		hp3.add(b3);
		add(hp3);
		setSize(1400,750);
		setVisible(true);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS","root","");
		}catch(Exception e4){System.out.println(e4);}
		

		
		
	}
	public void actionPerformed(ActionEvent e1)
	{
		
		if(e1.getSource()==b1)
		{
			try{
			s1=t1.getText();
			s2=""+cb.getItemAt(cb.getSelectedIndex());
			int Id=Integer.parseInt(s1);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from student where s_rollno='"+Id+"' and s_class='"+s2+"'");
			
			if(rs.next())
			{
				
				t3.setText(""+rs.getString(1));
				t4.setText(""+rs.getString(2));
				t5.setText(""+rs.getInt(3));
				t6.setText(""+rs.getInt(5));
				t7.setText(""+rs.getString(6));
				
			}
			else
			{
					JOptionPane.showMessageDialog(f,"invalid credentials","Alert",JOptionPane.WARNING_MESSAGE);
			}
			}catch(Exception e3){System.out.println(e3);}
		}
		if(e1.getSource()==b2)
		{
			try{
				f=new JFrame();
				s3=t3.getText();
				s4=t4.getText();
				s5=t5.getText();
				s6=t6.getText();
				s7=t7.getText();
				
				pstmt=con.prepareStatement("update student set s_name=?, s_class=?, s_rollno=?, s_phno=?, s_email=? where s_rollno=? and s_class=?");
				pstmt1=con.prepareStatement("update issue_details set s_name=?, s_rollno=?, s_class=? where s_rollno=? and s_class=?");
				pstmt.setString(1,s3);
				pstmt.setString(2,s4);
				int r=Integer.parseInt(s5);
				pstmt.setInt(3,r);
				int p=Integer.parseInt(s6);
				pstmt.setInt(4,p);
				pstmt.setString(5,s7);
				pstmt.setInt(6,r);
				pstmt.setString(7,s2);
				
					
				int n=pstmt.executeUpdate();
				
				pstmt1.setString(1,s3);
				pstmt1.setInt(2,r);
				pstmt1.setString(3,s2);
				
				pstmt1.setInt(4,r);
				pstmt1.setString(5,s2);
				
				int n1=pstmt1.executeUpdate();
				
				flag=1;
			if(flag==1)
			{
				JOptionPane.showMessageDialog(f,"Student record updated");
			}
			else{
				JOptionPane.showMessageDialog(f,"Student record not updated");
			}
			}catch(Exception e5){System.out.println(e5);}
		}
		if(e1.getSource()==b3)
		{
			new Home();
			
		}
		
		
		
	}
		
	
	public static void main(String args[])
	{
		new CheckMember();
	
		
	}
}