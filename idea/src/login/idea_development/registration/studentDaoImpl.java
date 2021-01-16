package login.idea_development.registration;
import java.sql.*;


public class studentDaoImpl implements studentDao{
	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertStudent(student s) {
	int status=0;
	try {
	con=MyConnectionProvider.getCon();
	ps=con.prepareStatement("insert into student values(?,?,?)");
	ps.setString(1, s.getUsername());
	ps.setString(2, s.getPassword());
	ps.setString(3, s.getName());

	status=ps.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}

	return status;
	}

	public student getStudent(String userid, String pass) {
	student s=new student();
	int j=0;
	try
	{
	con=MyConnectionProvider.getCon();
	ps=con.prepareStatement("select * from student where username=? and password=?");
	ps.setString(1, userid);
	ps.setString(2, pass);
	ResultSet rs=ps.executeQuery();
	System.out.println(rs);
	while(rs.next())
	{
	s.setUsername(rs.getString(1));
	s.setPassword(rs.getString(2));
	s.setName(rs.getString(3));

	}

	}
	catch(Exception e)
	{

	}
	return s;
	}

	






}
