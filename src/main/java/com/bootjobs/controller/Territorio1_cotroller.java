package com.bootjobs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;
import com.bootjobs.model.Tipologia;
import com.bootjobs.model.Tipologia_service;
import com.bootjobs.model.TitoloStudio;
import com.bootjobs.model.TitotloStudio_service;

/**
 * Servlet implementation class Territorio1_cotroller
 */
@WebServlet("/Territorio1_cotroller")
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
		Tipologia_service tips = new Tipologia_service();
		TitotloStudio_service titoS= new TitotloStudio_service();
		Tipologia tip = new Tipologia();
		TitoloStudio titleS = new TitoloStudio();
		HttpSession session = request.getSession();
		
		String id_Annuncio = request.getParameter("id_Annuncio");

		List<Territorio> regioni = ts.get_all_regioni();
		ArrayList<String> tbregioni = new ArrayList<String>();
		for (int i = 0; i < regioni.size(); i++) {
			Territorio t = regioni.get(i);

			tbregioni.add(t.getRegione());
		}
		
		ArrayList<String> contratto = new ArrayList<String>();

		List<Tipologia> tipo = tips.getTipologia();
		for(int i = 0; i<tipo.size();i++) {
			tip = tipo.get(i);
			contratto.add(tip.getTipologia());
		}
		
		ArrayList<String> titolo = new ArrayList<String>();

		List<TitoloStudio> tit = titoS.getTitoloS();
		for(int i = 0; i<tit.size();i++) {
			titleS = tit.get(i);
			titolo.add(titleS.getTds());
		}

		session.setAttribute("listaRegioni1", tbregioni);
		session.setAttribute("listaContratti", contratto);
		session.setAttribute("listaTitolo", titolo);
		session.setAttribute("idAnnuncio", id_Annuncio);
		

		RequestDispatcher rs = request.getRequestDispatcher("view/modifica.jsp?idAnnuncio="+id_Annuncio);
		
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
