package workshop.bank.entity;

import java.util.ArrayList;
import java.util.List;

import workshop.bank.exception.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    // ���¹�ȣ ����
    private String generateAccountNumber() {
        return "AC" + (nextAccountNumber++);
    }

    // ���� ���� ����
    public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accNum = generateAccountNumber();
        SavingsAccount account = new SavingsAccount(accNum, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("Saving(����) ���°� �����Ǿ����ϴ�: " + accNum + ", ������: " + ownerName + ", �ܾ�: " + initialBalance + "��, ������: " + interestRate + "%");
        return account;
    }

    // üŷ ���� ����
    public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accNum = generateAccountNumber();
        CheckingAccount account = new CheckingAccount(accNum, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + accNum + ", ������: " + ownerName + ", �ܾ�: " + initialBalance + "��, ��� �ѵ�: " + withdrawalLimit + "��");
        return account;
    }

    // ���� ã��
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }

    // �Ա�
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    // ���
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    // ��ü
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
    }

    // ��ü ���� ���
    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account acc : accounts) {
            acc.printAccountInfo();
        }
        System.out.println("===================");
    }
}
