package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;
import concurrency.statements.Stmt;
import concurrency.statements.WaitStmt;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FewestWaitsScheduler implements Scheduler {

  @Override
  public int chooseThread(ConcurrentProgram program) throws DeadlockException {
    Set<Integer> enabledThreads = program.getEnabledThreadIds();
    if (enabledThreads.isEmpty()){
      throw new DeadlockException();
    } else {
      Set<Integer> smallestWaitThreads = new HashSet<>();
      int smallestWaitsSoFar = calculateWait(program, (Integer) enabledThreads.toArray()[0]);
      for (Integer thread : enabledThreads){
        int wait = calculateWait(program, thread);
        if (wait < smallestWaitsSoFar){
          smallestWaitThreads.clear();
          smallestWaitThreads.add(thread);
        } else if (wait == smallestWaitsSoFar){
          smallestWaitThreads.add(thread);
        }
      }
      return getSmallestId(smallestWaitThreads);
    }
  }

  private int calculateWait(ConcurrentProgram program, Integer id){
    Collection<? extends Stmt> statements = program.remainingStatements(id);
    int numWaits = 0;
    for (Stmt statement : statements){
      if (statement instanceof WaitStmt){
        numWaits++;
      }
    }
    return numWaits;
  }


  private Integer getSmallestId(Set<Integer> ids) {
    Integer smallestSoFar = (Integer) ids.toArray()[0];
    for (Integer id : ids) {
      if (id < smallestSoFar) {
        smallestSoFar = id;
      }
    }
    return smallestSoFar;
  }

}
