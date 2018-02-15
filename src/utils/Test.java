//package simulation;
package utils;
//import MinPriorityQueue.MinPriorityQueue;
//from utils import MinPriorityQueue;

public class Test {
    public static void main(String[] args)
    {
      MinPriorityQueue instance = new MinPriorityQueue();
      System.out.println("*****************");

      for (int i = 10; i > 0; i--) {
        instance.add(i);
        //instance.print_q();
	System.out.println("");
	System.out.println("*****************");
      }

      for (int i = 1; i <= 10; i++) {
	       instance.remove();
        //instance.print_q();
	System.out.println("");
	System.out.println("*****************");
      }


    }
  }
