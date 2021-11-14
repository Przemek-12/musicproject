<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="mainpageservlet.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Music shop</title>
</head>
<h1>Main Page</h1>
<link rel ="stylesheet"  type="text/css" href="style.css">
<body>
<%

		String userSession = (String)session.getAttribute("username"); 

%>


		<h1> User: <% out.println(userSession); %> </h1>
		<a href = "logout.jsp">logout</a>																													


		<form action="MainPage.jsp">
		
		
		<%
		MainPage data = new MainPage(); 			
		
		String artist=request.getParameter("artist");
		String title=request.getParameter("title");
		String year=request.getParameter("year");
		String idalbums = request.getParameter("idalbums");
		String action=request.getParameter("action");
		
		MainGetAndSet getData = new MainGetAndSet();
		
		if("create".equals(action)){
		MainGetAndSet addData = new MainGetAndSet(artist,title,year);
		data.insertIntoDatabase(addData);
		}
		
		else if("delete".equals(action)){
			int id = Integer.parseInt(idalbums);
			data.DeleteFromDatabase(id);
		}
		
		
		else if("update".equals(action)){
			int id = Integer.parseInt(idalbums);			
			getData = data.updateData(id);	//polimorfizm jeden obiekt rowna sie drugi i ma dostep do metod z jego klasy					
		}
		
		else if("change".equals(action)){
			int idin = Integer.parseInt(idalbums);
			MainGetAndSet addData2 = new MainGetAndSet(artist,title,year);
			data.changeData(idin, addData2);
			
		}
		
		List<MainGetAndSet> albumdatabase = data.dispDataBase();
		%>
		
		<input type="hidden" name="idalbums" value=<%=getData.getIdalbums() %>>
		
		<table cellspacing="1" border="1" width ="1000" align="center" class="table">
		
		<tr>
		<td ><input type="text"  name="artist" class="form-control" placeholder="Enter artist" value=<%=getData.getArtist() %>></td>   
		<td ><input type="text" name="title" class="form-control" placeholder="Enter title" value=<%=getData.getTitle() %>></td>  
		<td ><input type="text" name="year" class="form-control" placeholder="Enter year" value=<%=getData.getYear() %>></td>
		<td><button type="submit" class="btn btn-xs btn-Success"  name="action" value="create" >Add</button></td>
		<td><button type="submit" class="btn btn-xs btn-Success"  name="action" value="change" >Update</button></td>
		</tr>
		
		</table>
		
		
		<table border="1" align = "center" bgcolor = "white" bordercolor="red">
		<caption>Data base content</caption>
			<tr><th><h3>id</h3></th>    <th><h3>Artist</h3></th>    <th><h3>Title</h3></th>    <th><h3>Year</h3></th></tr>
		<% 
		//for each loop
		for(MainGetAndSet addData:albumdatabase){
		%>
			<tr>
			<td><%=addData.getIdalbums() %></td>    <td><%=addData.getArtist() %></td>    <td><%=addData.getTitle() %></td>    <td><%=addData.getYear() %></td>
			<td><a class = "btn btn-sm btn-Danger" type="button" href="MainPage.jsp?action=delete&idalbums=<%= addData.getIdalbums() %>">delete</a></td>
			
			<td><a class="btn btn-Primary" type="button" href="MainPage.jsp?action=update&idalbums=<%= addData.getIdalbums()%>">update</a></td>
			</tr>
		<% 
		}
		%>
		</table>
		</form>









																														<ul>
																														<%	
																														for(int i=0;i<10;i++){%>
																															<li> <%= i  %></li>
																														<% 
																														}
																														%>
																														</ul>
</body>
</html>