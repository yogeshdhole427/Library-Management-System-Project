import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
public class BookDetails extends JFrame
{
	static JPanel hp1,hp2,hp3,hp5;
	JFrame hf;
	JLabel hl1,hl2;
	
	
	static int cnt=0;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	String bnm, baut;
	
	String[] col={"Book Name","Category","Author","Publisher","No of Pages","Quantity","Edition"};
		DefaultTableModel dtm=new DefaultTableModel(col,0);
		JTable tb=new JTable(dtm);
	
	public BookDetails()
	{
		
		hf=new JFrame("Issue Details");
		
		
		

		/*hl1 = new JLabel("LIBRARY MANAGEMENT");
		hl1.setForeground(Color.RED);
		hl1.setFont(new Font("Broadway", Font.BOLD, 25));
		hl1.setBounds(120,5,600,40);
		
		
		

		hp2=new JPanel();
		hp2.setLayout(null);
		hp2.setBounds(0,50,1400,100);
		hp2.setBackground(new Color(37,160,0));
	
		
		
		
		hp2.add(hl1);*/
		
		
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
		hp3.setBounds(0,150,1400,600);
		hp3.setBackground(new Color(255,255,255));
		hp3.setLayout(new BorderLayout(5,10));
		add(hp3,BorderLayout.NORTH);
		//hp3.add(new JScrollPane(tb));
		hp3.add(new JScrollPane(tb), BorderLayout.CENTER);
		//new BorderLayout(5,10)
		//add(hp3);
		//BorderLayout.NORTH
		
		
		//, BorderLayout.CENTER
		
		
		
		
		
		
		
			
		
		
		
		
			
		JFrame jf=new JFrame("Book Details");
		
		
		//jf.add(hp2);
		jf.add(hp3);
		
		jf.setSize(1400,750);
		jf.setVisible(true);
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lbms","root","");
		
			
		
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery("select * from book_details");
			while(rs.next())
			{
				Vector v1=new Vector();
				v1.add(rs.getString(1));
				v1.add(rs.getString(2));
				v1.add(rs.getString(3));
				v1.add(rs.getString(4));
				v1.add(rs.getInt(5));
				v1.add(rs.getInt(6));
				v1.add(rs.getInt(7));
				dtm.addRow(v1);

		
			}
						
		}catch(Exception e4){System.out.println(e4);}
		
		
	}
	
	
	public static void main(String args[])
	{
		new BookDetails();
		
		
	}
}
