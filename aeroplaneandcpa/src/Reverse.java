import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Reverse {

  public static void main(String[] args) throws IOException {
    Deque<String> text = new ArrayDeque<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    while (line != null) {
      text.push(line);
      line = br.readLine();
    }

    while (!text.isEmpty()){
      System.out.println(text.pop());
    }
  }

}
