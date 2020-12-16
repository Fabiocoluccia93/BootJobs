package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Provincia;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;


/**
 * Servlet implementation class Province
 */
public class Province_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Province_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		Territorio t = new Territorio();
		Territorio_service ts = new Territorio_service();
		String regione = request.getParameter("regioni");
		System.out.println("Regioni di modifica.jsp " + regione);
		
		
		List<Territorio> infRegione = ts.getOne(regione);
		t = infRegione.get(0);
		int codIstat = t.getId();
		System.out.println("ti prego " + codIstat);
		
		List<Provincia> lp = ts.get_all_province(codIstat);
		out.println("<option> Provincia </option>");
		for(int i = 0; i<lp.size();i++) {
			out.println("<option>" + lp.get(i).getNome_provincia() + "</option>");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
