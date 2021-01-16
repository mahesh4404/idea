package login.idea_development.registration;
import java.sql.*;
public class InvestorDaoImpl implements InvestorDao {
	
	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertInvestor(investor i) {
	int status=0;
	try {
	con=MyConnectionProvider.getCon();
	ps=con.prepareStatement("insert into investor values(?,?,?)");
	ps.setString(1, i.getUsername());
	ps.setString(2, i.getPassword());
	ps.setString(3, i.getName());

	status=ps.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}

	return status;
	}

	public investor getInvestor(String userid, String pass) {
	investor i=new investor();
	int j=0;
	try
	{
	con=MyConnectionProvider.getCon();
	ps=con.prepareStatement("select * from investor where username=? and password=?");
	ps.setString(1, userid);
	ps.setString(2, pass);
	ResultSet rs=ps.executeQuery();
	System.out.println(rs);
	while(rs.next())
	{
	i.setUsername(rs.getString(1));
	i.setPassword(rs.getString(2));
	i.setName(rs.getString(3));

	}

	}
	catch(Exception e)
	{

	}
	return i;
	}

	



}
