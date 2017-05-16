import java.util.*;

public class PriorityQueueUsage {
  static class PQsort implements Comparator<Integer> {
    public int compare(Integer one, Integer two) {
      return two - one;
    }
  }

  public static void main(String[] args) {
    int[] ia = {1, 5, 3, 7, 6, 9, 8};
    // use natural order
    PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

    for(int x : ia)
      pq1.offer(x);
    for(int x : ia)
      System.out.print(pq1.poll() + " ");   // 1 3 5 6 7 8 9
    System.out.println();

    PQsort pqs = new PQsort();    // use Comparator
    PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);

    for(int x : ia)
      pq2.offer(x);
    System.out.println("size " + pq2.size());   // 7
    System.out.println("peek " + pq2.peek());   // 9
    System.out.println("size " + pq2.size());   // 7
    System.out.println("poll " + pq2.poll());   // 9
    System.out.println("size " + pq2.size());   // 6
    for(int x : ia)
      System.out.print(pq2.poll() + " ");   // 8 7 6 5 3 1 null
    System.out.println();
  }
}

