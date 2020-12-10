package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootjobs.model.Provincia;
import com.bootjobs.model.*;

/**
 * Servlet implementation class Province_controller
 */
public class Province_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Province_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		EntityManager em = Dao.newInstance().createEntityManager();
		EntityTransaction entr = em.getTransaction();
		Query query = em.createQuery("getProvince");
		List<Provincia> pro= new ArrayList<Provincia>();
//	query.setParameter("codiceistat", 1);
		System.out.println("sono nel controller");
		entr.begin();
		pro =  query.getResultList();
		entr.commit();
		em.close();
		
		for(int i = 0; i<pro.size();i++) {
			out.println("<option>" + pro.get(i).getNome_provincia()+"</option>");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
