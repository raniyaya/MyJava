package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // === ���� ���� ===
        System.out.println("\n=== ���� ���� ===");
        SavingsAccount sa1 = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
        CheckingAccount ca1 = bank.createCheckingAccount("��ö��", 20000, 5000);
        SavingsAccount sa2 = bank.createSavingsAccount("�̿���", 30000, 2.0);

        System.out.println();
        bank.printAllAccounts();

        // === �Ա�/��� �׽�Ʈ ===
        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit(sa1.getAccountNumber(), 5000);
            bank.withdraw(sa1.getAccountNumber(), 3000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        // === ���� ���� �׽�Ʈ ===
        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        sa1.applyInterest();

        // === ���� ��ü �׽�Ʈ ===
        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(sa2.getAccountNumber(), ca1.getAccountNumber(), 5000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println();
        bank.printAllAccounts();

        // === ���� �׽�Ʈ ===
        try {
            // ��� �ѵ� �ʰ�
            bank.withdraw(ca1.getAccountNumber(), 6000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            // �������� �ʴ� ����
            bank.withdraw("AC9999", 1000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
