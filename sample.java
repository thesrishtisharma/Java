
package database_console;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

import java.sql.*;

/*<applet code="sample" width=500 height=1000>
</applet>*/

public class sample extends JApplet implements ActionListener 
{

    String msg="";
	JButton e,c,st,b1,b2;
	JLabel el,cl,stl,l1,l2,l3,nl,nll,l4;
        JTextField et,ct;
	FlowLayout F;
    public void init() 
    {
        F=new FlowLayout(FlowLayout.CENTER);
		JPanel p=new JPanel();
		getContentPane().add(p);
		p.setLayout(F);
		
		//Select Query
		l1=new JLabel("View Records using the following buttons :- ");
		el=new JLabel("Click to view Employee records : ");
		e=new JButton("Employee Records");
		cl=new JLabel("Click to view Customer records : ");
		c=new JButton("Customer Records");
		stl=new JLabel("Click to view Stock Records : ");
		st=new JButton("Stock Records");
		
		//Insert Query
		l2=new JLabel("Insert new records into the existing tables :- ");
                l3=new JLabel("Insert records into the 'Employee' table :- ");
                nl=new JLabel("Enter Employee name : ");
                et=new JTextField("");
                et.setPreferredSize(new Dimension(200,24));
                b1=new JButton("Submit Employee");
                l4=new JLabel("Insert records into the 'Customer' table :- ");
                nll=new JLabel("Enter Customer name : ");
                ct=new JTextField("");
                ct.setPreferredSize(new Dimension(200,24));
                b2=new JButton("Submit Customer");
                
		//select query
		p.add(l1);
		p.add(el);
		p.add(e);
		p.add(cl);
		p.add(c);
		p.add(stl);
		p.add(st);
                
                //insert query
                p.add(l2);
                p.add(l3);
                p.add(nl);
                p.add(et);
                p.add(b1);
                p.add(l4);
                p.add(nll);
                p.add(ct);
                p.add(b2);
                
		
		e.addActionListener(this);
		c.addActionListener(this);
		st.addActionListener(this);
                et.addActionListener(this);
                b1.addActionListener(this);
                ct.addActionListener(this);
                b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
		String str=ae.getActionCommand();
		if(str.equals("Employee Records"))
		{
                    System.out.println("Inside Employee Schema");
                    try{
                        String host="jdbc:mysql://localhost:3306/db?zeroDateTimeBehavior=convertToNull";
			String name="root";
                        String pass="27381080";
                        Connection con = DriverManager.getConnection(host,name,pass);
            
                        Statement stmt=con.createStatement();
                        String sql="select * from empl";
                        ResultSet rs = stmt.executeQuery(sql);
            
                        while(rs.next())
                        {
                            int ENo = rs.getInt("ENo");
                            String EName = rs.getString("EName");
                            String p=ENo+" "+EName+" ";
                            System.out.println(p);
                
                        }
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("****END OF EMPLOYEE TABLE****");
		}
		else if(str.equals("Customer Records"))
		{
                    System.out.println("Inside Customer Schema");
                    try{
                    String host="jdbc:mysql://localhost:3306/db?zeroDateTimeBehavior=convertToNull";
                    String name="root";
                    String pass="27381080";
                    Connection con = DriverManager.getConnection(host,name,pass);
            
                    Statement stmt=con.createStatement();
                    String sql="select * from cus";
                    ResultSet rs = stmt.executeQuery(sql);
            
                    while(rs.next())
                    {
                        int CNo = rs.getInt("CNo");
                        String CName = rs.getString("CName");
                        String p=CNo+" "+CName+" ";
                        System.out.println(p);
                 
                    }
                    }
                    catch(SQLException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("****END OF CUSTOMER TABLE****");
                }
                else if(str.equals("Stock Records"))
		{
                    System.out.println("Inside Stock Schema");
                    try{
                        String host="jdbc:mysql://localhost:3306/db?zeroDateTimeBehavior=convertToNull";
		        String name="root";
                        String pass="27381080";
                        Connection con = DriverManager.getConnection(host,name,pass);
            
                        Statement stmt=con.createStatement();
                        String sql="select * from stock";
                        ResultSet rs = stmt.executeQuery(sql);
            
                        while(rs.next())
                        {
                            int Sno = rs.getInt("Sno");
                            String Brand = rs.getString("Brand");
                            String Type = rs.getString("Type");
                            String SDate = rs.getString("SDate");
                            String p=Sno+" "+Brand+" "+Type+" "+SDate;
                            System.out.println(p);
                        }
                    }
                    catch(SQLException e){
                            System.out.println(e.getMessage());
                    }
                    System.out.println("****END OF STOCK TABLE****");
                }
                else if(str.equals("Submit Employee"))
                {
                    try{
                       
                
                        String host="jdbc:mysql://localhost:3306/db?zeroDateTimeBehavior=convertToNull";
		        String name="root";
                        String pass="27381080";
                        Connection con = DriverManager.getConnection(host,name,pass);
            
                        Statement stmt=con.createStatement();
                        String sql=("insert into empl(Ename) values('"+et.getText()+"')");
                        stmt.executeUpdate(sql);
                        
                
                    }
                    catch(SQLException e){
                            System.out.println(e.getMessage());
                    }
                    System.out.println("****END OF INSERTION IN EMPLOYEE TABLE****");
                }
                else if(str.equals("Submit Customer"))
                {
                    try{
                        
                
                        String host="jdbc:mysql://localhost:3306/db?zeroDateTimeBehavior=convertToNull";
		        String name="root";
                        String pass="27381080";
                        Connection con = DriverManager.getConnection(host,name,pass);
            
                        Statement stmt=con.createStatement();
                        String sql=("insert into cus(Cname) values('"+ct.getText()+"')");
                        stmt.executeUpdate(sql);
                        
                    }
                    catch(SQLException e){
                            System.out.println(e.getMessage());
                    }
                    System.out.println("****END OF INSERTION IN CUSTOMER TABLE****");
                } 
        }  
}
