package cells;

import java.util.LinkedList;

public class BackedUpMutableCell<T> extends MutableCell<T> implements BackedUpCell<T> {

  private LinkedList<T> values;
  private final Mode mode;
  private final int limit;


  public BackedUpMutableCell(){
    super();
    this.values = new LinkedList<>();
    this.mode = Mode.UNBOUNDED;
    this.limit = Integer.MAX_VALUE;
  }

  public BackedUpMutableCell(int limit){
    super();
    if (limit < 0){
      throw new IllegalArgumentException();
    } else {
      this.values = new LinkedList<>();
      this.mode = Mode.BOUNDED;
      this.limit = limit;
    }
  }

  @Override
  public void set(T value){
    if (this.isSet()){
      values.add(this.get());
      if (mode.equals(Mode.BOUNDED) && values.size() > limit){
        values.removeFirst();
      }
    }
    super.set(value);
  }

  @Override
  public boolean hasBackup() {
    if (values.isEmpty()){
      return false;
    }
    return true;
  }

  @Override
  public void revertToPrevious() {
    if (values.isEmpty()){
      throw new UnsupportedOperationException();
    } else {
      super.set(values.getLast());
      values.removeLast();
    }
  }
  
}
