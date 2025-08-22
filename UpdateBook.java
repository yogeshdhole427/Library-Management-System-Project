import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class UpdateBook extends JFrame implements ActionListener
{
	static JPanel hp1,hp2,hp3,hp4,hp5;
	JLabel hl1,hl2,hl3;
	
	JPanel p2;
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;

	Connection con;
	Statement stmt,stmt1;
	ResultSet rs;
	PreparedStatement pstmt;


	String bnm,aut,ctg,edi,publ,nbk,nbp;
	int ed,nb,np,flag=0;
	public UpdateBook()
	{
		
		setTitle("Update Book");
		setLayout(null);
		
		
		f=new JFrame();

		//Home Page
		
		
		
		
		
		

		
		hl2 = new JLabel("LIBRARY  MANAGMENT");
		hl2.setForeground(Color.WHITE);
		hl2.setFont(new Font("Broadway", Font.BOLD, 36));
		
		
		hl2.setBounds(230,10,500,70);
		
		
		
		
		
		
		
		hp3=new JPanel();
		hp3.setLayout(null);
		hp3.setBounds(0,250,1400,600);
		hp3.setBackground(new Color(255,255,255));
		
		hp5=new JPanel();
		hp5.setLayout(null);
		hp5.setBounds(0,0,1400,100);
		hp5.setBackground(new Color(49,199,4));
		JLabel hbackground1;
		ImageIcon himg1=new ImageIcon("images/Homelogo1.png");
		hbackground1=new JLabel("",himg1,JLabel.CENTER);
		hbackground1.setBounds(0,0,200,100);
		hp5.add(hbackground1);
		hp5.add(hl2);
		
		add(hp5);	
		
		
		
		//home code end

		l1 = new JLabel("Book Name:");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2 = new JLabel("Author:");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3 = new JLabel("Category:");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4 = new JLabel("Edition:");
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l5 = new JLabel("Publisher:");
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6 = new JLabel("No.of Books:");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7 = new JLabel("No.of Pages:");
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));

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
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2=new JButton("Update");
		b2.setBackground(new Color(159,255,146));
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3=new JButton("Delete");
		b3.setBackground(new Color(159,255,146));
		b3.setForeground(Color.BLACK);	
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
					
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,100,1400,150);
		p2.setBackground(new Color(0,0,0,65));


		l1.setBounds(100,30,150,30);
		t1.setBounds(230,30,420,30);
		l2.setBounds(100,90,100,30);
		t2.setBounds(230,90,280,30);
		b1.setBounds(520,90,130,30);
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		p2.add(b1);
		add(p2);

		l3.setBounds(150,50,100,30);
		t3.setBounds(280,50,150,30);
		l4.setBounds(470,50,100,30);
		t4.setBounds(570,50,200,30);
		l5.setBounds(150,100,100,30);
		t5.setBounds(280,100,350,30);
		l6.setBounds(150,150,150,30);
		t6.setBounds(280,150,100,30);
		l7.setBounds(450,150,150,30);
		t7.setBounds(570,150,100,30);

		b2.setBounds(300,220,100,40);
		b3.setBounds(440,220,100,40);

		hp3.add(l3);
		hp3.add(l4);
		hp3.add(l5);
		hp3.add(l6);
		hp3.add(l7);
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
			bnm=t1.getText();
			aut=t2.getText();
		if(e.getSource()==b1)
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from book_details where book_name='"+bnm+"' and b_author='"+aut+"'");
			
			if(rs.next())
			{
				t3.setText(rs.getString(2)+"");
				t4.setText(rs.getInt(7)+"");
				t5.setText(rs.getString(4)+"");
				t6.setText(rs.getInt(6)+"");
				t7.setText(rs.getInt(5)+"");
				
			}	
			else{
				JOptionPane.showMessageDialog(f,"Book is not found");	
			}
		}
		if(e.getSource()==b2)
		{
			ctg=t3.getText();
			edi=t4.getText();
			ed=Integer.parseInt(edi);
			publ=t5.getText();
			nbk=t6.getText();
			nb=Integer.parseInt(nbk);
			nbp=t7.getText();
			np=Integer.parseInt(nbp);
			pstmt=con.prepareStatement("update book_details set book_name=?, b_category=?, b_author=?, b_publisher=?, b_pages=?, b_qty=?, b_edition=?  where book_name=? and b_author=?");
				pstmt.setString(1,bnm);
				pstmt.setString(2,ctg);
				pstmt.setString(3,aut);
				pstmt.setString(4,publ);
				pstmt.setInt(5,np);
				
				pstmt.setInt(6,nb);
				pstmt.setInt(7,ed);
				pstmt.setString(8,bnm);
				pstmt.setString(9,aut);	
				int n=pstmt.executeUpdate();
				flag=1;
			if(flag==1)
			{
				JOptionPane.showMessageDialog(f,"Book Record Updated Successfully");
			}
			else{
				JOptionPane.showMessageDialog(f,"Book Record Not updated");
			}
				
		}
		if(e.getSource()==b3)
		{
			stmt1=con.createStatement();
			int n2=stmt1.executeUpdate("delete  from book_details where book_name='"+bnm+"' and b_author='"+aut+"'");
			JOptionPane.showMessageDialog(f,"Book record is deleted");	
		}
		}catch(Exception e3){ System.out.println(e3);}
		
	}
	public static void main(String args[])
	{
		new UpdateBook();
	
		
	}
}