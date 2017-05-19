import java.util.*;

public class QueueUsage {
  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    System.out.println(queue.offer(10));  // true
    System.out.println(queue.offer(4));   // true
    System.out.println(queue.peek());     // 10
    System.out.println(queue.poll());     // 10
    System.out.println(queue.poll());     // 4
    System.out.println(queue.peek());     // null

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    stack.push(10);
    stack.push(4);
    System.out.println(stack.peek());     // 4
    System.out.println(stack.poll());     // 4
    System.out.println(stack.poll());     // 10
    System.out.println(stack.peek());     // null

    Queue<Integer> q = new LinkedList<>();
    q.add(10);
    q.add(12);
    q.remove(1);    // remove(Object o)
    System.out.println(q);  // [10, 12]
  }
}

