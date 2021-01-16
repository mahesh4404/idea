
package login.idea_development.registration;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public LoginRegister() {
        super();
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

InvestorDao d=new InvestorDaoImpl();


String userName=request.getParameter("username");
String password=request.getParameter("password1");
String submittype=request.getParameter("submit");
investor d1=d.getInvestor(userName,password);
if(submittype.equals("login"))
{
request.getRequestDispatcher("r_loginverify.jsp").forward(request, response);


}
else if(submittype.equals("register"))
{
d1.setName(request.getParameter("name"));
d1.setPassword(password);
d1.setUsername(userName);
d.insertInvestor(d1);
request.setAttribute("sumessege","register r_success");
request.getRequestDispatcher("loginpage.jsp").forward(request, response);

}
else
{
request.setAttribute("messege","r_please register");
request.getRequestDispatcher("loginpage.jsp").forward(request, response);
}









}



}

