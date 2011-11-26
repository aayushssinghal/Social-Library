<%-- 
    Document   : generateBooks
    Created on : Nov 25, 2011, 5:01:44 PM
    Author     : aayush
--%>

<%@page import="Project_Lib.RandomDataGenerator"%>
<%@page import="DBPackage.basicLibrary"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function test() {
                //document.write("hello");
                alert("hi");
                var numofbooks = prompt("Enter number of books to be inserted");
                if (numofbooks != null && numofbooks > 0) {
                    alert("going to insert books");
                }
            
            }
        </script>
    </head>
    
    <body>
        <div align="center">
            <h1>Generate multiple random books and insert them</h1>
            <i>Only for debugging</i>
            <hr />
            <br />
            hello

            <% basicLibrary[] books = RandomDataGenerator.generateBooks(100, 12);
               basicLibrary.insertMultipleBooks(books);
            %>
            books inserted
            <br />
            <a href="index.jsp">Cancel</a>
        </div>
    </body>
</html>
