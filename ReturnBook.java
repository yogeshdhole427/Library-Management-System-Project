import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class ReturnBook extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5;
	JLabel hl1,hl2,hl3;
	JButton hb1,hb2,hb3,hb4,hb5,hb6;	

	int flag;
	JPanel p2;
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	JComboBox cb,cmb1;
	ResultSet rs,rs1,rs2;
	Connection con;
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
	Statement stmt,stmt1,stmt2;
	String rn,cl,rd,br;
	int bn,tot,totstd,totib,totab,ab;
	public ReturnBook()
	{
		
		setTitle("Return Book");
		setLayout(null);
		f=new JFrame();
		
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
		hp5.add(hl2);
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/horizontal1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(0,0,200,100);
		hp5.add(hbackground2);
		
		add(hp5);	
		
		
		
		//home code end

		l1 = new JLabel("Roll No:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2 = new JLabel("Class:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Stuudent Name:");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4 = new JLabel("Book Name:");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5 = new JLabel("Author:");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("Issue Date:");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7 = new JLabel("Return Date:");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l8 = new JLabel("Book Return:");
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
		b1.setBackground(new Color(159,255,146));
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b2=new JButton("Submit");
		b2.setBackground(new Color(159,255,146));
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b3=new JButton("Back");
		b3.setBackground(new Color(159,255,146));
		b3.setForeground(Color.BLACK);	
		b3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		String c1[]={"Select","FYBBA","SYBBA","TYBBA","FYBCA","SYBCA","TYBCA","FYBCS","SYBCS","TYBCS","FYBCOM","SYBCOM","TYBCOM"};
		cb=new JComboBox(c1);
		cb.setForeground(Color.BLACK);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 16));
		String c2[]={"Select","Returned"};
		cmb1=new JComboBox(c2);
		cmb1.setForeground(Color.BLACK);
		cmb1.setFont(new Font("Times New Roman", Font.BOLD, 16));
			
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,0,1400,100);
		p2.setBackground(new Color(0,0,0,125));

		l1.setBounds(100,30,100,40);
		t1.setBounds(230,30,150,40);
		l2.setBounds(440,30,100,40);
		cb.setBounds(520,30,150,40);
		b1.setBounds(750,30,130,40);
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(cb);
		p2.add(b1);
		hp3.add(p2);
		l3.setBounds(140,130,150,30);
		t3.setBounds(310,130,500,30);
		t3.setEditable(false);
		l4.setBounds(140,180,150,30);
		t4.setBounds(310,180,400,30);
		t4.setEditable(false);
		l5.setBounds(140,230,100,30);
		t5.setBounds(310,230,300,30);
		t5.setEditable(false);
		l6.setBounds(140,280,150,30);
		t6.setBounds(310,280,150,30);
		t6.setEditable(false);
		l7.setBounds(490,280,150,30);
		t7.setBounds(650,280,150,30);
		t7.setEditable(false);
		l8.setBounds(140,340,150,30);
		cmb1.setBounds(310,340,150,30);
		
		b2.setBounds(340,420,130,40);
		b3.setBounds(500,420,130,40);	
		hp3.add(l3);
		hp3.add(l4);
		hp3.add(l5);
		hp3.add(cmb1);
		hp3.add(l6);
		hp3.add(l7);
		hp3.add(l8);
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
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lbms","root","");
		}catch(Exception e4){System.out.println(e4);}
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try{
			f=new JFrame();
			rn=t1.getText();
			int n1=Integer.parseInt(rn);
			cl=""+cb.getItemAt(cb.getSelectedIndex());
			
		if(e.getSource()==b1)
		{
			
			String str="Not Returned";
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from issue_details where s_rollno='"+n1+"' and s_class='"+cl+"' and returned='"+str+"'");
			
			if(rs.next())
			{
				t3.setText(rs.getString(1)+"");
				t4.setText(rs.getString(4)+"");
				t5.setText(rs.getString(5)+"");
				t6.setText(rs.getString(6)+"");
				t7.setText(rs.getString(7)+"");
				
			}
			else
			{
				
				JOptionPane.showMessageDialog(f,"Entered data did not match","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==b2)
		{
				String bnm=t4.getText();
				String ba=t5.getText();
				stmt1=con.createStatement();
				rs1=stmt.executeQuery("select * from book_details where  book_name='"+bnm+"' and b_author='"+ba+"'");
				if(rs1.next())
				{
					bn=rs1.getInt(6);
					flag=1;
				}
				f=new JFrame();
				br=""+cmb1.getItemAt(cmb1.getSelectedIndex());
				rd=t7.getText();
				if(flag==1){

				pstmt=con.prepareStatement("update issue_details set returned=?, retuurn_date=? where s_rollno=? and s_class=?");
				
				pstmt.setString(1,br);
				pstmt.setString(2,rd);
				pstmt.setInt(3,n1);
				pstmt.setString(4,cl);	
				int n=pstmt.executeUpdate();

					int c=bn+1;
					pstmt1=con.prepareStatement("update book_details set b_qty=? where book_name=? and b_author=?");
					pstmt1.setInt(1,c);
					pstmt1.setString(2,bnm);
					pstmt1.setString(3,ba);
					int p1=pstmt1.executeUpdate();
				JOptionPane.showMessageDialog(f,"Book Record Updated");	
				}
			
				stmt2=con.createStatement();
				rs2=stmt2.executeQuery("select * from report");
				if(rs2.next())
				{
					tot=rs2.getInt(4);
					ab=rs2.getInt(5);
					
				}
				
				totstd=tot+1;
				pstmt2=con.prepareStatement("update report set t_returnedbooks=?,t_issuedbooks=?,t_availablebooks=?");
				
				pstmt2.setInt(1,totstd);
				
				totib=tot-1;
				pstmt2.setInt(2,totib);
				totab=ab+1;
				pstmt2.setInt(3,totab);
				int n3=pstmt2.executeUpdate();
				
		}}catch(Exception e5){System.out.println(e5);}
		if(e.getSource()==b3)
		{
			
			new Home();
		}
		
		
		
	}
		
	
	public static void main(String args[])
	{
		new ReturnBook();
	
		
	}
}