package com.bootjobs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annuncio a = new Annuncio();
		Annuncio_Service as = new Annuncio_Service();
		double x = Double.parseDouble(request.getParameter("stipendio"));
		
		a= as.findById(1l);
		Annuncio b = new Annuncio();
		b.setNome_annuncio(request.getParameter("nAnnuncio"));
		b.setDescrizione(request.getParameter("descrizione"));
		b.setStipendio(x);
		b.setTipo_contratto(request.getParameter("tContratto"));
		b.setTitolo_di_studio(request.getParameter("tStudio"));
		as.inserisciAnnuncio(b);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
