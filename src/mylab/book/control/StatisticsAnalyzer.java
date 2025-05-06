package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    // 출판물 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String type : sumMap.keySet()) {
            avgMap.put(type, sumMap.get(type) / (double) countMap.get(type));
        }

        return avgMap;
    }

    // 출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCount = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (String type : typeCount.keySet()) {
            distribution.put(type, (typeCount.get(type) * 100.0) / total);
        }

        return distribution;
    }

    // 특정 연도 출판 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (count * 100.0) / publications.length;
    }

    // 타입 판별 헬퍼
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    // 전체 통계 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("===== 출판물 통계 분석 =====");

        // 1. 타입별 평균 가격
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for (String type : avgPrice.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrice.get(type)) + "원");
        }

        // 2. 출판물 유형 분포
        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.printf("   - %s: %.2f%%\n", type, distribution.get(type));
        }

        // 3. 2007년 출판물 비율
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " +
                String.format("%.2f%%", calculatePublicationRatioByYear(publications, "2007")));

        System.out.println("=============================\n");
    }
}
