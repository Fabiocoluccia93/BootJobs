package com.bootjobs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootjobs.model.Category;
import com.bootjobs.model.Category_service;

/**
 * Servlet implementation class Category_controller
 */
@WebServlet("/Category_controller")
public class Category_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Category_service ctgs = new Category_service();
		List<Category> ctg = ctgs.queryForCategory();
		ArrayList<String> categoria = new ArrayList<String>();
		for(int i=0; i<ctg.size(); i++) {
			Category c = ctg.get(i);
			c.getCategory_name();
            categoria.add(c.getCategory_name());
		}
		request.setAttribute("BootJobs", categoria);
        RequestDispatcher rs = request.getRequestDispatcher("/view/category.jsp");
        rs.include(request, response);
        

//        // get session scoped attribute
//        HttpSession session = request.getSession();
//        String sessionScope = (String)session.getAttribute("category_name");
//
//        // get request scoped attribute
//        String requestScope = (String)request.getAttribute("category_name");
//
//        // print response
//        response.setContentType("category/jsp");
//        PrintWriter out = response.getWriter();
//       
//        out.write("<p>sessionScope: " + sessionScope + "</p>");
//        out.write("<p>requestScope: " + requestScope + "</p>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
