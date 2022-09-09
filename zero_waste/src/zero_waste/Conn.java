/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero_waste;
import java.sql.*;  

/**
 *
 * @author Anila Ditita
 */
public class Conn {
     java.sql.Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=zero_waste;selectMethod=cursor", "sa", "123456");
            s = c.createStatement();
            
           
        }catch(Exception e){ 
            e.printStackTrace();
        }  
    }  
    
}
