package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // === 계좌 생성 ===
        System.out.println("\n=== 계좌 생성 ===");
        SavingsAccount sa1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        CheckingAccount ca1 = bank.createCheckingAccount("김철수", 20000, 5000);
        SavingsAccount sa2 = bank.createSavingsAccount("이영희", 30000, 2.0);

        System.out.println();
        bank.printAllAccounts();

        // === 입금/출금 테스트 ===
        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(sa1.getAccountNumber(), 5000);
            bank.withdraw(sa1.getAccountNumber(), 3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // === 이자 적용 테스트 ===
        System.out.println("\n=== 이자 적용 테스트 ===");
        sa1.applyInterest();

        // === 계좌 이체 테스트 ===
        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(sa2.getAccountNumber(), ca1.getAccountNumber(), 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println();
        bank.printAllAccounts();

        // === 예외 테스트 ===
        try {
            // 출금 한도 초과
            bank.withdraw(ca1.getAccountNumber(), 6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            // 존재하지 않는 계좌
            bank.withdraw("AC9999", 1000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
