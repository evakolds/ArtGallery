package exhibition_service;

import ticket_service.TicketPack;

public final class DailyExhibition {
    private final Exhibition exhibition;
    private final Organiser organiser;
    private final TicketPack tickets;

    public DailyExhibition(Exhibition exhibition,
                           Organiser organiser,
                           TicketPack tickets) {

        this.exhibition = exhibition;
        this.organiser = organiser;
        this.tickets = tickets;
    }

    public String getName() {
        return exhibition.getName();
    }

    public String getOrganiser() {
        return organiser.getName();
    }

    public void openExhibition() {
        exhibition.open();
        tickets.newDay();

        System.out.println(organiser.getName() + " is cutting the red rope... " +
                "Exhibition '" + exhibition.getName() + "' is now officially open! Welcome!");
    }

    public void closeExhibition() {
        exhibition.close();

        System.out.println("Exhibition " + exhibition.getName() +
                " is closed for today.");
    }

    public int countRevenue() {
        int revenue = tickets.getRevenue();

        System.out.println(organiser.getName() + " is calculating their revenue... Wow, it's $" +
                revenue + "! Good day!");

        return revenue;
    }
}
