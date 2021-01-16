package login.idea_development.registration;

public interface InvestorDao {
	public int insertInvestor(investor i);
	public investor getInvestor(String username,String pass);
	}


