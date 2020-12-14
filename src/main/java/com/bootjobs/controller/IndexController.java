package com.bootjobs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Societa;
import com.bootjobs.model.SocietaService;

/**
 * Servlet implementation class IndexController
 */
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher r = null;
		String param = request.getParameter("param");
		
		if(param.equals("1")) {
			r=request.getRequestDispatcher("view/accessoSocieta.jsp");
		}
		
		else if(param.equals("2")) {
			r=request.getRequestDispatcher("view/creazioneSocieta.jsp");
		}
		
		else if(param.equals("3")) {
			r=request.getRequestDispatcher("index.jsp");
		} 
		
		else if(param.equals("4")) {
			
			HttpSession session = request.getSession(false);
			
			if(session != null)
			session.invalidate();
			
			r=request.getRequestDispatcher("index.jsp");
			
		}
		
		r.forward(request, response);
	}
}
	
