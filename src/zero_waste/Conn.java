package zero_waste;
import java.sql.*;  

public class Conn {
     java.sql.Connection c;
    Statement s;
     private  Statement stmt = null;
    private Connection connection;
    
        //Conncect to SQL Database
    //localhost1433 sa,p@ssword13,ConcertMania
    public Connection connectToDB() throws ClassNotFoundException, SQLException{
        System.out.println("DB is connecting");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=123456;" + "databaseName=zero_waste;";
        connection = DriverManager.getConnection(connectionUrl);
        System.out.println("Database is connected successfully");
        java.sql.Statement stmt = connection.createStatement();
        return connection;
      }
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
