package DBPackage;

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
public class basicLibrary extends DBPackage.DBConnection {

    public int acc;
    public String title;
    public String author;
    public String publication;

    public int edition;
    public int volume;
    public int year;
    public int pages;
    public String subject;
    public String ddc;
    public String sears;

    public basicLibrary() {
        acc = 0;
        title = "";
        author = "";
        publication = "";
        edition = 0;
        volume = 0;
        year = 0;
        pages = 0;
        subject = "";
        ddc = "";
        sears = "";
    }        
    
    public static ResultSet getAllBooks() {
        try {
            createConnection();
            stmt = conn.prepareStatement("select * from book");
            rset = stmt.executeQuery();
            return rset;
        } catch (SQLException ex) {
            System.out.println("exception in getAlllBooks() : " + ex);
        }
        return rset;
    }

    /**
     * Inserts one of more books to library, by reading from an array of books
     * 
     * @param books array of books(class basicLibrary) 
     */
    public static void insertMultipleBooks(basicLibrary books[]) {
        int ii;
        try {
            for (ii = 0; ii < books.length; ii++) {
                books[ii].insertNewBook();
            }
        } catch (java.lang.NullPointerException ex) {
            System.out.println("able to catch exception : " + ex);
        }
    }
    
    /**
     * the arguments are that of the attributes in the table "book"
     */
    public int insertNewBook(){
        try {
            createConnection();
            stmt = conn.prepareStatement(
                    "insert into book values(?,?,?,?,?,?,?,?,?,?,?)");
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
            stmt.executeUpdate();//exucuting the query
            
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
            stmt = conn.prepareStatement("delete from book where accno=?");
            stmt.setInt(1, accno);//completed the query
            stmt.executeUpdate();
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
            stmt = conn.prepareStatement("select * from issued_books where accno=?");
            stmt.setString(1, bookID);//completed the query
            rset=stmt.executeQuery();//exucuting the query
            if (rset.next()){
                System.out.println("Already issued");
                
            }
            else{
            	stmt = conn.prepareStatement("select to_char(sysdate, 'DD-Mon-YY') from dual");
            	rset = stmt.executeQuery();//exucuting the query
            	String curTime="",deadline="";
            	if (rset.next()){
                	curTime=rset.getString(1);
                	//out.println(curTime);
                }
                stmt = conn.prepareStatement("select to_char(sysdate+30, 'DD-Mon-YY') from dual");
                if (rset.next()){
                	deadline=rset.getString(1);
                	//out.println(deadline);
                }
                stmt = conn.prepareStatement("insert into issued_books values(?,?,?,?,?)");
                stmt.setString(1, personID);
                stmt.setString(2, bookID);
                stmt.setString(3, curTime);
                stmt.setString(4, deadline);
                int fine = 0;
                stmt.setInt(5, fine);
                //should insert taken on, deadline and fine
                //ResultSet set=stmt.executeQuery("select curdate()");
                //pStmt.setString(3, );
                stmt.executeUpdate();//exucuting the query
                
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
            stmt = conn.prepareStatement("select * from issued_books where accno=?");
            stmt.setString(1, bookID);//completed the query
            rset=stmt.executeQuery();//exucuting the query
            if (!rset.next()){
                System.out.println("Not issued");
                return 2;
            }
            else{
                stmt = conn.prepareStatement("delete from issued_books where accno=?");
                stmt.setString(1, bookID);//completed the query
                stmt.executeUpdate();//exucuting the query
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
    public int getmaxAcc(){
        createConnection();
        try{
            stmt = conn.prepareStatement("select max(accno) from book");
            ResultSet rset=stmt.executeQuery();
            rset.next();
            int i=rset.getInt(1);
            closeConnection();
            return i;
        }
        catch(Exception sql){
            System.out.println("error2");
        }
     return 0;
    }
    public int modifyBook(String oldacc,
            String newacc, String title, String author, String publication,
            String edition, String volume, String year, String pages, String subject, String ddc, String sears){
        try {
            createConnection();
            stmt = conn.prepareStatement("update book set accno=?,title=?,author=?,publication=?,edition=?,volume=?,"
                    + "yyyy=?,pages=?,subject=?,ddc=?,sears=? where accno=?");
            stmt.setString(1, newacc);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publication);
            stmt.setString(5, edition);
            stmt.setString(6, volume);
            stmt.setString(7, year);
            stmt.setString(8, pages);
            stmt.setString(9, subject);
            stmt.setString(10, ddc);
            stmt.setString(11, sears);
            stmt.setString(12, oldacc);//completed the query
            stmt.executeUpdate();//exucuting the query
            closeConnection();
        } catch (Exception sqle) {
            System.out.println("SQLException : " + sqle);
            return 0;
        }
        return 1;
    }
}
