package com.bootjobs.controller;

import java.io.File;
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

import com.bootjobs.model.AmministratoreService;
import com.bootjobs.model.FileService;
import com.bootjobs.model.Societa;

/**
 * Servlet implementation class AmministratoreController
 */
@WebServlet("/AmministratoreController")
public class AmministratoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmministratoreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher r=null;
		String param = request.getParameter("param");
		String message = null;
		
		if(request.getParameter("param")!=null && param.equals("0"))
		{
			String directory = request.getParameter("directoryimmagini");
			FileService.setupDirectoryImmagini(directory);	
			try
			{
				File file=new File(directory);
				if(!file.exists())
				{
						//crea la directory con il metodo mkdirs
					if(file.mkdirs())
					{
						file.setExecutable(true, false);
						file.setReadable(true, false);
						file.setWritable(true, false);
						message = "Directory foto creata e impostata nel database !";
					}
				}
			
					else
					{
						message = "Directory foto già esistente impostata nel database";
					}
				
			}
			catch (Exception e)
			{
				System.err.println("errore");
			}
			request.setAttribute("message", message);
			r=request.getRequestDispatcher("/view/DirectoryFile.jsp");
		}
	
		message=null;
		if(request.getParameter("param")!=null && param.equals("4"))
		{
			
			String directory =  request.getParameter("directorydocumenti");
			FileService.setupDirectoryDocumenti(directory);	
			try
			{
				File file=new File(directory);
				if(!file.exists())
				{
						//crea la directory con il metodo mkdirs
					if(file.mkdirs())
					{
						file.setExecutable(true, false);
						file.setReadable(true, false);
						file.setWritable(true, false);
						message = "Directory curriculum creata e impostata nel database!";
					}
				}
					else
					{
						message = "Directory curriculum già esistente impostata nel database";
					}
				}
				
			
		
		
			catch (Exception e)
			{
				System.err.println("errore");
			}
			request.setAttribute("message", message);
			r=request.getRequestDispatcher("/view/DirectoryFile.jsp");
		}
		

		if(param.equals("1")) {
			
			AmministratoreService as = new AmministratoreService();
			List <Societa> societa = new ArrayList<Societa>();
			
			societa=as.findAll();
			request.setAttribute("tutteSocieta", societa);
			
			
			r=request.getRequestDispatcher("view/cancellaSocieta.jsp");	
		}


		if(param.equals("3")) {
			r=request.getRequestDispatcher("view/homePageAmministratore.jsp");
		}

		r.forward(request, response);

	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r=null;
		String param = request.getParameter("param");

		if(param.equals("1")) {
			
			AmministratoreService as = new AmministratoreService();
			List <Societa> societa = new ArrayList<Societa>();
			String pIva = request.getParameter("partitaIva");
			
			if(as.cancellaSocieta(pIva)) {
				
				request.setAttribute("eliminazioneEffettuata", "Eliminazione della societa con relativi annunci effettuata con successo!");
				
				societa=as.findAll();
				request.setAttribute("tutteSocieta", societa);
				
				r=request.getRequestDispatcher("view/cancellaSocieta.jsp");
				
			}
			else {
			
			request.setAttribute("eliminazioneFallita", "Hai inserito una partita iva non corretta o inesistente!");
				
			societa=as.findAll();
			request.setAttribute("tutteSocieta", societa);
			
			r=request.getRequestDispatcher("view/cancellaSocieta.jsp");
			}
		}
		

		if(param.equals("4")) {
			HttpSession session = request.getSession(false);
			
			if(session!=null) {
				
				session.invalidate();
				
			}
			
			r=request.getRequestDispatcher("index.jsp");
		}
		r.forward(request, response);
		
	}

}

