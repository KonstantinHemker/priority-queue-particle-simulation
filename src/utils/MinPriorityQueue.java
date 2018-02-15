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


    /* TEMPORARY TESTING FUNCTION */
    /*
    public int compare_to(double x1, double x2) {
      if (x1 > x2)
        return 1;

      if (x1 == x2)
        return 0;

      return -1;
    }*/

    /**
     * Removes, and returns, the element at the front of the queue.
     */
     /*
    public T remove() {
        // TODO implement this method
        return null;
    }*/

/*
    private void print_section(double width,int type){

	if (type == 1){
	   for (int spacing=1;spacing <= (width);spacing++)
	       System.out.print(" ");
	   System.out.print("|");
	   for (int spacing=1;spacing < (width);spacing++)
	       System.out.print("_");

	}else{
	   for (int spacing=1;spacing < (width);spacing++)
	       System.out.print("_");
	   System.out.print("|");
	   for (int spacing=1;spacing <= (width);spacing++)
	       System.out.print(" ");
	}



    }

    public void print_q () {
      double depth = 1;
      double width = Math.ceil(queue_length/2);
      int increment = 1;


      //for (int i = 1; i < end_ptr; i++) {
        //System.out.println(queue[i]);
	//}

      for (int i = 1; i < end_ptr; i++) {

	  print_section(width,1);
        System.out.print((int) queue[i]);
	print_section(width,2);

	if (i == depth*2-1){
	    depth = depth*2;
	    width = Math.ceil(queue_length/depth/2);
	    System.out.println(" ");
	    System.out.println(" ");
	}
      }
    }
*/
    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return false;
    }

    public static void main(String [] args)
    {
	MinPriorityQueue instance = new MinPriorityQueue();

    }


}
