package collections;

import java.util.ArrayList;

public class CompactWordsNode {

  private char chr;
  private boolean isWord;
  private ArrayList<CompactWordsNode> children;

  public CompactWordsNode(char chr, boolean isWord){
    this.chr = chr;
    this.isWord = isWord;
    this.children = new ArrayList<>();
  }

  public char getChar(){
    return chr;
  }

  public boolean isWord(){
    return isWord;
  }

  public ArrayList<CompactWordsNode> getChildren(){
    return children;
  }

  public void removeWord(){
    isWord = false;
  }


  public void addChild(String word){
    if (word.length() == 1){
      CompactWordsNode next = new CompactWordsNode(word.charAt(0), true);
      children.add(next);
    } else {
      CompactWordsNode next = new CompactWordsNode(word.charAt(0), false);
      next.addChild(word.substring(1));
    }
  }
}
