package aeroplane;

public class CrewMember extends Passenger {

 public CrewMember(String firstName, String secondName){
    super(firstName, secondName);
    this.passengerType = "Crew Member";
  }

  @Override
  public boolean isAdult() {
    return true;
  }

 }
