package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Comuni;
import com.bootjobs.model.Provincia;
import com.bootjobs.model.Territorio_service;

/**
 * Servlet implementation class Comuni_controller
 */
@WebServlet("/Comuni_controller")
public class Comuni_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comuni_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		Territorio_service ts = new Territorio_service();
		Provincia pro = new Provincia();
		String province = request.getParameter("province");
	
		List<Provincia> siglaPro =ts.getSiglaPro(province);
		pro = siglaPro.get(0);
		
		
		List<Comuni> lp = ts.get_all_comuni(pro.getSigla());
		out.println("<option>" + "Comune" + "</option>");
		for (int i = 0; i < lp.size(); i++) {
			out.println("<option>" + lp.get(i).getNome_comune() + "</option>");
		}
	}

=======
		PrintWriter out = response.getWriter();
		Territorio_service ts = new Territorio_service();
		Provincia pro = new Provincia();
		String province = request.getParameter("province");

		List<Provincia> siglaPro =ts.getSiglaPro(province);
		pro = siglaPro.get(0);
		
		
		List<Comuni> lp = ts.get_all_comuni(pro.getSigla());
		out.println("<option> Comune </option>");
		for (int i = 0; i < lp.size(); i++) {
			out.println("<option>" + lp.get(i).getNome_comune() + "</option>");
		}
	}
>>>>>>> branch 'Test_fornaro_turrini' of https://github.com/Fabiocoluccia93/BootJobs.git

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
