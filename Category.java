import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Category extends JFrame implements ActionListener
{
	
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	public Category()
	{
		
		
		setLayout(null);
		l1=new JLabel("Library Managment System");
		l1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		l1.setBounds(200,50,400,50);
		b1=new JButton("Category");
		b1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		b1.setForeground(Color.BLACK);
		b1.setBounds(320,160,150,40);
		b1.setBackground(Color.RED);
		b2=new JButton("Author");
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		b2.setBounds(320,230,150,40);
		b2.setBackground(Color.CYAN);
		b3=new JButton("Books");
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		b3.setBounds(320,300,150,40);
		b3.setBackground(Color.CYAN);
		b4=new JButton("issue_Books");
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		b4.setBounds(320,370,150,40);
		b4.setBackground(Color.CYAN);
		b5=new JButton("return_Book");
		b5.setForeground(Color.BLACK);
		b5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		b5.setBounds(320,440,150,40);
		b5.setBackground(Color.CYAN);
		
		add(l1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b1);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setTitle("SVPM Library");
		setSize(800,800);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)
		{
			
		}
		if(e.getSource()==b3)
		{
			
		}
		if(e.getSource()==b4)
		{
			
		}
		if(e.getSource()==b5)
		{
			
		}
		
	}
	public static void main(String args[])
	{
		new Category();
	}
}