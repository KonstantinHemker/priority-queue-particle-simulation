package utils;



public class MinPriorityQueue<T extends Comparable<T>> {

  public int queue_length = 1;
  public T[] queue = (T[]) new Comparable[queue_length];
  //PCB[] res = (PCB[]) new Object[list.size()]; /* Not type-safe. */
  public int end_ptr;
    /**
     * Creates an empty queue.
     */
     public MinPriorityQueue() {
       // TODO implement the constructor
        //queue = new AbstractEvent[] {NULL};
        end_ptr = 1;
        queue_length = 1;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        //  implement this method
        return end_ptr-1;
    }

    public void resize() {
        queue_length = queue_length * 2;
        T[] newqueue = (T[]) new Comparable[queue_length];
        //T[] newqueue = new T[queue_length];
        java.lang.System.arraycopy(queue, 0, newqueue, 0, queue_length/2);
        queue = newqueue;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        if (queue_length == end_ptr)
          resize();
        queue[end_ptr] = elem;
        add_recursive(end_ptr);
	end_ptr += 1;
    }

    public void add_recursive(int location) {
      if (location == 1)
        return;
      int result = queue[location].compareTo(queue[location/2]);
      if (result >= 0)
        return;
      swap(location,location/2);
      add_recursive((location/2));
    }

    public Boolean can_remove(){
	if(end_ptr == 1){
	    return false;
	}
	return true;
    }

    public T remove(){
        T elem = queue[1];
        queue[1] = queue[end_ptr-1];
	       end_ptr = end_ptr -1;
        remove_recursive(1);
	return elem;
    }

    public void remove_recursive(int location) {
	int children;
	int result;
	int next_location;
      if (location*2 >= end_ptr)
        return;

      if(location*2+1 == end_ptr){
	  children = 1;
      }else{
	  children = queue[location*2].compareTo(queue[location*2+1]);
      }

      if(children < 0){
	  result = queue[location].compareTo(queue[location*2]);
	  next_location = location*2;
      }else{
	  result = queue[location].compareTo(queue[location*2+1]);
	  next_location = location*2+1;
      }

      if (result < 0)
        return;
      swap(location,next_location);
      remove_recursive(next_location);
    }

    public void swap(int index,int index2) {
      T temp;
      temp = queue[index];
      queue[index] = queue[index2];
      queue[index2] = temp;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return false;
    }

    public static void main(String [] args)
    {
	MinPriorityQueue instance = new MinPriorityQueue();

    }


}
