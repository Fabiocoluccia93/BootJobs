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

		String idAnnuncio = request.getParameter("id");
		Integer id = Integer.parseInt(idAnnuncio);
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
			a.setDescrizione(request.getParameter("descrizione"));
			a.setTipo_contratto(request.getParameter("tContratti"));
			a.setTitolo_di_studio(request.getParameter("tStudio"));
			a.setComune(request.getParameter("lComuni"));
			a.setData_pubblicazione(daras);
			a.setStipendio(x);

			as.modificaAnnuncio(a , id);

		//} else {
		//}
//			request.setAttribute("listaRegioni", tbregioni);



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
