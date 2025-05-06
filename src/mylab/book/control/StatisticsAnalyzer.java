package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    // ���ǹ� Ÿ�Ժ� ��� ���� ���
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

    // ���ǹ� ���� ���� ���
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

    // Ư�� ���� ���� ���� ���
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (count * 100.0) / publications.length;
    }

    // Ÿ�� �Ǻ� ����
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    // ��ü ��� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("===== ���ǹ� ��� �м� =====");

        // 1. Ÿ�Ժ� ��� ����
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for (String type : avgPrice.keySet()) {
            System.out.println("   - " + type + ": " + df.format(avgPrice.get(type)) + "��");
        }

        // 2. ���ǹ� ���� ����
        System.out.println("\n2. ���ǹ� ���� ����:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.printf("   - %s: %.2f%%\n", type, distribution.get(type));
        }

        // 3. 2007�� ���ǹ� ����
        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " +
                String.format("%.2f%%", calculatePublicationRatioByYear(publications, "2007")));

        System.out.println("=============================\n");
    }
}
