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
public class modifybook extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/xml");
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
        PreparedStatement stmt= conn.prepareStatement("select * from book where accno=?");
        stmt.setString(1, accno);
        ResultSet set = stmt.executeQuery();
        out.println("<?xml version='1.0' encoding='ISO-8859-1'?>");
        out.println("<bookdetails>");

        if(!set.next()){
            out.println("<error>nobook</error>");
            out.println("</bookdetails>");
        }
        else {
            out.println("<error>noerror</error>");
            out.println("<title>"+set.getString("title")+" </title>");
            out.println("<author>"+set.getString("author")+" </author>");
            out.println("<publication>"+set.getString("publication")+" </publication>");
            out.println("<edition>"+set.getString("edition")+" </edition>");
            out.println("<volume>"+set.getString("volume")+" </volume>");
            out.println("<year>"+set.getString("yyyy")+" </year>");
            out.println("<pages>"+set.getString("pages")+" </pages>");
            out.println("<subject>"+set.getString("subject")+" </subject>");
            out.println("<ddc>"+set.getString("ddc")+" </ddc>");
            out.println("<sears>"+set.getString("sears")+" </sears>");

       }
       out.println("</bookdetails>");


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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        basicLibrary insert=new basicLibrary();
        try{
                
                System.out.println("inserting new book");
                int i=insert.modifyBook(request.getParameter("oldaccno"), request.getParameter("newaccno"), request.getParameter("title"), request.getParameter("author"), request.getParameter("publication"), request.getParameter("edition"), request.getParameter("volume"), request.getParameter("year"), request.getParameter("pages"), request.getParameter("subject"), request.getParameter("ddc"), request.getParameter("sears"));//out.println("here");
                if (i==0){out.println("Could not modify");}
                else out.println("Servlet modifybook at " + request.getContextPath ());
            }
            catch(Exception sql){
                out.println("error1 "+sql);
            }
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
