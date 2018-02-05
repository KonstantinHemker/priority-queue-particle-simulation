//package simulation;
package utils;

//import MinPriorityQueue.MinPriorityQueue;

  public class Test {
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
