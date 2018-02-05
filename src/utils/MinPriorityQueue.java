package utils;



public class MinPriorityQueue{//<T extends Comparable<T>> {

  public int queue_length;
  public double[] queue = new double[queue_length];
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
        double[] newqueue = new double[queue_length];
        java.lang.System.arraycopy(queue, 0, newqueue, 0, queue_length/2);
        queue = newqueue;
    }

    /**
     * Adds elem to the queue.
     */
    public void add(double elem) {
        if (queue_length == end_ptr)
          resize();

        queue[end_ptr] = elem;

        add_recursive(end_ptr);

        end_ptr += 1;

        // TODO implement this method
    }



    public void add_recursive(int location) {
      if (location == 1)
        return;


      int result = compare_to (queue[location], queue[location/2]);

      if (result >= 0)
        return;

      swap(location);

      add_recursive((location/2));

    }


    public void swap(int index) {
      double temp;
      temp = queue[index];
      queue[index] = queue[index/2];
      queue[index/2] = temp;
    }

    /* TEMPORARY TESTING FUNCTION */
    public int compare_to(double x1, double x2) {
      if (x1 > x2)
        return 1;

      if (x1 == x2)
        return 0;

      return -1;
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
     /*
    public T remove() {
        // TODO implement this method
        return null;
    }*/

    public void print_q () {
      for (int i = 0; i < end_ptr; i++) {
        System.out.println(queue[i]);
      }
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return false;
    }

}

/*
  class Test {
    public static void main()
    {
      MinPriorityQueue instance = new MinPriorityQueue();
      System.out.println("*****************");

      for (int i = 10; i > 0; i--) {
        instance.add(i);
        instance.print_q();
      }


    }
  }
*/
