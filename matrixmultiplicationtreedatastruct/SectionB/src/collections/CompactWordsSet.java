package collections;

import collections.exceptions.InvalidWordException;
import java.util.List;

public interface CompactWordsSet {

  static void checkIfWordIsValid(String word) throws InvalidWordException {
    // TO BE IMPLEMENTED
    if (word == null || word.isEmpty()){
      throw new InvalidWordException("Input null or empty.");
    } else {
      if (word.chars().filter(c -> c < 97 || c > 122).count() > 0) {
        throw new InvalidWordException("Characters must be in range a to z.");
      }
    }
  }

  boolean add(String word) throws InvalidWordException;

  boolean remove(String word) throws InvalidWordException;

  boolean contains(String word) throws InvalidWordException;

  int size();

  List<String> uniqueWordsInAlphabeticOrder();

}
