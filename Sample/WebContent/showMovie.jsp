<%@ page language="java" import= " com.bean.* , java.util.* , java.sql.* " contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
</head>
<body>

<%-- <form method="post">

<table border="0" cellspacing="9" cellpadding="15" >
<tr>
<td><b>Movie Name</b></td>
<td><b>Actor</b></td>
<td><b>Languages</b></td>
<td><b>Rating</b></td>
<td><b>Ticket Price</b></td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/organisation";
String username="root";
String password = "root";
String query = "select * from movie_details";
Connection conn = DriverManager.getConnection(url,username,password);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);


while(rs.next())
{

%>
	
    <tr>
    <td><%= rs.getString("moviename") %></td>
    <td><%= rs.getString("actor") %></td>
    <td><%= rs.getString("language") %></td>
    <td><%= rs.getString("rating") %></td>
    <td><%= rs.getString("ticketprice") %></td></tr>
    
     <%

}
%>
    </table>
    <h1></h1>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }

catch(Exception e)
{
    e.printStackTrace();
  }

%>

</form>
</body>
</html> --%>


<form method="post">

<table border ="5" cellspacing="5" cellpadding="5">

<%
List<MovieDetails> movieList = ( List<MovieDetails> ) request.getAttribute("movieList");

out.println("<tr> <th> <h2> MovieName </h2> </th> <th> <h2> Actor </h2> </th> <th> <h2> Languages </h2> </th> <th> <h2> Ratings </h2> </th> <th> <h2> Price </h2> </th> </tr> <h2>");


for(MovieDetails movies : movieList){
	out.println("<tr><td>"+movies.getMoviename()+"</td>"+
					"<td>"+movies.getActor()+"</td>"+
					"<td>"+movies.getLanguages()+"</td>"+
					"<td>"+movies.getRating()+"</td>"+
					"<td>"+movies.getPrice()+"</td></tr>");
}

%>
</table>
</form>

</body>
</html> 