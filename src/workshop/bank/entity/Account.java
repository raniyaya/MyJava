package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
        }
        balance -= amount;
        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    public abstract void printAccountInfo(); // �� ���º� ���� ���
}