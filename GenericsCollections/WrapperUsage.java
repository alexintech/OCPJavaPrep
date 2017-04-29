public class WrapperUsage {
  public static void main(String[] args) {
    Long var1 = new Long(123);        // every time creates new objects
    Long var2 = new Long(123);
    System.out.println(var1 == var2);   // false

    Long var3 = Long.valueOf(123);    // uses cached values for (-128 to 127)
    Long var4 = Long.valueOf(123);
    System.out.println(var3 == var4);   // true

    Long var5 = 123L;                 // uses cached values
    Long var6 = 123L;
    System.out.println(var5 == var6);   // true
    System.out.println(var3 == var5);   // true
  }
}

