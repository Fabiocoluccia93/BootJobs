package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession s = request.getSession();
		Annuncio_Service as = new Annuncio_Service();
		Annuncio a = new Annuncio();
		PrintWriter out = response.getWriter();

		String nomeAnnuncioE = request.getParameter("annuncioEsistente");
		System.out.println("questo è il nome "+ nomeAnnuncioE);

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

		//if (nomeAnnuncioE.equals(annuncioA)) {

			a.setNome_annuncio(request.getParameter("nAnnuncio"));
			a.setTipo_contratto(request.getParameter("tContratto"));
			a.setDescrizione(request.getParameter("descrizione"));
			a.setTitolo_di_studio(request.getParameter("tStudio"));
			a.setData_pubblicazione(daras);
			a.setStipendio(x);

			as.modificaAnnuncio(nomeAnnuncioE, a);
			System.out.println("qua che nome ha " + a.getNome_annuncio());
			System.out.println("il nome corrisponde");

		//} else {
			out.println("non corrisponde");
		//}
//			request.setAttribute("listaRegioni", tbregioni);
		s.setAttribute("nomeAnnuncio", nomeAnnuncioE);


		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.include(request, response);

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
