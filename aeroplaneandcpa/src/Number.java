public class Number {

  private static int next(int x) {
    if (x % 2 == 0) {
      return x / 2;
    } else {
      return 3 * x + 1;
    }
  }

  public static void main(String[] args) {
    int num = Integer.parseInt(args[0]);
    System.out.print(num);
    while (num != 1) {
      num = next(num);
      System.out.print(" " + num);
    }

  }

}
