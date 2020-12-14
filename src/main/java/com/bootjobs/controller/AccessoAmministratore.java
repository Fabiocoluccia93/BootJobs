package com.bootjobs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Amministratore;
import com.bootjobs.model.AmministratoreService;

/**
 * Servlet implementation class AccessoAmministratore
 */
public class AccessoAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessoAmministratore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher r =null;
			r=request.getRequestDispatcher("view/accessoAmministratore.jsp");
			r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher r=null;
		String param = request.getParameter("param");
		

		if(param.equals("1")) {
			
			AmministratoreService as = new AmministratoreService();
			Amministratore a = null;
			
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			
			a=as.accessoAmministratore(user, password);
			if(a!=null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("Amministratore", a);				
				r=request.getRequestDispatcher("view/homePageAmministratore.jsp");
			}
			else {
				
				r=request.getRequestDispatcher("view/accessoAmministratore.jsp");
				request.setAttribute("accessoNegatoAmministratore", "errore username o password. riprova!");
				
			}
			
			
		}		
	r.forward(request, response);
		
	}

}
