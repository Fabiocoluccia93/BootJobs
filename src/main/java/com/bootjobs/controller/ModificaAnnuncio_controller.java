package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;

/**
 * Servlet implementation class ModificaAnnuncio_controller
 */
public class ModificaAnnuncio_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaAnnuncio_controller() {
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

		Annuncio_Service as = new Annuncio_Service();
		Annuncio a = new Annuncio();
		PrintWriter out = response.getWriter();

		String idAnnuncio = request.getParameter("id");
		Integer id = Integer.parseInt(idAnnuncio);

		System.out.println("*************************************");
		System.out.println(request.getParameter("nAnnuncio"));
		System.out.println(request.getParameter("descrizione"));
		System.out.println(request.getParameter("tContratti"));
		System.out.println(request.getParameter("tStudio"));
		System.out.println(request.getParameter("lComuni"));
		System.out.println(request.getParameter("stipendio"));
		System.out.println(request.getParameter("data"));
		System.out.println("*************************************");
		
		if (request.getParameter("nAnnuncio").equals("") || request.getParameter("descrizione").equals("")
				|| request.getParameter("tContratti").equals("Tipo contratto")
				|| request.getParameter("tStudio").equals("Titolo di studio")
				|| request.getParameter("lComuni").equals("") || request.getParameter("stipendio").equals(null)
				|| request.getParameter("data").equals(null)) {
			out.println("Uno dei campi e' vuoto");

			RequestDispatcher rd = request.getRequestDispatcher("view/modifica.jsp");
			rd.include(request, response);
		} else {

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
			double x = Double.parseDouble(request.getParameter("stipendio"));
			a.setNome_annuncio(request.getParameter("nAnnuncio"));
			a.setDescrizione(request.getParameter("descrizione"));
			a.setTipo_contratto(request.getParameter("tContratti"));
			a.setTitolo_di_studio(request.getParameter("tStudio"));
			a.setComune(request.getParameter("lComuni"));
			a.setData_pubblicazione(daras);
			a.setStipendio(x);

			as.modificaAnnuncio(a, id);
			
			
			
			List<Annuncio> listaAnnuncio = as.findById(id);
			
			for (int i = 0; i < listaAnnuncio.size(); i++) {
				a = listaAnnuncio.get(i);
			}
			
			
			request.setAttribute("annunci", listaAnnuncio);

			RequestDispatcher rd = request.getRequestDispatcher("/view/risultatiAnnuncioSocieta.jsp");

			rd.include(request, response);
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
