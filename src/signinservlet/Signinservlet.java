package signinservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.RegisterBean;

import musicproject3.UserDb;
import signinbean.SigninBean;

/**
 * Servlet implementation class Signinservlet
 */
@WebServlet("/Signinservlet")
public class Signinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signinservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		SigninBean sign = new SigninBean(username, password);
		
		sign.setUsername(username);
		sign.setPassword(password);
		
		UserDb user = new UserDb();
		String s1 = null;
		try {
			s1 = user.readData(sign);
			if(s1.equalsIgnoreCase("valid")) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				
				response.sendRedirect("http://localhost:8080/musicproject3/MainPage.jsp");
			}
			else {
				response.sendRedirect("http://localhost:8080/musicproject3/Signin.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
