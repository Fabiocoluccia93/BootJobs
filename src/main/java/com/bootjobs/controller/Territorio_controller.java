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

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;
import com.bootjobs.model.Tipologia;
import com.bootjobs.model.Tipologia_service;

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
		Tipologia_service tips = new Tipologia_service();
		Tipologia tip = new Tipologia();
		Annuncio_Service as = new Annuncio_Service();
		HttpSession session = request.getSession();

		List<Territorio> comuni = ts.get_all_regioni();
		ArrayList<String> tbregioni = new ArrayList<String>();
		for (int i = 0; i < comuni.size(); i++) {
			Territorio t = comuni.get(i);

			tbregioni.add(t.getRegione());
		}
		
		ArrayList<String> contratto = new ArrayList<String>();

		List<Tipologia> tipo = tips.getTipologia();
		for(int i = 0; i<tipo.size();i++) {
			tip = tipo.get(i);
			contratto.add(tip.getTipologia());
		}
//		List<Annuncio> contratto = as.getTipoContratto();
//		ArrayList<String> tContratto = new ArrayList<String>();
//		for (int i = 0; i < contratto.size(); i++) {
//			Annuncio a = contratto.get(i);
//
//			tContratto.add(a.getContratto());
//			System.out.println(a.getContratto());
//		}
		
		//session.setAttribute("listaContratti", tContratto);
		session.setAttribute("listaRegioni", tbregioni);
		session.setAttribute("listaContratti", contratto);

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
