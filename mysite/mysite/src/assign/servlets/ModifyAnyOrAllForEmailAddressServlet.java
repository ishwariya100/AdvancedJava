package assign.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/**
 * Servlet implementation class ModifyAnyOrAllForEmailAddressServlet
 */

public class ModifyAnyOrAllForEmailAddressServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyAnyOrAllForEmailAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errors = "";
		
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String workPhone = request.getParameter("wphone");
		String homePhone = request.getParameter("hphone");
		String mobilePhone = request.getParameter("mphone");
		String groupId = request.getParameter("groupId");
		
		EMailAddressVOO eMailAddressVO = (EMailAddressVOO)request.getSession().getAttribute("emailVO");
		
		if(firstName != null && !(firstName.trim().equals(""))) {
			eMailAddressVO.setfName(firstName);
		}
		
		if(middleName != null && !(middleName.trim().equals(""))) {
			eMailAddressVO.setmName(middleName);
		}
		
		if(lastName != null && !(lastName.trim().equals(""))) {
			eMailAddressVO.setlName(lastName);
		}
		
		if(workPhone != null && !(workPhone.trim().equals(""))) {
			eMailAddressVO.setwPhone(workPhone);
		}
		
		if(homePhone != null && !(homePhone.trim().equals(""))) {
			eMailAddressVO.sethPhone(homePhone);
		}
		
		if(mobilePhone != null && !(mobilePhone.trim().equals(""))) {
			eMailAddressVO.setmPhone(mobilePhone);
		}
		
		if(groupId != null && !(groupId.trim().equals(""))) {
			eMailAddressVO.setgroupID(groupId);
		}
		
		 try{
			EMailBO eMailBO = new EMailBO();
		 	eMailBO.updateEMailAddress(eMailAddressVO);
		 }catch (EMailValidationException emve){
			 errors = emve.getErrorMessage();
		 }
		 catch (Exception e){
		 e.printStackTrace();
		 }
		
		 //step3: Response Back
			if (errors.equals("")) {
				response.sendRedirect("/mysite/home.jsp");
			} else {
				request.getSession().setAttribute("Errors", errors);
				response.sendRedirect("/mysite/modifycontact.jsp");
			}
	}

}
