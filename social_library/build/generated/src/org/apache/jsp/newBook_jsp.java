package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body><div align=\"center\">\r\n");
      out.write("        <h1>Insert a New book</h1>\r\n");
      out.write("        <form action=\"newBook\" id=\"addnewbook\" method=\"POST\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>ACC. Number: </td><td><input type =\"text\" size=\"30\" name=\"accno\" /><br /></td></tr>\r\n");
      out.write("<tr><td>   Title: </td><td><input type =\"text\" size=\"30\" name=\"title\" /><br /></td></tr>\r\n");
      out.write("    <tr><td>     Author: </td><td><input type=\"text\" size=\"30\" name=\"author\" /><br /></td></tr>\r\n");
      out.write("        <tr><td>  Publication: </td><td><input type=\"text\" size=\"30\" name=\"publication\" /><br /></td></tr>\r\n");
      out.write("      <tr><td>      Edition:</td><td> <input type=\"text\" size=\"30\" name=\"edition\" /><br /></td></tr>\r\n");
      out.write("      <tr><td>      Volume: </td><td><input type=\"text\" size=\"30\" name=\"volume\" /><br /></td></tr>\r\n");
      out.write("      <tr><td>      Year: </td><td><input type=\"text\" size=\"30\" name=\"year\" /><br /></td></tr>\r\n");
      out.write("      <tr><td>      Pages: </td><td><input type=\"text\" size=\"30\" name=\"pages\" /><br /></td></tr>\r\n");
      out.write("     <tr><td>       Subject: </td><td><input type=\"text\" size=\"30\" name=\"subject\" /><br /></td></tr>\r\n");
      out.write("       <tr><td>     DDC: </td><td><input type=\"text\" size=\"30\" name=\"ddc\" /><br /></td></tr>\r\n");
      out.write("      <tr><td>      SEARS: </td><td><input type=\"text\" size=\"30\" name=\"sears\" /><br /></td></tr>\r\n");
      out.write("\t  </table>\r\n");
      out.write("            <input type=\"submit\" value=\"Submit\" />\r\n");
      out.write("        </form>\r\n");
      out.write("        </br>\r\n");
      out.write("        <a href=\"index.jsp\">Cancel</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
