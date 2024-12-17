package com.demo.controller;

import java.io.IOException;

import com.demo.beans.PersonalInfo;
import com.demo.service.PersonalInfoService;
import com.demo.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPersonalInfoServlet
 */
@WebServlet("/RegisterPersonalInfoServlet")
public class RegisterPersonalInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	public RegisterPersonalInfoServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PersonalInfoService personalInfoService = new PersonalInfoService();
		
		String error = Utils.isPersonalInfoRegRequestParamsValid(request);

		if (error == null) {
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String middlename = request.getParameter("middlename");
			String gender = request.getParameter("gender");

			PersonalInfo personalInfo = new PersonalInfo();
			personalInfo.setFirstname(firstname);
			personalInfo.setLastname(lastname);
			personalInfo.setGender(gender);
			personalInfo.setMiddlename(middlename);
			
			int personalInfoId = personalInfoService.registerPersonalInfo(personalInfo);
			
			if(personalInfoId > 0) {
				request.getSession().setAttribute("personalId", personalInfoId);
				response.sendRedirect("ContactInfo.jsp");
			}
			else {
				request.setAttribute("error", "Error in inserting the personalinfo to db");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
