package assign.validation;

import java.io.*;
import assign.interfaces.ErrorMessageCodes;

/**
 * 
 * EMailValidation
 *
 */

public class EMailValidation {
	
	public EMailValidation() {
		super();
	}

	private boolean isValidEmail(String inEMailId) {
		return (inEMailId.indexOf(".") > 2) && (inEMailId.indexOf("@") > 0);
	}

	public String validateEmailAddress(String inEMailId){
	// takes care of a@B. It won't take a@a.c mainly it won't take care after . com
		if (inEMailId.equals("")){
			return ErrorMessageCodes.EMAIL_ID_NULL;
		} else {
			if (!isValidEmail(inEMailId)) {
				return ErrorMessageCodes.EMAIL_ID_INVALID;
			}
		}
	   return "";
	}
	
	private boolean isFieldBlankOrNull(String field){
		if (field == null || field.trim().equals("")){
			return true;
		}
		return false;
	}
	
	public String validateFirstName(String firstName){
		if (isFieldBlankOrNull(firstName)){
			return ErrorMessageCodes.FIRST_NAME_IS_BLANK;
		}	
		return "";
	}
	
	public String validateLastName(String lastName){
		if (isFieldBlankOrNull(lastName)){
			return ErrorMessageCodes.LAST_NAME_IS_BLANK;
		}	
		return "";
	}
	
	public String validateMiddleName(String middleName){
		if (isFieldBlankOrNull(middleName)){
			return ErrorMessageCodes.MIDDLE_NAME_IS_BLANK;
		}	
		return "";
	}
	
	public String validateHomePhone(String homePhone){
		if (isFieldBlankOrNull(homePhone)){
			return ErrorMessageCodes.HOME_PHONE_IS_BLANK;
		}	
		return "";
	}
	
	public String validateWorkPhone(String workPhone){
		if (isFieldBlankOrNull(workPhone)){
			return ErrorMessageCodes.WORK_PHONE_IS_BLANK;
		}	
		return "";
	}
	
	public String validateMobilePhone(String mobilePhone){
		if (isFieldBlankOrNull(mobilePhone)){
			return ErrorMessageCodes.MOBILE_PHONE_IS_BLANK;
		}	
		return "";
	}
	
	public String validateGroupId(String groupId){
		if (isFieldBlankOrNull(groupId)){
			return ErrorMessageCodes.GROUP_ID_IS_BLANK;
		}	
		return "";
	}
	
	
}
 
