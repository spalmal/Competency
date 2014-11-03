<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CAP COMPETENCY</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<style>  
     <%@ include file="../css/style.css"%>  
</style>  
<div id="header">
  <ul id="menu">
    <li><a href="#">Home</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">Resources</a></li>
    <li><a href="#">Gallery</a></li>
    <li><a href="#">Archives</a></li>
    <li><a href="#">Contact</a></li>
  </ul>
  <h1><span style="color: #CCCC9A;"> EMC Consulting</span> Cap Team</h1>
</div>
<div id="gutter"></div>
<div id="col1">
  <h2>Welcome to <span style="font-weight:bold; color:#333;">Competency Tracker</span></h2>
  <p>The compency tracker is an idea innovation to manage the skills and their progress of each associate within the CAP Team. This tracker will help to keep the progress measures of an idvidual.</p>
  <p>This is a Spring-Mvc application as a test demo to achieve our competency tracker</p>
  <form  onsubmit="this.action = '/mvcchart/search/' + this.name.value"   method="get">
 <span> Enter Associate Name : </span><input type="text" id="name"></input>
 <input type="submit" value="Get Pie Charts"></input>
 </form>
<c:if test="${not empty skills}">
		 <img alt="Google Pie Chart" src=${chart1} />
	</c:if>
  
  <div class='box'>
    <div class='boxtop'>
      <div></div>
    </div>
    <div class='boxcontent'>
      <blockquote>This page has been tested in Mozilla and IE7. The page validates as XHTML 1.0 Transitional using valid CSS. For more FREE CSS templates visit <a href="http://www.mitchinson.net" title="my website">my website</a>.</blockquote>
    </div>
    <div class='boxbottom'>
      <div></div>
    </div>
  </div>
  <p>Corner images from <a href="http://wigflip.com/cornershop/">Cornershop</a></p>
  <h2>MENTORS</h2>
  <p><c:if test="${not empty mentors}">
		<ul>
			<c:forEach var="listValue" items="${mentors}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
	</c:if>
	</p>
  <p></p>
</div>
<div id="col3">
  <div class='box'>
    <div class='boxtop'>
      <div></div>
    </div>
    <div class='boxcontent'>
      <h3>Bar Plots</h3>
      <p><a href="#"><img src="../images/articles.png" alt="articles" title="articles" /></a></p>
     </div>
    <div class='boxbottom'>
     <div></div>
   </div>
  </div>
  <form action="/mvcchart/getCharts/barCharts" method="get">
  <p><a href="#" onclick="$(this).closest('form').submit()">Click to redirect to bar charts</a></p>
  </form>
  <div class='box'>
    <div class='boxtop'>
      <div></div>
    </div>
    <div class='boxcontent'>
      <h3>PIE CHARTS</h3>
      <p><a href="#"><img src="../images/articles.png" alt="articles" title="articles" /></a></p>
     </div>
    <div class='boxbottom'>
      <div></div>
    </div>
     </div>
   <form action="/mvcchart/getCharts/pieCharts" method="get">
  <p><a href="#" onclick="$(this).closest('form').submit()">Click to redirect to pie charts</a></p>
  </form>
  
  <p>&nbsp;</p>
</div>
<div id="footer"> <a href="#">homepage</a> | <a href="#">contact</a> | <a href="http://validator.w3.org/check?uri=referer">html</a> | <a href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a> | This work is licensed under a <a rel="license nofollow" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a> </div>
</body>
</html>
