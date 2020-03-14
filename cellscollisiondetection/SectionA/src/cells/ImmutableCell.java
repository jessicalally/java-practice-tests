package cells;

public class ImmutableCell<T> implements Cell<T> {

  private final T value;

  public ImmutableCell(T value){
    if (value == null){
      throw new IllegalArgumentException();
    }
    this.value = value;
  }

  @Override
  public void set(T value) {
    throw new UnsupportedOperationException("Cell is immutable.");
  }

  @Override
  public T get() {
    return value;
  }

  @Override
  public boolean isSet() {
    return value != null;
  }

  @Override
  public boolean equals(Object other){
    if (other instanceof ImmutableCell){
      return value.equals(((ImmutableCell) other).value);
    }
    return false;
  }

}
