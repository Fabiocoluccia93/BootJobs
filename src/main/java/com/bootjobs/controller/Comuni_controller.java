package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Comuni;
import com.bootjobs.model.Provincia;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class Comuni_controller
 */
public class Comuni_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Comuni_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		Territorio_service ts = new Territorio_service();
		Provincia pro = new Provincia();
		String province = request.getParameter("province");
		System.out.println("ti prego " + province);

		List<Provincia> siglaPro =ts.getSiglaPro(province);
		pro = siglaPro.get(0);
		
		
		List<Comuni> lp = ts.get_all_comuni(pro.getSigla());

		for (int i = 0; i < lp.size(); i++) {
			out.println("<option>" + lp.get(i).getNome_comune() + "</option>");
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
