package packPractice;

public class UserBean 
{
	private String username;
	private int password;
	
	UserBean()
	{
		
	}
	
	public UserBean(String username, int password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + "]";
	}

}
