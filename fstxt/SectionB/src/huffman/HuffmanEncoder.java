package huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class HuffmanEncoder {

  final HuffmanNode root;
  final Map<String, String> word2bitsequence;

  private HuffmanEncoder(HuffmanNode root,
      Map<String, String> word2bitSequence) {
    this.root = root;
    this.word2bitsequence = word2bitSequence;
  }

  private HuffmanNode getRoot(){
    return this.root;
  }

  public static HuffmanEncoder buildEncoder(Map<String, Integer> wordCounts) {
    //TODO: complete the implementation of this method (Q1)

    if (wordCounts == null) {
      throw new HuffmanEncoderException("wordCounts cannot be null");
    }
    if (wordCounts.size() < 2) {
      throw new HuffmanEncoderException("This encoder requires at least two different words");
    }

    // fixing the order in which words will be processed: this determinize the execution and makes
    // tests reproducible.
    TreeMap<String, Integer> sortedWords = new TreeMap<String, Integer>(wordCounts);
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(sortedWords.size());

    //YOUR IMPLEMENTATION HERE...
    HuffmanNode root;
    Map<String, String> word2bitSequence = new HashMap<>();

    Set<String> words = wordCounts.keySet();

    for (String word : words) {
      HuffmanNode next = new HuffmanLeaf(wordCounts.get(word), word);
      queue.add(next);
    }

    while (queue.size() > 1) {
      HuffmanNode first = queue.poll();
      HuffmanNode second = queue.poll();
      HuffmanNode newNode = new HuffmanInternalNode(first, second);
      queue.add(newNode);
    }

    root = queue.poll();
    word2bitSequence = encodeSequence(root, "", word2bitSequence);

    return new HuffmanEncoder(root, word2bitSequence);
  }

  private static Map<String, String> encodeSequence(HuffmanNode node, String sequence,
      Map<String, String> word2BitSequence) {
    for (String word : word2BitSequence.keySet()) {
      System.out.println(word + ", " + word2BitSequence.get(word));
    }

    if (node instanceof HuffmanLeaf) {
      word2BitSequence.put(((HuffmanLeaf) node).word, sequence);
      return word2BitSequence;
    } else {
      HuffmanInternalNode internalNode = (HuffmanInternalNode) node;
      return encodeSequence(internalNode.right, sequence + "1",
          encodeSequence(internalNode.left, sequence + "0", word2BitSequence));
    }
  }


  public String compress(List<String> text) {
    assert text != null && text.size() > 0;

    //TODO: implement this method (Q2)

    StringBuilder sb = new StringBuilder();

    for (String word : text) {
      if (word2bitsequence.containsKey(word)) {
        sb.append(word2bitsequence.get(word));
      } else {
        throw new HuffmanEncoderException("Word has no binary encoding.");
      }
    }
    return sb.toString();

  }


  public List<String> decompress(String compressedText) {
    assert compressedText != null && compressedText.length() > 0;

    //TODO: implement this method (Q3)
    List<String> words = new ArrayList<>();
    return findWords(compressedText, root, words);
  }

  private List<String> findWords(String compressedText, HuffmanNode node, List<String> words) {
    if (node instanceof HuffmanLeaf) {
      words.add(((HuffmanLeaf) node).word);
      if (compressedText.isEmpty()) {
        return words;
      } else {
        return findWords(compressedText, getRoot(), words);
      }
    } else {
      for (int i = 0; i < compressedText.length(); i++) {
        char next = compressedText.charAt(i);
        HuffmanInternalNode nextNode = (HuffmanInternalNode) node;
        if (next == '0') {
          return findWords(compressedText.substring(1), nextNode.left, words);
        } else {
          return findWords(compressedText.substring(1), nextNode.right, words);
        }
      }
    }
    return words;
  }

  // Below the classes representing the tree's nodes. There should be no need to modify them, but
  // feel free to do it if you see it fit

  private static abstract class HuffmanNode implements Comparable<HuffmanNode> {

    private final int count;

    public HuffmanNode(int count) {
      this.count = count;
    }

    @Override
    public int compareTo(HuffmanNode otherNode) {
      return count - otherNode.count;
    }
  }


  private static class HuffmanLeaf extends HuffmanNode {

    private final String word;

    public HuffmanLeaf(int frequency, String word) {
      super(frequency);
      this.word = word;
    }
  }


  private static class HuffmanInternalNode extends HuffmanNode {

    private final HuffmanNode left;
    private final HuffmanNode right;

    public HuffmanInternalNode(HuffmanNode left, HuffmanNode right) {
      super(left.count + right.count);
      this.left = left;
      this.right = right;
    }
  }
}
