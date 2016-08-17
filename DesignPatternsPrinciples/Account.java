public class Account {
  int balance;

  void deposit(final int amount) {
    // Local class to save the necessary data and to chack
    // that the transaction was valid
    class Auditor {
      // Stores the old balance
      private int balanceAtStartOfTransaction = balance;

      // Checks the postcondition
      void check() {
        assert balance - balanceAtStartOfTransaction == amount;
      }
    }
    Auditor auditor = new Auditor();  // Save the data
    balance += amount;      // Do the transaction
    auditor.check();        // Check the postcondition
  }

  public static void main(String[] args) {
    Account ac = new Account();
    ac.deposit(250);
  }
}

