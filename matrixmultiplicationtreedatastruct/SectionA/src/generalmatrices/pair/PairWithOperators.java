package generalmatrices.pair;

import generalmatrices.operators.RingElement;

public class PairWithOperators extends Pair implements RingElement<PairWithOperators> {

  // TODO: populate as part of Question 2

  public PairWithOperators(Integer coordX, Integer coordY){
    super(coordX, coordY);
  }

  @Override
  public PairWithOperators sum(PairWithOperators other) {
    int x = this.getCoordX() + other.getCoordX();
    int y = this.getCoordY() + other.getCoordY();
    return new PairWithOperators(x, y);
  }

  @Override
  public PairWithOperators product(PairWithOperators other) {
    int x = this.getCoordX() * other.getCoordX();
    int y = this.getCoordY() * other.getCoordY();
    return new PairWithOperators(x, y);
  }


}
