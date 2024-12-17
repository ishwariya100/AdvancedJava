package com.demo.controller;

import java.io.IOException;

import com.demo.beans.ContactInfo;
import com.demo.beans.PersonalInfo;
import com.demo.service.ContactInfoService;
import com.demo.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterContactInfoServlet
 */
@WebServlet("/RegisterContactInfoServlet")
public class RegisterContactInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterContactInfoServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ContactInfoService contactInfoService = new ContactInfoService();
		
		String error = Utils.isContactInfoRegRequestParamsValid(request);

		if (error == null) {

			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String phone = request.getParameter("phone");
			
			ContactInfo contactInfo = new ContactInfo();
			contactInfo.setAddress(address);
			contactInfo.setCity(city);
			contactInfo.setState(state);
			contactInfo.setCountry(country);
			contactInfo.setPhone(phone);
			contactInfo.setPersonalInfoId((int)request.getSession().getAttribute("personalId"));

			int contactInfoId = contactInfoService.registerContactInfo(contactInfo);

			if (contactInfoId > 0) {
				request.getSession().setAttribute("contactInfoId", contactInfoId);
				response.sendRedirect("BankInfo.jsp");
			} else {
				request.setAttribute("error", "Error in inserting the contactinfo to db");
				request.getRequestDispatcher("ContactInfo.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", error);
			request.getRequestDispatcher("ContactInfo.jsp").forward(request, response);
		}

	}

}
