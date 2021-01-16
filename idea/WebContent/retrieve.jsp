<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("idea");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "idea";
String userid = "root";
String password = "hari";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body style="background-color:#6AFB92;" align="center">


<tr>
<marquee direction="right" scrollamount="10" behavior="slide">
 <h1>
<p align="center">Idea Submitted By Students </p><br>
</h1>
</marquee>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from s_idea";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
  <h3>
<p align="center"><%=resultSet.getString("idea") %></p></br></h3>



</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
