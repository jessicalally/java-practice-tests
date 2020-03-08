package concurrency.statements;

import concurrency.Store;
import concurrency.expressions.Expr;

public class WaitStmt implements Stmt {

  private Expr left;
  private Expr right;

  public WaitStmt(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }

  public boolean isEnabled(Store store){
    return left.eval(store) == right.eval(store);
  }

  @Override
  public void execute(Store store) {

  }

}
