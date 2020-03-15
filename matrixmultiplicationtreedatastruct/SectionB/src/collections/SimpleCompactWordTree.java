package collections;

import collections.exceptions.InvalidWordException;
import java.util.ArrayList;
import java.util.List;

public class SimpleCompactWordTree implements CompactWordsSet {

  private CompactWordsNode root;
  private int numElements;

  public SimpleCompactWordTree() {
    this.root = new CompactWordsNode(Character.MIN_VALUE, false);
    this.numElements = 0;
  }

  @Override
  public boolean add(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    return addHelper(word, root);
  }

  private boolean addHelper(String word, CompactWordsNode node) {
    if (word.isEmpty()){
      return false;
    }
    if (!node.getChildren().isEmpty()) {
      for (CompactWordsNode child : node.getChildren()) {
        if (child.getChar() == word.charAt(0)) {
          return addHelper(word.substring(1), child);
        }
      }
    }
    node.addChild(word);
    numElements++;
    return true;
  }

  @Override
  public boolean remove(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    return removeHelper(word, root);
  }

  private boolean removeHelper(String word, CompactWordsNode node) {
    for (CompactWordsNode child : node.getChildren()) {
      if (child.getChar() == word.charAt(0)) {
        if (word.length() == 1 && child.isWord()) {
          child.removeWord();
          numElements--;
          return true;
        } else if (word.length() == 1) {
          return false;
        } else {
          return removeHelper(word.substring(1), child);
        }
      }
    }
    return false;
  }

  @Override
  public boolean contains(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    return containsHelper(word, root);
  }

  private boolean containsHelper(String word, CompactWordsNode node) {
    for (CompactWordsNode child : node.getChildren()) {
      if (child.getChar() == word.charAt(0)) {
        if (word.length() == 1 && child.isWord()) {
          return true;
        } else if (word.length() == 1) {
          return false;
        } else {
          return containsHelper(word.substring(1), child);
        }
      }
    }
    return false;
  }

  @Override
  public int size() {
    // TO BE IMPLEMENTED
    return numElements;
  }

  @Override
  public List<String> uniqueWordsInAlphabeticOrder() {
    // TO BE IMPLEMENTED
   List<String> words = new ArrayList<>();
  }

  private List<String> uniqueWordsHelper(CompactWordsNode node){
    List<String> words = new ArrayList<>();
    for (CompactWordsNode child : node.getChildren()){
      if (child.isWord()){
        words.add()
      }
    }
  }

}
