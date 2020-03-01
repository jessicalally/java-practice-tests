package aeroplane;

import java.util.Objects;

public class Seat {

  // TODO: Section A, Tasks 1 and 3
  private final int row;
  private final char letter;
  private final static char FIRST_SEAT = 'A';
  private final static char LAST_SEAT = 'F';
  private final static int FIRST_ROW = 1;
  private final static int LAST_ROW = 50;
  private final static int[] EMERGENCY_EXITS = {1, 10, 30};

  public Seat(int row, char letter){
    if (vaildRow(row) && validLetter(letter)){
      this.row = row;
      this.letter = letter;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private boolean vaildRow(int row){
    return FIRST_ROW <= row && LAST_ROW >= row;
  }


  private boolean validLetter(char letter){
    return FIRST_SEAT <= letter && LAST_SEAT >= letter;
  }

  @Override
  public String toString(){
    return String.valueOf(row) + letter;
  }

  public boolean isEmergencyExit(){
    boolean isEmergencyExit = false;
    for (int i = 0; i < EMERGENCY_EXITS.length; i++){
      isEmergencyExit = isEmergencyExit || EMERGENCY_EXITS[i] == letter;
    }
    return isEmergencyExit;
  }

  public boolean hasNext(){
    return !(row == LAST_ROW && letter == LAST_SEAT);
  }

  public Seat next(){
    char nextLetter = (char) (letter + 1);
    if (nextLetter > LAST_SEAT){
      return new Seat(row + 1, FIRST_SEAT);
    } else {
      return new Seat(row, nextLetter);
    }
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Seat) {
      Seat otherSeat = (Seat) other;
      return otherSeat.letter == letter && otherSeat.row == row;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, letter);
  }
}
