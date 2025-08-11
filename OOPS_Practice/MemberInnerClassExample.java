//member inner class
//accesses instance members of the outer class directly

class Bank {
    private String bankName = "Global Bank";

    class Account {
        private String accountHolder;

        public Account(String name) {
            this.accountHolder = name;
        }

        public void showDetails() {
            System.out.println("Bank: "+bankName+", Account Holder: "+accountHolder);
        }
    }
}

public class MemberInnerClassExample {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Bank.Account account = bank.new Account("Swayam");
        account.showDetails();
    }
}
