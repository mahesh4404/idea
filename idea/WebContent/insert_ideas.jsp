<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String first_name=request.getParameter("idea");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/idea", "root", "hari");
Statement st=conn.createStatement();
int i=st.executeUpdate("insert into s_idea values('"+first_name+"')");

out.println("Thankyou for Submitting your Idea!!!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>