
public class StaffItem {
	private String staffAccount;
	private String staffPassword;
	
	public StaffItem(String a, String p){
		staffAccount = a;
		staffPassword = p;
	}
	
	public String getStaffAccount(){
		return staffAccount;
	}
	public String getStaffPassword(){
		return staffPassword;
	}
	public void setStaffAccount(String a){
		staffAccount = a;
	}
	public void setStaffPassword(String p){
		staffPassword = p;
	}
	public boolean authenticate(String account, String pass){
		if ((account.equals(staffAccount))&&((pass.equals(staffPassword)))){
			return true;
		}
		return false;
	}
	
}
