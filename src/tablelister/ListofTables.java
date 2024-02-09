package tablelister;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListofTables {
 
  static String user = "postgres";
  static  PWD pwd = new PWD();
  static String url = "jdbc:postgresql://localhost:5432/test";
  // static String sql = "select * from students";
  static Connection connection;
  static ResultSet rs ;
  static DatabaseMetaData dmd;


  public static void main(String[] args) throws SQLException {
    /*
     * try { Class.forName("org.postgresql.Driver"); }catch(ClassNotFoundException
     * a) { System.out.println("Driver not found exception");
     * System.out.println(a.getMessage()); return; }
     */
     connection = DriverManager.getConnection(url, user, pwd.getPwd());
    int i = 1;
   try {
    
    dmd = connection.getMetaData();
    
    String[] tables = {"TABLE"};
    rs = dmd.getTables(null, null,null, tables);
    System.out.println("Tables in database are: ");
    while(rs.next()) {
      String list = rs.getString("TABLE_NAME");
      System.out.println((i++)+", "+ list);
      
    }
  } catch (SQLException e) {
    e.printStackTrace();
  
  }

  }

}
