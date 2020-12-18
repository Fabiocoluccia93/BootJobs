package com.bootjobs.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.Session;

import com.bootjobs.model.Candidato;
import com.bootjobs.model.Candidato_service;
import com.bootjobs.model.FileService;
import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class Candidato_controller
 */
@WebServlet("/Candidato_controller")
@MultipartConfig()
public class Candidato_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	private String foto ;
	private String curriculum;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Candidato_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param= request.getParameter("param");
		if(request.getParameter("param")!=null && param.equals("10"))
		{
			RequestDispatcher r = null ;
			HttpSession session = request.getSession();
			Territorio_service ts = new Territorio_service();
			List<Territorio> regioni = ts.get_all_regioni();
			ArrayList<String> tbregioni = new ArrayList<String>();
			for (int i = 0; i < regioni.size(); i++) {
				Territorio t = regioni.get(i);

				tbregioni.add(t.getRegione());
			}
			
			ArrayList<String> contratto = new ArrayList<String>();
			session.setAttribute("listaRegioni", tbregioni);
			response.sendRedirect("view/Profilo.jsp");
			
		}
		
		if(request.getParameter("param")!=null && param.equals("0"))
		{
			RequestDispatcher r = null ;
			HttpSession session = request.getSession();
			Territorio_service ts = new Territorio_service();
			List<Territorio> regioni = ts.get_all_regioni();
			ArrayList<String> tbregioni = new ArrayList<String>();
			for (int i = 0; i < regioni.size(); i++) {
				Territorio t = regioni.get(i);

				tbregioni.add(t.getRegione());
			}
			
			ArrayList<String> contratto = new ArrayList<String>();
			session.setAttribute("listaRegioni", tbregioni);
			response.sendRedirect("view/iscrizioneCandidato.jsp");
			
		}
		if(request.getParameter("param")!=null && param.equals("6")&&foto!=null)
		{
			
			String fotoprofilo = foto;
			System.out.println(fotoprofilo);
		response.setContentType("image/jpeg");  
	    ServletOutputStream out;  
	    out = response.getOutputStream();  
	    FileInputStream fin = new FileInputStream(fotoprofilo);  
	      
	    BufferedInputStream bin = new BufferedInputStream(fin);  
	    BufferedOutputStream bout = new BufferedOutputStream(out);  
	    int ch =0; ;  
	    while((ch=bin.read())!=-1)  
	    {  
	    bout.write(ch);  
	    }  
	      
	    bin.close();  
	    fin.close();  
	    bout.close();  
	    out.close();  
	    }
		if(request.getParameter("param")!=null && param.equals("7")&&curriculum!=null)
		{
			
			String curriculumprofilo = curriculum;
			System.out.println(curriculumprofilo);
		response.setContentType("application/pdf");  
	    response.setHeader("Content-disposition","attachment; filename=Curriculum.pdf");

	    ServletOutputStream out1;  
	    out1 = response.getOutputStream();  
	    FileInputStream fin1 = new FileInputStream(curriculumprofilo);  
	      
	    BufferedInputStream bin1 = new BufferedInputStream(fin1);  
	    BufferedOutputStream bout1 = new BufferedOutputStream(out1);  
	    int ch =0; ;  
	    while((ch=bin1.read())!=-1)  
	    {  
	    bout1.write(ch);  
	    }  
	      
	    bin1.close();  
	    fin1.close();  
	    bout1.close();  
	    out1.close();  
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param= request.getParameter("param");
		
		if(request.getParameter("param")!=null && param.equals("1"))
		{
			RequestDispatcher r = null ;
			Candidato_service cs = new Candidato_service();
			Candidato c_isc = new Candidato();
			c_isc.setMail(request.getParameter("mail"));
			c_isc.setPassword(request.getParameter("password")); 
			c_isc.setNome(request.getParameter("nome"));
			c_isc.setCognome(request.getParameter("cognome"));
			c_isc.setTitolo_studio(request.getParameter("titolo_studio"));  
			c_isc.setNumero_telefono(request.getParameter("numero_telefono"));
			/***************************************************/
			
			
			c_isc.setComune_candidato(request.getParameter("lComuni"));
			/***************************************************/
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
				Date date;
				try {
					String datastringa = request.getParameter("data_nascita");
							if(datastringa.equals(""))
							{
								
							}
							else
							{
								date = formatter.parse(datastringa);
								java.sql.Date sqlDate = new java.sql.Date(date.getTime());
								c_isc.setData_nascita(sqlDate);
							}
					
				} 
				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileService.setDirectory();
			
			System.out.println(request.getParameter("data_nascita"));
		/////////////////////////////////////////////////////////////////
			FileService fs = new FileService();
			String fileName = fs.getFileName(request.getParameter("mail"));
			if(fileName.equals(""))
			{
				
			}
			else
			{
				Part filePart = request.getPart("file");
				c_isc.setFoto(fs.UploadFoto(filePart,fileName));
			}
		    
		    String fileName1 = fs.getFileName1(request.getParameter("mail"));
		    if(fileName1.equals(""))
			{
				
			}
			else
			{
				Part filePart1 = request.getPart("file1");
			    c_isc.setCurriculum(fs.UploadDocument(filePart1,fileName1));
			}
		    
		  
		   
/////////////////////////////////////////////////////////////////
		    String message = null;
		    System.out.println("mail "+c_isc.getMail());
		    boolean mailcheck = cs.mailcheck(c_isc.getMail());
			if(mailcheck==false||c_isc.getMail().equals("")||c_isc.getNome().equals("")||c_isc.getCognome().equals("")||c_isc.getPassword().equals("")||c_isc.getCurriculum().equals("")||c_isc.getFoto().equals("")||c_isc.getTitolo_studio().equals("")||c_isc.getNumero_telefono().equals("")||c_isc.getComune_candidato().equals(""))
			{
				if(mailcheck==false)
				{
					message=" mail in uso";
				}
				else
				{
				message="I campi sono tutti obbligatori inserisci tutti i dati";
				}
			}
			else 
			{		
				message = null;
				boolean check = cs.iscrizione(c_isc);
				if(check==true)
				{
				 message = "Iscrizione eseguita con successo";
				}
			 }
			request.setAttribute("message", message);
			r=request.getRequestDispatcher("/view/iscrizioneCandidato.jsp");
			r.forward(request,response);
		}
		// login e caricamento profilo.jsp
		if(request.getParameter("param")!=null && param.equals("2"))
		{
			RequestDispatcher r = null ;
			boolean s;
			Candidato c_isc = new Candidato();
			Candidato c_oklog = new Candidato();
			Candidato_service cs = new Candidato_service();
			c_isc.setMail(request.getParameter("mail"));
			c_isc.setPassword(request.getParameter("password"));
			c_oklog=cs.login(c_isc);
			request.setAttribute("email", c_isc.getMail());
				if(c_oklog!=null)
				{
					request.setAttribute("profilo", c_oklog);

					HttpSession httpsession = request.getSession();
					httpsession.setAttribute("id_utente", c_oklog.getId_candidato());
					
					foto =  c_oklog.getFoto();
					curriculum = c_oklog.getCurriculum();
					
					r=request.getRequestDispatcher("/view/Profilo.jsp");	
					r.forward(request, response);
				}
				else
				{
					String message;
					message = "username o password errata riprova";
					request.setAttribute("message", message);
					r=request.getRequestDispatcher("/view/Login.jsp");	
					r.forward(request, response);
				}
				
				
		}
		// eliminazione profilo da profilo.jsp
		if(request.getParameter("param")!=null && param.equals("3"))
		{
			RequestDispatcher r = null ;
			Candidato_service cs = new Candidato_service();
			String del = request.getParameter("ide");
			boolean as= cs.eliminaProfilo(del);
			foto=null;
			String message = null;
			 if(as==true)
			 {
				 message = "Eliminazione eseguita con successo";
			 }
			 request.setAttribute("message", message);
			 r=request.getRequestDispatcher("/view/Profilo.jsp");
			 r.forward(request,response);
		}
		// modifica profilo da profilo.jsp
		if(request.getParameter("param")!=null && param.equals("4"))
		{
			RequestDispatcher r = null ;
			Candidato_service cs = new Candidato_service();
			Candidato c_mod = new Candidato();
			String id = request.getParameter("id");
			c_mod.setId_candidato(Integer.parseInt(id));
			c_mod.setMail(request.getParameter("mail"));
			c_mod.setPassword(request.getParameter("password")); 
			c_mod.setNome(request.getParameter("nome"));
			c_mod.setCognome(request.getParameter("cognome"));
			c_mod.setTitolo_studio(request.getParameter("titolo_studio"));  
			c_mod.setNumero_telefono(request.getParameter("numero_telefono"));
			/***************************************************/
			
			c_mod.setComune_candidato(request.getParameter("lComuni"));
			
			
			/***************************************************/
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try 
			{
				String datastringa = request.getParameter("data_nascita");
				if(datastringa.equals(""))
				{
					
				}
				else
				{
					date = formatter.parse(datastringa);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					c_mod.setData_nascita(sqlDate);
				}
			} 
			catch (ParseException e) 
			{
				
				e.printStackTrace();
			}
	
			
			String message = null;
			if(c_mod.getMail().equals("")||c_mod.getNome().equals("")||c_mod.getCognome().equals("")||c_mod.getPassword().equals("")||c_mod.getComune_candidato().equals("")||c_mod.getTitolo_studio().equals("")||c_mod.getNumero_telefono().equals("")||c_mod.getComune_candidato().equals(""))
			{
				
					message="I campi sono tutti obbligatori inserisci tutti i dati";
			}
			else
			{
				Candidato as=cs.modificaProfilo(c_mod);
				message = null;
				if(as!=null)
				{
					message = "Modifica eseguita con successo";
				}
			}
			 request.setAttribute("profilo", c_mod);
			 request.setAttribute("message", message);
			 r=request.getRequestDispatcher("/view/Profilo.jsp");
			 r.forward(request,response);
		}
		if(request.getParameter("param")!=null && param.equals("5"))
		{
//			FileService fs = new FileService();
//			String destinazione = request.getParameter("destination");
//			String destinazione1 = request.getParameter("destination1");
//			fs.setDestinazione(destinazione);
//			fs.setDestinazione1(destinazione1);
			FileService.setDirectory();
		}
		if(request.getParameter("param")!=null && param.equals("8"))
		{
			FileService.setDirectory();
			FileService fs = new FileService();
			RequestDispatcher r = null ;
		     Candidato c_mod = new Candidato();
			 Candidato_service cs = new Candidato_service();
			 Part filePart = request.getPart("file2");
			 String fileName = fs.getFileName(request.getParameter("mail"));
			 String nomefoto = fs.UploadFoto(filePart,fileName);
			 System.out.println("il nome della foto da modificare e"+nomefoto);
			 String id = request.getParameter("id");
			 c_mod.setId_candidato(Integer.parseInt(id));
			 c_mod.setMail(request.getParameter("mail"));
			 c_mod.setPassword(request.getParameter("password")); 
			 c_mod.setNome(request.getParameter("nome"));
			 c_mod.setCognome(request.getParameter("cognome"));
			 c_mod.setTitolo_studio(request.getParameter("titolo_studio"));  
			 c_mod.setNumero_telefono(request.getParameter("numero_telefono"));
			 c_mod.setComune_candidato(request.getParameter("comune"));
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				try 
				{
					date = formatter.parse(request.getParameter("data_nascita"));
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					c_mod.setData_nascita(sqlDate);
				} 
				catch (ParseException e) 
				{
					
					e.printStackTrace();
				}
		
			 c_mod.setFoto(nomefoto);
			 c_mod.setMail(request.getParameter("mail"));
			boolean check = cs.modificaFoto(c_mod);
			String message = null;
			 if(check==true)
			 {
				 message = "Foto aggiornata con successo";
			 }
			 request.setAttribute("profilo", c_mod);
			 request.setAttribute("message", message);
			 r=request.getRequestDispatcher("/view/Profilo.jsp");
			 r.forward(request,response);
		}
		if(request.getParameter("param")!=null && param.equals("9"))
		{
			FileService.setDirectory();
			 FileService fs = new FileService();
			 RequestDispatcher r = null ;
			 Candidato c_mod = new Candidato();
			 Candidato_service cs = new Candidato_service();
			 Part filePart1 = request.getPart("file3");
			 String fileName1 = fs.getFileName1(request.getParameter("mail"));
			 String id = request.getParameter("id");
			 c_mod.setId_candidato(Integer.parseInt(id));
			 c_mod.setMail(request.getParameter("mail"));
			 c_mod.setPassword(request.getParameter("password")); 
			 c_mod.setNome(request.getParameter("nome"));
			 c_mod.setCognome(request.getParameter("cognome"));
			 c_mod.setTitolo_studio(request.getParameter("titolo_studio"));  
			 c_mod.setNumero_telefono(request.getParameter("numero_telefono"));
			 c_mod.setComune_candidato(request.getParameter("comune"));
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				try 
				{
					date = formatter.parse(request.getParameter("data_nascita"));
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					c_mod.setData_nascita(sqlDate);
				} 
				catch (ParseException e) 
				{
					
					e.printStackTrace();
				}
		
			 c_mod.setCurriculum(fs.UploadDocument(filePart1,fileName1)); 
			 c_mod.setMail(request.getParameter("mail"));
		     boolean check = cs.modificaDocumento(c_mod);
		     String message = null;
			 if(check==true)
			 {
				 message = "Curriculum aggiornato con successo";
			 }
			 request.setAttribute("profilo", c_mod);
			 request.setAttribute("message", message);
			 r=request.getRequestDispatcher("/view/Profilo.jsp");
			 r.forward(request,response);
		}
		
			
	}

}
