package com.bootjobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;

/**
 * Servlet implementation class Ricerca_controller
 */
public class Ricerca_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ricerca_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Annuncio_Service as = new Annuncio_Service();
		Annuncio a = new Annuncio();
		String nAnnuncio = request.getParameter("nomeAnnuncio");
		System.out.println(nAnnuncio);
		
		List<Annuncio> listaAnnuncio = as.ricercanome_annuncio(nAnnuncio);
		
		for (int i = 0; i < listaAnnuncio.size(); i++) {
			a = listaAnnuncio.get(i);
			System.out.println(a.getNome_annuncio());
		}
		
		request.setAttribute("annunci", listaAnnuncio);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/risultatiAnnuncio.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
