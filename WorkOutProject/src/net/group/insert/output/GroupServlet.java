package net.group.insert.output;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/")

public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GroupDao groupDAO;
	
	public void init() {
		groupDAO = new GroupDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertGroup(request, response);
				break;
			case "/delete":
				deleteGroup(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateGroup(request, response);
				break;
			case "/list":
				listGroup(request, response);
				break;
			default:
				printGroup(request, response);
				break;
				
				
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void printGroup(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Group> printGroup = groupDAO.printGroup();
		request.setAttribute("printGroup", printGroup);
		RequestDispatcher dispatcher = request.getRequestDispatcher("printpage.jsp");
		dispatcher.forward(request, response);
	}


	private void listGroup(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Group> listGroup = groupDAO.selectAllGroup();
		request.setAttribute("listGroup", listGroup);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listpage.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		Group existingGroup = groupDAO.selectGroup(num);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("group", existingGroup);
		dispatcher.forward(request, response);

	}

	private void insertGroup(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		int groupnum =Integer.parseInt(request.getParameter("groupnum"));
		String setsnum =request.getParameter("setsnum");
		String sport = request.getParameter("sport");
		int distance =Integer.parseInt(request.getParameter("distance"));
		int split =Integer.parseInt(request.getParameter("split"));
		Group newGroup = new Group(name, groupnum, setsnum, sport, distance, split);
		groupDAO.insertGroup(newGroup);
		response.sendRedirect("list");
	}

	private void updateGroup(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int groupnum =Integer.parseInt(request.getParameter("groupnum"));
		String setsnum =request.getParameter("setsnum");
		String sport = request.getParameter("sport");
		int distance =Integer.parseInt(request.getParameter("distance"));
		int split =Integer.parseInt(request.getParameter("split"));
		Group book = new Group(name, groupnum, setsnum, sport, distance, split);
		groupDAO.updateGroup(book);
		response.sendRedirect("list");
	}

	private void deleteGroup(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int  num = Integer.parseInt(request.getParameter("num"));
		groupDAO.deleteGroup(num);
		response.sendRedirect("list");

	}

}














	