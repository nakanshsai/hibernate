package com.zensar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exception.ServiceExceptions;

import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
* @author akansh_sai
* @version 2.0
* @creation_date 21st sep 2019 5.29PM
* @modification_date 28th sep 2019 11.47AM
* @copyright Zensar technologies. All rights reserved
* @description it is data access object interface.
* 			   it is used in persistance layer of application.
*
*
*/
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
private static final long serialVersionUID = 1L;
private UserService userService;

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
*      response)
*/
public void setUserService(UserService userService) {
this.userService = userService;
}

@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	UserDao userdao = new UserDaoImpl();
	UserService userservice = new UserServiceImpl();
	((UserServiceImpl) userservice).setUserdao(userdao);
	setUserService(userservice);
	}

public UserService getUserService() {
return userService;
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
*      response)
*/

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
	String username = request.getParameter("username");
	String password = request.getParameter("passwd");
	PrintWriter out = response.getWriter();
	User clientUser =new User();
	clientUser.setUsername(username);
	clientUser.setPassword(password);

//invoking logic of business layer in presentation layer

try {
if (userService.validateUser(clientUser)) {

/* out.println("<p>Dear " +username+" welcome to ZEN-SHOP</p>"); */
RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
rd.forward(request, response);
} else {
out.println("<p>sorry! invalid credentials</p>");
RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
rd.include(request, response);
}
} catch (ServiceExceptions e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}


}