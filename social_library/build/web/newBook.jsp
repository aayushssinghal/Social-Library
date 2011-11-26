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
    <body><div align="center">
        <h1>Insert a New book</h1>
        <form action="addnewbook" id="newbook" method="POST">
		<table>
<tr>
<td>ACC. Number: </td><td><input type ="text" size="30" name="accno" /><br /></td></tr>
<tr><td>   Title: </td><td><input type ="text" size="30" name="title" /><br /></td></tr>
    <tr><td>     Author: </td><td><input type="text" size="30" name="author" /><br /></td></tr>
        <tr><td>  Publication: </td><td><input type="text" size="30" name="publication" /><br /></td></tr>
      <tr><td>      Edition:</td><td> <input type="text" size="30" name="edition" /><br /></td></tr>
      <tr><td>      Volume: </td><td><input type="text" size="30" name="volume" /><br /></td></tr>
      <tr><td>      Year: </td><td><input type="text" size="30" name="year" /><br /></td></tr>
      <tr><td>      Pages: </td><td><input type="text" size="30" name="pages" /><br /></td></tr>
     <tr><td>       Subject: </td><td><input type="text" size="30" name="subject" /><br /></td></tr>
       <tr><td>     DDC: </td><td><input type="text" size="30" name="ddc" /><br /></td></tr>
      <tr><td>      SEARS: </td><td><input type="text" size="30" name="sears" /><br /></td></tr>
	  </table>
            <input type="submit" value="Submit" />
        </form>
        </br>
        <a href="index.jsp">Cancel</a>
		</div>
    </body>
</html>