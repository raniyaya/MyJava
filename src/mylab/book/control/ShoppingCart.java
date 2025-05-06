package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // ��ٱ��Ͽ� �׸� �߰�
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + " �׸��� �߰��Ǿ����ϴ�.");
    }

    // ��ٱ��Ͽ��� �������� �׸� ����
    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println(title + " �׸��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println(title + " �׸��� ã�� �� �����ϴ�.");
        return false;
    }

    // ��ٱ��� ���
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###��");
        System.out.println("\n==== ��ٱ��� ��� ====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("�� ����: " + df.format(calculateTotalPrice()));
        System.out.println("���ΰ���: " + df.format(calculateDiscountedPrice()));
    }

    // �� ���� ���
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // ���� ���� ���
    public int calculateDiscountedPrice() {
        double total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;
            } else {
                total += item.getPrice();
            }
        }
        return (int) total;
    }

    // ��� ���
    public void printStatistics() {
        int novelCount = 0, magazineCount = 0, refCount = 0;
        for (Publication item : items) {
            if (item instanceof Novel) novelCount++;
            else if (item instanceof Magazine) magazineCount++;
            else if (item instanceof ReferenceBook) refCount++;
        }
        int total = items.size();
        System.out.println("\n===== ���ǹ� ��� =====");
        System.out.printf("�Ҽ�: %.2f%%\n", 100.0 * novelCount / total);
        System.out.printf("����: %.2f%%\n", 100.0 * magazineCount / total);
        System.out.printf("����: %.2f%%\n", 100.0 * refCount / total);
    }

    public List<Publication> getItems() {
        return items;
    }
}
