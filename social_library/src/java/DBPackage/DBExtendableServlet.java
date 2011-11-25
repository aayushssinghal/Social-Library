/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBPackage;

import java.sql.*;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author aayush
 */
public class DBExtendableServlet extends HttpServlet {
    
    public static Connection conn;
    public static ResultSet rset = null;
    public static PreparedStatement stmt;
    
    
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
