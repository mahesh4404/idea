package login.idea_development.registration;

public interface studentDao {
	public int insertStudent(student s);
	public student getStudent(String username,String pass);
	}


