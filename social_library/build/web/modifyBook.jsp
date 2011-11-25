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

function getbookinfo(formid){
if(document.modifybook.accno.value==""){
alert("enter book name");
return;}
else{
    if(xmlhttp){
        //courseid=document.getElementById(formid).value;
        xmlhttp.open("POST","modifybook?accno="+document.modifybook.accno.value,true); //YUIDemo will be the servlet name
        xmlhttp.onreadystatechange  = handlebookinfo;
        xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlhttp.send();
    }
}
}


function handlebookinfo(){
 try{
    if (xmlhttp.readyState == 4) {
     if(xmlhttp.status == 200) {
        xmlDoc=xmlhttp.responseXML;
        //xmlDoc.save("response.xml");
        var y=xmlhttp.responseXML.getElementsByTagName("error");
        
        if(y[0].childNodes[0].nodeValue=="noerror"){
            for(i=1;i<=10; i++){
                y=document.getElementById(i);
                y.setAttribute('style', 'display: block');
            }
            document.getElementById("font").innerHTML = "Old Acc. No. ";
            document.getElementById("font1").innerHTML = document.modifybook.accno.value;
            document.getElementById("0").innerHTML = "New Acc. No. of book: ";
            z=xmlhttp.responseXML.getElementsByTagName("title");
            y=document.getElementById("title");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("author");
            y=document.getElementById("author");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("publication");
            y=document.getElementById("publication");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("edition");
            y=document.getElementById("edition");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("volume");
            y=document.getElementById("volume");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("year");
            y=document.getElementById("year");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("pages");
            y=document.getElementById("pages");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("subject");
            y=document.getElementById("subject");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            var z=xmlhttp.responseXML.getElementsByTagName("ddc");
            y=document.getElementById("ddc");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value', z[0].childNodes[0].nodeValue);
            z=xmlhttp.responseXML.getElementsByTagName("sears");
            y=document.getElementById("sears");
            y.setAttribute('style', 'display: block');
            y.setAttribute('value',z[0].childNodes[0].nodeValue);
            document.getElementById("button").setAttribute('style', 'display: block');
            }
        }
        else{
            html="Invalid course-id";
        }
     }
     else {
        //alert("Error during AJAX call. Please try again");
     }
   }
 catch(e){alert("hih"+e.description);
}
}

function submit(){
var url="modifybook?oldaccno="+document.getElementById("font1").innerHTML+"&newaccno="+document.modifybook.accno.value+"&title="+document.modifybook.title.value+"&author="+document.modifybook.author.value+"&publication="+document.modifybook.publication.value+"&edition="+document.modifybook.edition.value+"&volume="+document.modifybook.volume.value+"&year="+document.modifybook.year.value+"&pages="+document.modifybook.pages.value+"&subject="+document.modifybook.subject.value+"&ddc="+document.modifybook.ddc.value+"&sears="+document.modifybook.sears.value;
 alert(url);
 if(xmlhttp) {
        xmlhttp.open("GET",url,true);
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
        <h1 id="h1">Modify book</h1>
        <font id="font"></font><font id="font1"></font>
        <form action="modifybook" id="modifybook" name="modifybook">
		<table>
<tr>
<td id="0">Acc. No. of book: </td><td><input type ="text" size="30" name="accno" id="accno" onblur="getbookinfo()" value=""/></td></tr>
<tr><td id="1" style="display: none">   Title: </td><td><input type ="text" size="30" name="title" id="title" style="display: none" value=""/></td></tr>
    <tr><td id="2" style="display: none">     Author: </td><td><input type="text" size="30" name="author" id="author" value="" style="display: none"/></td></tr>
        <tr><td id="3" style="display: none">  Publication: </td><td><input type="text" size="30" name="publication" id="publication" value="" style="display: none"/></td></tr>
      <tr><td id="4" style="display: none">      Edition:</td><td> <input type="text" size="30" name="edition" id="edition" value="" style="display: none"/></td></tr>
      <tr><td id="5" style="display: none">      Volume: </td><td><input type="text" size="30" name="volume" id="volume" value="" style="display: none"/></td></tr>
      <tr><td id="6" style="display: none">      Year: </td><td><input type="text" size="30" name="year" id="year" value="" style="display: none"/></td></tr>
      <tr><td id="7" style="display: none">      Pages: </td><td><input type="text" size="30" name="pages" id="pages" value="" style="display: none"/></td></tr>
     <tr><td id="8" style="display: none">       Subject: </td><td><input type="text" size="30" name="subject" id="subject" value="" style="display: none"/></td></tr>
       <tr><td id="9" style="display: none">     DDC: </td><td><input type="text" size="30" name="ddc" id="ddc" value="" style="display: none"/></td></tr>
      <tr><td id="10" style="display: none">      SEARS: </td><td><input type="text" size="30" name="sears" id="sears" value="" style="display: none"/></td></tr>
	  </table>
                    </form>
            <input id="button" type="button"  onClick="javascript:submit();return false;" value="Submit" style="display: none"/>

        </ br>
        <a href="index.jsp">Cancel</a>
		</div>
    </body>
</html>