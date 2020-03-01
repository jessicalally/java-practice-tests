package aeroplane;

public class BusinessClassPassenger extends NonCrewMember {

  private final Luxury luxury;

  public BusinessClassPassenger(String firstName, String secondName, int age, Luxury luxury){
      super(firstName, secondName, age);
      this.passengerType = "Business Class";
      this.luxury = luxury;
    }

  @Override
  public String toString(){
    return super.toString() + ", Luxury: " + luxury;
  }

  }

