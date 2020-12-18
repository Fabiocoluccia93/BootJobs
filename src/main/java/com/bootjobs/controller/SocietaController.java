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

import com.bootjobs.model.Annuncio;
import com.bootjobs.model.Annuncio_Service;
import com.bootjobs.model.Societa;
import com.bootjobs.model.SocietaService;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class SocietaController
 */
@WebServlet("/SocietaController")
public class SocietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher r =null;
		String param = request.getParameter("param");
		
		if(param.equals("1")) {
			r=request.getRequestDispatcher("view/modificaProfiloSocieta.jsp");
		}
	
		if(param.equals("2")) {
			r=request.getRequestDispatcher("view/confermaEliminazioneSocieta.jsp");
		}
		
		if(param.equals("3")) {
			r=request.getRequestDispatcher("view/homePageSocieta.jsp");
		}
		
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param = request.getParameter("param");
		RequestDispatcher r=null;
		
		

		if (param.equals("1")) {
			
			Societa s =null;
			SocietaService ss = new SocietaService();
			Annuncio_Service as = new Annuncio_Service();
			Annuncio a = new Annuncio();
			
			
			String mail=request.getParameter("mail");
			String password = request.getParameter("password");
			
			s=ss.accessoSocieta(mail, password);
			
				if (s!=null) {

					HttpSession session = request.getSession();
					
					List<Annuncio> listaAnnuncio = as.findByIdSoc(s.getId());

					for (int i = 0; i < listaAnnuncio.size(); i++) {
						a = listaAnnuncio.get(i);
						System.out.println(a.getNome_annuncio());
					}
					
					session.setAttribute("annunci", listaAnnuncio);
					session.setAttribute("societa", s);
					
					r=request.getRequestDispatcher("view/homePageSocieta.jsp");
					r.forward(request, response);
				}
				
				else {
					r=request.getRequestDispatcher("view/accessoSocieta.jsp");
					request.setAttribute("messaggio", "Mail o password non corrette. Ritenta l'accesso o se sei una nuova societa' iscriviti." );					
					r.forward(request, response);
				}			

		}
		
		
		 if(param.equals("2")) {
				
			Societa nuova= null;
			SocietaService ss = new SocietaService();
			HttpSession session = request.getSession();
					
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			String pIva =request.getParameter("pIva");
			String nome = request.getParameter("nomeTitolare");
			String cognome = request.getParameter("cognomeTitolare");
			String nomeAzienda = request.getParameter("nomeAzienda");
			String telefono = request.getParameter("contattoTelefonico");
			String comuneSocieta = request.getParameter("lComuni");
			
	
	if(!mail.equals("") && !password.equals("") && !nome.equals("") && !cognome.equals("") && !nomeAzienda.equals("") && !telefono.equals("") && !comuneSocieta.equals("")) {
	
		if(pIva.length() == 11) {
			
				if (!ss.checkEsistente(mail, pIva)) {

					nuova = new Societa(mail, password, pIva, nome, cognome, nomeAzienda, telefono, comuneSocieta);					
					
					if(ss.iscrizione(nuova)) {
						
						r=request.getRequestDispatcher("index.jsp");
						
						request.setAttribute("iscrizioneOk", "Iscrizione effettuata con successo, ora puoi effettuare il login");
						r.forward(request, response);
					}
					}
					else {
						
						session.setAttribute("societaEsistente", "La societa risulta presente nei nostri sistemi. prova a eseguire l'accesso.");
											
						ArrayList<Territorio> tbregioni = ss.dropDownRegioni();
						
						session.setAttribute("listaRegioni", tbregioni);
						
						response.sendRedirect("view/creazioneSocieta.jsp");
						
					}
		}
		else {
			
			session.setAttribute("partitaIvaErrata", "ATTENZIONE! La partita iva deve contenere obbligatoriamente 11 caratteri!");
			
			ArrayList<Territorio> tbregioni = ss.dropDownRegioni();
			
			session.setAttribute("listaRegioni", tbregioni);
			
			response.sendRedirect("view/creazioneSocieta.jsp");
			
		}
		}
		else {
	
			session.setAttribute("campiVuoti", "ATTENZIONE!I campi devono essere inseriti necessariamente tutti!");

			ArrayList<Territorio> tbregioni = ss.dropDownRegioni();						
			
			session.setAttribute("listaRegioni", tbregioni);
			
			response.sendRedirect("view/creazioneSocieta.jsp");
		}
	
		
	 }
		
			
		
		
		
		
	
			if(param.equals("3")) {
				
				SocietaService ss = new SocietaService();
				HttpSession session = request.getSession();
				
				Societa s = (Societa) session.getAttribute("societa");
				
				if(ss.eliminaProfilo(s.getId())) {
					
					session.invalidate();
					
					r=request.getRequestDispatcher("index.jsp");
					request.setAttribute("cancellazione", "eliminazione della societa effettuata con successo!");	
					r.forward(request, response);
				}
			}

			
			if(param.equals("4")) {
				
				SocietaService ss = new SocietaService();
				HttpSession session = request.getSession();
				Societa s = (Societa) session.getAttribute("societa");	
				
				String vecchiaPassword = request.getParameter("vecchiaPassword");
				String nuovaPassword = request.getParameter("nuovaPassword");
				String nome = request.getParameter("nomeTitolare");
				String cognome = request.getParameter("cognomeTitolare");
				String telefono = request.getParameter("contattoTelefonico");
												
			if(s.getPassword().equals(vecchiaPassword) && !vecchiaPassword.equals("")) {
				
				
				if(nuovaPassword.equals("")){					
					s.setPassword(s.getPassword());					
				}else {
					s.setPassword(nuovaPassword);
				}
			
				
				if(nome.equals("")) {
					s.setNome(s.getNome());
				}else {
					s.setNome(nome);
				}
				
				
				if(cognome.equals("")) {
					s.setCognome(s.getCognome());
				}else {
					s.setCognome(cognome);
				}
				
				
				if(telefono.equals("")) {
					s.setTelefono(s.getTelefono());					
				} else {
					s.setTelefono(telefono);
				}
				
			
				if(ss.modificaProfilo(s)) {
				
				request.setAttribute("modificaOK", "Modifiche eseguite correttamente!");				
				r=request.getRequestDispatcher("view/homePageSocieta.jsp");
				r.forward(request, response);
				}
			}
			
			else {
				
				request.setAttribute("passwordErrata", "Password errata, inserisci la password corretta per eseguire le modifiche");
				r=request.getRequestDispatcher("view/modificaProfiloSocieta.jsp");
				r.forward(request, response);
			}						
		}
		
	}

}
