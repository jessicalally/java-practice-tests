
public class Postgraduate extends Student{
// WRITE YOUR CODE HERE

  private Academic supervisor;

  public Postgraduate(String login, String name, String email, Academic supervisor){
    super(login, name, email);
    this.supervisor = supervisor;
  }

  public Academic getSupervisor(){
    return supervisor;
  }

	
}
