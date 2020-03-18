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
		if (size == max_size){
			throw new PriorityQueueException("Priority queue is full.");
		} else {
			items[size] = newEntry;
			int position = size;
			int parent = (size - 1) / 2;
			while (parent > 0 && items[position].compareTo(items[parent]) < 0){
				E temp = items[position];
				items[position] = items[parent];
				items[parent] = temp;
				position = parent;
				parent = (position - 1) / 2;
			}
			size++;
		}
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
		int left = root * 2 + 1;
		if (left < size){
			int right = left + 1;
			int minI;
			if (items[left].compareTo(items[right]) < 0){
				E min = items[left];
				minI = left;
			} else {
				E min = items[right];
				minI = right;
			}
			if (items[minI].compareTo(items[root]) < 0){
				E temp = items[minI];
				items[minI] = items[root];
				items[root] = temp;
				heapRebuild(minI);
			}
		}

	}
}
