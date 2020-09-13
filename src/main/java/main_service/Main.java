package main_service;

import exhibition_service.*;
import gallery_service.*;
import ticket_service.TicketPack;

public final class Main {
    public static void main( String[] args ) {
        MainService mainService = new MainService();

        System.out.println("---\nGood morning and welcome to the art gallery! Let me show you around.\n" +
                "\nWait... where are the paintings?\nBringing in: ");

        mainService.addPainting(new Painting("Mona Lisa", "Leonardo da Vinci", 1503));
        mainService.addPainting(new Painting("The Birth of Venus", "Sandro Botticelli", 1485));
        mainService.addPainting(new Painting("Creation of Adam", "Michelangelo", 1508));
        mainService.addPainting(new Painting("The Starry Night", "Vincent van Gogh", 1889));
        mainService.addPainting(new Painting("The Scream", "Edvard Munch", 1893));

        System.out.println("Better!\n\nBut where is anyone? It's 8 am, the working day has started. " +
                "Ah, here they are!");

        mainService.addTicketSeller(new TicketSeller("Ronald"));
        mainService.addJanitor(new Janitor("Daniel"));
        mainService.addGuide(new Guide("Jane", 7));
        mainService.addTicketSeller(new TicketSeller("Robert"));
        mainService.addGuide(new Guide("Emily", 3));

        System.out.print("\nGreat! And while they are getting ready for the day, " +
                "let me tell you a bit more about what you are going to see. " +
                "\nToday we have unique exhibitions by 2 organisers: ");

        mainService.addOrganiser(new Organiser("Mr. Smith"));
        System.out.print(" and ");
        mainService.addOrganiser(new Organiser("Mrs. Jackson"));
        System.out.println(".");

        mainService.addTicketPack(new TicketPack(5, 20 ));
        mainService.addTicketPack(new TicketPack(5, 15));

        System.out.print("\nThe first one is a true legend. It's ");
        mainService.addExhibition(new DailyExhibition(new Exhibition("The Old Masters", 0),
                mainService.getOrganiserByName("Mr. Smith"), mainService.getTicketPackByPrice(20)));
        mainService.openExhibition("The Old Masters");

        System.out.print("\nLet's wait for a few minutes. ");
        mainService.mop(mainService.getJanitorByName("Daniel"));

        System.out.print("\nThe second exhibition is also worth attention. Take a look at ");
        mainService.addExhibition(new DailyExhibition(new Exhibition("The 19th Century Classics", 0),
                mainService.getOrganiserByName("Mrs. Jackson"), mainService.getTicketPackByPrice(15)));
        mainService.openExhibition("The 19th Century Classics");

        System.out.println("\n---\nThe visitors will start coming soon! Let's prepare headsets for them.");
        mainService.addHeadsets(8);

        System.out.println("\nLook! We see our first visitors. Here they come:");
        mainService.addVisitor(new Visitor("Rachel"));
        mainService.addVisitor(new Visitor("Viktor"));
        mainService.addVisitor(new Visitor("Claire"));

        System.out.println("\nWhat is going on at the reception?");
        mainService.ticketConsultation("Robert", "Rachel");
        mainService.talkToVisitor("Ronald", "Claire");
        System.out.println();

        mainService.sellTicket(15, "Robert", "Rachel");
        mainService.sellTicket(20,"Ronald", "Claire");
        mainService.sellTicket(20,"Robert", "Viktor");
        System.out.println();

        mainService.giveHeadset("Ronald","Claire");
        mainService.giveHeadset("Robert", "Viktor");

        System.out.println("\n---\nThe tour is getting started!");
        mainService.describePainting("Jane","Mona Lisa");
        mainService.examinePainting("Claire", "Creation of Adam");
        mainService.admirePainting("Rachel", "The Birth of Venus");
        System.out.println();

        mainService.describePainting("Emily", "The Starry Night");
        mainService.interrupt("Rachel", "Emily");
        mainService.discussPainting("Viktor", "Claire", "The Scream");
        mainService.criticizePainting("Rachel", "The Scream");

        System.out.println("\n---\nWow, such a busy day! Now it's time to close the exhibitions.");
        mainService.closeExhibition("The Old Masters");
        mainService.closeExhibition("The 19th Century Classics");

        System.out.print("\nLook! ");
        mainService.mop(mainService.getJanitorByName("Daniel"));
        mainService.mopDance(mainService.getJanitorByName("Daniel"));

        System.out.println();
        mainService.countTotalRevenue();

        System.out.println("\nWe were happy to show you around today. See you next time!\n---");
    }
}
