package hyerim.section04.ex;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.balance = 0;

        account.deposit(10000);

        account.withdraw(9000);
        account.withdraw(2000);

        System.out.println(account.balance);

    }
}
