package mainpageservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
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
		
		//String artist = request.getParameter("artist");
		//String title = request.getParameter("title");
		//String year = request.getParameter("year");
		
		//MainGetAndSet insert = new MainGetAndSet(artist, title, year);
		//insert.setArtist(artist);
		//insert.setTitle(title);
		//insert.setYear(year);
		
		//MainPage mp = null;
		//try {
		//	mp = new MainPage();
		//} catch (Exception e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
	
		
		
		//try {
		//	mp.insertIntoDatabase(insert);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	
	}

}
