package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;
import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
        }
        super.withdraw(amount);  // �θ� �޼���� InsufficientBalanceException ����
    }

    @Override
    public void printAccountInfo() {
        System.out.println("���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance + "��, ��� �ѵ�: " + withdrawalLimit + "��");
    }
}
