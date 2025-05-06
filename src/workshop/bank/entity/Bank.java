package workshop.bank.entity;

import java.util.ArrayList;
import java.util.List;

import workshop.bank.exception.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    // 계좌번호 생성
    private String generateAccountNumber() {
        return "AC" + (nextAccountNumber++);
    }

    // 저축 계좌 생성
    public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accNum = generateAccountNumber();
        SavingsAccount account = new SavingsAccount(accNum, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + accNum + ", 소유자: " + ownerName + ", 잔액: " + initialBalance + "원, 이자율: " + interestRate + "%");
        return account;
    }

    // 체킹 계좌 생성
    public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accNum = generateAccountNumber();
        CheckingAccount account = new CheckingAccount(accNum, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + accNum + ", 소유자: " + ownerName + ", 잔액: " + initialBalance + "원, 출금 한도: " + withdrawalLimit + "원");
        return account;
    }

    // 계좌 찾기
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
    }

    // 입금
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    // 출금
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    // 이체
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }

    // 전체 계좌 출력
    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            acc.printAccountInfo();
        }
        System.out.println("===================");
    }
}
