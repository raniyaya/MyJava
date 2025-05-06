package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void main(String[] args) {
        Publication[] books = new Publication[7];

        books[0] = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
        books[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
        books[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
        books[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
        books[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");
        books[5] = new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설");
        books[6] = new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설");

        // 1. 도서 정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }

        // 2. 가격 변경
        System.out.println("\n==== 가격 변경 ====");
        Publication target = books[6];
        int originalPrice = target.getPrice();
        modifyPrice(target);  // 할인 적용
        int newPrice = target.getPrice();
        int diff = originalPrice - newPrice;

        System.out.println(target.getTitle() + " 변경 전 가격: " + originalPrice + "원");
        System.out.println(target.getTitle() + " 변경 후 가격: " + newPrice + "원");
        System.out.println("차액: " + diff + "원");

        // 3. 통계 분석
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(books);
    }

    // 타입별로 가격 할인
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
