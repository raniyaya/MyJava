package workshop.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("���� " + interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void printAccountInfo() {
        System.out.println("���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance + "��, ������: " + interestRate + "%");
    }
}
