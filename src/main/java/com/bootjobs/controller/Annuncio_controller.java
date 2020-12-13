package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;

/**
 * Servlet implementation class Annuncio_controller
 */
//@WebServlet("/Annuncio_controller")
public class Annuncio_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Annuncio_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Annuncio a = new Annuncio();
		Annuncio_Service as = new Annuncio_Service();
		HttpSession session = request.getSession();
		
		double x = Double.parseDouble(request.getParameter("stipendio"));
		String data = request.getParameter("data");
		
		Date dataU = null;
		try {
			dataU = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(data);
			dataU = date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		java.sql.Date daras = new java.sql.Date(dataU.getTime());
		
//		a.setId_societa_annuncio(session.getAttribute(//session id societa));
		if(request.getParameter("nAnnuncio").equals("")) {
			out.println("il campo e' vuoto");
		}
		a.setNome_annuncio(request.getParameter("nAnnuncio"));
		a.setDescrizione(request.getParameter("descrizione"));
		a.setStipendio(x);
		a.setTipo_contratto(request.getParameter("tContratto"));
		a.setTitolo_di_studio(request.getParameter("tStudio"));
		a.setData_pubblicazione(daras);
		a.setComune(request.getParameter("lComuni"));
		System.out.println("ciao sono la " + request.getParameter("lComuni"));
		as.inserisciAnnuncio(a);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
