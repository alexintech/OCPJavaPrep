public class IsItFurry {
  static class Chipmunk { }
  public static void main(String[] args) {
    Runnable r = new Thread();
    if (r instanceof Chipmunk)  // compile successfully
      System.out.println(true);
  }
}

