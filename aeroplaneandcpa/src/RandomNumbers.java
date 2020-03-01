import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {

  public static void main(String[] args) {
    assert args.length == 1;
    int x = Integer.parseInt(args[0]);
    List<Integer> numsSoFar = new ArrayList<>();
    boolean[] found = new boolean[x];

    for (int i=0; i<x; i++) {
      found[i] = false;
    }

    Random generator = new Random();
    int numbersFound = 0;
    int numbersGenerated = 0;
    System.out.println("Generating random numbers:");
    while (numbersFound < x) {
      int num = generator.nextInt(x);
      System.out.println(num + ", ");
      numbersGenerated++;
      if(!found[num]) {
        found[num] = true;
        numbersFound++;
      }
    }

    System.out.println("I had to generate " + numbersGenerated + " random numbers between 0 and " + x + " to have produced all such numbers at least once.");

  }

}
