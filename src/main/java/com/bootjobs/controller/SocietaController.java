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

/**
 * Servlet implementation class SocietaController
 */
public class SocietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher r=null;
		String param = request.getParameter("param");
		
		if (param.equals("1")) {
			
			boolean check = false;
			PrintWriter out = response.getWriter();
			Societa s = null;
			
			String mail=request.getParameter("mail");
			String password = request.getParameter("password");
			SocietaService ss = new SocietaService();
			
			check = ss.accessoSocieta(mail, password);
			
			if (check = true) {
				
				r=request.getRequestDispatcher("view/homePageSocieta.jsp");
				
				
			} else {
				
				out.println("Mail o password non corrette. Ritenta l'accesso o se sei una nuova societa' iscriviti.");
				r=request.getRequestDispatcher("view/accessoSocieta.jsp");
				r.include(request, response);
			}
		}
			
		else if(param.equals("2")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Societa s= null;
			SocietaService ss = new SocietaService();
			
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			String pIva =request.getParameter("pIva");
			String nome = request.getParameter("nomeTitolare");
			String cognome = request.getParameter("cognomeTitolare");
			String nomeAzienda = request.getParameter("nomeAzienda");
			String contattoTelefonico = request.getParameter("contattoTelefonico");
			String comuneSocieta = request.getParameter("comuneSocieta");
			
			if(pIva.length() == 11) {
				
				if (comuneSocieta !=null) {
					
					if(ss.checkEsiste(mail, pIva)) {
					
						out.println("Societa' gia' presente nel sistema. prova ad accedere");
						r=request.getRequestDispatcher("view/accessoSocieta.jsp");
						r.include(request, response);
						
					} else {
					
						s= new Societa(mail, password, pIva, nome, cognome, nomeAzienda, contattoTelefonico, comuneSocieta);
						ss.iscrizione(s);
						out.println("Societa' registrata, effettua l'accesso.");
						r=request.getRequestDispatcher("view/accessoSocieta.jsp");
						r.include(request, response);
						
					}
				}
				else {
					out.println("Inserisci correttamente la citta della societa");
					r=request.getRequestDispatcher("view/accessoSocieta.jsp");
					r.include(request, response);
				}
			}
			else
			{
				out.println("Partita iva errata, inserisci correttamente la partita iva.");
				out.println("La partita iva deve essere necessariamente composta da 11 caratteri.");
				r=request.getRequestDispatcher("view/creazioneSocieta.jsp");
				r.include(request, response);
				
			}
					
		}
		
		r.forward(request, response);
						
		}
		
}


