package main_service;

import exhibition_service.*;
import gallery_service.*;
import ticket_service.TicketPack;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public final class MainService {
    final private ExhibitionService exhibitions = new ExhibitionService();
    final private CleaningService cleaningService = new CleaningService();
    final private ReceptionService receptionService = new ReceptionService();
    final private TourService tourService = new TourService();

    final private LinkedList<Visitor> visitors = new LinkedList<>();
    final private LinkedList<Painting> paintings = new LinkedList<>();
    final private LinkedList<Guide> guides = new LinkedList<>();
    final private LinkedList<TicketSeller>  sellers = new LinkedList<>();
    final private LinkedList<Organiser> organisers = new LinkedList<>();
    final private LinkedList<TicketPack> ticketPacks = new LinkedList<>();

    public void addPainting(Painting painting) {
        System.out.println(" - " + painting);
        paintings.add(painting);
    }

    public void addJanitor(Janitor janitor) {
        System.out.println(" - Janitor " + janitor.getName());
        cleaningService.addJanitor(janitor);
    }

    public void addGuide(Guide guide) {
        System.out.println(" - Guide " + guide.getName());
        guides.add(guide);
    }

    public void addTicketSeller(TicketSeller seller) {
        System.out.println(" - Ticket seller " + seller.getName());
        sellers.add(seller);
    }

    public void addOrganiser(Organiser organiser) {
        System.out.print(organiser.getName());
        organisers.add(organiser);
    }

    public Organiser getOrganiserByName(String name) {
        for (Organiser organiser: organisers)
            if (organiser.getName().equals(name)) return organiser;

        return null;
    }

    public void addTicketPack(TicketPack ticketPack) {
        ticketPacks.add(ticketPack);
    }

    public TicketPack getTicketPackByPrice(int price) {
        for (TicketPack ticketPack: ticketPacks)
            if (ticketPack.getPrice() == price) return ticketPack;

        return null;
    }

    public void addExhibition(DailyExhibition exhibition) {
        System.out.println("'" + exhibition.getName() + "' organised by " + exhibition.getOrganiser() + ".");
        exhibitions.addExhibition(exhibition);
    }

    public void openExhibition(String name) {
        exhibitions.openExhibition(name);
    }

    public Janitor getJanitorByName(String name) {
        return cleaningService.getJanitorByName(name);
    }

    public void mop(Janitor janitor) {
        cleaningService.mop(janitor);
    }

    public void mopDance(Janitor janitor) {
        cleaningService.mopDance(janitor);
    }

    public void addHeadsets(int quantity) {
        Random random = new Random();
        System.out.println("Taking " + quantity + " headsets from the closet.");

        for (int i = 1; i < quantity;) {
            Headset headset = new Headset(random.nextBoolean(), UUID.randomUUID());
            receptionService.addHeadset(headset);
            i += 1;
        }
    }

    public void addVisitor(Visitor visitor) {
        System.out.println(" - " + visitor.getName());
        visitors.add(visitor);
    }

    public Visitor getVisitorByName(String name) {
        for (Visitor visitor: visitors)
            if (visitor.getName().equals(name)) return visitor;

        return null;
    }

    public TicketSeller getTicketSellerByName(String name) {
        for (TicketSeller seller: sellers)
            if (seller.getName().equals(name)) return seller;

        return null;
    }

    public Guide getGuideByName(String name) {
        for (Guide guide: guides)
            if (guide.getName().equals(name)) return guide;

        return null;
    }

    public Painting getPaintingByName(String name) {
        for (Painting painting: paintings)
            if (painting.getName().equals(name)) return painting;

        return null;
    }

    public void ticketConsultation(String sellerName,
                                   String visitorName) {

        receptionService.ticketConsultation(Objects.requireNonNull(getTicketSellerByName(sellerName)),
                Objects.requireNonNull(getVisitorByName(visitorName)));
    }

    public void talkToVisitor(String sellerName,
                              String visitorName) {

        receptionService.talkToVisitor(Objects.requireNonNull(getTicketSellerByName(sellerName)),
                Objects.requireNonNull(getVisitorByName(visitorName)));
    }

    public void sellTicket(int price,
                           String sellerName,
                           String visitorName) {

        receptionService.sellTicket(Objects.requireNonNull(getTicketPackByPrice(price)),
                Objects.requireNonNull(getTicketSellerByName(sellerName)),
                Objects.requireNonNull(getVisitorByName(visitorName)));
    }

    public void giveHeadset(String sellerName,
                            String visitorName) {

        receptionService.giveHeadset(Objects.requireNonNull(getTicketSellerByName(sellerName)),
                Objects.requireNonNull(getVisitorByName(visitorName)));
    }

    public void describePainting(String guideName,
                                 String paintingName) {

        tourService.describePainting(Objects.requireNonNull(getGuideByName(guideName)),
                getPaintingByName(paintingName));
    }

    public void examinePainting(String visitorName,
                                String paintingName) {

        tourService.examinePainting(Objects.requireNonNull(getVisitorByName(visitorName)),
                Objects.requireNonNull(getPaintingByName(paintingName)));
    }

    public void admirePainting(String visitorName,
                               String paintingName) {

        tourService.admirePainting(Objects.requireNonNull(getVisitorByName(visitorName)),
                Objects.requireNonNull(getPaintingByName(paintingName)));
    }

    public void discussPainting(String visitor1Name,
                                String visitor2Name,
                                String paintingName) {

        tourService.discussPainting(Objects.requireNonNull(getVisitorByName(visitor1Name)),
                Objects.requireNonNull(getVisitorByName(visitor2Name)),
                Objects.requireNonNull(getPaintingByName(paintingName)));
    }

    public void interrupt(String visitorName,
                          String guideName) {

        tourService.interrupt(Objects.requireNonNull(getVisitorByName(visitorName)),
                Objects.requireNonNull(getGuideByName(guideName)));
    }

    public void criticizePainting(String visitorName,
                                  String paintingName) {

        tourService.criticizePainting(Objects.requireNonNull(getVisitorByName(visitorName)),
                Objects.requireNonNull(getPaintingByName(paintingName)));
    }

    public void closeExhibition(String name) {
        exhibitions.closeExhibition(name);
    }

    public void countTotalRevenue() {
        exhibitions.countTotalRevenue();
    }
}
