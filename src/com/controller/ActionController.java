package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDAO;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ActionController() {
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("insert")) {
			UserBean s = new UserBean();
			s.setName(request.getParameter("name"));
			s.setPoints(Integer.valueOf(request.getParameter("points")));
			UserDAO.doInsert(s);
			response.sendRedirect("display.jsp");
		}
		else if (action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			UserBean s=UserDAO.getStudentById(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			}
		else if(action.equalsIgnoreCase("delete")){
			UserBean s=new UserBean();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			int beforePoints=Integer.valueOf(request.getParameter("beforePoints"));
			int currentPoints=Integer.valueOf(request.getParameter("points"));
			int score=beforePoints-currentPoints;
			s.setPoints(score<0?0:score);
			UserDAO.updateStudent(s);
			response.sendRedirect("display.jsp");
		}else if(action.equalsIgnoreCase("add")){
			UserBean s=new UserBean();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			int beforePoints=Integer.valueOf(request.getParameter("beforePoints"));
			int currentPoints=Integer.valueOf(request.getParameter("points"));
			s.setPoints(beforePoints+currentPoints);
			UserDAO.updateStudent(s);
			response.sendRedirect("display.jsp");
		}
	}

}
