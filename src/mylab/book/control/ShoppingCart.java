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

    // 장바구니에 항목 추가
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + " 항목이 추가되었습니다.");
    }

    // 장바구니에서 제목으로 항목 제거
    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println(title + " 항목이 제거되었습니다.");
                return true;
            }
        }
        System.out.println(title + " 항목을 찾을 수 없습니다.");
        return false;
    }

    // 장바구니 출력
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###원");
        System.out.println("\n==== 장바구니 목록 ====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()));
        System.out.println("할인가격: " + df.format(calculateDiscountedPrice()));
    }

    // 총 가격 계산
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // 할인 가격 계산
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

    // 통계 출력
    public void printStatistics() {
        int novelCount = 0, magazineCount = 0, refCount = 0;
        for (Publication item : items) {
            if (item instanceof Novel) novelCount++;
            else if (item instanceof Magazine) magazineCount++;
            else if (item instanceof ReferenceBook) refCount++;
        }
        int total = items.size();
        System.out.println("\n===== 출판물 통계 =====");
        System.out.printf("소설: %.2f%%\n", 100.0 * novelCount / total);
        System.out.printf("잡지: %.2f%%\n", 100.0 * magazineCount / total);
        System.out.printf("참고서: %.2f%%\n", 100.0 * refCount / total);
    }

    public List<Publication> getItems() {
        return items;
    }
}
