<%--
    Document   : newBook
    Created on : 29 Oct, 2011, 12:49:20 PM
    Author     : dhiraj
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
if(document.issuebook.accno.value=="" || document.issuebook.ID.value==""){alert("enter proper values"); return false;}
var url="issuebook?accno="+document.issuebook.accno.value+"&id="+document.issuebook.ID.value;
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
                //submit();

			return false;
		}
		else
		return true;
	}

</script>
    </head>
    <body><div align="center">
        <h1>Issue book</h1>
        <form name="issuebook" id="issuebook">
		<table>
<tr>
<td>Acc. No. of book: </td><td><input type ="text" size="30" name="accno" id="accno" onkeypress="return handleEnter(event, 'accno')"/></td></tr>
<tr>
<td>ID of the person: </td><td><input type ="text" size="30" name="ID" id="ID" onkeypress="return handleEnter(event, 'accno')"/></td></tr>

                </table>
            </form>
        <input type="button"  onClick="javascript:submit();return false;" value="Submit" id="Submit" />

        </br>
        <a href="index.jsp">Cancel</a>
		</div>
    </body>




</html>