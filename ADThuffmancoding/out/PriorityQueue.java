public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>{

	private E[] items;    //a heap of HuffmanTrees
	private final static int max_size = 256;
	private int size;    //number of HuffManTrees in the heap.
	
	
	public PriorityQueue( ) {
        // constructor which creates an empty heap
		items = (E[]) new Comparable[max_size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}

	public E getMin(){
		E root = null;
		if (!isEmpty()) root = items[0];
		return root;
	}
	
	public void add(E newEntry) throws PriorityQueueException{
	// post: Adds a new entry to the priority queue according to 
        // the priority value.
	// ADD YOUR CODE HERE
	}
 				
 	public E removeMin(){
	// post: Removes the minimum valued item from the PriorityQueue
		E root = null;
		if (!isEmpty()){
			root = items[0];
			items[0] = items[size-1];
			size--;
			heapRebuild(0);
		}
		return root;
	}
	
	private void heapRebuild(int root){
	// Rebuild heap to keep it ordered
	// ADD YOUR CODE HERE
	}
}
