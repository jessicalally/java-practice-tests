package cells;

import java.util.Comparator;
import java.util.LinkedList;

public class BackedUpCellComparator<U> implements Comparator<BackedUpCell<U>> {

  private Comparator<U> valueComparator;

  public BackedUpCellComparator(Comparator<U> valueComparator) {
    this.valueComparator = valueComparator;
  }

  @Override
  public int compare(BackedUpCell<U> first, BackedUpCell<U> second) {
    LinkedList<U> firstValues = new LinkedList<>();
    LinkedList<U> secondValues = new LinkedList<>();

    if (first.isSet() && !second.isSet()) {
      return 1;
    } else if (!first.isSet() && second.isSet()) {
      return -1;
    } else if (first.isSet() && second.isSet()) {
      while (first.hasBackup() && second.hasBackup()) {
        int result = valueComparator.compare(first.get(), second.get());
        if (result != 0){
          for (U value : firstValues){
            first.set(value);
          }
          for (U value : secondValues){
            second.set(value);
          }
          return result;
        }
        firstValues.add(first.get());
        secondValues.add(second.get());
        first.revertToPrevious();
        second.revertToPrevious();
      }
      int result = valueComparator.compare(first.get(), second.get());
      if (result != 0) {
        for (U value : firstValues){
          first.set(value);
        }
        for (U value : secondValues){
          second.set(value);
        }
        return result;
      } else {
        if (first.hasBackup()) {
          for (U value : firstValues){
            first.set(value);
          }
          for (U value : secondValues){
            second.set(value);
          }
          return 1;
        } else if (second.hasBackup()) {
          for (U value : firstValues){
            first.set(value);
          }
          for (U value : secondValues){
            second.set(value);
          }
          return -1;
        }
      }
    }
    for (U value : firstValues){
      first.set(value);
    }
    for (U value : secondValues){
      second.set(value);
    }
    return 0;
  }
}
