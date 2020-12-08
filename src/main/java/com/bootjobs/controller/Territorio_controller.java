package com.bootjobs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class Territorio_controller
 */
public class Territorio_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Territorio_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Territorio_service ts = new Territorio_service();
		HttpSession session = request.getSession();

		List<Territorio> comuni = ts.get_all_regioni();
		ArrayList<String> tbregioni = new ArrayList<String>();
		for (int i = 0; i < comuni.size(); i++) {
			Territorio a = comuni.get(i);

			tbregioni.add(a.getRegione());
		}

		session.setAttribute("listaRegioni", tbregioni);

		RequestDispatcher rs = request.getRequestDispatcher("/view/annuncio.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
