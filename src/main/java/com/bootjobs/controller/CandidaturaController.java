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
import com.bootjobs.model.Candidato_service;
import com.bootjobs.model.Candidatura;
import com.bootjobs.model.Candidatura_service;

/**
 * Servlet implementation class CandidaturaController
 */
@WebServlet("/CandidaturaController")
public class CandidaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidaturaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		
		RequestDispatcher r=null;
		Candidatura_service c_s  =  new Candidatura_service();
		Candidatura cand  = new Candidatura();
		HttpSession httpsession = request.getSession();
		Integer id_candidato = (Integer) httpsession.getAttribute("id_utente");
		String id_societa = request.getParameter("societa");
		String id_annuncio = request.getParameter("annuncio");
//		Integer idcandidatoInt = Integer.parseInt(id_candidato);
		cand.setId_candidato_fk(id_candidato);
		Integer id_adnnuncioInt = Integer.parseInt(id_annuncio);
		cand.setId_annuncio_fk(id_adnnuncioInt);
		Integer id_societaInt = Integer.parseInt(id_societa);
		cand.setId_societa_fk(id_societaInt);
		String message;
		boolean check = c_s.checkCandidatura(cand);
		if(check==true)
		{
			c_s.inserisciCandidatura(cand);
			message = "Candidatura inviata con successo";
		}
		else
		{
			message = "Candidatura gia inviata impossibile inviarne un'altra";
		}
		request.setAttribute("message", message);
		r=request.getRequestDispatcher("/view/dettagliAnnuncioCandidato.jsp");
		r.forward(request, response);
		
	}

}
