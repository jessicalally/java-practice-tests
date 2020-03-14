package generalmatrices.matrix;

import java.lang.reflect.Array;
import java.util.List;

public class Matrix<T> {

  private final T[][] matrix;
  private final int order;

  public Matrix(List<T> elements){
    if (elements.isEmpty()){
      throw new IllegalArgumentException();
    } else {
      this.order = (int) Math.sqrt(elements.size());
      this.matrix = (T[][]) new Object[order][order];
      for (int i = 0; i < order; i++){
        for (int j = 0; j < order; j++){
          matrix[i][j] = elements.get(i * order + j);
        }
      }
    }
  }

  // TODO: populate as part of Question 1 and Question 3

  public T get(int row, int col){
    return matrix[row][col];
  }

  public int getOrder(){
    return order;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < order; i++){
      sb.append('[');
      for (int j = 0; j < order; j++){
        sb.append(matrix[i][j] + " ");
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
    }
    sb.append(']');
    return sb.toString();
  }

}
