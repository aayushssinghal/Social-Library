/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI_pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import DBPackage.basicLibrary;
/**
 *
 * @author dhiraj
 */
public class issuebook extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modifybook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modifybook at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            String databaseName = "social_library";
        String connectionURL = "jdbc:derby://localhost:1527/" + databaseName + ";";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection(connectionURL);
            //Class.forName ("oracle.jdbc.driver.OracleDriver");
        //conn = DriverManager.getConnection("jdbc:oracle:thin:@10.105.1.30:1521:oradb","z9005044" ,"z9005044" );
        String accno=request.getParameter("accno");
        String id=request.getParameter("id");
        PreparedStatement stmt= conn.prepareStatement("select * from issued_books where accno=?");
        PreparedStatement stmt1= conn.prepareStatement("select * from book where accno=?");
        PreparedStatement stmt2= conn.prepareStatement("select * from person where id=?");
        stmt.setString(1, accno);
        stmt1.setString(1, accno);
        stmt2.setString(1, id);
        ResultSet set = stmt.executeQuery();
        ResultSet set1 = stmt1.executeQuery();
        ResultSet set2 = stmt2.executeQuery();
        if(!set1.next()){out.println("no book found with the Acc. no.");}
        else if(!set2.next()){out.println("no person found with the ID");}
        else if(set.next())
            {
            out.println("Book already issued");
        }
        else {
            stmt = conn.prepareStatement("insert into issued_books values(?, ?)");
            stmt.setString(1, accno);
            stmt.setString(2, id);//////////////TODO : should have to use the function for date and fine
            try {
                stmt.executeUpdate();
                out.println("Book succesfully issued");
            } catch (Exception e){
                out.println(e);
            }

            
        }
       

        stmt.close();
            conn.close();
        } catch(SQLException sqle) {
            System.err.println("problem in connecting to database :" + sqle);
        } catch(java.lang.ClassNotFoundException exp) {
            System.err.println("Database Driver class not found : " + exp);
        }
            } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
