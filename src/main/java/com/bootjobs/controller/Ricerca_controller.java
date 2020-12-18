package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;
import com.bootjobs.model.Candidato;

/**
 * Servlet implementation class Ricerca_controller
 */
@WebServlet("/Ricerca_controller")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Annuncio_Service as = new Annuncio_Service();
		HttpSession session = request.getSession();
		String param = request.getParameter("param");
		Integer intParam = Integer.parseInt(param);
		if (intParam == 3) 
		{
			Annuncio singolo = null;
			String id = request.getParameter("id");
			Integer idInt = Integer.parseInt(id);
			singolo = as.findById(idInt);
			session.setAttribute("annuncio", singolo);
			RequestDispatcher rd = request.getRequestDispatcher("/view/dettagliAnnuncioCandidato.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		Annuncio_Service as = new Annuncio_Service();
		Candidato c = new Candidato();
		Annuncio a = new Annuncio();
		HttpSession session = request.getSession();

		int b;
		
		if(session.getAttribute("id_utente")!= null) {
			 b = (int) session.getAttribute("id_utente");
		} else {
			 b = 0;
		}
				
		
		String param = request.getParameter("param");
		Integer intParam = Integer.parseInt(param);

		if (intParam == 1 && b== 0) {

			String nAnnuncio = request.getParameter("nomeAnnuncio");
			System.out.println(nAnnuncio);

			if (nAnnuncio.equals(null)) {

				out.println("Inserisci un parola chiave");
				RequestDispatcher rd = request.getRequestDispatcher("/view/index.jsp");
				rd.include(request, response);
			} else {

				List<Annuncio> listaAnnuncio = as.ricercanome_annuncio(nAnnuncio);

				for (int i = 0; i < listaAnnuncio.size(); i++) {
					a = listaAnnuncio.get(i);
					System.out.println(a.getNome_annuncio());
				}

				session.setAttribute("annunci", listaAnnuncio);

				RequestDispatcher rd = request.getRequestDispatcher("/view/risultatiAnnuncio.jsp");
				rd.include(request, response);
			}
		}
		if (intParam == 2) {

//			String idSocieta = session.getAttribute("");
//			Integer id = Integer.parseInt(idSocieta);
//
//			int id = 2;
//			String nAnnuncio = request.getParameter("nomeAnnuncio");
//			System.out.println(nAnnuncio);
//
//			List<Annuncio> listaAnnuncio = as.findById(id);
//
//			for (int i = 0; i < listaAnnuncio.size(); i++) {
//				a = listaAnnuncio.get(i);
//				System.out.println(a.getNome_annuncio());
//			}
//
//			request.setAttribute("annunci", listaAnnuncio);
//
//			RequestDispatcher rd = request.getRequestDispatcher("/view/risultatiAnnuncioSocieta.jsp");
//			rd.include(request, response);
		}
		
		
		
		if (b != 0) {

			String nAnnuncio = request.getParameter("nomeAnnuncio");
			System.out.println(nAnnuncio);

			if (nAnnuncio.equals(null)) {

				out.println("Inserisci un parola chiave");
				RequestDispatcher rd = request.getRequestDispatcher("/view/index.jsp");
				rd.include(request, response);
			} else {

				List<Annuncio> listaAnnuncio = as.ricercanome_annuncio(nAnnuncio);

				for (int i = 0; i < listaAnnuncio.size(); i++) {
					a = listaAnnuncio.get(i);
					System.out.println(a.getNome_annuncio());
				}

				session.setAttribute("annunci", listaAnnuncio);

				RequestDispatcher rd = request.getRequestDispatcher("/view/risultatiAnnuncioCandidato.jsp");
				rd.include(request, response);
			}

		}
	}
}
