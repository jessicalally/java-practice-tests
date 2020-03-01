import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryNumbers {

  private Random generator;

  public LotteryNumbers(){
    this.generator = new Random();
  }

  private List<Integer> getNumbers(){
    List<Integer> nums = new ArrayList<>();
    while (nums.size() < 7) {
      int x = generator.nextInt(49) + 1;
      if (!nums.contains(x)){
        nums.add(x);
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    LotteryNumbers numbers = new LotteryNumbers();
    List<Integer> chosenNums = numbers.getNumbers();
    for (int i=0; i< chosenNums.size() - 1; i++) {
      System.out.println("Number " + i +": " + chosenNums.get(i));
    }
    System.out.println("Bonus Number: " + chosenNums.get(6));
  }
}
