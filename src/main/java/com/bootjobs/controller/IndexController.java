package com.bootjobs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.SocietaService;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
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
		
		String param = request.getParameter("param");
		SocietaService ss = new SocietaService();
		HttpSession session = request.getSession();
		
		if(param.equals("1")) {
			RequestDispatcher r = null;
			r=request.getRequestDispatcher("view/accessoSocieta.jsp");
			r.forward(request, response);
		}
		
		
		
		if(param.equals("2")) {
			
			session.removeAttribute("campiVuoti");
			
			session.removeAttribute("partitaIvaErrata");
			
			session.removeAttribute("societaEsistente");
			
			ArrayList<Territorio> tbregioni = ss.dropDownRegioni();						
			
			session.setAttribute("listaRegioni", tbregioni);

			response.sendRedirect("view/creazioneSocieta.jsp");
			
		}
		
		
		
		if(param.equals("3")) {
			RequestDispatcher r = null;
			r=request.getRequestDispatcher("index.jsp");
			r.forward(request, response);
		} 
		
		
		if(param.equals("4")) {
			RequestDispatcher r = null;
			
			session = request.getSession(false);
			
			if(session != null) {
			session.invalidate();
			}
			
			r=request.getRequestDispatcher("index.jsp");
			r.forward(request, response);
		}
		
	}


}
