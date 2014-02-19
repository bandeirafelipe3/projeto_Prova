package de.vogella.wtp.filecounter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.vogella.wtp.filecounter.dao.FileDao;

/**
 * Servlet implementation class FileCounter
 */
@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int count;
	private FileDao dao;
	
	public void init() throws ServletException {
		dao = new FileDao();
		try{
			count = dao.getCount();
		}catch(Exception e){
			getServletContext().log("An exception occured in FileCounter", e);
			throw new ServletException("An exception occured in FileCounter" + e.getMessage());
		}
	}

    /**
     * Default constructor. 
     */
    public FileCounter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		if(session.isNew()){
			count++;
		}
		out.println("This site has been accessed" + count + "time.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		if(session.isNew()){
			count++;
		}
		out.println("This site has been accessed" + count + "time.");
		**/
	}
	
	public void destroy(){
		super.destroy();
		try{
			dao.save(count);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
