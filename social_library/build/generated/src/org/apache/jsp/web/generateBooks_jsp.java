package org.apache.jsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Project_Lib.RandomDataGenerator;
import DBPackage.basicLibrary;

public final class generateBooks_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function test() {\n");
      out.write("                //document.write(\"hello\");\n");
      out.write("                alert(\"hi\");\n");
      out.write("                var numofbooks = prompt(\"Enter number of books to be inserted\");\n");
      out.write("                if (numofbooks != null && numofbooks > 0) {\n");
      out.write("                    alert(\"going to insert books\");\n");
      out.write("                }\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <h1>Generate multiple random books and insert them</h1>\n");
      out.write("            <i>Only for debugging</i>\n");
      out.write("            <hr />\n");
      out.write("            <br />\n");
      out.write("            hello\n");
      out.write("\n");
      out.write("            ");
 basicLibrary[] books = RandomDataGenerator.generateBooks(100, 12);
               basicLibrary.insertMultipleBooks(books);
            
      out.write("\n");
      out.write("            books inserted\n");
      out.write("            <br />\n");
      out.write("            <a href=\"index.jsp\">Cancel</a>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
