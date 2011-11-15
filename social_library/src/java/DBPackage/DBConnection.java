/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBPackage;
import java.sql.*;

/**
 *
 * @author aayush
 */
public class DBConnection extends DBPackage.DBExtendableServlet {

    public static void closeConnection() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Unable to close connections with database :" + ex);
        }
    }
    
    public static void createConnection() {
        String databaseName = "social_library";
        String connectionURL = "jdbc:derby://localhost:1527/" + databaseName + ";";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(connectionURL);
        } catch(SQLException sqle) {
            System.err.println("problem in connecting to database :" + sqle);
        } catch(java.lang.ClassNotFoundException exp) {
            System.err.println("Database Driver class not found : " + exp);
        }
    }    
}
