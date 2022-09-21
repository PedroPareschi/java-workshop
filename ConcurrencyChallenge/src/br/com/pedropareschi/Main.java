package br.com.pedropareschi;

public class Main {

        public static void main(String[] args) {
            BankAccount account = new BankAccount("12345-67", 1000);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    account.deposit(300);
                    account.withdraw(50);
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    account.deposit(203.75);
                    account.withdraw(100);
                }
            });

            thread1.start();
            thread2.start();
    }
}


