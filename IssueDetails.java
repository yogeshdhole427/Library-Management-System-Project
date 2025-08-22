import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
public class IssueDetails extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp5;
	JFrame hf;
	JLabel hl1,hl2,l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	static int cnt=0;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	String bnm, baut;
	
	String[] col={"Student Name","Roll No","Class","Book Name","Author","Issue Date","Return Date"};
		DefaultTableModel dtm=new DefaultTableModel(col,0);
		JTable tb=new JTable(dtm);
	
	public IssueDetails()
	{
		
		hf=new JFrame("Issue Details");
		
		
		hp1=new JPanel();
		hp1.setLayout(null);
		hp1.setBounds(0,100,1400,100);
		hp1.setBackground(Color.GRAY);

		
		
		

		
	
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(210,10,500,70);
		
		
		
		
		
		
		tb.setEnabled(false);
		tb.setRowHeight(tb.getRowHeight()+20);
		JTableHeader tblhead=tb.getTableHeader();
		tblhead.setForeground(Color.BLACK);
		Font headerFont=new Font("Brodway",Font.BOLD, 15);
		tblhead.setFont(headerFont);
		DefaultTableCellRenderer rd=new DefaultTableCellRenderer();
		rd.setHorizontalAlignment(SwingConstants.CENTER);
		tb.getColumnModel().getColumn(1).setCellRenderer(rd);
		hp3=new JPanel();
		
		hp3.setBounds(0,200,1400,600);
		hp3.setBackground(new Color(255,255,255));
		hp3.setLayout(new BorderLayout(5,10));
		add(hp3,BorderLayout.NORTH);
		
		hp3.add(new JScrollPane(tb), BorderLayout.CENTER);
		
		l1=new JLabel("Book Name:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l2=new JLabel("Author:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t1=new JTextField();
		t1.setForeground(Color.BLACK);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t2=new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1=new JButton("Check");
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBackground(new Color(231, 230, 230));
		b2=new JButton("Back");
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setBackground(new Color(231, 230, 230));
		
		l1.setBounds(40,40,150,30);
		t1.setBounds(170,40,300,30);
		l2.setBounds(500,40,150,30);
		t2.setBounds(580,40,250,30);
		b1.setBounds(900,30,100,40);
		b2.setBounds(1020,30,100,40);
		
		hp1.add(l1);
		hp1.add(l2);
		hp1.add(t1);
		hp1.add(t2);
		hp1.add(b1);
		hp1.add(b2);
			
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,0,1400,100);
		hp5.setBackground(new Color(49,199,4));
		hp5.add(hl2);
		JLabel hbackground2;
		ImageIcon himg2=new ImageIcon("images/Homelogo1.png");
		hbackground2=new JLabel("",himg2,JLabel.CENTER);
		hbackground2.setBounds(20,0,150,100);
		hp5.add(hbackground2);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);	
		JFrame jf=new JFrame("Issue Details");
		
		jf.add(hp1);
		
		jf.add(hp3);
		
		jf.add(hp5);
		jf.setSize(1400,750);
		
		jf.setVisible(true);
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lbms","root","");
		}catch(Exception e4){System.out.println(e4);}
		
			
		
		
	}
	public void actionPerformed(ActionEvent he1)
	{
		try{
			JFrame f=new JFrame();
			bnm=t1.getText();
			baut=t2.getText();
		if(he1.getSource()==b1)
		{
			String str="Not Returned";
			stmt=con.createStatement();
			Vector v1=new Vector();
			rs=stmt.executeQuery("select * from issue_details where book_name='"+bnm+"' and b_author='"+baut+"' and returned='"+str+"'");
			while(rs.next())
			{
				v1.add(rs.getString(1));
				v1.add(rs.getInt(2));
				v1.add(rs.getString(3));
				v1.add(rs.getString(4));
				v1.add(rs.getString(5));
				v1.add(rs.getString(6));
				v1.add(rs.getString(7));
				
		
			}
			dtm.addRow(v1);
		}
		}catch(Exception e2){ System.out.println(e2);}
		if(he1.getSource()==b2)
		{
			new Home();
		}
		
		
	}
		
	
	public static void main(String args[])
	{
		new IssueDetails();
		
		
	}
}
