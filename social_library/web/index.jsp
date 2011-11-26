<%-- 
    Document   : index
    Created on : 28 Oct, 2011, 4:13:29 PM
    Author     : aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>library!</h1>
        <a href="newBook.jsp">new book in library</a><br/>
        <a href="issueBook.jsp">issue a book</a><br/>
        <a href="returnBook.jsp">return a book</a><br/>
        <a href="search">search book</a><br/>
    </body>
</html>-->

<head>
<title>Social Library IIT Bombay - Home</title>
<link rel="stylesheet" href="home.css" type="text/css"/>
<script language="JavaScript" type="text/javascript">
    <!--
    function MM_reloadPage(init) {  //reloads the window if Nav4 resized
      if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
        document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
      else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
    }
    MM_reloadPage(true);
    //-->
  </script>
</head>
<body class="body">
      <div id="fb-root"></div>
      <script>
        window.fbAsyncInit = function() {
          FB.init({
            appId      : 'YOUR_APP_ID',
            status     : true, 
            cookie     : true,
            xfbml      : true
          });

          FB.api('/me', function(user) {
            if (user) {
              var image = document.getElementById('image');
              image.src = 'http://graph.facebook.com/' + user.id + '/picture';
              var name = document.getElementById('name');
              name.innerHTML = user.name
            }
          });
        };

        (function(d){
           var js, id = 'facebook-jssdk'; if (d.getElementById(id)) {return;}
           js = d.createElement('script'); js.id = id; js.async = true;
           js.src = "//connect.facebook.net/en_US/all.js";
           d.getElementsByTagName('head')[0].appendChild(js);
         }(document));
      </script>
<center>
    <span class ="header1"> <h1> Welcome to Social Library of IIT Bombay </h1> </span>
<div class="topmaincol">
		<div class="divpath">
			<div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway">Home </span>
                        </div>
                    <div style="float:left;font-size: 18px;"> &nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway">Login with Ldap </span>                               
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:2px;">
				<div id="login" class="fb-login-button" data-perms="email, offline_access">Login with Facebook</div>                              
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway"><a href="newBook.jsp">Add new book</a> </span>                              
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway"><a href="deleteBook.jsp">Delete book</a> </span>
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway"><a href="modifyBook.jsp">Modify book</a> </span>
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway"><a href="issueBook.jsp">Issue book</a> </span>
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp;</div>
                        <div style="float:left;height:50px;padding-top:5px;">
				<span class="pathway"><a href="returnBook.jsp">Return book</a> </span>
			</div>
                    <div style="float:left;font-size: 18px">&nbsp;&nbsp;|&nbsp;&nbsp</div>
                    <div style="float:right;height:50px;padding-top:5px;">
				<a href="http://www.iitb.ac.in"> <span class="pathway">IIT Bombay Home </span> </a>                              
			</div>
		</div>
</div> <fb:like href="http://www.cse.iitb.ac.in/~gauravchauhan/cse" send="true" width="450" show_faces="true"></fb:like>
<div id="logo">
	<div id="logged" align="left">
        <img id="image"/>
        <div id="name"></div>
      </div>	
</div>
   
	 
HELLO    	
<script type="text/javascript"  src="jquery.js"></script>
   
</center>

  <p>I would like to say: </p>
<script>
  $("p").append("<strong>Hello</strong>");
</script>

<script>
    $.getJSON('test.php', function(data) {

    // Inside your success callback:

    $("#variable1").html(data.variable1);
    $("#variable2").html(data.variable2);

});
    
    
</script>
<script>
   $("h1").append("hello");
   
   
   $.get("test.php",function(data){
     $("p").append( "Name: " + data.name ).append( "Time: " + data.time );
   }, "json");
   
   </script>
   
HELLO 2
 <fb:comments href="http://www.cse.iitb.ac.in/~gauravchauhan/cse" num_posts="" width="500"></fb:comments>
 </body>
</html><!-- 1321180682 -->