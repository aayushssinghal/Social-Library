/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

//import social_library.DBPackage;


/**
 *
 * @author aayush
 */
public class DisplayAllBooks extends DBPackage.DBConnection {

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
            /* TODO output your page here */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>All Books</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Display All Books" + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            createConnection();
            displayAllBooks(out);
            closeConnection();
        } finally {            
            out.close();
        }
    }

    public static void displayAllBooks(PrintWriter out) {
        displayTable(out, "book");
    }
    
    public static void selectFromTable(String table) {
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + table);
        } catch (SQLException sqle) {
            System.err.println("Could not create Prepared statement : " + sqle);
        } catch (java.lang.NullPointerException Exc) {
            System.err.println("conn is NULL" + Exc);
        }
        
        try {
            rset = stmt.executeQuery();
        } catch (SQLException sqle) {
            System.err.println("Could not fetch table " + table + " content from database : " + sqle);
        } catch (java.lang.NullPointerException Exc) {
            System.err.println("stmt is NULL" + Exc);
        }
    }

    
    public static void displayTable(PrintWriter out, String table) {
        selectFromTable(table);
        
        try {
            //out.println("total " + rset.getFetchSize() + " results found<br />");
            out.println("<table border = '1' cellpadding = '5'>");
            ResultSetMetaData rsmd = rset.getMetaData();
            int NumCol = rsmd.getColumnCount();
            out.println("<tr>");
            for (int i = 1; i <= NumCol; i++) {
                out.println("<th align = 'center'>" + rsmd.getColumnName(i) + "</th>");
            }
            int cnt = 0;
            int limit = 50;
            String s;
            out.println("</tr>");
            while (rset.next() && limit-- > 0) {
                cnt++;
                out.println("<tr>");
                    for (int i = 1; i <= NumCol; i++) {
                        s = rset.getString(i);
                        if (s == null) {
                            s = "";
                        }
                        out.println("<td align = 'center'>" + s + "</td>");
                    }

                
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException sqle) {
            System.err.println("Could not display table content : " + sqle);
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
