package huffman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Counter extends Thread {

  private Map<String, Integer> result;
  private List<String> words;

  public Counter(List<String> words, int from, int to) {
    this.words = words.subList(from, to);
    this.result = new HashMap<>();
  }

  @Override
  public void run() {
    result = words.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
  }

  public Map<String, Integer> getResult() {
    return this.result;
  }
}
