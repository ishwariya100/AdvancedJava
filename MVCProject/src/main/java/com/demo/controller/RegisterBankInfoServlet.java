package com.demo.controller;

import java.io.IOException;

import com.demo.beans.BankInfo;
import com.demo.service.BankInfoService;
import com.demo.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterBankInfoServlet
 */
@WebServlet("/RegisterBankInfoServlet")
public class RegisterBankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterBankInfoServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BankInfoService bankInfoService = new BankInfoService();
		
		String error = Utils.isBankInfoRegRequestParamsValid(request);

		if (error == null) {
			
			String bankname = request.getParameter("bankname");
			String account = request.getParameter("account");
			String ssn = request.getParameter("ssn");

			BankInfo bankInfo = new BankInfo();
			bankInfo.setAccount(account);;
			bankInfo.setBankname(bankname);;
			bankInfo.setSsn(ssn);
			bankInfo.setPersonalInfoId((int)request.getSession().getAttribute("personalId"));
			
			int bankInfoId = bankInfoService.registerBankInfo(bankInfo);
			
			if(bankInfoId > 0) {
				request.getSession().setAttribute("bankInfoId", bankInfoId);
				response.sendRedirect("Success.html");
			}
			else {
				request.setAttribute("error", "Error in inserting the bankinfo to db");
				request.getRequestDispatcher("BankInfo.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("error", error);
			request.getRequestDispatcher("BankInfo.jsp").forward(request, response);
		}

	}
}
