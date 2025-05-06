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
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        super.withdraw(amount);  // 부모 메서드는 InsufficientBalanceException 던짐
    }

    @Override
    public void printAccountInfo() {
        System.out.println("계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원, 출금 한도: " + withdrawalLimit + "원");
    }
}
