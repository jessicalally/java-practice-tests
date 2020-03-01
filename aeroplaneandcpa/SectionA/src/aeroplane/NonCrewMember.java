package aeroplane;

public abstract class NonCrewMember extends Passenger {

  private static final int ADULT_AGE = 18;
  protected int age;

  protected NonCrewMember(String firstName, String secondName, int age){
    super(firstName, secondName);
    if (validAge(age)){
      this.age = age;
    } else {
      throw new IllegalArgumentException("Age must be non-negative.");
    }

  }

  @Override
  public boolean isAdult() {
    return age >= ADULT_AGE;
  }

  protected boolean validAge(int age){
    return age >= 0;
  }

  @Override
  public String toString(){
    return super.toString() + ", Age: " + age;
  }

}
