package gallery_service;

import ticket_service.TicketPack;

import java.util.LinkedList;

public final class ReceptionService {
    final private LinkedList<Headset> headsets = new LinkedList<>();

    public void addHeadset(Headset headset) { headsets.add(headset); }

    public void ticketConsultation(TicketSeller seller,
                                   Visitor visitor) {

        System.out.println("Ticket seller " + seller.getName() + " is giving " +
                visitor.getName() + " a consultation on the ticket types.");
    }

    public void sellTicket(TicketPack tickets,
                           TicketSeller seller,
                           Visitor visitor){

        String ticketDescription = tickets.deleteTicket();

        System.out.println(ticketDescription + " is sold to " + visitor.getName() + " by " + seller.getName() + ".");
    }

    public void giveHeadset(TicketSeller seller,
                            Visitor visitor){

        Headset headset = headsets.removeFirst();

        System.out.println(seller.getName() + " gives headset #" + headset.getId() + " to " + visitor.getName() + ".");

        if (headset.isBroken()) {
            System.out.println("Headset #" + headset.getId() + " is broken!");
            returnHeadset(headset, visitor);
        }
    }

    public void returnHeadset(Headset headset,
                              Visitor visitor){

        headsets.add(headset);

        System.out.println(visitor.getName() + " returns headset #" + headset.getId() +
                " and wonders about the service quality.");
    }

    public void talkToVisitor(TicketSeller seller,
                              Visitor visitor){

        System.out.println(
                "\"Yes, the weather is nice today. No, it's not my first time in town.\" Small talk between "
                + seller.getName() + " and " + visitor.getName()
                + " is starting to be boring.");
    }
}
