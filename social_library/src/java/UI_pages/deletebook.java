package UI_pages;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBPackage.basicLibrary;

/**
 *
 * @author aayush
 */
public class deletebook extends HttpServlet {

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
        basicLibrary insert=new basicLibrary();
        if(request.getParameter("accno")!="")insert.acc=Integer.parseInt(request.getParameter("accno"));
        try {
            /* TODO output your page here */
            //out.println("<html>");
            //out.println("<head>");
            //out.println("<title>deletebook Servlet deletebook</title>");
            //out.println("</head>");
            //out.println("<body>");
            //out.println(insert.acc);
            try{
                System.out.println("deleting book");///////////////////should check for spaces or empty
                int i=insert.deleteBook(insert.acc);//out.println("here");
                if (i==0){out.println("Could not delete the book");}
                else out.println("Servlet deletebook at " + request.getContextPath ());
            }
            catch(Exception sql){
                out.println("error at delete "+sql);
            }
            //out.println("</body>");
            //out.println("</html>");
             /**/
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
