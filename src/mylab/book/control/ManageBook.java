package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void main(String[] args) {
        Publication[] books = new Publication[7];

        books[0] = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
        books[1] = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
        books[2] = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
        books[3] = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
        books[4] = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");
        books[5] = new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�");
        books[6] = new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�");

        // 1. ���� ���� ���
        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }

        // 2. ���� ����
        System.out.println("\n==== ���� ���� ====");
        Publication target = books[6];
        int originalPrice = target.getPrice();
        modifyPrice(target);  // ���� ����
        int newPrice = target.getPrice();
        int diff = originalPrice - newPrice;

        System.out.println(target.getTitle() + " ���� �� ����: " + originalPrice + "��");
        System.out.println(target.getTitle() + " ���� �� ����: " + newPrice + "��");
        System.out.println("����: " + diff + "��");

        // 3. ��� �м�
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(books);
    }

    // Ÿ�Ժ��� ���� ����
    public static void modifyPrice(Publication p) {
        if (p instanceof Magazine) {
            p.setPrice((int) (p.getPrice() * 0.6));
        } else if (p instanceof Novel) {
            p.setPrice((int) (p.getPrice() * 0.8));
        } else if (p instanceof ReferenceBook) {
            p.setPrice((int) (p.getPrice() * 0.9));
        }
    }
}
