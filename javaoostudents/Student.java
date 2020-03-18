
abstract public class Student extends Person implements Notifiable {

	private String login,  email;


	public void notify(String message) {
		System.out.println("email: " + email + ". Message: " + message);
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public Student(String login, String name, String email) {
		super(name);
		this.login = login;
		this.email = email;
	}

}
