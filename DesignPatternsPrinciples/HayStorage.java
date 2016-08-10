// Singleton pattern example
public class HayStorage {
  private int quantity = 0;
  private HayStorage() { }

  private static final HayStorage instance = new HayStorage();

  public static HayStorage getInstance() {
    return instance;
  }
  public synchronized void addHay(int amount) {
    quantity += amount;
  }
  public synchronized boolean removeHay(int amount) {
    if (quantity < amount) return false;
    quantity -= amount;
    return true;
  }
  public synchronized int getHayQuantity() {
    return quantity;
  }
}

// Singleton pattern with lazy initialization
class VisitorTicketTracker {
  private static VisitorTicketTracker instance;  // not final!
  private VisitorTicketTracker() { }

  public static VisitorTicketTracker getInstance() {
    // using lazy initialization
    if (instance == null) {
      instance = new VisitorTicketTracker();  // NOT THREAD-SAFE!
    }
    return instance;
  }
}

// Singleton pattern with double-checked locking
class VisitorTracker {
  private static volatile VisitorTracker instance;  // not final!
  private VisitorTracker() { }

  public static VisitorTracker getInstance() {
    // double-checked locking
    if (instance == null) {
      synchronized(VisitorTracker.class) {
        if (instance == null) {
          instance = new VisitorTicketTracker();
        }
      }
    }
    return instance;
  }
}
