package assign.interfaces;

 
/**
 * 
 * ErrorMessageCodes
 *
 */

public interface ErrorMessageCodes {
	//addemailaddress page errors
	String EMAIL_ID_NULL = "EMailID Required<br>";
	public static final String EMAIL_ID_INVALID = "Invalid EMailId. for eg: a@b.c<br>";
	public static final String FIRST_NAME_IS_BLANK = "First Name is blank<br>";
	public static final String LAST_NAME_IS_BLANK = "Last Name is blank<br>";
	public static final String MIDDLE_NAME_IS_BLANK = "Middle Name is blank<br>";
	public static final String HOME_PHONE_IS_BLANK = "Home Phone is blank<br>";
	public static final String MOBILE_PHONE_IS_BLANK = "Mobile Phone is blank<br>";
	public static final String WORK_PHONE_IS_BLANK = "Work Phone is blank<br>";
	public static final String GROUP_ID_IS_BLANK = "Group Id is blank<br>";
	
	public static final String HOME_PAGE = "/jsp/home.jsp";
}
 
