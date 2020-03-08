package concurrency;

import concurrency.schedulers.RoundRobinScheduler;
import java.util.LinkedList;
import java.util.List;

import concurrency.schedulers.Scheduler;

public class Executor {

	private ConcurrentProgram program;
	private Scheduler scheduler;

	public Executor(ConcurrentProgram program, Scheduler scheduler) {
		this.program = program;
		this.scheduler = scheduler;
	}

	/**
	 * Executes program with respect to scheduler
	 *
	 * @return the final state and history of execution
	 */
	public String execute() {
		List<Integer> history = new LinkedList<Integer>();
		boolean deadlockOccurred = false;

		// TODO: Add code here to complete Question 3
		while (!program.isTerminated() && !deadlockOccurred){
			try {
				int id = scheduler.chooseThread(program);
				history.add(id);
				program.step(id);
			} catch (DeadlockException e){
				deadlockOccurred = true;
			}
		}

		StringBuilder result = new StringBuilder();
		result.append("Final state: " + program + "\n");
		result.append("History: " + history + "\n");
		result.append("Termination status: "
				+ (deadlockOccurred ? "deadlock" : "graceful") + "\n");
		return result.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Executor) {
			Executor other = (Executor) that;
			return this.program.toString().equals(other.program.toString());
		} else {
			return false;
		}
	}

}
