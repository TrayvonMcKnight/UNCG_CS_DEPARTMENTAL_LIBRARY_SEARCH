import java.sql.*;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    String dbURL = "jdbc:derby://localhost:1527/db";
    Connection c = null;
    Statement stmt = null;
    
    try {
        c = DriverManager.getConnection(dbURL);
      c.setAutoCommit(false);
      System.out.println("HERE ARE YOUR RESULTS:");
      System.out.println();

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM APP.CSLIB" );
      while ( rs.next() ) {
         int id = rs.getInt("id"); 
         String  title = rs.getString("TITLE");
         String author  = rs.getString("AUTHOR");
         String  publisher= rs.getString("PUBLISHER");
         String location = rs.getString("LOCATION");
         System.out.println( "ID = " + id );
         System.out.println( "TITLE= " + title ); 
         System.out.println( "AUTHOR = " + author );
         System.out.println( "PUBLISHER = " + publisher);
         System.out.println( "LOCATION = " + location);
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("NO RESULTS FOUND - TRY YOUR SEARCH AGAIN");
    
  }
}