package servletmusicproject3;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.RegisterBean;

import musicproject3.UserDb;

/**
 * Servlet implementation class Servletmusicproject3
 */
@WebServlet("/Servletmusicproject3")
public class Servletmusicproject3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletmusicproject3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String email =request.getParameter("email");
		
		RegisterBean rb = new RegisterBean(username, password, email);
		rb.setUsername(username);
		rb.setPassword(password);
		rb.setEmail(email);
		
		
		UserDb ud = new UserDb();
		String s1;
		String s2;
		
		try {
			s1 = ud.insertUser(rb);
			if(s1.equals("valid")) {	
				RegisterBean rb2 = new RegisterBean(username, password, email);
						s2=ud.addUser(rb2);
						if(s2.contentEquals("success")) {
						response.sendRedirect("http://localhost:8080/musicproject3/Signin.jsp");			
						}
				out.println("works");
			}
			if(s1.equals("account_already_exists")){				
				response.sendRedirect("http://localhost:8080/musicproject3/register.jsp");
				out.println("exists already");
			}
			else {
				out.println("error");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
