
package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Database_console {
    public static void main(String args[]){
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
        catch(SQLException e){
           System.out.println(e.getMessage());
        }    
    }
}
