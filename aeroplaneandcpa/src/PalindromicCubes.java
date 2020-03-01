public class PalindromicCubes {

  private static boolean isPalindrome(int x) {
    String num = String.valueOf(x);
    int l = num.length();
    for (int i=0;  i < l; i++) {
      if (num.charAt(i) != num.charAt(l-i-1)){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    for (int number=0; number < 2000; number++) {
      int cube = number * number * number;
      if (isPalindrome(cube)){
        System.out.println(number + " cubed is " + cube);
      }
    }
  }

}
