package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.bootjobs.model.Societa;
import com.bootjobs.model.SocietaService;
import com.bootjobs.model.SocietaUtilities;

/**
 * Servlet implementation class SocietaController
 */
public class SocietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		RequestDispatcher r=null;
		String param = request.getParameter("param");
		

		if (param.equals("1")) {
			
			Societa s =null;
			SocietaService ss = new SocietaService();
			
			
			String mail=request.getParameter("mail");
			String password = request.getParameter("password");
			
			s=ss.accessoSocieta(mail, password);
			
				if (s!=null) {

					HttpSession session = request.getSession();

					session.setAttribute("societa", s);
					
					r=request.getRequestDispatcher("view/homePageSocieta.jsp");
				}
				
				else {
					r=request.getRequestDispatcher("view/accessoSocieta.jsp");
					request.setAttribute("messaggio", "Mail o password non corrette. Ritenta l'accesso o se sei una nuova societa' iscriviti." );					
				}			

		}
		
		
		
		
		 if(param.equals("2")) {
			
			Societa nuova= null;
			SocietaService ss = new SocietaService();
					
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			String pIva =request.getParameter("pIva");
			String nome = request.getParameter("nomeTitolare");
			String cognome = request.getParameter("cognomeTitolare");
			String nomeAzienda = request.getParameter("nomeAzienda");
			String telefono = request.getParameter("contattoTelefonico");
			String comuneSocieta = request.getParameter("comuneSocieta");
			
	
	if(!mail.equals("") && !password.equals("") && !nome.equals("") && !cognome.equals("") && !nomeAzienda.equals("") && !telefono.equals("") && !comuneSocieta.equals("")) {
	
		if(pIva.length() == 11) {
			
				if (!ss.checkEsistente(mail, pIva)) {

					nuova = new Societa(mail, password, pIva, nome, cognome, nomeAzienda, telefono, comuneSocieta);					
					
					if(ss.iscrizione(nuova)) {
						
						r=request.getRequestDispatcher("index.jsp");
						
						request.setAttribute("iscrizioneOk", "Iscrizione effettuata con successo, ora puoi effettuare il login");
						}
					}
					else {
						
						r=request.getRequestDispatcher("view/creazioneSocieta.jsp");
						request.setAttribute("societaEsistente", "La societa risulta presente nei nostri sistemi. prova a eseguire l'accesso.");
						
					}
		}
		else {
			
			r=request.getRequestDispatcher("view/creazioneSocieta.jsp");
			request.setAttribute("partitaIvaErrata", "ATTENZIONE! La partita iva deve contenere obbligatoriamente 11 caratteri!");
			
		}
		}
		else {
		
			r=request.getRequestDispatcher("view/creazioneSocieta.jsp");
			request.setAttribute("campiVuoti", "ATTENZIONE!I campi devono essere inseriti necessariamente tutti!");
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
				}
			}
			
			else {
				
				request.setAttribute("passwordErrata", "Password errata, inserisci la password corretta per eseguire le modifiche");
				r=request.getRequestDispatcher("view/modificaProfiloSocieta.jsp");
			}						
		}
			
		r.forward(request, response);
		
	}
}
