
public class Undergraduate extends Student  {
	private Academic tutor;

	public Academic getTutor() {
		return tutor;
	}

	public Undergraduate(String login, String name,
			String email, Academic tutor) {
		super(login, name, email);
		this.tutor = tutor;
	}

	public void setTutor(Academic tutor) {
		this.tutor = tutor;
	}
	
}
