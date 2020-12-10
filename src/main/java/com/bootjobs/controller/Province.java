package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Provincia;
import com.bootjobs.model.Territorio_service;


/**
 * Servlet implementation class Province
 */
public class Province extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Province() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		Territorio_service ts = new Territorio_service();
		String regioni = request.getParameter("regione");
		System.out.println(regioni);
		
		List<Provincia> lp = ts.get_All_provincie();
		
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
