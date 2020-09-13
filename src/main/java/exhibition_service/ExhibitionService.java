package exhibition_service;

import java.util.LinkedList;

public final class ExhibitionService {
    final private LinkedList<DailyExhibition> exhibitions = new LinkedList<>();

    public void addExhibition(DailyExhibition exhibition) {
        exhibitions.add(exhibition);
    }

    public void openExhibition(String name) {
        for (DailyExhibition exhibition: exhibitions) {
            if (exhibition.getName().equals(name)){
                exhibition.openExhibition();
            }
        }
    }

    public void closeExhibition(String name) {
        for (DailyExhibition exhibition: exhibitions) {
            if (exhibition.getName().equals(name)){
                exhibition.closeExhibition();
            }
        }
    }

    public void countTotalRevenue() {
        int totalRevenue = 0;
        for (DailyExhibition exhibition: exhibitions) totalRevenue += exhibition.countRevenue();

        System.out.println("Total revenue for today is $" + totalRevenue + ". Great!");
    }
}
