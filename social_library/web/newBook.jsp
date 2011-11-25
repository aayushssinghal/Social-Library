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
                <script type="text/javascript">

function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
   try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
   }
   catch (e) {
     try {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
     }
     catch (e2) {
       xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
     }
   }
   if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
     xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
   }
   return xmlHttp;  // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject();	//xmlhttp holds the ajax object

function submit(){
var url="addnewbook?accno="+document.addnewbook.accno.value+"&title="+document.addnewbook.title.value+"&author="+document.addnewbook.author.value+"&publication="+document.addnewbook.publication.value+"&edition="+document.addnewbook.edition.value+"&volume="+document.addnewbook.volume.value+"&year="+document.addnewbook.year.value+"&pages="+document.addnewbook.pages.value+"&subject="+document.addnewbook.subject.value+"&ddc="+document.addnewbook.ddc.value+"&sears="+document.addnewbook.sears.value;
 //alert(url);
 if(xmlhttp) {
        xmlhttp.open("POST",url,true);
        xmlhttp.onreadystatechange  = handleServerResponse;

    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send(null);
  }
    return false;
}

function handleServerResponse() {
   if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
     if (xmlhttp.responseText==""){}
        else{
            alert(xmlhttp.responseText);
        } //Update the HTML Form element
     }
     else {
        //alert("Error during AJAX call. Please try again");
     }
   }
}

function handleEnter (event) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyCode == 13) {
                submit();

			return false;
		}
		else
		return true;
	}

</script>
    </head>
    <body><div align="center">
        <h1>Insert a New book</h1>
        <form action="addnewbook" id="addnewbook" name="addnewbook">
		<table>
<tr>
<td>ACC. Number: </td><td><input type ="text" size="30" name="accno" id="accno"/><br /></td></tr>
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
                    </form>
            <input type="button"  onClick="javascript:submit();return false;" value="Submit" />

        </ br>
        <a href="index.jsp">Cancel</a>
		</div>
    </body>
</html>