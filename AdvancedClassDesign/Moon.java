abstract class Satellite {
  static {
    ctr = (int) (Math.random() * 100);
  }
  static final int ctr;
}
class Moon extends Satellite {
  public static void main(String[] args) {
    System.out.println(Moon.ctr);
  }
}

