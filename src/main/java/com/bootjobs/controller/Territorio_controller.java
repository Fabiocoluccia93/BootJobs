package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Territorio;
import com.bootjobs.model.Territorio_service;
import com.mysql.cj.protocol.WriterWatcher;

/**
 * Servlet implementation class Territorio_controller
 */
public class Territorio_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Territorio_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		Territorio_service ts = new Territorio_service();
		
		List<Territorio> comuni= ts.get_all_comuni();
		for(int i = 0; i<comuni.size(); i++) {
			Territorio a = comuni.get(i);
			out.println(a.getComune());			
		}
//		System.out.println(a.getComune());
		request.setAttribute("listaComuni", comuni);
		
		RequestDispatcher rs =request.getRequestDispatcher("/view/annuncio.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
