package ticket_service;

import java.util.LinkedList;
import java.util.UUID;

public final class TicketPack {
    final private LinkedList<Ticket> tickets = new LinkedList<>();
    final private int price;
    private int revenue;

    public TicketPack(int quantity, int price) {
        for (int i = 1; i <= quantity;) {
            tickets.add(new Ticket(UUID.randomUUID(), price));
            i += 1;
        }
        this.price = price;
        this.revenue = 0;
    }

    public void newDay() {
        revenue = 0;
    }

    public int getRevenue() {
        return revenue;
    }

    public String deleteTicket(){
        revenue += price;
        Ticket ticket = tickets.removeFirst();
        return ticket.getDescription();
    }

    public int getPrice() {
        return price;
    }
}
