<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>CAP COMPETENCY</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style>  
     <%@ include file="../css/style.css"%>  
</style>  
<script>
 
 	// get list of mentees from mentor id
	function call(id) {
		$("#"+id).slideToggle("slow");
		 if (!$("#"+id).length){
			var elements = $();
		   $("."+id).append('<div id="'+id+'">');
		var urls ="/mvcchart/getMentee/"+id;
		 $.ajax({
			 url:urls,
			 success:function(data){
				 for (var i in data) {
					// $("#id").append(data[i]);
					 elements = elements.add('<li class="mentee"> <a href="#" onclick="getMenteeSkills('+"'"+data[i]+"'"+')">'+data[i]+'</a></li>');
					}
				 elements = elements.add('<p></p><ul><h5><a href="#" onclick="getAllMenteeSkills('+"'"+id+"','"+data[i]+"'"+')">get all mentees</a></h5><ul>');
				 elements = elements.add('</div>');
				   $("#"+id).append(elements);
	
			  }});
		 }
	}
	
 	//get skill details 
 	function getMenteeSkills(name) {
		 if ($("#employeeDetails").length){
		 	$("#details").remove();
		 }
 		var $div = $('<div id="details"/>');
 		var $table = $('<table id="'+name+'"><th colspan="2">Skill Details for '+name+'</th>');
 		
 		$("#employeeDetails").append($div);	
 		$("#details").append($table);
 			 $.ajax({
			 url:"/mvcchart/getMenteeSkillSets/"+name,
			 success:function(data){
				 for (var i in data.forms) {
					$('#'+name).append('<tr><td>'+data.forms[i].skill+'</td><td>'+data.forms[i].skillRating+'</td></tr>');
					
					 }
			  }});
 			  
		 }
 	//get skill detaiuls for all employees under a mentor
 	function getAllMenteeSkills(name,nameID) {
	 if ($("#employeeDetails").length){
		 	$("#details").remove();
		 }
		var $div = $('<div id="details"/>');
		//var $table = $('<table id="'+nameID+'"><th colspan="2">Associate  Details for Mentor'+nameID+'</th>');
		var $table = $('<table id="'+nameID+'">');
		$("#employeeDetails").append($div);	
		$("#details").append($table);
		 $('#'+nameID).append("<td><tr>apple</tr></td>");
			 $.ajax({
			 url:"/mvcchart/getAllMenteeSkillSets/"+name,
			 success:function(data){
				 var obj = data.employeeSkill;
				
				 var obj2 = data.skillName;
				 $('#'+nameID).append('<th><td>'+"Skill Names"+'</td>');
				 for(var key in obj) {
					 $('#'+nameID).append("<td>"+key+"</td>");
					 
				 }
				 $('#'+nameID).append("</th>");
				 for (var key in obj2) {				
					 		$('#'+nameID).append('<tr><td>'+(parseInt(key) + parseInt(1))+'</td><td>'+obj2[key]+'</td></tr>');
				 }
					 	
				 for(var key in obj) {
				   	var a = obj[key];
					 $('#'+nameID).find('tr').each(function(j){
						var i = $("tr", $("td:first")).length;
					
				        $(this).find('td').eq(1).after('<td>'+a[j]+'</td>');
			 		 });
				   
				  }
				 
			
				
				   }});
			 }
	
</script>
</head>
<body>
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
  <p>The competency tracker is an idea innovation to manage the skills and their progress of each associate within the CAP Team. This tracker will help to keep the progress measures of an idvidual.</p>
  <p>This is a Spring-Mvc application as a test demo to achieve our competency tracker</p>
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
<p></p>
  <h2>MENTORS</h2>
  <div id="col2">
  <p><c:if test="${not empty mentors}">
		<ul>
			<c:forEach var="listValue" items="${mentors}">
			<h4><li class='${listValue.employeeId}'><a href="#" onclick="call('${listValue.employeeId}')">${listValue.employeeFirstName}</a></li> </h4>
			</c:forEach>
			
		</ul>
	</c:if>
	</p>
  <p></p>


</div>
<div id="col3">
 <c:if test="${not empty skillDetails}">
		<ul>
			<c:forEach var="listValue" items="${skillDetails}">
				<li>${listValue.employeeId}</li>			
			</c:forEach>
			
		</ul>
	</c:if>
</div>
<div id="employeeDetails"></div>


</div>
<!-- End of column1 -->
<!-- Beginning  of Div3 -->
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
  <div class='box'>
    <div class='boxtop'>
      <div></div>
    </div>
    <div class='boxcontent'>
      <h3>Line CHARTS</h3>
      <p><a href="#"><img src="../images/articles.png" alt="articles" title="articles" /></a></p>
     </div>
    <div class='boxbottom'>
      <div></div>
    </div>
     </div>
   <form action="/mvcchart/getCharts/lineCharts" method="get">
  <p><a href="#" onclick="$(this).closest('form').submit()">Click to redirect to pie charts</a></p>
  </form>
  
  <p>&nbsp;</p>
 </div>
<div id="footer"> <a href="#">homepage</a> | <a href="#">contact</a> | <a href="http://validator.w3.org/check?uri=referer">html</a> | <a href="http://jigsaw.w3.org/css-validator">css</a> | &copy; 2007 Anyone | Design by <a href="http://www.mitchinson.net"> www.mitchinson.net</a> | This work is licensed under a <a rel="license nofollow" target="_blank" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 License</a> </div>
</body>
</html>
