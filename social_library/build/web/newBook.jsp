<%-- 
    Document   : newBook
    Created on : 29 Oct, 2011, 12:49:20 PM
    Author     : aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert a New book</h1>
        <form action="newBook" id="newbook" method="POST">
            ACC. Number <input type ="text" size="20" name="accno" /><br />
            Title <input type ="text" size="30" name="title" /><br />
            Author <input type="text" size="30" name="author" /><br />
            Publication <input type="text" size="30" name="publication" /><br />
            Edition <input type="text" size="10" name="edition" /><br />
            Volume <input type="text" size="10" name="volume" /><br />
            Year <input type="text" size="10" name="year" /><br />
            Pages <input type="text" size="10" name="pages" /><br />
            Subject <input type="text" size="30" name="subject" /><br />
            DDC <input type="text" size="30" name="ddc" /><br />
            SEARS <input type="text" size="30" name="sears" /><br />
            <input type="submit" value="Submit" />
        </form>
        
        <a href="index.jsp">Cancel</a>
    </body>
</html>