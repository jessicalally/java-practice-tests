import java.util.HashSet;
import java.util.Set;

public class Course {

	/* WRITE YOUR CODE HERE */

  private Set<Student> students;
  private String name;

  public Course(String name, Set<Student> students){
    this.students = students;
    this.name = name;
  }

  public Set<Postgraduate> getPostgraduates(String nameOfSupervisor){
    Set<Postgraduate> postgraduates = new HashSet<>();
    for (Student student : students){
      if (student instanceof Postgraduate){
        Postgraduate postgraduate = (Postgraduate) student;
        if (postgraduate.getSupervisor().getName().equals(nameOfSupervisor)){
          postgraduates.add(postgraduate);
        }
      }
    }
    return postgraduates;
  }

}
