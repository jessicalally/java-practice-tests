package aeroplane;

public abstract class Passenger {

	// TODO: Section A, Task 2

  protected String firstName;
  protected String secondName;
  protected String passengerType;

  protected Passenger(String firstName, String secondName){
    this.firstName = firstName;
    this.secondName = secondName;
  }

  public abstract boolean isAdult();

  public String toString(){
    return passengerType + ": " + firstName + " " + secondName;
  }

}
