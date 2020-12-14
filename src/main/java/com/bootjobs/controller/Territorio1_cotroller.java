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

import com.bootjobs.model.Annuncio_Service;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;
import com.bootjobs.model.Tipologia;
import com.bootjobs.model.Tipologia_service;

/**
 * Servlet implementation class Territorio1_cotroller
 */
public class Territorio1_cotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Territorio1_cotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Territorio_service ts = new Territorio_service();		

		List<Territorio> regioni = ts.get_all_regioni();
		ArrayList<String> tbregioni = new ArrayList<String>();
		for (int i = 0; i < regioni.size(); i++) {
			Territorio t = regioni.get(i);

			tbregioni.add(t.getRegione());
		}

		request.setAttribute("listaRegioni1", tbregioni);

		RequestDispatcher rs = request.getRequestDispatcher("/view/modifica.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
