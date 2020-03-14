package generalmatrices.matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Matrix<T> {

  private final T[][] matrix;
  private final int order;

  public Matrix(List<T> elements) {
    if (elements.isEmpty()) {
      throw new IllegalArgumentException();
    } else {
      this.order = (int) Math.sqrt(elements.size());
      this.matrix = (T[][]) new Object[order][order];
      for (int i = 0; i < order; i++) {
        for (int j = 0; j < order; j++) {
          matrix[i][j] = elements.get(i * order + j);
        }
      }
    }
  }

  // TODO: populate as part of Question 1 and Question 3

  public T get(int row, int col) {
    return matrix[row][col];
  }

  public int getOrder() {
    return order;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < order; i++) {
      sb.append('[');
      for (int j = 0; j < order; j++) {
        sb.append(matrix[i][j] + " ");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
    }
    sb.append(']');
    return sb.toString();
  }

  public Matrix<T> sum(Matrix<T> other, BinaryOperator<T> elementSum) {
    List<T> elements = new ArrayList<>();
    for (int i = 0; i < order; i++) {
      for (int j = 0; j < order; j++) {
        elements.add(elementSum.apply(this.get(i, j), other.get(i, j)));
      }
    }
    return new Matrix<>(elements);
  }

  public Matrix<T> product(Matrix<T> other, BinaryOperator<T> elementSum,
      BinaryOperator<T> elementProduct) {
    List<T> elements = new ArrayList<>();
    // row
    for (int i = 0; i < order; i++) {
      // column
      for (int j = 0; j < order; j++) {
        // elem in row/column
        List<T> tempElems = new ArrayList<>();
        for (int k = 0; k < order; k++) {
          tempElems.add(elementProduct.apply(this.get(i, k), other.get(k, j)));
        }
        T temp;
        if (order > 1){
          temp = elementSum.apply(tempElems.get(0), tempElems.get(1));
          for (int k = 2; k < order; k++){
            temp = elementSum.apply(temp, tempElems.get(k));
          }
        } else {
          temp = tempElems.get(0);
        }
        elements.add(temp);
      }
    }
    return new Matrix<>(elements);
  }

}
