<%@ page language="java" import="java.sql.*"
    pageEncoding="ISO-8859-1" %>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>harisarvo</h1>
</body>
</html>
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password1");
    Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/idea","root","hari");
Statement st=con.createStatement();

   
   
       int x=0;
   
    ResultSet rs=st.executeQuery("SELECT * FROM  student");
    while(rs.next())
    {
    if(rs.getString(1).equals(username))
    {
    if(rs.getString(2).equals(password))
    {
    x=1;
    break;
    }
   
    }
    }
    if(x==1)
    {
    response.sendRedirect("home.html");
    }
    else
    {
    response.sendRedirect("r_invalis username and password.jsp");
    }
   
    %>

