package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundRobinScheduler implements Scheduler {

  private int numTimesEnabled = 0;
  private Integer t = -1;

  @Override
  public int chooseThread(ConcurrentProgram program) throws DeadlockException {
    if (program.getEnabledThreadIds().isEmpty()) {
      throw new DeadlockException();
    } else {
      Set<Integer> enabledThreads = program.getEnabledThreadIds();
      numTimesEnabled++;
      if (numTimesEnabled == 0) {
        t = getSmallestId(enabledThreads);
        return t;
      } else {
        t = getSmallestIdLargerThant(enabledThreads);
        return t;
      }
    }
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

   private Integer getSmallestIdLargerThant(Set<Integer> ids) {
    Set<Integer> idsGreaterThant = new HashSet<>();
    for (Integer id : ids) {
      if (id > t) {
        idsGreaterThant.add(id);
      }
    }
    if (idsGreaterThant.isEmpty()) {
      return getSmallestId(ids);
    } else {
      return getSmallestId(idsGreaterThant);
    }
  }
}
