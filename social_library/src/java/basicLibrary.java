/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package library;
import java.sql.*;
/**
 *
 * @author dhiraj - edited by Aayush
 */
public class basicLibrary {
    int acc;
    String title;
    String author;
    String publication;

    int edition; 
    int volume;
    int year;
    int pages;
    String subject; 
    String ddc;
    String sears;

            
    protected static Connection conn;
    protected static ResultSet rset = null;
    protected static PreparedStatement stmt;

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

    
    /**
     * the arguments are that of the attributes in the table "book"
     */
    public int insertNewBook(){
        try {
            createConnection();
            stmt = conn.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, acc);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publication);
            stmt.setInt(5, edition);
            stmt.setInt(6, volume);
            stmt.setInt(7, year);
            stmt.setInt(8, pages);
            stmt.setString(9, subject);
            stmt.setString(10, ddc);
            stmt.setString(11, sears);//completed the query
            stmt.execute();//exucuting the query
            
            closeConnection();
        } catch (Exception sqle) {
            System.out.println("SQLException at insert : " + sqle);
            return 0;//return 0 for failure
        }
        return 1;//return 1 for success
    }
    
    /*
     * the argument is book ID, it is enough for delete as it is the primary key
     */
    public static int deleteBook(int accno){
        try {
            createConnection();
            stmt = conn.prepareStatement("delete from book where ID=?");
            stmt.setInt(1, accno);//completed the query
            stmt.execute();
            closeConnection();
        }
        catch (Exception sqle) {
            System.out.println("SQLException at delete : " + sqle);
            return 0;
        }
        return 1;
    }

    /**
     * the arguments are ID of the person issuing the book and the ID of the book being issued
     */
    public static int issueBook(String personID, String bookID){
        try {
            createConnection();
            stmt = conn.prepareStatement("select * from issued_books where bookID=?");
            stmt.setString(1, bookID);//completed the query
            rset=stmt.executeQuery();//exucuting the query
            if (rset.next()){
                System.out.println("Already issued");
                
            }
            else{
                stmt = conn.prepareStatement("insert into issued_books values(?,?,?,?,?)");
                stmt.setString(1, personID);
                stmt.setString(2, bookID);
                //should insert taken on, deadline and fine
                //ResultSet set=stmt.executeQuery("select curdate()");
                //pStmt.setString(3, );
                stmt.execute();//exucuting the query
                
            }
            closeConnection();
        }
        catch (Exception sqle) {
            System.out.println("SQLException : " + sqle);
            return 0;
        }
        return 1;
    }
    /*
     * the argument is the book being returned, this is enough as it can be made primary key
     */
        public static int returnBook(String bookID){
        try {
            createConnection();
            stmt = conn.prepareStatement("select * from issued_books where bookID=?");
            stmt.setString(1, bookID);//completed the query
            rset=stmt.executeQuery();//exucuting the query
            if (!rset.next()){
                System.out.println("Not issued");
            }
            else{
                stmt = conn.prepareStatement("delete from issued_books where bookID=?");
                stmt.setString(1, bookID);//completed the query
                stmt.execute();//exucuting the query
            }
            closeConnection();
        }
        catch (Exception sqle) {
            System.out.println("SQLException : " + sqle);
            return 0;
        }
        return 1;
    }
    /*
     * the arguments are the ID of the book to be modified and the new values of the book
     */
    public int modifyBook(String oldID,
            String newID, String title, String author, String publication,
            String edition, String volume, String year, String pages, String subject, String ddc, String acc){
        try {
            createConnection();
            stmt = conn.prepareStatement("update book set ID=?,title=?,author=?,publication=?,edition=?,volume=?,"
                    + "year=?,pages=?,subject=?,ddc=?,acc=? where ID=?");
            stmt.setString(1, newID);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publication);
            stmt.setString(5, edition);
            stmt.setString(6, volume);
            stmt.setString(7, year);
            stmt.setString(8, pages);
            stmt.setString(9, subject);
            stmt.setString(10, ddc);
            stmt.setString(11, acc);
            stmt.setString(12, oldID);//completed the query
            stmt.execute();//exucuting the query
            closeConnection();        
        } catch (Exception sqle) {
            System.out.println("SQLException : " + sqle);
            return 0;
        }
        return 1;
    }
}